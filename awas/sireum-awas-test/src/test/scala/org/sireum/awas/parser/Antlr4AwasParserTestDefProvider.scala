/*
Copyright (c) 2015, Robby, Kansas State University
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:

1. Redistributions of source code must retain the above copyright notice, this
   list of conditions and the following disclaimer.
2. Redistributions in binary form must reproduce the above copyright notice,
   this list of conditions and the following disclaimer in the documentation
   and/or other materials provided with the distribution.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

package org.sireum.awas.parser

import org.sireum.awas.ast.Builder
import org.sireum.test._
import org.sireum.util._

final class Antlr4AwasParserTestDefProvider(tf: TestFramework)
  extends TestDefProvider {

  override def testDefs: ISeq[TestDef] = ivector(
    ConditionTest("properties", parsePass(
      """
        |types
        |
        |  lattice Top
        |
        |  lattice Left extends Top
        |
        |  lattice Right extends Top
        |
        |  lattice Bottom extends Left, Right
        |
        |  enum Error
        |
        |  enum Failure { AFail, BFail, CFail }
        |
        |  record R
        |    x: Integer
        |    y: Integer
        |
        |components
        |  A
        |    ports
        |      in aIn
        |      out aOut
        |    properties
        |      b0: Boolean
        |      b3: Boolean = true
        |      b4: Boolean = false
        |      x: Integer
        |      z: Integer = 5
        |      r0: Real
        |      r1: Real = 0.0
        |      s0: String
        |      s1: String = "bar"
        |      lat0: Top
        |      lat1: Top = Left
        |      enum0: Failure
        |      enum1: Failure = BFail
        |      enum2: Error = Disconnected // checked with profile
        |      rec0: R
        |      rec2: R = R(x=1, y=2)
        |      set0: Set[Integer]
        |      set1: Set[Integer] = Set[Integer](1, 2, 3)
        |      seq0: Seq[Integer]
        |      seq1: Seq[Integer] = Seq[Integer](1, 2, 3)
        |      map0: Map[Integer, Integer]
        |      map1: Map[Integer, Integer] =
        |          Map[Integer, Integer](1 -> 2, 2 -> 3, 3 -> 4)
      """.stripMargin))
    ,
    ConditionTest("abcloop", parsePass(
      """
        |/*
        |
        |      ┌──── A ────┐       ┌──── B ────┐
        |      │           │       │           │
        |  ┌───▷aIn    aOut▷───────▷bIn    bOut▷──┐
        |  │   │           │       │           │  │
        |  │   └───────────┘       └───────────┘  │
        |  │                                      │
        |  │                                      │
        |  │             ┌──── C ────┐            │
        |  │             │           │            │
        |  └─────────────◁cOut    cIn◁────────────┘
        |                │           │
        |                └───────────┘
        |
        |*/
        |
        |components
        |  A
        |    ports
        |      in aIn
        |      out aOut
        |
        |  B
        |    ports
        |      in bIn
        |      out bOut
        |
        |  C
        |    ports
        |      in cIn
        |      out cOut
        |
        |connections
        |  A2B: A.aOut -> B.bIn
        |  B2C: B.bOut -> C.cIn
        |  C2A: C.cOut -> A.aIn
      """.stripMargin))
    ,
    ConditionTest("PcaShutoff", parsePass(
      """
        |// from https://github.com/santoslab/aadl-map-apps/tree/develop/pca-shutoff
        |
        |types
        |
        |  alias Natural = Integer (0, _)
        |
        |
        |  // from ErrorLibrary ?
        |
        |  lattice ErrorType
        |
        |  lattice ItemCommission extends ErrorType
        |
        |  lattice ServiceError extends ErrorType
        |
        |  lattice SequenceOmission extends ErrorType
        |
        |  lattice ItemOmission extends ErrorType
        |
        |  lattice LateDelivery extends ErrorType
        |
        |  lattice OutOfRange extends ErrorType
        |
        |  lattice LateDate extends ErrorType
        |
        |
        |  // from https://github.com/santoslab/aadl-map-apps/blob/develop/map-globals/packages/MAP_Errors.aadl
        |
        |  lattice ControlInputWrong extends ItemCommission
        |
        |  lattice ControlInputMissing extends ItemOmission
        |
        |  lattice IncorrectlyBuiltControlAlgorithm extends ServiceError
        |
        |	 lattice OutdatedControlAlgorithm extends ServiceError
        |
        |	 lattice IncorrectlyModifiedControlAlgorithm extends ServiceError
        |
        |	 lattice ProcessModelInconsistent extends ServiceError
        |
        |  lattice ProcessModelIncomplete extends ServiceError
        |
        |  lattice ProcessModelIncorrect extends ServiceError
        |
        |  lattice InappropriateControlAction extends SequenceCommission
        |
        |	 lattice IneffectiveControlAction extends ServiceError
        |
        |  lattice MissingControlAction extends ItemOmission
        |
        |  lattice InadequateActuatorOperation extends ServiceError
        |
        |  lattice DelayedOperation extends LateDelivery
        |
        |  lattice ComponentFailure extends ErrorType
        |
        |	 lattice ChangesOverTime extends ErrorType
        |
        |  lattice ConflictingControlActionsFromExternalController extends SequenceCommission
        |
        |  lattice ProcessInputMissing extends ItemOmission
        |
        |	 lattice ProcessInputWrong extends ItemCommission
        |
        |	 lattice UnidentifiedDisturbance extends ItemCommission
        |
        |	 lattice OutOfRangeDisturbance extends OutOfRange
        |
        |  lattice ProcessOutputContributesToSystemHazard extends ErrorType
        |
        |  lattice FeedbackDelayedFromProcess extends LateData
        |
        |	 lattice MesasurementInaccurate extends ServiceCommission
        |
        |	 lattice IncorrectInformationProvided extends ItemCommission
        |
        |	 lattice NoInformationProvided extends ItemOmission
        |
        |  lattice InadequateSensorOperation extends ServiceError
        |
        |  lattice FeedbackDelayedFromSensor extends LateData
        |
        |  lattice InadequateFeedback extends ItemCommission
        |
        |  lattice MissingFeedback extends ItemOmission
        |
        |
        |  // from https://github.com/santoslab/aadl-map-apps/blob/develop/map-globals/propertysets/MAP_Properties.aadl
        |
        |  enum ProcessKind { Logic, Display }
        |
        |  enum ComponentKind { Top, Actuator, Sensor, Controller, ControlledProcess }
        |
        |
        |  // from https://github.com/santoslab/aadl-map-apps/blob/develop/map-globals/propertysets/MAP_Error_Properties.aadl
        |
        |  alias Context = String
        |
        |  alias Assumption = String
        |
        |  record Abbreviation
        |    full: String
        |    definition: String
        |
        |  record AccidentLevel
        |    level: Natural
        |    description: String
        |
        |  record Accident
        |    number: Natural
        |    description: String
        |    level: AccidentLevel
        |
        |  record Hazard
        |    number: Natural
        |    description: String
        |    accident: Accident
        |
        |  record Constraint
        |    description: String
        |    hazard: Hazard
        |
        |  // Q: Sam, why are all these enum elements grouped into one enum type?
        |  enum KindsType {
        |    NotProviding, Providing, Early, Late, AppliedTooLong, StoppedTooSon,
        |
        |    ValueLow, ValueHigh,
        |
        |    ParamsMissing, ParamsWrong, ParamsOutOfOrder
        |  }
        |
        |  alias RelevantStates = Accident
        |
        |  record ProtoHazard
        |    harm: Accident
        |    componentState: PumpAction // type refined for PCA Shutoff
        |    environmentState: PatientStatus // type refined for PCA Shutoff
        |    interactionPoints: Seq[Port]
        |
        |  record OccurenceCause
        |    errorType: ErrorType
        |    description: String
        |
        |  record Occurrence
        |    kind: KindsType
        |    hazard: Hazard
        |    violatedConstraint: Constraint
        |    title: String
        |    cause: OccurrenceCause
        |    compensation: String
        |
        |
        |  // https://github.com/santoslab/aadl-map-apps/blob/develop/pca-shutoff/packages/PCA_Shutoff_Errors.aadl
        |
        |  lattice InadvertentPumpNormally extends InappropriateControlAction
        |
        |	 lattice SpO2ValueHigh extends InadequateSensorOperation
        |
        |	 lattice SpO2ValueLow extends InadequateSensorOperation
        |
        |	 lattice ETCO2ValueLow extends InadequateSensorOperation
        |
        |	 lattice ETCO2ValueHigh extends InadequateSensorOperation
        |
        |	 lattice RespiratoryRateLow extends InadequateSensorOperation
        |
        |	 lattice RespiratoryRateHigh extends InadequateSensorOperation
        |
        |	 lattice DeviceAlarmFailsOn extends InadequateSensorOperation
        |
        |	 lattice DeviceAlarmFailsOff extends InadequateSensorOperation
        |
        |  enum PatientStatus { Healthy, Risk, Overdose }
        |
        |  enum PumpAction { PumpNormal, PumpMinimal }
        |
        |constants
        |
        |  // from https://github.com/santoslab/aadl-map-apps/blob/develop/pca-shutoff/propertysets/PCA_Shutoff_Error_Properties.aadl
        |
        |  Context: Context = "Example context"
        |
        |	 NoAlarms: Assumption = "There are no alarms that need forwarding"
        |
        |	 SpO2: Abbreviation = Abbreviation(full = "Blood-oxygen Saturation",
        |		                                 definition = "The oxygenation of the patient's blood")
        |
        |	 Death: AccidentLevel = AccidentLevel(level = 1,
        |		                                    description = "Results in the death of a human")
        |
        |	 PatientDeath: Accident = Accident(description = "Patient is killed ",
        |		                                 level = Death)
        |
        |	 InadvertentPumpNormally: Hazard = Hazard(description = "The pump is ordered to run normally when it should not.",
        |		                                        accident = PatientDeath)
        |
        |	 BadInfoGiven: Hazard = Hazard(description = "Incorrect information is sent to the display.",
        |		                             accident = PatientDeath)
        |
        |	 DontLetPumpRunWhenUnsafe: Constraint = Constraint(description = "The app must command the pump to stop if the patient’s vital signs indicate over-infusion.",
        |		                                                 hazard = InadvertentPumpNormally)
        |
        |  DisplayMustShowPatientStatus: Constraint = Constraint(description = "The app must correctly inform the display of the status of the patient’s vital signs.",
        |		                                                     hazard = PCA_Shutoff_Error_Properties::BadInfoGiven)
        |
        |	 DisplayMustShowPumpStatus: Constraint = Constraint(description = "The app must correctly inform the display of the pump command status.",
        |                                                     hazard = BadInfoGiven)
      """.stripMargin))
    /* , TODO: nested component
    ConditionTest("abNested", parsePass(
      """
        |/*
        |
        |   ┌───────────────────── AB ──────────────────────┐
        |   │                                               │
        |   │                                               │
        |   │      ┌──── A ────┐       ┌──── B ────┐        │
        |   │abIn  │           │       │           │   abOut│
        |   ▷──────▷aIn    aOut▷───────▷bIn    bOut▷────────▷
        |   │      │           │       │           │        │
        |   │      └───────────┘       └───────────┘        │
        |   │                                               │
        |   │                                               │
        |   └───────────────────────────────────────────────┘
        |
        |*/
        |
        |component AB
        |  ports
        |    in abIn
        |    out abOut
        |
        |enclosure AB
        |
        |component A
        |  ports
        |    in aIn
        |    out aOut
        |
        |component B
        |  ports
        |    in bIn
        |    out bOut
        |
        |connection AB -> A
        |connection A -> B
        |connection B -> AB
      """.stripMargin))
    ,
    ConditionTest("abNestedSeparateAssembly", parsePass(
      """
        |/*
        |
        |   ┌────────────────── sup::AB ────────────────────┐
        |   │                                               │
        |   │                                               │
        |   │      ┌─ sub::A ──┐       ┌─ sub::B ──┐        │
        |   │abIn  │           │       │           │   abOut│
        |   ▷──────▷aIn    aOut▷───────▷bIn    bOut▷────────▷
        |   │      │           │       │           │        │
        |   │      └───────────┘       └───────────┘        │
        |   │                                               │
        |   │                                               │
        |   └───────────────────────────────────────────────┘
        |
        |*/
        |
        |namespace sub
        |
        |enclosure MyEnclosure
        |  ports
        |    in enclosureIn
        |    out enclosureOut
        |
        |component A
        |  ports
        |    in aIn
        |    out aOut
        |
        |component B
        |  ports
        |    in bIn
        |    out bOut
        |
        |connection MyEnclosure -> A
        |connection A -> B
        |connection B -> MyEnclosure
        |
        |namespace sup
        |
        |component AB
        |  ports
        |    in abIn
        |    out abOut
        |
        |assembly AB for sub::MyEnclosure
        |  ports
        |    abIn as enclosureIn
        |    abOut as enclosureOut
      """.stripMargin))
     */
  )

  def parsePass(input: String): Boolean = {
    Builder(input).isDefined
  }
}
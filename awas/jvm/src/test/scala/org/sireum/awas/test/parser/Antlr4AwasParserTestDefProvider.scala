/*
 Copyright (c) 2016, Robby, Kansas State University
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

package org.sireum.awas.test.parser

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
    ConditionTest("Isolette_model", parsePass(
      """
        |components
        |  Thermostat
        |    ports
        |      out heater_ctrl
        |      in settings
        |      in sensed_temp
        |      out feedback
        |  HeatSource
        |    ports
        |      in on_heater
        |      out heater_output
        |  Air
        |    ports
        |      in from_heater
        |      out to_infant
        |      in from_infant
        |      out to_sensor
        |  TempSensor
        |    ports
        |      in air_heat
        |      out air_temp
        |  OperatorInterface
        |    ports
        |      in feedback_in
        |      out feedback_out
        |      in settings_in
        |      out settings_out
        |  Infant
        |    ports
        |      in heat_in
        |      out heat_out
        |  Nurse
        |    ports
        |      out set_params
        |      in monitor
        |connections
        |  t1: Thermostat.heater_ctrl -> HeatSource.on_heater
        |  h1: HeatSource.heater_output -> Air.from_heater
        |  h2: Air.to_sensor -> TempSensor.air_heat
        |  t2: TempSensor.air_temp -> Thermostat.sensed_temp
        |  i1: Air.to_infant -> Infant.heat_in
        |  i2: Infant.heat_out -> Air.from_infant
        |  o1: OperatorInterface.settings_out -> Thermostat.settings
        |  o2: Thermostat.feedback -> OperatorInterface.feedback_in
        |  o3: OperatorInterface.feedback_out -> Nurse.monitor
        |  o4: Nurse.set_params -> OperatorInterface.settings_in
      """.stripMargin
    )),
    ConditionTest("AccidentLevel_Annex_D_14971", parsePass(
      """
        |types
        |  record AccidentLevel
        |    level: Natural
        |    description: String
        |constants
        |  Catastrophic: AccidentLevel = AccidentLevel(level = 1, description = "Results in infants death")
        |  Critical: AccidentLevel = AccidentLevel(level = 2, description = "Results in permanent impairment or life-threatening injury")
        |  Serious: AccidentLevel = AccidentLevel(level = 3, description = "Results in injury or impairment requiring professional medical intervention")
        |  Minor: AccidentLevel = AccidentLevel(level = 4, description = "Results in temporary injurt or impairment not requiring professional medical intervention")
        |  Negligible: AccidentLevel = AccidentLevel(level = 5, description = "Inconvenience or temporary discomfort")
      """.stripMargin
    ))
    , ConditionTest("Isolette_Accident", parsePass(
      """
        |types
        |  record Accident
        |    description: String
        |    level: AccidentLevel
        |
        |constants
        |  Serious_injury: Accident = Accident(description = "Prolonged exposure of Infant to unsafe heat leads to serious injury or death", level = Catastrophic)
        |  Short_term: Accident = Accident(description = "Burst(Shorten) exposure of Infant to unsafe heat causes skin burns / skin damages", level = Critical)
        |  unsafe_cold: Accident = Accident(description = "Exposure of Infant to unsafe cold", level = Catastrophic)

      """.stripMargin
    ))
    ,
    ConditionTest("PcaShutoff", parsePass(
      """
        |// from https://github.com/santoslab/aadl-map-apps/tree/develop/pca-shutoff
        |
        |types
        |
        |  alias Natural = Integer (0, _)
        |
        |  enum States
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
        |  lattice OutdatedControlAlgorithm extends ServiceError
        |
        |  lattice IncorrectlyModifiedControlAlgorithm extends ServiceError
        |
        |  lattice ProcessModelInconsistent extends ServiceError
        |
        |  lattice ProcessModelIncomplete extends ServiceError
        |
        |  lattice ProcessModelIncorrect extends ServiceError
        |
        |  lattice InappropriateControlAction extends SequenceCommission
        |
        |  lattice IneffectiveControlAction extends ServiceError
        |
        |  lattice MissingControlAction extends ItemOmission
        |
        |  lattice InadequateActuatorOperation extends ServiceError
        |
        |  lattice DelayedOperation extends LateDelivery
        |
        |  lattice ComponentFailure extends ErrorType
        |
        |  lattice ChangesOverTime extends ErrorType
        |
        |  lattice ConflictingControlActionsFromExternalController extends SequenceCommission
        |
        |  lattice ProcessInputMissing extends ItemOmission
        |
        |  lattice ProcessInputWrong extends ItemCommission
        |
        |  lattice UnidentifiedDisturbance extends ItemCommission
        |
        |  lattice OutOfRangeDisturbance extends OutOfRange
        |
        |  lattice ProcessOutputContributesToSystemHazard extends ErrorType
        |
        |  lattice FeedbackDelayedFromProcess extends LateData
        |
        |  lattice MesasurementInaccurate extends ServiceCommission
        |
        |  lattice IncorrectInformationProvided extends ItemCommission
        |
        |  lattice NoInformationProvided extends ItemOmission
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
        |  // Q.1: why are all these enum elements grouped into one enum type?
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
        |    componentState: States
        |    environmentState: States
        |    interactionPoints: Seq[Port]
        |
        |  record OccurrenceCause
        |    errorType: Option[ErrorType]
        |    description: String
        |
        |  record Occurrence
        |    kind: KindsType
        |    violatedConstraint: Option[Constraint]
        |    title: String
        |    cause: OccurrenceCause
        |    compensation: String
        |
        |
        |  // https://github.com/santoslab/aadl-map-apps/blob/develop/pca-shutoff/packages/PCA_Shutoff_Errors.aadl
        |
        |  lattice InadvertentPumpNormally extends InappropriateControlAction
        |
        |  lattice SpO2Value extends InadequateSensorOperation // inserted to group sub lattice elements related to SpO2Value
        |
        |  lattice SpO2ValueHigh extends SpO2Value
        |
        |  lattice SpO2ValueLow extends SpO2Value
        |
        |  lattice ETCO2Value extends InadequateSensorOperation // inserted to group sub lattice elements related to ETCO2Value
        |
        |  lattice ETCO2ValueLow extends ETCO2Value
        |
        |  lattice ETCO2ValueHigh extends ETCO2Value
        |
        |  lattice RespiratoryRate extends InadequateSensorOperation // inserted to group sub lattice elements related to RespiratoryRate
        |
        |  lattice RespiratoryRateLow extends RespiratoryRate
        |
        |  lattice RespiratoryRateHigh extends RespiratoryRate
        |
        |  lattice DeviceAlarmFailsStatus extends InadequateSensorOperation // inserted to group sub lattice elements related to DeviceAlarm
        |
        |  lattice DeviceAlarmFailsOn extends DeviceAlarmFailsStatus
        |
        |  lattice DeviceAlarmFailsOff extends DeviceAlarmFailsStatus
        |
        |  enum PatientStatus extends States { Healthy, Risk, Overdose }
        |
        |  enum PumpAction extends States { PumpNormal, PumpMinimal }
        |
        |
        |constants
        |
        |  // from https://github.com/santoslab/aadl-map-apps/blob/develop/pca-shutoff/propertysets/PCA_Shutoff_Error_Properties.aadl
        |
        |  Context: Context = "Example context"
        |
        |  NoAlarms: Assumption = "There are no alarms that need forwarding"
        |
        |  SpO2: Abbreviation = Abbreviation(full = "Blood-oxygen Saturation",
        |                                    definition = "The oxygenation of the patient's blood")
        |
        |  Death: AccidentLevel = AccidentLevel(level = 1,
        |                                       description = "Results in the death of a human")
        |
        |  PatientDeath: Accident = Accident(description = "Patient is killed ",
        |                                    level = Death)
        |
        |  InadvertentPumpNormally: Hazard = Hazard(description = "The pump is ordered to run normally when it should not.",
        |                                           accident = PatientDeath)
        |
        |  BadInfoGiven: Hazard = Hazard(description = "Incorrect information is sent to the display.",
        |                                accident = PatientDeath)
        |
        |  DontLetPumpRunWhenUnsafe: Constraint = Constraint(description = "The app must command the pump to stop if the patient’s vital signs indicate over-infusion.",
        |                                                    hazard = InadvertentPumpNormally)
        |
        |  DisplayMustShowPatientStatus: Constraint = Constraint(description = "The app must correctly inform the display of the status of the patient’s vital signs.",
        |                                                        hazard = PCA_Shutoff_Error_Properties::BadInfoGiven)
        |
        |  DisplayMustShowPumpStatus: Constraint = Constraint(description = "The app must correctly inform the display of the pump command status.",
        |                                                     hazard = BadInfoGiven)
        |
        |
        |components
        |
        |  // from https://github.com/santoslab/aadl-map-apps/blob/develop/pca-shutoff/packages/Capnograph_Interface.aadl
        |
        |  Capnograph
        |    ports
        |      out ETCO2: ETCO2ValueHigh
        |      out RespiratoryRate: RespiratoryRate
        |      out DeviceError: DeviceAlarmFailsStatus
        |    flows
        |      ETCO2UnDetectableHighValueFlowSource: _ -> ETCO2{ETCO2ValueHigh}
        |      RRUnDetectableHighValueFlowSource: _ -> RespiratoryRate{RespiratoryRateHigh}
        |      RRUnDetectableLowValueFlowSource: _ -> RespiratoryRate{RespiratoryRateLow}
        |      DeviceAlarmNotSent: _ -> DeviceError{DeviceAlarmFailsOff}
        |      DeviceAlarmErroneouslySent: _ -> DeviceError{DeviceAlarmFailsOn}
        |    properties
        |      relevantStates: RelevantStates = PatientDeath // Q.2: what does "applies to PatientStatus" mean here?
        |
        |  // from https://github.com/santoslab/aadl-map-apps/blob/develop/pca-shutoff/packages/PCAPump_Interface.aadl
        |
        |  PcaPump
        |    ports
        |      in PumpNormally: InadvertentPumpNormally
        |    flows
        |      ODCommand: PumpNormally{InadvertentPumpNormally} -> _
        |    properties
        |      componentKing: ComponentKind = ComponentKind.Actuator
        |      relevantStates: RelevantStates = PatientDeath
        |
        |  // from https://github.com/santoslab/aadl-map-apps/blob/develop/pca-shutoff/packages/PCA_Shutoff_Display.aadl
        |
        |  AppDisplay
        |    ports
        |      in SpO2: SpO2ValueHigh
        |      in ETCO2 // Q.3: is this not used for hazard analysis? (likewise for the rest of untyped ports)
        |      in RespiratoryRate
        |      in CommandPumpNormal
        |      in CapnographError
        |      in PulseOxError
        |      out Show
        |    flows
        |      HighSpO2MisleadsClinician: SpO2{SpO2ValueHigh} -> _
        |    properties
        |      processKind: ProcessKind = ProcessKind.Display
        |      componentKind: ComponentKind = ComponentKind.Actuator
        |      relevantStates: RelevantStates = PatientDeath
        |
        |  // https://github.com/santoslab/aadl-map-apps/blob/develop/pca-shutoff/packages/PCA_Shutoff_Logic.aadl
        |
        |  AppLogic
        |    ports
        |      in SpO2: SpO2ValueHigh
        |      in ETCO2: ETCO2ValueHigh
        |      in RespiratoryRate: RespiratoryRate
        |      in CapnographError
        |      in PulseOxError
        |      out CommandPumpNormal: InadvertentPumpNormally
        |    flows
        |      HighSpO2LeadsToOD: SpO2{SpO2ValueHigh} -> CommandPumpNormal{InadvertentPumpNormally}
        |      HighETCO2LeadsToOD: ETCO2{ETCO2ValueHigh} -> CommandPumpNormal{InadvertentPumpNormally}
        |      LowRRLeadsToOD: RespiratoryRate{RespiratoryRateLow, RespiratoryRateHigh} -> CommandPumpNormal{InadvertentPumpNormally}
        |    properties
        |      relevantStates: RelevantStates = PatientDeath
        |      protoHazard: ProtoHazard = ProtoHazard(harm = PatientDeath,
        |                                             componentState = PumpAction.PumpNormal,
        |                                             environmentState = PatientStatus.Risk,
        |                                             interactionPoints = Seq[Port](AppLogic.SpO2, AppLogic.ETCO2))
        |      occurrence: Occurrence = Occurrence(kind = KindsType.Providing,
        |                                          violatedConstraint = Some[Constraint](DontLetPumpRunWhenUnsafe),
        |                                          title = "High Physio Params",
        |                                          cause = OccurrenceCause(errorType = Some[ErrorType](InadvertentPumpNormally),
        |                                                                  description = "One or more physiological parameters are too high, leading the app logic to incorrectly believe the patient is healthy"),
        |                                          compensation = "Physiological values are cross-checked with others")
        |
        |  // from https://github.com/santoslab/aadl-map-apps/blob/develop/pca-shutoff/packages/PulseOx_Interface.aadl
        |
        |  PulseOx
        |    ports
        |      out SpO2: SpO2ValueHigh
        |      out DeviceError: DeviceAlarmFailsStatus
        |    flows
        |      SpO2UnDetectableHighValueFlowSource: _ -> SpO2{SpO2ValueHigh}
        |      DeviceAlarmNotSent: _ -> DeviceError{DeviceAlarmFailsOn}
        |      DeviceAlarmErroneouslySent: _ -> DeviceError{DeviceAlarmFailsOff}
        |    properties
        |      relevantStates: RelevantStates = PatientDeath
        |
        |
        |connections
        |
        |  // from https://github.com/santoslab/aadl-map-apps/blob/develop/pca-shutoff/packages/PCA_Shutoff_System.aadl
        |
        |  Spo2Logic: PulseOx.SpO2{InadvertentPumpNormally} -> AppLogic.SpO2
        |  // Q.4: Sam, what does https://github.com/santoslab/aadl-map-apps/blob/develop/pca-shutoff/packages/PCA_Shutoff_System.aadl#L49-L51 mean?
        |  //      Specifically, what does error source on a connection mean?
        |  //      Which port of the connection originates the error?
        |  //      In the above, I put it in PulseOx.SpO2.
        |
        |  RespiratoryRateLogic: Capnograph.RespiratoryRate -> AppLogic.RespiratoryRate
        |
        |  PumpCommandLogic: AppLogic.CommandPumpNormal -> PcaPump.PumpNormally
        |    properties
        |      occurrence1: Occurrence = Occurrence(kind = KindsType.Providing,
        |                                           violatedConstraint = Some[Constraint](DontLetPumpRunWhenUnsafe),
        |                                           title = "High Physio Params",
        |                                           cause = OccurrenceCause(errorType = Some[ErrorType](InadvertentPumpNormally),
        |                                                                   description = "One or more physiological parameters are too high, leading the app logic to incorrectly believe the patient is healthy"),
        |                                           compensation = "Physiological values are cross-checked with others")
        |      occurrence2: Occurrence = Occurrence(kind = KindsType.NotProviding,
        |                                           violatedConstraint = None[Constraint],
        |                                           title = "NotHazardous",
        |                                           cause = OccurrenceCause(errorType = None[ErrorType],
        |                                                                   description = "Not running the pump isn't unsafe (though it may be undesirable)"),
        |                                           compensation = "Not needed")
        |
        |  ETCO2Logic: Capnograph.ETCO2 -> AppLogic.ETCO2
        |
        |  CapnographFailLogic: Capnograph.DeviceError -> AppLogic.CapnographError
        |
        |  PulseoxFailLogic: PulseOx.DeviceError -> AppLogic.PulseOxError
        |
        |  Spo2Display: PulseOx.SpO2 -> appDisplay.SpO2
        |
        |  RespiratoryRateDisplay: Capnograph.RespiratoryRate -> AppDisplay.RespiratoryRate
        |
        |  PumpCommandDisplay: AppLogic.CommandPumpNormal -> AppDisplay.CommandPumpNormal
        |
        |  ETCO2Display: Capnograph.ETCO2 -> AppDisplay.ETCO2
        |
        |  CapnographFailDisplay: Capnograph.DeviceError -> AppDisplay.CapnographError
        |
        |  PulseOxFailDisplay: PulseOx.DeviceError -> AppDisplay.PulseOxError
        |
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

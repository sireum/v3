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

package org.sireum.logika

import org.sireum.logika.ast._
import org.sireum.util._

private final case class
SequentProofContext(unitNode: UnitNode,
                    autoEnabled: Boolean,
                    timeoutInMs: PosInteger,
                    checkSat: Boolean = false,
                    hintEnabled: Boolean = false,
                    inscribeSummoningsEnabled: Boolean = false,
                    coneInfluenceEnabled: Boolean = false,
                    invariants: ILinkedSet[Exp] = ilinkedSetEmpty,
                    premises: ILinkedSet[Exp] = ilinkedSetEmpty,
                    vars: ISet[String] = isetEmpty,
                    facts: IMap[String, Exp] = imapEmpty,
                    provedSteps: IMap[Natural, ProofStep] = imapEmpty,
                    declaredStepNumbers: IMap[Natural, LocationInfo] = imapEmpty,
                    methodOpt: Option[MethodDecl] = None,
                    satFacts: Boolean = true)
                   (implicit reporter: AccumulatingTagReporter) extends ProofContext[SequentProofContext] {
  val isSymExe = false

  def make(vars: ISet[String],
           provedSteps: IMap[Natural, ProofStep],
           declaredStepNumbers: IMap[Natural, LocationInfo],
           premises: ILinkedSet[Exp]): SequentProofContext =
    copy(vars = vars, provedSteps = provedSteps,
      declaredStepNumbers = declaredStepNumbers, premises = premises)
}

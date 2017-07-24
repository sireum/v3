// #Sireum
/*
 Copyright (c) 2017, Robby, Kansas State University
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

package org.sireum.lang.tools

import org.sireum._

@datatype trait Template {
  def main(licenseOpt: Option[String],
           fileUriOpt: Option[String],
           packageNameOpt: Option[String],
           name: String,
           preMethods: ISZ[ST],
           postMethod: ISZ[ST],
           transformHelper: ISZ[ST],
           transformMethod: ISZ[ST]): ST
}

object Template {
  val empty: ST = st""

  @pure def stOpt[T](tOpt: Option[T], f: T => ST): ST = {
    return tOpt.map(f).getOrElse(empty)
  }

  @datatype class MTransformer {
    def main(licenseOpt: Option[String],
             fileUriOpt: Option[String],
             packageNameOpt: Option[String],
             name: String,
             preMethods: ISZ[ST],
             postMethods: ISZ[ST],
             transformHelpers: ISZ[ST],
             transformMethods: ISZ[ST]): ST = {
      val license: ST = stOpt(licenseOpt, (text: String) =>
        st"""/*
            | $text
            | */)
            |""")
      val fileUri: ST = stOpt(fileUriOpt, (text: String) =>
        st"// This file is auto-generated from $text\n")
      val packageName: ST = stOpt(fileUriOpt, (text: String) =>
        st"package $text\n")
      return st"""// #Sireum
                 |// @formatter:off
                 |
                 |$license
                 |$fileUri
                 |$packageName
                 |
                 |import org.sireum._
                 |
                 |object $name {
                 |
                 |  @record class PreResult[T](continue: B,
                 |                             resultOpt: MOption[T])
                 |
                 |  @sig trait PrePost {
                 |
                 |    ${(preMethods, "\n\n")}
                 |
                 |    ${(postMethods, "\n\n")}
                 |
                 |  }
                 |
                 |  ${(transformHelpers, "\n\n")}
                 |
                 |}
                 |
                 |import $name._
                 |
                 |@record class $name(pp: PrePost) {
                 |
                 |  ${(transformMethods, "\n\n")}
                 |
                 |}"""
    }
  }

}

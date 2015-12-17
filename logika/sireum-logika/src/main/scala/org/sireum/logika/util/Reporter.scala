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

package org.sireum.logika.util

import org.sireum.util._

trait Reporter {
  def error(message: String): Unit

  def error(line: PosInteger,
            column: PosInteger,
            offset: Natural,
            message: String): Unit

  def info(message: String): Unit

  def info(line: PosInteger,
           column: PosInteger,
           offset: Natural,
           message: String): Unit

  def warn(message: String): Unit

  def warn(line: PosInteger,
           column: PosInteger,
           offset: Natural,
           message: String): Unit
}

object ConsoleReporter extends Reporter {
  override def error(message: String): Unit = {
    Console.err.println(message)
    Console.err.flush()
  }

  override def error(line: PosInteger,
                     column: PosInteger,
                     offset: Natural,
                     message: String): Unit = {
    Console.err.println(s"[$line, $column] $message")
    Console.err.flush()
  }

  override def info(message: String): Unit = {
    Console.out.println(message)
    Console.out.flush()
  }

  override def warn(message: String): Unit = {
    Console.out.println(message)
    Console.out.flush()
  }

  override def warn(line: PosInteger, column: PosInteger,
                    offset: Natural, message: String): Unit = {
    Console.out.println(s"[$line, $column] $message")
    Console.out.flush()
  }

  override def info(line: PosInteger, column: PosInteger,
                    offset: Natural, message: String): Unit = {
    Console.out.println(s"[$line, $column] $message")
    Console.out.flush()
  }
}

object ErrorCountingReporter extends Reporter {
  var errors = 0

  override def error(message: String): Unit = {
    Console.err.println(message)
    Console.err.flush()
    errors += 1
  }

  override def error(line: PosInteger,
                     column: PosInteger,
                     offset: Natural,
                     message: String): Unit = {
    Console.err.println(s"[$line, $column] $message")
    Console.err.flush()
    errors += 1
  }

  override def info(message: String): Unit = {}

  override def warn(message: String): Unit = {}

  override def warn(line: PosInteger, column: PosInteger,
                    offset: Natural, message: String): Unit = {}

  override def info(line: PosInteger, column: PosInteger,
                    offset: Natural, message: String): Unit = {}
}

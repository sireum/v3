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

package org.sireum.logika

object B {
  @native def random: B = $

  @native
  @pure def toB(b: B): B =
    c"""{ ensures result = b }"""

  @native
  @pure def toZ(b: B): Z =
    c"""{ ensures result = if (b) 1 else 0 }"""

  @native
  @pure def toZ8(b: B): Z8 =
    c"""{ ensures result = if (b) z8"1" else z8"0" }"""

  @native
  @pure def toZ16(b: B): Z16 =
    c"""{ ensures result = if (b) z16"1" else z16"0" }"""

  @native
  @pure def toZ32(b: B): Z32 =
    c"""{ ensures result = if (b) z32"1" else z32"0" }"""

  @native
  @pure def toZ64(b: B): Z64 =
    c"""{ ensures result = if (b) z64"1" else z64"0" }"""

  @native
  @pure def toN(b: B): N =
    c"""{ ensures result = if (b) n"1" else n"0" }"""

  @native
  @pure def toN8(b: B): N8 =
    c"""{ ensures result = if (b) n8"1" else n8"0" }"""

  @native
  @pure def toN16(b: B): N16 =
    c"""{ ensures result = if (b) n16"1" else n16"0" }"""

  @native
  @pure def toN32(b: B): N32 =
    c"""{ ensures result = if (b) n32"1" else n32"0" }"""

  @native
  @pure def toN64(b: B): N64 =
    c"""{ ensures result = if (b) n64"1" else n64"0" }"""

  @native
  @pure def toS8(b: B): S8 =
    c"""{ ensures result = if (b) s8"1" else s8"0" }"""

  @native
  @pure def toS16(b: B): S16 =
    c"""{ ensures result = if (b) s16"1" else s16"0" }"""

  @native
  @pure def toS32(b: B): S32 =
    c"""{ ensures result = if (b) s32"1" else s32"0" }"""

  @native
  @pure def toS64(b: B): S64 =
    c"""{ ensures result = if (b) s64"1" else s64"0" }"""

  @native
  @pure def toU8(b: B): U8 =
    c"""{ ensures result = if (b) u8"1" else u8"0" }"""

  @native
  @pure def toU16(b: B): U16 =
    c"""{ ensures result = if (b) u16"1" else u16"0" }"""

  @native
  @pure def toU32(b: B): U32 =
    c"""{ ensures result = if (b) u32"1" else u32"0" }"""

  @native
  @pure def toU64(b: B): U64 =
    c"""{ ensures result = if (b) u64"1" else u64"0" }"""

  @native
  @pure def toF32(b: B): F32 =
    c"""{ ensures result = if (b) f32"1.0" else f32"0.0" }"""

  @native
  @pure def toF64(b: B): F64 =
    c"""{ ensures result = if (b) f64"1.0" else f64"0.0" }"""

  @native
  @pure def toR(b: B): R =
    c"""{ ensures result = if (b) r"1.0" else r"0.0" }"""
}


object Z {
  @native def random: Z = $

  @native
  @pure def isInRangeZ8(n: Z): B =
    c"""{ ensures result = (-128 ≤ n ∧ n ≤ 127) }"""

  @native
  @pure def isInRangeZ16(n: Z): B =
    c"""{ ensures result = (-32768 ≤ n ∧ n ≤ 32767) }"""

  @native
  @pure def isInRangeZ32(n: Z): B =
    c"""{ ensures result = (-2147483648 ≤ n ∧ n ≤ 2147483647) }"""

  @native
  @pure def isInRangeZ64(n: Z): B =
    c"""{ ensures result = (-9223372036854775808 ≤ n ∧ n ≤ 9223372036854775807) }"""

  @native
  @pure def isInRangeN8(n: Z): B =
    c"""{ ensures result = (0 ≤ n ∧ n ≤ 255) }"""

  @native
  @pure def isInRangeN16(n: Z): B =
    c"""{ ensures result = (0 ≤ n ∧ n ≤ 65535) }"""

  @native
  @pure def isInRangeN32(n: Z): B =
    c"""{ ensures result = (0 ≤ n ∧ n ≤ 4294967295) }"""

  @native
  @pure def isInRangeN64(n: Z): B =
    c"""{ ensures result = (0 ≤ n ∧ n ≤ 18446744073709551615) }"""

  @native
  @pure def toB(n: Z): B =
    c"""{ ensures result = (n ≠ 0) }"""

  @native
  @pure def toZ(n: Z): Z =
    c"""{ ensures result = n }"""

  @native
  @pure def toZ8(n: Z): Z8 =
    c"""{ requires -128 ≤ n ∧ n ≤ 127
          ensures  Z8.toZ(result) = n }"""

  @native
  @pure def toZ16(n: Z): Z16 =
    c"""{ requires -32768 ≤ n ∧ n ≤ 32767
          ensures  Z16.toZ(result) = n    }"""

  @native
  @pure def toZ32(n: Z): Z32 =
    c"""{ requires -2147483648 ≤ n ∧ n ≤ 2147483647
          ensures  Z32.toZ(result) = n              }"""

  @native
  @pure def toZ64(n: Z): Z64 =
    c"""{ requires -9223372036854775808 ≤ n ∧ n ≤ 9223372036854775807
          ensures  Z64.toZ(result) = n                                }"""

  @native
  @pure def toN(n: Z): N =
    c"""{ requires n ≥ 0
          ensures  N.toZ(result) = n }"""

  @native
  @pure def toN8(n: Z): N8 =
    c"""{ requires 0 ≤ n ∧ n ≤ 255
          ensures  N8.toZ(result) = n }"""

  @native
  @pure def toN16(n: Z): N16 =
    c"""{ requires 0 ≤ n ∧ n ≤ 65535
          ensures  N16.toZ(result) = n }"""

  @native
  @pure def toN32(n: Z): N32 =
    c"""{ requires 0 ≤ n ∧ n ≤ 4294967295
          ensures  N32.toZ(result) = n    }"""

  @native
  @pure def toN64(n: Z): N64 =
    c"""{ requires 0 ≤ n ∧ n ≤ 18446744073709551615
          ensures  N64.toZ(result) = n              }"""

  @native
  @pure def toS8(n: Z): S8 =
    c"""{ requires -128 ≤ n ∧ n ≤ 127
          ensures  S8.toZ(result) = n }"""

  @native
  @pure def toS16(n: Z): S16 =
    c"""{ requires -32768 ≤ n ∧ n ≤ 32767
          ensures  S16.toZ(result) = n    }"""

  @native
  @pure def toS32(n: Z): S32 =
    c"""{ requires -2147483648 ≤ n ∧ n ≤ 2147483647
          ensures  S32.toZ(result) = n              }"""

  @native
  @pure def toS64(n: Z): S64 =
    c"""{ requires -9223372036854775808 ≤ n ∧ n ≤ 9223372036854775807
          ensures  S64.toZ(result) = n                                }"""

  @native
  @pure def toU8(n: Z): U8 =
    c"""{ requires 0 ≤ n ∧ n ≤ 255
          ensures  U8.toZ(result) = n }"""

  @native
  @pure def toU16(n: Z): U16 =
    c"""{ requires 0 ≤ n ∧ n ≤ 65535
          ensures  U16.toZ(result) = n }"""

  @native
  @pure def toU32(n: Z): U32 =
    c"""{ requires 0 ≤ n ∧ n ≤ 4294967295
          ensures  U32.toZ(result) = n }"""

  @native
  @pure def toU64(n: Z): U64 =
    c"""{ requires 0 ≤ n ∧ n ≤ 18446744073709551615
          ensures  U64.toZ(result) = n              }"""

  @native /* @first */
  @pure def toR(n: Z): R = $
}


object Z8 {
  val Max: Z8 = z8"127"

  val Min: Z8 = z8"-128"

  c"""{ invariant Max = z8"127"
                  Min = z8"-128" }"""

  @native def random: Z8 = $

  @native
  @pure def toB(n: Z8): B =
    c"""{ ensures result = (n ≠ z8"0") }"""

  @native /* @first */
  @pure def toZ(n: Z8): Z = $

  @native
  @pure def toZ8(n: Z8): Z8 =
    c"""{ ensures result = n }"""

  @native
  @pure def toZ16(n: Z8): Z16 =
    c"""{ ensures Z16.toZ(result) = toZ(n) }"""

  @native
  @pure def toZ32(n: Z8): Z32 =
    c"""{ ensures Z32.toZ(result) = toZ(n) }"""

  @native
  @pure def toZ64(n: Z8): Z64 =
    c"""{ ensures Z64.toZ(result) = toZ(n) }"""

  @native
  @pure def toN(n: Z8): N =
    c"""{ requires n ≥ z8"0"
          ensures  N.toZ(result) = toZ(n) }"""

  @native
  @pure def toN8(n: Z8): N8 =
    c"""{ requires n ≥ z8"0"
          ensures  N8.toZ(result) = toZ(n) }"""

  @native
  @pure def toN16(n: Z8): N16 =
    c"""{ requires n ≥ z8"0"
          ensures  N16.toZ(result) = toZ(n) }"""

  @native
  @pure def toN32(n: Z8): N32 =
    c"""{ requires n ≥ z8"0"
          ensures  N32.toZ(result) = toZ(n) }"""

  @native
  @pure def toN64(n: Z8): N64 =
    c"""{ requires n ≥ z8"0"
          ensures  N64.toZ(result) = toZ(n) }"""

  @native
  @pure def toS8(n: Z8): S8 =
    c"""{ ensures S8.toZ(result) = toZ(n) }"""

  @native
  @pure def toS16(n: Z8): S16 =
    c"""{ ensures S16.toZ(result) = toZ(n) }"""

  @native
  @pure def toS32(n: Z8): S32 =
    c"""{ ensures S32.toZ(result) = toZ(n) }"""

  @native
  @pure def toS64(n: Z8): S64 =
    c"""{ ensures S64.toZ(result) = toZ(n) }"""

  @native
  @pure def toU8(n: Z8): U8 =
    c"""{ requires n ≥ z8"0"
          ensures  U8.toZ(result) = toZ(n) }"""

  @native
  @pure def toU16(n: Z8): U16 =
    c"""{ requires n ≥ z8"0"
          ensures  U16.toZ(result) = toZ(n) }"""

  @native
  @pure def toU32(n: Z8): U32 =
    c"""{ requires n ≥ z8"0"
          ensures  U32.toZ(result) = toZ(n) }"""

  @native
  @pure def toU64(n: Z8): U64 =
    c"""{ requires n ≥ z8"0"
          ensures  U64.toZ(result) = toZ(n) }"""

  @native
  @pure def toR(n: Z8): R =
    c"""{ ensures result = Z.toR(toZ(n)) }"""
}


object Z16 {
  val Max: Z16 = z16"32767"

  val Min: Z16 = z16"-32768"

  c"""{ invariant Max = z16"32767"
                  Min = z16"-32768" }"""

  @native def random: Z16 = $

  @native
  @pure def toB(n: Z16): B =
    c"""{ ensures result = (n ≠ z16"0") }"""

  @native /* @first */
  @pure def toZ(n: Z16): Z = $

  @native
  @pure def toZ8(n: Z16): Z8 =
    c"""{ requires z16"-128" ≤ n ∧ n ≤ z16"127"
          ensures  Z8.toZ(result) = toZ(n)      }"""

  @native
  @pure def toZ16(n: Z16): Z16 =
    c"""{ ensures result = n }"""

  @native
  @pure def toZ32(n: Z16): Z32 =
    c"""{ ensures Z32.toZ(result) = toZ(n) }"""

  @native
  @pure def toZ64(n: Z16): Z64 =
    c"""{ ensures Z64.toZ(result) = toZ(n) }"""

  @native
  @pure def toN(n: Z16): N =
    c"""{ requires n ≥ z16"0"
          ensures  N.toZ(result) = toZ(n) }"""

  @native
  @pure def toN8(n: Z16): N8 =
    c"""{ requires z16"0" ≤ n ∧ n ≤ z16"255"
          ensures  N8.toZ(result) = toZ(n)   }"""

  @native
  @pure def toN16(n: Z16): N16 =
    c"""{ requires n ≥ z16"0"
          ensures  N16.toZ(result) = toZ(n) }"""

  @native
  @pure def toN32(n: Z16): N32 =
    c"""{ requires n ≥ z16"0"
          ensures  N32.toZ(result) = toZ(n) }"""

  @native
  @pure def toN64(n: Z16): N64 =
    c"""{ requires n ≥ z16"0"
          ensures  N64.toZ(result) = toZ(n) }"""

  @native
  @pure def toS8(n: Z16): S8 =
    c"""{ requires z16"-128" ≤ n ∧ n ≤ z16"127"
          ensures  S8.toZ(result) = toZ(n)      }"""

  @native
  @pure def toS16(n: Z16): S16 =
    c"""{ ensures S16.toZ(result) = toZ(n) }"""

  @native
  @pure def toS32(n: Z16): S32 =
    c"""{ ensures S32.toZ(result) = toZ(n) }"""

  @native
  @pure def toS64(n: Z16): S64 =
    c"""{ ensures S64.toZ(result) = toZ(n) }"""

  @native
  @pure def toU8(n: Z16): U8 =
    c"""{ requires z16"0" ≤ n ∧ n ≤ z16"255"
          ensures  U8.toZ(result) = toZ(n)   }"""

  @native
  @pure def toU16(n: Z16): U16 =
    c"""{ requires n ≥ z16"0"
          ensures  U16.toZ(result) = toZ(n) }"""

  @native
  @pure def toU32(n: Z16): U32 =
    c"""{ requires n ≥ z16"0"
          ensures  U32.toZ(result) = toZ(n) }"""

  @native
  @pure def toU64(n: Z16): U64 =
    c"""{ requires n ≥ z16"0"
          ensures  U64.toNZ(result) = toZ(n) }"""

  @native
  @pure def toR(n: Z16): R =
    c"""{ ensures result = Z.toR(toZ(n)) }"""
}


object Z32 {
  val Max: Z32 = z32"2147483647"

  val Min: Z32 = z32"-2147483648"

  c"""{ invariant Max = z32"2147483647"
                  Min = z32"-2147483648" }"""

  @native def random: Z32 = $

  @native
  @pure def toB(n: Z32): B =
    c"""{ ensures result = (n ≠ z32"0") }"""

  @native /* @first */
  @pure def toZ(n: Z32): Z = $

  @native
  @pure def toZ8(n: Z32): Z8 =
    c"""{ requires z32"-128" ≤ n ∧ n ≤ z32"127"
          ensures  Z8.toZ(result) = toZ(n)      }"""

  @native
  @pure def toZ16(n: Z32): Z16 =
    c"""{ requires z32"-32768" ≤ n ∧ n ≤ z32"32767"
          ensures  Z16.toZ(result) = toZ(n)         }"""

  @native
  @pure def toZ32(n: Z32): Z32 =
    c"""{ ensures result = n }"""

  @native
  @pure def toZ64(n: Z32): Z64 =
    c"""{ ensures Z64.toZ(result) = toZ(n) }"""

  @native
  @pure def toN(n: Z32): N =
    c"""{ requires n ≥ z32"0"
          ensures  N.toZ(result) = toZ(n) }"""

  @native
  @pure def toN8(n: Z32): N8 =
    c"""{ requires z32"0" ≤ n ∧ n ≤ z32"255"
          ensures  N8.toZ(result) = toZ(n)   }"""

  @native
  @pure def toN16(n: Z32): N16 =
    c"""{ requires z32"0" ≤ n ∧ n ≤ z32"65535"
          ensures  N16.toZ(result) = toZ(n)    }"""

  @native
  @pure def toN32(n: Z32): N32 =
    c"""{ requires n ≥ z32"0"
          ensures  N32.toZ(result) = toZ(n) }"""

  @native
  @pure def toN64(n: Z32): N64 =
    c"""{ requires n ≥ z32"0"
          ensures  N64.toZ(result) = toZ(n) }"""

  @native
  @pure def toS8(n: Z32): S8 =
    c"""{ requires z32"-128" ≤ n ∧ n ≤ z32"127"
          ensures  S8.toZ(result) = toZ(n)      }"""

  @native
  @pure def toS16(n: Z32): S16 =
    c"""{ requires z32"-32768" ≤ n ∧ n ≤ z32"32767"
          ensures  S16.toZ(result) = toZ(n)         }"""

  @native
  @pure def toS32(n: Z32): S32 =
    c"""{ ensures S32.toZ(result) = toZ(n) }"""

  @native
  @pure def toS64(n: Z32): S64 =
    c"""{ ensures S64.toZ(result) = toZ(n) }"""

  @native
  @pure def toU8(n: Z32): U8 =
    c"""{ requires z32"0" ≤ n ∧ n ≤ z32"255"
          ensures  U8.toZ(result) = toZ(n)   }"""

  @native
  @pure def toU16(n: Z32): U16 =
    c"""{ requires z32"0" ≤ n ∧ n ≤ z32"65535"
          ensures  U16.toZ(result) = toZ(n)    }"""

  @native
  @pure def toU32(n: Z32): U32 =
    c"""{ requires n ≥ z32"0"
          ensures  U32.toZ(result) = toZ(n) }"""

  @native
  @pure def toU64(n: Z32): U64 =
    c"""{ requires n ≥ z32"0"
          ensures  U64.toZ(result) = toZ(n) }"""

  @native
  @pure def toR(n: Z32): R =
    c"""{ ensures result = Z.toR(toZ(n)) }"""
}


object Z64 {
  val Max: Z64 = z64"9223372036854775807"

  val Min: Z64 = z64"-9223372036854775808"

  c"""{ invariant Max = z64"9223372036854775807"
                  Min = z64"-9223372036854775808" }"""

  @native def random: Z64 = $

  @native
  @pure def toB(n: Z64): B =
    c"""{ ensures result = (n ≠ z64"0") }"""

  @native /* @first */
  @pure def toZ(n: Z64): Z = $

  @native
  @pure def toZ8(n: Z64): Z8 =
    c"""{ requires z64"-128" ≤ n ∧ n ≤ z64"127"
          ensures  Z8.toZ(result) = toZ(n)      }"""

  @native
  @pure def toZ16(n: Z64): Z16 =
    c"""{ requires z64"-32768" ≤ n ∧ n ≤ z64"32767"
          ensures  Z16.toZ(result) = toZ(n)         }"""

  @native
  @pure def toZ32(n: Z64): Z32 =
    c"""{ requires z64"-2147483648" ≤ n ∧ n ≤ z64"2147483647"
          ensures  Z32.toZ(result) = toZ(n)                   }"""

  @native
  @pure def toZ64(n: Z64): Z64 =
    c"""{ ensures result = n }"""

  @native
  @pure def toN(n: Z64): N =
    c"""{ requires n ≥ z64"0"
          ensures  N.toZ(result) = toZ(n) }"""

  @native
  @pure def toN8(n: Z64): N8 =
    c"""{ requires z64"0" ≤ n ∧ n ≤ z64"255"
          ensures  N8.toZ(result) = toZ(n)   }"""

  @native
  @pure def toN16(n: Z64): N16 =
    c"""{ requires z64"0" ≤ n ∧ n ≤ z64"65535"
          ensures  N16.toZ(result) = toZ(n)    }"""

  @native
  @pure def toN32(n: Z64): N32 =
    c"""{ requires z64"0" ≤ n ∧ n ≤ z64"4294967295"
          ensures  N32.toZ(result) = toZ(n)         }"""

  @native
  @pure def toN64(n: Z64): N64 =
    c"""{ ensures N64.toZ(result) = toZ(n) }"""

  @native
  @pure def toS8(n: Z64): S8 =
    c"""{ requires z64"-128" ≤ n ∧ n ≤ z64"127"
          ensures  S8.toZ(result) = toZ(n)      }"""

  @native
  @pure def toS16(n: Z64): S16 =
    c"""{ requires z64"-32768" ≤ n ∧ n ≤ z64"32767"
          ensures  S16.toZ(result) = toZ(n)         }"""

  @native
  @pure def toS32(n: Z64): S32 =
    c"""{ requires z64"-2147483648" ≤ n ∧ n ≤ z64"2147483647"
          ensures  S32.toZ(result) = toZ(n)                   }"""

  @native
  @pure def toS64(n: Z64): S64 =
    c"""{ ensures S64.toZ(result) = toZ(n) }"""

  @native
  @pure def toU8(n: Z64): U8 =
    c"""{ requires z64"0" ≤ n ∧ n ≤ z64"255"
          ensures  U8.toZ(result) = toZ(n)   }"""

  @native
  @pure def toU16(n: Z64): U16 =
    c"""{ requires z64"0" ≤ n ∧ n ≤ z64"65535"
          ensures  U16.toZ(result) = toZ(n)    }"""

  @native
  @pure def toU32(n: Z64): U32 =
    c"""{ requires z64"0" ≤ n ∧ n ≤ z64"4294967295"
          ensures  U32.toZ(result) = toZ(n)         }"""

  @native
  @pure def toU64(n: Z64): U64 =
    c"""{ requires z64"0" ≤ n ∧ n ≤ z64"18446744073709551615"
          ensures  U64.toZ(result) = toZ(n)                   }"""

  @native
  @pure def toR(n: Z64): R =
    c"""{ ensures result = Z.toR(toZ(n)) }"""
}


object N {
  @native def random: N = $

  @native
  @pure def toB(n: N): B =
    c"""{ ensures result = (n ≠ n"0") }"""

  @native /* @first */
  @pure def toZ(n: N): Z = $

  @native
  @pure def toZ8(n: N): Z8 =
    c"""{ requires n ≤ n"127"
          ensures  Z8.toZ(result) = toZ(n) }"""

  @native
  @pure def toZ16(n: N): Z16 =
    c"""{ requires n ≤ n"32767"
          ensures  Z16.toZ(result) = toZ(n) }"""

  @native
  @pure def toZ32(n: N): Z32 =
    c"""{ requires n ≤ n"2147483647"
          ensures  Z32.toZ(result) = toZ(n) }"""

  @native
  @pure def toZ64(n: N): Z64 =
    c"""{ requires n ≤ n"9223372036854775807"
          ensures  Z64.toZ(result) = toZ(n)   }"""

  @native
  @pure def toN(n: N): N =
    c"""{ ensures result = n }"""

  @native
  @pure def toN8(n: N): N8 =
    c"""{ requires n ≤ n"255"
          ensures  N8.toN(result) = n }"""

  @native
  @pure def toN16(n: N): N16 =
    c"""{ requires n ≤ n"65535"
          ensures  N16.toN(result) = n }"""

  @native
  @pure def toN32(n: N): N32 =
    c"""{ requires n ≤ n"4294967295"
          ensures  N32.toN(result) = n }"""

  @native
  @pure def toN64(n: N): N64 =
    c"""{ requires n ≤ n"18446744073709551615"
          ensures  N64.toN(result) = n         }"""

  @native
  @pure def toS8(n: N): S8 =
    c"""{ requires n ≤ n"127"
          ensures  S8.toZ(result) = toZ(n) }"""

  @native
  @pure def toS16(n: N): S16 =
    c"""{ requires n ≤ n"32767"
          ensures  S16.toZ(result) = toZ(n) }"""

  @native
  @pure def toS32(n: N): S32 =
    c"""{ requires n ≤ n"2147483647"
          ensures  S32.toZ(result) = toZ(n) }"""

  @native
  @pure def toS64(n: N): S64 =
    c"""{ requires n ≤ n"9223372036854775807"
          ensures  S64.toZ(result) = toZ(n)   }"""

  @native
  @pure def toU8(n: N): U8 =
    c"""{ requires n ≤ n"255"
          ensures  U8.toN(result) = n }"""

  @native
  @pure def toU16(n: N): U16 =
    c"""{ requires n ≤ n"65535"
          ensures  U16.toN(result) = n }"""

  @native
  @pure def toU32(n: N): U32 =
    c"""{ requires n ≤ n"4294967295"
          ensures  U32.toN(result) = n }"""

  @native
  @pure def toU64(n: N): U64 =
    c"""{ requires n ≤ n"18446744073709551615"
          ensures  U64.toN(result) = n         }"""

  @native /* @first */
  @pure def toR(n: N): R = $
}


object N8 {
  val Max: N8 = n8"255"

  c"""{ invariant Max = n8"255" }"""

  @native def random: N8 = $

  @native
  @pure def toB(n: N8): B =
    c"""{ ensures result = (n ≠ n8"0") }"""

  @native /* @first */
  @pure def toZ(n: N8): Z = $

  @native
  @pure def toZ8(n: N8): Z8 =
    c"""{ requires n ≤ n8"127"
          ensures  Z8.toZ(result) = toZ(n) }"""

  @native
  @pure def toZ16(n: N8): Z16 =
    c"""{ ensures Z16.toZ(result) = toZ(n) }"""

  @native
  @pure def toZ32(n: N8): Z32 =
    c"""{ ensures Z32.toZ(result) = toZ(n) }"""

  @native
  @pure def toZ64(n: N8): Z64 =
    c"""{ ensures Z64.toZ(result) = toZ(n) }"""

  @native /* @first */
  @pure def toN(n: N8): N = $

  @native
  @pure def toN8(n: N8): N8 =
    c"""{ ensures result = n }"""

  @native
  @pure def toN16(n: N8): N16 =
    c"""{ ensures N16.toN(result) = toN(n) }"""

  @native
  @pure def toN32(n: N8): N32 =
    c"""{ ensures N32.toN(result) = toN(n) }"""

  @native
  @pure def toN64(n: N8): N64 =
    c"""{ ensures N64.toN(result) = toN(n) }"""

  @native
  @pure def toS8(n: N8): S8 =
    c"""{ requires n ≤ n8"127"
          ensures  S8.toZ(result) = toZ(n) }"""

  @native
  @pure def toS16(n: N8): S16 =
    c"""{ ensures S16.toZ(result) = toZ(n) }"""

  @native
  @pure def toS32(n: N8): S32 =
    c"""{ ensures S32.toZ(result) = toZ(n) }"""

  @native
  @pure def toS64(n: N8): S64 =
    c"""{ ensures S64.toZ(result) = toZ(n) }"""

  @native
  @pure def toU8(n: N8): U8 =
    c"""{ ensures U8.toN(result) = toN(n) }"""

  @native
  @pure def toU16(n: N8): U16 =
    c"""{ ensures U16.toN(result) = toN(n) }"""

  @native
  @pure def toU32(n: N8): U32 =
    c"""{ ensures U32.toN(result) = toN(n) }"""

  @native
  @pure def toU64(n: N8): U64 =
    c"""{ ensures U64.toN(result) = toN(n) }"""

  @native
  @pure def toR(n: N8): R =
    c"""{ ensures result = N.toR(toN(n)) }"""
}


object N16 {
  val Max: N16 = n16"65535"

  c"""{ invariant Max = n16"65535" }"""

  @native def random: N16 = $

  @native
  @pure def toB(n: N16): B =
    c"""{ ensures result = (n ≠ n16"0") }"""

  @native /* @first */
  @pure def toZ(n: N16): Z = $

  @native
  @pure def toZ8(n: N16): Z8 =
    c"""{ requires n ≤ n16"127"
          ensures  Z8.toZ(result) = toZ(n) }"""

  @native
  @pure def toZ16(n: N16): Z16 =
    c"""{ requires n ≤ n16"32767"
          ensures  Z16.toZ(result) = toZ(n)   }"""

  @native
  @pure def toZ32(n: N16): Z32 =
    c"""{ ensures Z32.toZ(result) = toZ(n) }"""

  @native
  @pure def toZ64(n: N16): Z64 =
    c"""{ ensures Z64.toZ(result) = toZ(n) }"""

  @native /* @first */
  @pure def toN(n: N16): N = $

  @native
  @pure def toN8(n: N16): N8 =
    c"""{ requires n ≤ n16"255"
          ensures  N8.toN(result) = toN(n) }"""

  @native
  @pure def toN16(n: N16): N16 =
    c"""{ ensures N16.toN(result) = toN(n) }"""

  @native
  @pure def toN32(n: N16): N32 =
    c"""{ ensures N32.toN(result) = toN(n) }"""

  @native
  @pure def toN64(n: N16): N64 =
    c"""{ ensures N64.toN(result) = toN(n) }"""

  @native
  @pure def toS8(n: N16): S8 =
    c"""{ requires n ≤ n16"127"
          ensures  S8.toZ(result) = toZ(n) }"""

  @native
  @pure def toS16(n: N16): S16 =
    c"""{ requires n ≤ n16"32767"
          ensures  S16.toZ(result) = toZ(n) }"""

  @native
  @pure def toS32(n: N16): S32 =
    c"""{ ensures S32.toZ(result) = toZ(n) }"""

  @native
  @pure def toS64(n: N16): S64 =
    c"""{ ensures S64.toZ(result) = toZ(n) }"""

  @native
  @pure def toU8(n: N16): U8 =
    c"""{ requires n ≤ n16"255"
          ensures  U8.toN(result) = toN(n) }"""

  @native
  @pure def toU16(n: N16): U16 =
    c"""{ ensures U16.toN(result) = toN(n) }"""

  @native
  @pure def toU32(n: N16): U32 =
    c"""{ ensures U32.toN(result) = toN(n) }"""

  @native
  @pure def toU64(n: N16): U64 =
    c"""{ ensures U64.toN(result) = toN(n) }"""

  @native
  @pure def toR(n: N16): R =
    c"""{ ensures result = N.toR(toN(n)) }"""
}


object N32 {
  val Max: N32 = n32"4294967295"

  c"""{ invariant Max = n32"4294967295" }"""

  @native def random: N32 = $

  @native
  @pure def toB(n: N32): B =
    c"""{ ensures result = (n ≠ n32"0") }"""

  @native /* @first */
  @pure def toZ(n: N32): Z = $

  @native
  @pure def toZ8(n: N32): Z8 =
    c"""{ requires n ≤ n32"127"
          ensures  Z8.toZ(result) = toZ(n) }"""

  @native
  @pure def toZ16(n: N32): Z16 =
    c"""{ requires n ≤ n32"32767"
          ensures  Z16.toZ(result) = toZ(n) }"""

  @native
  @pure def toZ32(n: N32): Z32 =
    c"""{ requires n ≤ n32"2147483647"
          ensures  Z32.toZ(result) = toZ(n) }"""

  @native
  @pure def toZ64(n: N32): Z64 =
    c"""{ ensures Z64.toZ(result) = toZ(n) }"""

  @native /* @first */
  @pure def toN(n: N32): N = $

  @native
  @pure def toN8(n: N32): N8 =
    c"""{ requires n ≤ n32"255"
          ensures  N8.toN(result) = toN(n) }"""

  @native
  @pure def toN16(n: N32): N16 =
    c"""{ requires n ≤ n32"65535"
          ensures  N16.toN(result) = toN(n) }"""

  @native
  @pure def toN32(n: N32): N32 =
    c"""{ ensures result = n }"""

  @native
  @pure def toN64(n: N32): N64 =
    c"""{ ensures N64.toN(result) = toN(n) }"""

  @native
  @pure def toS8(n: N32): S8 =
    c"""{ requires n ≤ n32"127"
          ensures  S8.toZ(result) = toZ(n) }"""

  @native
  @pure def toS16(n: N32): S16 =
    c"""{ requires n ≤ n32"32767"
          ensures  S16.toZ(result) = toZ(n) }"""

  @native
  @pure def toS32(n: N32): S32 =
    c"""{ requires n ≤ n32"2147483647"
          ensures  S32.toZ(result) = toZ(n) }"""

  @native
  @pure def toS64(n: N32): S64 =
    c"""{ ensures S64.toZ(result) = toZ(n) }"""

  @native
  @pure def toU8(n: N32): U8 =
    c"""{ requires n ≤ n32"255"
          ensures  U8.toN(result) = toN(n) }"""

  @native
  @pure def toU16(n: N32): U16 =
    c"""{ requires n ≤ n32"65535"
          ensures  U16.toN(result) = toN(n) }"""

  @native
  @pure def toU32(n: N32): U32 =
    c"""{ ensures U32.toN(result) = toN(n) }"""

  @native
  @pure def toU64(n: N32): U64 =
    c"""{ ensures U32.toN(result) = toN(n) }"""

  @native
  @pure def toR(n: N32): R =
    c"""{ ensures result = N.toR(toN(n)) }"""
}


object N64 {
  val Max: N64 = n64"18446744073709551615"

  c"""{ invariant Max = n64"18446744073709551615" }"""

  @native def random: N64 = $

  @native
  @pure def toB(n: N64): B =
    c"""{ ensures result = (n ≠ n64"0") }"""

  @native /* @first */
  @pure def toZ(n: N64): Z = $

  @native
  @pure def toZ8(n: N64): Z8 =
    c"""{ requires n ≤ n64"127"
          ensures  Z8.toZ(result) = toZ(n) }"""

  @native
  @pure def toZ16(n: N64): Z16 =
    c"""{ requires n ≤ n64"32767"
          ensures  Z16.toZ(result) = toZ(n) }"""

  @native
  @pure def toZ32(n: N64): Z32 =
    c"""{ requires n ≤ n64"2147483647"
          ensures  Z32.toZ(result) = toZ(n) }"""

  @native
  @pure def toZ64(n: N64): Z64 =
    c"""{ requires n ≤ n64"9223372036854775807"
          ensures  Z64.toZ(result) = toZ(n)     }"""

  @native /* @first */
  @pure def toN(n: N64): N = $

  @native
  @pure def toN8(n: N64): N8 =
    c"""{ requires n ≤ n64"255"
          ensures  N8.toN(result) = toN(n) }"""

  @native
  @pure def toN16(n: N64): N16 =
    c"""{ requires n ≤ n64"65535"
          ensures  N16.toN(result) = toN(n) }"""

  @native
  @pure def toN32(n: N64): N32 =
    c"""{ requires n ≤ n64"4294967295"
          ensures  N32.toN(result) = toN(n) }"""

  @native
  @pure def toN64(n: N64): N64 =
    c"""{ ensures result = n }"""

  @native
  @pure def toS8(n: N64): S8 =
    c"""{ requires n ≤ n64"127"
          ensures  S8.toZ(result) = toZ(n) }"""

  @native
  @pure def toS16(n: N64): S16 =
    c"""{ requires n ≤ n64"32767"
          ensures  S16.toZ(result) = toZ(n) }"""

  @native
  @pure def toS32(n: N64): S32 =
    c"""{ requires n ≤ n64"2147483647"
          ensures  S32.toZ(result) = toZ(n) }"""

  @native
  @pure def toS64(n: N64): S64 =
    c"""{ requires n ≤ n64"9223372036854775807"
          ensures  S64.toZ(result) = toZ(n)     }"""

  @native
  @pure def toU8(n: N64): U8 =
    c"""{ requires n ≤ n64"255"
          ensures  U8.toN(result) = toN(n) }"""

  @native
  @pure def toU16(n: N64): U16 =
    c"""{ requires n ≤ n64"65535"
          ensures  U16.toN(result) = toN(n) }"""

  @native
  @pure def toU32(n: N64): U32 =
    c"""{ requires n ≤ n64"4294967295"
          ensures  U32.toN(result) = toN(n) }"""

  @native
  @pure def toU64(n: N64): U64 =
    c"""{ ensures U64.toN(result) = toN(n) }"""

  @native
  @pure def toR(n: N64): R =
    c"""{ ensures result = N.toR(toN(n)) }"""
}


object S8 {
  val Max: S8 = s8"127"

  val Min: S8 = s8"-128"

  c"""{ invariant Max = s8"127"
                  Min = s8"-128" }"""

  @native def random: S8 = $

  @native
  @pure def toB(n: S8): B =
    c"""{ ensures result = (n ≠ s8"0") }"""

  @native
  @pure def toZ(n: S8): Z =
    c"""{ ensures result = if (n ≥ s8"0")
                               (if ((n & s8"1" ) ≠ s8"1" ) 0 else 1 ) +
                               (if ((n & s8"2" ) ≠ s8"2" ) 0 else 2 ) +
                               (if ((n & s8"4" ) ≠ s8"4" ) 0 else 4 ) +
                               (if ((n & s8"8" ) ≠ s8"8" ) 0 else 8 ) +
                               (if ((n & s8"16") ≠ s8"16") 0 else 16) +
                               (if ((n & s8"32") ≠ s8"32") 0 else 32) +
                               (if ((n & s8"64") ≠ s8"64") 0 else 64)
                           else
                             -((if ((n & s8"1" ) = s8"1" ) 0 else 1 ) +
                               (if ((n & s8"2" ) = s8"2" ) 0 else 2 ) +
                               (if ((n & s8"4" ) = s8"4" ) 0 else 4 ) +
                               (if ((n & s8"8" ) = s8"8" ) 0 else 8 ) +
                               (if ((n & s8"16") = s8"16") 0 else 16) +
                               (if ((n & s8"32") = s8"32") 0 else 32) +
                               (if ((n & s8"64") = s8"64") 0 else 64) + 1) }"""

  @native
  @pure def toZ8(n: S8): Z8 =
    c"""{ ensures Z8.toZ(result) = toZ(n) }"""

  @native
  @pure def toZ16(n: S8): Z16 =
    c"""{ ensures Z16.toZ(result) = toZ(n) }"""

  @native
  @pure def toZ32(n: S8): Z32 =
    c"""{ ensures Z32.toZ(result) = toZ(n) }"""

  @native
  @pure def toZ64(n: S8): Z64 =
    c"""{ ensures Z64.toZ(result) = toZ(n) }"""

  @native
  @pure def toN(n: S8): N =
    c"""{ requires n ≥ s8"0"
          ensures  result = (if ((n & s8"1"  ) ≠ s8"1"  ) n"0" else n"1"  ) +
                            (if ((n & s8"2"  ) ≠ s8"2"  ) n"0" else n"2"  ) +
                            (if ((n & s8"4"  ) ≠ s8"4"  ) n"0" else n"4"  ) +
                            (if ((n & s8"8"  ) ≠ s8"8"  ) n"0" else n"8"  ) +
                            (if ((n & s8"16" ) ≠ s8"16" ) n"0" else n"16" ) +
                            (if ((n & s8"32" ) ≠ s8"32" ) n"0" else n"32" ) +
                            (if ((n & s8"64" ) ≠ s8"64" ) n"0" else n"64" )   }"""

  @native
  @pure def toN8(n: S8): N8 =
    c"""{ requires n ≥ s8"0"
          ensures  N8.toZ(result) = toZ(n) }"""

  @native
  @pure def toN16(n: S8): N16 =
    c"""{ requires n ≥ s8"0"
          ensures  N16.toZ(result) = toZ(n) }"""

  @native
  @pure def toN32(n: S8): N32 =
    c"""{ requires n ≥ s8"0"
          ensures  N32.toZ(result) = toZ(n) }"""

  @native
  @pure def toN64(n: S8): N64 =
    c"""{ requires n ≥ s8"0"
          ensures  N64.toZ(result) = toZ(n) }"""

  @native
  @pure def toS8(n: S8): S8 =
    c"""{ ensures result = n }"""

  @native /* @first */
  @pure def toS16(n: S8): S16 = $

  @native /* @first */
  @pure def toS32(n: S8): S32 = $

  @native /* @first */
  @pure def toS64(n: S8): S64 = $

  @native /* @first */
  @pure def toU8(n: S8): U8 =
    c"""{ requires n ≥ s8"0" }"""

  @native /* @first */
  @pure def toRawU8(n: S8): U8 = $

  @native /* @first */
  @pure def toU16(n: S8): U16 =
    c"""{ requires n ≥ s8"0" }"""

  @native /* @first */
  @pure def toU32(n: S8): U32 =
    c"""{ requires n ≥ s8"0" }"""

  @native /* @first */
  @pure def toU64(n: S8): U64 =
    c"""{ requires n ≥ s8"0" }"""
}


object S16 {
  val Max: S16 = s16"32767"

  val Min: S16 = s16"-32768"

  c"""{ invariant Max = s16"32767"
                  Min = s16"-32768" }"""

  @native def random: S16 = $

  @native
  @pure def toB(n: S16): B =
    c"""{ ensures result = (n ≠ s16"0") }"""

  @native
  @pure def toZ(n: S16): Z =
    c"""{ ensures result = if (n ≥ s16"0")
                               (if ((n & s16"1"    ) ≠ s16"1"    ) 0 else 1)     +
                               (if ((n & s16"2"    ) ≠ s16"2"    ) 0 else 2)     +
                               (if ((n & s16"4"    ) ≠ s16"4"    ) 0 else 4)     +
                               (if ((n & s16"8"    ) ≠ s16"8"    ) 0 else 8)     +
                               (if ((n & s16"16"   ) ≠ s16"16"   ) 0 else 16)    +
                               (if ((n & s16"32"   ) ≠ s16"32"   ) 0 else 32)    +
                               (if ((n & s16"64"   ) ≠ s16"64"   ) 0 else 64)    +
                               (if ((n & s16"128"  ) ≠ s16"128"  ) 0 else 128)   +
                               (if ((n & s16"256"  ) ≠ s16"256"  ) 0 else 256)   +
                               (if ((n & s16"512"  ) ≠ s16"512"  ) 0 else 512)   +
                               (if ((n & s16"1024" ) ≠ s16"1024" ) 0 else 1024)  +
                               (if ((n & s16"4096" ) ≠ s16"4096" ) 0 else 4096)  +
                               (if ((n & s16"8192" ) ≠ s16"8192" ) 0 else 8192)  +
                               (if ((n & s16"2048" ) ≠ s16"2048" ) 0 else 2048)  +
                               (if ((n & s16"16384") ≠ s16"16384") 0 else 16384)
                           else
                             -((if ((n & s16"1"    ) = s16"1"    ) 0 else 1)     +
                               (if ((n & s16"2"    ) = s16"2"    ) 0 else 2)     +
                               (if ((n & s16"4"    ) = s16"4"    ) 0 else 4)     +
                               (if ((n & s16"8"    ) = s16"8"    ) 0 else 8)     +
                               (if ((n & s16"16"   ) = s16"16"   ) 0 else 16)    +
                               (if ((n & s16"32"   ) = s16"32"   ) 0 else 32)    +
                               (if ((n & s16"64"   ) = s16"64"   ) 0 else 64)    +
                               (if ((n & s16"128"  ) = s16"128"  ) 0 else 128)   +
                               (if ((n & s16"256"  ) = s16"256"  ) 0 else 256)   +
                               (if ((n & s16"512"  ) = s16"512"  ) 0 else 512)   +
                               (if ((n & s16"1024" ) = s16"1024" ) 0 else 1024)  +
                               (if ((n & s16"4096" ) = s16"4096" ) 0 else 4096)  +
                               (if ((n & s16"8192" ) = s16"8192" ) 0 else 8192)  +
                               (if ((n & s16"2048" ) = s16"2048" ) 0 else 2048)  +
                               (if ((n & s16"16384") = s16"16384") 0 else 16384) + 1) }"""

  @native
  @pure def toZ8(n: S16): Z8 =
    c"""{ requires s16"-128" ≤ n ∧ n ≤ s16"127"
          ensures  Z8.toZ(result) = toZ(n)      }"""

  @native
  @pure def toZ16(n: S16): Z16 =
    c"""{ ensures Z16.toZ(result) = toZ(n) }"""

  @native
  @pure def toZ32(n: S16): Z32 =
    c"""{ ensures Z16.toZ(result) = toZ(n) }"""

  @native
  @pure def toZ64(n: S16): Z64 =
    c"""{ ensures Z16.toZ(result) = toZ(n) }"""

  @native
  @pure def toN(n: S16): N =
    c"""{ requires n ≥ s16"0"
          ensures  result = (if ((n & s16"1"    ) ≠ s16"1"    ) n"0" else n"1"    ) +
                            (if ((n & s16"2"    ) ≠ s16"2"    ) n"0" else n"2"    ) +
                            (if ((n & s16"4"    ) ≠ s16"4"    ) n"0" else n"4"    ) +
                            (if ((n & s16"8"    ) ≠ s16"8"    ) n"0" else n"8"    ) +
                            (if ((n & s16"16"   ) ≠ s16"16"   ) n"0" else n"16"   ) +
                            (if ((n & s16"32"   ) ≠ s16"32"   ) n"0" else n"32"   ) +
                            (if ((n & s16"64"   ) ≠ s16"64"   ) n"0" else n"64"   ) +
                            (if ((n & s16"128"  ) ≠ s16"128"  ) n"0" else n"128"  ) +
                            (if ((n & s16"256"  ) ≠ s16"256"  ) n"0" else n"256"  ) +
                            (if ((n & s16"512"  ) ≠ s16"512"  ) n"0" else n"512"  ) +
                            (if ((n & s16"1024" ) ≠ s16"1024" ) n"0" else n"1024" ) +
                            (if ((n & s16"4096" ) ≠ s16"4096" ) n"0" else n"4096" ) +
                            (if ((n & s16"8192" ) ≠ s16"8192" ) n"0" else n"8192" ) +
                            (if ((n & s16"2048" ) ≠ s16"2048" ) n"0" else n"2048" ) +
                            (if ((n & s16"16384") ≠ s16"16384") n"0" else n"16384")   }"""

  @native
  @pure def toN8(n: S16): N8 =
    c"""{ requires s16"0 ≤ n ∧ n ≤ s16"255"
          ensures  N8.toZ(result) = toZ(n)  }"""

  @native
  @pure def toN16(n: S16): N16 =
    c"""{ requires n ≥ s16"0"
          ensures  N16.toZ(result) = toZ(n) }"""

  @native
  @pure def toN32(n: S16): N32 =
    c"""{ requires n ≥ s16"0"
          ensures  N32.toZ(result) = toZ(n) }"""

  @native
  @pure def toN64(n: S16): N64 =
    c"""{ requires n ≥ s16"0"
          ensures  N64.toZ(result) = toZ(n) }"""

  @native /* @first */
  @pure def toS8(n: S16): S8 =
    c"""{ requires s16"-128" ≤ n ∧ n ≤ s16"127" }"""

  @native
  @pure def toS16(n: S16): S16 =
    c"""{ ensures result = n }"""

  @native /* @first */
  @pure def toS32(n: S16): S32 = $

  @native /* @first */
  @pure def toS64(n: S16): S64 = $

  @native /* @first */
  @pure def toU8(n: S16): U8 =
    c"""{ requires s16"0 ≤ n ∧ n ≤ s16"255" }"""

  @native /* @first */
  @pure def toU16(n: S16): U16 =
    c"""{ requires n ≥ s16"0" }"""

  @native /* @first */
  @pure def toRawU16(n: S16): U16 = $

  @native /* @first */
  @pure def toU32(n: S16): U32 =
    c"""{ requires n ≥ s16"0" }"""

  @native /* @first */
  @pure def toU64(n: S16): U64 =
    c"""{ requires n ≥ s16"0" }"""
}


object S32 {
  val Max: S32 = s32"2147483647"

  val Min: S32 = s32"-2147483648"

  c"""{ invariant Max = s32"2147483647"
                  Min = s32"-2147483648" }"""

  @native def random: S32 = $

  @native
  @pure def toB(n: S32): B =
    c"""{ ensures result = (n ≠ s32"0") }"""

  @native
  @pure def toZ(n: S32): Z =
    c"""{ ensures result = if (n ≥ s32"0")
                               (if ((n & s32"1"         ) ≠ s32"1"         ) 0 else 1         ) +
                               (if ((n & s32"2"         ) ≠ s32"2"         ) 0 else 2         ) +
                               (if ((n & s32"4"         ) ≠ s32"4"         ) 0 else 4         ) +
                               (if ((n & s32"8"         ) ≠ s32"8"         ) 0 else 8         ) +
                               (if ((n & s32"16"        ) ≠ s32"16"        ) 0 else 16        ) +
                               (if ((n & s32"32"        ) ≠ s32"32"        ) 0 else 32        ) +
                               (if ((n & s32"64"        ) ≠ s32"64"        ) 0 else 64        ) +
                               (if ((n & s32"128"       ) ≠ s32"128"       ) 0 else 128       ) +
                               (if ((n & s32"256"       ) ≠ s32"256"       ) 0 else 256       ) +
                               (if ((n & s32"512"       ) ≠ s32"512"       ) 0 else 512       ) +
                               (if ((n & s32"1024"      ) ≠ s32"1024"      ) 0 else 1024      ) +
                               (if ((n & s32"2048"      ) ≠ s32"2048"      ) 0 else 2048      ) +
                               (if ((n & s32"4096"      ) ≠ s32"4096"      ) 0 else 4096      ) +
                               (if ((n & s32"8192"      ) ≠ s32"8192"      ) 0 else 8192      ) +
                               (if ((n & s32"16384"     ) ≠ s32"16384"     ) 0 else 16384     ) +
                               (if ((n & s32"32768"     ) ≠ s32"32768"     ) 0 else 32768     ) +
                               (if ((n & s32"65536"     ) ≠ s32"65536"     ) 0 else 65536     ) +
                               (if ((n & s32"131072"    ) ≠ s32"131072"    ) 0 else 131072    ) +
                               (if ((n & s32"262144"    ) ≠ s32"262144"    ) 0 else 262144    ) +
                               (if ((n & s32"524288"    ) ≠ s32"524288"    ) 0 else 524288    ) +
                               (if ((n & s32"1048576"   ) ≠ s32"1048576"   ) 0 else 1048576   ) +
                               (if ((n & s32"2097152"   ) ≠ s32"2097152"   ) 0 else 2097152   ) +
                               (if ((n & s32"4194304"   ) ≠ s32"4194304"   ) 0 else 4194304   ) +
                               (if ((n & s32"8388608"   ) ≠ s32"8388608"   ) 0 else 8388608   ) +
                               (if ((n & s32"16777216"  ) ≠ s32"16777216"  ) 0 else 16777216  ) +
                               (if ((n & s32"33554432"  ) ≠ s32"33554432"  ) 0 else 33554432  ) +
                               (if ((n & s32"67108864"  ) ≠ s32"67108864"  ) 0 else 67108864  ) +
                               (if ((n & s32"134217728" ) ≠ s32"134217728" ) 0 else 134217728 ) +
                               (if ((n & s32"268435456" ) ≠ s32"268435456" ) 0 else 268435456 ) +
                               (if ((n & s32"536870912" ) ≠ s32"536870912" ) 0 else 536870912 ) +
                               (if ((n & s32"1073741824") ≠ s32"1073741824") 0 else 1073741824)
                           else
                             -((if ((n & s32"1"         ) = s32"1"         ) 0 else 1         ) +
                               (if ((n & s32"2"         ) = s32"2"         ) 0 else 2         ) +
                               (if ((n & s32"4"         ) = s32"4"         ) 0 else 4         ) +
                               (if ((n & s32"8"         ) = s32"8"         ) 0 else 8         ) +
                               (if ((n & s32"16"        ) = s32"16"        ) 0 else 16        ) +
                               (if ((n & s32"32"        ) = s32"32"        ) 0 else 32        ) +
                               (if ((n & s32"64"        ) = s32"64"        ) 0 else 64        ) +
                               (if ((n & s32"128"       ) = s32"128"       ) 0 else 128       ) +
                               (if ((n & s32"256"       ) = s32"256"       ) 0 else 256       ) +
                               (if ((n & s32"512"       ) = s32"512"       ) 0 else 512       ) +
                               (if ((n & s32"1024"      ) = s32"1024"      ) 0 else 1024      ) +
                               (if ((n & s32"2048"      ) = s32"2048"      ) 0 else 2048      ) +
                               (if ((n & s32"4096"      ) = s32"4096"      ) 0 else 4096      ) +
                               (if ((n & s32"8192"      ) = s32"8192"      ) 0 else 8192      ) +
                               (if ((n & s32"16384"     ) = s32"16384"     ) 0 else 16384     ) +
                               (if ((n & s32"32768"     ) = s32"32768"     ) 0 else 32768     ) +
                               (if ((n & s32"65536"     ) = s32"65536"     ) 0 else 65536     ) +
                               (if ((n & s32"131072"    ) = s32"131072"    ) 0 else 131072    ) +
                               (if ((n & s32"262144"    ) = s32"262144"    ) 0 else 262144    ) +
                               (if ((n & s32"524288"    ) = s32"524288"    ) 0 else 524288    ) +
                               (if ((n & s32"1048576"   ) = s32"1048576"   ) 0 else 1048576   ) +
                               (if ((n & s32"2097152"   ) = s32"2097152"   ) 0 else 2097152   ) +
                               (if ((n & s32"4194304"   ) = s32"4194304"   ) 0 else 4194304   ) +
                               (if ((n & s32"8388608"   ) = s32"8388608"   ) 0 else 8388608   ) +
                               (if ((n & s32"16777216"  ) = s32"16777216"  ) 0 else 16777216  ) +
                               (if ((n & s32"33554432"  ) = s32"33554432"  ) 0 else 33554432  ) +
                               (if ((n & s32"67108864"  ) = s32"67108864"  ) 0 else 67108864  ) +
                               (if ((n & s32"134217728" ) = s32"134217728" ) 0 else 134217728 ) +
                               (if ((n & s32"268435456" ) = s32"268435456" ) 0 else 268435456 ) +
                               (if ((n & s32"536870912" ) = s32"536870912" ) 0 else 536870912 ) +
                               (if ((n & s32"1073741824") = s32"1073741824") 0 else 1073741824) + 1) }"""

  @native
  @pure def toZ8(n: S32): Z8 =
    c"""{ requires s32"-128" ≤ n ∧ s32"n ≤ 127"
          ensures  Z8.toZ(result) = toZ(n)      }"""

  @native
  @pure def toZ16(n: S32): Z16 =
    c"""{ requires s32"-32768" ≤ n ∧ s32"n ≤ 32767"
          ensures  Z16.toZ(result) = toZ(n)         }"""

  @native
  @pure def toZ32(n: S32): Z32 =
    c"""{ ensures  Z32.toZ(result) = toZ(n) }"""

  @native
  @pure def toZ64(n: S32): Z64 =
    c"""{ ensures  Z64.toZ(result) = toZ(n) }"""

  @native
  @pure def toN(n: S32): N =
    c"""{ requires n ≥ s32"0"
          ensures  result = (if ((n & s32"1"         ) ≠ s32"1"         ) n"0" else n"1"         ) +
                            (if ((n & s32"2"         ) ≠ s32"2"         ) n"0" else n"2"         ) +
                            (if ((n & s32"4"         ) ≠ s32"4"         ) n"0" else n"4"         ) +
                            (if ((n & s32"8"         ) ≠ s32"8"         ) n"0" else n"8"         ) +
                            (if ((n & s32"16"        ) ≠ s32"16"        ) n"0" else n"16"        ) +
                            (if ((n & s32"32"        ) ≠ s32"32"        ) n"0" else n"32"        ) +
                            (if ((n & s32"64"        ) ≠ s32"64"        ) n"0" else n"64"        ) +
                            (if ((n & s32"128"       ) ≠ s32"128"       ) n"0" else n"128"       ) +
                            (if ((n & s32"256"       ) ≠ s32"256"       ) n"0" else n"256"       ) +
                            (if ((n & s32"512"       ) ≠ s32"512"       ) n"0" else n"512"       ) +
                            (if ((n & s32"1024"      ) ≠ s32"1024"      ) n"0" else n"1024"      ) +
                            (if ((n & s32"2048"      ) ≠ s32"2048"      ) n"0" else n"2048"      ) +
                            (if ((n & s32"4096"      ) ≠ s32"4096"      ) n"0" else n"4096"      ) +
                            (if ((n & s32"8192"      ) ≠ s32"8192"      ) n"0" else n"8192"      ) +
                            (if ((n & s32"16384"     ) ≠ s32"16384"     ) n"0" else n"16384"     ) +
                            (if ((n & s32"32768"     ) ≠ s32"32768"     ) n"0" else n"32768"     ) +
                            (if ((n & s32"65536"     ) ≠ s32"65536"     ) n"0" else n"65536"     ) +
                            (if ((n & s32"131072"    ) ≠ s32"131072"    ) n"0" else n"131072"    ) +
                            (if ((n & s32"262144"    ) ≠ s32"262144"    ) n"0" else n"262144"    ) +
                            (if ((n & s32"524288"    ) ≠ s32"524288"    ) n"0" else n"524288"    ) +
                            (if ((n & s32"1048576"   ) ≠ s32"1048576"   ) n"0" else n"1048576"   ) +
                            (if ((n & s32"2097152"   ) ≠ s32"2097152"   ) n"0" else n"2097152"   ) +
                            (if ((n & s32"4194304"   ) ≠ s32"4194304"   ) n"0" else n"4194304"   ) +
                            (if ((n & s32"8388608"   ) ≠ s32"8388608"   ) n"0" else n"8388608"   ) +
                            (if ((n & s32"16777216"  ) ≠ s32"16777216"  ) n"0" else n"16777216"  ) +
                            (if ((n & s32"33554432"  ) ≠ s32"33554432"  ) n"0" else n"33554432"  ) +
                            (if ((n & s32"67108864"  ) ≠ s32"67108864"  ) n"0" else n"67108864"  ) +
                            (if ((n & s32"134217728" ) ≠ s32"134217728" ) n"0" else n"134217728" ) +
                            (if ((n & s32"268435456" ) ≠ s32"268435456" ) n"0" else n"268435456" ) +
                            (if ((n & s32"536870912" ) ≠ s32"536870912" ) n"0" else n"536870912" ) +
                            (if ((n & s32"1073741824") ≠ s32"1073741824") n"0" else n"1073741824")   }"""

  @native
  @pure def toN8(n: S32): N8 =
    c"""{ requires s32"0" ≤ n ∧ n ≤ s32"255"
          ensures  N8.toZ(result) = toZ(n)   }"""

  @native
  @pure def toN16(n: S32): N16 =
    c"""{ requires s32"0" ≤ n ∧ n ≤ s32"65535"
          ensures  N16.toZ(result) = toZ(n)    }"""

  @native
  @pure def toN32(n: S32): N32 =
    c"""{ requires n ≥ s32"0"
          ensures  N32.toZ(result) = toZ(n) }"""

  @native
  @pure def toN64(n: S32): N64 =
    c"""{ requires n ≥ s32"0"
          ensures  N64.toZ(result) = toZ(n) }"""

  @native /* @first */
  @pure def toS8(n: S32): S8 =
    c"""{ requires s32"-128" ≤ n ∧ n ≤ s32"127" }"""

  @native /* @first */
  @pure def toS16(n: S32): S16 =
    c"""{ requires s32"-32768" ≤ n ∧ n ≤ s32"32767" }"""

  @native
  @pure def toS32(n: S32): S32 =
    c"""{ ensures result = n }"""

  @native /* @first */
  @pure def toS64(n: S32): S64 = $

  @native /* @first */
  @pure def toU8(n: S32): U8 =
    c"""{ requires s32"0" ≤ n ∧ n ≤ s32"255" }"""

  @native /* @first */
  @pure def toU16(n: S32): U16 =
    c"""{ requires s32"0" ≤ n ∧ n ≤ s32"65535" }"""

  @native /* @first */
  @pure def toU32(n: S32): U32 =
    c"""{ requires n ≥ s32"0" }"""

  @native /* @first */
  @pure def toRawU32(n: S32): U32 = $

  @native /* @first */
  @pure def toU64(n: S32): U64 =
    c"""{ requires n ≥ s32"0" }"""
}


object S64 {
  val Max: S64 = s64"9223372036854775807"

  val Min: S64 = s64"-9223372036854775808"

  c"""{ invariant Max = s64"9223372036854775807"
                  Min = s64"-9223372036854775808" }"""

  @native def random: S64 = $

  @native
  @pure def toB(n: S64): B =
    c"""{ ensures result = (n ≠ s64"0") }"""

  @native
  @pure def toZ(n: S64): Z =
    c"""{ ensures result = if (n ≥ s64"0")
                               (if ((n & s64"1"                  ) ≠ s64"1"                  ) 0 else 1                  ) +
                               (if ((n & s64"2"                  ) ≠ s64"2"                  ) 0 else 2                  ) +
                               (if ((n & s64"4"                  ) ≠ s64"4"                  ) 0 else 4                  ) +
                               (if ((n & s64"8"                  ) ≠ s64"8"                  ) 0 else 8                  ) +
                               (if ((n & s64"16"                 ) ≠ s64"16"                 ) 0 else 16                 ) +
                               (if ((n & s64"32"                 ) ≠ s64"32"                 ) 0 else 32                 ) +
                               (if ((n & s64"64"                 ) ≠ s64"64"                 ) 0 else 64                 ) +
                               (if ((n & s64"128"                ) ≠ s64"128"                ) 0 else 128                ) +
                               (if ((n & s64"256"                ) ≠ s64"256"                ) 0 else 256                ) +
                               (if ((n & s64"512"                ) ≠ s64"512"                ) 0 else 512                ) +
                               (if ((n & s64"1024"               ) ≠ s64"1024"               ) 0 else 1024               ) +
                               (if ((n & s64"2048"               ) ≠ s64"2048"               ) 0 else 2048               ) +
                               (if ((n & s64"4096"               ) ≠ s64"4096"               ) 0 else 4096               ) +
                               (if ((n & s64"8192"               ) ≠ s64"8192"               ) 0 else 8192               ) +
                               (if ((n & s64"16384"              ) ≠ s64"16384"              ) 0 else 16384              ) +
                               (if ((n & s64"32768"              ) ≠ s64"32768"              ) 0 else 32768              ) +
                               (if ((n & s64"65536"              ) ≠ s64"65536"              ) 0 else 65536              ) +
                               (if ((n & s64"131072"             ) ≠ s64"131072"             ) 0 else 131072             ) +
                               (if ((n & s64"262144"             ) ≠ s64"262144"             ) 0 else 262144             ) +
                               (if ((n & s64"524288"             ) ≠ s64"524288"             ) 0 else 524288             ) +
                               (if ((n & s64"1048576"            ) ≠ s64"1048576"            ) 0 else 1048576            ) +
                               (if ((n & s64"2097152"            ) ≠ s64"2097152"            ) 0 else 2097152            ) +
                               (if ((n & s64"4194304"            ) ≠ s64"4194304"            ) 0 else 4194304            ) +
                               (if ((n & s64"8388608"            ) ≠ s64"8388608"            ) 0 else 8388608            ) +
                               (if ((n & s64"16777216"           ) ≠ s64"16777216"           ) 0 else 16777216           ) +
                               (if ((n & s64"33554432"           ) ≠ s64"33554432"           ) 0 else 33554432           ) +
                               (if ((n & s64"67108864"           ) ≠ s64"67108864"           ) 0 else 67108864           ) +
                               (if ((n & s64"134217728"          ) ≠ s64"134217728"          ) 0 else 134217728          ) +
                               (if ((n & s64"268435456"          ) ≠ s64"268435456"          ) 0 else 268435456          ) +
                               (if ((n & s64"536870912"          ) ≠ s64"536870912"          ) 0 else 536870912          ) +
                               (if ((n & s64"1073741824"         ) ≠ s64"1073741824"         ) 0 else 1073741824         ) +
                               (if ((n & s64"2147483648"         ) ≠ s64"2147483648"         ) 0 else 2147483648         ) +
                               (if ((n & s64"4294967296"         ) ≠ s64"4294967296"         ) 0 else 4294967296         ) +
                               (if ((n & s64"8589934592"         ) ≠ s64"8589934592"         ) 0 else 8589934592         ) +
                               (if ((n & s64"17179869184"        ) ≠ s64"17179869184"        ) 0 else 17179869184        ) +
                               (if ((n & s64"34359738368"        ) ≠ s64"34359738368"        ) 0 else 34359738368        ) +
                               (if ((n & s64"68719476736"        ) ≠ s64"68719476736"        ) 0 else 68719476736        ) +
                               (if ((n & s64"137438953472"       ) ≠ s64"137438953472"       ) 0 else 137438953472       ) +
                               (if ((n & s64"274877906944"       ) ≠ s64"274877906944"       ) 0 else 274877906944       ) +
                               (if ((n & s64"549755813888"       ) ≠ s64"549755813888"       ) 0 else 549755813888       ) +
                               (if ((n & s64"1099511627776"      ) ≠ s64"1099511627776"      ) 0 else 1099511627776      ) +
                               (if ((n & s64"2199023255552"      ) ≠ s64"2199023255552"      ) 0 else 2199023255552      ) +
                               (if ((n & s64"4398046511104"      ) ≠ s64"4398046511104"      ) 0 else 4398046511104      ) +
                               (if ((n & s64"8796093022208"      ) ≠ s64"8796093022208"      ) 0 else 8796093022208      ) +
                               (if ((n & s64"17592186044416"     ) ≠ s64"17592186044416"     ) 0 else 17592186044416     ) +
                               (if ((n & s64"35184372088832"     ) ≠ s64"35184372088832"     ) 0 else 35184372088832     ) +
                               (if ((n & s64"70368744177664"     ) ≠ s64"70368744177664"     ) 0 else 70368744177664     ) +
                               (if ((n & s64"140737488355328"    ) ≠ s64"140737488355328"    ) 0 else 140737488355328    ) +
                               (if ((n & s64"281474976710656"    ) ≠ s64"281474976710656"    ) 0 else 281474976710656    ) +
                               (if ((n & s64"562949953421312"    ) ≠ s64"562949953421312"    ) 0 else 562949953421312    ) +
                               (if ((n & s64"1125899906842624"   ) ≠ s64"1125899906842624"   ) 0 else 1125899906842624   ) +
                               (if ((n & s64"2251799813685248"   ) ≠ s64"2251799813685248"   ) 0 else 2251799813685248   ) +
                               (if ((n & s64"4503599627370496"   ) ≠ s64"4503599627370496"   ) 0 else 4503599627370496   ) +
                               (if ((n & s64"9007199254740992"   ) ≠ s64"9007199254740992"   ) 0 else 9007199254740992   ) +
                               (if ((n & s64"18014398509481984"  ) ≠ s64"18014398509481984"  ) 0 else 18014398509481984  ) +
                               (if ((n & s64"36028797018963968"  ) ≠ s64"36028797018963968"  ) 0 else 36028797018963968  ) +
                               (if ((n & s64"72057594037927936"  ) ≠ s64"72057594037927936"  ) 0 else 72057594037927936  ) +
                               (if ((n & s64"144115188075855872" ) ≠ s64"144115188075855872" ) 0 else 144115188075855872 ) +
                               (if ((n & s64"288230376151711744" ) ≠ s64"288230376151711744" ) 0 else 288230376151711744 ) +
                               (if ((n & s64"576460752303423488" ) ≠ s64"576460752303423488" ) 0 else 576460752303423488 ) +
                               (if ((n & s64"1152921504606846976") ≠ s64"1152921504606846976") 0 else 1152921504606846976) +
                               (if ((n & s64"2305843009213693952") ≠ s64"2305843009213693952") 0 else 2305843009213693952) +
                               (if ((n & s64"4611686018427387904") ≠ s64"4611686018427387904") 0 else 4611686018427387904)
                           else
                             -((if ((n & s64"1"                  ) ≠ s64"1"                  ) 0 else 1                  ) +
                               (if ((n & s64"2"                  ) ≠ s64"2"                  ) 0 else 2                  ) +
                               (if ((n & s64"4"                  ) ≠ s64"4"                  ) 0 else 4                  ) +
                               (if ((n & s64"8"                  ) ≠ s64"8"                  ) 0 else 8                  ) +
                               (if ((n & s64"16"                 ) ≠ s64"16"                 ) 0 else 16                 ) +
                               (if ((n & s64"32"                 ) ≠ s64"32"                 ) 0 else 32                 ) +
                               (if ((n & s64"64"                 ) ≠ s64"64"                 ) 0 else 64                 ) +
                               (if ((n & s64"128"                ) ≠ s64"128"                ) 0 else 128                ) +
                               (if ((n & s64"256"                ) ≠ s64"256"                ) 0 else 256                ) +
                               (if ((n & s64"512"                ) ≠ s64"512"                ) 0 else 512                ) +
                               (if ((n & s64"1024"               ) ≠ s64"1024"               ) 0 else 1024               ) +
                               (if ((n & s64"2048"               ) ≠ s64"2048"               ) 0 else 2048               ) +
                               (if ((n & s64"4096"               ) ≠ s64"4096"               ) 0 else 4096               ) +
                               (if ((n & s64"8192"               ) ≠ s64"8192"               ) 0 else 8192               ) +
                               (if ((n & s64"16384"              ) ≠ s64"16384"              ) 0 else 16384              ) +
                               (if ((n & s64"32768"              ) ≠ s64"32768"              ) 0 else 32768              ) +
                               (if ((n & s64"65536"              ) ≠ s64"65536"              ) 0 else 65536              ) +
                               (if ((n & s64"131072"             ) ≠ s64"131072"             ) 0 else 131072             ) +
                               (if ((n & s64"262144"             ) ≠ s64"262144"             ) 0 else 262144             ) +
                               (if ((n & s64"524288"             ) ≠ s64"524288"             ) 0 else 524288             ) +
                               (if ((n & s64"1048576"            ) ≠ s64"1048576"            ) 0 else 1048576            ) +
                               (if ((n & s64"2097152"            ) ≠ s64"2097152"            ) 0 else 2097152            ) +
                               (if ((n & s64"4194304"            ) ≠ s64"4194304"            ) 0 else 4194304            ) +
                               (if ((n & s64"8388608"            ) ≠ s64"8388608"            ) 0 else 8388608            ) +
                               (if ((n & s64"16777216"           ) ≠ s64"16777216"           ) 0 else 16777216           ) +
                               (if ((n & s64"33554432"           ) ≠ s64"33554432"           ) 0 else 33554432           ) +
                               (if ((n & s64"67108864"           ) ≠ s64"67108864"           ) 0 else 67108864           ) +
                               (if ((n & s64"134217728"          ) ≠ s64"134217728"          ) 0 else 134217728          ) +
                               (if ((n & s64"268435456"          ) ≠ s64"268435456"          ) 0 else 268435456          ) +
                               (if ((n & s64"536870912"          ) ≠ s64"536870912"          ) 0 else 536870912          ) +
                               (if ((n & s64"1073741824"         ) ≠ s64"1073741824"         ) 0 else 1073741824         ) +
                               (if ((n & s64"2147483648"         ) ≠ s64"2147483648"         ) 0 else 2147483648         ) +
                               (if ((n & s64"4294967296"         ) ≠ s64"4294967296"         ) 0 else 4294967296         ) +
                               (if ((n & s64"8589934592"         ) ≠ s64"8589934592"         ) 0 else 8589934592         ) +
                               (if ((n & s64"17179869184"        ) ≠ s64"17179869184"        ) 0 else 17179869184        ) +
                               (if ((n & s64"34359738368"        ) ≠ s64"34359738368"        ) 0 else 34359738368        ) +
                               (if ((n & s64"68719476736"        ) ≠ s64"68719476736"        ) 0 else 68719476736        ) +
                               (if ((n & s64"137438953472"       ) ≠ s64"137438953472"       ) 0 else 137438953472       ) +
                               (if ((n & s64"274877906944"       ) ≠ s64"274877906944"       ) 0 else 274877906944       ) +
                               (if ((n & s64"549755813888"       ) ≠ s64"549755813888"       ) 0 else 549755813888       ) +
                               (if ((n & s64"1099511627776"      ) ≠ s64"1099511627776"      ) 0 else 1099511627776      ) +
                               (if ((n & s64"2199023255552"      ) ≠ s64"2199023255552"      ) 0 else 2199023255552      ) +
                               (if ((n & s64"4398046511104"      ) ≠ s64"4398046511104"      ) 0 else 4398046511104      ) +
                               (if ((n & s64"8796093022208"      ) ≠ s64"8796093022208"      ) 0 else 8796093022208      ) +
                               (if ((n & s64"17592186044416"     ) ≠ s64"17592186044416"     ) 0 else 17592186044416     ) +
                               (if ((n & s64"35184372088832"     ) ≠ s64"35184372088832"     ) 0 else 35184372088832     ) +
                               (if ((n & s64"70368744177664"     ) ≠ s64"70368744177664"     ) 0 else 70368744177664     ) +
                               (if ((n & s64"140737488355328"    ) ≠ s64"140737488355328"    ) 0 else 140737488355328    ) +
                               (if ((n & s64"281474976710656"    ) ≠ s64"281474976710656"    ) 0 else 281474976710656    ) +
                               (if ((n & s64"562949953421312"    ) ≠ s64"562949953421312"    ) 0 else 562949953421312    ) +
                               (if ((n & s64"1125899906842624"   ) ≠ s64"1125899906842624"   ) 0 else 1125899906842624   ) +
                               (if ((n & s64"2251799813685248"   ) ≠ s64"2251799813685248"   ) 0 else 2251799813685248   ) +
                               (if ((n & s64"4503599627370496"   ) ≠ s64"4503599627370496"   ) 0 else 4503599627370496   ) +
                               (if ((n & s64"9007199254740992"   ) ≠ s64"9007199254740992"   ) 0 else 9007199254740992   ) +
                               (if ((n & s64"18014398509481984"  ) ≠ s64"18014398509481984"  ) 0 else 18014398509481984  ) +
                               (if ((n & s64"36028797018963968"  ) ≠ s64"36028797018963968"  ) 0 else 36028797018963968  ) +
                               (if ((n & s64"72057594037927936"  ) ≠ s64"72057594037927936"  ) 0 else 72057594037927936  ) +
                               (if ((n & s64"144115188075855872" ) ≠ s64"144115188075855872" ) 0 else 144115188075855872 ) +
                               (if ((n & s64"288230376151711744" ) ≠ s64"288230376151711744" ) 0 else 288230376151711744 ) +
                               (if ((n & s64"576460752303423488" ) ≠ s64"576460752303423488" ) 0 else 576460752303423488 ) +
                               (if ((n & s64"1152921504606846976") ≠ s64"1152921504606846976") 0 else 1152921504606846976) +
                               (if ((n & s64"2305843009213693952") ≠ s64"2305843009213693952") 0 else 2305843009213693952) +
                               (if ((n & s64"4611686018427387904") ≠ s64"4611686018427387904") 0 else 4611686018427387904) + 1) }"""

  @native
  @pure def toZ8(n: S64): Z8 =
    c"""{ requires s64"-128" ≤ n ∧ s64"n ≤ 127"
          ensures  Z8.toZ(result) = toZ(n)      }"""

  @native
  @pure def toZ16(n: S64): Z16 =
    c"""{ requires s64"-32768" ≤ n ∧ s64"n ≤ 32767"
          ensures  Z16.toZ(result) = toZ(n)         }"""

  @native
  @pure def toZ32(n: S64): Z32 =
    c"""{ requires s64"-2147483648" ≤ n ∧ s64"n ≤ 2147483647"
          ensures  Z32.toZ(result) = toZ(n)                   }"""

  @native
  @pure def toZ64(n: S64): Z64 =
    c"""{ ensures  Z64.toZ(result) = toZ(n) }"""

  @native
  @pure def toN(n: S64): N =
    c"""{ requires n ≥ s64"0"
          ensures  result = (if ((n & s64"1"                  ) ≠ s64"1"                  ) n"0" else n"1"                  ) +
                            (if ((n & s64"2"                  ) ≠ s64"2"                  ) n"0" else n"2"                  ) +
                            (if ((n & s64"4"                  ) ≠ s64"4"                  ) n"0" else n"4"                  ) +
                            (if ((n & s64"8"                  ) ≠ s64"8"                  ) n"0" else n"8"                  ) +
                            (if ((n & s64"16"                 ) ≠ s64"16"                 ) n"0" else n"16"                 ) +
                            (if ((n & s64"32"                 ) ≠ s64"32"                 ) n"0" else n"32"                 ) +
                            (if ((n & s64"64"                 ) ≠ s64"64"                 ) n"0" else n"64"                 ) +
                            (if ((n & s64"128"                ) ≠ s64"128"                ) n"0" else n"128"                ) +
                            (if ((n & s64"256"                ) ≠ s64"256"                ) n"0" else n"256"                ) +
                            (if ((n & s64"512"                ) ≠ s64"512"                ) n"0" else n"512"                ) +
                            (if ((n & s64"1024"               ) ≠ s64"1024"               ) n"0" else n"1024"               ) +
                            (if ((n & s64"2048"               ) ≠ s64"2048"               ) n"0" else n"2048"               ) +
                            (if ((n & s64"4096"               ) ≠ s64"4096"               ) n"0" else n"4096"               ) +
                            (if ((n & s64"8192"               ) ≠ s64"8192"               ) n"0" else n"8192"               ) +
                            (if ((n & s64"16384"              ) ≠ s64"16384"              ) n"0" else n"16384"              ) +
                            (if ((n & s64"32768"              ) ≠ s64"32768"              ) n"0" else n"32768"              ) +
                            (if ((n & s64"65536"              ) ≠ s64"65536"              ) n"0" else n"65536"              ) +
                            (if ((n & s64"131072"             ) ≠ s64"131072"             ) n"0" else n"131072"             ) +
                            (if ((n & s64"262144"             ) ≠ s64"262144"             ) n"0" else n"262144"             ) +
                            (if ((n & s64"524288"             ) ≠ s64"524288"             ) n"0" else n"524288"             ) +
                            (if ((n & s64"1048576"            ) ≠ s64"1048576"            ) n"0" else n"1048576"            ) +
                            (if ((n & s64"2097152"            ) ≠ s64"2097152"            ) n"0" else n"2097152"            ) +
                            (if ((n & s64"4194304"            ) ≠ s64"4194304"            ) n"0" else n"4194304"            ) +
                            (if ((n & s64"8388608"            ) ≠ s64"8388608"            ) n"0" else n"8388608"            ) +
                            (if ((n & s64"16777216"           ) ≠ s64"16777216"           ) n"0" else n"16777216"           ) +
                            (if ((n & s64"33554432"           ) ≠ s64"33554432"           ) n"0" else n"33554432"           ) +
                            (if ((n & s64"67108864"           ) ≠ s64"67108864"           ) n"0" else n"67108864"           ) +
                            (if ((n & s64"134217728"          ) ≠ s64"134217728"          ) n"0" else n"134217728"          ) +
                            (if ((n & s64"268435456"          ) ≠ s64"268435456"          ) n"0" else n"268435456"          ) +
                            (if ((n & s64"536870912"          ) ≠ s64"536870912"          ) n"0" else n"536870912"          ) +
                            (if ((n & s64"1073741824"         ) ≠ s64"1073741824"         ) n"0" else n"1073741824"         ) +
                            (if ((n & s64"2147483648"         ) ≠ s64"2147483648"         ) n"0" else n"2147483648"         ) +
                            (if ((n & s64"4294967296"         ) ≠ s64"4294967296"         ) n"0" else n"4294967296"         ) +
                            (if ((n & s64"8589934592"         ) ≠ s64"8589934592"         ) n"0" else n"8589934592"         ) +
                            (if ((n & s64"17179869184"        ) ≠ s64"17179869184"        ) n"0" else n"17179869184"        ) +
                            (if ((n & s64"34359738368"        ) ≠ s64"34359738368"        ) n"0" else n"34359738368"        ) +
                            (if ((n & s64"68719476736"        ) ≠ s64"68719476736"        ) n"0" else n"68719476736"        ) +
                            (if ((n & s64"137438953472"       ) ≠ s64"137438953472"       ) n"0" else n"137438953472"       ) +
                            (if ((n & s64"274877906944"       ) ≠ s64"274877906944"       ) n"0" else n"274877906944"       ) +
                            (if ((n & s64"549755813888"       ) ≠ s64"549755813888"       ) n"0" else n"549755813888"       ) +
                            (if ((n & s64"1099511627776"      ) ≠ s64"1099511627776"      ) n"0" else n"1099511627776"      ) +
                            (if ((n & s64"2199023255552"      ) ≠ s64"2199023255552"      ) n"0" else n"2199023255552"      ) +
                            (if ((n & s64"4398046511104"      ) ≠ s64"4398046511104"      ) n"0" else n"4398046511104"      ) +
                            (if ((n & s64"8796093022208"      ) ≠ s64"8796093022208"      ) n"0" else n"8796093022208"      ) +
                            (if ((n & s64"17592186044416"     ) ≠ s64"17592186044416"     ) n"0" else n"17592186044416"     ) +
                            (if ((n & s64"35184372088832"     ) ≠ s64"35184372088832"     ) n"0" else n"35184372088832"     ) +
                            (if ((n & s64"70368744177664"     ) ≠ s64"70368744177664"     ) n"0" else n"70368744177664"     ) +
                            (if ((n & s64"140737488355328"    ) ≠ s64"140737488355328"    ) n"0" else n"140737488355328"    ) +
                            (if ((n & s64"281474976710656"    ) ≠ s64"281474976710656"    ) n"0" else n"281474976710656"    ) +
                            (if ((n & s64"562949953421312"    ) ≠ s64"562949953421312"    ) n"0" else n"562949953421312"    ) +
                            (if ((n & s64"1125899906842624"   ) ≠ s64"1125899906842624"   ) n"0" else n"1125899906842624"   ) +
                            (if ((n & s64"2251799813685248"   ) ≠ s64"2251799813685248"   ) n"0" else n"2251799813685248"   ) +
                            (if ((n & s64"4503599627370496"   ) ≠ s64"4503599627370496"   ) n"0" else n"4503599627370496"   ) +
                            (if ((n & s64"9007199254740992"   ) ≠ s64"9007199254740992"   ) n"0" else n"9007199254740992"   ) +
                            (if ((n & s64"18014398509481984"  ) ≠ s64"18014398509481984"  ) n"0" else n"18014398509481984"  ) +
                            (if ((n & s64"36028797018963968"  ) ≠ s64"36028797018963968"  ) n"0" else n"36028797018963968"  ) +
                            (if ((n & s64"72057594037927936"  ) ≠ s64"72057594037927936"  ) n"0" else n"72057594037927936"  ) +
                            (if ((n & s64"144115188075855872" ) ≠ s64"144115188075855872" ) n"0" else n"144115188075855872" ) +
                            (if ((n & s64"288230376151711744" ) ≠ s64"288230376151711744" ) n"0" else n"288230376151711744" ) +
                            (if ((n & s64"576460752303423488" ) ≠ s64"576460752303423488" ) n"0" else n"576460752303423488" ) +
                            (if ((n & s64"1152921504606846976") ≠ s64"1152921504606846976") n"0" else n"1152921504606846976") +
                            (if ((n & s64"2305843009213693952") ≠ s64"2305843009213693952") n"0" else n"2305843009213693952") +
                            (if ((n & s64"4611686018427387904") ≠ s64"4611686018427387904") n"0" else n"4611686018427387904")   }"""

  @native
  @pure def toN8(n: S64): N8 =
    c"""{ requires s64"0" ≤ n ∧ n ≤ s64"255"
          ensures  N8.toZ(result) = toZ(n)   }"""

  @native
  @pure def toN16(n: S64): N16 =
    c"""{ requires s64"0" ≤ n ∧ n ≤ s64"65535"
          ensures  N16.toZ(result) = toZ(n)    }"""

  @native
  @pure def toN32(n: S64): N32 =
    c"""{ requires s64"0" ≤ n ∧ n ≤ s64"4294967295"
          ensures  N32.toZ(result) = toZ(n)         }"""

  @native
  @pure def toN64(n: S64): N64 =
    c"""{ ensures N64.toZ(result) = toZ(n) }"""

  @native /* @first */
  @pure def toS8(n: S64): S8 =
    c"""{ requires s64"-128" ≤ n ∧ n ≤ s64"127" }"""

  @native /* @first */
  @pure def toS16(n: S64): S16 =
    c"""{ requires s64"-32768" ≤ n ∧ n ≤ s64"32767" }"""

  @native /* @first */
  @pure def toS32(n: S64): S32 =
    c"""{ requires s64"-2147483648" ≤ n ∧ n ≤ s64"2147483647" }"""

  @native
  @pure def toS64(n: S64): S64 =
    c"""{ ensures result = n }"""

  @native /* @first */
  @pure def toU8(n: S64): U8 =
    c"""{ requires s64"0" ≤ n ∧ n ≤ s64"255" }"""

  @native /* @first */
  @pure def toU16(n: S64): U16 =
    c"""{ requires s64"0" ≤ n ∧ n ≤ s64"65535" }"""

  @native /* @first */
  @pure def toU32(n: S64): U32 =
    c"""{ requires s64"0" ≤ n ∧ n ≤ s64"4294967295" }"""

  @native /* @first */
  @pure def toU64(n: S64): U64 =
    c"""{ requires n ≥ s64"0" }"""

  @native /* @first */
  @pure def toRawU64(n: S64): U64 = $
}


object U8 {
  val Max: U8 = u8"255"

  c"""{ invariant Max = u8"255" }"""

  @native def random: U8 = $

  @native
  @pure def toB(n: U8): B =
    c"""{ ensures result = (n ≠ u8"0") }"""

  @native
  @pure def toZ(n: U8): Z =
    c"""{ ensures result = (if ((n & u8"1"  ) ≠ u8"1"  ) 0 else 1  ) +
                           (if ((n & u8"2"  ) ≠ u8"2"  ) 0 else 2  ) +
                           (if ((n & u8"4"  ) ≠ u8"4"  ) 0 else 4  ) +
                           (if ((n & u8"8"  ) ≠ u8"8"  ) 0 else 8  ) +
                           (if ((n & u8"16" ) ≠ u8"16" ) 0 else 16 ) +
                           (if ((n & u8"32" ) ≠ u8"32" ) 0 else 32 ) +
                           (if ((n & u8"64" ) ≠ u8"64" ) 0 else 64 ) +
                           (if ((n & u8"128") ≠ u8"128") 0 else 128)   }"""

  @native
  @pure def toZ8(n: U8): Z8 =
    c"""{ requires n ≤ u8"127"
          ensures  Z8.toZ(result) = toZ(n) }"""

  @native
  @pure def toZ16(n: U8): Z16 =
    c"""{ ensures Z16.toZ(result) = toZ(n) }"""

  @native
  @pure def toZ32(n: U8): Z32 =
    c"""{ ensures Z32.toZ(result) = toZ(n) }"""

  @native
  @pure def toZ64(n: U8): Z64 =
    c"""{ ensures Z64.toZ(result) = toZ(n) }"""

  @native
  @pure def toN(n: U8): N =
    c"""{ ensures result = (if ((n & u8"1"  ) ≠ u8"1"  ) n"0" else n"1"  ) +
                           (if ((n & u8"2"  ) ≠ u8"2"  ) n"0" else n"2"  ) +
                           (if ((n & u8"4"  ) ≠ u8"4"  ) n"0" else n"4"  ) +
                           (if ((n & u8"8"  ) ≠ u8"8"  ) n"0" else n"8"  ) +
                           (if ((n & u8"16" ) ≠ u8"16" ) n"0" else n"16" ) +
                           (if ((n & u8"32" ) ≠ u8"32" ) n"0" else n"32" ) +
                           (if ((n & u8"64" ) ≠ u8"64" ) n"0" else n"64" ) +
                           (if ((n & u8"128") ≠ u8"128") n"0" else n"128")   }"""

  @native
  @pure def toN8(n: U8): N8 =
    c"""{ requires n ≤ u8"255"
          ensures  N8.toN(result) = toN(n) }"""

  @native
  @pure def toN16(n: U8): N16 =
    c"""{ ensures N16.toN(result) = toN(n) }"""

  @native
  @pure def toN32(n: U8): N32 =
    c"""{ ensures N32.toN(result) = toN(n) }"""

  @native
  @pure def toN64(n: U8): N64 =
    c"""{ ensures N64.toN(result) = toN(n) }"""

  @native /* @first */
  @pure def toS8(n: U8): S8 =
    c"""{ requires n ≤ u8"127" }"""

  @native /* @first */
  @pure def toRawS8(n: U8): S8 = $

  @native /* @first */
  @pure def toS16(n: U8): S16 = $

  @native /* @first */
  @pure def toS32(n: U8): S32 = $

  @native /* @first */
  @pure def toS64(n: U8): S64 = $

  @native
  @pure def toU8(n: U8): U8 =
    c"""{ ensures result = n }"""

  @native /* @first */
  @pure def toU16(n: U8): U16 = $

  @native /* @first */
  @pure def toU32(n: U8): U32 = $

  @native /* @first */
  @pure def toU64(n: U8): U64 = $
}


object U16 {
  val Max: U16 = u16"65535"

  c"""{ invariant Max = u16"65535" }"""

  @native def random: U16 = $

  @native
  @pure def toB(n: U16): B =
    c"""{ ensures result = (n ≠ u16"0") }"""

  @native
  @pure def toZ(n: U16): Z =
    c"""{ ensures result = (if ((n & u16"1"    ) ≠ u16"1"    ) 0 else 1    ) +
                           (if ((n & u16"2"    ) ≠ u16"2"    ) 0 else 2    ) +
                           (if ((n & u16"4"    ) ≠ u16"4"    ) 0 else 4    ) +
                           (if ((n & u16"8"    ) ≠ u16"8"    ) 0 else 8    ) +
                           (if ((n & u16"16"   ) ≠ u16"16"   ) 0 else 16   ) +
                           (if ((n & u16"32"   ) ≠ u16"32"   ) 0 else 32   ) +
                           (if ((n & u16"64"   ) ≠ u16"64"   ) 0 else 64   ) +
                           (if ((n & u16"128"  ) ≠ u16"128"  ) 0 else 128  ) +
                           (if ((n & u16"256"  ) ≠ u16"256"  ) 0 else 256  ) +
                           (if ((n & u16"512"  ) ≠ u16"512"  ) 0 else 512  ) +
                           (if ((n & u16"1024" ) ≠ u16"1024" ) 0 else 1024 ) +
                           (if ((n & u16"4096" ) ≠ u16"4096" ) 0 else 4096 ) +
                           (if ((n & u16"8192" ) ≠ u16"8192" ) 0 else 8192 ) +
                           (if ((n & u16"2048" ) ≠ u16"2048" ) 0 else 2048 ) +
                           (if ((n & u16"16384") ≠ u16"16384") 0 else 16384) +
                           (if ((n & u16"32768") ≠ u16"32768") 0 else 32768)   }"""

  @native
  @pure def toZ8(n: U16): Z8 =
    c"""{ requires n ≤ u16"127"
          ensures  Z8.toZ(result) = toZ(n) }"""

  @native
  @pure def toZ16(n: U16): Z16 =
    c"""{ requires n ≤ u16"32767"
          ensures  Z16.toZ(result) = toZ(n) }"""

  @native
  @pure def toZ32(n: U16): Z32 =
    c"""{ ensures Z32.toZ(result) = toZ(n) }"""

  @native
  @pure def toZ64(n: U16): Z64 =
    c"""{ ensures Z64.toZ(result) = toZ(n) }"""

  @native
  @pure def toN(n: U16): N =
    c"""{ ensures result = (if ((n & u16"1"    ) ≠ u16"1"    ) n"0" else n"1"    ) +
                           (if ((n & u16"2"    ) ≠ u16"2"    ) n"0" else n"2"    ) +
                           (if ((n & u16"4"    ) ≠ u16"4"    ) n"0" else n"4"    ) +
                           (if ((n & u16"8"    ) ≠ u16"8"    ) n"0" else n"8"    ) +
                           (if ((n & u16"16"   ) ≠ u16"16"   ) n"0" else n"16"   ) +
                           (if ((n & u16"32"   ) ≠ u16"32"   ) n"0" else n"32"   ) +
                           (if ((n & u16"64"   ) ≠ u16"64"   ) n"0" else n"64"   ) +
                           (if ((n & u16"128"  ) ≠ u16"128"  ) n"0" else n"128"  ) +
                           (if ((n & u16"256"  ) ≠ u16"256"  ) n"0" else n"256"  ) +
                           (if ((n & u16"512"  ) ≠ u16"512"  ) n"0" else n"512"  ) +
                           (if ((n & u16"1024" ) ≠ u16"1024" ) n"0" else n"1024" ) +
                           (if ((n & u16"4096" ) ≠ u16"4096" ) n"0" else n"4096" ) +
                           (if ((n & u16"8192" ) ≠ u16"8192" ) n"0" else n"8192" ) +
                           (if ((n & u16"2048" ) ≠ u16"2048" ) n"0" else n"2048" ) +
                           (if ((n & u16"16384") ≠ u16"16384") n"0" else n"16384") +
                           (if ((n & u16"32768") ≠ u16"32768") n"0" else n"32768")   }"""

  @native
  @pure def toN8(n: U16): N8 =
    c"""{ requires n ≤ u16"255"
          ensures  N8.toN(result) = toN(n) }"""

  @native
  @pure def toN16(n: U16): N16 =
    c"""{ requires n ≤ u16"65535"
          ensures  N16.toN(result) = toN(n) }"""

  @native
  @pure def toN32(n: U16): N32 =
    c"""{ ensures N32.toN(result) = toN(n) }"""

  @native
  @pure def toN64(n: U16): N64 =
    c"""{ ensures N64.toN(result) = toN(n) }"""

  @native /* @first */
  @pure def toS8(n: U16): S8 =
    c"""{ requires n ≤ u16"127" }"""

  @native /* @first */
  @pure def toS16(n: U16): S16 =
    c"""{ requires n ≤ u16"32767" }"""

  @native /* @first */
  @pure def toRawS16(n: U16): S16 = $

  @native /* @first */
  @pure def toS32(n: U16): S32 = $

  @native /* @first */
  @pure def toS64(n: U16): S64 = $

  @native /* @first */
  @pure def toU8(n: U16): U8 = $

  @native
  @pure def toU16(n: U16): U16 =
    c"""{ ensures result = n }"""

  @native /* @first */
  @pure def toU32(n: U16): U32 = $

  @native /* @first */
  @pure def toU64(n: U16): U64 = $
}


object U32 {
  val Max: U32 = u32"4294967295"

  c"""{ invariant Max = u32"4294967295" }"""

  @native def random: U32 = $

  @native
  @pure def toB(n: U32): B =
    c"""{ ensures result = (n ≠ u32"0") }"""

  @native
  @pure def toZ(n: U32): Z =
    c"""{ ensures result = (if ((n & u32"1"         ) ≠ u32"1"         ) 0 else 1         ) +
                           (if ((n & u32"2"         ) ≠ u32"2"         ) 0 else 2         ) +
                           (if ((n & u32"4"         ) ≠ u32"4"         ) 0 else 4         ) +
                           (if ((n & u32"8"         ) ≠ u32"8"         ) 0 else 8         ) +
                           (if ((n & u32"16"        ) ≠ u32"16"        ) 0 else 16        ) +
                           (if ((n & u32"32"        ) ≠ u32"32"        ) 0 else 32        ) +
                           (if ((n & u32"64"        ) ≠ u32"64"        ) 0 else 64        ) +
                           (if ((n & u32"128"       ) ≠ u32"128"       ) 0 else 128       ) +
                           (if ((n & u32"256"       ) ≠ u32"256"       ) 0 else 256       ) +
                           (if ((n & u32"512"       ) ≠ u32"512"       ) 0 else 512       ) +
                           (if ((n & u32"1024"      ) ≠ u32"1024"      ) 0 else 1024      ) +
                           (if ((n & u32"2048"      ) ≠ u32"2048"      ) 0 else 2048      ) +
                           (if ((n & u32"4096"      ) ≠ u32"4096"      ) 0 else 4096      ) +
                           (if ((n & u32"8192"      ) ≠ u32"8192"      ) 0 else 8192      ) +
                           (if ((n & u32"16384"     ) ≠ u32"16384"     ) 0 else 16384     ) +
                           (if ((n & u32"32768"     ) ≠ u32"32768"     ) 0 else 32768     ) +
                           (if ((n & u32"65536"     ) ≠ u32"65536"     ) 0 else 65536     ) +
                           (if ((n & u32"131072"    ) ≠ u32"131072"    ) 0 else 131072    ) +
                           (if ((n & u32"262144"    ) ≠ u32"262144"    ) 0 else 262144    ) +
                           (if ((n & u32"524288"    ) ≠ u32"524288"    ) 0 else 524288    ) +
                           (if ((n & u32"1048576"   ) ≠ u32"1048576"   ) 0 else 1048576   ) +
                           (if ((n & u32"2097152"   ) ≠ u32"2097152"   ) 0 else 2097152   ) +
                           (if ((n & u32"4194304"   ) ≠ u32"4194304"   ) 0 else 4194304   ) +
                           (if ((n & u32"8388608"   ) ≠ u32"8388608"   ) 0 else 8388608   ) +
                           (if ((n & u32"16777216"  ) ≠ u32"16777216"  ) 0 else 16777216  ) +
                           (if ((n & u32"33554432"  ) ≠ u32"33554432"  ) 0 else 33554432  ) +
                           (if ((n & u32"67108864"  ) ≠ u32"67108864"  ) 0 else 67108864  ) +
                           (if ((n & u32"134217728" ) ≠ u32"134217728" ) 0 else 134217728 ) +
                           (if ((n & u32"268435456" ) ≠ u32"268435456" ) 0 else 268435456 ) +
                           (if ((n & u32"536870912" ) ≠ u32"536870912" ) 0 else 536870912 ) +
                           (if ((n & u32"1073741824") ≠ u32"1073741824") 0 else 1073741824) +
                           (if ((n & u32"2147483648") ≠ u32"2147483648") 0 else 2147483648)   }"""

  @native
  @pure def toZ8(n: U32): Z8 =
    c"""{ requires n ≤ u32"127"
          ensures  Z8.toZ(result) = toZ(n) }"""

  @native
  @pure def toZ16(n: U32): Z16 =
    c"""{ requires n ≤ u32"32767"
          ensures  Z16.toZ(result) = toZ(n) }"""

  @native
  @pure def toZ32(n: U32): Z32 =
    c"""{ requires n ≤ u32"2147483647"
          ensures  Z32.toZ(result) = toZ(n) }"""

  @native
  @pure def toZ64(n: U32): Z64 =
    c"""{ ensures Z64.toZ(result) = toZ(n) }"""

  @native
  @pure def toN(n: U32): N =
    c"""{ ensures result = (if ((n & u32"1"         ) ≠ u32"1"         ) n"0" else n"1"         ) +
                           (if ((n & u32"2"         ) ≠ u32"2"         ) n"0" else n"2"         ) +
                           (if ((n & u32"4"         ) ≠ u32"4"         ) n"0" else n"4"         ) +
                           (if ((n & u32"8"         ) ≠ u32"8"         ) n"0" else n"8"         ) +
                           (if ((n & u32"16"        ) ≠ u32"16"        ) n"0" else n"16"        ) +
                           (if ((n & u32"32"        ) ≠ u32"32"        ) n"0" else n"32"        ) +
                           (if ((n & u32"64"        ) ≠ u32"64"        ) n"0" else n"64"        ) +
                           (if ((n & u32"128"       ) ≠ u32"128"       ) n"0" else n"128"       ) +
                           (if ((n & u32"256"       ) ≠ u32"256"       ) n"0" else n"256"       ) +
                           (if ((n & u32"512"       ) ≠ u32"512"       ) n"0" else n"512"       ) +
                           (if ((n & u32"1024"      ) ≠ u32"1024"      ) n"0" else n"1024"      ) +
                           (if ((n & u32"2048"      ) ≠ u32"2048"      ) n"0" else n"2048"      ) +
                           (if ((n & u32"4096"      ) ≠ u32"4096"      ) n"0" else n"4096"      ) +
                           (if ((n & u32"8192"      ) ≠ u32"8192"      ) n"0" else n"8192"      ) +
                           (if ((n & u32"16384"     ) ≠ u32"16384"     ) n"0" else n"16384"     ) +
                           (if ((n & u32"32768"     ) ≠ u32"32768"     ) n"0" else n"32768"     ) +
                           (if ((n & u32"65536"     ) ≠ u32"65536"     ) n"0" else n"65536"     ) +
                           (if ((n & u32"131072"    ) ≠ u32"131072"    ) n"0" else n"131072"    ) +
                           (if ((n & u32"262144"    ) ≠ u32"262144"    ) n"0" else n"262144"    ) +
                           (if ((n & u32"524288"    ) ≠ u32"524288"    ) n"0" else n"524288"    ) +
                           (if ((n & u32"1048576"   ) ≠ u32"1048576"   ) n"0" else n"1048576"   ) +
                           (if ((n & u32"2097152"   ) ≠ u32"2097152"   ) n"0" else n"2097152"   ) +
                           (if ((n & u32"4194304"   ) ≠ u32"4194304"   ) n"0" else n"4194304"   ) +
                           (if ((n & u32"8388608"   ) ≠ u32"8388608"   ) n"0" else n"8388608"   ) +
                           (if ((n & u32"16777216"  ) ≠ u32"16777216"  ) n"0" else n"16777216"  ) +
                           (if ((n & u32"33554432"  ) ≠ u32"33554432"  ) n"0" else n"33554432"  ) +
                           (if ((n & u32"67108864"  ) ≠ u32"67108864"  ) n"0" else n"67108864"  ) +
                           (if ((n & u32"134217728" ) ≠ u32"134217728" ) n"0" else n"134217728" ) +
                           (if ((n & u32"268435456" ) ≠ u32"268435456" ) n"0" else n"268435456" ) +
                           (if ((n & u32"536870912" ) ≠ u32"536870912" ) n"0" else n"536870912" ) +
                           (if ((n & u32"1073741824") ≠ u32"1073741824") n"0" else n"1073741824") +
                           (if ((n & u32"2147483648") ≠ u32"2147483648") n"0" else n"2147483648")   }"""

  @native
  @pure def toN8(n: U32): N8 =
    c"""{ requires n ≤ u32"255"
          ensures  N8.toN(result) = toN(n) }"""

  @native
  @pure def toN16(n: U32): N16 =
    c"""{ requires n ≤ u32"65535"
          ensures  N16.toN(result) = toN(n) }"""

  @native
  @pure def toN32(n: U32): N32 =
    c"""{ ensures N32.toN(result) = toN(n) }"""

  @native
  @pure def toN64(n: U32): N64 =
    c"""{ ensures N64.toN(result) = toN(n) }"""

  @native /* @first */
  @pure def toS8(n: U32): S8 =
    c"""{ requires n ≤ u32"127" }"""

  @native /* @first */
  @pure def toS16(n: U32): S16 =
    c"""{ requires n ≤ u32"32767" }"""

  @native /* @first */
  @pure def toS32(n: U32): S32 =
    c"""{ requires n ≤ u32"2147483647" }"""

  @native /* @first */
  @pure def toRawS32(n: U32): S32 = $

  @native /* @first */
  @pure def toS64(n: U32): S64 = $

  @native /* @first */
  @pure def toU8(n: U32): U8 =
    c"""{ requires n ≤ u32"255" }"""

  @native /* @first */
  @pure def toU16(n: U32): U16 =
    c"""{ requires n ≤ u32"65535" }"""

  @native
  @pure def toU32(n: U32): U32 =
    c"""{ ensures result = n }"""

  @native /* @first */
  @pure def toU64(n: U32): U64 = $

  @native /* @first */
  @pure def toRawF32(n: U32): F32 = $
}


object U64 {
  val Max: U64 = u64"18446744073709551615"

  c"""{ invariant Max = u64"18446744073709551615" }"""

  @native def random: U64 = $

  @native
  @pure def toB(n: U64): B =
    c"""{ ensures result = (n ≠ u64"0") }"""

  @native
  @pure def toZ(n: U64): Z =
    c"""{ ensures result = (if ((n & u64"1"                  ) ≠ u64"1"                  ) 0 else 1                  ) +
                           (if ((n & u64"2"                  ) ≠ u64"2"                  ) 0 else 2                  ) +
                           (if ((n & u64"4"                  ) ≠ u64"4"                  ) 0 else 4                  ) +
                           (if ((n & u64"8"                  ) ≠ u64"8"                  ) 0 else 8                  ) +
                           (if ((n & u64"16"                 ) ≠ u64"16"                 ) 0 else 16                 ) +
                           (if ((n & u64"32"                 ) ≠ u64"32"                 ) 0 else 32                 ) +
                           (if ((n & u64"64"                 ) ≠ u64"64"                 ) 0 else 64                 ) +
                           (if ((n & u64"128"                ) ≠ u64"128"                ) 0 else 128                ) +
                           (if ((n & u64"256"                ) ≠ u64"256"                ) 0 else 256                ) +
                           (if ((n & u64"512"                ) ≠ u64"512"                ) 0 else 512                ) +
                           (if ((n & u64"1024"               ) ≠ u64"1024"               ) 0 else 1024               ) +
                           (if ((n & u64"2048"               ) ≠ u64"2048"               ) 0 else 2048               ) +
                           (if ((n & u64"4096"               ) ≠ u64"4096"               ) 0 else 4096               ) +
                           (if ((n & u64"8192"               ) ≠ u64"8192"               ) 0 else 8192               ) +
                           (if ((n & u64"16384"              ) ≠ u64"16384"              ) 0 else 16384              ) +
                           (if ((n & u64"32768"              ) ≠ u64"32768"              ) 0 else 32768              ) +
                           (if ((n & u64"65536"              ) ≠ u64"65536"              ) 0 else 65536              ) +
                           (if ((n & u64"131072"             ) ≠ u64"131072"             ) 0 else 131072             ) +
                           (if ((n & u64"262144"             ) ≠ u64"262144"             ) 0 else 262144             ) +
                           (if ((n & u64"524288"             ) ≠ u64"524288"             ) 0 else 524288             ) +
                           (if ((n & u64"1048576"            ) ≠ u64"1048576"            ) 0 else 1048576            ) +
                           (if ((n & u64"2097152"            ) ≠ u64"2097152"            ) 0 else 2097152            ) +
                           (if ((n & u64"4194304"            ) ≠ u64"4194304"            ) 0 else 4194304            ) +
                           (if ((n & u64"8388608"            ) ≠ u64"8388608"            ) 0 else 8388608            ) +
                           (if ((n & u64"16777216"           ) ≠ u64"16777216"           ) 0 else 16777216           ) +
                           (if ((n & u64"33554432"           ) ≠ u64"33554432"           ) 0 else 33554432           ) +
                           (if ((n & u64"67108864"           ) ≠ u64"67108864"           ) 0 else 67108864           ) +
                           (if ((n & u64"134217728"          ) ≠ u64"134217728"          ) 0 else 134217728          ) +
                           (if ((n & u64"268435456"          ) ≠ u64"268435456"          ) 0 else 268435456          ) +
                           (if ((n & u64"536870912"          ) ≠ u64"536870912"          ) 0 else 536870912          ) +
                           (if ((n & u64"1073741824"         ) ≠ u64"1073741824"         ) 0 else 1073741824         ) +
                           (if ((n & u64"2147483648"         ) ≠ u64"2147483648"         ) 0 else 2147483648         ) +
                           (if ((n & u64"4294967296"         ) ≠ u64"4294967296"         ) 0 else 4294967296         ) +
                           (if ((n & u64"8589934592"         ) ≠ u64"8589934592"         ) 0 else 8589934592         ) +
                           (if ((n & u64"17179869184"        ) ≠ u64"17179869184"        ) 0 else 17179869184        ) +
                           (if ((n & u64"34359738368"        ) ≠ u64"34359738368"        ) 0 else 34359738368        ) +
                           (if ((n & u64"68719476736"        ) ≠ u64"68719476736"        ) 0 else 68719476736        ) +
                           (if ((n & u64"137438953472"       ) ≠ u64"137438953472"       ) 0 else 137438953472       ) +
                           (if ((n & u64"274877906944"       ) ≠ u64"274877906944"       ) 0 else 274877906944       ) +
                           (if ((n & u64"549755813888"       ) ≠ u64"549755813888"       ) 0 else 549755813888       ) +
                           (if ((n & u64"1099511627776"      ) ≠ u64"1099511627776"      ) 0 else 1099511627776      ) +
                           (if ((n & u64"2199023255552"      ) ≠ u64"2199023255552"      ) 0 else 2199023255552      ) +
                           (if ((n & u64"4398046511104"      ) ≠ u64"4398046511104"      ) 0 else 4398046511104      ) +
                           (if ((n & u64"8796093022208"      ) ≠ u64"8796093022208"      ) 0 else 8796093022208      ) +
                           (if ((n & u64"17592186044416"     ) ≠ u64"17592186044416"     ) 0 else 17592186044416     ) +
                           (if ((n & u64"35184372088832"     ) ≠ u64"35184372088832"     ) 0 else 35184372088832     ) +
                           (if ((n & u64"70368744177664"     ) ≠ u64"70368744177664"     ) 0 else 70368744177664     ) +
                           (if ((n & u64"140737488355328"    ) ≠ u64"140737488355328"    ) 0 else 140737488355328    ) +
                           (if ((n & u64"281474976710656"    ) ≠ u64"281474976710656"    ) 0 else 281474976710656    ) +
                           (if ((n & u64"562949953421312"    ) ≠ u64"562949953421312"    ) 0 else 562949953421312    ) +
                           (if ((n & u64"1125899906842624"   ) ≠ u64"1125899906842624"   ) 0 else 1125899906842624   ) +
                           (if ((n & u64"2251799813685248"   ) ≠ u64"2251799813685248"   ) 0 else 2251799813685248   ) +
                           (if ((n & u64"4503599627370496"   ) ≠ u64"4503599627370496"   ) 0 else 4503599627370496   ) +
                           (if ((n & u64"9007199254740992"   ) ≠ u64"9007199254740992"   ) 0 else 9007199254740992   ) +
                           (if ((n & u64"18014398509481984"  ) ≠ u64"18014398509481984"  ) 0 else 18014398509481984  ) +
                           (if ((n & u64"36028797018963968"  ) ≠ u64"36028797018963968"  ) 0 else 36028797018963968  ) +
                           (if ((n & u64"72057594037927936"  ) ≠ u64"72057594037927936"  ) 0 else 72057594037927936  ) +
                           (if ((n & u64"144115188075855872" ) ≠ u64"144115188075855872" ) 0 else 144115188075855872 ) +
                           (if ((n & u64"288230376151711744" ) ≠ u64"288230376151711744" ) 0 else 288230376151711744 ) +
                           (if ((n & u64"576460752303423488" ) ≠ u64"576460752303423488" ) 0 else 576460752303423488 ) +
                           (if ((n & u64"1152921504606846976") ≠ u64"1152921504606846976") 0 else 1152921504606846976) +
                           (if ((n & u64"2305843009213693952") ≠ u64"2305843009213693952") 0 else 2305843009213693952) +
                           (if ((n & u64"4611686018427387904") ≠ u64"4611686018427387904") 0 else 4611686018427387904) +
                           (if ((n & u64"9223372036854775808") ≠ u64"9223372036854775808") 0 else 9223372036854775808)   }"""

  @native
  @pure def toZ8(n: U64): Z8 =
    c"""{ requires n ≤ u64"127"
          ensures  Z8.toZ(result) = toZ(n) }"""

  @native
  @pure def toZ16(n: U64): Z16 =
    c"""{ requires n ≤ u64"32767"
          ensures  Z16.toZ(result) = toZ(n) }"""

  @native
  @pure def toZ32(n: U64): Z32 =
    c"""{ requires n ≤ u64"2147483647"
          ensures  Z32.toZ(result) = toZ(n) }"""

  @native
  @pure def toZ64(n: U64): Z64 =
    c"""{ requires n ≤ u64"9223372036854775807"
          ensures  Z64.toZ(result) = toZ(n) }"""

  @native
  @pure def toN(n: U64): N =
    c"""{ ensures result = (if ((n & u64"1"                  ) ≠ u64"1"                  ) n"0" else n"1"                  ) +
                           (if ((n & u64"2"                  ) ≠ u64"2"                  ) n"0" else n"2"                  ) +
                           (if ((n & u64"4"                  ) ≠ u64"4"                  ) n"0" else n"4"                  ) +
                           (if ((n & u64"8"                  ) ≠ u64"8"                  ) n"0" else n"8"                  ) +
                           (if ((n & u64"16"                 ) ≠ u64"16"                 ) n"0" else n"16"                 ) +
                           (if ((n & u64"32"                 ) ≠ u64"32"                 ) n"0" else n"32"                 ) +
                           (if ((n & u64"64"                 ) ≠ u64"64"                 ) n"0" else n"64"                 ) +
                           (if ((n & u64"128"                ) ≠ u64"128"                ) n"0" else n"128"                ) +
                           (if ((n & u64"256"                ) ≠ u64"256"                ) n"0" else n"256"                ) +
                           (if ((n & u64"512"                ) ≠ u64"512"                ) n"0" else n"512"                ) +
                           (if ((n & u64"1024"               ) ≠ u64"1024"               ) n"0" else n"1024"               ) +
                           (if ((n & u64"2048"               ) ≠ u64"2048"               ) n"0" else n"2048"               ) +
                           (if ((n & u64"4096"               ) ≠ u64"4096"               ) n"0" else n"4096"               ) +
                           (if ((n & u64"8192"               ) ≠ u64"8192"               ) n"0" else n"8192"               ) +
                           (if ((n & u64"16384"              ) ≠ u64"16384"              ) n"0" else n"16384"              ) +
                           (if ((n & u64"32768"              ) ≠ u64"32768"              ) n"0" else n"32768"              ) +
                           (if ((n & u64"65536"              ) ≠ u64"65536"              ) n"0" else n"65536"              ) +
                           (if ((n & u64"131072"             ) ≠ u64"131072"             ) n"0" else n"131072"             ) +
                           (if ((n & u64"262144"             ) ≠ u64"262144"             ) n"0" else n"262144"             ) +
                           (if ((n & u64"524288"             ) ≠ u64"524288"             ) n"0" else n"524288"             ) +
                           (if ((n & u64"1048576"            ) ≠ u64"1048576"            ) n"0" else n"1048576"            ) +
                           (if ((n & u64"2097152"            ) ≠ u64"2097152"            ) n"0" else n"2097152"            ) +
                           (if ((n & u64"4194304"            ) ≠ u64"4194304"            ) n"0" else n"4194304"            ) +
                           (if ((n & u64"8388608"            ) ≠ u64"8388608"            ) n"0" else n"8388608"            ) +
                           (if ((n & u64"16777216"           ) ≠ u64"16777216"           ) n"0" else n"16777216"           ) +
                           (if ((n & u64"33554432"           ) ≠ u64"33554432"           ) n"0" else n"33554432"           ) +
                           (if ((n & u64"67108864"           ) ≠ u64"67108864"           ) n"0" else n"67108864"           ) +
                           (if ((n & u64"134217728"          ) ≠ u64"134217728"          ) n"0" else n"134217728"          ) +
                           (if ((n & u64"268435456"          ) ≠ u64"268435456"          ) n"0" else n"268435456"          ) +
                           (if ((n & u64"536870912"          ) ≠ u64"536870912"          ) n"0" else n"536870912"          ) +
                           (if ((n & u64"1073741824"         ) ≠ u64"1073741824"         ) n"0" else n"1073741824"         ) +
                           (if ((n & u64"2147483648"         ) ≠ u64"2147483648"         ) n"0" else n"2147483648"         ) +
                           (if ((n & u64"4294967296"         ) ≠ u64"4294967296"         ) n"0" else n"4294967296"         ) +
                           (if ((n & u64"8589934592"         ) ≠ u64"8589934592"         ) n"0" else n"8589934592"         ) +
                           (if ((n & u64"17179869184"        ) ≠ u64"17179869184"        ) n"0" else n"17179869184"        ) +
                           (if ((n & u64"34359738368"        ) ≠ u64"34359738368"        ) n"0" else n"34359738368"        ) +
                           (if ((n & u64"68719476736"        ) ≠ u64"68719476736"        ) n"0" else n"68719476736"        ) +
                           (if ((n & u64"137438953472"       ) ≠ u64"137438953472"       ) n"0" else n"137438953472"       ) +
                           (if ((n & u64"274877906944"       ) ≠ u64"274877906944"       ) n"0" else n"274877906944"       ) +
                           (if ((n & u64"549755813888"       ) ≠ u64"549755813888"       ) n"0" else n"549755813888"       ) +
                           (if ((n & u64"1099511627776"      ) ≠ u64"1099511627776"      ) n"0" else n"1099511627776"      ) +
                           (if ((n & u64"2199023255552"      ) ≠ u64"2199023255552"      ) n"0" else n"2199023255552"      ) +
                           (if ((n & u64"4398046511104"      ) ≠ u64"4398046511104"      ) n"0" else n"4398046511104"      ) +
                           (if ((n & u64"8796093022208"      ) ≠ u64"8796093022208"      ) n"0" else n"8796093022208"      ) +
                           (if ((n & u64"17592186044416"     ) ≠ u64"17592186044416"     ) n"0" else n"17592186044416"     ) +
                           (if ((n & u64"35184372088832"     ) ≠ u64"35184372088832"     ) n"0" else n"35184372088832"     ) +
                           (if ((n & u64"70368744177664"     ) ≠ u64"70368744177664"     ) n"0" else n"70368744177664"     ) +
                           (if ((n & u64"140737488355328"    ) ≠ u64"140737488355328"    ) n"0" else n"140737488355328"    ) +
                           (if ((n & u64"281474976710656"    ) ≠ u64"281474976710656"    ) n"0" else n"281474976710656"    ) +
                           (if ((n & u64"562949953421312"    ) ≠ u64"562949953421312"    ) n"0" else n"562949953421312"    ) +
                           (if ((n & u64"1125899906842624"   ) ≠ u64"1125899906842624"   ) n"0" else n"1125899906842624"   ) +
                           (if ((n & u64"2251799813685248"   ) ≠ u64"2251799813685248"   ) n"0" else n"2251799813685248"   ) +
                           (if ((n & u64"4503599627370496"   ) ≠ u64"4503599627370496"   ) n"0" else n"4503599627370496"   ) +
                           (if ((n & u64"9007199254740992"   ) ≠ u64"9007199254740992"   ) n"0" else n"9007199254740992"   ) +
                           (if ((n & u64"18014398509481984"  ) ≠ u64"18014398509481984"  ) n"0" else n"18014398509481984"  ) +
                           (if ((n & u64"36028797018963968"  ) ≠ u64"36028797018963968"  ) n"0" else n"36028797018963968"  ) +
                           (if ((n & u64"72057594037927936"  ) ≠ u64"72057594037927936"  ) n"0" else n"72057594037927936"  ) +
                           (if ((n & u64"144115188075855872" ) ≠ u64"144115188075855872" ) n"0" else n"144115188075855872" ) +
                           (if ((n & u64"288230376151711744" ) ≠ u64"288230376151711744" ) n"0" else n"288230376151711744" ) +
                           (if ((n & u64"576460752303423488" ) ≠ u64"576460752303423488" ) n"0" else n"576460752303423488" ) +
                           (if ((n & u64"1152921504606846976") ≠ u64"1152921504606846976") n"0" else n"1152921504606846976") +
                           (if ((n & u64"2305843009213693952") ≠ u64"2305843009213693952") n"0" else n"2305843009213693952") +
                           (if ((n & u64"4611686018427387904") ≠ u64"4611686018427387904") n"0" else n"4611686018427387904") +
                           (if ((n & u64"9223372036854775808") ≠ u64"9223372036854775808") n"0" else n"9223372036854775808")   }"""

  @native
  @pure def toN8(n: U64): N8 =
    c"""{ requires n ≤ u64"255"
          ensures  N8.toN(result) = toN(n) }"""

  @native
  @pure def toN16(n: U64): N16 =
    c"""{ requires n ≤ u64"65535"
          ensures  N16.toN(result) = toN(n) }"""

  @native
  @pure def toN32(n: U64): N32 =
    c"""{ requires n ≤ u64"4294967295"
          ensures  N32.toN(result) = toN(n) }"""

  @native
  @pure def toN64(n: U64): N64 =
    c"""{ ensures N64.toN(result) = toN(n) }"""

  @native /* @first */
  @pure def toS8(n: U64): S8 =
    c"""{ requires n ≤ u64"127" }"""

  @native /* @first */
  @pure def toS16(n: U64): S16 =
    c"""{ requires n ≤ u64"32767" }"""

  @native /* @first */
  @pure def toS32(n: U64): S32 =
    c"""{ requires n ≤ u64"2147483647" }"""

  @native /* @first */
  @pure def toS64(n: U64): S64 =
    c"""{ requires n ≤ u64"9223372036854775807" }"""

  @native /* @first */
  @pure def toRawS64(n: U64): S64 = $

  @native /* @first */
  @pure def toU8(n: U64): U8 =
    c"""{ requires n ≤ u64"255" }"""

  @native /* @first */
  @pure def toU16(n: U64): U16 =
    c"""{ requires n ≤ u64"65535" }"""

  @native /* @first */
  @pure def toU32(n: U64): U32 =
    c"""{ requires n ≤ u64"4294967295" }"""

  @native /* @first */
  @pure def toU64(n: U64): U64 =
    c"""{ ensures result = n }"""

  @native /* @first */
  @pure def toRawF64(n: U64): F64 = $
}


object F32 {
  @native def random: F32 = $

  @native
  @pure def toB(n: F32): B =
    c"""{ ensures result = (n ≠ f32"0.0") }"""

  @native /* @first */
  @pure def toRawU32(n: F32): U32 = $

  @native
  @pure def toF32(n: F32): F32 =
    c"""{ ensures result = n }"""
}


object F64 {
  @native def random: F64 = $

  @native
  @pure def toB(n: F64): B =
    c"""{ ensures result = (n ≠ f64"0.0") }"""

  @native /* @first */
  @pure def toRawU64(n: F64): U64 = $

  @native
  @pure def toF64(n: F64): F64 =
    c"""{ ensures result = n }"""
}


object R {
  @native def random: R = $

  @native
  @pure def toB(n: R): B =
    c"""{ ensures result = (n ≠ r"0.0") }"""

  @native /* @first */
  @pure def toZ(n: R): Z = $

  @native /* @first */
  @pure def toN(n: R): N =
    c"""{ requires n ≥ r"0.0" }"""

  @native
  @pure def toR(n: R): R =
    c"""{ ensures result = n }"""
}

object SI {
  @native
  @pure def append[I, E](s: IS[I, E], e: E): IS[I, E] =
    c"""{ ensures result.size == s.size + 1
                  ∀i: (0 ..< result.size)  result(i) = s(i)
                  result(result.size - 1) = e               }"""

  @native
  @pure def prepend[I, E](s: IS[I, E], e: E): IS[I, E] =
    c"""{ ensures result.size == s.size + 1
                  ∀i: (1 ..< result.size)  result(i) = s(i - 1)
                  result(0) = e                                 }"""

  @native
  @pure def appends[I, E](s1: IS[I, E], s2: IS[I, E]): IS[I, E] =
    c"""{ ensures result.size == s1.size + s2.size
                  ∀i: (0 ..< s1.size)  result(i) = s1(i)
                  ∀i: (0 ..< s2.size)  result(s1.size + i) = s2(i) }"""

  @native
  @pure def toMS[I, E](s: IS[I, E]): MS[I, E] =
    c"""{ ensures result.size = s.size
                  ∀i: (0 ..< result.size)  result(i) = s(i) }"""

  @native
  @pure def chunk[I, E](s: IS[I, E], size: I): IS[I, IS[I, E]] =
    c"""{ requires s.size % size = 0
          ensures  result.size * size = s.size
                   ∀i: (0 ..< result.size)  result(i).size = size
                   ∀i: (0 ..< result.size)
                     ∀j: (0 ..< size)
                       s(i * result.size + j) = result(i)(j)      }"""

  @native
  @pure def drop[I, E](s: IS[I, E], size: I): IS[I, E] =
    c"""{ requires s.size ≥ size
          ensures  result.size = s.size - size
                   ∀i (0 ..< s.size - size)  result(i) = s(size + i) }"""

  c"""{ fact
          def foldLeftSpec[I, E, R](s: IS[I, E], f: (R, E) => R, init: R, i: I): R
          = init,                                      if i = 0               (base)
          = f(foldLeftSpec(s, f, init, i - 1), s(i)),  if 0 < i ∧ i < s.size  (rec)  }"""

  /* s = [0, 1, 2, 3]
     foldLeftSpec(s, f, init, 3) = f(foldLeftSpec(s, f, init, 2), s(3))
                                 = f(f(foldLeftSpec(s, f, init, 1), s(2)), s(3))
                                 = f(f(f(foldLeftSpec(s, f, init, 0), s(i1), s(2)), s(3))
                                 = f(f(f(init, s(i1)), s(2)), s(3)) */

  @native
  @pure def foldLeft[I, E, R](s: IS[I, E], @pure f: (R, E) => R, init: R): R =
    c"""{ ensures result = foldLeftSpec(s, f, init, s.size - 1) }"""

  c"""{ fact
          def foldRightSpec[I, E, R](s: IS[I, E], f: (R, E) => R, init: R, i: I): R
          = f(init, s(s.size - 1)),                                  if i = 0               (base)
          = f(foldRightSpec(s, f, init, i - 1), s(s.size - i - 1)),  if 1 < i ∧ i ≤ s.size  (rec)  }"""

  /* s = [0, 1, 2, 3]
     foldRightSpec(s, f, init, 3) = f(foldRightSpec(s, f, init, 2))), s(0))
                                  = f(f(foldRightSpec(s, f, init, 1)), s(1)), s(0))
                                  = f(f(f(foldRightSpec(s, f, init, 0), s(2)), s(1)), s(0))
                                  = f(f(f(f(init, s(3)), s(2)), s(1)), s(0)) */

  @native
  @pure def foldRight[I, E, R](s: IS[I, E], @pure f: (R, E) => R, init: R): R =
    c"""{ ensures result = foldRightSpec(s, f, init, s.size - 1) }"""

  @native
  @pure def map[I, E1, E2](s: IS[I, E2], @pure f: E1 => E2): IS[I, E2] =
    c"""{ ensures result.size = s.size
                  ∀i: (0 ..< result.size)  result(i) = f(s(i)) }"""

  @native
  @pure def take[I, E](s: IS[I, E], size: I): IS[I, E] =
    c"""{ requires s.size ≥ size
          ensures  result.size = size
                   ∀i: (0 ..< result.size)  result(i) = s(i) }"""

  @native
  @pure def fromU8[I](n: U8, @pure toI: U8 => I): IS[I, B] =
    c"""{ ensures result.size = toI(u8"8")
                  ∀i: (u8"0" .. u8"7")
                    result(toI(i)) = U8.toB(n & (u8"1" << (u8"7" - i))) }"""

  @native
  @pure def fromU16[I](n: U16, @pure toI: U16 => I): IS[I, B] =
    c"""{ ensures result.size = toI(u16"16")
                  ∀i: (u16"0" .. u16"15")
                    result(toI(i)) = U16.toB(n & (u16"1" << (u16"15" - i))) }"""

  @native
  @pure def fromU32[I](n: U32, @pure toI: U32 => I): IS[I, B] =
    c"""{ ensures result.size = toI(u32"32")
                  ∀i: (u32"0" .. u32"31")
                    result(toI(i)) = U32.toB(n & (u32"1" << (u32"31" - i))) }"""

  @native
  @pure def fromU64[I](n: U64, @pure toI: U64 => I): IS[I, B] =
    c"""{ ensures result.size = toI(u64"64")
                  ∀i: (u64"0" .. u64"63")
                    result(toI(i)) = U64.toB(n & (u64"1" << (u64"63" - i))) }"""

  @native
  @pure def toU8[I](s: IS[I, B], @pure toI: U8 => I): U8 =
    c"""{ requires s.size = toI(u8"8")
          ensures  ∀i: (u8"0" .. u8"7")
                     s(toI(i)) = U8.toB(result & (u8"1" << (u8"7" - i))) }"""

  @native
  @pure def toU16[I](s: IS[I, B], @pure toI: U16 => I): U16 =
    c"""{ requires s.size = toI(u16"16")
          ensures  ∀i: (u16"0" .. u16"15")
                     s(toI(i)) = U16.toB(result & (u16"1" << (u16"15" - i))) }"""

  @native
  @pure def toU32[I](s: IS[I, B], @pure toI: U32 => I): U32 =
    c"""{ requires s.size = toI(u32"32")
          ensures  ∀i: (u32"0" .. u32"31")
                     s(toI(i)) = U32.toB(result & (u32"1" << (u32"31" - i))) }"""

  @native
  @pure def toU64[I](s: IS[I, B], @pure toI: U64 => I): U64 =
    c"""{ requires s.size = toI(u64"64")
          ensures  ∀i: (u64"0" .. u64"63")
                     s(toI(i)) = U64.toB(result & (u64"1" << (u64"63" - i))) }"""
}

object SM {
  @native
  @pure def append[I, E](s: MS[I, E], e: E): MS[I, E] =
    c"""{ ensures result.size == s.size + 1
                  ∀i: (0 ..< result.size)  result(i) = s(i)
                  result(result.size - 1) = e               }"""

  @native
  @pure def prepend[I, E](s: MS[I, E], e: E): MS[I, E] =
    c"""{ ensures result.size == s.size + 1
                  ∀i: (1 ..< result.size)  result(i) = s(i - 1)
                  result(0) = e                                 }"""

  @native
  @pure def appends[I, E](s1: MS[I, E], s2: MS[I, E]): MS[I, E] =
    c"""{ ensures result.size == s1.size + s2.size
                  ∀i: (0 ..< s1.size)  result(i) = s1(i)
                  ∀i: (0 ..< s2.size)  result(s1.size + i) = s2(i) }"""

  @native
  @pure def toIS[I, E](s: MS[I, E]): IS[I, E] =
    c"""{ ensures result.size = s.size
                  ∀i: (0 ..< result.size)  result(i) = s(i) }"""

  @native
  @pure def chunk[I, E](s: MS[I, E], size: I): MS[I, MS[I, E]] =
    c"""{ requires s.size % size = 0
          ensures  result.size * size = s.size
                   ∀i: (0 ..< result.size)  result(i).size = size
                   ∀i: (0 ..< result.size)
                     ∀j: (0 ..< size)
                       s(i * result.size + j) = result(i)(j) }"""

  @native
  @pure def drop[I, E](s: MS[I, E], size: I): MS[I, E] =
    c"""{ requires s.size ≥ size
          ensures  result.size = s.size - size
                   ∀i (0 ..< s.size - size)  result(i) = s(size + i) }"""

  c"""{ fact
          def foldLeftSpec[I, E, R](s: MS[I, E], f: (R, E) => R, init: R, i: I): R
          = init,                                      if i = 0               (base)
          = f(foldLeftSpec(s, f, init, i - 1), s(i)),  if 0 < i ∧ i < s.size  (rec)  }"""

  @native
  @pure def foldLeft[I, E, R](s: MS[I, E], @pure f: (R, E), init: R): R =
    c"""{ ensures result = foldLeftSpec(s, f, init, s.size - 1) }"""

  c"""{ fact
          def foldRightSpec[I, E, R](s: MS[I, E], f: (R, E) => R, init: R, i: I): R
          = f(init, s(s.size - 1)),                                  if i = 0               (base)
          = f(foldRightSpec(s, f, init, i - 1), s(s.size - i - 1)),  if 1 < i ∧ i ≤ s.size  (rec)  }"""

  @native
  @pure def foldRight[I, E, R](s: MS[I, E], @pure f: (R, E), init: R): R =
    c"""{ ensures result = foldRightSpec(s, f, init, s.size - 1) }"""

  @native
  @pure def map[I, E1, E2](s: MS[I, E2], @pure f: E1 => E2): MS[I, E2] =
    c"""{ ensures result.size = s.size
                  ∀i: (0 ..< result.size)  result(i) = f(s(i)) }"""

  @native
  def transform[I, E1, E2](s: MS[I, E2], @pure f: E1 => E2): Unit =
    c"""{ modifies s
          ensures  s.size = s_in.size
                   ∀i: (0 ..< s.size)  s(i) = f(s_in(i)) }"""

  @native
  @pure def take[I, E](s: MS[I, E], size: I): MS[I, E] =
    c"""{ requires s.size ≥ size
          ensures  result.size = size
                   ∀i: (0 ..< result.size)  result(i) = s(i) }"""

  @native
  @pure def fromU8[I](n: U8, @pure toI: U8 => I): MS[I, B] =
    c"""{ ensures result.size = toI(u8"8")
                  ∀i: (u8"0" .. u8"7")
                    result(toI(i)) = U8.toB(n & (u8"1" << (u8"7" - i))) }"""

  @native
  @pure def fromU16[I](n: U16, @pure toI: U16 => I): MS[I, B] =
    c"""{ ensures result.size = toI(u16"16")
                  ∀i: (u16"0" .. u16"15")
                    result(toI(i)) = U16.toB(n & (u16"1" << (u16"15" - i))) }"""

  @native
  @pure def fromU32[I](n: U32, @pure toI: U32 => I): MS[I, B] =
    c"""{ ensures result.size = toI(u32"32")
                  ∀i: (u32"0" .. u32"31")
                    result(toI(i)) = U32.toB(n & (u32"1" << (u32"31" - i))) }"""

  @native
  @pure def fromU64[I](n: U64, @pure toI: U64 => I): MS[I, B] =
    c"""{ ensures result.size = toI(u64"64")
                  ∀i: (u64"0" .. u64"63")
                    result(toI(i)) = U64.toB(n & (u64"1" << (u64"63" - i))) }"""

  @native
  @pure def toU8[I](s: MS[I, B], @pure toI: U8 => I): U8 =
    c"""{ requires s.size = toI(u8"8")
          ensures  ∀i: (u8"0" .. u8"7")
                     s(toI(i)) = U8.toB(result & (u8"1" << (u8"7" - i))) }"""

  @native
  @pure def toU16[I](s: MS[I, B], @pure toI: U16 => I): U16 =
    c"""{ requires s.size = toI(u16"16")
          ensures  ∀i: (u16"0" .. u16"15")
                     s(toI(i)) = U16.toB(result & (u16"1" << (u16"15" - i))) }"""

  @native
  @pure def toU32[I](s: MS[I, B], @pure toI: U32 => I): U32 =
    c"""{ requires s.size = toI(u32"32")
          ensures  ∀i: (u32"0" .. u32"31")
                     s(toI(i)) = U32.toB(result & (u32"1" << (u32"31" - i))) }"""

  @native
  @pure def toU64[I](s: MS[I, B], @pure toI: U64 => I): U64 =
    c"""{ requires s.size = toI(u64"64")
          ensures  ∀i: (u64"0" .. u64"63")
                     s(toI(i)) = U64.toB(result & (u64"1" << (u64"63" - i))) }"""
}
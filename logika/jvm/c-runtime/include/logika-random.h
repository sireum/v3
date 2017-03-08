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

#ifndef LOGIKA_RANDOM_H
#define LOGIKA_RANDOM_H

#include <logika.h>

#ifndef L_RANDOM_SEQ_MAX
#define L_RANDOM_SEQ_MAX 1024
#endif

B L_random_B(void);

U8 L_random_U8(void);

U16 L_random_U16(void);

U32 L_random_U32(void);

U64 L_random_U64(void);

#define L_random_S8()  ((S8)  L_random_U8())

#define L_random_S16() ((S16) L_random_U16())

#define L_random_S32() ((S32) L_random_U32())

#define L_random_S64() ((S64) L_random_U64())

#define L_random_Z8()  ((Z8)  L_random_U8 ())

#define L_random_Z16() ((Z16) L_random_U16())

#define L_random_Z32() ((Z32) L_random_U32())

#define L_random_Z64() ((Z64) L_random_U64())

#define L_random_N8()  ((N8)  L_random_U8())

#define L_random_N16() ((N16) L_random_U16())

#define L_random_N32() ((N32) L_random_U32())

#define L_random_N64() ((N64) L_random_U64())

#define L_random_F32() ((F32) L_random_U32())

#define L_random_F64() ((F64) L_random_U64())

#if BIT_WIDTH == 0

Z L_random_Z(void);

#define L_random_N() L_random_Z()

#elif BIT_WIDTH == 8

#define L_random_Z() L_random_Z8()

#define L_random_N() L_random_N8()

#elif BIT_WIDTH == 16

#define L_random_Z() L_random_Z16()

#define L_random_N() L_random_N16()

#elif BIT_WIDTH == 32

#define L_random_Z() L_random_Z32()

#define L_random_N() L_random_N32()

#elif BIT_WIDTH == 64

#define L_random_Z() L_random_Z64()

#define L_random_N() L_random_N64()

#endif

ZS L_random_ZS(void);

#if BIT_WIDTH == 0

#define L_random_NS() L_random_ZS()

#else

NS L_random_NS(void);

#endif

S8S L_random_S8S(void);

S16S L_random_S16S(void);

S32S L_random_S32S(void);

S64S L_random_S64S(void);

U8S L_random_U8S(void);

U16S L_random_U16S(void);

U32S L_random_U32S(void);

U64S L_random_U64S(void);

#define L_random_Z8S()  L_random_S8S()

#define L_random_Z16S() L_random_S16S()

#define L_random_Z32S() L_random_S32S()

#define L_random_Z64S() L_random_S64S()

#define L_random_N8S()  L_random_U8S()

#define L_random_N16S() L_random_U16S()

#define L_random_N32S() L_random_U32S()

#define L_random_N64S() L_random_U64S()

F32S L_random_F32S(void);

F64S L_random_F64S(void);

#endif

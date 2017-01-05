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

#ifndef LOGIKA_IO_H
#define LOGIKA_IO_H

#include <stdlib.h>
#include <string.h>
#include <logika.h>

#ifndef L_RANDOM_SEQ_MAX
#define L_RANDOM_SEQ_MAX 1024
#endif

Z L_Z_read(const L_string msg);

Z8 L_Z8_random();

Z16 L_Z16_random();

Z32 L_Z32_random();

Z64 L_Z64_random();

#define L_N8_random() ((N8) L_Z8_random())

#define L_N16_random() ((N16) L_Z16_random())

#define L_N32_random() ((N32) L_Z32_random())

#define L_N64_random() ((N64) L_Z64_random())

#if BIT_WIDTH == 0

Z L_Z_random();
#define L_N_random() L_Z_random()

#elif BIT_WIDTH == 8

#define L_Z_random() L_Z8_random()
#define L_N_random() L_N8_random()

#elif BIT_WIDTH == 16

#define L_Z_random() L_Z16_random()
#define L_N_random() L_N16_random()

#elif BIT_WIDTH == 32

#define L_Z_random() L_Z32_random()
#define L_N_random() L_N64_random()

#elif BIT_WIDTH == 64

#define L_Z_random() L_Z64_random()
#define L_N_random() L_N64_random()

#endif

#define L_S8_random() L_Z8_random()

#define L_S16_random() L_Z16_random()

#define L_S32_random() L_Z32_random()

#define L_S64_random() L_Z64_random()

#define L_U8_random() ((U8) L_Z8_random())

#define L_U16_random() ((U16) L_Z16_random())

#define L_U32_random() ((U32) L_Z32_random())

#define L_U64_random() ((U64) L_Z64_random())

#define L_F32_random() ((F32) L_Z32_random())

#define L_F64_random() ((F64) L_Z64_random())

ZS L_ZS_random();

#if BIT_WIDTH == 0
#define L_NS_random() L_ZS_random()
#else
NS L_NS_random();
#endif

Z8S L_Z8S_random();

Z16S L_Z16S_random();

Z32S L_Z32S_random();

Z64S L_Z64S_random();

N8S L_N8S_random();

N16S L_N16S_random();

N32S L_N32S_random();

N64S L_N64S_random();

#define L_S8S_random() L_Z8S_random()

#define L_S16S_random() L_Z16S_random()

#define L_S32S_random() L_Z32S_random()

#define L_S64S_random() L_Z64S_random()

#define L_U8S_random() L_N8S_random()

#define L_U16S_random() L_N16S_random()

#define L_U32S_random() L_N32S_random()

#define L_U64S_random() L_N64S_random()

F32S L_F32S_random();

F64S L_F64S_random();

L_string L_Z_toString(const Z n);

void L_print(const int strNum, ...);

void L_println(const int strNum, ...);

#endif
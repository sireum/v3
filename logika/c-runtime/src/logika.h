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

#ifndef LOGIKA_H
#define LOGIKA_H

#ifdef LOGIKA_DEBUG
#include <assert.h>
#define L_assert(e) assert(e)
#else
#define L_assert(e)
#endif

#include <limits.h>
#include <stdbool.h>
#include <stdint.h>

#define L_string char *

#if BIT_WIDTH == 0
#include <gmp.h>
typedef struct Z {
  mpz_t data;
} Z;
typedef struct N {
  mpz_t data;
} N;
#elif BIT_WIDTH == 8
#define Z         int8_t
#define N         uint8_t
#define Z_C(c)    c
#define Z_L(c)    c
#elif BIT_WIDTH == 16
#define Z         int16_t
#define N         uint16_t
#define Z_C(c)    c
#define Z_L(c)    c
#elif BIT_WIDTH == 32
#define Z         int32_t
#define N         uint32_t
#define Z_C(c)    c
#define Z_L(c)    c
#elif BIT_WIDTH == 64
#define Z         int64_t
#define N         uint64_t
#if __WORDSIZE == 64
#define Z_C(c)  c ## L
#define Z_L(c)  c
#else
#define Z_C(c)  c ## LL
#define Z_L(c)  c ## L
#endif
#endif

#define B           bool
#define T           true
#define F           false

#define Z8          int8_t
#define Z8_Min      INT8_MIN
#define Z8_Max      INT8_MAX

#define Z16         int16_t
#define Z16_Min     INT16_MIN
#define Z16_Max     INT16_MAX

#define Z32         int32_t
#define Z32_Min     INT32_MIN
#define Z32_Max     INT32_MAX

#define Z64         int64_t
#define Z64_Min     INT64_MIN
#define Z64_Max     INT64_MAX

#define N8          uint8_t
#define N8_Min      0
#define N8_Max      UINT8_MAX

#define N16         uint16_t
#define N16_Min     0
#define N16_Max     UINT16_MAX

#define N32         uint32_t
#define N32_Min     0
#define N32_Max     UINT32_MAX

#define N64         uint64_t
#define N64_Min     0
#define N64_Max     UINT64_MAX

#define S8          int8_t
#define S8_Min      INT8_MIN
#define S8_Max      INT8_MAX

#define S16         int16_t
#define S16_Min     INT16_MIN
#define S16_Max     INT16_MAX

#define S32         int32_t
#define S32_Min     INT32_MIN
#define S32_Max     INT32_MAX

#define S64         int64_t
#define S64_Min     INT64_MIN
#define S64_Max     INT64_MAX

#define U8          uint8_t
#define U8_Min      UINT8_MIN
#define U8_Max      UINT8_MAX

#define U16         uint16_t
#define U16_Min     UINT16_MIN
#define U16_Max     UINT16_MAX

#define U32         uint32_t
#define U32_Min     UINT32_MIN
#define U32_Max     UINT32_MAX

#define U64         uint64_t
#define U64_Min     UINT64_MIN
#define U64_Max     UINT64_MAX

#define F32         float
#define F64         double

typedef struct {
  Z size;
  B *data;
} BS;

typedef struct {
  Z size;
  Z *data;
} ZS;

typedef struct {
  Z size;
  Z8 *data;
} Z8S;

typedef struct {
  Z size;
  Z16 *data;
} Z16S;

typedef struct {
  Z size;
  Z32 *data;
} Z32S;

typedef struct {
  Z size;
  Z64 *data;
} Z64S;

typedef struct {
  Z size;
  N *data;
} NS;

typedef struct {
  Z size;
  N8 *data;
} N8S;

typedef struct {
  Z size;
  N16 *data;
} N16S;

typedef struct {
  Z size;
  N32 *data;
} N32S;

typedef struct {
  Z size;
  N64 *data;
} N64S;

typedef struct {
  Z size;
  S8 *data;
} S8S;

typedef struct {
  Z size;
  S16 *data;
} S16S;

typedef struct {
  Z size;
  S32 *data;
} S32S;

typedef struct {
  Z size;
  S64 *data;
} S64S;

typedef struct {
  Z size;
  S8 *data;
} U8S;

typedef struct {
  Z size;
  S16 *data;
} U16S;

typedef struct {
  Z size;
  S32 *data;
} U32S;

typedef struct {
  Z size;
  S64 *data;
} U64S;

typedef struct {
  Z size;
  S32 *data;
} F32S;

typedef struct {
  Z size;
  F64 *data;
} F64S;

#if BIT_WIDTH == 0

Z L_Z_add(Z n, Z m);
Z L_Z_addl(Z n, Z m);
Z L_Z_addr(Z n, Z m);
Z L_Z_addlr(Z n, Z m);

Z L_Z_sub(Z n, Z m);
Z L_Z_subl(Z n, Z m);
Z L_Z_subr(Z n, Z m);
Z L_Z_sublr(Z n, Z m);

Z L_Z_mul(Z n, Z m);
Z L_Z_mull(Z n, Z m);
Z L_Z_mulr(Z n, Z m);
Z L_Z_mullr(Z n, Z m);

Z L_Z_div(Z n, Z m);
Z L_Z_divl(Z n, Z m);
Z L_Z_divr(Z n, Z m);
Z L_Z_divlr(Z n, Z m);

Z L_Z_rem(Z n, Z m);
Z L_Z_reml(Z n, Z m);
Z L_Z_remr(Z n, Z m);
Z L_Z_remlr(Z n, Z m);

N L_N_add(N n, N m);
N L_N_addl(N n, N m);
N L_N_addr(N n, N m);
N L_N_addlr(N n, N m);

N L_N_sub(N n, N m);
N L_N_subl(N n, N m);
N L_N_subr(N n, N m);
N L_N_sublr(N n, N m);

N L_N_mul(N n, N m);
N L_N_mull(N n, N m);
N L_N_mulr(N n, N m);
N L_N_mullr(N n, N m);

N L_N_div(N n, N m);
N L_N_divl(N n, N m);
N L_N_divr(N n, N m);
N L_N_divlr(N n, N m);

N L_N_rem(N n, N m);
N L_N_reml(N n, N m);
N L_N_remr(N n, N m);
N L_N_remlr(N n, N m);

#endif

#endif
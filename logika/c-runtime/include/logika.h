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

#include <stdbool.h>
#include <stddef.h>
#include <stdint.h>

#ifdef LOGIKA_SECURE_WIPE

#define L_av(p) asm volatile("": : "g" (p) :"memory")
#define L_wipe(p, n) { memset(p, 0, n); L_av(p); }
#define L_string_wipe(s) { memset(s, 0, strlen(s)); L_av(s); free(s); }
#else
#define L_av(p)
#define L_wipe(p, n)
#define L_string_wipe(s) free(s)
#endif

#define L_string char *

#if BIT_WIDTH == 0

#include <gmp.h>

typedef struct {
  mpz_t data;
} Z;

#define N Z

#elif BIT_WIDTH == 8

#define Z         int8_t
#define N         uint8_t

#elif BIT_WIDTH == 16

#define Z         int16_t
#define N         uint16_t

#elif BIT_WIDTH == 32

#define Z         int32_t
#define N         uint32_t

#elif BIT_WIDTH == 64

#define Z         int64_t
#define N         uint64_t

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

size_t L_Z_to_size_t(Z n);

typedef struct {
  size_t size;
  B *data;
} BS;

typedef struct {
  size_t size;
  Z *data;
} ZS;

typedef struct {
  size_t size;
  Z8 *data;
} Z8S;

typedef struct {
  size_t size;
  Z16 *data;
} Z16S;

typedef struct {
  size_t size;
  Z32 *data;
} Z32S;

typedef struct {
  size_t size;
  Z64 *data;
} Z64S;

typedef struct {
  size_t size;
  N *data;
} NS;

typedef struct {
  size_t size;
  N8 *data;
} N8S;

typedef struct {
  size_t size;
  N16 *data;
} N16S;

typedef struct {
  size_t size;
  N32 *data;
} N32S;

typedef struct {
  size_t size;
  N64 *data;
} N64S;

#define S8S Z8S
#define S16S Z16S
#define S32S Z32S
#define S64S Z64S

#define U8S N8S
#define U16S N16S
#define U32S N32S
#define U64S N64S

typedef struct {
  size_t size;
  F32 *data;
} F32S;

typedef struct {
  size_t size;
  F64 *data;
} F64S;

ZS L_ZS_create(size_t size, Z initialValue);

ZS L_ZS(int size, ...);

void L_Z_wipe(Z *n);

void L_ZS_wipe(ZS *ns);

#if BIT_WIDTH == 0

Z L_Z_si(long int n);

Z L_Z_ui(unsigned long int n);

Z L_Z_str(L_string n);

#define L_N_ui(n) L_Z_ui(n)

#define L_N_str(n) L_Z_str(n)

Z L_Z_neg(Z n);

Z L_Z_negf(Z n);

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

B L_Z_eq(Z n, Z m);

B L_Z_eql(Z n, Z m);

B L_Z_eqr(Z n, Z m);

B L_Z_eqlr(Z n, Z m);

B L_Z_lt(Z n, Z m);

B L_Z_ltl(Z n, Z m);

B L_Z_ltr(Z n, Z m);

B L_Z_ltlr(Z n, Z m);

B L_Z_gt(Z n, Z m);

B L_Z_gtl(Z n, Z m);

B L_Z_gtr(Z n, Z m);

B L_Z_gtlr(Z n, Z m);

#define L_Z_ne(n, m) !L_Z_eq(n, m)

#define L_Z_nel(n, m) !L_Z_eql(n, m)

#define L_Z_ner(n, m) !L_Z_eqr(n, m)

#define L_Z_nelr(n, m) !L_Z_eqlr(n, m)

#define L_Z_le(n, m) !L_Z_gt(n, m)

#define L_Z_lel(n, m) !L_Z_gtl(n, m)

#define L_Z_ler(n, m) !L_Z_gtr(n, m)

#define L_Z_lelr(n, m) !L_Z_gtlr(n, m)

#define L_Z_ge(n, m) !L_Z_lt(n, m)

#define L_Z_gel(n, m) !L_Z_ltl(n, m)

#define L_Z_ger(n, m) !L_Z_ltr(n, m)

#define L_Z_gelr(n, m) !L_Z_ltlr(n, m)

#define L_NS_create(size, initialValue) L_ZS_create(size, initialValue)

#define L_NS(size, args ...) L_ZS(size, args)

#define L_N_wipe(n) L_Z_wipe(n)

#define L_NS_wipe(n) L_ZS_wipe(n)

#else

NS L_NS_create(size_t size, N initialValue);

NS L_NS(int size, ...);

void L_N_wipe(N *n);

void L_NS_wipe(NS *ns);

#endif

void L_Z8_wipe(Z8 *n);

void L_Z16_wipe(Z16 *n);

void L_Z32_wipe(Z32 *n);

void L_Z64_wipe(Z64 *n);

#define L_N8_wipe(n) L_Z8_wipe((Z8 *) n)

#define L_N16_wipe(n) L_Z16_wipe((Z16 *) n)

#define L_N32_wipe(n) L_Z32_wipe((Z32 *) n)

#define L_N64_wipe(n) L_Z64_wipe((Z64 *) n)

#define L_S8_wipe(n) L_Z8_wipe((Z8 *) n)

#define L_S16_wipe(n) L_Z16_wipe((Z16 *) n)

#define L_S32_wipe(n) L_Z32_wipe((Z32 *) n)

#define L_S64_wipe(n) L_Z64_wipe((Z64 *) n)

#define L_U8_wipe(n) L_Z8_wipe((Z8 *) n)

#define L_U16_wipe(n) L_Z16_wipe((Z16 *) n)

#define L_U32_wipe(n) L_Z32_wipe((Z32 *) n)

#define L_U64_wipe(n) L_Z64_wipe((Z64 *) n)

#define L_F32_wipe(n) L_Z32_wipe((Z32 *) n)

#define L_F64_wipe(n) L_Z64_wipe((Z64 *) n)

Z8S L_Z8S_create(size_t size, Z8 initialValue);

Z8S L_Z8S(int size, ...);

Z16S L_Z16S_create(size_t size, Z16 initialValue);

Z16S L_Z16S(int size, ...);

Z32S L_Z32S_create(size_t size, Z32 initialValue);

Z32S L_Z32S(int size, ...);

Z64S L_Z64S_create(size_t size, Z64 initialValue);

Z64S L_Z64S(int size, ...);

N8S L_N8S_create(size_t size, N8 initialValue);

N8S L_N8S(int size, ...);

N16S L_N16S_create(size_t size, N16 initialValue);

N16S L_N16S(int size, ...);

N32S L_N32S_create(size_t size, N32 initialValue);

N32S L_N32S(int size, ...);

N64S L_N64S_create(size_t size, N64 initialValue);

N64S L_N64S(int size, ...);

#define L_S8S_create(size, initialValue) L_Z8S_create(size, initialValue)

#define L_S16S_create(size, initialValue) L_Z16S_create(size, initialValue)

#define L_S32S_create(size, initialValue) L_Z32S_create(size, initialValue)

#define L_S64S_create(size, initialValue) L_Z64S_create(size, initialValue)

#define L_U8S_create(size, initialValue) L_U8S_create(size, initialValue)

#define L_U16S_create(size, initialValue) L_U16S_create(size, initialValue)

#define L_U32S_create(size, initialValue) L_U32S_create(size, initialValue)

#define L_U64S_create(size, initialValue) L_U64S_create(size, initialValue)

F32S L_F32S_create(size_t size, F32 initialValue);

F64S L_F64S_create(size_t size, F64 initialValue);

void L_Z8S_wipe(Z8S *ns);

void L_Z16S_wipe(Z16S *ns);

void L_Z32S_wipe(Z32S *ns);

void L_Z64S_wipe(Z64S *ns);

void L_N8S_wipe(N8S *ns);

void L_N16S_wipe(N16S *ns);

void L_N32S_wipe(N32S *ns);

void L_N64S_wipe(N64S *ns);

#define L_S8S_wipe(ns) L_Z8S_wipe(ns)

#define L_S16S_wipe(ns) L_Z16S_wipe(ns)

#define L_S32S_wipe(ns) L_Z32S_wipe(ns)

#define L_S64S_wipe(ns) L_Z64S_wipe(ns)

#define L_U8S_wipe(ns) L_Z8S_wipe(ns)

#define L_U16S_wipe(ns) L_Z16S_wipe(ns)

#define L_U32S_wipe(ns) L_Z32S_wipe(ns)

#define L_U64S_wipe(ns) L_Z64S_wipe(ns)

void L_F32S_wipe(F32S *ns);

void L_F64S_wipe(F64S *ns);

#endif
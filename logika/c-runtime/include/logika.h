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


#include <assert.h>
#include <stdbool.h>
#include <stddef.h>
#include <stdint.h>


#ifdef LOGIKA_DEBUG
#define L_assert(e) assert(e)
#else
#define L_assert(e)
#endif


#ifdef LOGIKA_SECURE_WIPE
#define L_av(p) __asm__ __volatile__("": : "m" (p) :"memory")
#define L_wipe(p, n) { memset(p, 0, n); L_av(p); }
#define L_string_wipe(s) { memset(s, 0, strlen(s)); L_av(s); free(s); }
#else
#define L_av(p)
#define L_wipe(p, n)
#define L_string_wipe(s) free(s)
#endif


void *L_malloc(size_t size);

void *L_realloc(void *ptr, size_t size);


#if BIT_WIDTH == 0

#include <gmp.h>

typedef struct {
  mpz_t data;
} Z;

#define N Z

#define Z_LT_INT  false

#elif BIT_WIDTH == 8

typedef int8_t    Z;
typedef uint8_t   N;

#define Z_LT_INT  INT8_MAX < INT_MAX

#elif BIT_WIDTH == 16

typedef int16_t    Z;
typedef uint16_t   N;

#define Z_LT_INT  INT16_MAX < INT_MAX

#elif BIT_WIDTH == 32

typedef int32_t    Z;
typedef uint32_t   N;

#define Z_LT_INT  INT32_MAX < INT_MAX

#elif BIT_WIDTH == 64

typedef int64_t    Z;
typedef uint64_t   N;

#define Z_LT_INT  INT64_MAX < INT_MAX

#endif

typedef bool B;

#define T           true
#define F           false

typedef int8_t Z8;
#define Z8_Min      INT8_MIN
#define Z8_Max      INT8_MAX

typedef int16_t Z16;
#define Z16_Min     INT16_MIN
#define Z16_Max     INT16_MAX

typedef int32_t Z32;
#define Z32_Min     INT32_MIN
#define Z32_Max     INT32_MAX

typedef int64_t Z64;
#define Z64_Min     INT64_MIN
#define Z64_Max     INT64_MAX

typedef uint8_t N8;
#define N8_Min      0
#define N8_Max      UINT8_MAX

typedef uint16_t N16;
#define N16_Min     0
#define N16_Max     UINT16_MAX

typedef uint32_t N32;
#define N32_Min     0
#define N32_Max     UINT32_MAX

typedef uint64_t N64;
#define N64_Min     0
#define N64_Max     UINT64_MAX

typedef int8_t S8;
#define S8_Min      INT8_MIN
#define S8_Max      INT8_MAX

typedef int16_t S16;
#define S16_Min     INT16_MIN
#define S16_Max     INT16_MAX

typedef int32_t S32;
#define S32_Min     INT32_MIN
#define S32_Max     INT32_MAX

typedef int64_t S64;
#define S64_Min     INT64_MIN
#define S64_Max     INT64_MAX

typedef uint8_t U8;
#define U8_Min      UINT8_MIN
#define U8_Max      UINT8_MAX

typedef uint16_t U16;
#define U16_Min     UINT16_MIN
#define U16_Max     UINT16_MAX

typedef uint32_t U32;
#define U32_Min     UINT32_MIN
#define U32_Max     UINT32_MAX

typedef uint64_t U64;
#define U64_Min     UINT64_MIN
#define U64_Max     UINT64_MAX

typedef float F32;

typedef double F64;

size_t L_Z_to_size_t(Z n);

typedef struct {
  size_t size;
  B *data;
} BS;

typedef struct {
  size_t size;
  Z *data;
} ZS;

#if BIT_WIDTH == 0

typedef ZS NS;

#else

typedef struct {
  size_t size;
  N *data;
} NS;

#endif

typedef struct {
  size_t size;
  S8 *data;
} S8S;

typedef struct {
  size_t size;
  S16 *data;
} S16S;

typedef struct {
  size_t size;
  Z32 *data;
} S32S;

typedef struct {
  size_t size;
  Z64 *data;
} S64S;

typedef struct {
  size_t size;
  U8 *data;
} U8S;

typedef struct {
  size_t size;
  U16 *data;
} U16S;

typedef struct {
  size_t size;
  U32 *data;
} U32S;

typedef struct {
  size_t size;
  U64 *data;
} U64S;

typedef S8S Z8S;

typedef S16S Z16S;

typedef S32S Z32S;

typedef S64S Z64S;

typedef U8S N8S;

typedef U16S N16S;

typedef U32S N32S;

typedef U64S N64S;

typedef struct {
  size_t size;
  F32 *data;
} F32S;

typedef struct {
  size_t size;
  F64 *data;
} F64S;

Z L_Z_size_t(size_t n);

#if BIT_WIDTH == 0

Z L_Z_si(long int n);

Z L_Z_ui(unsigned long int n);

Z L_Z_str(char *n);

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

#endif


void L_U8_wipe(U8 *n);

void L_U16_wipe(U16 *n);

void L_U32_wipe(U32 *n);

void L_U64_wipe(U64 *n);

#define L_Z8_wipe(n) L_U8_wipe((U8 *) n)

#define L_Z16_wipe(n) L_U16_wipe((U16 *) n)

#define L_Z32_wipe(n) L_U32_wipe((U32 *) n)

#define L_Z64_wipe(n) L_U64_wipe((U64 *) n)

#define L_N8_wipe(n) L_U8_wipe((U8 *) n)

#define L_N16_wipe(n) L_U16_wipe((U16 *) n)

#define L_N32_wipe(n) L_U32_wipe((U32 *) n)

#define L_N64_wipe(n) L_U64_wipe((U64 *) n)

#define L_S8_wipe(n) L_U8_wipe((U8 *) n)

#define L_S16_wipe(n) L_U16_wipe((U16 *) n)

#define L_S32_wipe(n) L_U32_wipe((U32 *) n)

#define L_S64_wipe(n) L_U64_wipe((U64 *) n)

#define L_F32_wipe(n) L_U32_wipe((U32 *) n)

#define L_F64_wipe(n) L_U64_wipe((U64 *) n)

void L_Z_wipe(Z *n);

#if BIT_WIDTH == 0

#define L_N_wipe(n) L_Z_wipe(n)

#else

void L_N_wipe(N *n);

#endif


S8S L_S8S_create(size_t size, S8 initialValue);

S8S L_S8S(int size, ...);

S16S L_S16S_create(size_t size, S16 initialValue);

S16S L_S16S(int size, ...);

S32S L_S32S_create(size_t size, S32 initialValue);

S32S L_S32S(int size, ...);

S64S L_S64S_create(size_t size, S64 initialValue);

S64S L_S64S(int size, ...);

U8S L_U8S_create(size_t size, U8 initialValue);

U8S L_U8S(int size, ...);

U16S L_U16S_create(size_t size, U16 initialValue);

U16S L_U16S(int size, ...);

U32S L_U32S_create(size_t size, U32 initialValue);

U32S L_U32S(int size, ...);

U64S L_U64S_create(size_t size, U64 initialValue);

U64S L_U64S(int size, ...);

#define L_Z8S_create(size, initialValue) L_S8S_create(size, initialValue)

#define L_Z16S_create(size, initialValue) L_S16S_create(size, initialValue)

#define L_Z32S_create(size, initialValue) L_S32S_create(size, initialValue)

#define L_Z64S_create(size, initialValue) L_S64S_create(size, initialValue)

#define L_N8S_create(size, initialValue) L_U8S_create(size, initialValue)

#define L_N16S_create(size, initialValue) L_U16S_create(size, initialValue)

#define L_N32S_create(size, initialValue) L_U32S_create(size, initialValue)

#define L_N64S_create(size, initialValue) L_U64S_create(size, initialValue)

F32S L_F32S_create(size_t size, F32 initialValue);

F64S L_F64S_create(size_t size, F64 initialValue);

ZS L_ZS_create(size_t size, Z initialValue);

ZS L_ZS(int size, ...);

#if BIT_WIDTH == 0

#define L_NS_create(size, initialValue) L_ZS_create(size, initialValue)

#define L_NS(size, args ...) L_ZS(size, args)

#else

NS L_NS_create(size_t size, N initialValue);

NS L_NS(int size, ...);

#endif


S8S L_S8S_clone(S8S ns);

S16S L_S16S_clone(S16S ns);

S32S L_S32S_clone(S32S ns);

S64S L_S64S_clone(S64S ns);

U8S L_U8S_clone(U8S ns);

U16S L_U16S_clone(U16S ns);

U32S L_U32S_clone(U32S ns);

U64S L_U64S_clone(U64S ns);

F32S L_F32S_clone(F32S ns);

F64S L_F64S_clone(F64S ns);

#define L_Z8S_clone(ns) L_S8S_clone(ns)

#define L_Z16S_clone(ns) L_S16S_clone(ns)

#define L_Z32S_clone(ns) L_S32S_clone(ns)

#define L_Z64S_clone(ns) L_S64S_clone(ns)

#define L_N8S_clone(ns) L_U8S_clone(ns)

#define L_N16S_clone(ns) L_U16S_clone(ns)

#define L_N32S_clone(ns) L_U32S_clone(ns)

#define L_N64S_clone(ns) L_U64S_clone(ns)

#if BIT_WIDTH == 0

ZS L_ZS_clone(ZS ns);

#define L_NS_clone(ns) L_ZS_clone(ns)

#elif BIT_WIDTH == 8

#define L_ZS_clone(ns) L_S8S_clone(ns)

#define L_NS_clone(ns) L_U8S_clone(ns)

#elif BIT_WIDTH == 16

#define L_ZS_clone(ns) L_S16S_clone(ns)

#define L_NS_clone(ns) L_U16S_clone(ns)

#elif BIT_WIDTH == 32

#define L_ZS_clone(ns) L_S32S_clone(ns)

#define L_NS_clone(ns) L_U32S_clone(ns)

#elif BIT_WIDTH == 64

#define L_ZS_clone(ns) L_S64S_clone(ns)

#define L_NS_clone(ns) L_U64S_clone(ns)

#endif


S8S L_S8S_prepend(S8 n, S8S ns);

S8S L_S8S_prependf(S8 n, S8S ns);

S8S L_S8S_append(S8S ns, S8 n);

S8S L_S8S_appendf(S8S ns, S8 n);

S8S L_S8S_appends(S8S ns1, S8S ns2);

S8S L_S8S_appendsl(S8S ns1, S8S ns2);

S8S L_S8S_appendsr(S8S ns1, S8S ns2);

S8S L_S8S_appendslr(S8S ns1, S8S ns2);

S16S L_S16S_prepend(S16 n, S16S ns);

S16S L_S16S_prependf(S16 n, S16S ns);

S16S L_S16S_append(S16S ns, S16 n);

S16S L_S16S_appendf(S16S ns, S16 n);

S16S L_S16S_appends(S16S ns1, S16S ns2);

S16S L_S16S_appendsl(S16S ns1, S16S ns2);

S16S L_S16S_appendsr(S16S ns1, S16S ns2);

S16S L_S16S_appendslr(S16S ns1, S16S ns2);

S32S L_S32S_prepend(S32 n, S32S ns);

S32S L_S32S_prependf(S32 n, S32S ns);

S32S L_S32S_append(S32S ns, S32 n);

S32S L_S32S_appendf(S32S ns, S32 n);

S32S L_S32S_appends(S32S ns1, S32S ns2);

S32S L_S32S_appendsl(S32S ns1, S32S ns2);

S32S L_S32S_appendsr(S32S ns1, S32S ns2);

S32S L_S32S_appendslr(S32S ns1, S32S ns2);

S64S L_S64S_prepend(S64 n, S64S ns);

S64S L_S64S_prependf(S64 n, S64S ns);

S64S L_S64S_append(S64S ns, S64 n);

S64S L_S64S_appendf(S64S ns, S64 n);

S64S L_S64S_appends(S64S ns1, S64S ns2);

S64S L_S64S_appendsl(S64S ns1, S64S ns2);

S64S L_S64S_appendsr(S64S ns1, S64S ns2);

S64S L_S64S_appendslr(S64S ns1, S64S ns2);

U8S L_U8S_prepend(U8 n, U8S ns);

U8S L_U8S_prependf(U8 n, U8S ns);

U8S L_U8S_append(U8S ns, U8 n);

U8S L_U8S_appendf(U8S ns, U8 n);

U8S L_U8S_appends(U8S ns1, U8S ns2);

U8S L_U8S_appendsl(U8S ns1, U8S ns2);

U8S L_U8S_appendsr(U8S ns1, U8S ns2);

U8S L_U8S_appendslr(U8S ns1, U8S ns2);

U16S L_U16S_prepend(U16 n, U16S ns);

U16S L_U16S_prependf(U16 n, U16S ns);

U16S L_U16S_append(U16S ns, U16 n);

U16S L_U16S_appendf(U16S ns, U16 n);

U16S L_U16S_appends(U16S ns1, U16S ns2);

U16S L_U16S_appendsl(U16S ns1, U16S ns2);

U16S L_U16S_appendsr(U16S ns1, U16S ns2);

U16S L_U16S_appendslr(U16S ns1, U16S ns2);

U32S L_U32S_prepend(U32 n, U32S ns);

U32S L_U32S_prependf(U32 n, U32S ns);

U32S L_U32S_append(U32S ns, U32 n);

U32S L_U32S_appendf(U32S ns, U32 n);

U32S L_U32S_appends(U32S ns1, U32S ns2);

U32S L_U32S_appendsl(U32S ns1, U32S ns2);

U32S L_U32S_appendsr(U32S ns1, U32S ns2);

U32S L_U32S_appendslr(U32S ns1, U32S ns2);

U64S L_U64S_prepend(U64 n, U64S ns);

U64S L_U64S_prependf(U64 n, U64S ns);

U64S L_U64S_append(U64S ns, U64 n);

U64S L_U64S_appendf(U64S ns, U64 n);

U64S L_U64S_appends(U64S ns1, U64S ns2);

U64S L_U64S_appendsl(U64S ns1, U64S ns2);

U64S L_U64S_appendsr(U64S ns1, U64S ns2);

U64S L_U64S_appendslr(U64S ns1, U64S ns2);

#if BIT_WIDTH == 0

ZS L_ZS_prepend(Z n, ZS ns);

ZS L_ZS_prependf(Z n, ZS ns);

ZS L_ZS_append(ZS ns, Z n);

ZS L_ZS_appendf(ZS ns, Z n);

ZS L_ZS_appends(ZS ns1, ZS ns2);

ZS L_ZS_appendsl(ZS ns1, ZS ns2);

ZS L_ZS_appendsr(ZS ns1, ZS ns2);

ZS L_ZS_appendslr(ZS ns1, ZS ns2);

#define L_NS_prepend(n, ns) L_ZS_prepend(n, ns)

#define L_NS_prependf(n, ns) L_ZS_prependf(n, ns)

#define L_NS_append(ns, n) L_ZS_append(ns, n)

#define L_NS_appendf(ns, n) L_ZS_appendf(ns, n)

#define L_NS_appends(ns1, ns2) L_ZS_appends(ns1, ns2)

#define L_NS_appendsl(ns1, ns2) L_ZS_appendsl(ns1, ns2)

#define L_NS_appendsr(ns1, ns2) L_ZS_appendsr(ns1, ns2)

#define L_NS_appendslr(ns1, ns2) L_ZS_appendslr(ns1, ns2)

#elif BIT_WIDTH == 8

#define L_ZS_prepend(n, ns) L_S8S_prepend(n, ns)

#define L_ZS_prependf(n, ns) L_S8S_prependf(n, ns)

#define L_ZS_append(ns, n) L_S8S_append(ns, n)

#define L_ZS_appendf(ns, n) L_S8S_appendf(ns, n)

#define L_ZS_appends(ns1, ns2) L_S8S_appends(ns1, ns2)

#define L_ZS_appendsl(ns1, ns2) L_S8S_appendsl(ns1, ns2)

#define L_ZS_appendsr(ns1, ns2) L_S8S_appendsr(ns1, ns2)

#define L_ZS_appendslr(ns1, ns2) L_S8S_appendslr(ns1, ns2)

#define L_NS_prepend(n, ns) L_U8S_prepend(n, ns)

#define L_NS_prependf(n, ns) L_U8S_prependf(n, ns)

#define L_NS_append(ns, n) L_U8S_append(ns, n)

#define L_NS_appendf(ns, n) L_U8S_appendf(ns, n)

#define L_NS_appends(ns1, ns2) L_U8S_appends(ns1, ns2)

#define L_NS_appendsl(ns1, ns2) L_U8S_appendsl(ns1, ns2)

#define L_NS_appendsr(ns1, ns2) L_U8S_appendsr(ns1, ns2)

#define L_NS_appendslr(ns1, ns2) L_U8S_appendslr(ns1, ns2)

#elif BIT_WIDTH == 16

#define L_ZS_prepend(n, ns) L_S16S_prepend(n, ns)

#define L_ZS_prependf(n, ns) L_S16S_prependf(n, ns)

#define L_ZS_append(ns, n) L_S16S_append(ns, n)

#define L_ZS_appendf(ns, n) L_S16S_appendf(ns, n)

#define L_ZS_appends(ns1, ns2) L_S16S_appends(ns1, ns2)

#define L_ZS_appendsl(ns1, ns2) L_S16S_appendsl(ns1, ns2)

#define L_ZS_appendsr(ns1, ns2) L_S16S_appendsr(ns1, ns2)

#define L_ZS_appendslr(ns1, ns2) L_S16S_appendslr(ns1, ns2)

#define L_NS_prepend(n, ns) L_U16S_prepend(n, ns)

#define L_NS_prependf(n, ns) L_U16S_prependf(n, ns)

#define L_NS_append(ns, n) L_U16S_append(ns, n)

#define L_NS_appendf(ns, n) L_U16S_appendf(ns, n)

#define L_NS_appends(ns1, ns2) L_U16S_appends(ns1, ns2)

#define L_NS_appendsl(ns1, ns2) L_U16S_appendsl(ns1, ns2)

#define L_NS_appendsr(ns1, ns2) L_U16S_appendsr(ns1, ns2)

#define L_NS_appendslr(ns1, ns2) L_U16S_appendslr(ns1, ns2)

#elif BIT_WIDTH == 32

#define L_ZS_prepend(n, ns) L_S32S_prepend(n, ns)

#define L_ZS_prependf(n, ns) L_S32S_prependf(n, ns)

#define L_ZS_append(ns, n) L_S32S_append(ns, n)

#define L_ZS_appendf(ns, n) L_S32S_appendf(ns, n)

#define L_ZS_appends(ns1, ns2) L_S32S_appends(ns1, ns2)

#define L_ZS_appendsl(ns1, ns2) L_S32S_appendsl(ns1, ns2)

#define L_ZS_appendsr(ns1, ns2) L_S32S_appendsr(ns1, ns2)

#define L_ZS_appendslr(ns1, ns2) L_S32S_appendslr(ns1, ns2)

#define L_NS_prepend(n, ns) L_U32S_prepend(n, ns)

#define L_NS_prependf(n, ns) L_U32S_prependf(n, ns)

#define L_NS_append(ns, n) L_U32S_append(ns, n)

#define L_NS_appendf(ns, n) L_U32S_appendf(ns, n)

#define L_NS_appends(ns1, ns2) L_U32S_appends(ns1, ns2)

#define L_NS_appendsl(ns1, ns2) L_U32S_appendsl(ns1, ns2)

#define L_NS_appendsr(ns1, ns2) L_U32S_appendsr(ns1, ns2)

#define L_NS_appendslr(ns1, ns2) L_U32S_appendslr(ns1, ns2)

#elif BIT_WIDTH == 64

#define L_ZS_prepend(n, ns) L_S64S_prepend(n, ns)

#define L_ZS_prependf(n, ns) L_S64S_prependf(n, ns)

#define L_ZS_append(ns, n) L_S64S_append(ns, n)

#define L_ZS_appendf(ns, n) L_S64S_appendf(ns, n)

#define L_ZS_appends(ns1, ns2) L_S64S_appends(ns1, ns2)

#define L_ZS_appendsl(ns1, ns2) L_S64S_appendsl(ns1, ns2)

#define L_ZS_appendsr(ns1, ns2) L_S64S_appendsr(ns1, ns2)

#define L_ZS_appendslr(ns1, ns2) L_S64S_appendslr(ns1, ns2)

#define L_NS_prepend(n, ns) L_U64S_prepend(n, ns)

#define L_NS_prependf(n, ns) L_U64S_prependf(n, ns)

#define L_NS_append(ns, n) L_U64S_append(ns, n)

#define L_NS_appendf(ns, n) L_U64S_appendf(ns, n)

#define L_NS_appends(ns1, ns2) L_U64S_appends(ns1, ns2)

#define L_NS_appendsl(ns1, ns2) L_U64S_appendsl(ns1, ns2)

#define L_NS_appendsr(ns1, ns2) L_U64S_appendsr(ns1, ns2)

#define L_NS_appendslr(ns1, ns2) L_U64S_appendslr(ns1, ns2)

#endif

void L_S8S_wipe(S8S *ns);

void L_S16S_wipe(S16S *ns);

void L_S32S_wipe(S32S *ns);

void L_S64S_wipe(S64S *ns);

void L_U8S_wipe(U8S *ns);

void L_U16S_wipe(U16S *ns);

void L_U32S_wipe(U32S *ns);

void L_U64S_wipe(U64S *ns);

#define L_Z8S_wipe(ns) L_S8S_wipe(ns)

#define L_Z16S_wipe(ns) L_S16S_wipe(ns)

#define L_Z32S_wipe(ns) L_S32S_wipe(ns)

#define L_Z64S_wipe(ns) L_S64S_wipe(ns)

#define L_N8S_wipe(ns) L_U8S_wipe(ns)

#define L_N16S_wipe(ns) L_U16S_wipe(ns)

#define L_N32S_wipe(ns) L_U32S_wipe(ns)

#define L_N64S_wipe(ns) L_U64S_wipe(ns)

void L_F32S_wipe(F32S *ns);

void L_F64S_wipe(F64S *ns);

void L_ZS_wipe(ZS *ns);

#if BIT_WIDTH == 0

#define L_NS_wipe(n) L_ZS_wipe(n)

#else

void L_NS_wipe(NS *ns);

#endif

#endif
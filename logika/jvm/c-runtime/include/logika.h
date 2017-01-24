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


#include <stdbool.h>
#include <stddef.h>
#include <stdint.h>


#ifdef LOGIKA_DEBUG

#include <assert.h>

#define L_assert(e) assert(e)
#else
#define L_assert(e)
#endif


#ifdef LOGIKA_WIPE
#define L_av(p) __asm__ __volatile__("": : "m" (p) :"memory")
#define L_wipe(p, n) { memset(p, 0, n); L_av(p); }
#define L_wipex(x, n) { memset(&x, 0, n); L_av(x); }
#elif LOGIKA_DIRTY_WIPE
#define L_av(p) __asm__ __volatile__("": : "m" (p) :"memory")
void L_wipe(void *p, size_t n);
#define L_wipex(x, n) L_wipe(&x, n)
#else
#define L_av(p)
#define L_wipe(p, n)
#define L_wipex(x, n)
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
#define T true
#define F false

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

size_t L_Z2st(Z n);

#if BIT_WIDTH == 0
size_t L_Z2stf(Z n);
#else
#define L_Z2stf(n) L_Z2st(n)
#endif

Z L_st2Z(size_t n);

typedef struct {
  size_t size;
  size_t dataSize;
  size_t *data;
} BS;

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

#if BIT_WIDTH == 0

typedef struct {
  size_t size;
  Z *data;
} ZS;

typedef ZS NS;

#elif BIT_WIDTH == 8

typedef Z8S ZS;
typedef N8S NS;

#elif BIT_WIDTH == 16

typedef Z16S ZS;
typedef N16S NS;

#elif BIT_WIDTH == 32

typedef Z32S ZS;
typedef N32S NS;

#elif BIT_WIDTH == 64

typedef Z64S ZS;
typedef N64S NS;

#endif

typedef struct {
  size_t size;
  F32 *data;
} F32S;

typedef struct {
  size_t size;
  F64 *data;
} F64S;

#if BIT_WIDTH == 0

Z L_Zsi(long int n);

Z L_Zui(unsigned long int n);

Z L_Zstr(char *n);

#define L_Nui(n) L_Zui(n)

#define L_Nstr(n) L_Zstr(n)

Z L_neg_Z(Z n);

Z L_neg_Zf(Z n);

Z L_add_Z(Z n, Z m);

Z L_add_Zl(Z n, Z m);

Z L_add_Zr(Z n, Z m);

Z L_add_Zlr(Z n, Z m);

Z L_sub_Z(Z n, Z m);

Z L_sub_Zl(Z n, Z m);

Z L_sub_Zr(Z n, Z m);

Z L_sub_Zlr(Z n, Z m);

Z L_mul_Z(Z n, Z m);

Z L_mul_Zl(Z n, Z m);

Z L_mul_Zr(Z n, Z m);

Z L_mul_Zlr(Z n, Z m);

Z L_div_Z(Z n, Z m);

Z L_div_Zl(Z n, Z m);

Z L_div_Zr(Z n, Z m);

Z L_div_Zlr(Z n, Z m);

Z L_rem_Z(Z n, Z m);

Z L_rem_Zl(Z n, Z m);

Z L_rem_Zr(Z n, Z m);

Z L_rem_Zlr(Z n, Z m);

N L_add_N(N n, N m);

N L_add_Nl(N n, N m);

N L_add_Nr(N n, N m);

N L_add_Nlr(N n, N m);

N L_sub_N(N n, N m);

N L_sub_Nl(N n, N m);

N L_sub_Nr(N n, N m);

N L_sub_Nlr(N n, N m);

N L_mul_N(N n, N m);

N L_mul_Nl(N n, N m);

N L_mul_Nr(N n, N m);

N L_mul_Nlr(N n, N m);

N L_div_N(N n, N m);

N L_div_Nl(N n, N m);

N L_div_Nr(N n, N m);

N L_div_Nlr(N n, N m);

N L_rem_N(N n, N m);

N L_rem_Nl(N n, N m);

N L_rem_Nr(N n, N m);

N L_rem_Nlr(N n, N m);

B L_eq_Z(Z n, Z m);

B L_eq_Zl(Z n, Z m);

B L_eq_Zr(Z n, Z m);

B L_eq_Zlr(Z n, Z m);

B L_lt_Z(Z n, Z m);

B L_lt_Zl(Z n, Z m);

B L_lt_Zr(Z n, Z m);

B L_lt_Zlr(Z n, Z m);

B L_gt_Z(Z n, Z m);

B L_gt_Zl(Z n, Z m);

B L_gt_Zr(Z n, Z m);

B L_gt_Zlr(Z n, Z m);

#define L_ne_Z(n, m) !L_eq_Z(n, m)

#define L_ne_Zl(n, m) !L_eq_Zl(n, m)

#define L_ne_Zr(n, m) !L_eq_Zr(n, m)

#define L_ne_Zlr(n, m) !L_eq_Zlr(n, m)

#define L_le_Z(n, m) !L_gt_Z(n, m)

#define L_le_Zl(n, m) !L_gt_Zl(n, m)

#define L_le_Zr(n, m) !L_gt_Zr(n, m)

#define L_le_Zlr(n, m) !L_gt_Zlr(n, m)

#define L_ge_Z(n, m) !L_lt_Z(n, m)

#define L_ge_Zl(n, m) !L_lt_Zl(n, m)

#define L_ge_Zr(n, m) !L_lt_Zr(n, m)

#define L_ge_Zlr(n, m) !L_lt_Zlr(n, m)

#endif

void L_wipe_B(B *b);

void L_wipe_U8(U8 *n);

void L_wipe_U16(U16 *n);

void L_wipe_U32(U32 *n);

void L_wipe_U64(U64 *n);

#define L_wipe_Z8(n)  L_wipe_U8((U8 *) n)

#define L_wipe_Z16(n) L_wipe_U16((U16 *) n)

#define L_wipe_Z32(n) L_wipe_U32((U32 *) n)

#define L_wipe_Z64(n) L_wipe_U64((U64 *) n)

#define L_wipe_N8(n)  L_wipe_U8((U8 *) n)

#define L_wipe_N16(n) L_wipe_U16((U16 *) n)

#define L_wipe_N32(n) L_wipe_U32((U32 *) n)

#define L_wipe_N64(n) L_wipe_U64((U64 *) n)

#define L_wipe_S8(n)  L_wipe_U8((U8 *) n)

#define L_wipe_S16(n) L_wipe_U16((U16 *) n)

#define L_wipe_S32(n) L_wipe_U32((U32 *) n)

#define L_wipe_S64(n) L_wipe_U64((U64 *) n)

#define L_F32_wipe(n) L_wipe_U32((U32 *) n)

#define L_F64_wipe(n) L_wipe_U64((U64 *) n)

void L_wipe_Z(Z *n);

#if BIT_WIDTH == 0

#define L_wipe_N(n) L_wipe_Z(n)

#else

void L_wipe_N(N *n);

#endif

BS L_create_BS(size_t size, B initialValue);

BS L_BS(size_t size, ...);

void L_wipe_BS(BS *bs);

S8S L_create_S8S(size_t size, S8 initialValue);

S8S L_S8S(size_t size, ...);

S16S L_create_S16S(size_t size, S16 initialValue);

S16S L_S16S(size_t size, ...);

S32S L_create_S32S(size_t size, S32 initialValue);

S32S L_S32S(size_t size, ...);

S64S L_create_S64S(size_t size, S64 initialValue);

S64S L_S64S(size_t size, ...);

U8S L_create_U8S(size_t size, U8 initialValue);

U8S L_U8S(size_t size, ...);

U16S L_create_U16S(size_t size, U16 initialValue);

U16S L_U16S(size_t size, ...);

U32S L_create_U32S(size_t size, U32 initialValue);

U32S L_U32S(size_t size, ...);

U64S L_create_U64S(size_t size, U64 initialValue);

U64S L_U64S(size_t size, ...);

#define L_create_Z8S(size, initialValue)  L_create_S8S(size, initialValue)

#define L_Z8S(size, args ...) L_S8S(size, args)

#define L_create_Z16S(size, initialValue) L_create_S16S(size, initialValue)

#define L_Z16S(size, args ...) L_S16S(size, args)

#define L_create_Z32S(size, initialValue) L_create_S32S(size, initialValue)

#define L_Z32S(size, args ...) L_S32S(size, args)

#define L_create_Z64S(size, initialValue) L_create_S64S(size, initialValue)

#define L_Z64S(size, args ...) L_S64S(size, args)

#define L_create_N8S(size, initialValue)  L_create_U8S(size, initialValue)

#define L_N8S(size, args ...) L_U8S(size, args)

#define L_create_N16S(size, initialValue) L_create_U16S(size, initialValue)

#define L_N16S(size, args ...) L_U16S(size, args)

#define L_create_N32S(size, initialValue) L_create_U32S(size, initialValue)

#define L_N32S(size, args ...) L_U32S(size, args)

#define L_create_N64S(size, initialValue) L_create_U64S(size, initialValue)

#define L_N64S(size, args ...) L_U64S(size, args)

F32S L_create_F32S(size_t size, F32 initialValue);

F32S L_F32S(size_t size, ...);

F64S L_create_F64S(size_t size, F64 initialValue);

F64S L_F64S(size_t size, ...);

ZS L_create_ZS(size_t size, Z initialValue);

ZS L_ZS(size_t size, ...);

#if BIT_WIDTH == 0

ZS L_create_ZSf(size_t size, Z initialValue);

ZS L_ZSf(BS fmask, size_t size, ...);

#define L_create_NS(size, initialValue) L_create_ZS(size, initialValue)

#define L_create_NSf(size, initialValue) L_create_ZSf(size, initialValue)

#define L_NS(size, args ...) L_ZS(size, args)

#define L_NSf(fmask, size, args ...) L_ZSf(fmask, size, args)

#else

NS L_create_NS(size_t size, N initialValue);

NS L_NS(size_t size, ...);

#endif

B L_get_BS(BS bs, Z index);

void L_set_BS(BS bs, Z index, B value);

#if BIT_WIDTH == 0

Z L_clone_Z(Z n);

#define L_clone_N(n) L_clone_Z(n)

#endif

BS L_clone_BS(BS ns);

S8S L_clone_S8S(S8S ns);

S16S L_clone_S16S(S16S ns);

S32S L_clone_S32S(S32S ns);

S64S L_clone_S64S(S64S ns);

U8S L_clone_U8S(U8S ns);

U16S L_clone_U16S(U16S ns);

U32S L_clone_U32S(U32S ns);

U64S L_clone_U64S(U64S ns);

F32S L_clone_F32S(F32S ns);

F64S L_clone_F64S(F64S ns);

#define L_clone_Z8S(ns)  L_clone_S8S(ns)

#define L_clone_Z16S(ns) L_clone_S16S(ns)

#define L_clone_Z32S(ns) L_clone_S32S(ns)

#define L_clone_Z64S(ns) L_clone_S64S(ns)

#define L_clone_N8S(ns)  L_clone_U8S(ns)

#define L_clone_N16S(ns) L_clone_U16S(ns)

#define L_clone_N32S(ns) L_clone_U32S(ns)

#define L_clone_N64S(ns) L_clone_U64S(ns)

#if BIT_WIDTH == 0

ZS L_clone_ZS(ZS ns);

#define L_clone_NS(ns) L_clone_ZS(ns)

#elif BIT_WIDTH == 8

#define L_clone_ZS(ns) L_clone_S8S(ns)

#define L_clone_NS(ns) L_clone_U8S(ns)

#elif BIT_WIDTH == 16

#define L_clone_ZS(ns) L_clone_S16S(ns)

#define L_clone_NS(ns) L_clone_U16S(ns)

#elif BIT_WIDTH == 32

#define L_clone_ZS(ns) L_clone_S32S(ns)

#define L_clone_NS(ns) L_clone_U32S(ns)

#elif BIT_WIDTH == 64

#define L_clone_ZS(ns) L_clone_S64S(ns)

#define L_clone_NS(ns) L_clone_U64S(ns)

#endif


B L_eq_BS(BS bs1, BS bs2);

B L_eq_BSl(BS bs1, BS bs2);

B L_eq_BSr(BS bs1, BS bs2);

B L_eq_BSlr(BS bs1, BS bs2);

B L_eq_S8S(S8S ns1, S8S ns2);

B L_eq_S8Sl(S8S ns1, S8S ns2);

B L_eq_S8Sr(S8S ns1, S8S ns2);

B L_eq_S8Slr(S8S ns1, S8S ns2);

B L_eq_S16S(S16S ns1, S16S ns2);

B L_eq_S16Sl(S16S ns1, S16S ns2);

B L_eq_S16Sr(S16S ns1, S16S ns2);

B L_eq_S16Slr(S16S ns1, S16S ns2);

B L_eq_S32S(S32S ns1, S32S ns2);

B L_eq_S32Sl(S32S ns1, S32S ns2);

B L_eq_S32Sr(S32S ns1, S32S ns2);

B L_eq_S32Slr(S32S ns1, S32S ns2);

B L_eq_S64S(S64S ns1, S64S ns2);

B L_eq_S64Sl(S64S ns1, S64S ns2);

B L_eq_S64Sr(S64S ns1, S64S ns2);

B L_eq_S64Slr(S64S ns1, S64S ns2);

B L_eq_U8S(U8S ns1, U8S ns2);

B L_eq_U8Sl(U8S ns1, U8S ns2);

B L_eq_U8Sr(U8S ns1, U8S ns2);

B L_eq_U8Slr(U8S ns1, U8S ns2);

B L_eq_U16S(U16S ns1, U16S ns2);

B L_eq_U16Sl(U16S ns1, U16S ns2);

B L_eq_U16Sr(U16S ns1, U16S ns2);

B L_eq_U16Slr(U16S ns1, U16S ns2);

B L_eq_U32S(U32S ns1, U32S ns2);

B L_eq_U32Sl(U32S ns1, U32S ns2);

B L_eq_U32Sr(U32S ns1, U32S ns2);

B L_eq_U32Slr(U32S ns1, U32S ns2);

B L_eq_U64S(U64S ns1, U64S ns2);

B L_eq_U64Sl(U64S ns1, U64S ns2);

B L_eq_U64Sr(U64S ns1, U64S ns2);

B L_eq_U64Slr(U64S ns1, U64S ns2);

B L_eq_F32S(F32S ns1, F32S ns2);

B L_eq_F32Sl(F32S ns1, F32S ns2);

B L_eq_F32Sr(F32S ns1, F32S ns2);

B L_eq_F32Slr(F32S ns1, F32S ns2);

B L_eq_F64S(F64S ns1, F64S ns2);

B L_eq_F64Sl(F64S ns1, F64S ns2);

B L_eq_F64Sr(F64S ns1, F64S ns2);

B L_eq_F64Slr(F64S ns1, F64S ns2);

#define L_eq_Z8S(ns1, ns2)  L_eq_S8S(ns1, ns2)

#define L_eq_Z16S(ns1, ns2) L_eq_S16S(ns1, ns2)

#define L_eq_Z32S(ns1, ns2) L_eq_S32S(ns1, ns2)

#define L_eq_Z64S(ns1, ns2) L_eq_S64S(ns1, ns2)

#define L_eq_N8S(ns1, ns2)  L_eq_U8S(ns1, ns2)

#define L_eq_N16S(ns1, ns2) L_eq_U16S(ns1, ns2)

#define L_eq_N32S(ns1, ns2) L_eq_U32S(ns1, ns2)

#define L_eq_N64S(ns1, ns2) L_eq_U64S(ns1, ns2)

#define L_eq_Z8Sl(ns1, ns2)  L_eq_S8Sl(ns1, ns2)

#define L_eq_Z16Sl(ns1, ns2) L_eq_S16Sl(ns1, ns2)

#define L_eq_Z32Sl(ns1, ns2) L_eq_S32Sl(ns1, ns2)

#define L_eq_Z64Sl(ns1, ns2) L_eq_S64Sl(ns1, ns2)

#define L_eq_N8Sl(ns1, ns2)  L_eq_U8Sl(ns1, ns2)

#define L_eq_N16Sl(ns1, ns2) L_eq_U16Sl(ns1, ns2)

#define L_eq_N32Sl(ns1, ns2) L_eq_U32Sl(ns1, ns2)

#define L_eq_N64Sl(ns1, ns2) L_eq_U64Sl(ns1, ns2)

#define L_eq_Z8Sr(ns1, ns2)  L_eq_S8Sr(ns1, ns2)

#define L_eq_Z16Sr(ns1, ns2) L_eq_S16Sr(ns1, ns2)

#define L_eq_Z32Sr(ns1, ns2) L_eq_S32Sr(ns1, ns2)

#define L_eq_Z64Sr(ns1, ns2) L_eq_S64Sr(ns1, ns2)

#define L_eq_N8Sr(ns1, ns2)  L_eq_U8Sr(ns1, ns2)

#define L_eq_N16Sr(ns1, ns2) L_eq_U16Sr(ns1, ns2)

#define L_eq_N32Sr(ns1, ns2) L_eq_U32Sr(ns1, ns2)

#define L_eq_N64Sr(ns1, ns2) L_eq_U64Sr(ns1, ns2)

#define L_eq_Z8Slr(ns1, ns2)  L_eq_S8Slr(ns1, ns2)

#define L_eq_Z16Slr(ns1, ns2) L_eq_S16Slr(ns1, ns2)

#define L_eq_Z32Slr(ns1, ns2) L_eq_S32Slr(ns1, ns2)

#define L_eq_Z64Slr(ns1, ns2) L_eq_S64Slr(ns1, ns2)

#define L_eq_N8Slr(ns1, ns2)  L_eq_U8Slr(ns1, ns2)

#define L_eq_N16Slr(ns1, ns2) L_eq_U16Slr(ns1, ns2)

#define L_eq_N32Slr(ns1, ns2) L_eq_U32Slr(ns1, ns2)

#define L_eq_N64Slr(ns1, ns2) L_eq_U64Slr(ns1, ns2)

#if BIT_WIDTH == 0

B L_eq_ZS(ZS ns1, ZS ns2);

B L_eq_ZSl(ZS ns1, ZS ns2);

B L_eq_ZSr(ZS ns1, ZS ns2);

B L_eq_ZSlr(ZS ns1, ZS ns2);

#define L_eq_NS(ns1, ns2) L_eq_ZS(ns1, ns2)

#elif BIT_WIDTH == 8

#define L_eq_ZS(ns1, ns2) L_eq_S8S(ns1, ns2)

#define L_eq_ZSl(ns1, ns2) L_eq_S8Sl(ns1, ns2)

#define L_eq_ZSr(ns1, ns2) L_eq_S8Sr(ns1, ns2)

#define L_eq_ZSlr(ns1, ns2) L_eq_S8Slr(ns1, ns2)

#define L_eq_NS(ns1, ns2) L_eq_U8S(ns1, ns2)

#elif BIT_WIDTH == 16

#define L_eq_ZS(ns1, ns2) L_eq_S16S(ns1, ns2)

#define L_eq_ZSl(ns1, ns2) L_eq_S16Sl(ns1, ns2)

#define L_eq_ZSr(ns1, ns2) L_eq_S16Sr(ns1, ns2)

#define L_eq_ZSlr(ns1, ns2) L_eq_S16Slr(ns1, ns2)

#define L_eq_NS(ns1, ns2) L_eq_U16S(ns1, ns2)

#elif BIT_WIDTH == 32

#define L_eq_ZS(ns1, ns2) L_eq_S32S(ns1, ns2)

#define L_eq_ZSl(ns1, ns2) L_eq_S32Sl(ns1, ns2)

#define L_eq_ZSr(ns1, ns2) L_eq_S32Sr(ns1, ns2)

#define L_eq_ZSlr(ns1, ns2) L_eq_S32Slr(ns1, ns2)

#define L_eq_NS(ns1, ns2) L_eq_U32S(ns1, ns2)

#elif BIT_WIDTH == 64

#define L_eq_ZS(ns1, ns2) L_eq_S64S(ns1, ns2)

#define L_eq_ZSl(ns1, ns2) L_eq_S64Sl(ns1, ns2)

#define L_eq_ZSr(ns1, ns2) L_eq_S64Sr(ns1, ns2)

#define L_eq_ZSlr(ns1, ns2) L_eq_S64Slr(ns1, ns2)

#define L_eq_NS(ns1, ns2) L_eq_U64S(ns1, ns2)

#endif

#define L_eq_NSl(ns1, ns2) L_eq_ZSl(ns1, ns2)

#define L_eq_NSr(ns1, ns2) L_eq_ZSr(ns1, ns2)

#define L_eq_NSlr(ns1, ns2) L_eq_ZSlr(ns1, ns2)

#define L_ne_S8S(ns1, ns2) !L_eq_S8S(ns1, ns2)

#define L_ne_S8Sl(ns1, ns2) !L_eq_S8Sl(ns1, ns2)

#define L_ne_S8Sr(ns1, ns2) !L_eq_S8Sr(ns1, ns2)

#define L_ne_S8Slr(ns1, ns2) !L_eq_S8Slr(ns1, ns2)

#define L_ne_S16S(ns1, ns2) !L_eq_S16S(ns1, ns2)

#define L_ne_S16Sl(ns1, ns2) !L_eq_S16Sl(ns1, ns2)

#define L_ne_S16Sr(ns1, ns2) !L_eq_S16Sr(ns1, ns2)

#define L_ne_S16Slr(ns1, ns2) !L_eq_S16Slr(ns1, ns2)

#define L_ne_S32S(ns1, ns2) !L_eq_S32S(ns1, ns2)

#define L_ne_S32Sl(ns1, ns2) !L_eq_S32Sl(ns1, ns2)

#define L_ne_S32Sr(ns1, ns2) !L_eq_S32Sr(ns1, ns2)

#define L_ne_S32Slr(ns1, ns2) !L_eq_S32Slr(ns1, ns2)

#define L_ne_S64S(ns1, ns2) !L_eq_S64S(ns1, ns2)

#define L_ne_S64Sl(ns1, ns2) !L_eq_S64Sl(ns1, ns2)

#define L_ne_S64Sr(ns1, ns2) !L_eq_S64Sr(ns1, ns2)

#define L_ne_S64Slr(ns1, ns2) !L_eq_S64Slr(ns1, ns2)

#define L_ne_U8S(ns1, ns2) !L_eq_U8S(ns1, ns2)

#define L_ne_U8Sl(ns1, ns2) !L_eq_U8Sl(ns1, ns2)

#define L_ne_U8Sr(ns1, ns2) !L_eq_U8Sr(ns1, ns2)

#define L_ne_U8Slr(ns1, ns2) !L_eq_U8Slr(ns1, ns2)

#define L_ne_U16S(ns1, ns2) !L_eq_U16S(ns1, ns2)

#define L_ne_U16Sl(ns1, ns2) !L_eq_U16Sl(ns1, ns2)

#define L_ne_U16Sr(ns1, ns2) !L_eq_U16Sr(ns1, ns2)

#define L_ne_U16Slr(ns1, ns2) !L_eq_U16Slr(ns1, ns2)

#define L_ne_U32S(ns1, ns2) !L_eq_U32S(ns1, ns2)

#define L_ne_U32Sl(ns1, ns2) !L_eq_U32Sl(ns1, ns2)

#define L_ne_U32Sr(ns1, ns2) !L_eq_U32Sr(ns1, ns2)

#define L_ne_U32Slr(ns1, ns2) !L_eq_U32Slr(ns1, ns2)

#define L_ne_U64S(ns1, ns2) !L_eq_U64S(ns1, ns2)

#define L_ne_U64Sl(ns1, ns2) !L_eq_U64Sl(ns1, ns2)

#define L_ne_U64Sr(ns1, ns2) !L_eq_U64Sr(ns1, ns2)

#define L_ne_U64Slr(ns1, ns2) !L_eq_U64Slr(ns1, ns2)

#define L_ne_Z8S(ns1, ns2) !L_eq_Z8S(ns1, ns2)

#define L_ne_Z8Sl(ns1, ns2) !L_eq_Z8Sl(ns1, ns2)

#define L_ne_Z8Sr(ns1, ns2) !L_eq_Z8Sr(ns1, ns2)

#define L_ne_Z8Slr(ns1, ns2) !L_eq_Z8Slr(ns1, ns2)

#define L_ne_Z16S(ns1, ns2) !L_eq_Z16S(ns1, ns2)

#define L_ne_Z16Sl(ns1, ns2) !L_eq_Z16Sl(ns1, ns2)

#define L_ne_Z16Sr(ns1, ns2) !L_eq_Z16Sr(ns1, ns2)

#define L_ne_Z16Slr(ns1, ns2) !L_eq_Z16Slr(ns1, ns2)

#define L_ne_Z32S(ns1, ns2) !L_eq_Z32S(ns1, ns2)

#define L_ne_Z32Sl(ns1, ns2) !L_eq_Z32Sl(ns1, ns2)

#define L_ne_Z32Sr(ns1, ns2) !L_eq_Z32Sr(ns1, ns2)

#define L_ne_Z32Slr(ns1, ns2) !L_eq_Z32Slr(ns1, ns2)

#define L_ne_Z64S(ns1, ns2) !L_eq_Z64S(ns1, ns2)

#define L_ne_Z64Sl(ns1, ns2) !L_eq_Z64Sl(ns1, ns2)

#define L_ne_Z64Sr(ns1, ns2) !L_eq_Z64Sr(ns1, ns2)

#define L_ne_Z64Slr(ns1, ns2) !L_eq_Z64Slr(ns1, ns2)

#define L_ne_N8S(ns1, ns2) !L_eq_N8S(ns1, ns2)

#define L_ne_N8Sl(ns1, ns2) !L_eq_N8Sl(ns1, ns2)

#define L_ne_N8Sr(ns1, ns2) !L_eq_N8Sr(ns1, ns2)

#define L_ne_N8Slr(ns1, ns2) !L_eq_N8Slr(ns1, ns2)

#define L_ne_N16S(ns1, ns2) !L_eq_N16S(ns1, ns2)

#define L_ne_N16Sl(ns1, ns2) !L_eq_N16Sl(ns1, ns2)

#define L_ne_N16Sr(ns1, ns2) !L_eq_N16Sr(ns1, ns2)

#define L_ne_N16Slr(ns1, ns2) !L_eq_N16Slr(ns1, ns2)

#define L_ne_N32S(ns1, ns2) !L_eq_N32S(ns1, ns2)

#define L_ne_N32Sl(ns1, ns2) !L_eq_N32Sl(ns1, ns2)

#define L_ne_N32Sr(ns1, ns2) !L_eq_N32Sr(ns1, ns2)

#define L_ne_N32Slr(ns1, ns2) !L_eq_N32Slr(ns1, ns2)

#define L_ne_N64S(ns1, ns2) !L_eq_N64S(ns1, ns2)

#define L_ne_N64Sl(ns1, ns2) !L_eq_N64Sl(ns1, ns2)

#define L_ne_N64Sr(ns1, ns2) !L_eq_N64Sr(ns1, ns2)

#define L_ne_N64Slr(ns1, ns2) !L_eq_N64Slr(ns1, ns2)

#define L_ne_F32S(ns1, ns2) !L_eq_F32S(ns1, ns2)

#define L_ne_F32Sl(ns1, ns2) !L_eq_F32Sl(ns1, ns2)

#define L_ne_F32Sr(ns1, ns2) !L_eq_F32Sr(ns1, ns2)

#define L_ne_F32Slr(ns1, ns2) !L_eq_F32Slr(ns1, ns2)

#define L_ne_F64S(ns1, ns2) !L_eq_F64S(ns1, ns2)

#define L_ne_F64Sl(ns1, ns2) !L_eq_F64Sl(ns1, ns2)

#define L_ne_F64Sr(ns1, ns2) !L_eq_F64Sr(ns1, ns2)

#define L_ne_F64Slr(ns1, ns2) !L_eq_F64Slr(ns1, ns2)

#define L_ne_ZS(ns1, ns2) !L_eq_ZS(ns1, ns2)

#define L_ne_ZSl(ns1, ns2) !L_eq_ZSl(ns1, ns2)

#define L_ne_ZSr(ns1, ns2) !L_eq_ZSr(ns1, ns2)

#define L_ne_ZSlr(ns1, ns2) !L_eq_ZSlr(ns1, ns2)

#define L_ne_NS(ns1, ns2) !L_eq_NS(ns1, ns2)

#define L_ne_NSl(ns1, ns2) !L_eq_NSl(ns1, ns2)

#define L_ne_NSr(ns1, ns2) !L_eq_NSr(ns1, ns2)

#define L_ne_NSlr(ns1, ns2) !L_eq_NSlr(ns1, ns2)


S8S L_prepend_S8S(S8 n, S8S ns);

S8S L_prepend_S8Sf(S8 n, S8S ns);

S8S L_append_S8S(S8S ns, S8 n);

S8S L_append_S8Sf(S8S ns, S8 n);

S8S L_appends_S8S(S8S ns1, S8S ns2);

S8S L_appends_S8Sl(S8S ns1, S8S ns2);

S8S L_appends_S8Sr(S8S ns1, S8S ns2);

S8S L_appends_S8Slr(S8S ns1, S8S ns2);

S16S L_prepend_S16S(S16 n, S16S ns);

S16S L_prepend_S16Sf(S16 n, S16S ns);

S16S L_append_S16S(S16S ns, S16 n);

S16S L_append_S16Sf(S16S ns, S16 n);

S16S L_appends_S16S(S16S ns1, S16S ns2);

S16S L_appends_S16Sl(S16S ns1, S16S ns2);

S16S L_appends_S16Sr(S16S ns1, S16S ns2);

S16S L_appends_S16Slr(S16S ns1, S16S ns2);

S32S L_prepend_S32S(S32 n, S32S ns);

S32S L_prepend_S32Sf(S32 n, S32S ns);

S32S L_append_S32S(S32S ns, S32 n);

S32S L_append_S32Sf(S32S ns, S32 n);

S32S L_appends_S32S(S32S ns1, S32S ns2);

S32S L_appends_S32Sl(S32S ns1, S32S ns2);

S32S L_appends_S32Sr(S32S ns1, S32S ns2);

S32S L_appends_S32Slr(S32S ns1, S32S ns2);

S64S L_prepend_S64S(S64 n, S64S ns);

S64S L_prepend_S64Sf(S64 n, S64S ns);

S64S L_append_S64S(S64S ns, S64 n);

S64S L_append_S64Sf(S64S ns, S64 n);

S64S L_appends_S64S(S64S ns1, S64S ns2);

S64S L_appends_S64Sl(S64S ns1, S64S ns2);

S64S L_appends_S64Sr(S64S ns1, S64S ns2);

S64S L_appends_S64Slr(S64S ns1, S64S ns2);

U8S L_prepend_U8S(U8 n, U8S ns);

U8S L_prepend_U8Sf(U8 n, U8S ns);

U8S L_append_U8S(U8S ns, U8 n);

U8S L_append_U8Sf(U8S ns, U8 n);

U8S L_appends_U8S(U8S ns1, U8S ns2);

U8S L_appends_U8Sl(U8S ns1, U8S ns2);

U8S L_appends_U8Sr(U8S ns1, U8S ns2);

U8S L_appends_U8Slr(U8S ns1, U8S ns2);

U16S L_prepend_U16S(U16 n, U16S ns);

U16S L_prepend_U16Sf(U16 n, U16S ns);

U16S L_append_U16S(U16S ns, U16 n);

U16S L_append_U16Sf(U16S ns, U16 n);

U16S L_appends_U16S(U16S ns1, U16S ns2);

U16S L_appends_U16Sl(U16S ns1, U16S ns2);

U16S L_appends_U16Sr(U16S ns1, U16S ns2);

U16S L_appends_U16Slr(U16S ns1, U16S ns2);

U32S L_prepend_U32S(U32 n, U32S ns);

U32S L_prepend_U32Sf(U32 n, U32S ns);

U32S L_append_U32S(U32S ns, U32 n);

U32S L_append_U32Sf(U32S ns, U32 n);

U32S L_appends_U32S(U32S ns1, U32S ns2);

U32S L_appends_U32Sl(U32S ns1, U32S ns2);

U32S L_appends_U32Sr(U32S ns1, U32S ns2);

U32S L_appends_U32Slr(U32S ns1, U32S ns2);

U64S L_prepend_U64S(U64 n, U64S ns);

U64S L_prepend_U64Sf(U64 n, U64S ns);

U64S L_append_U64S(U64S ns, U64 n);

U64S L_append_U64Sf(U64S ns, U64 n);

U64S L_appends_U64S(U64S ns1, U64S ns2);

U64S L_appends_U64Sl(U64S ns1, U64S ns2);

U64S L_appends_U64Sr(U64S ns1, U64S ns2);

U64S L_appends_U64Slr(U64S ns1, U64S ns2);

#if BIT_WIDTH == 0

ZS L_prepend_ZS(Z n, ZS ns);

ZS L_prepend_ZSf(Z n, ZS ns);

ZS L_append_ZS(ZS ns, Z n);

ZS L_append_ZSf(ZS ns, Z n);

ZS L_appends_ZS(ZS ns1, ZS ns2);

ZS L_appends_ZSl(ZS ns1, ZS ns2);

ZS L_appends_ZSr(ZS ns1, ZS ns2);

ZS L_appends_ZSlr(ZS ns1, ZS ns2);

#define L_prepend_NS(n, ns)      L_prepend_ZS(n, ns)

#define L_prepend_NSf(n, ns)     L_prepend_ZSf(n, ns)

#define L_NS_append(ns, n)       L_append_ZS(ns, n)

#define L_NS_appendf(ns, n)      L_append_ZSf(ns, n)

#define L_NS_appends(ns1, ns2)   L_appends_ZS(ns1, ns2)

#define L_NS_appendsl(ns1, ns2)  L_appends_ZSl(ns1, ns2)

#define L_NS_appendsr(ns1, ns2)  L_appends_ZSr(ns1, ns2)

#define L_NS_appendslr(ns1, ns2) L_appends_ZSlr(ns1, ns2)

#elif BIT_WIDTH == 8

#define L_prepend_ZS(n, ns)      L_prepend_S8S(n, ns)

#define L_prepend_ZSf(n, ns)     L_prepend_S8Sf(n, ns)

#define L_append_ZS(ns, n)       L_append_S8S(ns, n)

#define L_append_ZSf(ns, n)      L_append_S8Sf(ns, n)

#define L_appends_ZS(ns1, ns2)   L_appends_S8S(ns1, ns2)

#define L_appends_ZSl(ns1, ns2)  L_appends_S8Sl(ns1, ns2)

#define L_appends_ZSr(ns1, ns2)  L_appends_S8Sr(ns1, ns2)

#define L_appends_ZSlr(ns1, ns2) L_appends_S8Slr(ns1, ns2)

#define L_prepend_NS(n, ns)      L_prepend_U8S(n, ns)

#define L_prepend_NSf(n, ns)     L_prepend_U8Sf(n, ns)

#define L_append_NS(ns, n)       L_append_U8S(ns, n)

#define L_append_NSf(ns, n)      L_append_U8Sf(ns, n)

#define L_appends_NS(ns1, ns2)   L_appends_U8S(ns1, ns2)

#define L_appends_NSl(ns1, ns2)  L_appends_U8Sl(ns1, ns2)

#define L_appends_NSr(ns1, ns2)  L_appends_U8Sr(ns1, ns2)

#define L_appends_NSlr(ns1, ns2) L_appends_U8Slr(ns1, ns2)


#elif BIT_WIDTH == 16

#define L_prepend_ZS(n, ns)      L_prepend_S16S(n, ns)

#define L_prepend_ZSf(n, ns)     L_prepend_S16Sf(n, ns)

#define L_append_ZS(ns, n)       L_append_S16S(ns, n)

#define L_append_ZSf(ns, n)      L_append_S16Sf(ns, n)

#define L_appends_ZS(ns1, ns2)   L_appends_S16S(ns1, ns2)

#define L_appends_ZSl(ns1, ns2)  L_appends_S16Sl(ns1, ns2)

#define L_appends_ZSr(ns1, ns2)  L_appends_S16Sr(ns1, ns2)

#define L_appends_ZSlr(ns1, ns2) L_appends_S16Slr(ns1, ns2)

#define L_prepend_NS(n, ns)      L_prepend_U16S(n, ns)

#define L_prepend_NSf(n, ns)     L_prepend_U16Sf(n, ns)

#define L_append_NS(ns, n)       L_append_U16S(ns, n)

#define L_append_NSf(ns, n)      L_append_U16Sf(ns, n)

#define L_appends_NS(ns1, ns2)   L_appends_U16S(ns1, ns2)

#define L_appends_NSl(ns1, ns2)  L_appends_U16Sl(ns1, ns2)

#define L_appends_NSr(ns1, ns2)  L_appends_U16Sr(ns1, ns2)

#define L_appends_NSlr(ns1, ns2) L_appends_U16Slr(ns1, ns2)

#elif BIT_WIDTH == 32

#define L_prepend_ZS(n, ns)      L_prepend_S32S(n, ns)

#define L_prepend_ZSf(n, ns)     L_prepend_S32Sf(n, ns)

#define L_append_ZS(ns, n)       L_append_S32S(ns, n)

#define L_append_ZSf(ns, n)      L_append_S32Sf(ns, n)

#define L_appends_ZS(ns1, ns2)   L_appends_S32S(ns1, ns2)

#define L_appends_ZSl(ns1, ns2)  L_appends_S32Sl(ns1, ns2)

#define L_appends_ZSr(ns1, ns2)  L_appends_S32Sr(ns1, ns2)

#define L_appends_ZSlr(ns1, ns2) L_appends_S32Slr(ns1, ns2)

#define L_prepend_NS(n, ns)      L_prepend_U32S(n, ns)

#define L_prepend_NSf(n, ns)     L_prepend_U32Sf(n, ns)

#define L_append_NS(ns, n)       L_append_U32S(ns, n)

#define L_append_NSf(ns, n)      L_append_U32Sf(ns, n)

#define L_appends_NS(ns1, ns2)   L_appends_U32S(ns1, ns2)

#define L_appends_NSl(ns1, ns2)  L_appends_U32Sl(ns1, ns2)

#define L_appends_NSr(ns1, ns2)  L_appends_U32Sr(ns1, ns2)

#define L_appends_NSlr(ns1, ns2) L_appends_U32Slr(ns1, ns2)

#elif BIT_WIDTH == 64

#define L_prepend_ZS(n, ns)      L_prepend_S64S(n, ns)

#define L_prepend_ZSf(n, ns)     L_prepend_S64Sf(n, ns)

#define L_append_ZS(ns, n)       L_append_S64S(ns, n)

#define L_append_ZSf(ns, n)      L_append_S64Sf(ns, n)

#define L_appends_ZS(ns1, ns2)   L_appends_S64S(ns1, ns2)

#define L_appends_ZSl(ns1, ns2)  L_appends_S64Sl(ns1, ns2)

#define L_appends_ZSr(ns1, ns2)  L_appends_S64Sr(ns1, ns2)

#define L_appends_ZSlr(ns1, ns2) L_appends_S64Slr(ns1, ns2)

#define L_prepend_NS(n, ns)      L_prepend_U64S(n, ns)

#define L_prepend_NSf(n, ns)     L_prepend_U64Sf(n, ns)

#define L_append_NS(ns, n)       L_append_U64S(ns, n)

#define L_append_NSf(ns, n)      L_append_U64Sf(ns, n)

#define L_appends_NS(ns1, ns2)   L_appends_U64S(ns1, ns2)

#define L_appends_NSl(ns1, ns2)  L_appends_U64Sl(ns1, ns2)

#define L_appends_NSr(ns1, ns2)  L_appends_U64Sr(ns1, ns2)

#define L_appends_NSlr(ns1, ns2) L_appends_U64Slr(ns1, ns2)

#endif

void L_wipe_S8S(S8S *ns);

void L_wipe_S16S(S16S *ns);

void L_wipe_S32S(S32S *ns);

void L_wipe_S64S(S64S *ns);

void L_wipe_U8S(U8S *ns);

void L_wipe_U16S(U16S *ns);

void L_wipe_U32S(U32S *ns);

void L_wipe_U64S(U64S *ns);

#define L_wipe_Z8S(ns)  L_wipe_S8S(ns)

#define L_wipe_Z16S(ns) L_wipe_S16S(ns)

#define L_wipe_Z32S(ns) L_wipe_S32S(ns)

#define L_wipe_Z64S(ns) L_wipe_S64S(ns)

#define L_wipe_N8S(ns)  L_wipe_U8S(ns)

#define L_wipe_N16S(ns) L_wipe_U16S(ns)

#define L_wipe_N32S(ns) L_wipe_U32S(ns)

#define L_wipe_N64S(ns) L_wipe_U64S(ns)

void L_wipe_F32S(F32S *ns);

void L_wipe_F64S(F64S *ns);

void L_wipe_ZS(ZS *ns);

#if BIT_WIDTH == 0

#define L_wipe_NS(n) L_wipe_ZS(n)

#else

void L_wipe_NS(NS *ns);

#endif

#endif
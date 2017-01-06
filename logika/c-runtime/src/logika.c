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

#include <limits.h>
#include <logika.h>
#include <stdarg.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define BITS_PER_SIZE_T CHAR_BIT * sizeof(size_t)
#define BITS_PER_ULONG  CHAR_BIT * sizeof(unsigned int long)

void *L_malloc(size_t size) {
  void *result = malloc(size);
  L_assert(result != NULL);
  return result;
}

void *L_realloc(void *ptr, size_t size) {
  void *result = realloc(ptr, size);
  L_assert(result != NULL);
  return result;
}

#if BIT_WIDTH == 0

static bool L_Z_fits_size_t(Z n) {
  L_assert(mpz_cmp_ui(n.data, 0) >= 0);
  return mpz_sizeinbase(n.data, 2) <= BITS_PER_SIZE_T;
}

size_t L_Z_to_size_t(Z n) {
  L_assert(L_Z_fits_size_t(n));
#if SIZE_T_MAX > ULONG_MAX
  mpz_t temp;
  mpz_init(temp);
  mpz_fdiv_q_2exp(temp, n.data, BITS_PER_ULONG);
  size_t result = (((size_t) mpz_get_ui(temp)) << BITS_PER_ULONG) | mpz_get_ui(n.data);
  mpz_clear(temp);
  L_wipe(&temp, sizeof(mpz_t));
  return result;
#else
  return mpz_get_ui(n.data);
#endif
}

Z L_Z_si(long int n) {
  Z result = {0};
  mpz_init_set_si(result.data, n);
  return result;
}

Z L_Z_ui(unsigned long int n) {
  Z result = {0};
  mpz_init_set_ui(result.data, n);
  return result;
}

Z L_Z_str(char *n) {
  Z result = {0};
  mpz_init_set_str(result.data, n, 10);
  return result;
}

Z L_Z_neg(Z n) {
  Z result = {0};
  mpz_init(result.data);
  mpz_neg(result.data, n.data);
  return result;
}

Z L_Z_negf(Z n) {
  Z result = L_Z_neg(n);
  L_Z_wipe(&n);
  return result;
}

Z L_Z_add(Z n, Z m) {
  Z result = {0};
  mpz_init(result.data);
  mpz_add(result.data, n.data, m.data);
  return result;
}

Z L_Z_addl(Z n, Z m) {
  Z result = L_Z_add(n, m);
  L_Z_wipe(&n);
  return result;
}

Z L_Z_addr(Z n, Z m) {
  Z result = L_Z_add(n, m);
  L_Z_wipe(&m);
  return result;
}

Z L_Z_addlr(Z n, Z m) {
  Z result = L_Z_add(n, m);
  L_Z_wipe(&n);
  L_Z_wipe(&m);
  return result;
}

Z L_Z_sub(Z n, Z m) {
  Z result = {0};
  mpz_init(result.data);
  mpz_sub(result.data, n.data, m.data);
  return result;
}

Z L_Z_subl(Z n, Z m) {
  Z result = L_Z_sub(n, m);
  L_Z_wipe(&n);
  return result;
}

Z L_Z_subr(Z n, Z m) {
  Z result = L_Z_sub(n, m);
  L_Z_wipe(&m);
  return result;
}

Z L_Z_sublr(Z n, Z m) {
  Z result = L_Z_sub(n, m);
  L_Z_wipe(&n);
  L_Z_wipe(&m);
  return result;
}

Z L_Z_mul(Z n, Z m) {
  Z result = {0};
  mpz_init(result.data);
  mpz_mul(result.data, n.data, m.data);
  return result;
}

Z L_Z_mull(Z n, Z m) {
  Z result = L_Z_mul(n, m);
  L_Z_wipe(&n);
  return result;
}

Z L_Z_mulr(Z n, Z m) {
  Z result = L_Z_mul(n, m);
  L_Z_wipe(&m);
  return result;
}

Z L_Z_mullr(Z n, Z m) {
  Z result = L_Z_mul(n, m);
  L_Z_wipe(&n);
  L_Z_wipe(&m);
  return result;
}

Z L_Z_div(Z n, Z m) {
  L_assert(mpz_cmp_ui(m.data, 0) != 0);
  Z result = {0};
  mpz_init(result.data);
  mpz_tdiv_q(result.data, n.data, m.data);
  return result;
}

Z L_Z_divl(Z n, Z m) {
  Z result = L_Z_div(n, m);
  L_Z_wipe(&n);
  return result;
}

Z L_Z_divr(Z n, Z m) {
  Z result = L_Z_div(n, m);
  L_Z_wipe(&m);
  return result;
}

Z L_Z_divlr(Z n, Z m) {
  Z result = L_Z_div(n, m);
  L_Z_wipe(&n);
  L_Z_wipe(&m);
  return result;
}

Z L_Z_rem(Z n, Z m) {
  L_assert(mpz_cmp_ui(m.data, 0) != 0);
  Z result = {0};
  mpz_init(result.data);
  mpz_tdiv_r(result.data, n.data, m.data);
  return result;
}

Z L_Z_reml(Z n, Z m) {
  Z result = L_Z_rem(n, m);
  L_Z_wipe(&n);
  return result;
}

Z L_Z_remr(Z n, Z m) {
  Z result = L_Z_rem(n, m);
  L_Z_wipe(&m);
  return result;
}

Z L_Z_remlr(Z n, Z m) {
  Z result = L_Z_rem(n, m);
  L_Z_wipe(&n);
  L_Z_wipe(&m);
  return result;
}

B L_Z_eq(Z n, Z m) {
  return mpz_cmp(n.data, m.data) == 0;
}

B L_Z_eql(Z n, Z m) {
  B result = L_Z_eq(n, m);
  L_N_wipe(&n);
  return result;
}

B L_Z_eqr(Z n, Z m) {
  B result = L_Z_eq(n, m);
  L_N_wipe(&m);
  return result;
}

B L_Z_eqlr(Z n, Z m) {
  B result = L_Z_eq(n, m);
  L_N_wipe(&n);
  L_N_wipe(&m);
  return result;
}

B L_Z_lt(Z n, Z m) {
  return mpz_cmp(n.data, m.data) < 0;
}

B L_Z_ltl(Z n, Z m) {
  B result = L_Z_lt(n, m);
  L_N_wipe(&n);
  return result;
}

B L_Z_ltr(Z n, Z m) {
  B result = L_Z_lt(n, m);
  L_N_wipe(&m);
  return result;
}

B L_Z_ltlr(Z n, Z m) {
  B result = L_Z_lt(n, m);
  L_N_wipe(&n);
  L_N_wipe(&m);
  return result;
}

B L_Z_gt(Z n, Z m) {
  return mpz_cmp(n.data, m.data) > 0;
}

B L_Z_gtl(Z n, Z m) {
  B result = L_Z_gt(n, m);
  L_N_wipe(&n);
  return result;
}

B L_Z_gtr(Z n, Z m) {
  B result = L_Z_gt(n, m);
  L_N_wipe(&m);
  return result;
}

B L_Z_gtlr(Z n, Z m) {
  B result = L_Z_gt(n, m);
  L_N_wipe(&n);
  L_N_wipe(&m);
  return result;
}

N L_N_add(N n, N m) {
  N result = {0};
  mpz_init(result.data);
  mpz_add(result.data, n.data, m.data);
  L_assert(mpz_cmp_ui(result.data, 0) >= 0);
  return result;
}

N L_N_addl(N n, N m) {
  N result = L_N_add(n, m);
  L_N_wipe(&n);
  return result;
}

N L_N_addr(N n, N m) {
  N result = L_N_add(n, m);
  L_N_wipe(&m);
  return result;
}

N L_N_addlr(N n, N m) {
  N result = L_N_add(n, m);
  L_N_wipe(&n);
  L_N_wipe(&m);
  return result;
}

N L_N_sub(N n, N m) {
  N result = {0};
  mpz_init(result.data);
  mpz_sub(result.data, n.data, m.data);
  L_assert(mpz_cmp_ui(result.data, 0) >= 0);
  return result;
}

N L_N_subl(N n, N m) {
  N result = L_N_sub(n, m);
  L_N_wipe(&n);
  return result;
}

N L_N_subr(N n, N m) {
  N result = L_N_sub(n, m);
  L_N_wipe(&m);
  return result;
}

N L_N_sublr(N n, N m) {
  N result = L_N_sub(n, m);
  L_N_wipe(&n);
  L_N_wipe(&m);
  return result;
}

N L_N_mul(N n, N m) {
  N result = {0};
  mpz_init(result.data);
  mpz_mul(result.data, n.data, m.data);
  L_assert(mpz_cmp_ui(result.data, 0) >= 0);
  return result;
}

N L_N_mull(N n, N m) {
  N result = L_N_mul(n, m);
  L_N_wipe(&n);
  return result;
}

N L_N_mulr(N n, N m) {
  N result = L_N_mul(n, m);
  L_N_wipe(&m);
  return result;
}

N L_N_mullr(N n, N m) {
  N result = L_N_mul(n, m);
  L_N_wipe(&n);
  L_N_wipe(&m);
  return result;
}

N L_N_div(N n, N m) {
  L_assert(mpz_cmp_ui(m.data, 0) != 0);
  N result = {0};
  mpz_init(result.data);
  mpz_tdiv_q(result.data, n.data, m.data);
  L_assert(mpz_cmp_ui(result.data, 0) >= 0);
  return result;
}

N L_N_divl(N n, N m) {
  N result = L_N_div(n, m);
  L_N_wipe(&n);
  return result;
}

N L_N_divr(N n, N m) {
  N result = L_N_div(n, m);
  L_N_wipe(&m);
  return result;
}

N L_N_divlr(N n, N m) {
  N result = L_N_div(n, m);
  L_N_wipe(&n);
  L_N_wipe(&m);
  return result;
}

N L_N_rem(N n, N m) {
  L_assert(mpz_cmp_ui(m.data, 0) != 0);
  N result = {0};
  mpz_init(result.data);
  mpz_tdiv_r(result.data, n.data, m.data);
  L_assert(mpz_cmp_ui(result.data, 0) >= 0);
  return result;
}

N L_N_reml(N n, N m) {
  N result = L_N_rem(n, m);
  L_N_wipe(&n);
  return result;
}

N L_N_remr(N n, N m) {
  N result = L_N_rem(n, m);
  L_N_wipe(&m);
  return result;
}

N L_N_remlr(N n, N m) {
  N result = L_N_rem(n, m);
  L_N_wipe(&n);
  L_N_wipe(&m);
  return result;
}

ZS L_ZS_create(size_t size, Z initialValue) {
  ZS result = {0};
  result.size = size;
  result.data = L_malloc(size * sizeof(Z));
  size_t i;
  for (i = 0; i < size; i++) {
    result.data[i] = initialValue;
  }
  return result;
}

ZS L_ZS(int size, ...) {
  ZS result = {0};
  result.size = (size_t) size;
  result.data = L_malloc(size * sizeof(Z));
  va_list valist;
  va_start(valist, size);
  int i;
  for (i = 0; i < size; i++) {
#if Z_LT_INT
    result.data[i] = (Z) va_arg(valist, int);
#else
    result.data[i] = va_arg(valist, Z);
#endif
  }
  va_end(valist);

  return result;
}

void L_Z_wipe(Z *n) {
  mpz_clear(n->data);
  L_wipe(n, sizeof(Z));
}

void L_ZS_wipe(ZS *ns) {
  size_t size = ns->size;
  size_t i;
  for (i = 0; i < size; i++) {
    L_Z_wipe(&(ns->data[i]));
  }
  L_wipe(ns, sizeof(ZS));
}

#else

NS L_NS_create(size_t size, N initialValue) {
  L_assert(size <= SIZE_T_MAX);
  NS result = {0};
  result.size = size;
  result.data = L_malloc(size * sizeof(N));
  size_t i;
  for (i = 0; i < size; i++) {
    result.data[i] = initialValue;
  }
  return result;
}

NS L_NS(int size, ...) {
  NS result = {0};
  result.size = (size_t) size;
  result.data = L_malloc(size * sizeof(N));
  va_list valist;
  va_start(valist, size);
  int i;
  for (i = 0; i < size; i++) {
#if Z_LT_INT
    result.data[i] = (N) va_arg(valist, int);
#else
    result.data[i] = va_arg(valist, N);
#endif
  }
  va_end(valist);

  return result;
}

void L_Z_wipe(Z *n) {
  *n = 0;
}

void L_N_wipe(N *n) {
  *n = 0;
}

void L_ZS_wipe(ZS *ns) {
  size_t size = ns->size;
  size_t i;
  for (i = 0; i < size; i++) {
    L_Z_wipe(&(ns->data[i]));
  }
  L_wipe(ns, sizeof(ZS));
}

void L_NS_wipe(NS *ns) {
  size_t size = ns->size;
  size_t i;
  for (i = 0; i < size; i++) {
    L_N_wipe(&(ns->data[i]));
  }
  L_wipe(ns, sizeof(NS));
}

#endif

void L_U8_wipe(U8 *n) {
  *n = 0;
  L_av(n);
}

void L_U16_wipe(U16 *n) {
  *n = 0;
  L_av(n);
}

void L_U32_wipe(U32 *n) {
  *n = 0;
  L_av(n);
}

void L_U64_wipe(U64 *n) {
  *n = 0;
  L_av(n);
}

S8S L_S8S_create(size_t size, S8 initialValue) {
  S8S result = {0};
  result.size = size;
  result.data = L_malloc(size * sizeof(S8));
  size_t i;
  for (i = 0; i < size; i++) {
    result.data[i] = initialValue;
  }
  return result;
}

S8S L_S8S(int size, ...) {
  S8S result = {0};
  result.size = (size_t) size;
  result.data = L_malloc(size * sizeof(S8));
  va_list valist;
  va_start(valist, size);
  int i;
  for (i = 0; i < size; i++) {
#if Z8_Max < INT_MAX
    result.data[i] = (S8) va_arg(valist, int);
#else
    result.data[i] = va_arg(valist, S8);
#endif
  }
  va_end(valist);

  return result;
}

S16S L_S16S_create(size_t size, S16 initialValue) {
  S16S result = {0};
  result.size = size;
  result.data = L_malloc(size * sizeof(S16));
  size_t i;
  for (i = 0; i < size; i++) {
    result.data[i] = initialValue;
  }
  return result;
}

S16S L_S16S(int size, ...) {
  S16S result = {0};
  result.size = (size_t) size;
  result.data = L_malloc(size * sizeof(S16));
  va_list valist;
  va_start(valist, size);
  int i;
  for (i = 0; i < size; i++) {
#if Z16_Max < INT_MAX
    result.data[i] = (S16) va_arg(valist, int);
#else
    result.data[i] = va_arg(valist, S16);
#endif
  }
  va_end(valist);

  return result;
}

S32S L_S32S_create(size_t size, S32 initialValue) {
  S32S result = {0};
  result.size = size;
  result.data = L_malloc(size * sizeof(S32));
  size_t i;
  for (i = 0; i < size; i++) {
    result.data[i] = initialValue;
  }
  return result;
}

S32S L_S32S(int size, ...) {
  S32S result = {0};
  result.size = (size_t) size;
  result.data = L_malloc(size * sizeof(S32));
  va_list valist;
  va_start(valist, size);
  int i;
  for (i = 0; i < size; i++) {
    result.data[i] = va_arg(valist, S32);
  }
  va_end(valist);

  return result;
}

S64S L_S64S_create(size_t size, S64 initialValue) {
  S64S result = {0};
  result.size = size;
  result.data = L_malloc(size * sizeof(S64));
  size_t i;
  for (i = 0; i < size; i++) {
    result.data[i] = initialValue;
  }
  return result;
}

S64S L_S64S(int size, ...) {
  S64S result = {0};
  result.size = (size_t) size;
  result.data = L_malloc(size * sizeof(S64));
  va_list valist;
  va_start(valist, size);
  int i;
  for (i = 0; i < size; i++) {
    result.data[i] = va_arg(valist, S64);
  }
  va_end(valist);

  return result;
}

U8S L_U8S_create(size_t size, U8 initialValue) {
  U8S result = {0};
  result.size = size;
  result.data = L_malloc(size * sizeof(U8));
  size_t i;
  for (i = 0; i < size; i++) {
    result.data[i] = initialValue;
  }
  return result;
}

U8S L_U8S(int size, ...) {
  U8S result = {0};
  result.size = (size_t) size;
  result.data = L_malloc(size * sizeof(U8));
  va_list valist;
  va_start(valist, size);
  int i;
  for (i = 0; i < size; i++) {
#if Z8_Max < INT_MAX
    result.data[i] = (U8) va_arg(valist, int);
#else
    result.data[i] = va_arg(valist, U8);
#endif
  }
  va_end(valist);

  return result;
}

U16S L_U16S_create(size_t size, U16 initialValue) {
  U16S result = {0};
  result.size = size;
  result.data = L_malloc(size * sizeof(U16));
  size_t i;
  for (i = 0; i < size; i++) {
    result.data[i] = initialValue;
  }
  return result;
}

U16S L_U16S(int size, ...) {
  U16S result = {0};
  result.size = (size_t) size;
  result.data = L_malloc(size * sizeof(U16));
  va_list valist;
  va_start(valist, size);
  int i;
  for (i = 0; i < size; i++) {
#if Z16_Max < INT_MAX
    result.data[i] = (U16) va_arg(valist, int);
#else
    result.data[i] = va_arg(valist, U16);
#endif
  }
  va_end(valist);

  return result;
}

U32S L_U32S_create(size_t size, U32 initialValue) {
  U32S result = {0};
  result.size = size;
  result.data = L_malloc(size * sizeof(U32));
  size_t i;
  for (i = 0; i < size; i++) {
    result.data[i] = initialValue;
  }
  return result;
}

U32S L_U32S(int size, ...) {
  U32S result = {0};
  result.size = (size_t) size;
  result.data = L_malloc(size * sizeof(U32));
  va_list valist;
  va_start(valist, size);
  int i;
  for (i = 0; i < size; i++) {
    result.data[i] = va_arg(valist, U32);
  }
  va_end(valist);

  return result;
}

U64S L_U64S_create(size_t size, U64 initialValue) {
  U64S result = {0};
  result.size = size;
  result.data = L_malloc(size * sizeof(U64));
  size_t i;
  for (i = 0; i < size; i++) {
    result.data[i] = initialValue;
  }
  return result;
}

U64S L_U64S(int size, ...) {
  U64S result = {0};
  result.size = (size_t) size;
  result.data = L_malloc(size * sizeof(U64));
  va_list valist;
  va_start(valist, size);
  int i;
  for (i = 0; i < size; i++) {
    result.data[i] = va_arg(valist, U64);
  }
  va_end(valist);

  return result;
}

F32S L_F32S_create(size_t size, F32 initialValue) {
  F32S result = {0};
  result.size = size;
  result.data = L_malloc(size * sizeof(F32));
  size_t i;
  for (i = 0; i < size; i++) {
    result.data[i] = initialValue;
  }
  return result;
}

F64S L_F64S_create(size_t size, F64 initialValue) {
  F64S result = {0};
  result.size = size;
  result.data = L_malloc(size * sizeof(F64));
  size_t i;
  for (i = 0; i < size; i++) {
    result.data[i] = initialValue;
  }
  return result;
}

S8S L_S8S_prepend(S8 n, S8S ns) {
  L_assert(ns.size < SIZE_T_MAX);
  S8S result = {0};
  size_t size = ns.size + 1;
  result.size = size;
  result.data = L_malloc(sizeof(S8) * size);
  result.data[0] = n;
  memcpy(&(result.data[1]), ns.data, ns.size);
  return result;
}

S8S L_S8S_prependf(S8 n, S8S ns) {
  S8S result = L_S8S_prepend(n, ns);
  L_S8S_wipe(&ns);
  return result;
}

S8S L_S8S_append(S8S ns, S8 n) {
  L_assert(ns.size < SIZE_T_MAX);
  S8S result = {0};
  size_t size = ns.size + 1;
  result.size = size;
  result.data = L_malloc(sizeof(S8) * size);
  result.data[size - 1] = n;
  memcpy(result.data, ns.data, ns.size);
  return result;
}

S8S L_S8S_appendf(S8S ns, S8 n) {
  S8S result = L_S8S_append(ns, n);
  L_S8S_wipe(&ns);
  return result;
}

S8S L_S8S_appends(S8S ns1, S8S ns2) {
  L_assert(ns1.size + ns2.size < SIZE_T_MAX);
  S8S result = {0};
  size_t size = ns1.size + ns2.size;
  result.size = size;
  result.data = L_malloc(sizeof(S8) * size);
  memcpy(result.data, ns1.data, ns1.size);
  memcpy(&(result.data[ns1.size]), ns2.data, ns2.size);
  return result;
}

S8S L_S8S_appendsl(S8S ns1, S8S ns2) {
  S8S result = L_S8S_appends(ns1, ns2);
  L_S8S_wipe(&ns1);
  return result;
}

S8S L_S8S_appendsr(S8S ns1, S8S ns2) {
  S8S result = L_S8S_appends(ns1, ns2);
  L_S8S_wipe(&ns2);
  return result;
}

S8S L_S8S_appendslr(S8S ns1, S8S ns2) {
  S8S result = L_S8S_appends(ns1, ns2);
  L_S8S_wipe(&ns1);
  L_S8S_wipe(&ns2);
  return result;
}

S16S L_S16S_prepend(S16 n, S16S ns) {
  L_assert(ns.size < SIZE_T_MAX);
  S16S result = {0};
  size_t size = ns.size + 1;
  result.size = size;
  result.data = L_malloc(sizeof(S16) * size);
  result.data[0] = n;
  memcpy(&(result.data[1]), ns.data, ns.size);
  return result;
}

S16S L_S16S_prependf(S16 n, S16S ns) {
  S16S result = L_S16S_prepend(n, ns);
  L_S16S_wipe(&ns);
  return result;
}

S16S L_S16S_append(S16S ns, S16 n) {
  L_assert(ns.size < SIZE_T_MAX);
  S16S result = {0};
  size_t size = ns.size + 1;
  result.size = size;
  result.data = L_malloc(sizeof(S16) * size);
  result.data[size - 1] = n;
  memcpy(result.data, ns.data, ns.size);
  return result;
}

S16S L_S16S_appendf(S16S ns, S16 n) {
  S16S result = L_S16S_append(ns, n);
  L_S16S_wipe(&ns);
  return result;
}

S16S L_S16S_appends(S16S ns1, S16S ns2) {
  L_assert(ns1.size + ns2.size < SIZE_T_MAX);
  S16S result = {0};
  size_t size = ns1.size + ns2.size;
  result.size = size;
  result.data = L_malloc(sizeof(S16) * size);
  memcpy(result.data, ns1.data, ns1.size);
  memcpy(&(result.data[ns1.size]), ns2.data, ns2.size);
  return result;
}

S16S L_S16S_appendsl(S16S ns1, S16S ns2) {
  S16S result = L_S16S_appends(ns1, ns2);
  L_S16S_wipe(&ns1);
  return result;
}

S16S L_S16S_appendsr(S16S ns1, S16S ns2) {
  S16S result = L_S16S_appends(ns1, ns2);
  L_S16S_wipe(&ns2);
  return result;
}

S16S L_S16S_appendslr(S16S ns1, S16S ns2) {
  S16S result = L_S16S_appends(ns1, ns2);
  L_S16S_wipe(&ns1);
  L_S16S_wipe(&ns2);
  return result;
}

S32S L_S32S_prepend(S32 n, S32S ns) {
  L_assert(ns.size < SIZE_T_MAX);
  S32S result = {0};
  size_t size = ns.size + 1;
  result.size = size;
  result.data = L_malloc(sizeof(S32) * size);
  result.data[0] = n;
  memcpy(&(result.data[1]), ns.data, ns.size);
  return result;
}

S32S L_S32S_prependf(S32 n, S32S ns) {
  S32S result = L_S32S_prepend(n, ns);
  L_S32S_wipe(&ns);
  return result;
}

S32S L_S32S_append(S32S ns, S32 n) {
  L_assert(ns.size < SIZE_T_MAX);
  S32S result = {0};
  size_t size = ns.size + 1;
  result.size = size;
  result.data = L_malloc(sizeof(S32) * size);
  result.data[size - 1] = n;
  memcpy(result.data, ns.data, ns.size);
  return result;
}

S32S L_S32S_appendf(S32S ns, S32 n) {
  S32S result = L_S32S_append(ns, n);
  L_S32S_wipe(&ns);
  return result;
}

S32S L_S32S_appends(S32S ns1, S32S ns2) {
  L_assert(ns1.size + ns2.size < SIZE_T_MAX);
  S32S result = {0};
  size_t size = ns1.size + ns2.size;
  result.size = size;
  result.data = L_malloc(sizeof(S32) * size);
  memcpy(result.data, ns1.data, ns1.size);
  memcpy(&(result.data[ns1.size]), ns2.data, ns2.size);
  return result;
}

S32S L_S32S_appendsl(S32S ns1, S32S ns2) {
  S32S result = L_S32S_appends(ns1, ns2);
  L_S32S_wipe(&ns1);
  return result;
}

S32S L_S32S_appendsr(S32S ns1, S32S ns2) {
  S32S result = L_S32S_appends(ns1, ns2);
  L_S32S_wipe(&ns2);
  return result;
}

S32S L_S32S_appendslr(S32S ns1, S32S ns2) {
  S32S result = L_S32S_appends(ns1, ns2);
  L_S32S_wipe(&ns1);
  L_S32S_wipe(&ns2);
  return result;
}

S64S L_S64S_prepend(S64 n, S64S ns) {
  L_assert(ns.size < SIZE_T_MAX);
  S64S result = {0};
  size_t size = ns.size + 1;
  result.size = size;
  result.data = L_malloc(sizeof(S64) * size);
  result.data[0] = n;
  memcpy(&(result.data[1]), ns.data, ns.size);
  return result;
}

S64S L_S64S_prependf(S64 n, S64S ns) {
  S64S result = L_S64S_prepend(n, ns);
  L_S64S_wipe(&ns);
  return result;
}

S64S L_S64S_append(S64S ns, S64 n) {
  L_assert(ns.size < SIZE_T_MAX);
  S64S result = {0};
  size_t size = ns.size + 1;
  result.size = size;
  result.data = L_malloc(sizeof(S64) * size);
  result.data[size - 1] = n;
  memcpy(result.data, ns.data, ns.size);
  return result;
}

S64S L_S64S_appendf(S64S ns, S64 n) {
  S64S result = L_S64S_append(ns, n);
  L_S64S_wipe(&ns);
  return result;
}

S64S L_S64S_appends(S64S ns1, S64S ns2) {
  L_assert(ns1.size + ns2.size < SIZE_T_MAX);
  S64S result = {0};
  size_t size = ns1.size + ns2.size;
  result.size = size;
  result.data = L_malloc(sizeof(S64) * size);
  memcpy(result.data, ns1.data, ns1.size);
  memcpy(&(result.data[ns1.size]), ns2.data, ns2.size);
  return result;
}

S64S L_S64S_appendsl(S64S ns1, S64S ns2) {
  S64S result = L_S64S_appends(ns1, ns2);
  L_S64S_wipe(&ns1);
  return result;
}

S64S L_S64S_appendsr(S64S ns1, S64S ns2) {
  S64S result = L_S64S_appends(ns1, ns2);
  L_S64S_wipe(&ns2);
  return result;
}

S64S L_S64S_appendslr(S64S ns1, S64S ns2) {
  S64S result = L_S64S_appends(ns1, ns2);
  L_S64S_wipe(&ns1);
  L_S64S_wipe(&ns2);
  return result;
}

U8S L_U8S_prepend(U8 n, U8S ns) {
  L_assert(ns.size < SIZE_T_MAX);
  U8S result = {0};
  size_t size = ns.size + 1;
  result.size = size;
  result.data = L_malloc(sizeof(U8) * size);
  result.data[0] = n;
  memcpy(&(result.data[1]), ns.data, ns.size);
  return result;
}

U8S L_U8S_prependf(U8 n, U8S ns) {
  U8S result = L_U8S_prepend(n, ns);
  L_U8S_wipe(&ns);
  return result;
}

U8S L_U8S_append(U8S ns, U8 n) {
  L_assert(ns.size < SIZE_T_MAX);
  U8S result = {0};
  size_t size = ns.size + 1;
  result.size = size;
  result.data = L_malloc(sizeof(U8) * size);
  result.data[size - 1] = n;
  memcpy(result.data, ns.data, ns.size);
  return result;
}

U8S L_U8S_appendf(U8S ns, U8 n) {
  U8S result = L_U8S_append(ns, n);
  L_U8S_wipe(&ns);
  return result;
}

U8S L_U8S_appends(U8S ns1, U8S ns2) {
  L_assert(ns1.size + ns2.size < SIZE_T_MAX);
  U8S result = {0};
  size_t size = ns1.size + ns2.size;
  result.size = size;
  result.data = L_malloc(sizeof(U8) * size);
  memcpy(result.data, ns1.data, ns1.size);
  memcpy(&(result.data[ns1.size]), ns2.data, ns2.size);
  return result;
}

U8S L_U8S_appendsl(U8S ns1, U8S ns2) {
  U8S result = L_U8S_appends(ns1, ns2);
  L_U8S_wipe(&ns1);
  return result;
}

U8S L_U8S_appendsr(U8S ns1, U8S ns2) {
  U8S result = L_U8S_appends(ns1, ns2);
  L_U8S_wipe(&ns2);
  return result;
}

U8S L_U8S_appendslr(U8S ns1, U8S ns2) {
  U8S result = L_U8S_appends(ns1, ns2);
  L_U8S_wipe(&ns1);
  L_U8S_wipe(&ns2);
  return result;
}

U16S L_U16S_prepend(U16 n, U16S ns) {
  L_assert(ns.size < SIZE_T_MAX);
  U16S result = {0};
  size_t size = ns.size + 1;
  result.size = size;
  result.data = L_malloc(sizeof(U16) * size);
  result.data[0] = n;
  memcpy(&(result.data[1]), ns.data, ns.size);
  return result;
}

U16S L_U16S_prependf(U16 n, U16S ns) {
  U16S result = L_U16S_prepend(n, ns);
  L_U16S_wipe(&ns);
  return result;
}

U16S L_U16S_append(U16S ns, U16 n) {
  L_assert(ns.size < SIZE_T_MAX);
  U16S result = {0};
  size_t size = ns.size + 1;
  result.size = size;
  result.data = L_malloc(sizeof(U16) * size);
  result.data[size - 1] = n;
  memcpy(result.data, ns.data, ns.size);
  return result;
}

U16S L_U16S_appendf(U16S ns, U16 n) {
  U16S result = L_U16S_append(ns, n);
  L_U16S_wipe(&ns);
  return result;
}

U16S L_U16S_appends(U16S ns1, U16S ns2) {
  L_assert(ns1.size + ns2.size < SIZE_T_MAX);
  U16S result = {0};
  size_t size = ns1.size + ns2.size;
  result.size = size;
  result.data = L_malloc(sizeof(U16) * size);
  memcpy(result.data, ns1.data, ns1.size);
  memcpy(&(result.data[ns1.size]), ns2.data, ns2.size);
  return result;
}

U16S L_U16S_appendsl(U16S ns1, U16S ns2) {
  U16S result = L_U16S_appends(ns1, ns2);
  L_U16S_wipe(&ns1);
  return result;
}

U16S L_U16S_appendsr(U16S ns1, U16S ns2) {
  U16S result = L_U16S_appends(ns1, ns2);
  L_U16S_wipe(&ns2);
  return result;
}

U16S L_U16S_appendslr(U16S ns1, U16S ns2) {
  U16S result = L_U16S_appends(ns1, ns2);
  L_U16S_wipe(&ns1);
  L_U16S_wipe(&ns2);
  return result;
}

U32S L_U32S_prepend(U32 n, U32S ns) {
  L_assert(ns.size < SIZE_T_MAX);
  U32S result = {0};
  size_t size = ns.size + 1;
  result.size = size;
  result.data = L_malloc(sizeof(U32) * size);
  result.data[0] = n;
  memcpy(&(result.data[1]), ns.data, ns.size);
  return result;
}

U32S L_U32S_prependf(U32 n, U32S ns) {
  U32S result = L_U32S_prepend(n, ns);
  L_U32S_wipe(&ns);
  return result;
}

U32S L_U32S_append(U32S ns, U32 n) {
  L_assert(ns.size < SIZE_T_MAX);
  U32S result = {0};
  size_t size = ns.size + 1;
  result.size = size;
  result.data = L_malloc(sizeof(U32) * size);
  result.data[size - 1] = n;
  memcpy(result.data, ns.data, ns.size);
  return result;
}

U32S L_U32S_appendf(U32S ns, U32 n) {
  U32S result = L_U32S_append(ns, n);
  L_U32S_wipe(&ns);
  return result;
}

U32S L_U32S_appends(U32S ns1, U32S ns2) {
  L_assert(ns1.size + ns2.size < SIZE_T_MAX);
  U32S result = {0};
  size_t size = ns1.size + ns2.size;
  result.size = size;
  result.data = L_malloc(sizeof(U32) * size);
  memcpy(result.data, ns1.data, ns1.size);
  memcpy(&(result.data[ns1.size]), ns2.data, ns2.size);
  return result;
}

U32S L_U32S_appendsl(U32S ns1, U32S ns2) {
  U32S result = L_U32S_appends(ns1, ns2);
  L_U32S_wipe(&ns1);
  return result;
}

U32S L_U32S_appendsr(U32S ns1, U32S ns2) {
  U32S result = L_U32S_appends(ns1, ns2);
  L_U32S_wipe(&ns2);
  return result;
}

U32S L_U32S_appendslr(U32S ns1, U32S ns2) {
  U32S result = L_U32S_appends(ns1, ns2);
  L_U32S_wipe(&ns1);
  L_U32S_wipe(&ns2);
  return result;
}

U64S L_U64S_prepend(U64 n, U64S ns) {
  L_assert(ns.size < SIZE_T_MAX);
  U64S result = {0};
  size_t size = ns.size + 1;
  result.size = size;
  result.data = L_malloc(sizeof(U64) * size);
  result.data[0] = n;
  memcpy(&(result.data[1]), ns.data, ns.size);
  return result;
}

U64S L_U64S_prependf(U64 n, U64S ns) {
  U64S result = L_U64S_prepend(n, ns);
  L_U64S_wipe(&ns);
  return result;
}

U64S L_U64S_append(U64S ns, U64 n) {
  L_assert(ns.size < SIZE_T_MAX);
  U64S result = {0};
  size_t size = ns.size + 1;
  result.size = size;
  result.data = L_malloc(sizeof(U64) * size);
  result.data[size - 1] = n;
  memcpy(result.data, ns.data, ns.size);
  return result;
}

U64S L_U64S_appendf(U64S ns, U64 n) {
  U64S result = L_U64S_append(ns, n);
  L_U64S_wipe(&ns);
  return result;
}

U64S L_U64S_appends(U64S ns1, U64S ns2) {
  L_assert(ns1.size + ns2.size < SIZE_T_MAX);
  U64S result = {0};
  size_t size = ns1.size + ns2.size;
  result.size = size;
  result.data = L_malloc(sizeof(U64) * size);
  memcpy(result.data, ns1.data, ns1.size);
  memcpy(&(result.data[ns1.size]), ns2.data, ns2.size);
  return result;
}

U64S L_U64S_appendsl(U64S ns1, U64S ns2) {
  U64S result = L_U64S_appends(ns1, ns2);
  L_U64S_wipe(&ns1);
  return result;
}

U64S L_U64S_appendsr(U64S ns1, U64S ns2) {
  U64S result = L_U64S_appends(ns1, ns2);
  L_U64S_wipe(&ns2);
  return result;
}

U64S L_U64S_appendslr(U64S ns1, U64S ns2) {
  U64S result = L_U64S_appends(ns1, ns2);
  L_U64S_wipe(&ns1);
  L_U64S_wipe(&ns2);
  return result;
}

#if BIT_WIDTH == 0

ZS L_ZS_prepend(Z n, ZS ns) {
  L_assert(ns.size < SIZE_T_MAX);
  ZS result = {0};
  size_t size = ns.size + 1;
  result.size = size;
  result.data = L_malloc(sizeof(Z) * size);
  result.data[0] = n;
  memcpy(&(result.data[1]), ns.data, ns.size);
  return result;
}

ZS L_ZS_prependf(Z n, ZS ns) {
  ZS result = L_ZS_prepend(n, ns);
  L_ZS_wipe(&ns);
  return result;
}

ZS L_ZS_append(ZS ns, Z n) {
  L_assert(ns.size < SIZE_T_MAX);
  ZS result = {0};
  size_t size = ns.size + 1;
  result.size = size;
  result.data = L_malloc(sizeof(Z) * size);
  result.data[size - 1] = n;
  memcpy(result.data, ns.data, ns.size);
  return result;
}

ZS L_ZS_appendf(ZS ns, Z n) {
  ZS result = L_ZS_append(ns, n);
  L_ZS_wipe(&ns);
  return result;
}

ZS L_ZS_appends(ZS ns1, ZS ns2) {
  L_assert(ns1.size + ns2.size < SIZE_T_MAX);
  ZS result = {0};
  size_t size = ns1.size + ns2.size;
  result.size = size;
  result.data = L_malloc(sizeof(Z) * size);
  memcpy(result.data, ns1.data, ns1.size);
  memcpy(&(result.data[ns1.size]), ns2.data, ns2.size);
  return result;
}

ZS L_ZS_appendsl(ZS ns1, ZS ns2) {
  ZS result = L_ZS_appends(ns1, ns2);
  L_ZS_wipe(&ns1);
  return result;
}

ZS L_ZS_appendsr(ZS ns1, ZS ns2) {
  ZS result = L_ZS_appends(ns1, ns2);
  L_ZS_wipe(&ns2);
  return result;
}

ZS L_ZS_appendslr(ZS ns1, ZS ns2) {
  ZS result = L_ZS_appends(ns1, ns2);
  L_ZS_wipe(&ns1);
  L_ZS_wipe(&ns2);
  return result;
}

#endif

void L_S8S_wipe(S8S *ns) {
  L_wipe(ns->data, sizeof(S8) * ns->size);
  free(ns->data);
  L_wipe(ns, sizeof(S8S));
}

void L_S16S_wipe(S16S *ns) {
  L_wipe(ns->data, sizeof(S16) * ns->size);
  free(ns->data);
  L_wipe(ns, sizeof(S16S));
}

void L_S32S_wipe(S32S *ns) {
  L_wipe(ns->data, sizeof(S32) * ns->size);
  free(ns->data);
  L_wipe(ns, sizeof(S32S));
}

void L_S64S_wipe(S64S *ns) {
  L_wipe(ns->data, sizeof(S64) * ns->size);
  free(ns->data);
  L_wipe(ns, sizeof(S64S));
}

void L_U8S_wipe(U8S *ns) {
  L_wipe(ns->data, sizeof(U8) * ns->size);
  free(ns->data);
  L_wipe(ns, sizeof(U8S));
}

void L_U16S_wipe(U16S *ns) {
  L_wipe(ns->data, sizeof(U16) * ns->size);
  free(ns->data);
  L_wipe(ns, sizeof(U16S));
}

void L_U32S_wipe(U32S *ns) {
  L_wipe(ns->data, sizeof(U32) * ns->size);
  free(ns->data);
  L_wipe(ns, sizeof(U32S));
}

void L_U64S_wipe(U64S *ns) {
  L_wipe(ns->data, sizeof(U64) * ns->size);
  free(ns->data);
  L_wipe(ns, sizeof(U64S));
}

void L_F32S_wipe(F32S *ns) {
  L_wipe(ns->data, sizeof(F32) * ns->size);
  free(ns->data);
  L_wipe(ns, sizeof(F32S));
}

void L_F64S_wipe(F64S *ns) {
  L_wipe(ns->data, sizeof(F64) * ns->size);
  free(ns->data);
  L_wipe(ns, sizeof(F64S));
}

static void __EV() {
  U8 __EV_F32_IS_32[1 - (2 * ((sizeof(F32) * CHAR_BIT) != 32))];
  U8 __EV_F64_IS_64[1 - (2 * ((sizeof(F64) * CHAR_BIT) != 64))];
#if SIZE_T_MAX > ULONG_MAX
  U8 __EV_SIZE_T_ULONG2X[1 - (2 * (sizeof(size_t) != 2 * sizeof(unsigned long int)))];
#endif
  L_assert(F);
}

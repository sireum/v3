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

void * L_malloc(size_t size) {
  void * result = malloc(size);
  L_assert(result != NULL);
  return result;
}

void * L_realloc(void * ptr, size_t size) {
  void * result = realloc(ptr, size);
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
#if SIZE_MAX > ULONG_MAX
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

Z L_Z_str(L_string n) {
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
  L_assert(size <= SIZE_MAX);
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

void L_Z8_wipe(Z8 *n) {
  *n = 0;
  L_av(n);
}

void L_Z16_wipe(Z16 *n) {
  *n = 0;
  L_av(n);
}

void L_Z32_wipe(Z32 *n) {
  *n = 0;
  L_av(n);
}

void L_Z64_wipe(Z64 *n) {
  *n = 0;
  L_av(n);
}

Z8S L_Z8S_create(size_t size, Z8 initialValue) {
  Z8S result = {0};
  result.size = size;
  result.data = L_malloc(size * sizeof(Z8));
  size_t i;
  for (i = 0; i < size; i++) {
    result.data[i] = initialValue;
  }
  return result;
}

Z8S L_Z8S(int size, ...) {
  Z8S result = {0};
  result.size = (size_t) size;
  result.data = L_malloc(size * sizeof(Z8));
  va_list valist;
  va_start(valist, size);
  int i;
  for (i = 0; i < size; i++) {
#if Z8_Max < INT_MAX
    result.data[i] = (Z8) va_arg(valist, int);
#else
    result.data[i] = va_arg(valist, Z8);
#endif
  }
  va_end(valist);

  return result;
}

Z16S L_Z16S_create(size_t size, Z16 initialValue) {
  Z16S result = {0};
  result.size = size;
  result.data = L_malloc(size * sizeof(Z16));
  size_t i;
  for (i = 0; i < size; i++) {
    result.data[i] = initialValue;
  }
  return result;
}

Z16S L_Z16S(int size, ...) {
  Z16S result = {0};
  result.size = (size_t) size;
  result.data = L_malloc(size * sizeof(Z16));
  va_list valist;
  va_start(valist, size);
  int i;
  for (i = 0; i < size; i++) {
#if Z16_Max < INT_MAX
    result.data[i] = (Z16) va_arg(valist, int);
#else
    result.data[i] = va_arg(valist, Z16);
#endif
  }
  va_end(valist);

  return result;
}

Z32S L_Z32S_create(size_t size, Z32 initialValue) {
  Z32S result = {0};
  result.size = size;
  result.data = L_malloc(size * sizeof(Z32));
  size_t i;
  for (i = 0; i < size; i++) {
    result.data[i] = initialValue;
  }
  return result;
}

Z32S L_Z32S(int size, ...) {
  Z32S result = {0};
  result.size = (size_t) size;
  result.data = L_malloc(size * sizeof(Z32));
  va_list valist;
  va_start(valist, size);
  int i;
  for (i = 0; i < size; i++) {
    result.data[i] = va_arg(valist, Z32);
  }
  va_end(valist);

  return result;
}

Z64S L_Z64S_create(size_t size, Z64 initialValue) {
  Z64S result = {0};
  result.size = size;
  result.data = L_malloc(size * sizeof(Z64));
  size_t i;
  for (i = 0; i < size; i++) {
    result.data[i] = initialValue;
  }
  return result;
}

Z64S L_Z64S(int size, ...) {
  Z64S result = {0};
  result.size = (size_t) size;
  result.data = L_malloc(size * sizeof(Z64));
  va_list valist;
  va_start(valist, size);
  int i;
  for (i = 0; i < size; i++) {
    result.data[i] = va_arg(valist, Z64);
  }
  va_end(valist);

  return result;
}

N8S L_N8S_create(size_t size, N8 initialValue) {
  N8S result = {0};
  result.size = size;
  result.data = L_malloc(size * sizeof(N8));
  size_t i;
  for (i = 0; i < size; i++) {
    result.data[i] = initialValue;
  }
  return result;
}

N8S L_N8S(int size, ...) {
  N8S result = {0};
  result.size = (size_t) size;
  result.data = L_malloc(size * sizeof(N8));
  va_list valist;
  va_start(valist, size);
  int i;
  for (i = 0; i < size; i++) {
#if Z8_Max < INT_MAX
    result.data[i] = (N8) va_arg(valist, int);
#else
    result.data[i] = va_arg(valist, N8);
#endif
  }
  va_end(valist);

  return result;
}

N16S L_N16S_create(size_t size, N16 initialValue) {
  N16S result = {0};
  result.size = size;
  result.data = L_malloc(size * sizeof(N16));
  size_t i;
  for (i = 0; i < size; i++) {
    result.data[i] = initialValue;
  }
  return result;
}

N16S L_N16S(int size, ...) {
  N16S result = {0};
  result.size = (size_t) size;
  result.data = L_malloc(size * sizeof(N16));
  va_list valist;
  va_start(valist, size);
  int i;
  for (i = 0; i < size; i++) {
#if Z16_Max < INT_MAX
    result.data[i] = (N16) va_arg(valist, int);
#else
    result.data[i] = va_arg(valist, N16);
#endif
  }
  va_end(valist);

  return result;
}

N32S L_N32S_create(size_t size, N32 initialValue) {
  N32S result = {0};
  result.size = size;
  result.data = L_malloc(size * sizeof(N32));
  size_t i;
  for (i = 0; i < size; i++) {
    result.data[i] = initialValue;
  }
  return result;
}

N32S L_N32S(int size, ...) {
  N32S result = {0};
  result.size = (size_t) size;
  result.data = L_malloc(size * sizeof(N32));
  va_list valist;
  va_start(valist, size);
  int i;
  for (i = 0; i < size; i++) {
    result.data[i] = va_arg(valist, N32);
  }
  va_end(valist);

  return result;
}

N64S L_N64S_create(size_t size, N64 initialValue) {
  N64S result = {0};
  result.size = size;
  result.data = L_malloc(size * sizeof(N64));
  size_t i;
  for (i = 0; i < size; i++) {
    result.data[i] = initialValue;
  }
  return result;
}

N64S L_N64S(int size, ...) {
  N64S result = {0};
  result.size = (size_t) size;
  result.data = L_malloc(size * sizeof(N64));
  va_list valist;
  va_start(valist, size);
  int i;
  for (i = 0; i < size; i++) {
    result.data[i] = va_arg(valist, N64);
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

void L_Z8S_wipe(Z8S *ns) {
  L_wipe(ns->data, sizeof(Z8) * ns->size);
  free(ns->data);
  L_wipe(ns, sizeof(Z8S));
}

void L_Z16S_wipe(Z16S *ns) {
  L_wipe(ns->data, sizeof(Z16) * ns->size);
  free(ns->data);
  L_wipe(ns, sizeof(Z16S));
}

void L_Z32S_wipe(Z32S *ns) {
  L_wipe(ns->data, sizeof(Z32) * ns->size);
  free(ns->data);
  L_wipe(ns, sizeof(Z32S));
}

void L_Z64S_wipe(Z64S *ns) {
  L_wipe(ns->data, sizeof(Z64) * ns->size);
  free(ns->data);
  L_wipe(ns, sizeof(Z64S));
}

void L_N8S_wipe(N8S *ns) {
  L_wipe(ns->data, sizeof(N8) * ns->size);
  free(ns->data);
  L_wipe(ns, sizeof(N8S));
}

void L_N16S_wipe(N16S *ns) {
  L_wipe(ns->data, sizeof(N16) * ns->size);
  free(ns->data);
  L_wipe(ns, sizeof(N16S));
}

void L_N32S_wipe(N32S *ns) {
  L_wipe(ns->data, sizeof(N32) * ns->size);
  free(ns->data);
  L_wipe(ns, sizeof(N32S));
}

void L_N64S_wipe(N64S *ns) {
  L_wipe(ns->data, sizeof(N64) * ns->size);
  free(ns->data);
  L_wipe(ns, sizeof(Z64S));
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
  L_assert(F);
}

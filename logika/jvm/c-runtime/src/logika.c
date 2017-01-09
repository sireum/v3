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

Z L_st2Z(size_t n) {
  Z result = {0};
  if (n < ULONG_MAX) {
    mpz_init_set_ui(result.data, n);
  } else {
    size_t length = snprintf(NULL, 0, "%zu", n);
    char *str = L_malloc(length + 1);
    snprintf(str, length + 1, "%zu", n);
    mpz_init_set_str(result.data, str, 10);
    free(str);
  }
  return result;
}

static bool L_Z_fits_size_t(Z n) {
  L_assert(mpz_cmp_ui(n.data, 0) >= 0);
  return mpz_sizeinbase(n.data, 2) <= BITS_PER_SIZE_T;
}

size_t L_Z2st(Z n) {
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

size_t L_Z2stf(Z n) {
  size_t result = L_Z2st(n);
  L_wipe_Z(&n);
  return result;
}

Z L_Zsi(long int n) {
  Z result = {0};
  mpz_init_set_si(result.data, n);
  return result;
}

Z L_Zui(unsigned long int n) {
  Z result = {0};
  mpz_init_set_ui(result.data, n);
  return result;
}

Z L_Zstr(char *n) {
  Z result = {0};
  mpz_init_set_str(result.data, n, 10);
  return result;
}

Z L_neg_Z(Z n) {
  Z result = {0};
  mpz_init(result.data);
  mpz_neg(result.data, n.data);
  return result;
}

Z L_neg_Zf(Z n) {
  Z result = L_neg_Z(n);
  L_wipe_Z(&n);
  return result;
}

Z L_add_Z(Z n, Z m) {
  Z result = {0};
  mpz_init(result.data);
  mpz_add(result.data, n.data, m.data);
  return result;
}

Z L_add_Zl(Z n, Z m) {
  Z result = L_add_Z(n, m);
  L_wipe_Z(&n);
  return result;
}

Z L_add_Zr(Z n, Z m) {
  Z result = L_add_Z(n, m);
  L_wipe_Z(&m);
  return result;
}

Z L_add_Zlr(Z n, Z m) {
  Z result = L_add_Z(n, m);
  L_wipe_Z(&n);
  L_wipe_Z(&m);
  return result;
}

Z L_sub_Z(Z n, Z m) {
  Z result = {0};
  mpz_init(result.data);
  mpz_sub(result.data, n.data, m.data);
  return result;
}

Z L_sub_Zl(Z n, Z m) {
  Z result = L_sub_Z(n, m);
  L_wipe_Z(&n);
  return result;
}

Z L_sub_Zr(Z n, Z m) {
  Z result = L_sub_Z(n, m);
  L_wipe_Z(&m);
  return result;
}

Z L_sub_Zlr(Z n, Z m) {
  Z result = L_sub_Z(n, m);
  L_wipe_Z(&n);
  L_wipe_Z(&m);
  return result;
}

Z L_mul_Z(Z n, Z m) {
  Z result = {0};
  mpz_init(result.data);
  mpz_mul(result.data, n.data, m.data);
  return result;
}

Z L_mul_Zl(Z n, Z m) {
  Z result = L_mul_Z(n, m);
  L_wipe_Z(&n);
  return result;
}

Z L_mul_Zr(Z n, Z m) {
  Z result = L_mul_Z(n, m);
  L_wipe_Z(&m);
  return result;
}

Z L_mul_Zlr(Z n, Z m) {
  Z result = L_mul_Z(n, m);
  L_wipe_Z(&n);
  L_wipe_Z(&m);
  return result;
}

Z L_div_Z(Z n, Z m) {
  L_assert(mpz_cmp_ui(m.data, 0) != 0);
  Z result = {0};
  mpz_init(result.data);
  mpz_tdiv_q(result.data, n.data, m.data);
  return result;
}

Z L_div_Zl(Z n, Z m) {
  Z result = L_div_Z(n, m);
  L_wipe_Z(&n);
  return result;
}

Z L_div_Zr(Z n, Z m) {
  Z result = L_div_Z(n, m);
  L_wipe_Z(&m);
  return result;
}

Z L_div_Zlr(Z n, Z m) {
  Z result = L_div_Z(n, m);
  L_wipe_Z(&n);
  L_wipe_Z(&m);
  return result;
}

Z L_rem_Z(Z n, Z m) {
  L_assert(mpz_cmp_ui(m.data, 0) != 0);
  Z result = {0};
  mpz_init(result.data);
  mpz_tdiv_r(result.data, n.data, m.data);
  return result;
}

Z L_rem_Zl(Z n, Z m) {
  Z result = L_rem_Z(n, m);
  L_wipe_Z(&n);
  return result;
}

Z L_rem_Zr(Z n, Z m) {
  Z result = L_rem_Z(n, m);
  L_wipe_Z(&m);
  return result;
}

Z L_rem_Zlr(Z n, Z m) {
  Z result = L_rem_Z(n, m);
  L_wipe_Z(&n);
  L_wipe_Z(&m);
  return result;
}

B L_eq_Z(Z n, Z m) {
  return mpz_cmp(n.data, m.data) == 0;
}

B L_eq_Zl(Z n, Z m) {
  B result = L_eq_Z(n, m);
  L_wipe_N(&n);
  return result;
}

B L_eq_Zr(Z n, Z m) {
  B result = L_eq_Z(n, m);
  L_wipe_N(&m);
  return result;
}

B L_eq_Zlr(Z n, Z m) {
  B result = L_eq_Z(n, m);
  L_wipe_N(&n);
  L_wipe_N(&m);
  return result;
}

B L_lt_Z(Z n, Z m) {
  return mpz_cmp(n.data, m.data) < 0;
}

B L_lt_Zl(Z n, Z m) {
  B result = L_lt_Z(n, m);
  L_wipe_N(&n);
  return result;
}

B L_lt_Zr(Z n, Z m) {
  B result = L_lt_Z(n, m);
  L_wipe_N(&m);
  return result;
}

B L_lt_Zlr(Z n, Z m) {
  B result = L_lt_Z(n, m);
  L_wipe_N(&n);
  L_wipe_N(&m);
  return result;
}

B L_gt_Z(Z n, Z m) {
  return mpz_cmp(n.data, m.data) > 0;
}

B L_gt_Zl(Z n, Z m) {
  B result = L_gt_Z(n, m);
  L_wipe_N(&n);
  return result;
}

B L_gt_Zr(Z n, Z m) {
  B result = L_gt_Z(n, m);
  L_wipe_N(&m);
  return result;
}

B L_gt_Zlr(Z n, Z m) {
  B result = L_gt_Z(n, m);
  L_wipe_N(&n);
  L_wipe_N(&m);
  return result;
}

N L_add_N(N n, N m) {
  N result = {0};
  mpz_init(result.data);
  mpz_add(result.data, n.data, m.data);
  L_assert(mpz_cmp_ui(result.data, 0) >= 0);
  return result;
}

N L_add_Nl(N n, N m) {
  N result = L_add_N(n, m);
  L_wipe_N(&n);
  return result;
}

N L_add_Nr(N n, N m) {
  N result = L_add_N(n, m);
  L_wipe_N(&m);
  return result;
}

N L_add_Nlr(N n, N m) {
  N result = L_add_N(n, m);
  L_wipe_N(&n);
  L_wipe_N(&m);
  return result;
}

N L_sub_N(N n, N m) {
  N result = {0};
  mpz_init(result.data);
  mpz_sub(result.data, n.data, m.data);
  L_assert(mpz_cmp_ui(result.data, 0) >= 0);
  return result;
}

N L_sub_Nl(N n, N m) {
  N result = L_sub_N(n, m);
  L_wipe_N(&n);
  return result;
}

N L_sub_Nr(N n, N m) {
  N result = L_sub_N(n, m);
  L_wipe_N(&m);
  return result;
}

N L_subl_Nr(N n, N m) {
  N result = L_sub_N(n, m);
  L_wipe_N(&n);
  L_wipe_N(&m);
  return result;
}

N L_mul_N(N n, N m) {
  N result = {0};
  mpz_init(result.data);
  mpz_mul(result.data, n.data, m.data);
  L_assert(mpz_cmp_ui(result.data, 0) >= 0);
  return result;
}

N L_mul_Nl(N n, N m) {
  N result = L_mul_N(n, m);
  L_wipe_N(&n);
  return result;
}

N L_mul_Nr(N n, N m) {
  N result = L_mul_N(n, m);
  L_wipe_N(&m);
  return result;
}

N L_mul_Nlr(N n, N m) {
  N result = L_mul_N(n, m);
  L_wipe_N(&n);
  L_wipe_N(&m);
  return result;
}

N L_div_N(N n, N m) {
  L_assert(mpz_cmp_ui(m.data, 0) != 0);
  N result = {0};
  mpz_init(result.data);
  mpz_tdiv_q(result.data, n.data, m.data);
  L_assert(mpz_cmp_ui(result.data, 0) >= 0);
  return result;
}

N L_div_Nl(N n, N m) {
  N result = L_div_N(n, m);
  L_wipe_N(&n);
  return result;
}

N L_div_Nr(N n, N m) {
  N result = L_div_N(n, m);
  L_wipe_N(&m);
  return result;
}

N L_div_Nlr(N n, N m) {
  N result = L_div_N(n, m);
  L_wipe_N(&n);
  L_wipe_N(&m);
  return result;
}

N L_rem_N(N n, N m) {
  L_assert(mpz_cmp_ui(m.data, 0) != 0);
  N result = {0};
  mpz_init(result.data);
  mpz_tdiv_r(result.data, n.data, m.data);
  L_assert(mpz_cmp_ui(result.data, 0) >= 0);
  return result;
}

N L_rem_Nl(N n, N m) {
  N result = L_rem_N(n, m);
  L_wipe_N(&n);
  return result;
}

N L_rem_Nr(N n, N m) {
  N result = L_rem_N(n, m);
  L_wipe_N(&m);
  return result;
}

N L_rem_Nlr(N n, N m) {
  N result = L_rem_N(n, m);
  L_wipe_N(&n);
  L_wipe_N(&m);
  return result;
}

ZS L_create_ZS(size_t size, Z initialValue) {
  ZS result = {0};
  result.size = size;
  result.data = L_malloc(size * sizeof(Z));
  size_t i;
  for (i = 0; i < size; i++) {
    result.data[i] = initialValue;
  }
  return result;
}

void L_wipe_Z(Z *n) {
  mpz_clear(n->data);
  L_wipe(n, sizeof(Z));
}

void L_wipe_ZS(ZS *ns) {
  size_t size = ns->size;
  size_t i;
  for (i = 0; i < size; i++) {
    L_wipe_Z(&(ns->data[i]));
  }
  L_wipe(ns, sizeof(ZS));
}

#else

size_t L_Z2st(Z n) {
  L_assert(0 <= n && n <= SIZE_T_MAX);
  return (size_t) n;
}

Z L_st2Z(size_t n) {
  Z result = (Z) n;
  L_assert(result == n);
  return result;
}

NS L_create_NS(size_t size, N initialValue) {
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

void L_wipe_Z(Z *n) {
  *n = 0;
}

void L_wipe_N(N *n) {
  *n = 0;
}

void L_wipe_ZS(ZS *ns) {
  size_t size = ns->size;
  size_t i;
  for (i = 0; i < size; i++) {
    L_wipe_Z(&(ns->data[i]));
  }
  L_wipe(ns, sizeof(ZS));
}

void L_wipe_NS(NS *ns) {
  size_t size = ns->size;
  size_t i;
  for (i = 0; i < size; i++) {
    L_wipe_N(&(ns->data[i]));
  }
  L_wipe(ns, sizeof(NS));
}

#endif

void L_wipe_B(B *b) {
  *b = false;
  L_av(b);
}

void L_wipe_U8(U8 *n) {
  *n = 0;
  L_av(n);
}

void L_wipe_U16(U16 *n) {
  *n = 0;
  L_av(n);
}

void L_wipe_U32(U32 *n) {
  *n = 0;
  L_av(n);
}

void L_wipe_U64(U64 *n) {
  *n = 0;
  L_av(n);
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

BS L_create_BS(size_t size, B initialValue) {
  BS result = {0};
  size_t dataSize = size / BITS_PER_SIZE_T + (size % BITS_PER_SIZE_T == 0? 0 : 1);
  result.size = size;
  result.dataSize = dataSize;
  result.data = L_malloc(dataSize * sizeof(size_t));
  size_t i;
  size_t init = initialValue ? SIZE_MAX : 0;
  for (i = 0; i < dataSize; i++) {
    result.data[i] = init;
  }
  return result;
}

BS L_BS(int size, ...) {
  BS result = L_create_BS((size_t) size, false);
  va_list valist;
  va_start(valist, size);
  int i;
  for (i = 0; i < size; i++) {
    if (va_arg(valist, int)) {
      L_set_BS(result, L_st2Z((size_t) i), true);
    }
  }
  va_end(valist);

  return result;
}

S8S L_create_S8S(size_t size, S8 initialValue) {
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

S16S L_create_S16S(size_t size, S16 initialValue) {
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

S32S L_create_S32S(size_t size, S32 initialValue) {
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

S64S L_create_S64S(size_t size, S64 initialValue) {
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

U8S L_create_U8S(size_t size, U8 initialValue) {
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

U16S L_create_U16S(size_t size, U16 initialValue) {
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

U32S L_create_U32S(size_t size, U32 initialValue) {
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

U64S L_create_U64S(size_t size, U64 initialValue) {
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

F32S L_create_F32S(size_t size, F32 initialValue) {
  F32S result = {0};
  result.size = size;
  result.data = L_malloc(size * sizeof(F32));
  size_t i;
  for (i = 0; i < size; i++) {
    result.data[i] = initialValue;
  }
  return result;
}

F64S L_create_F64S(size_t size, F64 initialValue) {
  F64S result = {0};
  result.size = size;
  result.data = L_malloc(size * sizeof(F64));
  size_t i;
  for (i = 0; i < size; i++) {
    result.data[i] = initialValue;
  }
  return result;
}

B L_get_BS(BS bs, Z index) {
  size_t i = L_Z2st(index);
  size_t j = i / BITS_PER_SIZE_T;
  size_t mask = (size_t) 1 << (i % BITS_PER_SIZE_T);
  return (bs.data[j] & mask) == 0? false : true;
}

void L_set_BS(BS bs, Z index, B value) {
  size_t i = L_Z2st(index);
  size_t j = i / BITS_PER_SIZE_T;
  if (value) {
    size_t mask = (size_t) 1 << (i % BITS_PER_SIZE_T);
    bs.data[j] = bs.data[j] | mask;
  } else {
    size_t mask = (size_t) ~(1 << (i % BITS_PER_SIZE_T));
    bs.data[j] = bs.data[j] & mask;
  }
}

BS L_clone_BS(BS ns) {
  BS result = {0};
  size_t dataSize = ns.dataSize;
  result.size = ns.size;
  result.dataSize = dataSize;
  result.data = L_malloc(dataSize * sizeof(size_t));
  memcpy(result.data, ns.data, dataSize);
  return result;
}

S8S L_clone_S8S(S8S ns) {
  S8S result = {0};
  size_t size = ns.size;
  result.size = size;
  result.data = L_malloc(size * sizeof(S8));
  memcpy(result.data, ns.data, size);
  return result;
}

S16S L_clone_S16S(S16S ns) {
  S16S result = {0};
  size_t size = ns.size;
  result.size = size;
  result.data = L_malloc(size * sizeof(S16));
  memcpy(result.data, ns.data, size);
  return result;
}

S32S L_clone_S32S(S32S ns) {
  S32S result = {0};
  size_t size = ns.size;
  result.size = size;
  result.data = L_malloc(size * sizeof(S32));
  memcpy(result.data, ns.data, size);
  return result;
}

S64S L_clone_S64S(S64S ns) {
  S64S result = {0};
  size_t size = ns.size;
  result.size = size;
  result.data = L_malloc(size * sizeof(S64));
  memcpy(result.data, ns.data, size);
  return result;
}

U8S L_clone_U8S(U8S ns) {
  U8S result = {0};
  size_t size = ns.size;
  result.size = size;
  result.data = L_malloc(size * sizeof(U8));
  memcpy(result.data, ns.data, size);
  return result;
}

U16S L_clone_U16S(U16S ns) {
  U16S result = {0};
  size_t size = ns.size;
  result.size = size;
  result.data = L_malloc(size * sizeof(U16));
  memcpy(result.data, ns.data, size);
  return result;
}

U32S L_clone_U32S(U32S ns) {
  U32S result = {0};
  size_t size = ns.size;
  result.size = size;
  result.data = L_malloc(size * sizeof(U32));
  memcpy(result.data, ns.data, size);
  return result;
}

U64S L_clone_U64S(U64S ns) {
  U64S result = {0};
  size_t size = ns.size;
  result.size = size;
  result.data = L_malloc(size * sizeof(U64));
  memcpy(result.data, ns.data, size);
  return result;
}

F32S L_clone_F32S(F32S ns) {
  F32S result = {0};
  size_t size = ns.size;
  result.size = size;
  result.data = L_malloc(size * sizeof(F32));
  memcpy(result.data, ns.data, size);
  return result;
}

F64S L_clone_F64S(F64S ns) {
  F64S result = {0};
  size_t size = ns.size;
  result.size = size;
  result.data = L_malloc(size * sizeof(F64));
  memcpy(result.data, ns.data, size);
  return result;
}

#if BIT_WIDTH == 0

ZS L_clone_ZS(ZS ns) {
  ZS result = {0};
  size_t size = ns.size;
  result.size = size;
  result.data = L_malloc(size * sizeof(Z));
  size_t i;
  for (i = 0; i < size; i++) {
    mpz_set(result.data[i].data, ns.data[i].data);
  }
  return result;
}

#endif

B L_eq_BS(BS bs1, BS bs2) {
  return bs1.size == bs2.size && memcmp(bs1.data, bs2.data, bs1.dataSize) == 0;
}

B L_eq_BSl(BS bs1, BS bs2) {
  B result = L_eq_BS(bs1, bs2);
  L_wipe_BS(&bs1);
  return result;
}

B L_eq_BSr(BS bs1, BS bs2) {
  B result = L_eq_BS(bs1, bs2);
  L_wipe_BS(&bs2);
  return result;
}

B L_eq_BSlr(BS bs1, BS bs2) {
  B result = L_eq_BS(bs1, bs2);
  L_wipe_BS(&bs1);
  L_wipe_BS(&bs2);
  return result;
}

B L_eq_S8S(S8S ns1, S8S ns2) {
  return ns1.size == ns2.size && memcmp(ns1.data, ns2.data, ns1.size) == 0;
}

B L_eq_S8Sl(S8S ns1, S8S ns2) {
  B result = L_eq_S8S(ns1, ns2);
  L_wipe_S8S(&ns1);
  return result;
}

B L_eq_S8Sr(S8S ns1, S8S ns2) {
  B result = L_eq_S8S(ns1, ns2);
  L_wipe_S8S(&ns2);
  return result;
}

B L_eq_S8Slr(S8S ns1, S8S ns2) {
  B result = L_eq_S8S(ns1, ns2);
  L_wipe_S8S(&ns1);
  L_wipe_S8S(&ns2);
  return result;
}

B L_eq_S16S(S16S ns1, S16S ns2) {
  return ns1.size == ns2.size && memcmp(ns1.data, ns2.data, ns1.size) == 0;
}

B L_eq_S16Sl(S16S ns1, S16S ns2) {
  B result = L_eq_S16S(ns1, ns2);
  L_wipe_S16S(&ns1);
  return result;
}

B L_eq_S16Sr(S16S ns1, S16S ns2) {
  B result = L_eq_S16S(ns1, ns2);
  L_wipe_S16S(&ns2);
  return result;
}

B L_eq_S16Slr(S16S ns1, S16S ns2) {
  B result = L_eq_S16S(ns1, ns2);
  L_wipe_S16S(&ns1);
  L_wipe_S16S(&ns2);
  return result;
}

B L_eq_S32S(S32S ns1, S32S ns2) {
  return ns1.size == ns2.size && memcmp(ns1.data, ns2.data, ns1.size) == 0;
}

B L_eq_S32Sl(S32S ns1, S32S ns2) {
  B result = L_eq_S32S(ns1, ns2);
  L_wipe_S32S(&ns1);
  return result;
}

B L_eq_S32Sr(S32S ns1, S32S ns2) {
  B result = L_eq_S32S(ns1, ns2);
  L_wipe_S32S(&ns2);
  return result;
}

B L_eq_S32Slr(S32S ns1, S32S ns2) {
  B result = L_eq_S32S(ns1, ns2);
  L_wipe_S32S(&ns1);
  L_wipe_S32S(&ns2);
  return result;
}

B L_eq_S64S(S64S ns1, S64S ns2) {
  return ns1.size == ns2.size && memcmp(ns1.data, ns2.data, ns1.size) == 0;
}

B L_eq_S64Sl(S64S ns1, S64S ns2) {
  B result = L_eq_S64S(ns1, ns2);
  L_wipe_S64S(&ns1);
  return result;
}

B L_eq_S64Sr(S64S ns1, S64S ns2) {
  B result = L_eq_S64S(ns1, ns2);
  L_wipe_S64S(&ns2);
  return result;
}

B L_eq_S64Slr(S64S ns1, S64S ns2) {
  B result = L_eq_S64S(ns1, ns2);
  L_wipe_S64S(&ns1);
  L_wipe_S64S(&ns2);
  return result;
}

B L_eq_U8S(U8S ns1, U8S ns2) {
  return ns1.size == ns2.size && memcmp(ns1.data, ns2.data, ns1.size) == 0;
}

B L_eq_U8Sl(U8S ns1, U8S ns2) {
  B result = L_eq_U8S(ns1, ns2);
  L_wipe_U8S(&ns1);
  return result;
}

B L_eq_U8Sr(U8S ns1, U8S ns2) {
  B result = L_eq_U8S(ns1, ns2);
  L_wipe_U8S(&ns2);
  return result;
}

B L_eq_U8Slr(U8S ns1, U8S ns2) {
  B result = L_eq_U8S(ns1, ns2);
  L_wipe_U8S(&ns1);
  L_wipe_U8S(&ns2);
  return result;
}

B L_eq_U16S(U16S ns1, U16S ns2) {
  return ns1.size == ns2.size && memcmp(ns1.data, ns2.data, ns1.size) == 0;
}

B L_eq_U16Sl(U16S ns1, U16S ns2) {
  B result = L_eq_U16S(ns1, ns2);
  L_wipe_U16S(&ns1);
  return result;
}

B L_eq_U16Sr(U16S ns1, U16S ns2) {
  B result = L_eq_U16S(ns1, ns2);
  L_wipe_U16S(&ns2);
  return result;
}

B L_eq_U16Slr(U16S ns1, U16S ns2) {
  B result = L_eq_U16S(ns1, ns2);
  L_wipe_U16S(&ns1);
  L_wipe_U16S(&ns2);
  return result;
}

B L_eq_U32S(U32S ns1, U32S ns2) {
  return ns1.size == ns2.size && memcmp(ns1.data, ns2.data, ns1.size) == 0;
}

B L_eq_U32Sl(U32S ns1, U32S ns2) {
  B result = L_eq_U32S(ns1, ns2);
  L_wipe_U32S(&ns1);
  return result;
}

B L_eq_U32Sr(U32S ns1, U32S ns2) {
  B result = L_eq_U32S(ns1, ns2);
  L_wipe_U32S(&ns2);
  return result;
}

B L_eq_U32Slr(U32S ns1, U32S ns2) {
  B result = L_eq_U32S(ns1, ns2);
  L_wipe_U32S(&ns1);
  L_wipe_U32S(&ns2);
  return result;
}

B L_eq_U64S(U64S ns1, U64S ns2) {
  return ns1.size == ns2.size && memcmp(ns1.data, ns2.data, ns1.size) == 0;
}

B L_eq_U64Sl(U64S ns1, U64S ns2) {
  B result = L_eq_U64S(ns1, ns2);
  L_wipe_U64S(&ns1);
  return result;
}

B L_eq_U64Sr(U64S ns1, U64S ns2) {
  B result = L_eq_U64S(ns1, ns2);
  L_wipe_U64S(&ns2);
  return result;
}

B L_eq_U64Slr(U64S ns1, U64S ns2) {
  B result = L_eq_U64S(ns1, ns2);
  L_wipe_U64S(&ns1);
  L_wipe_U64S(&ns2);
  return result;
}

B L_eq_F32S(F32S ns1, F32S ns2) {
  return ns1.size == ns2.size && memcmp(ns1.data, ns2.data, ns1.size) == 0;
}

B L_eq_F32Sl(F32S ns1, F32S ns2) {
  B result = L_eq_F32S(ns1, ns2);
  L_wipe_F32S(&ns1);
  return result;
}

B L_eq_F32Sr(F32S ns1, F32S ns2) {
  B result = L_eq_F32S(ns1, ns2);
  L_wipe_F32S(&ns2);
  return result;
}

B L_eq_F32Slr(F32S ns1, F32S ns2) {
  B result = L_eq_F32S(ns1, ns2);
  L_wipe_F32S(&ns1);
  L_wipe_F32S(&ns2);
  return result;
}

B L_eq_F64S(F64S ns1, F64S ns2) {
  return ns1.size == ns2.size && memcmp(ns1.data, ns2.data, ns1.size) == 0;
}

B L_eq_F64Sl(F64S ns1, F64S ns2) {
  B result = L_eq_F64S(ns1, ns2);
  L_wipe_F64S(&ns1);
  return result;
}

B L_eq_F64Sr(F64S ns1, F64S ns2) {
  B result = L_eq_F64S(ns1, ns2);
  L_wipe_F64S(&ns2);
  return result;
}

B L_eq_F64Slr(F64S ns1, F64S ns2) {
  B result = L_eq_F64S(ns1, ns2);
  L_wipe_F64S(&ns1);
  L_wipe_F64S(&ns2);
  return result;
}

#if BIT_WIDTH == 0

B L_eq_ZS(ZS ns1, ZS ns2) {
  size_t size = ns1.size;
  if (size != ns2.size) return false;
  size_t i;
  for (i = 0; i < size; i++) {
    if (!L_eq_Z(ns1.data[i], ns1.data[i])) return false;
  }
  return true;
}

B L_eq_ZSl(ZS ns1, ZS ns2) {
  B result = L_eq_ZS(ns1, ns2);
  L_wipe_ZS(&ns1);
  return result;
}

B L_eq_ZSr(ZS ns1, ZS ns2) {
  B result = L_eq_ZS(ns1, ns2);
  L_wipe_ZS(&ns2);
  return result;
}

B L_eq_ZSlr(ZS ns1, ZS ns2) {
  B result = L_eq_ZS(ns1, ns2);
  L_wipe_ZS(&ns1);
  L_wipe_ZS(&ns2);
  return result;
}

#endif

S8S L_prepend_S8S(S8 n, S8S ns) {
  L_assert(ns.size < SIZE_T_MAX);
  S8S result = {0};
  size_t size = ns.size + 1;
  result.size = size;
  result.data = L_malloc(sizeof(S8) * size);
  result.data[0] = n;
  memcpy(&(result.data[1]), ns.data, ns.size);
  return result;
}

S8S L_prepend_S8Sf(S8 n, S8S ns) {
  S8S result = L_prepend_S8S(n, ns);
  L_wipe_S8S(&ns);
  return result;
}

S8S L_append_S8S(S8S ns, S8 n) {
  L_assert(ns.size < SIZE_T_MAX);
  S8S result = {0};
  size_t size = ns.size + 1;
  result.size = size;
  result.data = L_malloc(sizeof(S8) * size);
  result.data[size - 1] = n;
  memcpy(result.data, ns.data, ns.size);
  return result;
}

S8S L_append_S8Sf(S8S ns, S8 n) {
  S8S result = L_append_S8S(ns, n);
  L_wipe_S8S(&ns);
  return result;
}

S8S L_appends_S8S(S8S ns1, S8S ns2) {
  L_assert(ns1.size + ns2.size < SIZE_T_MAX);
  S8S result = {0};
  size_t size = ns1.size + ns2.size;
  result.size = size;
  result.data = L_malloc(sizeof(S8) * size);
  memcpy(result.data, ns1.data, ns1.size);
  memcpy(&(result.data[ns1.size]), ns2.data, ns2.size);
  return result;
}

S8S L_appends_S8Sl(S8S ns1, S8S ns2) {
  S8S result = L_appends_S8S(ns1, ns2);
  L_wipe_S8S(&ns1);
  return result;
}

S8S L_appends_S8Sr(S8S ns1, S8S ns2) {
  S8S result = L_appends_S8S(ns1, ns2);
  L_wipe_S8S(&ns2);
  return result;
}

S8S L_appends_S8Slr(S8S ns1, S8S ns2) {
  S8S result = L_appends_S8S(ns1, ns2);
  L_wipe_S8S(&ns1);
  L_wipe_S8S(&ns2);
  return result;
}

S16S L_prepend_S16S(S16 n, S16S ns) {
  L_assert(ns.size < SIZE_T_MAX);
  S16S result = {0};
  size_t size = ns.size + 1;
  result.size = size;
  result.data = L_malloc(sizeof(S16) * size);
  result.data[0] = n;
  memcpy(&(result.data[1]), ns.data, ns.size);
  return result;
}

S16S L_prepend_S16Sf(S16 n, S16S ns) {
  S16S result = L_prepend_S16S(n, ns);
  L_wipe_S16S(&ns);
  return result;
}

S16S L_append_S16S(S16S ns, S16 n) {
  L_assert(ns.size < SIZE_T_MAX);
  S16S result = {0};
  size_t size = ns.size + 1;
  result.size = size;
  result.data = L_malloc(sizeof(S16) * size);
  result.data[size - 1] = n;
  memcpy(result.data, ns.data, ns.size);
  return result;
}

S16S L_append_S16Sf(S16S ns, S16 n) {
  S16S result = L_append_S16S(ns, n);
  L_wipe_S16S(&ns);
  return result;
}

S16S L_appends_S16S(S16S ns1, S16S ns2) {
  L_assert(ns1.size + ns2.size < SIZE_T_MAX);
  S16S result = {0};
  size_t size = ns1.size + ns2.size;
  result.size = size;
  result.data = L_malloc(sizeof(S16) * size);
  memcpy(result.data, ns1.data, ns1.size);
  memcpy(&(result.data[ns1.size]), ns2.data, ns2.size);
  return result;
}

S16S L_appends_S16Sl(S16S ns1, S16S ns2) {
  S16S result = L_appends_S16S(ns1, ns2);
  L_wipe_S16S(&ns1);
  return result;
}

S16S L_appends_S16Sr(S16S ns1, S16S ns2) {
  S16S result = L_appends_S16S(ns1, ns2);
  L_wipe_S16S(&ns2);
  return result;
}

S16S L_appends_S16Slr(S16S ns1, S16S ns2) {
  S16S result = L_appends_S16S(ns1, ns2);
  L_wipe_S16S(&ns1);
  L_wipe_S16S(&ns2);
  return result;
}

S32S L_prepend_S32S(S32 n, S32S ns) {
  L_assert(ns.size < SIZE_T_MAX);
  S32S result = {0};
  size_t size = ns.size + 1;
  result.size = size;
  result.data = L_malloc(sizeof(S32) * size);
  result.data[0] = n;
  memcpy(&(result.data[1]), ns.data, ns.size);
  return result;
}

S32S L_prepend_S32Sf(S32 n, S32S ns) {
  S32S result = L_prepend_S32S(n, ns);
  L_wipe_S32S(&ns);
  return result;
}

S32S L_append_S32S(S32S ns, S32 n) {
  L_assert(ns.size < SIZE_T_MAX);
  S32S result = {0};
  size_t size = ns.size + 1;
  result.size = size;
  result.data = L_malloc(sizeof(S32) * size);
  result.data[size - 1] = n;
  memcpy(result.data, ns.data, ns.size);
  return result;
}

S32S L_append_S32Sf(S32S ns, S32 n) {
  S32S result = L_append_S32S(ns, n);
  L_wipe_S32S(&ns);
  return result;
}

S32S L_appends_S32S(S32S ns1, S32S ns2) {
  L_assert(ns1.size + ns2.size < SIZE_T_MAX);
  S32S result = {0};
  size_t size = ns1.size + ns2.size;
  result.size = size;
  result.data = L_malloc(sizeof(S32) * size);
  memcpy(result.data, ns1.data, ns1.size);
  memcpy(&(result.data[ns1.size]), ns2.data, ns2.size);
  return result;
}

S32S L_appends_S32Sl(S32S ns1, S32S ns2) {
  S32S result = L_appends_S32S(ns1, ns2);
  L_wipe_S32S(&ns1);
  return result;
}

S32S L_appends_S32Sr(S32S ns1, S32S ns2) {
  S32S result = L_appends_S32S(ns1, ns2);
  L_wipe_S32S(&ns2);
  return result;
}

S32S L_appends_S32Slr(S32S ns1, S32S ns2) {
  S32S result = L_appends_S32S(ns1, ns2);
  L_wipe_S32S(&ns1);
  L_wipe_S32S(&ns2);
  return result;
}

S64S L_prepend_S64S(S64 n, S64S ns) {
  L_assert(ns.size < SIZE_T_MAX);
  S64S result = {0};
  size_t size = ns.size + 1;
  result.size = size;
  result.data = L_malloc(sizeof(S64) * size);
  result.data[0] = n;
  memcpy(&(result.data[1]), ns.data, ns.size);
  return result;
}

S64S L_prepend_S64Sf(S64 n, S64S ns) {
  S64S result = L_prepend_S64S(n, ns);
  L_wipe_S64S(&ns);
  return result;
}

S64S L_append_S64S(S64S ns, S64 n) {
  L_assert(ns.size < SIZE_T_MAX);
  S64S result = {0};
  size_t size = ns.size + 1;
  result.size = size;
  result.data = L_malloc(sizeof(S64) * size);
  result.data[size - 1] = n;
  memcpy(result.data, ns.data, ns.size);
  return result;
}

S64S L_append_S64Sf(S64S ns, S64 n) {
  S64S result = L_append_S64S(ns, n);
  L_wipe_S64S(&ns);
  return result;
}

S64S L_appends_S64S(S64S ns1, S64S ns2) {
  L_assert(ns1.size + ns2.size < SIZE_T_MAX);
  S64S result = {0};
  size_t size = ns1.size + ns2.size;
  result.size = size;
  result.data = L_malloc(sizeof(S64) * size);
  memcpy(result.data, ns1.data, ns1.size);
  memcpy(&(result.data[ns1.size]), ns2.data, ns2.size);
  return result;
}

S64S L_appends_S64Sl(S64S ns1, S64S ns2) {
  S64S result = L_appends_S64S(ns1, ns2);
  L_wipe_S64S(&ns1);
  return result;
}

S64S L_appends_S64Sr(S64S ns1, S64S ns2) {
  S64S result = L_appends_S64S(ns1, ns2);
  L_wipe_S64S(&ns2);
  return result;
}

S64S L_appends_S64Slr(S64S ns1, S64S ns2) {
  S64S result = L_appends_S64S(ns1, ns2);
  L_wipe_S64S(&ns1);
  L_wipe_S64S(&ns2);
  return result;
}

U8S L_prepend_U8S(U8 n, U8S ns) {
  L_assert(ns.size < SIZE_T_MAX);
  U8S result = {0};
  size_t size = ns.size + 1;
  result.size = size;
  result.data = L_malloc(sizeof(U8) * size);
  result.data[0] = n;
  memcpy(&(result.data[1]), ns.data, ns.size);
  return result;
}

U8S L_prepend_U8Sf(U8 n, U8S ns) {
  U8S result = L_prepend_U8S(n, ns);
  L_wipe_U8S(&ns);
  return result;
}

U8S L_append_U8S(U8S ns, U8 n) {
  L_assert(ns.size < SIZE_T_MAX);
  U8S result = {0};
  size_t size = ns.size + 1;
  result.size = size;
  result.data = L_malloc(sizeof(U8) * size);
  result.data[size - 1] = n;
  memcpy(result.data, ns.data, ns.size);
  return result;
}

U8S L_append_U8Sf(U8S ns, U8 n) {
  U8S result = L_append_U8S(ns, n);
  L_wipe_U8S(&ns);
  return result;
}

U8S L_appends_U8S(U8S ns1, U8S ns2) {
  L_assert(ns1.size + ns2.size < SIZE_T_MAX);
  U8S result = {0};
  size_t size = ns1.size + ns2.size;
  result.size = size;
  result.data = L_malloc(sizeof(U8) * size);
  memcpy(result.data, ns1.data, ns1.size);
  memcpy(&(result.data[ns1.size]), ns2.data, ns2.size);
  return result;
}

U8S L_appends_U8Sl(U8S ns1, U8S ns2) {
  U8S result = L_appends_U8S(ns1, ns2);
  L_wipe_U8S(&ns1);
  return result;
}

U8S L_appends_U8Sr(U8S ns1, U8S ns2) {
  U8S result = L_appends_U8S(ns1, ns2);
  L_wipe_U8S(&ns2);
  return result;
}

U8S L_appends_U8Slr(U8S ns1, U8S ns2) {
  U8S result = L_appends_U8S(ns1, ns2);
  L_wipe_U8S(&ns1);
  L_wipe_U8S(&ns2);
  return result;
}

U16S L_prepend_U16S(U16 n, U16S ns) {
  L_assert(ns.size < SIZE_T_MAX);
  U16S result = {0};
  size_t size = ns.size + 1;
  result.size = size;
  result.data = L_malloc(sizeof(U16) * size);
  result.data[0] = n;
  memcpy(&(result.data[1]), ns.data, ns.size);
  return result;
}

U16S L_prepend_U16Sf(U16 n, U16S ns) {
  U16S result = L_prepend_U16S(n, ns);
  L_wipe_U16S(&ns);
  return result;
}

U16S L_append_U16S(U16S ns, U16 n) {
  L_assert(ns.size < SIZE_T_MAX);
  U16S result = {0};
  size_t size = ns.size + 1;
  result.size = size;
  result.data = L_malloc(sizeof(U16) * size);
  result.data[size - 1] = n;
  memcpy(result.data, ns.data, ns.size);
  return result;
}

U16S L_append_U16Sf(U16S ns, U16 n) {
  U16S result = L_append_U16S(ns, n);
  L_wipe_U16S(&ns);
  return result;
}

U16S L_appends_U16S(U16S ns1, U16S ns2) {
  L_assert(ns1.size + ns2.size < SIZE_T_MAX);
  U16S result = {0};
  size_t size = ns1.size + ns2.size;
  result.size = size;
  result.data = L_malloc(sizeof(U16) * size);
  memcpy(result.data, ns1.data, ns1.size);
  memcpy(&(result.data[ns1.size]), ns2.data, ns2.size);
  return result;
}

U16S L_appends_U16Sl(U16S ns1, U16S ns2) {
  U16S result = L_appends_U16S(ns1, ns2);
  L_wipe_U16S(&ns1);
  return result;
}

U16S L_appends_U16Sr(U16S ns1, U16S ns2) {
  U16S result = L_appends_U16S(ns1, ns2);
  L_wipe_U16S(&ns2);
  return result;
}

U16S L_appends_U16Slr(U16S ns1, U16S ns2) {
  U16S result = L_appends_U16S(ns1, ns2);
  L_wipe_U16S(&ns1);
  L_wipe_U16S(&ns2);
  return result;
}

U32S L_prepend_U32S(U32 n, U32S ns) {
  L_assert(ns.size < SIZE_T_MAX);
  U32S result = {0};
  size_t size = ns.size + 1;
  result.size = size;
  result.data = L_malloc(sizeof(U32) * size);
  result.data[0] = n;
  memcpy(&(result.data[1]), ns.data, ns.size);
  return result;
}

U32S L_prepend_U32Sf(U32 n, U32S ns) {
  U32S result = L_prepend_U32S(n, ns);
  L_wipe_U32S(&ns);
  return result;
}

U32S L_append_U32S(U32S ns, U32 n) {
  L_assert(ns.size < SIZE_T_MAX);
  U32S result = {0};
  size_t size = ns.size + 1;
  result.size = size;
  result.data = L_malloc(sizeof(U32) * size);
  result.data[size - 1] = n;
  memcpy(result.data, ns.data, ns.size);
  return result;
}

U32S L_append_U32Sf(U32S ns, U32 n) {
  U32S result = L_append_U32S(ns, n);
  L_wipe_U32S(&ns);
  return result;
}

U32S L_appends_U32S(U32S ns1, U32S ns2) {
  L_assert(ns1.size + ns2.size < SIZE_T_MAX);
  U32S result = {0};
  size_t size = ns1.size + ns2.size;
  result.size = size;
  result.data = L_malloc(sizeof(U32) * size);
  memcpy(result.data, ns1.data, ns1.size);
  memcpy(&(result.data[ns1.size]), ns2.data, ns2.size);
  return result;
}

U32S L_appends_U32Sl(U32S ns1, U32S ns2) {
  U32S result = L_appends_U32S(ns1, ns2);
  L_wipe_U32S(&ns1);
  return result;
}

U32S L_appends_U32Sr(U32S ns1, U32S ns2) {
  U32S result = L_appends_U32S(ns1, ns2);
  L_wipe_U32S(&ns2);
  return result;
}

U32S L_appends_U32Slr(U32S ns1, U32S ns2) {
  U32S result = L_appends_U32S(ns1, ns2);
  L_wipe_U32S(&ns1);
  L_wipe_U32S(&ns2);
  return result;
}

U64S L_prepend_U64S(U64 n, U64S ns) {
  L_assert(ns.size < SIZE_T_MAX);
  U64S result = {0};
  size_t size = ns.size + 1;
  result.size = size;
  result.data = L_malloc(sizeof(U64) * size);
  result.data[0] = n;
  memcpy(&(result.data[1]), ns.data, ns.size);
  return result;
}

U64S L_prepend_U64Sf(U64 n, U64S ns) {
  U64S result = L_prepend_U64S(n, ns);
  L_wipe_U64S(&ns);
  return result;
}

U64S L_append_U64S(U64S ns, U64 n) {
  L_assert(ns.size < SIZE_T_MAX);
  U64S result = {0};
  size_t size = ns.size + 1;
  result.size = size;
  result.data = L_malloc(sizeof(U64) * size);
  result.data[size - 1] = n;
  memcpy(result.data, ns.data, ns.size);
  return result;
}

U64S L_append_U64Sf(U64S ns, U64 n) {
  U64S result = L_append_U64S(ns, n);
  L_wipe_U64S(&ns);
  return result;
}

U64S L_appends_U64S(U64S ns1, U64S ns2) {
  L_assert(ns1.size + ns2.size < SIZE_T_MAX);
  U64S result = {0};
  size_t size = ns1.size + ns2.size;
  result.size = size;
  result.data = L_malloc(sizeof(U64) * size);
  memcpy(result.data, ns1.data, ns1.size);
  memcpy(&(result.data[ns1.size]), ns2.data, ns2.size);
  return result;
}

U64S L_appends_U64Sl(U64S ns1, U64S ns2) {
  U64S result = L_appends_U64S(ns1, ns2);
  L_wipe_U64S(&ns1);
  return result;
}

U64S L_appends_U64Sr(U64S ns1, U64S ns2) {
  U64S result = L_appends_U64S(ns1, ns2);
  L_wipe_U64S(&ns2);
  return result;
}

U64S L_appends_U64Slr(U64S ns1, U64S ns2) {
  U64S result = L_appends_U64S(ns1, ns2);
  L_wipe_U64S(&ns1);
  L_wipe_U64S(&ns2);
  return result;
}

#if BIT_WIDTH == 0

ZS L_prepend_ZS(Z n, ZS ns) {
  L_assert(ns.size < SIZE_T_MAX);
  ZS result = {0};
  size_t size = ns.size + 1;
  result.size = size;
  result.data = L_malloc(sizeof(Z) * size);
  result.data[0] = n;
  memcpy(&(result.data[1]), ns.data, ns.size);
  return result;
}

ZS L_prepend_ZSf(Z n, ZS ns) {
  ZS result = L_prepend_ZS(n, ns);
  L_wipe_ZS(&ns);
  return result;
}

ZS L_append_ZS(ZS ns, Z n) {
  L_assert(ns.size < SIZE_T_MAX);
  ZS result = {0};
  size_t size = ns.size + 1;
  result.size = size;
  result.data = L_malloc(sizeof(Z) * size);
  result.data[size - 1] = n;
  memcpy(result.data, ns.data, ns.size);
  return result;
}

ZS L_append_ZSf(ZS ns, Z n) {
  ZS result = L_append_ZS(ns, n);
  L_wipe_ZS(&ns);
  return result;
}

ZS L_appends_ZS(ZS ns1, ZS ns2) {
  L_assert(ns1.size + ns2.size < SIZE_T_MAX);
  ZS result = {0};
  size_t size = ns1.size + ns2.size;
  result.size = size;
  result.data = L_malloc(sizeof(Z) * size);
  memcpy(result.data, ns1.data, ns1.size);
  memcpy(&(result.data[ns1.size]), ns2.data, ns2.size);
  return result;
}

ZS L_appends_ZSl(ZS ns1, ZS ns2) {
  ZS result = L_appends_ZS(ns1, ns2);
  L_wipe_ZS(&ns1);
  return result;
}

ZS L_appends_ZSr(ZS ns1, ZS ns2) {
  ZS result = L_appends_ZS(ns1, ns2);
  L_wipe_ZS(&ns2);
  return result;
}

ZS L_appends_ZSlr(ZS ns1, ZS ns2) {
  ZS result = L_appends_ZS(ns1, ns2);
  L_wipe_ZS(&ns1);
  L_wipe_ZS(&ns2);
  return result;
}

#endif

void L_wipe_BS(BS *bs) {
  L_wipe(bs->data, bs->dataSize);
  free(bs->data);
  L_wipe(bs, sizeof(BS));
}

void L_wipe_S8S(S8S *ns) {
  L_wipe(ns->data, sizeof(S8) * ns->size);
  free(ns->data);
  L_wipe(ns, sizeof(S8S));
}

void L_wipe_S16S(S16S *ns) {
  L_wipe(ns->data, sizeof(S16) * ns->size);
  free(ns->data);
  L_wipe(ns, sizeof(S16S));
}

void L_wipe_S32S(S32S *ns) {
  L_wipe(ns->data, sizeof(S32) * ns->size);
  free(ns->data);
  L_wipe(ns, sizeof(S32S));
}

void L_wipe_S64S(S64S *ns) {
  L_wipe(ns->data, sizeof(S64) * ns->size);
  free(ns->data);
  L_wipe(ns, sizeof(S64S));
}

void L_wipe_U8S(U8S *ns) {
  L_wipe(ns->data, sizeof(U8) * ns->size);
  free(ns->data);
  L_wipe(ns, sizeof(U8S));
}

void L_wipe_U16S(U16S *ns) {
  L_wipe(ns->data, sizeof(U16) * ns->size);
  free(ns->data);
  L_wipe(ns, sizeof(U16S));
}

void L_wipe_U32S(U32S *ns) {
  L_wipe(ns->data, sizeof(U32) * ns->size);
  free(ns->data);
  L_wipe(ns, sizeof(U32S));
}

void L_wipe_U64S(U64S *ns) {
  L_wipe(ns->data, sizeof(U64) * ns->size);
  free(ns->data);
  L_wipe(ns, sizeof(U64S));
}

void L_wipe_F32S(F32S *ns) {
  L_wipe(ns->data, sizeof(F32) * ns->size);
  free(ns->data);
  L_wipe(ns, sizeof(F32S));
}

void L_wipe_F64S(F64S *ns) {
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
  L_assert(false);
}

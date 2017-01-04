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
#include <stdlib.h>
#include <string.h>

#if BIT_WIDTH == 0

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

void L_Z_wipe(Z *n) {
  mpz_clear(n->data);
  L_wipe(n, sizeof(Z));
}

void L_ZS_wipe(ZS *ns) {
  size_t size = ns->size;
  for (size_t i = 0; i < size; i++) {
    L_Z_wipe(&(ns->data[i]));
  }
  L_wipe(ns, sizeof(ZS));
}

#else

void L_Z_wipe(Z *n) {
  *n = 0;
}

void L_N_wipe(N *n) {
  *n = 0;
}

void L_ZS_wipe(ZS *ns) {
  size_t size = ns->size;
  for (size_t i = 0; i < size; i++) {
    L_Z_wipe(&(ns->data[i]));
  }
  L_wipe(ns, sizeof(ZS));
}

void L_NS_wipe(NS *ns) {
  size_t size = ns->size;
  for (size_t i = 0; i < size; i++) {
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

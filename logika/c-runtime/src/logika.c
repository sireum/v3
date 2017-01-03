#include "logika.h"

#if BIT_WIDTH == 0

Z L_Z_add(Z n, Z m) {
  Z result = {0};
  mpz_init(result.data);
  mpz_add(result.data, n.data, m.data);
  return result;
}

Z L_Z_addl(Z n, Z m) {
  Z result = L_Z_add(n, m);
  mpz_clear(n.data);
  return result;
}

Z L_Z_addr(Z n, Z m) {
  Z result = L_Z_add(n, m);
  mpz_clear(m.data);
  return result;
}

Z L_Z_addlr(Z n, Z m) {
  Z result = L_Z_add(n, m);
  mpz_clears(n.data, m.data);
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
  mpz_clear(n.data);
  return result;
}

Z L_Z_subr(Z n, Z m) {
  Z result = L_Z_sub(n, m);
  mpz_clear(m.data);
  return result;
}

Z L_Z_sublr(Z n, Z m) {
  Z result = L_Z_sub(n, m);
  mpz_clears(n.data, m.data);
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
  mpz_clear(n.data);
  return result;
}

Z L_Z_mulr(Z n, Z m) {
  Z result = L_Z_mul(n, m);
  mpz_clear(m.data);
  return result;
}

Z L_Z_mullr(Z n, Z m) {
  Z result = L_Z_mul(n, m);
  mpz_clears(n.data, m.data);
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
  mpz_clear(n.data);
  return result;
}

Z L_Z_divr(Z n, Z m) {
  Z result = L_Z_div(n, m);
  mpz_clear(m.data);
  return result;
}

Z L_Z_divlr(Z n, Z m) {
  Z result = L_Z_div(n, m);
  mpz_clears(n.data, m.data);
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
  mpz_clear(n.data);
  return result;
}

Z L_Z_remr(Z n, Z m) {
  Z result = L_Z_rem(n, m);
  mpz_clear(m.data);
  return result;
}

Z L_Z_remlr(Z n, Z m) {
  Z result = L_Z_rem(n, m);
  mpz_clears(n.data, m.data);
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
  mpz_clear(n.data);
  return result;
}

N L_N_addr(N n, N m) {
  N result = L_N_add(n, m);
  mpz_clear(m.data);
  return result;
}

N L_N_addlr(N n, N m) {
  N result = L_N_add(n, m);
  mpz_clears(n.data, m.data);
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
  mpz_clear(n.data);
  return result;
}

N L_N_subr(N n, N m) {
  N result = L_N_sub(n, m);
  mpz_clear(m.data);
  return result;
}

N L_N_sublr(N n, N m) {
  N result = L_N_sub(n, m);
  mpz_clears(n.data, m.data);
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
  mpz_clear(n.data);
  return result;
}

N L_N_mulr(N n, N m) {
  N result = L_N_mul(n, m);
  mpz_clear(m.data);
  return result;
}

N L_N_mullr(N n, N m) {
  N result = L_N_mul(n, m);
  mpz_clears(n.data, m.data);
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
  mpz_clear(n.data);
  return result;
}

N L_N_divr(N n, N m) {
  N result = L_N_div(n, m);
  mpz_clear(m.data);
  return result;
}

N L_N_divlr(N n, N m) {
  N result = L_N_div(n, m);
  mpz_clears(n.data, m.data);
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
  mpz_clear(n.data);
  return result;
}

N L_N_remr(N n, N m) {
  N result = L_N_rem(n, m);
  mpz_clear(m.data);
  return result;
}

N L_N_remlr(N n, N m) {
  N result = L_N_rem(n, m);
  mpz_clears(n.data, m.data);
  return result;
}

#endif

static void __EV() {
  U8 __EV_F32_IS_32[1 - (2 * ((sizeof(F32) * CHAR_BIT) != 32))];
  U8 __EV_F64_IS_64[1 - (2 * ((sizeof(F64) * CHAR_BIT) != 64))];
  L_assert(F);
}

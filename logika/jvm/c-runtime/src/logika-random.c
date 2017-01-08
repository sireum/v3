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

#include <sodium.h>
#include <logika-random.h>

U8 L_random_U8(void) {
  return (U8) randombytes_uniform(256);
}

U16 L_random_U16(void) {
  return (U16) randombytes_uniform(65536);
}

U32 L_random_U32(void) {
  return randombytes_random();
}

U64 L_random_U64(void) {
  return ((U64) randombytes_random()) << 32 | randombytes_random();
}

#if BIT_WIDTH == 0

Z L_random_Z(void) {
  Z result = {0};
  int n = (int) randombytes_uniform(16);
  mpz_init_set_ui(result.data, randombytes_random());
  int i;
  for (i = 0; i < n; i++) {
    mpz_mul_ui(result.data, result.data, (unsigned long int) i + 1);
    mpz_add_ui(result.data, result.data, randombytes_random());
  }
  return result;
}

#endif

ZS L_random_ZS(void) {
  ZS result = {0};
  size_t size = (size_t) randombytes_uniform(L_RANDOM_SEQ_MAX);
  result.size = size;
  result.data = L_malloc(size * sizeof(Z));
  size_t i;
  for (i = 0; i < size; i++) {
    result.data[i] = L_random_Z();
  }
  return result;
}

#if BIT_WIDTH != 0
NS L_random_NS(void) {
  NS result = {0};
  size_t size = (size_t) randombytes_uniform(L_RANDOM_SEQ_MAX);
  result.size = size;
  result.data = L_malloc(size * sizeof(N));
  for (size_t i = 0; i < size; i++) {
    result.data[i] = L_random_N();
  }
  return result;
}
#endif

S8S L_random_S8S(void) {
  S8S result = {0};
  size_t size = (size_t) randombytes_uniform(L_RANDOM_SEQ_MAX);
  result.size = size;
  result.data = L_malloc(size * sizeof(S8));
  size_t i;
  for (i = 0; i < size; i++) {
    result.data[i] = L_random_S8();
  }
  return result;
}

S16S L_random_S16S(void) {
  S16S result = {0};
  size_t size = (size_t) randombytes_uniform(L_RANDOM_SEQ_MAX);
  result.size = size;
  result.data = L_malloc(size * sizeof(S16));
  size_t i;
  for (i = 0; i < size; i++) {
    result.data[i] = L_random_S16();
  }
  return result;
}

S32S L_random_S32S(void) {
  S32S result = {0};
  size_t size = (size_t) randombytes_uniform(L_RANDOM_SEQ_MAX);
  result.size = size;
  result.data = L_malloc(size * sizeof(S32));
  size_t i;
  for (i = 0; i < size; i++) {
    result.data[i] = L_random_S32();
  }
  return result;
}

S64S L_random_S64S(void) {
  S64S result = {0};
  size_t size = (size_t) randombytes_uniform(L_RANDOM_SEQ_MAX);
  result.size = size;
  result.data = L_malloc(size * sizeof(S64));
  size_t i;
  for (i = 0; i < size; i++) {
    result.data[i] = L_random_S64();
  }
  return result;
}

U8S L_random_U8S(void) {
  U8S result = {0};
  size_t size = (size_t) randombytes_uniform(L_RANDOM_SEQ_MAX);
  result.size = size;
  result.data = L_malloc(size * sizeof(U8));
  size_t i;
  for (i = 0; i < size; i++) {
    result.data[i] = L_random_U8();
  }
  return result;
}

U16S L_random_U16S(void) {
  U16S result = {0};
  size_t size = (size_t) randombytes_uniform(L_RANDOM_SEQ_MAX);
  result.size = size;
  result.data = L_malloc(size * sizeof(U16));
  size_t i;
  for (i = 0; i < size; i++) {
    result.data[i] = L_random_U16();
  }
  return result;
}

U32S L_random_U32S(void) {
  U32S result = {0};
  size_t size = (size_t) randombytes_uniform(L_RANDOM_SEQ_MAX);
  result.size = size;
  result.data = L_malloc(size * sizeof(U32));
  size_t i;
  for (i = 0; i < size; i++) {
    result.data[i] = L_random_U32();
  }
  return result;
}

U64S L_random_U64S(void) {
  U64S result = {0};
  size_t size = (size_t) randombytes_uniform(L_RANDOM_SEQ_MAX);
  result.size = size;
  result.data = L_malloc(size * sizeof(U64));
  size_t i;
  for (i = 0; i < size; i++) {
    result.data[i] = L_random_U64();
  }
  return result;
}

F32S L_random_F32S(void) {
  F32S result = {0};
  size_t size = (size_t) randombytes_uniform(L_RANDOM_SEQ_MAX);
  result.size = size;
  result.data = L_malloc(size * sizeof(F32));
  size_t i;
  for (i = 0; i < size; i++) {
    result.data[i] = L_random_F32();
  }
  return result;
}

F64S L_random_F64S(void) {
  F64S result = {0};
  size_t size = (size_t) randombytes_uniform(L_RANDOM_SEQ_MAX);
  result.size = size;
  result.data = L_malloc(size * sizeof(F64));
  size_t i;
  for (i = 0; i < size; i++) {
    result.data[i] = L_random_N64();
  }
  return result;
}

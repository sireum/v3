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

#include <ctype.h>
#include <errno.h>
#include <limits.h>
#include <sodium.h>
#include <stdarg.h>
#include <logika-io.h>

#if BIT_WIDTH == 0

L_string L_Z_toString(const Z n) {
  return mpz_get_str(NULL, 10, n.data);
}

#elif BIT_WIDTH == 64

L_string L_Z_toString(const Z n) {
  size_t length = snprintf(NULL, 0, "%lld", n);
  L_string str = L_malloc(length + 1);
  snprintf(str, length + 1, "%lld", n);
  return str;
}

#else

L_string L_Z_toString(const Z n) {
  size_t length = snprintf(NULL, 0, "%d", n);
  L_string str = L_malloc(length + 1);
  snprintf(str, length + 1, "%d", n);
  return str;
}

#endif

static L_string L_readLine(const L_string msg) {
  size_t capacity = 1024;
  L_string line = L_malloc(capacity);
  printf("%s", msg);
  fflush(stdout);
  size_t size = 0;
  int c;
  while ((c = getchar()) != EOF && c != '\n') {
    if (size == capacity) {
      capacity *= 2;
      line = L_realloc(line, capacity);
    }
    line[size++] = (char) c;
  }
  if (size == capacity) {
    capacity += 1;
    line = L_realloc(line, capacity);
  }
  line[size] = 0;

  return line;
}

static bool L_str2int(long long int *out,
                      const L_string str,
                      const long long int min,
                      const long long int max) {
  if (str[0] == '\0' || isspace(str[0]))
    return false;
  L_string end;
  errno = 0;
  long l = strtol((L_string) str, &end, 10);
  if (l > max || (errno == ERANGE && l == LLONG_MAX))
    return false;
  if (l < min || (errno == ERANGE && l == LLONG_MIN))
    return false;
  if (*end != '\0')
    return false;
  *out = l;
  return true;
}

Z L_Z_read(const L_string msg) {
  L_string s = L_readLine(msg);
#if BIT_WIDTH == 0
  Z result = {0};
  if (s[0] == '\0' || isspace(s[0]) || mpz_init_set_str(result.data, s, 10) == -1) {
    printf("Invalid value '%s' for an integer.\n", s);
    result = L_Z_read(msg);
  }
#elif BIT_WIDTH == 8
  Z result;
  long long int n;
  if (!L_str2int(&n, s, Z8_Min, Z8_Max)) {
    printf("Invalid value '%s' for 8-bit integer.\n", s);
    result = L_Z_read(msg);
  } else {
    result = (Z8) n;
  }
#elif BIT_WIDTH == 16
  Z result;
  long long int n;
  if (!L_str2int(&n, s, Z16_Min, Z16_Max)) {
    printf("Invalid value '%s' for 16-bit integer.\n", s);
    result = L_Z_read(msg);
  } else {
    result = (Z16) n;
  }
#elif BIT_WIDTH == 32
  Z result;
  long long int n;
  if (!L_str2int(&n, s, Z32_Min, Z32_Max)) {
    printf("Invalid value '%s' for 32-bit integer.\n", s);
    result = L_Z_read(msg);
  } else {
    result = (Z32) n;
  }
#elif BIT_WIDTH == 64
  Z result;
  long long int n;
  if (!L_str2int(&n, s, Z64_Min, Z64_Max)) {
    printf("Invalid value '%s' for 64-bit integer.\n", s);
    result = L_Z_read(msg);
  } else {
    result = (Z64) n;
  }
#endif
  free(s);
  return result;
}

Z8 L_Z8_random() {
  return (Z8) randombytes_uniform(256);
}

Z16 L_Z16_random() {
  return (Z16) randombytes_uniform(65536);
}

Z32 L_Z32_random() {
  return randombytes_random();
}

Z64 L_Z64_random() {
  return ((Z64) randombytes_random()) << 32 | randombytes_random();
}

#if BIT_WIDTH == 0
Z L_Z_random() {
  Z result = {0};
  int n = (int) randombytes_uniform(16);
  mpz_init_set_ui(result.data, randombytes_random());
  for (int i = 0; i < n; i++) {
    mpz_mul_ui(result.data, result.data, (unsigned long int) i + 1);
    mpz_add_ui(result.data, result.data, randombytes_random());
  }
  return result;
}
#endif

ZS L_ZS_random() {
  ZS result = {0};
  size_t size = (size_t) randombytes_uniform(L_RANDOM_SEQ_MAX);
  result.size = size;
  result.data = L_malloc(size * sizeof(Z));
  for (size_t i = 0; i < size; i++) {
    result.data[i] = L_Z_random();
  }
  return result;
}

#if BIT_WIDTH != 0
NS L_NS_random() {
  NS result = {0};
  size_t size = (size_t) randombytes_uniform(L_RANDOM_SEQ_MAX);
  result.size = size;
  result.data = L_malloc(size * sizeof(N));
  for (size_t i = 0; i < size; i++) {
    result.data[i] = L_N_random();
  }
  return result;
}
#endif

Z8S L_Z8S_random() {
  Z8S result = {0};
  size_t size = (size_t) randombytes_uniform(L_RANDOM_SEQ_MAX);
  result.size = size;
  result.data = L_malloc(size * sizeof(Z8));
  for (size_t i = 0; i < size; i++) {
    result.data[i] = L_Z8_random();
  }
  return result;
}

Z16S L_Z16S_random() {
  Z16S result = {0};
  size_t size = (size_t) randombytes_uniform(L_RANDOM_SEQ_MAX);
  result.size = size;
  result.data = L_malloc(size * sizeof(Z16));
  for (size_t i = 0; i < size; i++) {
    result.data[i] = L_Z16_random();
  }
  return result;
}

Z32S L_Z32S_random() {
  Z32S result = {0};
  size_t size = (size_t) randombytes_uniform(L_RANDOM_SEQ_MAX);
  result.size = size;
  result.data = L_malloc(size * sizeof(Z32));
  for (size_t i = 0; i < size; i++) {
    result.data[i] = L_Z32_random();
  }
  return result;
}

Z64S L_Z64S_random() {
  Z64S result = {0};
  size_t size = (size_t) randombytes_uniform(L_RANDOM_SEQ_MAX);
  result.size = size;
  result.data = L_malloc(size * sizeof(Z64));
  for (size_t i = 0; i < size; i++) {
    result.data[i] = L_Z64_random();
  }
  return result;
}

N8S L_N8S_random() {
  N8S result = {0};
  size_t size = (size_t) randombytes_uniform(L_RANDOM_SEQ_MAX);
  result.size = size;
  result.data = L_malloc(size * sizeof(N8));
  for (size_t i = 0; i < size; i++) {
    result.data[i] = L_N8_random();
  }
  return result;
}

N16S L_N16S_random() {
  N16S result = {0};
  size_t size = (size_t) randombytes_uniform(L_RANDOM_SEQ_MAX);
  result.size = size;
  result.data = L_malloc(size * sizeof(N16));
  for (size_t i = 0; i < size; i++) {
    result.data[i] = L_N16_random();
  }
  return result;
}

N32S L_N32S_random() {
  N32S result = {0};
  size_t size = (size_t) randombytes_uniform(L_RANDOM_SEQ_MAX);
  result.size = size;
  result.data = L_malloc(size * sizeof(N32));
  for (size_t i = 0; i < size; i++) {
    result.data[i] = L_N32_random();
  }
  return result;
}

N64S L_N64S_random() {
  N64S result = {0};
  size_t size = (size_t) randombytes_uniform(L_RANDOM_SEQ_MAX);
  result.size = size;
  result.data = L_malloc(size * sizeof(N64));
  for (size_t i = 0; i < size; i++) {
    result.data[i] = L_N64_random();
  }
  return result;
}

F32S L_F32S_random() {
  F32S result = {0};
  size_t size = (size_t) randombytes_uniform(L_RANDOM_SEQ_MAX);
  result.size = size;
  result.data = L_malloc(size * sizeof(F32));
  for (size_t i = 0; i < size; i++) {
    result.data[i] = L_F32_random();
  }
  return result;
}

F64S L_F64S_random() {
  F64S result = {0};
  size_t size = (size_t) randombytes_uniform(L_RANDOM_SEQ_MAX);
  result.size = size;
  result.data = L_malloc(size * sizeof(F64));
  for (size_t i = 0; i < size; i++) {
    result.data[i] = L_F64_random();
  }
  return result;
}

void L_print(const int strNum, ...) {
  va_list valist;
  va_start(valist, strNum);
  for (int i = 0; i < strNum; i++) {
    printf("%s", *va_arg(valist, L_string *));
    fflush(stdout);
  }
  va_end(valist);
}

void L_println(const int strNum, ...) {
  va_list valist;
  va_start(valist, strNum);
  for (int i = 0; i < strNum; i++) {
    L_string str = va_arg(valist, L_string);
    printf("%s", str);
    fflush(stdout);
  }
  va_end(valist);
  printf("\n");
  fflush(stdout);
}

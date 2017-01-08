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
#include <logika-io.h>

#define LL_MAX ((0x7fffffffLL << 32) | 0xffffffffLL)
#define LL_MIN ((0xffffffffLL << 32) | 0xffffffffLL)

static char *L_readLine(const char *msg) {
  size_t capacity = L_READLINE_INIT_SIZE;
  char *line = L_malloc(capacity);
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
                      const char *str,
                      const long long int min,
                      const long long int max) {
  if (str[0] == '\0' || isspace(str[0]))
    return false;
  char *end;
  errno = 0;
  long long int l = strtoll((char *) str, &end, 10);
  if (l > max || (errno == ERANGE && l == LL_MAX))
    return false;
  if (l < min || (errno == ERANGE && l == LL_MIN))
    return false;
  if (*end != '\0')
    return false;
  *out = l;
  return true;
}

Z L_read_Z(const char *msg) {
  char *s = L_readLine(msg);
#if BIT_WIDTH == 0
  Z result = {0};
  if (s[0] == '\0' || isspace(s[0]) || mpz_init_set_str(result.data, s, 10) == -1) {
    printf("Invalid value '%s' for an integer.\n", s);
    result = L_read_Z(msg);
  }
#elif BIT_WIDTH == 8
  Z result;
  long long int n;
  if (!L_str2int(&n, s, Z8_Min, Z8_Max)) {
    printf("Invalid value '%s' for 8-bit integer.\n", s);
    result = L_read_Z(msg);
  } else {
    result = (Z8) n;
  }
#elif BIT_WIDTH == 16
  Z result;
  long long int n;
  if (!L_str2int(&n, s, Z16_Min, Z16_Max)) {
    printf("Invalid value '%s' for 16-bit integer.\n", s);
    result = L_read_Z(msg);
  } else {
    result = (Z16) n;
  }
#elif BIT_WIDTH == 32
  Z result;
  long long int n;
  if (!L_str2int(&n, s, Z32_Min, Z32_Max)) {
    printf("Invalid value '%s' for 32-bit integer.\n", s);
    result = L_read_Z(msg);
  } else {
    result = (Z32) n;
  }
#elif BIT_WIDTH == 64
  Z result;
  long long int n;
  if (!L_str2int(&n, s, Z64_Min, Z64_Max)) {
    printf("Invalid value '%s' for 64-bit integer.\n", s);
    result = L_read_Z(msg);
  } else {
    result = (Z64) n;
  }
#endif
  free(s);
  return result;
}

void L_print_S8(const S8 n) {
  printf("%d", (int) n);
}

void L_print_S16(const S16 n) {
  printf("%d", (int) n);
}

void L_print_S32(const S32 n) {
  printf("%ld", (long int) n);
}

void L_print_S64(const S64 n) {
  printf("%lld", (long long int) n);
}

void L_print_U8(const U8 n) {
  printf("%u", (unsigned int) n);
}

void L_print_U16(const U16 n) {
  printf("%u", (unsigned int) n);
}

void L_print_U32(const U32 n) {
  printf("%lu", (unsigned long int) n);
}

void L_print_U64(const U64 n) {
  printf("%llu", (unsigned long long int) n);
}

#if BIT_WIDTH == 0

void L_print_Z(const Z n) {
  char *str = mpz_get_str(NULL, 10, n.data);
  printf("%s", str);
  free(str);
}

void L_print_ZS(ZS ns) {
  L_print("[");
  size_t size = ns.size;
  if (size > 0) {
    L_print_Z(ns.data[0]);
    size_t i;
    for (i = 1; i < size; i++) {
      L_print(", ");
      L_print_Z(ns.data[i]);
    }
  }
  L_print("]");
}

#endif

void L_print_S8S(S8S ns) {
  L_print("[");
  size_t size = ns.size;
  if (size > 0) {
    L_print_S8(ns.data[0]);
    size_t i;
    for (i = 1; i < size; i++) {
      L_print(", ");
      L_print_S8(ns.data[i]);
    }
  }
  L_print("]");
}

void L_print_S16S(S16S ns) {
  L_print("[");
  size_t size = ns.size;
  if (size > 0) {
    L_print_S16(ns.data[0]);
    size_t i;
    for (i = 1; i < size; i++) {
      L_print(", ");
      L_print_S16(ns.data[i]);
    }
  }
  L_print("]");
}

void L_print_S32S(S32S ns) {
  L_print("[");
  size_t size = ns.size;
  if (size > 0) {
    L_print_S32(ns.data[0]);
    size_t i;
    for (i = 1; i < size; i++) {
      L_print(", ");
      L_print_S32(ns.data[i]);
    }
  }
  L_print("]");
}

void L_print_S64S(S64S ns) {
  L_print("[");
  size_t size = ns.size;
  if (size > 0) {
    L_print_S64(ns.data[0]);
    size_t i;
    for (i = 1; i < size; i++) {
      L_print(", ");
      L_print_S64(ns.data[i]);
    }
  }
  L_print("]");
}

void L_print_U8S(U8S ns) {
  L_print("[");
  size_t size = ns.size;
  if (size > 0) {
    L_print_U8(ns.data[0]);
    size_t i;
    for (i = 1; i < size; i++) {
      L_print(", ");
      L_print_U8(ns.data[i]);
    }
  }
  L_print("]");
}

void L_print_U16S(U16S ns) {
  L_print("[");
  size_t size = ns.size;
  if (size > 0) {
    L_print_U16(ns.data[0]);
    size_t i;
    for (i = 1; i < size; i++) {
      L_print(", ");
      L_print_U16(ns.data[i]);
    }
  }
  L_print("]");
}

void L_print_U32S(U32S ns) {
  L_print("[");
  size_t size = ns.size;
  if (size > 0) {
    L_print_U32(ns.data[0]);
    size_t i;
    for (i = 1; i < size; i++) {
      L_print(", ");
      L_print_U32(ns.data[i]);
    }
  }
  L_print("]");
}

void L_print_U64S(U64S ns) {
  L_print("[");
  size_t size = ns.size;
  if (size > 0) {
    L_print_U64(ns.data[0]);
    size_t i;
    for (i = 1; i < size; i++) {
      L_print(", ");
      L_print_U64(ns.data[i]);
    }
  }
  L_print("]");
}

void L_print(char *str) {
  printf("%s", str);
}

void L_println(void) {
  printf("\n");
}

void L_flush(void) {
  fflush(stdout);
}

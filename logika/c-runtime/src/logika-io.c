#include "logika-io.h"

#if BIT_WIDTH == 0

L_string L_Z_toString(const Z n) {
  return mpz_get_str(NULL, 10, n.data);
}

#elif BIT_WIDTH == 64

L_string L_Z_toString(const Z n) {
  size_t length = snprintf(NULL, 0, "%lld", n);
  L_string str = malloc(length + 1);
  snprintf(str, length + 1, "%lld", n);
  return str;
}

#else

L_string L_Z_toString(const Z n) {
  size_t length = snprintf(NULL, 0, "%d", n);
  L_string str = malloc(length + 1);
  snprintf(str, length + 1, "%d", n);
  return str;
}

#endif

static L_string L_readLine(const L_string msg) {
  size_t capacity = 1024;
  L_string line = malloc(capacity);
  L_assert(line != NULL);
  printf("%s", msg);
  fflush(stdout);
  size_t size = 0;
  int c;
  while ((c = getchar()) != EOF && c != '\n') {
    if (size == capacity) {
      capacity *= 2;
      line = realloc(line, capacity);
      L_assert(line != NULL);
    }
    line[size++] = (char) c;
  }
  if (size == capacity) {
    capacity += 1;
    line = realloc(line, capacity);
    L_assert(line != NULL);
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

Z L_readInt(const L_string msg) {
  L_string s = L_readLine(msg);
#if BIT_WIDTH == 0
  Z result = {0};
  if (s[0] == '\0' || isspace(s[0]) || mpz_init_set_str(result.data, s, 10) == -1) {
    printf("Invalid value '%s' for an integer.\n", s);
    result = L_readInt(msg);
  }
#elif BIT_WIDTH == 8
  Z result;
  long long int n;
  if (!L_str2int(&n, s, Z8_Min, Z8_Max)) {
    printf("Invalid value '%s' for 8-bit integer.\n", s);
    result = L_readInt(msg);
  } else {
    result = (Z8) n;
  }
#elif BIT_WIDTH == 16
  Z result;
  long long int n;
  if (!L_str2int(&n, s, Z16_Min, Z16_Max)) {
    printf("Invalid value '%s' for 16-bit integer.\n", s);
    result = L_readInt(msg);
  } else {
    result = (Z16) n;
  }
#elif BIT_WIDTH == 32
  Z result;
  long long int n;
  if (!L_str2int(&n, s, Z32_Min, Z32_Max)) {
    printf("Invalid value '%s' for 32-bit integer.\n", s);
    result = L_readInt(msg);
  } else {
    result = (Z32) n;
  }
#elif BIT_WIDTH == 64
  Z result;
  long long int n;
  if (!L_str2int(&n, s, Z64_Min, Z64_Max)) {
    printf("Invalid value '%s' for 64-bit integer.\n", s);
    result = L_readInt(msg);
  } else {
    result = (Z64) n;
  }
#endif
  free(s);
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
  fflush(stdout);
}

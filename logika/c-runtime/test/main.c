#include "logika.h"
#include "logika-io.h"

int main(int argc, L_string argv[]) {
  Z a = L_readInt("Enter a: ");
  Z b = L_readInt("Enter b: ");

#if BIT_WIDTH == 0
  Z c = L_Z_mul(a, b);
#else
  Z c = a * b;
#endif

  {
    L_string arg0 = L_Z_toString(a);
    L_string arg1 = L_Z_toString(b);
    L_string arg2 = L_Z_toString(c);
    L_println(5, arg0, " * ", arg1, " => ", arg2);
    free(arg0);
    free(arg1);
    free(arg2);
  }

#if BIT_WIDTH == 0
  mpz_clear(a.data);
  mpz_clear(b.data);
  mpz_clear(c.data);
#endif
  return 0;
}
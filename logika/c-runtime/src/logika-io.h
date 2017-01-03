#ifndef LOGIKA_IO_H
#define LOGIKA_IO_H

#include <ctype.h>
#include <errno.h>
#include <stdarg.h>
#include <stdlib.h>
#include <stdio.h>
#include "logika.h"

Z L_readInt(const L_string msg);

L_string L_Z_toString(const Z n);

void L_print(const int strNum, ...);

void L_println(const int strNum, ...);

#endif
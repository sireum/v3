include(FindPackageHandleStandardArgs)

find_library(GMP_L NAMES gmp)
if (NOT GMP_L)
    message(FATAL_ERROR "Could not find GMP library!")
endif()

find_path(GMP_H NAMES gmp.h)
if (GMP_H)
    list(REMOVE_DUPLICATES GMP_H)
else()
    message(FATAL_ERROR "Could not find GMP include path!")
endif()

find_package_handle_standard_args(GMP DEFAULT_MSG GMP_H GMP_L)
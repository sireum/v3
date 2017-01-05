include(FindPackageHandleStandardArgs)

find_library(SODIUM_L NAMES sodium libsodium)
if (NOT SODIUM_L)
    message(FATAL_ERROR "Could not find Sodium library!")
endif()

find_path(SODIUM_H NAMES sodium.h)
if (SODIUM_H)
    list(REMOVE_DUPLICATES SODIUM_H)
else()
    message(FATAL_ERROR "Could not find Sodium include path!")
endif()

find_package_handle_standard_args(Sodium DEFAULT_MSG SODIUM_H SODIUM_L)
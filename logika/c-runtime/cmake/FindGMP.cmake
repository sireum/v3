include(FindPackageHandleStandardArgs)

find_library(GMP_LIBRARIES
        NAMES gmp
        DOC "GMP libraries")
if (GMP_LIBRARIES)
    message(STATUS "Found GMP library: \"${GMP_LIBRARIES}\"")
else()
    message(FATAL_ERROR "Could not find GMP library")
endif()

find_path(GMP_INCLUDES
        NAMES gmp.h
        DOC "GMP header")
if (GMP_INCLUDES)
    message(STATUS "Found GMP include path: \"${GMP_INCLUDES}\"")
else()
    message(FATAL_ERROR "Could not find GMP include path")
endif()

if (GMP_LIBRARIES AND GMP_INCLUDES)
    set(GMP_INCLUDE_DIRS "${GMP_INCLUDES}")
    list(REMOVE_DUPLICATES GMP_INCLUDE_DIRS)
    message(STATUS "Found GMP")
else()
    message(FATAL_ERROR "Could not find GMP")
endif()

find_package_handle_standard_args(GMP DEFAULT_MSG GMP_INCLUDE_DIRS GMP_LIBRARIES)
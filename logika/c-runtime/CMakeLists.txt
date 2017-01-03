cmake_minimum_required(VERSION 3.6)

project(logika-c-runtime)

set(CMAKE_C_STANDARD 99)

list(APPEND CMAKE_MODULE_PATH "${CMAKE_CURRENT_LIST_DIR}/cmake")

find_package(GMP REQUIRED)

include_directories(${GMP_INCLUDE_DIRS})

set(LIB_SOURCE_FILES src/logika.c src/logika-io.c)
set(UB -DBIT_WIDTH=0)
set(B8 -DBIT_WIDTH=8)
set(B16 -DBIT_WIDTH=16)
set(B32 -DBIT_WIDTH=32)
set(B64 -DBIT_WIDTH=64)

add_definitions(-DLOGIKA_DEBUG)
link_libraries(${GMP_LIBRARIES})


add_library(logika ${LIB_SOURCE_FILES})
target_compile_definitions(logika PUBLIC ${UB})

add_library(logika8 ${LIB_SOURCE_FILES})
target_compile_definitions(logika8 PUBLIC ${B8})

add_library(logika16 ${LIB_SOURCE_FILES})
target_compile_definitions(logika16 PUBLIC ${B16})

add_library(logika32 ${LIB_SOURCE_FILES})
target_compile_definitions(logika32 PUBLIC ${B32})

add_library(logika64 ${LIB_SOURCE_FILES})
target_compile_definitions(logika64 PUBLIC ${B64})


add_executable(logika-main test/main.c)
target_link_libraries(logika-main logika)
target_include_directories(logika-main PUBLIC src)
target_compile_definitions(logika-main PUBLIC ${UB})

add_executable(logika-main8 test/main.c)
target_link_libraries(logika-main8 logika8)
target_include_directories(logika-main8 PUBLIC src)
target_compile_definitions(logika-main8 PUBLIC ${B8})

add_executable(logika-main16 test/main.c)
target_link_libraries(logika-main16 logika16)
target_include_directories(logika-main16 PUBLIC src)
target_compile_definitions(logika-main16 PUBLIC ${B16})

add_executable(logika-main32 test/main.c)
target_link_libraries(logika-main32 logika32)
target_include_directories(logika-main32 PUBLIC src)
target_compile_definitions(logika-main32 PUBLIC ${B32})

add_executable(logika-main64 test/main.c)
target_link_libraries(logika-main64 logika64)
target_include_directories(logika-main64 PUBLIC src)
target_compile_definitions(logika-main64 PUBLIC ${B64})

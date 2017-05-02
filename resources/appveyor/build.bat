@echo off

IF %COMPILER%==msys2 (
  SET "PATH=C:\%MSYS2_DIR%\%MSYSTEM%\bin;C:\%MSYS2_DIR%\usr\bin;%PATH%"
  bash -lc "$APPVEYOR_BUILD_FOLDER/bin/sbt-launch.sh clean test:compile"
)
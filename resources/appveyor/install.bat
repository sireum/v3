@echo off

IF %COMPILER%==msys2 (
  SET "PATH=C:\%MSYS2_DIR%\%MSYSTEM%\bin;C:\%MSYS2_DIR%\usr\bin;%PATH%"
  bash -lc "pacman -S git unzip wget"
  bash -lc "$APPVEYOR_BUILD_FOLDER/bin/prelude.sh"
)
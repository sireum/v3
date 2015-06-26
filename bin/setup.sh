#!/bin/bash
COMMANDS="wget unzip rm mv"
for COMMAND in ${COMMANDS}; do
	type -P ${COMMAND} &>/dev/null && continue || { echo "${COMMAND} command not found; aborting..."; exit 1; }
done
ZULU_VERSION=1.8.0_45-8.7.0.5
if [ -n "$COMSPEC" -a -x "$COMSPEC" ]; then
  ZULU_DROP_URL=http://cdn.azulsystems.com/zulu/2015-04-8.7-bin/zulu${ZULU_VERSION}-win64.zip
elif [ "$(uname)" == "Darwin" ]; then
  ZULU_DROP_URL=http://cdn.azulsystems.com/zulu/2015-04-8.7-bin/zulu${ZULU_VERSION}-macosx.zip
elif [ "$(expr substr $(uname -s) 1 5)" == "Linux" ]; then
  ZULU_DROP_URL=http://cdn.azulsystems.com/zulu/2015-04-8.7-bin/zulu${ZULU_VERSION}-x86lx64.zip
else
  echo "Sireum does not support: $(uname)"
  exit
fi
mkdir -p platform
echo "Entering platform..."
cd platform
ZULU_DROP="${ZULU_DROP_URL##*/}"
ZULU_DIR="${ZULU_DROP%.*}"
if [ ! -d "java" ]; then
  if [ ! -d ${ZULU_DIR} ]; then
    if [ ! -f ${ZULU_DROP} ]; then
      echo
      echo Downloading ${ZULU_DROP}
      echo
      wget --referer=http://www.azulsystems.com/products/zulu/downloads ${ZULU_DROP_URL}
    fi
    echo
    echo Extracting ${ZULU_DROP}
    unzip -oq ${ZULU_DROP}
    echo
    echo Deleting ${ZULU_DROP}
    rm ${ZULU_DROP}
  fi
  echo
  echo Moving ${ZULU_DIR} to java
  mv ${ZULU_DIR} java
fi
SBT_DROP_URL=https://dl.bintray.com/sbt/native-packages/sbt/0.13.8/sbt-0.13.8.zip
SBT_DROP="${SBT_DROP_URL##*/}"
SBT_DIR=sbt
if [ ! -d ${SBT_DIR} ]; then
  if [ ! -f ${SBT_DROP_URL} ]; then
    echo
    echo Downloading ${SBT_DROP}
    echo
    wget ${SBT_DROP_URL}
  fi
  echo
  echo "Extracting ${SBT_DROP}"
  unzip -oq ${SBT_DROP}
  echo
  echo "Deleting ${SBT_DROP}"
  rm ${SBT_DROP}
fi
echo
echo "... done!"

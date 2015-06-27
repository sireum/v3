#!/bin/bash
COMMANDS="wget unzip rm mv"
for COMMAND in ${COMMANDS}; do
	type -P ${COMMAND} &>/dev/null && continue || { echo "${COMMAND} command not found; aborting..."; exit 1; }
done
ZULU_RELEASE=2015-04-8.7
ZULU_VERSION=1.8.0_45-8.7.0.5
SBT_VERSION=0.13.8
NODE_VERSION=0.12.5
if [ -n "$COMSPEC" -a -x "$COMSPEC" ]; then
  PLATFORM=win
  ZULU_DROP_URL=http://cdn.azulsystems.com/zulu/${ZULU_RELEASE}-bin/zulu${ZULU_VERSION}-win64.zip
  NODE_DROP_URL=https://nodejs.org/dist/v${NODE_VERSION}/x64/node.exe
elif [ "$(uname)" == "Darwin" ]; then
  PLATFORM=lin
  ZULU_DROP_URL=http://cdn.azulsystems.com/zulu/${ZULU_RELEASE}-bin/zulu${ZULU_VERSION}-macosx.zip
  NODE_DROP_URL=https://nodejs.org/dist/v${NODE_VERSION}/node-v${NODE_VERSION}-darwin-x64.tar.gz
elif [ "$(expr substr $(uname -s) 1 5)" == "Linux" ]; then
  PLATFORM=mac
  ZULU_DROP_URL=http://cdn.azulsystems.com/zulu/${ZULU_RELEASE}-bin/zulu${ZULU_VERSION}-x86lx64.zip
  NODE_DROP_URL=https://nodejs.org/dist/v0.12.5/node-v${NODE_VERSION}-linux-x64.tar.gz
else
  echo "Sireum does not support: $(uname)"
  exit
fi
REPO=$( cd "$( dirname "$0" )"/.. &> /dev/null && pwd )
mkdir -p ${REPO}/platform
cd ${REPO}/platform
ZULU_DROP="${ZULU_DROP_URL##*/}"
ZULU_DIR="${ZULU_DROP%.*}"
grep -q ${ZULU_VERSION} java/VER &> /dev/null && ZULU_UPDATE=false || ZULU_UPDATE=true
if [ ! -d "java" ] || [ "${ZULU_UPDATE}" = "true" ]; then
  if [ ! -f ${ZULU_DROP} ]; then
    echo
    echo "Downloading ${ZULU_DROP}"
    echo
    wget --referer=http://www.azulsystems.com/products/zulu/downloads ${ZULU_DROP_URL}
  fi
  echo
  echo "Extracting ${ZULU_DROP}"
  unzip -oq ${ZULU_DROP}
  echo
  echo "Deleting ${ZULU_DROP}"
  rm ${ZULU_DROP}
  echo
  echo "Moving ${ZULU_DIR} to java"
  rm -fR java
  mv ${ZULU_DIR} java
  echo "${ZULU_VERSION}" > java/VER
fi
SBT_DROP_URL=https://dl.bintray.com/sbt/native-packages/sbt/${SBT_VERSION}/sbt-${SBT_VERSION}.zip
SBT_DROP="${SBT_DROP_URL##*/}"
grep -q ${SBT_VERSION} sbt/VER &> /dev/null && SBT_UPDATE=false || SBT_UPDATE=true
if [ ! -d "sbt" ] || [ "${SBT_UPDATE}" = "true" ]; then
  if [ ! -f ${SBT_DROP} ]; then
    echo
    echo "Downloading ${SBT_DROP}"
    echo
    wget ${SBT_DROP_URL}
  fi
  echo
  echo "Extracting ${SBT_DROP}"
  rm -fR sbt
  unzip -oq ${SBT_DROP}
  echo
  echo "Deleting ${SBT_DROP}"
  rm ${SBT_DROP}
  echo "${SBT_VERSION}" > sbt/VER
fi
grep -q ${NODE_VERSION} node/VER &> /dev/null && NODE_UPDATE=false || NODE_UPDATE=true
if [ ! -d "node" ] || [ "${NODE_UPDATE}" = "true" ]; then
  if [ "${PLATFORM}" = "win" ]; then
    NODE_DROP="${NODE_DROP_URL##*/}"
    echo
    echo "Creating node/bin"
    rm -fR node
    mkdir -p node/bin
    cd node/bin
    echo
    echo "Downloading ${NODE_DROP}"
    echo
    wget ${NODE_DROP_URL}
    cd ../..
    echo "${NODE_VERSION}" > node/VER
  else
    NODE_DROP="${NODE_DROP_URL##*/}"
    NODE_DIR="${NODE_DROP%.tar.gz}"
    if [ ! -f ${NODE_DROP} ]; then
      echo
      echo "Downloading ${NODE_DROP}"
      echo
      wget ${NODE_DROP_URL}
    fi
    echo
    echo "Extracting ${NODE_DROP}"
    tar xfz ${NODE_DROP}
    echo
    echo "Deleting ${NODE_DROP}"
    rm ${NODE_DROP}
    echo
    echo "Moving ${NODE_DIR} to node"
    rm -fR node
    mv ${NODE_DIR} node
    echo "${NODE_VERSION}" > node/VER
  fi
fi

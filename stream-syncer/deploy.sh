#!/bin/bash
./build.sh
ssh invex@143.198.148.148 "docker stop stream-syncer"
scp build/libs/application.jar invex@143.198.148.148:/home/invex/opt/stream-syncer/build/libs
ssh invex@143.198.148.148 "docker start stream-syncer"

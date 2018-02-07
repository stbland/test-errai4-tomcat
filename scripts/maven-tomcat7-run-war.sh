#!/bin/bash 
SCRIPTPATH=$(readlink -f "$0")
SCRIPTDIR=$(dirname "$SCRIPTPATH")
$SCRIPTDIR/doMaven.sh -Ptomcat7 -Dmaven.test.skip=true tomcat7:run-war

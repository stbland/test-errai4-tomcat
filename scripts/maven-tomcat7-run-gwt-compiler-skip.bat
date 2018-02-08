@echo off
set LOGNAME=tomcat
doMaven.bat -Dgwt.compiler.skip=true -Dmaven.test.skip=true -Ptomcat7 tomcat7:run

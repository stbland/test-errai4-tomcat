@echo off
set LOGNAME=tomcat
set SCRIPTPATH=%~dp0
call "%SCRIPTPATH%doMaven.bat" -Dgwt.compiler.skip=true -Dmaven.test.skip=true -Ptomcat7 tomcat7:run-war

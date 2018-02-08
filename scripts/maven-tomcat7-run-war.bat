@echo off
set LOGNAME=tomcat
set SCRIPTPATH=%~dp0
call "%SCRIPTPATH%doMaven.bat" -Ptomcat7 -Dmaven.test.skip=true tomcat7:run-war
@echo off
set LOGNAME=tomcat
set SCRIPTPATH=%~dp0
call "%SCRIPTPATH%doMaven.bat" -Ptomcat7 tomcat7:run-war-only
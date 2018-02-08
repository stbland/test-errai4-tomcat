@echo off
set LOGNAME=tomcat
set SCRIPTPATH=%~dp0
call "%SCRIPTPATH%doMaven.bat" -Pgwt-codeserver -Pgwt-no-precompile -Ptomcat7 -Dmaven.test.skip=true package tomcat7:run-war
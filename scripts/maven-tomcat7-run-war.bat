@echo off
set LOGNAME=tomcat
call doMaven.bat -Ptomcat7 -Dmaven.test.skip=true tomcat7:run-war
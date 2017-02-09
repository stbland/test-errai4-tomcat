@echo off
set LOGNAME=tomcat
call doMaven.bat -Ptomcat7 tomcat7:run-war-only
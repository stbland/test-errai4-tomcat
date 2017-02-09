@echo off
set LOGNAME=tomcat
call doMaven -Pgwt-codeserver -Pgwt-no-precompile -Ptomcat7 -Dmaven.test.skip=true package tomcat7:run-war
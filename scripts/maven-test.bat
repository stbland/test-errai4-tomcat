@echo off
set TESTARGS=%*
set SCRIPTPATH=%~dp0
call "%SCRIPTPATH%doMaven.bat" -e resources:resources resources:testResources test %TESTARGS%
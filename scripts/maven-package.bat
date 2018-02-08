@echo off
set SCRIPTPATH=%~dp0
call "%SCRIPTPATH%doMaven.bat" -DskipTests clean package
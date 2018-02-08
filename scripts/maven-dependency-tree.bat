@echo off
set LOGNAME=dependency-tree
set SCRIPTPATH=%~dp0
call "%SCRIPTPATH%doMaven.bat" dependency:tree
pause

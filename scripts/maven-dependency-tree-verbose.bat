@echo off
set SCRIPTPATH=%~dp0
call "%SCRIPTPATH%doMaven.bat" dependency:tree -Dverbose
pause

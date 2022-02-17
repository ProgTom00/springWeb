call runcrud.bat
if "%ERRORLEVEL%" == "0" goto browser
echo.
echo executing runcrud.bat - breaking work
goto fail

:browser
start chrome http://www.google.com
if "%ERRORLEVEL%" == "0" goto openhost
echo cannot open chrome - breaking work
goto fail

:openhost
start chrome http://localhost:8080/v1/task/getTasks
if "%ERRORLEVEL%" == "0" goto end
echo cannot open host
goto fail

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished.
@ECHO off

%~d0
cd %~p0

if "%REBEL_HOME%"=="" ECHO You haven't setup JRebel. Make your life easier: http://wiki.www.uprr.com/confluence/x/wNeqAw

call mvn jetty:run -Pjetty

pause
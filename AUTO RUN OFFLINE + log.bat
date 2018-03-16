@echo off
for /f "tokens=14" %%a in ('ipconfig ^| findstr IPv4') do set _IPaddr=%%a
echo YOUR IP ADDRESS IS: %_IPaddr%
java -jar target\RadarProject-FutureX-FORK-jar-with-dependencies.jar %_IPaddr% PortFilter %_IPaddr% Offline > logall.txt
pause
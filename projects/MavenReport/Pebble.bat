@echo off

set yy=%date:~-4%

set mm=%date:~-7,2%

set dd=%date:~-10,2%

set MYDATE=%dd%-%mm%-%yy%

cd C:\Users\Deepak\Documents\apache-jmeter-3.2\apache-jmeter-3.2\bin

call jmeter -g D:\Users\AllReports\PerfTesting\Pebble_%MYDATE%\PP-3.csv -o D:\AllReports\PerformanceTesting\Pebble_%MYDATE%\PP-3
call jmeter -g D:\Users\AllReports\PerfTesting\Pebble_%MYDATE%\PP-6.csv -o D:\AllReports\PerformanceTesting\Pebble_%MYDATE%\PP-6
call jmeter -g D:\Users\AllReports\PerfTesting\Pebble_%MYDATE%\PP-17.csv -o D:\AllReports\PerformanceTesting\Pebble_%MYDATE%\PP-17
call jmeter -g D:\Users\AllReports\PerfTesting\Pebble_%MYDATE%\PP-41.csv -o D:\AllReports\PerformanceTesting\Pebble_%MYDATE%\PP-41
call jmeter -g D:\Users\AllReports\PerfTesting\Pebble_%MYDATE%\PP-34.csv -o D:\AllReports\PerformanceTesting\Pebble_%MYDATE%\PP-34
call jmeter -g D:\Users\AllReports\PerfTesting\Pebble_%MYDATE%\PP-48.csv -o D:\AllReports\PerformanceTesting\Pebble_%MYDATE%\PP-48
call jmeter -g D:\Users\AllReports\PerfTesting\Pebble_%MYDATE%\PP-55.csv -o D:\AllReports\PerformanceTesting\Pebble_%MYDATE%\PP-55
call jmeter -g D:\Users\AllReports\PerfTesting\Pebble_%MYDATE%\PP-57.csv -o D:\AllReports\PerformanceTesting\Pebble_%MYDATE%\PP-57
call jmeter -g D:\Users\AllReports\PerfTesting\Pebble_%MYDATE%\PP-61.csv -o D:\AllReports\PerformanceTesting\Pebble_%MYDATE%\PP-61
call jmeter -g D:\Users\AllReports\PerfTesting\Pebble_%MYDATE%\PP-39.csv -o D:\AllReports\PerformanceTesting\Pebble_%MYDATE%\PP-39
Echo Done
echo done
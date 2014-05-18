berlinclock
===========

Simple web app to convert a time in format hh:mm:ss to a Berlin-clock format.
The project can be built and deployed using the following maven goals.
install jetty:run

Once app has been deployed and the server is running the current server time 
in Berlin format can be seen in the following url.

http://localhost:8080/bc/

Alternatively, the service getTime is available to retrieve the Berlin representation of
the server time or any time in the correct format.

http://localhost:8080/bc/clock/berlinClock/getTime
http://localhost:8080/bc/clock/berlinClock/getTime?time=12:12:12

A Berlin time format can also be obtained from the command line using the following
maven goal.
exec:java
This mode will ask for the user's input in the specified format or an empty string.
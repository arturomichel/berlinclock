berlinclock
===========

Simple web app to convert a time in format hh:mm:ss to a Berlin-clock format.
The project can be built and deployed using the following maven goals.
install jetty:run

> mvn install jetty:run

Once app has been deployed and the server is running the current server time 
in Berlin format can be seen in the following url.

http://localhost:8080/bc/

Alternatively, the service getTime is available to retrieve the Berlin time representations using a gmt offset.
To set an alternative time zone use the offset param in the web service call.

http://localhost:8080/bc/clock/berlinClock/getTime?offset=-10

This call affects the server clock; all users using the clock will see the updated time. 

Once the offset has been set you can go back to the graphical representation of the clock using the new time.

http://localhost:8080/bc


A Berlin time format can also be obtained from the command line using the following
maven goal.

> mvn exec:java

This mode will ask for the user's input in the specified format or an empty string.

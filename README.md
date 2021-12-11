# test
A springboot task scheduler microservice, all scheduled task are in Nigeria Lagos time and will excecute in a time 2 hours behind east african time.
CSV file is located in scheduled folder under resources folder, Please change file url in scheduled class line 40 to url in your machine.

Application contain a scheduler service that runs at the time(s) specified in Spring Boot configuration file (every minute by default but can be changed). 

Create a CSV file containing 2 columns: time and bitmask representing day of week


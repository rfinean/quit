# Quit Smoking project

## Back-end queue of messages
We're using a RabbitMQ (http://www.rabbitmq.com/documentation.html) message queue service on Cloud Foundry (http://docs.cloudfoundry.com/services.html) to queue messages of encouragement from one anonymous ex-smoker to another.

## User-interface clients
* We've got a mobile web client in PHP as the main user interface (monitored real-time with GoSquared <http://www.gosquared.com/developer/>).
* We've used Twilio <http://www.twilio.com/docs> to enable SMS encouragement in addition to the web interface.

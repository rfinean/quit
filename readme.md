# Quit Smoking project

Similar to http://smokefree.nhs.uk/ways-to-quit/support-on-your-mobile/ and their text messaging service,
this sysem encourages smokers to offer some words of encouragement to other smokers trying to quit every time
they resist the urge to smoke a cigarette. This gives them something to do with their hands and also gives
them a record of how well they are doing. In return they are rewarded with words of encouragement from some
random other ex-smoker. These are just random messages from real ex-smokers in the same situation - each time
likely to be from someone different - they are not conversations.

## Back-end queue of messages
We're using a RabbitMQ (http://www.rabbitmq.com/documentation.html) message queue service on Cloud Foundry (http://docs.cloudfoundry.com/services.html) to queue messages of encouragement from one anonymous ex-smoker to another.

## User-interface clients
* We've got a mobile web client in PHP as the main user interface (monitored real-time with GoSquared <http://www.gosquared.com/developer/>).
* We've used Twilio <http://www.twilio.com/docs> to enable SMS encouragement in addition to the web interface.

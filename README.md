# aws-demo-sns-sms

The project was created to learn AWS services, exactly SNS service. Try to send SMS.
Before the research I thought I can use SNS as sms provider and can send any message to any phone number.
But there is a rule SNS topic must have a subscribers. So you must add here subscribers with subscribtion type in out case its SMS and contact info. 
AWS requires you to verify this subscriber. Therefor you could not send message anybody except verified subscribers.

One interesting thing here if you try to send message by using sdk and you input another phone number except verified subscribers
API returns you a valid response with message id and you think the message was send, unfortunately it's not. 



## To run this project

You need to override two things 
1. Inside `SmsServiceImpl` you find `aws-demo-sms` here must be your topic name.
2. `application.properties` use your credentials. aws.access-key and aws.secret-key must be changed
3. `application.properties -> aws.region-name` here must be your topic's region name.


If you don't know what credentials must be here follow this instruction:
3. Open AWS console, then IAM page. On the left menu you can find User groups menu. Open it and then create a group.
When you create a group. Note that you must attach policy inside `Attach permissions policies` part add `AmazonSNSFullAccess`.
4. After creating group, we need to create user. Don't forget to checked `Access key - Programmatic access` checkbox and attach to group which you create above.
5. After creating user you can find credentials this user page.

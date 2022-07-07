## Webhooks umgesetzt

- event in sv occur
- event goes to the aws queue
- a lamda function checks the queue
- lambda function pings a specific url that the customer defined (the webhook)

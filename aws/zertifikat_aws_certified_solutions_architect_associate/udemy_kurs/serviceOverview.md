# Services 

| Servicename | Purpose | Chapter/Videoi
| -------------  |:-------------:|:-------------:|
| Snowball | | S3 |
| Athena vs Macie | | S3 |
| S3 Transfer Acceleration | shown a tool to test transfer acceleration / mainly uploads | S3 |
| CloudFront | is a CDN (Content Delivery ) | |
| AWS DataSync | Sync data between on premise and aws | S3|
| Storage Gateway | | S3 | 
| EC2 | Elastic Compute Cloud | EC2 |
| EBS | Elastic Block Store | EC2|
| EFS | Elastic File System | EC2 |
| WAF | Web Application Firewall| EC2 |
| ENI | | EC2 |
| CloudFormation | Teraform ähnlich nur von AWS | Video 113 - Ha-Architektur |
| Load Balancer | | HA-Architekur |
| Elastic Beanstalk | quick deploy without worrying the infrastructure | Video 114 |
| Kinesis | Handle/Store Streams | |
| SWF | Simple Workflow Service | |
| SNS | Simple Notification Service| |
| SQS | Simple Queue Service | |
| API Gateway | | Applications |
| RDS | Relational Database Service| | DB|
| Redshift | Data warehouse | DB
| Aurora | Amazon relational Database | DB |
| DynamoDB| Amazon NoSQL Database | DB | 
| DMS | Database Migration Service | DB |
| CloudWatch | | 
| CloudTrail | |
| AWS Directory Service | Microsoft - Connect AWS with Active Directory  | Advanced IAM|
| RAM | Resource Access Manager - share a subnet form one account to/with a subnet from another account | Advanced IAM|
| VPC| Virtual Private Cloud | VPC |
| Direct Connect | Direct dedicated connection premise -> aws | VPC |
| NAT | Network Address Translation|
| VPC Flow Logs | | VPC |
| VPC Endpoint | traffic doesnt leave the aws network |
| PrivateLink| peering VPCs to tens,thousands of customer VPCs | VPC |
| ACL | Access Control Lists |
| NAT Instance| | VPC |
| Route Table | | VPC |


|||
|||
|||


# Terms

|Term | Description|
| -------------  |:-------------:|
| Bastion Host| |
| Elastic IP| |
| Security Groups | |
| Placement Groups ||
| Spot Instances ||
| Signed URLS S3 CloudFront ||
| ARN |  Amazon Resource Name|
| Ingress | Traffic von außen nach innen |
| Egress | Traffic von innen nach außen |
|||
|||
|||


# Performance 

## S3 and Performance
- Prefixes
- CloudFront (Download spped with the help of Edge Location)
- Transfer Acceleration (Upload Spped with the help of the Edge Locations)

- Multipart Upload (Parallelize uploads - increase efficiency)
- S3 Byte-Range Fetches (Parallelize download)

- S3 Select / Glacier Select (only retrieve a subset of data from an object - 400% performance improvment)

## DB and performance
- Read Replica

- Elasticache
  - Memcached (Simple)
  - Redis (is Multi AZ / back ups and restore possible)

- DynamoDB Specific:
  - DAX (DynamoDB Accelerator)

# EC2
global accelerator   
Global Accelerator improves performance for a wide range of applications over TCP or UDP by proxying packets at the edge to applications running in one or more AWS Regions.   


# API Caching
- API Gateway (also provide caching)





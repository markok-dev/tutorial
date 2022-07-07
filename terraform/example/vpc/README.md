Example creating a VPC and a S3 bucket via [terraform](https://www.terraform.io/).

1. set aws credentials  
`aws configure`

2. create bucket  
create the bucket that is defined in `terraform.tf`   

3. run command  
`terraform init`

4. run command  
`terraform apply`

5. destroy all created resources  
`terraform destroy`




# AWS - Credentials
go to `%USERPROFILE%\.aws\`   

open/create file `credentials`   

add folowing profile:   

```
[iam_playground]
aws_access_key_id = AKIAYYYYYYYYYYYYYYYYYXZY
aws_secret_access_key = 6BG5y7zYfLDKgCrJ7YYYYYYYYYYYYYYYYYYYXYZ

```

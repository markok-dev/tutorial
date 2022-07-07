resource "aws_s3_bucket" "b" {
  bucket = "my.terraform.testbuckt.210683"
  acl    = "private"

  tags = {
    Description = "Terraform created bucket"
    Environment = "Dev"
  }
}
terraform {
  backend "s3" {
    bucket   = "mk.terraform.testbucket.vpc2" # bucketname - this bucket must be created befor running terraform
    key      = "common_resources/ecs.tfstate" # struktur/file innerhalb vom bucket
    region   = "us-east-1"
    profile  = "iam_playground"
  }
}


# variable "aws_account_id" {
# }

# variable "aws_account_name" {
# }

variable "name" {
  description = "the project name"
  default = "ecs-playground"
}

variable "aws_region" {
  default = "us-east-1"
}

variable "aws_profile" {
  default = "iam_playground"
}

variable "aws_role_name" {
  default = "OrganizationAccountAccessRole"
}

variable "cidr" {
  description = "The CIDR block for the VPC."
  type        = string
  default     = "10.1.0.0/16"
}

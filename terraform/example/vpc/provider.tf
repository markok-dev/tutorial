provider "aws" {
  region  = var.aws_region
  profile = var.aws_profile
   #assume_role {
   #  role_arn     = "arn:aws:iam::${var.aws_account_id}:role/${var.aws_role_name}"
   #  session_name = "${var.aws_role_name}@${var.aws_account_name}"
   #}


    # these tags are set for ALL created resources
    default_tags {
      tags = {
        Environment = "staging" # taggs für die von terraform erzeugen ressourcen
        Project     = var.name
      }
    }
}

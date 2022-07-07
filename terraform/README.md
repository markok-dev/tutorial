# terraform installieren
- windows-user: use wsl  
- install the [aws cli](https://docs.aws.amazon.com/cli/latest/userguide/getting-started-install.html)
- install terraform, use the tool [tfswitch](https://tfswitch.warrensbox.com/).

# print sensitive data
https://www.terraform.io/language/state/sensitive-data   

nach terraform apply werden information über die erstellten resourcen ausgegeben.   
einige müssen als 'sensitive = true' deklariert werden.   
Diese Informationen werden nicht ausgegeben - sie werden lediglich mit '<sensitive>' angezeigt.    

Um sich diese ausgeben zu lassen:  `terraform output cd_secret_key`   
wobei `cd_secret_key` die auszugebende variable ist.    



# tfswitch
hiermit kann man bequem unterschiedliche versionen von terraform laden



# Terraform

terraform can be used for multiple platforms: azure, aws   

but there is a aws-only-tool for that from aws: cloud formation

https://www.youtube.com/watch?v=l5k1ai_GBDE   

- automate and manage your infrastructure
- provisioning infrastructure

terraform is __DECLARATIV__ = define WHAT end result you wnat

__Imperativ__ wäre = define exact steps - HOW   




### Ansible VS Terraform
Both: Infrastructure as a Code   
Both automate: provisioning, configuring and managing the infrastructure   

Terraform - Better for infrastructure   
Ansible - Better for configuring that infrastructur   


### Terraform Commands

#### refresh
query infrastructure provider to get current state

### plan
- create an execution plan   
- determines what actions are necessary to achive the desired state   
- just a preview, no changes to real resources

### apply
- execute the plan

### destroy
- destroy the resource/infrastructure
- clean up the resources
- reverting everithing what have been created








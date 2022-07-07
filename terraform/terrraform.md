Info   
Terrafrom wird benötigt, um die alle nötigen resourcen auf aws zu erzeugen    
https://www.terraform.io/



Vorbereitung auf AWS:    
- User anlegen: "terraform_expenseapp" [ein user pro app wird benötigt - es wäre auch möglich ein user für mehrere apps zu erzeugen]
- Permissions vergeben - direkt an den User hängen (nicht z.b. über eine Gruppe): AmazonS3FullAccess, CloudFrontFullAccess hinzufügen
- Tag: app mit dem Tag value: expenseapp

- s3 bucket erstellen: `com.scopevisio.expenseapp.terraform`   
wird im backend.tf-file eingetragen

Info zu Terraform:   
Terraform braucht ein S3 Bucket, um informationen zu hinterlegen, was terraform alles durchgeführt hat. um ggf. diese aktionen auch wieder rückgängig zu machen.   
dafür wurde folgener bucket erstellt: com.scopevisio.expenseapp.terraform
wobei hier dieser butcket explizit nur für die expense app erstellt wurde


- Ubunto shell starten

- in dem windows explort eingeben:   
\\wsl$\Ubuntu

Damit kommt man in die Ubunto-Verzeichnisse. In das Verzeichnis gehen und in das home-directory das Script (terraform-install.sh) von Thuan kopieren.   

die rechte für das file setzen:   
chmod +x terraform-install.sh


danach das script ausführen. 
Dabei gab es anfags schwierigkeiten, weil updates und programme installiert werden mussten:    

sudo apt update    

sudo apt install curl    

sudo apt install jq

sudo apt install unzip

./terraform-install.sh

nach dem ausführen steht da, dass man folgedens ausführen muss:   
source ~/.bashrc   
dieses dann auch ausführen.   


die export commands ausführen, damit man sich mit aws authentifiziert:   
export AWS_ACCESS_KEY_ID=AKIA4UDDKMNXXXXXXXXXXXXXXXXXXXXXXXXXXX
export AWS_SECRET_ACCESS_KEY=jCHwY/Lq+RysZBtY9Zgs9T3+3Py9YYrm/cZNCU7x


in das aws verzeichnis von dem projekt wechseln:  
`cd /mnt/c/work/dev/gitrepos/expenseapp/aws/`   

ausführen:   
`terraform init`   

ausführen:   
`terraform apply`

mit `terraform destroy`   
wird alles was aufgebaut wurde, wieder zerstört.   

######
jetzt wurde auf seiten von aws alles erzeugt was benötigt wird.
s3, cloudfront
#####

um die anwendung zu übertragen, muss der befehl    
`npm run deploy-aws` ausgeführt werden   

damit dieses geht, musste in der package.json folgender eintrag hinzugefügt werden:  
"deploy-aws": "vue-cli-service build && npx deploy-aws-s3-cloudfront --source ./dist --bucket expense.staging.scopevisio.com --delete --distribution E1QPK32UU9U1ZV --invalidation-path \"/*\" --non-interactive"

wobei "E1QPK32UU9U1ZV" die Domain Name von der CloudFront ist.

Dabei handelt es sich um folgende Bibliothek:   
__deploy-aws-s3-cloudfront:__    
https://www.npmjs.com/package/deploy-aws-s3-cloudfront    

__npx__   
https://www.npmjs.com/package/npx






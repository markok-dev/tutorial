# move git repository with history

Schritte um ein Repo z.b. von bitbucket nach github __mit history__ zu verschieben.

```
mkdir testProject
cd testProject
git init
git remote add bitbucket https://mk@bitbucket/scm/tool/testProject.git # erst das projekt, das man verschieben möchte ansteuern
git pull bitbucket master # das projekt auschecken
git remote remove bitbucket # hier wird das projekt nicht aus bitbucket entfernt, sondern nur entkoppelt
git branch -M main
git remote add origin git@github.com:company/testProject.git # jetzt steuert man das ziel-repo an
git push -u origin main # hier pusht man die dateien in das ziel-repo
```

# Mehrere Schlüssel handeln
in den .ssh-Ordner eine `config` Datei (ohne Endung) erstellen.

auf die Einrückung achten:
```
Host github.com
  HostName github.com
  User git
  IdentityFile ~/.ssh/githubkey
```
Hier wird für authentifizierung gegenüber gihub.com der angegebene Schlüssel verwendet.

weitere infos: https://linuxize.com/post/using-the-ssh-config-file/   




# Schlüssel hinzufügen 

⚠️⚠️⚠️⚠️hierfür gibt es eine andere lösung. via "config"-file ⚠️⚠️⚠️⚠️

hat man mehrere Schlüssel, müssen diese "registriert" werden:   
im Interneht ließt man

start ssh-agent   
```eval $(ssh-agent -s)```

add github key   
```ssh-add ~/.ssh/githubkey```

show all keys:
```ssh-add -l```

dies muss man bei jedem schließen der Konsole(z.B. git bash) wiederholen

das kann man mit einem script umgehen - diesen in der ~/.bashrc eintragen

```
echo "starting....."

env=~/.ssh/agent.env

agent_load_env () { test -f "$env" && . "$env" >| /dev/null ; }

agent_start () {
   echo "starting agent"
    (umask 077; ssh-agent >| "$env")
    . "$env" >| /dev/null ; }

agent_load_env

# agent_run_state: 0=agent running w/ key; 1=agent w/o key; 2= agent not running
agent_run_state=$(ssh-add -l >| /dev/null 2>&1; echo $?)

echo $agent_run_state

if [ ! "$SSH_AUTH_SOCK" ] || [ $agent_run_state = 2 ]; then
    echo "in if 1"
    agent_start
    ssh-add
    ssh-add /c/Users/marko.kovacevic/.ssh/githubkey
elif [ "$SSH_AUTH_SOCK" ] && [ $agent_run_state = 1 ]; then
    echo "in if 2"
    ssh-add
    ssh-add /c/Users/marko.kovacevic/.ssh/githubkey
fi

echo "finished"

unset env
```
Man beachte, dass hier für das Verständnis debug(echo) ausgaben stehen   
Beim öffnen der bash sieht man diese Ausgaben zu beginn
!!!! Es wird hier noch explzit ein zweiter Schlüssel hinzugefügt:  ssh-add /c/Users/marko.kovacevic/.ssh/githubkey#
löscht man diese Zeile, wird nur der ./ssh/id_rsa hinzugefügt


### Umstellung von Passwort zu SSH
Hat man ein git-repository ausgecheckt und stellt anschliessen auf ssh keys um. muss man die url in der datei .git/config des jeweiligen Projektes noch angepasst werden
die url findet man auf der oberfläche auf dem checkout link - dabei auch achten, dass man die richtige url nimmt

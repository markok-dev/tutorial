# WSL

https://docs.microsoft.com/de-de/windows/wsl/basic-commands    


!!! darauf achten, dass man die wsl richtig startet - über start und dann "wsl" eingeben !!!     

### Im Explorer den WSL-Ordner öffnen
`%USERPROFILE%`

### install updates for wsl:
`wsl --update`

falls es ein kernel update gab ist ein shutdown notwendig:   
`wsl --shutdown`   

### zeigt alle installierte distributionen an:   
`wsl --list --verbose`

man sieht welche vorhanden sind und in welcher wsl-version diese vorliegen (1 oder 2)


### to show all available distributions:   
`wsl --list --online`   

to install one of them, type:   
`wsl --install -d debian`   
the last parameter (debian) is the name of the distribution

### distribution löschen
`wsl --unregister Debian`


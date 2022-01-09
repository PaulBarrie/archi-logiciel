# Architecture logiciel - CC2

*Auteur: Paul Barrié*

> ## Architecture générale

Un controlleur web Rest avec la librairie Spring a été ajouté. Pour chacune des routes, les appels aux repositories s'effectuent 
par le biais d'événements (*Software Event Driven Architecture*).
Chacun des évènements est envoyé dans un bus d'évènement. On a deux bus: un pour les queries et un pour les commandes. 

Des erreurs métiers ont été créées et peuvent être levés par des validateurs à la construction des objets. Ces erreurs sont
ensuite prises en charge par le controlleur REST (voir `ExceptionController.java`)

> ## Tests

L'API peut être testée avec l'environnement Postman disponible [ici](https://www.getpostman.com/collections/4789810c624658a4309b).
Des tests ont par ailleurs été ajoutés en utilisant la librairie `spring test` et l'utilitaire `MockMVC`.
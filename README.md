# Architecture logiciel - CC2

*Auteur: Paul Barrié*

> ## Architecture générale

Un controlleur web Rest avec la librairie Spring a été ajouté. Pour chacune des routes, les appels aux repositories s'effectuent 
par le biais d'événements (*Software Event Driven Architecture*).
Chacun des évènements est envoyé dans un bus d'évènement. On a deux bus: un pour les queries et un pour les commandes. 

Des erreurs métiers ont été créées et peuvent être levés par des validateurs à la construction des objets. Ces erreurs sont
ensuite prises en charge par le controlleur REST (voir `ExceptionController.java`)

> ## Traitement des use cases
>> ### Use case 2: requête d'un tradesman

Le choix qui a été réalisé pour ce use case est de permettre de trouver un tradesman selon s'il a eu au moins une expérience 
professionnelle ou un diplôme dans l'un des domaines donnés. (cf `GET /tradesmen/search/?domains=<>`).

>> ### Use case 3: match d'un tradesman

>> ### Use case 7: création d'un projet
On suppose qu'un projet(`Project`) est une liste de contrats (`Contract`). Un contrat contient une série de renseignements 
spécifiques(compétence, quantité de travail en heure, prix horaire, etc.). À l'activation du projet l'ensemble des contrats
qu'il contient sont publiés.
> ## Tests

L'API peut être testée avec l'environnement Postman disponible [ici](https://www.getpostman.com/collections/4789810c624658a4309b).
Des tests ont par ailleurs été ajoutés en utilisant la librairie `spring test` et l'utilitaire `MockMVC`.
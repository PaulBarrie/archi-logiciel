# Architecture logiciel - TradeMe

*Auteur: Paul Barrié*

> ## Architecture générale

Un controlleur web Rest avec la librairie Spring a été ajouté. Pour chacune des routes, les appels aux repositories s'effectuent 
par le biais d'événements (*Software Event Driven Architecture*).
Chacun des évènements est envoyé dans un bus d'évènement. On a deux bus: un pour les queries et un pour les commandes. 

Des erreurs métiers ont été créées et peuvent être levés par des validateurs à la construction des objets. Ces erreurs sont
ensuite prises en charge par le controlleur REST (voir `ExceptionController.java`)

> ## Traitement des use cases
>> ### Use case 1: inscription d'un membre

>> ### Use case 2: requête d'un tradesman
Le choix qui a été réalisé pour ce use case est de permettre de trouver un tradesman selon s'il a eu au moins une expérience 
professionnelle ou un diplôme dans l'un des domaines donnés. Pour ce faire, il suffit d'appeler la route 
`GET /tradesmen/search/?domains=<targeted_domain>` qui renverra une liste de tradesmen.

>> ### Use case 3: match d'un tradesman

>> ### Use case 7: création d'un projet
On suppose qu'un projet(`Project`) est une liste de contrats (`Contract`). Un contrat contient une série de renseignements 
spécifiques (compétence, quantité de travail en heure, prix horaire, etc.).

Pour créer ce projet, il faut appeler la route: `POST /project` en précisant en paramètre de la requête,
l'id du contractor (`contractor_id`), la durée du chantier en jours (`day_duration`) ainsi que la localisation du chantier 
(`location`). À la création du projet son statut est `PENDING`.

Le contractor peut par la suite rajouter un contrat au projet précédemment créé en appellant la route: `POST /project/contract`
et en lui précisant l'id du projet concerné(`project_id`), le salaire horaire (`hourly_wage`), le nombre d'heures de travail 
souhaité (`nb_hours`), ainsi que le domaine de compétence recherché (`work_domain`).
Pour activer le projet, il suffit d'appeler la route `PUT /project/activate` en lui précisant l'id du projet concerné (`project_id`). 
Le statut du projet passe alors en `VALIDATED` et les contrats afférents deviennent `PUBLISHED`.

> ## Tests

L'API peut être testée avec l'environnement Postman disponible [ici](https://www.getpostman.com/collections/4789810c624658a4309b).
Des tests ont par ailleurs été ajoutés en utilisant la librairie `spring test` et l'utilitaire `MockMVC`.
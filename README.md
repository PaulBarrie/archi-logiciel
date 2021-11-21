# Architecture logiciel - CC1

*Auteur: Paul Barrié*

>## Création d'un utilisateur
Pour ce qui concerne l'enregistrement d'un utilisateur deux actions sont requises.

Premièrement, la création (l'instanciation) d'un objet d'une classe `User`. Si cet objet
peut contenir des attributs simples et typiques de ce cas d'usage (un id, un prénom, un nom, etc.), il peut
également contenir des champs plus complexes (credentials, moyen de paiement,
addresse, numéro de téléphone, etc.).

Par soucis de lisibilité et du respect du principe de responsabilité unique(*Single Responsability Principle, SRO*),
il est préférable de créer des objets distincts pour ces champs complexes qui seront injectés dans la classe principale,
`User`. On se retrouve alors avec un objet composite.

Dès lors, l'instanciation d'un utilisateur nécessitera l'instanciation d'un utilisateur. Réaliser l'instanciation de tous ces
objets dans une même classe ou une même méthode constituerait un anti-pattern (*SRO*). Pour éviter cela nous instancierons
les utilisateurs grâce à un monteur (*builder*) qui permettra de bien séparer les logiques d'instanciations des différentes
classes.
On peut ainsi ajouter un nouveau type d'utilisateur (avec un autre type de paiement) sans changer  pour autant les classes
décrivant les autres aspects d'un utilisateur (`User`, `Credentials`).

La deuxième étape de l'enregistrement consiste en la vérification des données fournies. On peut imaginer que pour cet étape
plusieurs niveau de vérification peuvent être mis en place: vérification que les champs soient tous fournis, que leur valeur
soit valide, que certains champs critiques ne sont pas déjà utilisés (ex: mail), etc.
Nous implémenterons quelques unes de ces vérifications pour la v1 du logiciel, mais nous devons adopter un pattern qui nous
permettra de rajouter facilement des étapes de vérifications. Pour cela, nous séparerons les différentes étapes en utilisant
un pattern *Chain of Resposabili    ty*.


>## Requêtes de paiement

Pour ce qui est du paiement, le process consiste à:

1. Envoyer une requête avec les données utiles à un service extérieur, `Contractor` (banque, service de gestion de paiement en ligne,
   etc.)
2. Recevoir une réponse de la part du `Contractor` (code de réponse et message).
3. De traiter la réponse et de rediriger l'utilisateur en fonction.

Deux principaux problèmes se posent à nous.
Tout d'abord, nous n'avons pas un mais potentiellement plusieurs `Contractor` à gérer. `Contractor` sera donc une classe
abstraite. De même chaque type de `Contractor` (ie: chaque classe fille) devrait avoir une instance unique et donc être un
singleton.

La deuxième problématique repose sur l'intéraction de deux process qui ont a priori des interfaces pas compatibles: le
contractor a son propre système et notre membership construit de la donnée sous un format répondant à notre propre logique
métier. Ainsi pour chaque contractor, il faudra créer un `Adapter` à même de pouvoir communiquer avec le SI de ce dernier.
Cet adapteur agira comme un client envoyant une requête à un service externe géré par le contractor en question.


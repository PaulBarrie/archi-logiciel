```
┌─────────┐
│ User    │
│         │
│         │
│         │
│         │
│         │
│         │
└─────────┘

```

>## Création d'un utilisateur

Pour coller au plus près des contraintes métiers, nous aurons besoin de créer une classe User relativement complexe dans
lequel plusieurs dépendances seront injectées:

    * Une classe Address décrivant l'addresses de l'utilisateur
    * Une classe Phone décrivant le numéro de l'utilisateur
!! Justifier la séparation des classes en plusieur morceaux -> Bridge??
Ainsi la création d'un objet User recquierera la création de deux autres objets. Pour cela, nous utilisrons un **Builder** 
(*Builder Pattern*), permettant ainsi de respeceter le *Single Responsability Principle* et donc de séparer la logique 
métier, située dans la classe User, de sa construction relativement complexe dans une classe UserBuilder.

Consécutivement à la création d'un objet utilisateur, un autre aspect doit être abordé à savoir celui de la validité des
données. Nous pourrions en effet opérer cette validation directement dans les *Factory*. Néanmoins, nous pourrions 
considérer cette pratique comme un anti-pattern puisque dès lors les classes *Factory* auraient deux fonctions: la 
création et la validation de l'objet (*Single Responsability Principle*).

Enfin, lors de la création de l'utilisateur (et éventuellement lors de la validation des données) est celle de la persistance
des données.
# Microservice des compétences

Gestion des compétences

## Installation

### Prérequis

- Une instance mongoDB sur le port 27017

Lancer la commande suivante :

```bash
mvn sping-bot:run
```

## API

### création d'une compétence

```http
POST localost:8080/api/competences
{
    "nom": "java",
    "description": "java 17"
}
```

### Récupération d'une compétence

```http
GET localost:8080/api/competences/{id}
```

Ou `{id}` représente l'identifiant de la compétence.

### Récupération de toutes les compétences

```http
GET localost:8080/api/competences
```

### Mise à jour complete d'une compétences

```http
PUT localost:8080/api/competences
{   
    "id": "2",
    "nom": "JAVA",
    "description": "Java forever"
}
```

### Mise à jour partielle d'une compétences

```http
PATCH localost:8080/api/competences/{id}
{   
    "nom": "JAVA",
    "description": "Java United"
}
```

Ou `{id}` représente l'identifiant de la compétence.

### Suppression d'une compétences

```http
DELETE localost:8080/api/competences/{id}
```

Ou `{id}` représente l'identifiant de la compétence.
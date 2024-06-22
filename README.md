# Générateur de Code Membre

Ce projet est une application Java/Spring Boot permettant de générer des codes membres personnalisés pour une organisation. L'application utilise une base de données H2 pour stocker les informations des membres et leurs codes.

## Fonctionnalités

- Génération de codes membres uniques basés sur des règles spécifiques (genre, année d'adhésion, compteur).
- Stockage des informations des membres dans une base de données H2.
- Validation de l'unicité des codes membres.

## Technologies utilisées

- Java (version minimale requise : Java 11)
- Spring Boot
- Hibernate ORM pour la gestion de la base de données
- Base de données H2 (in-memory pour les tests et développement)
- Lombok pour la réduction du code boilerplate
- Maven pour la gestion des dépendances

## Configuration

### Prérequis

Avant de démarrer, assurez-vous d'avoir installé :

- Java (version 11 ou supérieure)
- Maven

### Installation

1. Clonez ce dépôt :

   ```bash
   git clone https://github.com/votre-utilisateur/generateur-code-membre.git
   ```

2. Importez le projet dans votre IDE favori comme un projet Maven.

3. Lancez l'application en exécutant la classe principale ou via Maven :

   ```bash
   mvn spring-boot:run
   ```

   L'application démarrera avec une base de données H2 en mémoire pour les tests et le développement.

## Utilisation

### API REST

L'application expose une API REST pour gérer les membres et générer leurs codes. Voici quelques exemples d'utilisation de l'API :

1. **Ajouter un membre** : Envoie une requête POST pour ajouter un membre et générer un code unique.

2. **Récupérer tous les membres** : Envoie une requête GET pour obtenir la liste de tous les membres avec leurs informations et codes.

### Exemple de requêtes cURL

- Pour ajouter un membre, vous pouvez utiliser la commande cURL suivante :

  ```bash
  curl -X POST http://localhost:8080/api/membres -H 'Content-Type: application/json' -d '{
      "sexe": "MASCULIN",
      "prenom": "Mouhamed",
      "nom": "ndiaye",
      "email": "monmail@gmail.com",
      "anneeAdhesion": "2024-06-20T14:48:00"
  }'
  ```

- Pour récupérer tous les membres, utilisez cette commande :

  ```bash
  curl -X GET http://localhost:8899/api/membres
  ```

## Contributions

Les contributions sont les bienvenues ! Si vous souhaitez améliorer ce projet, veuillez soumettre une pull request avec vos modifications.

## Auteurs

- Votre Nom (@Seydinand18)

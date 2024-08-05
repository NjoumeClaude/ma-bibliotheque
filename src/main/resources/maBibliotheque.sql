CREATE DATABASE bibliotheque;


CREATE TABLE EMPRUNTS (

    numEmprunt INT NOT NULL,
    dateEmprunt DATE NOT NULL,
    dateRetour DATE NOT NULL,
    estRetourne BIT NOT NULL

)

CREATE TABLE LIVRES (

    idLivre INT NOT NULL,
    numIsbn VARCHAR(12),
    auteur VARCHAR(25),
    editeur VARCHAR(25)
    categorie VARCHAR(25),
    nbreExemplaire INT,
    datePublication DATE NOT NULL

)

CREATE TABLE UTILISATEURS (

    identifiant INT NOT NULL,
    nom VARCHAR(25),
    prenom VARCHAR(25),
    email VARCHAR(25)
    motDePasse VARCHAR(15),
    dateCreation DATE NOT NULL,
    dateEdition DATE NOT NULL
)

CREATE TABLE ABONNEMENTS(

    numAbonnement INT NOT NULL,
    typeAbonnement VARCHAR(15),
    statutAbonnement VARCHAR(15),
    nbreExemplaire INT,
    dateAbonnement DATE NOT NULL,
    dateExpiration DATE NOT NULL

)
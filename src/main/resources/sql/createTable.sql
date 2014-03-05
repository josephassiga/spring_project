/**
 * Création de la table Personne.
 */
create table personne(
	idPersonne INTEGER NOT NULL,
	nom VARCHAR(255) NOT NULL,
	dateNaissance date NOT NULL,
	PRIMARY KEY(idPersonne)
);

/**
 * Création de la table Amis.
 */
create table amis(
    id INTEGER NOT NULL AUTO_INCREMENT,
    idPersonne INTEGER NOT NULL,
	idFriend INTEGER NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY(idPersonne) REFERENCES personne(idPersonne)
);
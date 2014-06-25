create table UTILISATEUR (
	id integer GENERATED BY DEFAULT AS IDENTITY (START WITH 1 , INCREMENT BY 1) not null,
	nom varchar(40) not null,
	prenom varchar(40) not null,
	mail varchar(150) not null,
	constraint pk_utilisateur_id primary key(id)
);


create table CONSULTATION(
	id INTEGER GENERATED BY DEFAULT AS IDENTITY (START WITH 1 , INCREMENT BY 1 ) not null ,
	id_utilisateur_consulte integer not null,
	adresse_ip_visiteur varchar(11) not null,
	date_visite datetime not null,
	constraint pk_consultation_id primary key(id)
);

create table CENTRE_INTERET(
	id INTEGER GENERATED BY DEFAULT AS IDENTITY  (START WITH 1 , INCREMENT BY 1 ) not null,
	libelle varchar(50) not null,
	constraint pk_centre_interet_id primary key(id)
);

create table UTILISATEUR_A_CENTRE_INTERET(
	id_utilisateur integer not null,
	id_centre_interet integer not null,
	constraint pk_utilisateur_a_centre_interet primary key(id_utilisateur, id_centre_interet)
);


alter table CONSULTATION
add constraint fk_consultation_id_utilisateur_consulte foreign key(id_utilisateur_consulte)
				REFERENCES UTILISATEUR(id);
				
alter table UTILISATEUR_A_CENTRE_INTERET
add constraint fk_util_a_ct_id_utilisateur foreign key(id_utilisateur)
				references UTILISATEUR(id);
				
alter table UTILISATEUR_A_CENTRE_INTERET
add constraint fk_util_a_ct_id_centre_interet foreign key(id_centre_interet)
				references CENTRE_INTERET(id);
				
				
INSERT INTO "PUBLIC"."UTILISATEUR"
("NOM", "PRENOM", "MAIL" )
VALUES ('Lagrange', 'Romauin', 'romain.lagrange2@gmail.com');

INSERT INTO "PUBLIC"."UTILISATEUR"
("NOM", "PRENOM", "MAIL" )
VALUES ('Cavet', 'Amaury', 'amaurycavet@hotmail.fr');

INSERT INTO "PUBLIC"."UTILISATEUR"
("NOM", "PRENOM", "MAIL", "SEXE" )
VALUES ('Cavet', 'Marie', 'mariecavet@cavet.fr', 'femme');

INSERT INTO "PUBLIC"."CENTRE_INTERET"
(  "LIBELLE" )
VALUES ('Java')

INSERT INTO "PUBLIC"."CENTRE_INTERET"
(  "LIBELLE" )
VALUES ('PHP')

INSERT INTO "PUBLIC"."CENTRE_INTERET"
(  "LIBELLE" )
VALUES ('Symfony')
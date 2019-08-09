INSERT INTO `ville` (`code_postal`, `libelle_ville`) VALUES (75017, 'Paris');
INSERT INTO `ville` (`code_postal`, `libelle_ville`) VALUES (75018, 'Paris');
INSERT INTO `ville` (`code_postal`, `libelle_ville`) VALUES (75019, 'Paris');
INSERT INTO `ville` (`code_postal`, `libelle_ville`) VALUES (75020, 'Paris');
INSERT INTO `ville` (`code_postal`, `libelle_ville`) VALUES (78000, 'Versailles');
INSERT INTO `ville` (`code_postal`, `libelle_ville`) VALUES (78740, 'Vaux-sur-Seine');
INSERT INTO `ville` (`code_postal`, `libelle_ville`) VALUES (78490, 'Gambaiseuil');
INSERT INTO `ville` (`code_postal`, `libelle_ville`) VALUES (78280, 'Guyancourt');
INSERT INTO `ville` (`code_postal`, `libelle_ville`) VALUES (91440, 'Bures-sur-Yvette');
INSERT INTO `ville` (`code_postal`, `libelle_ville`) VALUES (91120, 'Palaiseau');
INSERT INTO `ville` (`code_postal`, `libelle_ville`) VALUES (91290, 'Arpajon');
INSERT INTO `ville` (`code_postal`, `libelle_ville`) VALUES (91590, 'Guigneville-sur-Essonne');
INSERT INTO `ville` (`code_postal`, `libelle_ville`) VALUES (92120, 'Montrouge');
INSERT INTO `ville` (`code_postal`, `libelle_ville`) VALUES (92110, 'Clichy');
INSERT INTO `ville` (`code_postal`, `libelle_ville`) VALUES (92250, 'La Garenne-Colombes');
INSERT INTO `ville` (`code_postal`, `libelle_ville`) VALUES (92230, 'Gennevilliers');
INSERT INTO `ville` (`code_postal`, `libelle_ville`) VALUES (93160, 'Noisy-le-Grand');
INSERT INTO `ville` (`code_postal`, `libelle_ville`) VALUES (93300, 'Aubervilliers');
INSERT INTO `ville` (`code_postal`, `libelle_ville`) VALUES (93130, 'Noisy-le-Sec');
INSERT INTO `ville` (`code_postal`, `libelle_ville`) VALUES (93000, 'Bobigny');
INSERT INTO `ville` (`code_postal`, `libelle_ville`) VALUES (94120, 'Fontenay-sous-Bois');
INSERT INTO `ville` (`code_postal`, `libelle_ville`) VALUES (94240, 'L''Haÿ-les-Roses');
INSERT INTO `ville` (`code_postal`, `libelle_ville`) VALUES (94450, 'Limeil-Brévannes');
INSERT INTO `ville` (`code_postal`, `libelle_ville`) VALUES (94140, 'Alfortville');
INSERT INTO `ville` (`code_postal`, `libelle_ville`) VALUES (95100, 'Argenteuil');
INSERT INTO `ville` (`code_postal`, `libelle_ville`) VALUES (95130, 'Le Plessis-Bouchard');
INSERT INTO `ville` (`code_postal`, `libelle_ville`) VALUES (95130, 'Le Plessis-Bouchard');
INSERT INTO `ville` (`code_postal`, `libelle_ville`) VALUES (95610, 'Éragny');

INSERT INTO `adresse` (`libelle_adresse`, `id_ville`) VALUES ('23 rue de la gare', '1');
INSERT INTO `adresse` (`libelle_adresse`, `id_ville`) VALUES ('34 rue de la république', '15');
INSERT INTO `adresse` (`libelle_adresse`, `id_ville`) VALUES ('1 rue des clos', '5');
INSERT INTO `adresse` (`libelle_adresse`, `id_ville`) VALUES ('2 rue de la poste', '7');
INSERT INTO `adresse` (`libelle_adresse`, `id_ville`) VALUES ('42 rue du pont', '11');
INSERT INTO `adresse` (`libelle_adresse`, `id_ville`) VALUES ('44 boulevard Arthur premier', '4');
INSERT INTO `adresse` (`libelle_adresse`, `id_ville`) VALUES ('11 rue de la gare', '15');
INSERT INTO `adresse` (`libelle_adresse`, `id_ville`) VALUES ('3 rue de la fontaine', '18');
INSERT INTO `adresse` (`libelle_adresse`, `id_ville`) VALUES ('23 rue des roses', '2');
INSERT INTO `adresse` (`libelle_adresse`, `id_ville`) VALUES ('10 avenue pasteur', '3');

INSERT INTO `acidite` (`indice_acidite`) VALUES (1);
INSERT INTO `acidite` (`indice_acidite`) VALUES (2);
INSERT INTO `acidite` (`indice_acidite`) VALUES (3);
INSERT INTO `acidite` (`indice_acidite`) VALUES (4);
INSERT INTO `acidite` (`indice_acidite`) VALUES (5);
INSERT INTO `acidite` (`indice_acidite`) VALUES (6);
INSERT INTO `acidite` (`indice_acidite`) VALUES (7);
INSERT INTO `acidite` (`indice_acidite`) VALUES (8);
INSERT INTO `acidite` (`indice_acidite`) VALUES (9);
INSERT INTO `acidite` (`indice_acidite`) VALUES (10);
INSERT INTO `acidite` (`indice_acidite`) VALUES (11);
INSERT INTO `acidite` (`indice_acidite`) VALUES (12);
INSERT INTO `acidite` (`indice_acidite`) VALUES (13);
INSERT INTO `acidite` (`indice_acidite`) VALUES (14);

INSERT INTO `besoin_eau` (`indice_besoin_eau`) VALUES (1);
INSERT INTO `besoin_eau` (`indice_besoin_eau`) VALUES (2);
INSERT INTO `besoin_eau` (`indice_besoin_eau`) VALUES (3);

INSERT INTO `exposition` (`libelle_exposition`) VALUES ('Ombre');
INSERT INTO `exposition` (`libelle_exposition`) VALUES('Mi-ombre');
INSERT INTO `exposition` (`libelle_exposition`) VALUES('Soleil');

INSERT INTO `humidite_sol` (`libelle_humidite`) VALUES ('Sol drainé');
INSERT INTO `humidite_sol` (`libelle_humidite`) VALUES ('Sol humide');
INSERT INTO `humidite_sol` (`libelle_humidite`) VALUES ('Sol sec');
INSERT INTO `humidite_sol` (`libelle_humidite`) VALUES ('Sol frais');

INSERT INTO `mois` (`libelle_mois`) VALUES ('Janvier');
INSERT INTO `mois` (`libelle_mois`) VALUES ('Février');
INSERT INTO `mois` (`libelle_mois`) VALUES ('Mars');
INSERT INTO `mois` (`libelle_mois`) VALUES ('Avril');
INSERT INTO `mois` (`libelle_mois`) VALUES ('Mai');
INSERT INTO `mois` (`libelle_mois`) VALUES ('Juin');
INSERT INTO `mois` (`libelle_mois`) VALUES ('Juillet');
INSERT INTO `mois` (`libelle_mois`) VALUES ('Août');
INSERT INTO `mois` (`libelle_mois`) VALUES ('Septembre');
INSERT INTO `mois` (`libelle_mois`) VALUES ('Octobre');
INSERT INTO `mois` (`libelle_mois`) VALUES ('Novembre');
INSERT INTO `mois` (`libelle_mois`) VALUES ('Décembre');

INSERT INTO `rusticite` (`indice_rusticite`) VALUES (1);
INSERT INTO `rusticite` (`indice_rusticite`) VALUES(2);
INSERT INTO `rusticite` (`indice_rusticite`) VALUES(3);

INSERT INTO `type_plante` (`libelle_type_plante`) VALUES ('Solanacée');
INSERT INTO `type_plante` (`libelle_type_plante`) VALUES ('Cucurbitacée');
INSERT INTO `type_plante` (`libelle_type_plante`) VALUES ('Apiacée');
INSERT INTO `type_plante` (`libelle_type_plante`) VALUES ('Brassicacée');

INSERT INTO `type_sol` ( `libelle_type_sol`) VALUES ('Sableux');
INSERT INTO `type_sol` ( `libelle_type_sol`) VALUES ('Argileux');
INSERT INTO `type_sol` ( `libelle_type_sol`) VALUES ('Calcaire');
INSERT INTO `type_sol` ( `libelle_type_sol`) VALUES ('Caillouteux');
INSERT INTO `type_sol` ( `libelle_type_sol`) VALUES ('Humifère');
INSERT INTO `type_sol` ( `libelle_type_sol`) VALUES ('Terre de bruyère');
INSERT INTO `type_sol` ( `libelle_type_sol`) VALUES ('Terreau');

INSERT INTO `plante` (`libelle_plante`, `id_acidite`, `id_besoin_eau`, `id_debut_floraison`, `id_debut_recolte`, `id_debut_semis`, `id_exposition`, `id_fin_floraison`, `id_fin_recolte`, `id_fin_semis`, `id_humidite_sol`, `id_rusticite`, `id_type_plante`, `id_type_sol`, `photo` ) VALUES ('Tomate', 7, 2, 6, 6, 2, 3, 9, 10, 5, 1, 1, 1, 2, 'tomates.jpg');
INSERT INTO `plante` (`libelle_plante`, `id_acidite`, `id_besoin_eau`, `id_debut_floraison`, `id_debut_recolte`, `id_debut_semis`, `id_exposition`, `id_fin_floraison`, `id_fin_recolte`, `id_fin_semis`, `id_humidite_sol`, `id_rusticite`, `id_type_plante`, `id_type_sol`, `photo`) VALUES ('Aubergine', 7, 3, 6, 7, 2, 3, 9, 9, 4, 1, 1, 1, 7, 'aubergines.jpg');
INSERT INTO `plante` (`libelle_plante`, `id_acidite`, `id_besoin_eau`, `id_debut_floraison`, `id_debut_recolte`, `id_debut_semis`, `id_exposition`, `id_fin_floraison`, `id_fin_recolte`, `id_fin_semis`, `id_humidite_sol`, `id_rusticite`, `id_type_plante`, `id_type_sol`, `photo` ) VALUES ('Poivron', 7, 2, 6, 7, 2, 3, 8, 10, 4, 4, 1, 1, 7, 'poivrons-et-les-piments.jpg');
INSERT INTO `plante` (`libelle_plante`, `id_acidite`, `id_besoin_eau`, `id_debut_floraison`, `id_debut_recolte`, `id_debut_semis`, `id_exposition`, `id_fin_floraison`, `id_fin_recolte`, `id_fin_semis`, `id_humidite_sol`, `id_rusticite`, `id_type_plante`, `id_type_sol`, `photo`) VALUES ('Concombre', 7, 2, 6, 7, 4, 3, 9, 10, 5, 1, 1, 2, 1, 'concombres.jpg');
INSERT INTO `plante` (`libelle_plante`, `id_acidite`, `id_besoin_eau`, `id_debut_floraison`, `id_debut_recolte`, `id_debut_semis`, `id_exposition`, `id_fin_floraison`, `id_fin_recolte`, `id_fin_semis`, `id_humidite_sol`, `id_rusticite`, `id_type_plante`, `id_type_sol`, `photo`) VALUES ('Courgette', 7, 2, 4, 5, 3, 3, 10, 10, 7, 1, 1, 2, 7, 'courgettes.jpg');
INSERT INTO `plante` (`libelle_plante`, `id_acidite`, `id_besoin_eau`, `id_debut_floraison`, `id_debut_recolte`, `id_debut_semis`, `id_exposition`, `id_fin_floraison`, `id_fin_recolte`, `id_fin_semis`, `id_humidite_sol`, `id_rusticite`, `id_type_plante`, `id_type_sol`, `photo`) VALUES ('Carotte', 7, 2, NULL, 6, 2, 3, NULL, 11, 6, 1, 3, 3, 1, 'carottes.jpg');
INSERT INTO `plante` (`libelle_plante`, `id_acidite`, `id_besoin_eau`, `id_debut_floraison`, `id_debut_recolte`, `id_debut_semis`, `id_exposition`, `id_fin_floraison`, `id_fin_recolte`, `id_fin_semis`, `id_humidite_sol`, `id_rusticite`, `id_type_plante`, `id_type_sol`, `photo`) VALUES ('Pomme de terre', 7, 1, NULL, 6, 3, 2, NULL, 9, 5, 1, 1, 1, 2, 'pommes-de-terre.jpg');
INSERT INTO `plante` (`libelle_plante`, `id_acidite`, `id_besoin_eau`, `id_debut_floraison`, `id_debut_recolte`, `id_debut_semis`, `id_exposition`, `id_fin_floraison`, `id_fin_recolte`, `id_fin_semis`, `id_humidite_sol`, `id_rusticite`, `id_type_plante`, `id_type_sol`, `photo` ) VALUES ('Radis', 7, 3, 5, 3, 1, 2, 10, 11, 9, 1, 2, 4, 1, 'radis.jpg');

INSERT INTO `outil` (`libelle_outil`, `quantite_outil_totale`) VALUES('Pelle', 10);
INSERT INTO `outil` (`libelle_outil`, `quantite_outil_totale`) VALUES('Râteau', 9);
INSERT INTO `outil` (`libelle_outil`, `quantite_outil_totale`) VALUES('Bêche', 5);
INSERT INTO `outil` (`libelle_outil`, `quantite_outil_totale`) VALUES('Arrosoir', 11);
INSERT INTO `outil` (`libelle_outil`, `quantite_outil_totale`) VALUES('Binette', 4);
INSERT INTO `outil` (`libelle_outil`, `quantite_outil_totale`) VALUES('Cisaille', 6);
INSERT INTO `outil` (`libelle_outil`, `quantite_outil_totale`) VALUES('Faucille', 3);
INSERT INTO `outil` (`libelle_outil`, `quantite_outil_totale`) VALUES('Faux', 3);
INSERT INTO `outil` (`libelle_outil`, `quantite_outil_totale`) VALUES('Fourche', 4);
INSERT INTO `outil` (`libelle_outil`, `quantite_outil_totale`) VALUES('Pioche', 3);
INSERT INTO `outil` (`libelle_outil`, `quantite_outil_totale`) VALUES('Seau', 5);
INSERT INTO `outil` (`libelle_outil`, `quantite_outil_totale`) VALUES('Houe', 6);
INSERT INTO `outil` (`libelle_outil`, `quantite_outil_totale`) VALUES('Sarcloir', 4);
INSERT INTO `outil` (`libelle_outil`, `quantite_outil_totale`) VALUES('Sécateur', 12);
INSERT INTO `outil` (`libelle_outil`, `quantite_outil_totale`) VALUES('Semoir', 4);
INSERT INTO `outil` (`libelle_outil`, `quantite_outil_totale`) VALUES('Brouette', 2);
INSERT INTO `outil` (`libelle_outil`, `quantite_outil_totale`) VALUES('Motobineuse', 1);
INSERT INTO `outil` (`libelle_outil`, `quantite_outil_totale`) VALUES('Tracteur', 1);
INSERT INTO `outil` (`libelle_outil`, `quantite_outil_totale`) VALUES('Batte à semis', 3);
INSERT INTO `outil` (`libelle_outil`, `quantite_outil_totale`) VALUES('Plantoir', 3);
INSERT INTO `outil` (`libelle_outil`, `quantite_outil_totale`) VALUES('Greffoir', 2);
INSERT INTO `outil` (`libelle_outil`, `quantite_outil_totale`) VALUES('Serpette', 2);
INSERT INTO `outil` (`libelle_outil`, `quantite_outil_totale`) VALUES('Pince', 3);

INSERT INTO `role` (`libelle_role`) VALUES ('Administrateur');
INSERT INTO `role` (`libelle_role`) VALUES ('Gestionnaire');
INSERT INTO `role` (`libelle_role`) VALUES ('Adherent');

INSERT INTO `competence` (`libelle_competence`) VALUES ('Débutant');
INSERT INTO `competence` (`libelle_competence`) VALUES ('Intermédiaire');
INSERT INTO `competence` (`libelle_competence`) VALUES ('Confirmé');

INSERT INTO `actions` (`libelle_action`, `id_competence`) VALUES('Planter', 2);
INSERT INTO `actions` (`libelle_action`, `id_competence`) VALUES('Récolter', 1);
INSERT INTO `actions` (`libelle_action`, `id_competence`) VALUES('Biner', 2);
INSERT INTO `actions` (`libelle_action`, `id_competence`) VALUES('Bassiner', 1);
INSERT INTO `actions` (`libelle_action`, `id_competence`) VALUES('Borner', 2);
INSERT INTO `actions` (`libelle_action`, `id_competence`) VALUES('Butter', 2);
INSERT INTO `actions` (`libelle_action`, `id_competence`) VALUES('Sercler', 2);
INSERT INTO `actions` (`libelle_action`, `id_competence`) VALUES('Repiquer', 3);
INSERT INTO `actions` (`libelle_action`, `id_competence`) VALUES('Terrauter', 1);
INSERT INTO `actions` (`libelle_action`, `id_competence`) VALUES('Pincer', 2);
INSERT INTO `actions` (`libelle_action`, `id_competence`) VALUES('Marquoter', 3);
INSERT INTO `actions` (`libelle_action`, `id_competence`) VALUES('Bouturer', 3);
INSERT INTO `actions` (`libelle_action`, `id_competence`) VALUES('Arroser', 1);
INSERT INTO `actions` (`libelle_action`, `id_competence`) VALUES('Ameublir', 2);
INSERT INTO `actions` (`libelle_action`, `id_competence`) VALUES('Amender', 1);
INSERT INTO `actions` (`libelle_action`, `id_competence`) VALUES('Semer', 1);
INSERT INTO `actions` (`libelle_action`, `id_competence`) VALUES('Bécher', 2);

INSERT INTO `sexe` (`libelle_sexe`) VALUES ('Homme');
INSERT INTO `sexe` (`libelle_sexe`) VALUES ('Femme');

INSERT INTO `adherent` (`id_competence`, `id_sexe`, `nom_usage`, `nom_naissance`, `prenom`, `date_de_naissance`, `email`, `telephone`, `date_enregistrement`, `login`, `password`, `id_role`, `id_adresse`) VALUES (1, 1, '', 'Katz', 'Axel', '1979-03-10', 'axel.katz@gmail.com', '0652329812','2019-01-02', 'axel', 'axel', 1, 1);
INSERT INTO `adherent` (`id_competence`, `id_sexe`, `nom_usage`, `nom_naissance`, `prenom`, `date_de_naissance`, `email`, `telephone`, `date_enregistrement`, `login`, `password`, `id_role`, `id_adresse`) VALUES(3, 1, '', 'Mehidi', 'Reda', '1989-08-21', 'reda.mehidi@hotmail.fr', '0798356241', '2018-11-01', 'reda', 'reda', 2, 2);
INSERT INTO `adherent` (`id_competence`, `id_sexe`, `nom_usage`, `nom_naissance`, `prenom`, `date_de_naissance`, `email`, `telephone`, `date_enregistrement`, `login`, `password`, `id_role`, `id_adresse`) VALUES (2, 1, '', 'Poma', 'Lionel', '1985-04-02', 'lionel.poma@yahoo.fr', '0698784565', '2019-03-01', 'lionel', 'lionel', 3, 3);
INSERT INTO `adherent` (`id_competence`, `id_sexe`, `nom_usage`, `nom_naissance`, `prenom`, `date_de_naissance`, `email`, `telephone`, `date_enregistrement`, `login`, `password`, `id_role`, `id_adresse`) VALUES(3, 1, '', 'Abderamane', 'Faïdine', '1987-11-20', 'faidin.abderemane@gmail.ccom', '0741526396', '2019-03-12', 'faidine', 'faidine', 3, 4);
INSERT INTO `adherent` (`id_competence`, `id_sexe`, `nom_usage`, `nom_naissance`, `prenom`, `date_de_naissance`, `email`, `telephone`, `date_enregistrement`, `login`, `password`, `id_role`, `id_adresse`) VALUES (2, 1, '', 'Gonzales Olmos', 'Javier', '1987-12-05', 'javier.gonzalez@hotmail.com', '0765894532', '2019-02-06', 'javier', 'javier', 3, 5);
INSERT INTO `adherent` (`id_competence`, `id_sexe`, `nom_usage`, `nom_naissance`, `prenom`, `date_de_naissance`, `email`, `telephone`, `date_enregistrement`, `login`, `password`, `id_role`, `id_adresse`) VALUES (2, 1, '', 'Akrour', 'Rabah', '1994-06-01', 'rabah.akrour@free.fr', '0656955178', '2019-01-17', 'rabah', 'rabah', 3, 6);
INSERT INTO `adherent` (`id_competence`, `id_sexe`, `nom_usage`, `nom_naissance`, `prenom`, `date_de_naissance`, `email`, `telephone`, `date_enregistrement`, `login`, `password`, `id_role`, `id_adresse`) VALUES (2, 2, '', 'Diraa', 'Meryem', '1980-05-02', 'meryem.diraa@yahoo.com', '0732548496', '2019-01-23', 'meryem', 'meryem', 3, 7);
INSERT INTO `adherent` (`id_competence`, `id_sexe`, `nom_usage`, `nom_naissance`, `prenom`, `date_de_naissance`, `email`, `telephone`, `date_enregistrement`, `login`, `password`, `id_role`, `id_adresse`) VALUES (2, 2, '', 'Nlend Nlend', 'Estelle', '1982-03-09', 'estelle.nleno@hotmail.fr', '0658956547', '2019-01-15', 'estelle', 'estelle', 3, 8);
INSERT INTO `adherent` (`id_competence`, `id_sexe`, `nom_usage`, `nom_naissance`, `prenom`, `date_de_naissance`, `email`, `telephone`, `date_enregistrement`, `login`, `password`, `id_role`, `id_adresse`) VALUES (3, 2, '', 'Salome', 'Hajer', '1992-03-07', 'hajer.salome@yahoo.fr', '0798546321', '2017-01-07', 'hajer', 'hajer', 3, 9);
INSERT INTO `adherent` (`id_competence`, `id_sexe`, `nom_usage`, `nom_naissance`, `prenom`, `date_de_naissance`, `email`, `telephone`, `date_enregistrement`, `login`, `password`, `id_role`, `id_adresse`) VALUES (3, 1, '', 'Talbi', 'Ilyas', '1990-05-21', 'ilyas.tal90@gmail.com', '0658692010', '2017-03-01', 'ilyas', 'ilyas', 3, 10);

INSERT INTO `motif_desinscription` (`libelle_motif_desinscription`) VALUES ('Radiation');
INSERT INTO `motif_desinscription` (`libelle_motif_desinscription`) VALUES ('Déménagement');
INSERT INTO `motif_desinscription` (`libelle_motif_desinscription`) VALUES ('Invalidité');
INSERT INTO `motif_desinscription` (`libelle_motif_desinscription`) VALUES ('Décès');

INSERT INTO `motif_tache` (`libelle_motif_tache`) VALUES ('Météo');
INSERT INTO `motif_tache` (`libelle_motif_tache`) VALUES ('Manque d effectifs');
INSERT INTO `motif_tache` (`libelle_motif_tache`) VALUES ('Outils indisponible');

INSERT INTO `terrain` (`libelle_terrain`, `longueur`, `largeur`, `date_creation_terrain`, `date_retrait_terrain`, `id_adresse`) VALUES ('Les couteaux', 140, 120, '2015-06-08', null, 9 );
INSERT INTO `terrain` (`libelle_terrain`, `longueur`, `largeur`, `date_creation_terrain`, `date_retrait_terrain`, `id_adresse`) VALUES ('Champigny', 1200, 1000, '2016-07-25', null, 8 );
INSERT INTO `terrain` (`libelle_terrain`, `longueur`, `largeur`, `date_creation_terrain`, `date_retrait_terrain`, `id_adresse`) VALUES ('Carreaux', 250, 200, '2017-08-01', null, 7 );
INSERT INTO `terrain` (`libelle_terrain`, `longueur`, `largeur`, `date_creation_terrain`, `date_retrait_terrain`, `id_adresse`) VALUES ('Les champs', 700, 500, '2018-12-14', null, 6 );
INSERT INTO `terrain` (`libelle_terrain`, `longueur`, `largeur`, `date_creation_terrain`, `date_retrait_terrain`, `id_adresse`) VALUES ('La forêt', 1500, 2000, '2019-03-12', null, 5 );

INSERT INTO `parcelle` (`libelle_parcelle`, `date_creation_parcelle`, `date_retrait_parcelle`, `id_acidite`, `id_humidite_sol`, `id_terrain`, `id_type_sol`, `couleur_parcelle`) VALUES ('A1', '2018-06-09', null, 7, 1, 1, 1, '#65d1f5');
INSERT INTO `parcelle` (`libelle_parcelle`, `date_creation_parcelle`, `date_retrait_parcelle`, `id_acidite`, `id_humidite_sol`, `id_terrain`, `id_type_sol`, `couleur_parcelle`) VALUES ('A2', '2017-05-25', null, 9, 2, 1, 2, '#ffae00');
INSERT INTO `parcelle` (`libelle_parcelle`, `date_creation_parcelle`, `date_retrait_parcelle`, `id_acidite`, `id_humidite_sol`, `id_terrain`, `id_type_sol`, `couleur_parcelle`) VALUES ('A3', '2019-02-12', null, 8, 3, 1, 3, '#f24013');
INSERT INTO `parcelle` (`libelle_parcelle`, `date_creation_parcelle`, `date_retrait_parcelle`, `id_acidite`, `id_humidite_sol`, `id_terrain`, `id_type_sol`, `couleur_parcelle`) VALUES ('B1', '2019-01-08', null, 6, 4, 2, 4, '#e0e020');
INSERT INTO `parcelle` (`libelle_parcelle`, `date_creation_parcelle`, `date_retrait_parcelle`, `id_acidite`, `id_humidite_sol`, `id_terrain`, `id_type_sol`, `couleur_parcelle`) VALUES ('B2', '2018-09-29', null, 8, 2, 2, 2, '#bf2cc9');
INSERT INTO `parcelle` (`libelle_parcelle`, `date_creation_parcelle`, `date_retrait_parcelle`, `id_acidite`, `id_humidite_sol`, `id_terrain`, `id_type_sol`, `couleur_parcelle`) VALUES ('B3', '2018-06-15', null, 7, 3, 2, 3, '#db892c');

INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('1', '1', '1');
INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('2', '1', '1');
INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('3', '1', '1');
INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('1', '2', '1');
INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('2', '2', '1');
INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('3', '2', '1');
INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('4', '1', '1');
INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('4', '2', '1');

INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('3', '5', '2');
INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('4', '5', '2');
INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('3', '6', '2');
INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('4', '6', '2');
INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('3', '7', '2');
INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('4', '7', '2');
INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('3', '8', '2');
INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('4', '8', '2');

INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('7', '3', '3');
INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('8', '3', '3');
INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('9', '3', '3');
INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('10', '3', '3');
INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('7', '4', '3');
INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('8', '4', '3');
INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('9', '4', '3');
INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('10', '4', '3');
INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('7', '5', '3');
INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('8', '5', '3');
INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('9', '5', '3');
INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('10', '5', '3');
INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('7', '6', '3');
INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('8', '6', '3');
INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('9', '6', '3');
INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('10', '6', '3');

INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('10', '8', '4');
INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('11', '8', '4');
INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('10', '9', '4');
INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('11', '9', '4');

INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('4', '2', '5');
INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('5', '2', '5');
INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('4', '3', '5');
INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('5', '3', '5');
INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('4', '4', '5');
INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('5', '4', '5');
INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('4', '5', '5');
INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('5', '5', '5');

INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('9', '3', '6');
INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('10', '3', '6');
INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('11', '3', '6');
INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('12', '3', '6');
INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('9', '4', '6');
INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('10', '4', '6');
INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('11', '4', '6');
INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('12', '4', '6');
INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('9', '5', '6');
INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('10', '5', '6');
INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('11', '5', '6');
INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('12', '5', '6');
INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('9', '6', '6');
INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('10', '6', '6');
INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('11', '6', '6');
INSERT INTO `p3_jardeen_db`.`emplacement` (`numColonne`, `numLigne`, `id_parcelle`) VALUES ('12', '6', '6');

INSERT INTO `tache` (`libelle_tache`, `date_debut_tache`, `date_fin_tache`, `nb_adherent_requis`, `id_action`, `id_competence`, `id_parcelle`, `id_plante`, `id_tache_pere`, `id_motif_report`, `date_annulation_tache`, `id_motif_annulation`) VALUES ('Semer les carottes', '2019-06-25 12:00:00', '2019-06-25 14:00:00', 3, 16, 3, 5, 6, null, null, null, null);
INSERT INTO `tache` (`libelle_tache`, `date_debut_tache`, `date_fin_tache`, `nb_adherent_requis`, `id_action`, `id_competence`, `id_parcelle`, `id_plante`, `id_tache_pere`, `id_motif_report`, `date_annulation_tache`, `id_motif_annulation`) VALUES ('Récolter les radis', '2019-06-25 14:00:00', '2019-06-25 17:00:00', 2, 2, 2, 4, 8, null, null, null, null);
INSERT INTO `tache` (`libelle_tache`, `date_debut_tache`, `date_fin_tache`, `nb_adherent_requis`, `id_action`, `id_competence`, `id_parcelle`, `id_plante`, `id_tache_pere`, `id_motif_report`, `date_annulation_tache`, `id_motif_annulation`) VALUES ('Semer les courgettes', '2019-06-26 09:00:00', '2019-06-26 10:00:00', 2, 16, 2, 3, 5, null, null, null, null);
INSERT INTO `tache` (`libelle_tache`, `date_debut_tache`, `date_fin_tache`, `nb_adherent_requis`, `id_action`, `id_competence`, `id_parcelle`, `id_plante`, `id_tache_pere`, `id_motif_report`, `date_annulation_tache`, `id_motif_annulation`) VALUES ('Planter les pommes de terre', '2019-06-26 11:00:00', '2019-06-26 13:00:00', 3, 1, 1, 2, 7, null, null, null, null);
INSERT INTO `tache` (`libelle_tache`, `date_debut_tache`, `date_fin_tache`, `nb_adherent_requis`, `id_action`, `id_competence`, `id_parcelle`, `id_plante`, `id_tache_pere`, `id_motif_report`, `date_annulation_tache`, `id_motif_annulation`) VALUES ('Repiquer les tomates', '2019-06-27 09:00:00', '2019-06-27 11:00:00', 2, 5, 1, 1, 1, null, null, null, null);

INSERT INTO `outil_action` (`id_action`, `id_outil`) VALUES (1, 1);
INSERT INTO `outil_action` (`id_action`, `id_outil`) VALUES (1, 20);
INSERT INTO `outil_action` (`id_action`, `id_outil`) VALUES (2, 14);
INSERT INTO `outil_action` (`id_action`, `id_outil`) VALUES (2, 1);
INSERT INTO `outil_action` (`id_action`, `id_outil`) VALUES (3, 5);
INSERT INTO `outil_action` (`id_action`, `id_outil`) VALUES (8, 12);
INSERT INTO `outil_action` (`id_action`, `id_outil`) VALUES (8, 20);
INSERT INTO `outil_action` (`id_action`, `id_outil`) VALUES (10, 23);
INSERT INTO `outil_action` (`id_action`, `id_outil`) VALUES (13, 4);
INSERT INTO `outil_action` (`id_action`, `id_outil`) VALUES (16, 15);
INSERT INTO `outil_action` (`id_action`, `id_outil`) VALUES (16, 19);
INSERT INTO `outil_action` (`id_action`, `id_outil`) VALUES (17, 3);


INSERT INTO `outil_tache` (`quantite_outil_utilisee`, `id_outil`, `id_tache`) VALUES (1, 15, 1);
INSERT INTO `outil_tache` (`quantite_outil_utilisee`, `id_outil`, `id_tache`) VALUES (1, 19, 1);
INSERT INTO `outil_tache` (`quantite_outil_utilisee`, `id_outil`, `id_tache`) VALUES (1, 11, 2);
INSERT INTO `outil_tache` (`quantite_outil_utilisee`, `id_outil`, `id_tache`) VALUES (1, 14, 2);
INSERT INTO `outil_tache` (`quantite_outil_utilisee`, `id_outil`, `id_tache`) VALUES (1, 1, 3);
INSERT INTO `outil_tache` (`quantite_outil_utilisee`, `id_outil`, `id_tache`) VALUES (1, 20, 3);
INSERT INTO `outil_tache` (`quantite_outil_utilisee`, `id_outil`, `id_tache`) VALUES (1, 1, 4);
INSERT INTO `outil_tache` (`quantite_outil_utilisee`, `id_outil`, `id_tache`) VALUES (2, 20, 4);
INSERT INTO `outil_tache` (`quantite_outil_utilisee`, `id_outil`, `id_tache`) VALUES (1, 12, 5);

INSERT INTO `affectation_adherent` (`id_adherent`, `id_tache`) VALUES (1, 1);
INSERT INTO `affectation_adherent` (`id_adherent`, `id_tache`) VALUES (5, 1);
INSERT INTO `affectation_adherent` (`id_adherent`, `id_tache`) VALUES (6, 2);
INSERT INTO `affectation_adherent` (`id_adherent`, `id_tache`) VALUES (8, 2);
INSERT INTO `affectation_adherent` (`id_adherent`, `id_tache`) VALUES (10, 3);
INSERT INTO `affectation_adherent` (`id_adherent`, `id_tache`) VALUES (5, 3);
INSERT INTO `affectation_adherent` (`id_adherent`, `id_tache`) VALUES (7, 4);
INSERT INTO `affectation_adherent` (`id_adherent`, `id_tache`) VALUES (2, 4);
INSERT INTO `affectation_adherent` (`id_adherent`, `id_tache`) VALUES (1, 4);
INSERT INTO `affectation_adherent` (`id_adherent`, `id_tache`) VALUES (2, 5);

INSERT INTO `volontariat_adherent` (`id_adherent`, `id_tache`) VALUES (7 , 3);
INSERT INTO `volontariat_adherent` (`id_adherent`, `id_tache`) VALUES (7 , 2);
INSERT INTO `volontariat_adherent` (`id_adherent`, `id_tache`) VALUES (2 , 1);
INSERT INTO `volontariat_adherent` (`id_adherent`, `id_tache`) VALUES (2 , 5);

INSERT INTO `adherent_terrain` (`id_adherent`, `id_terrain`) VALUES (1 , 2);
INSERT INTO `adherent_terrain` (`id_adherent`, `id_terrain`) VALUES (1 , 3);

INSERT INTO `actions_plante` (`num_ordonnancement`, `id_action`, `id_plante`) VALUES (1, 16, 1);
INSERT INTO `actions_plante` (`num_ordonnancement`, `id_action`, `id_plante`) VALUES (2, 8, 1);
INSERT INTO `actions_plante` (`num_ordonnancement`, `id_action`, `id_plante`) VALUES (3, 10, 1);
INSERT INTO `actions_plante` (`num_ordonnancement`, `id_action`, `id_plante`) VALUES (1, 17, 2);
INSERT INTO `actions_plante` (`num_ordonnancement`, `id_action`, `id_plante`) VALUES (2, 16, 2);
INSERT INTO `actions_plante` (`num_ordonnancement`, `id_action`, `id_plante`) VALUES (3, 10, 2);
INSERT INTO `actions_plante` (`num_ordonnancement`, `id_action`, `id_plante`) VALUES (1, 17, 3);
INSERT INTO `actions_plante` (`num_ordonnancement`, `id_action`, `id_plante`) VALUES (2, 16, 3);
INSERT INTO `actions_plante` (`num_ordonnancement`, `id_action`, `id_plante`) VALUES (3, 10, 3);
INSERT INTO `actions_plante` (`num_ordonnancement`, `id_action`, `id_plante`) VALUES (1, 17, 4);
INSERT INTO `actions_plante` (`num_ordonnancement`, `id_action`, `id_plante`) VALUES (2, 16, 4);
INSERT INTO `actions_plante` (`num_ordonnancement`, `id_action`, `id_plante`) VALUES (3, 10, 4);
INSERT INTO `actions_plante` (`num_ordonnancement`, `id_action`, `id_plante`) VALUES (1, 16, 5);
INSERT INTO `actions_plante` (`num_ordonnancement`, `id_action`, `id_plante`) VALUES (2, 8, 5);
INSERT INTO `actions_plante` (`num_ordonnancement`, `id_action`, `id_plante`) VALUES (3, 10, 5);
INSERT INTO `actions_plante` (`num_ordonnancement`, `id_action`, `id_plante`) VALUES (1, 16, 6);
INSERT INTO `actions_plante` (`num_ordonnancement`, `id_action`, `id_plante`) VALUES (2, 8, 6);
INSERT INTO `actions_plante` (`num_ordonnancement`, `id_action`, `id_plante`) VALUES (3, 10, 6);
INSERT INTO `actions_plante` (`num_ordonnancement`, `id_action`, `id_plante`) VALUES (3, 2, 6);

INSERT INTO `desinscription` (`id_adherent`, `id_motif_desinscription`, `date_desinscription`) VALUES (4, 1, NOW());

INSERT INTO `inscription` (`date_inscription`, `id_adherent`) VALUES ('2018-09-21', '1');
INSERT INTO `inscription` (`date_inscription`, `id_adherent`) VALUES ('2018-10-23', '2');
INSERT INTO `inscription` (`date_inscription`, `id_adherent`) VALUES ('2019-03-14', '5');
INSERT INTO `inscription` (`date_inscription`, `id_adherent`) VALUES ('2018-08-29', '6');
INSERT INTO `inscription` (`date_inscription`, `id_adherent`) VALUES ('2019-01-05', '7');
INSERT INTO `inscription` (`date_inscription`, `id_adherent`) VALUES ('2019-06-18', '8');
INSERT INTO `inscription` (`date_inscription`, `id_adherent`) VALUES ('2017-04-12', '9');
INSERT INTO `inscription` (`date_inscription`, `id_adherent`) VALUES ('2018-06-26', '10');
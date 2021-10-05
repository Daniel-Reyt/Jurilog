INSERT INTO CLIENT (NOM, PRENOM, ADRESSE, PHONE, PASSWORD, USERNAME) VALUES ('reyt', 'daniel', '11 rue de la gare 68550 Saint-Amarin', '0609336279', 'dada', 'dada');
INSERT INTO CLIENT (NOM, PRENOM, ADRESSE, PHONE, PASSWORD, USERNAME) VALUES ('Bertrand', 'James', '23 rue de la libération 75000 Paris', '0102030405', 'berber', 'james');

INSERT INTO AVOCAT (NOM, PRENOM, ADRESS, PHONE, PASSWORD, USERNAME) VALUES ('Louise', 'Hoffman', '40 rue de hagenault 68100 Colmar', '0656647825', 'louise', 'hoffman');
INSERT INTO AVOCAT (NOM, PRENOM, ADRESS, PHONE, PASSWORD, USERNAME) VALUES ('Jean', 'Pfefren', '28 rue de la colombière 68100 Colmar', '0805843178', 'Jean', 'Pfefren');

INSERT INTO RDV (DATE, HEURE_RDV, STATUS, AVOCAT_ID, CLIENT_ID) VALUES ('10-01-2021', '10:00', 1, 1, 1);
INSERT INTO RDV (DATE, HEURE_RDV, STATUS, AVOCAT_ID, CLIENT_ID) VALUES ('20-02-2022', '11:30', 1, 2, 2);
INSERT INTO RDV (DATE, HEURE_RDV, STATUS, AVOCAT_ID, CLIENT_ID) VALUES ('30-02-2022', '15:30', 0, 2, 1);

INSERT INTO FACTURE (NB_HEURE, STATUS_FACTURE, TAUX_HONORAIRE, RDV_ID) VALUES (1, 0, 10.00, 1);
INSERT INTO FACTURE (NB_HEURE, STATUS_FACTURE, TAUX_HONORAIRE, RDV_ID) VALUES (2, 1, 20.00, 2);
INSERT INTO FACTURE (NB_HEURE, STATUS_FACTURE, TAUX_HONORAIRE, RDV_ID) VALUES (3, null, 30.00, 3);
INSERT INTO CLIENT (NOM, PRENOM, ADRESSE, PHONE, PASSWORD, USERNAME) VALUES ('reyt', 'daniel', '11 rue de la gare 68550 Saint-Amarin', '0609336279', 'dada', 'dada');
INSERT INTO CLIENT (NOM, PRENOM, ADRESSE, PHONE, PASSWORD, USERNAME) VALUES ('Bertrand', 'James', '23 rue de la libération 75000 Paris', '0102030405', 'Bertrand', 'James');

INSERT INTO AVOCAT (NOM, PRENOM, ADRESS, PHONE, PASSWORD, USERNAME) VALUES ('Louise', 'Hoffman', '40 rue de hagenault 68100 Colmar', '0656647825', 'louise', 'hoffman');
INSERT INTO AVOCAT (NOM, PRENOM, ADRESS, PHONE, PASSWORD, USERNAME) VALUES ('Jean', 'Pfefren', '28 rue de la colombière 68100 Colmar', '0805843178', 'Jean', 'Pfefren');

INSERT INTO BALANCE (CLIENT_ID, MONTANT) VALUES (1, 100);
INSERT INTO BALANCE (CLIENT_ID, MONTANT) VALUES (2, 10);

INSERT INTO BALANCE_AVOCAT (AVOCAT_ID, MONTANT) VALUES (1, 10);
INSERT INTO BALANCE_AVOCAT (AVOCAT_ID, MONTANT) VALUES (2, 10);

INSERT INTO TYPE_RDV (TYPE_RDV_NAME, PERCENT_AUGMENTATION) VALUES ('administration complexe', 10.00);
INSERT INTO TYPE_RDV (TYPE_RDV_NAME, PERCENT_AUGMENTATION) VALUES ('administration simple', 0.00);
INSERT INTO TYPE_RDV (TYPE_RDV_NAME, PERCENT_AUGMENTATION) VALUES ('assistance de jugement', 5.00);
INSERT INTO TYPE_RDV (TYPE_RDV_NAME, PERCENT_AUGMENTATION) VALUES ('assistance de cours d assise', 15.00);
INSERT INTO TYPE_RDV (TYPE_RDV_NAME, PERCENT_AUGMENTATION) VALUES ('plainte diverses', 2.00);

INSERT INTO RDV (DATE, HEURE, STATUS, AVOCAT_ID, CLIENT_ID, TYPE_ID) VALUES ('2021-01-10', '10', '1', 1, 1, 1);
INSERT INTO RDV (DATE, HEURE, STATUS, AVOCAT_ID, CLIENT_ID, TYPE_ID) VALUES ('2022-02-20', '11', '1', 2, 2, 2);
INSERT INTO RDV (DATE, HEURE, STATUS, AVOCAT_ID, CLIENT_ID, TYPE_ID) VALUES ('2022-02-30', '15', '2', 1, 1, 3);
INSERT INTO RDV (DATE, HEURE, STATUS, AVOCAT_ID, CLIENT_ID, TYPE_ID) VALUES ('2022-02-30', '15', '0', 1, 1, 4);

INSERT INTO FACTURE (NB_HEURE, STATUS_FACTURE, TAUX_HONORAIRE, RDV_ID, TOTAL_FACTURE) VALUES (1, '0', 10.00, 1, 11.00);
INSERT INTO FACTURE (NB_HEURE, STATUS_FACTURE, TAUX_HONORAIRE, RDV_ID, TOTAL_FACTURE) VALUES (1, '1', 20.00, 2, 20.00);
INSERT INTO FACTURE (NB_HEURE, STATUS_FACTURE, TAUX_HONORAIRE, RDV_ID, TOTAL_FACTURE) VALUES (1, '-1', 0, 3, 0);
INSERT INTO FACTURE (NB_HEURE, STATUS_FACTURE, TAUX_HONORAIRE, RDV_ID, TOTAL_FACTURE) VALUES (1, '-1', 0, 4, 0);
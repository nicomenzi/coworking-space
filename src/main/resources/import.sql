INSERT INTO "Role" ("name") VALUES ('Administrator');

INSERT INTO "Role" ("name") VALUES ('Mitglied');

INSERT INTO "Person" ("name", "nachname", "email", "password", "role_id") VALUES (
    'Nico', 'Menzi', 'nico@menzi.ch', 'password', 1
);
INSERT INTO "Person" ("name", "nachname", "email", "password", "role_id") VALUES (
    'Tobias', 'BErtschi', 'bertschi@mengmxzi.ch', 'password', 2
);

INSERT INTO "Geraet" ("name", "specs", "beschreibung") VALUES (
    'Geraet1', 'specs1', 'beschreibung1'
);
INSERT INTO "Geraet" ("name", "specs", "beschreibung") VALUES (
    'Geraet2', 'specs2', 'beschreibung2'
);

INSERT INTO "BuchungGeraet" ("status", "dateStart", "dateEnd", "geraet_id", "person_id") VALUES (
    1 , '2019-01-01', '2019-01-02', 1 ,1 
);
INSERT INTO "BuchungGeraet" ("status", "dateStart", "dateEnd", "geraet_id", "person_id") VALUES (
    2 , '2019-01-01', '2019-01-02', 2 ,2 
);
INSERT INTO "Raum" ("name", "nummer") VALUES (
    'Raum1', 1
);
INSERT INTO "Raum" ("name", "nummer") VALUES (
    'Raum2', 2
);

INSERT INTO "BuchungRaum" ("status", "dateStart", "dateEnd", "raum_id", "person_id") VALUES (
    1 , '2019-01-01', '2019-01-02', 1 ,1 
);
INSERT INTO "BuchungRaum" ("status", "dateStart", "dateEnd", "raum_id", "person_id") VALUES (
    2 , '2019-01-01', '2019-01-02', 2 ,2 
);

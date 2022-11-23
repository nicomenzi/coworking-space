## coworking-space

Dieses Projekt ist eine Rest API die für ei Coworkingspace erstellt wurde bei dem zusätzlich auch noch Geräte bestellt werden können. Für die Authenthisierung gibt es zwei User arten nämlich Mitglied und Administrator. Die Mitglieder könne sich nur einloggen, Geräte bestellen und Plätze Reservieren. 

Das Projekt wurde mit Quarkus erstellt und verwendet eine Postgres Datenbank.

## Starten
Um das Projekt zu starten muss Docker installiert sein und in der IDE muss das Docker und Dev Container Plugin installiert sein. Danach kann das Projekt mit `Quarkus: Debug current Quarkus Project` gestartet werden.

## Datenbank

Über http://localhost:5050 ist PgAdmin4 erreichbar. Damit lässt sich die Datenbank komfortabel verwalten. Der Benutzername lautet `zli@example.com` und das Passwort `zli*123`. Die Verbindung zur PostgreSQL-Datenbank muss zuerst mit folgenden Daten konfiguriert werden:
 - Host name/address: `db`
 - Port: `5432`
 - Maintenance database: `postgres`
 - Username: `postgres`
 - Password: `postgres`

GithubRepo: https://github.com/nicomenzi/coworking-space

## API
Die API hat 2 Benutzer einmal Admin:
    - Username: `nico@menzi.ch`
    - Password: `password`

und Mitglied:
    - Username: `bertschi@mengmxzi.ch`
    - Password: `password`

Login: `http://localhost:8080/auth`

## API Dokumentation
Die API Dokumentation ist unter http://localhost:8080/q/swagger-ui/ zu finden.

# Testen
Die  Tests können mit `./mvnw quarkus:test` ausgeführt werden.
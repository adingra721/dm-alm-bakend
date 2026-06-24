# CIMA ALM

Projet Spring Boot 3.x / Java 21 pour le parametrage ALM assurance SALA ALLIANZ.

## Stack

- Java 21
- Spring Boot 3.x
- PostgreSQL
- Spring Data JPA
- MapStruct
- Lombok

## Lancement

```bash
cd cima-alm
mvn spring-boot:run
```

Configurer PostgreSQL dans `src/main/resources/application.yml`.

## Organisation des couches

Chaque module metier suit le schema :

- `entity`
- `dto`
- `mapper`
- `repository`
- `service`
- `controller`

Les endpoints CRUD sont exposes sous `/api/v1`.

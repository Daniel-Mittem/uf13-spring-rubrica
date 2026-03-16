# uf13-spring-rubrica

Applicazione Spring per la gestione di una rubrica di contatti tramite database MySQL su container Docker

### Dependencies
- Spring Web --> (sviluppo web app, manda in output una pagina HTML)
- Spring DevTools (opzionale) --> (gestisce il riavvio rapido dell'applicazione)
- Thymeleaf --> (templating HTML per pagine dinamiche)
- Spring Data JPA (tecnologia di gestione dei database)
- Driver MySQL (connettore al database)
- Lombok (boilerplate code)
- Validator O/I (validazione dei form)

Per aggiungere nuove dependencies usare l'opzione `Spring Initializr: Add starters...`

## Avvio applicazione

1. Creazione del container per il database specificato in `docker-compsose.yaml`

```bash
docker compose up mysql-db [-d]
```

2. Verificare il corretto avvio del container

```bash
docker compose ps
```

3. Terminare l'esecuzione del container

```bash
docker compose down
```
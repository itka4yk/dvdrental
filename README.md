## RentalDVD pet DDD project

### Prepare env

```bash
# create env with docker-compose
$ docker-compose up -d
```

### Database

[Sample](https://www.postgresqltutorial.com/postgresql-sample-database/) database is used.
```bash
# get container ID for postgres
$ docker ps
# copy database dump to the container
$ docker cp ./db/dvdrental.tar 71d465ed9c3d:/dump.tar
# run pg_restore on that dump
$ docker exec 71d465ed9c3d pg_restore -U postgres -d postgres ./dump.tar
```
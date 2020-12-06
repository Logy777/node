# 58-65 lessons

```bash
 2005  docker build . -t favorites-node
 2010  docker run --name mongodb -d mongo
 2012  docker inspect mongodb
 2013  docker build . -t favorites-node
 2014  docker run --name favorites --rm -d -p 3000:3000 favorites-node
 2020  docker container prune
 2023  docker network ls
 2024  docker network create favorites-net
 2025  docker network ls
 2026  docker run --name mongodb -d --network favorites-net mongo
 2027  docker ps
 2028  docker build . -t favorites-node
 2029  docker run --name favorites --rm -d -p 3000:3000 --network favorites-net favorites-node
```

# 58-65 lessons commands

```bash
 2021  docker run --name mongodb -d --network favorites-net mongo
 2022  docker rm mongodb
 2023  docker network ls
 2024  docker network create favorites-net
 2025  docker network ls
 2026  docker run --name mongodb -d --network favorites-net mongo
 2027  docker ps
 2028  docker build . -t favorites-node
 2029  docker run --name favorites --rm -d -p 3000:3000 --network favorites-net favorites-node
 2030  docker ps
```

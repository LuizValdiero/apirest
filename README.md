# apirest
tutorial: [API REST - SPRING BOOT](https://www.youtube.com/playlist?list=PL8iIphQOyG-D2FP9wkg12AavzmVRWEcnJ)


### PostgreSQL
> [Install](https://www.postgresql.org/download/linux/ubuntu/)

```
# Create the file repository configuration:
sudo sh -c 'echo "deb http://apt.postgresql.org/pub/repos/apt $(lsb_release -cs)-pgdg main" > /etc/apt/sources.list.d/pgdg.list'

# Import the repository signing key:
wget --quiet -O - https://www.postgresql.org/media/keys/ACCC4CF8.asc | sudo apt-key add -

# Update the package lists:
sudo apt-get update

# Install the latest version of PostgreSQL.
# If you want a specific version, use 'postgresql-12' or similar instead of 'postgresql':
sudo apt-get -y install postgresql
```
> Install pgAdmin4

```
sudo apt install pgadmin4
```

> Modify root password

```
sudo su - postgres

psql -d postgres -U postgres

alter user postgres with password 'xxxx'
```

> create user and db

```
sudo -u postgres psql

create database db_apirest;
create user user_apirest with encrypted password '123456';
grant all privileges on database bd_apirest to user_apirest;
```

### Deploy on Heroku


[Install Heroku CLI](https://devcenter.heroku.com/articles/heroku-cli)
```
sudo snap install --classic heroku
```

[Heroku Page](https://dashboard.heroku.com/apps)

> Create new APP

> Deploy using Heroku Git

```
heroku login
heroku git:remote -a first-apirest
git push heroku master
```

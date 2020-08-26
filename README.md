# spring_boot_project
tutorial: curso de spring REST para iniciantes


### PostgreSQL
Install

https://www.postgresql.org/download/linux/ubuntu/

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
Install pgAdmin4

```
sudo apt install pgadmin
```

Modify root password

```
sudo su - postgres

psql -d postgres -U postgres

alter user postgres with password 'xxxx'
```

create user and db

```
sudo -u postgres psql

create database db_apirest;
create user user_apirest with encrypted password '123456';
grant all privileges on database bd_apirest to user_apirest;
```


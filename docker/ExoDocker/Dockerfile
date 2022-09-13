FROM mysql
ENV MYSQL_ROOT_PASSWORD root
ADD dump.sql /docker-entrypoint-initdb.d
EXPOSE 3306
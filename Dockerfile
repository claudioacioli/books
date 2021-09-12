FROM tomcat:9.0-alpine

COPY target/books-1.0-SNAPSHOT /usr/local/tomcat/webapps/books

EXPOSE 8080

CMD ["catalina.sh", "run"]
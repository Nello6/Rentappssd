FROM tomcat:8.0.51-jre8-alpine
RUN rm -rf /usr/local/tomcat/webapps/*
COPY ./target/rentapp.war /usr/local/tomcat/webapps/rentapp.war
CMD ["catalina.sh","run"]
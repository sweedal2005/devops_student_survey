FROM tomcat:9.0

COPY target/student-survey.war /usr/local/tomcat/webapps/

EXPOSE 8080
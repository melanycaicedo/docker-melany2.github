
FROM tomcat


ADD index.jsp /usr/share/tomtcat/jsp


RUN rm -r /usr/local/tomcat/webapps
RUN mv /usr/local/tomcat/webapps.dist /usr/local/tomcat/webapps


RUN mkdir /usr/local/tomcat/webapps/index


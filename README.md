# test-errai4-tomcat

Test Errai 4 on Tomcat server

Prerequisites
-------------

 * JDK 8 (run `java -version` on the command line to check)
 * Maven 3 (run `mvn --version` on the command line to check) 
	
Run on Tomcat
-------------

	% git clone https://github.com/stbland/test-errai4-tomcat.git
	
	% cd test-errai4-tomcat
	
	% mvn tomcat7:run-war
	
	open http://localhost:8080/test-errai4-tomcat/ in your web brower
	

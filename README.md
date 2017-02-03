# test-errai4-tomcat

Test Errai 4 on Tomcat server

## Prerequisites

 * JDK 8 (run `java -version` on the command line to check)
 * Maven 3 (run `mvn --version` on the command line to check) 

## Fetch the code

```bash
git clone https://github.com/stbland/test-errai4-tomcat.git

cd test-errai4-tomcat
```
	
## Run WAR on Tomcat server

```bash	
mvn -Ptomcat7 package tomcat7:run-war
```

open [http://localhost:8080/test-errai4-tomcat/](http://localhost:8080/test-errai4-tomcat/) in your web brower

## Run Super Dev Mode

### Start GWT code server

In a first terminal
	
```bash	
mvn -Pgwt-codeserver gwt:run-codeserver
```

### Start Tomcat server

In a second terminal

```bash	
mvn -Pgwt-codeserver -Pgwt-no-precompile -Ptomcat7 package tomcat7:run-war
```

open [http://localhost:8080/](http://localhost:8080/) in your web brower

## Build the WAR

```bash	
mvn clean package
```
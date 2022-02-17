# aws-stuff

Contains projects that interact with aws services.

## Deploy lib on local nexus:
mvn clean deploy -P secrets

## Run application with command line:
mvn spring-boot:run

## Lib dependency:
'''
<dependency>
	<groupId>com.secrets</groupId>
	<artifactId>secrets</artifactId>
	<version>0.0.1-SNAPSHOT</version>
</dependency>
'''

## Settings.xml
'''
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 https://maven.apache.org/xsd/settings-1.0.0.xsd">
    	<servers>
	    <server>
		<id>nexus</id>
		<username>user</username>
		<password>password</password>
	    </server>
	</servers>
</settings>

'''


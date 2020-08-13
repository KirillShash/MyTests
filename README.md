# MyTests

For launch:
1. Java 11
2. Maven
3. All dependencies are written in my POM.xml :
 3.1 Rest assured (main library for nttp requests)
 3.2 Serenity (to generate a report for tests run)
 
Command for terminal: mvn clean integration-test serenity:aggregate

The report is generated in target\site\serenity\index.html

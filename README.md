# Java Playground
A multi-module Maven project for learning Java. Each module is an independent program with its own `main()` method.

## Building All Modules
```bash
mvn clean package
```

## Building a Single Module
```bash
mvn clean package -pl hello-world
mvn clean package -pl for-loop
```
etc

## Running Individual Programs
```bash
java -jar hello-world/target/hello-world-1.0.0-SNAPSHOT.jar
java -jar for-loop/target/for-loop-1.0.0-SNAPSHOT.jar
```
etc

## Cleaning Build Artifacts
```bash
mvn clean
```

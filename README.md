# Java Playground
A multi-module Maven project for learning Java.

## Building All Modules
```bash
mvn clean install
```

## Building a Single Module
```bash
mvn clean install -pl hello-world
```

## Running Individual Programs
```bash
java -jar hello-world/target/hello-world-1.0.0-SNAPSHOT.jar
```
or
```bash
mvn exec:java -pl hello-world
mvn -q exec:java -pl hello-world (quiet, just the program output)
```

## To build and run

```bash
mvn clean install -pl .\jme-hello-world\ exec:java
```
or from the module directory
```bash
mvn clean install exec:java
```

## Cleaning Build Artifacts
```bash
mvn clean
```

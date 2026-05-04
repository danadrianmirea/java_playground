# Java Playground

A multi-module Maven project for learning Java. Each module is an independent program with its own `main()` method.

```
## Building All Modules

```bash
mvn clean package
```

## Building a Single Module

```bash
mvn clean package -pl hello-world
mvn clean package -pl for-loop
mvn clean package -pl functions-test
mvn clean package -pl read-input
mvn clean package -pl spinning-cube
```

## Running Individual Programs
```bash
java -jar hello-world/target/hello-world-1.0.0-SNAPSHOT.jar
java -jar for-loop/target/for-loop-1.0.0-SNAPSHOT.jar
java -jar functions-test/target/functions-test-1.0.0-SNAPSHOT.jar
java -jar read-input/target/read-input-1.0.0-SNAPSHOT.jar
java -jar spinning-cube/target/spinning-cube-1.0.0-SNAPSHOT.jar
etc

## Cleaning Build Artifacts

```bash
mvn clean
```

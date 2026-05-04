# Java Playground

A multi-module Maven project for learning Java basics.

## Building

Build all modules:
```
mvn clean package
```

Build a specific module:
```
mvn clean package -pl hello-world
```

## Running

### Using exec-maven-plugin (recommended for interactive programs)

Run a specific module:
```
mvn exec:java -pl hello-world
mvn exec:java -pl for-loop
mvn exec:java -pl functions-test
mvn exec:java -pl read-input
```

### Using the executable JAR

Build first, then run:
```
mvn clean package
java -jar hello-world\target\hello-world-1.0.0-SNAPSHOT.jar
java -jar for-loop\target\for-loop-1.0.0-SNAPSHOT.jar
java -jar functions-test\target\functions-test-1.0.0-SNAPSHOT.jar
java -jar read-input\target\read-input-1.0.0-SNAPSHOT.jar
```

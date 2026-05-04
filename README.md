# Java Playground

A multi-module Maven project for learning Java. Each module is an independent program with its own `main()` method.

## Project Structure

```
java_playground/
├── pom.xml                  # Parent POM (multi-module reactor)
├── hello-world/             # Simple "Hello World" program
├── for-loop/                # For loop examples with array input
├── functions-test/          # Function/method examples
├── read-input/              # Reading user input from console
└── spinning-cube/           # 3D spinning cube (LibGDX graphics demo)
```

## Prerequisites

- Java 17+ (for spinning-cube) or Java 11+ (for the other modules)
- Apache Maven 3.6+

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

### Hello World
```bash
java -jar hello-world/target/hello-world-1.0.0-SNAPSHOT.jar
```

### For Loop
```bash
java -jar for-loop/target/for-loop-1.0.0-SNAPSHOT.jar
```

### Functions Test
```bash
java -jar functions-test/target/functions-test-1.0.0-SNAPSHOT.jar
```j
j
### Read Input
`j``bash
java -jar read-input/target/read-input-1.0.0-SNAPSHOT.jar
```

### Spinning Cube (3D Graphics Demo)
```bash
java -jar spinning-cube/target/spinning-cube-1.0.0-SNAPSHOT.jar
```

## Cleaning Build Artifacts

```bash
mvn clean
```

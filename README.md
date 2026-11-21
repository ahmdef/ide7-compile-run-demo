# IDE7

IDE7 is a JavaFX development environment built by an eight-person student team at ENSEEIHT. It provides a Java editor, code completion, a compile-and-run workflow, debugger tools, and a UML class diagram editor.

## Run locally

Install JDK 21 and Maven 3.9 or later. Check that `java`, `javac`, and `mvn` are available in your terminal. From the repository root:

```sh
mvn compile javafx:run
```

Run `mvn verify` to build the application. The build was verified with JDK 21 and Maven 3.9.16.

Open a folder containing a Java program, select the file with its `main` method, and use the IDE's run controls. The app calls the Java compiler, displays diagnostics if compilation fails, and shows the program's output when it runs.

## Team and contribution

This was a team project completed at ENSEEIHT. I worked with one teammate on the compilation and execution workflow. I contributed compiler diagnostic parsing, debugger panels, and breakpoint support.

## Compile-and-run walkthrough

**1. Compile a Java program with a missing semicolon.** The sample adds the squares of the integers from 1 through 5. With the semicolon removed from line 5, IDE7's compile-and-run service stops before execution. Its diagnostic parser returns:

```text
Compile exit code: 1
Line 5: ';' expected
```

**2. Add the semicolon and run again.**

```java
sum += n * n;
```

The service compiles the file, launches the program, and captures standard output:

```text
Run exit code: 0
Sum of squares (1 to 5): 55
```

I verified both cases with the IDE7 compilation, diagnostic-parsing, and execution classes using a small test program.

## Try the sample with a JDK

The [example Java file](SumOfSquares.java) is included in its corrected form. From the repository root:

```sh
javac SumOfSquares.java
java SumOfSquares
```

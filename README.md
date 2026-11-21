# IDE7 · Compile and run Java

IDE7 is a Java IDE built by an eight-person student team at ENSEEIHT. This case study shows what happens when a Java file fails to compile and how the IDE runs it once the error is fixed.

## My contribution

I worked with one teammate on compilation and execution. My contributions included parsing compiler output into diagnostics with a line number and a message, adding debugger panels, and working on breakpoint support.

## Demo · From a compiler error to output

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

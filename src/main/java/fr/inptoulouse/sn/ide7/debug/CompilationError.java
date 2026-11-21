package fr.inptoulouse.sn.ide7.debug;

public class CompilationError {
    private final String sourcePath;
    private final int line;
    private final String message;

    public CompilationError(int line, String message) {
        this(null, line, message);
    }

    public CompilationError(String sourcePath, int line, String message) {
        this.sourcePath = sourcePath;
        this.line = line;
        this.message = message;
    }

    public String getSourcePath() {
        return sourcePath;
    }

    public int getLine() {
        return line;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        if (line > 0) {
            return "Ligne " + line + " : " + message;
        }
        return message;
    }
}

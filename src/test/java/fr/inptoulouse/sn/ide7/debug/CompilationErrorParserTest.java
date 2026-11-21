package fr.inptoulouse.sn.ide7.debug;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CompilationErrorParserTest {
    @Test
    void keepsSourcePathsForFilesWithTheSameName() {
        List<CompilationError> errors = new CompilationErrorParser().parse(
            "/tmp/My Project/one/Main.java:3: error: ';' expected\n"
                + "    System.out.println(1)\n"
                + "                         ^\n"
                + "/tmp/My Project/two/Main.java:8: error: cannot find symbol\n"
                + "2 errors\n"
        );

        assertEquals(2, errors.size());
        assertEquals("/tmp/My Project/one/Main.java", errors.get(0).getSourcePath());
        assertEquals(3, errors.get(0).getLine());
        assertEquals("';' expected", errors.get(0).getMessage());
        assertEquals("/tmp/My Project/two/Main.java", errors.get(1).getSourcePath());
    }

    @Test
    void recognizesFrenchErrorsAndSkipsWarnings() {
        List<CompilationError> errors = new CompilationErrorParser().parse(
            "C:\\Workspace\\Main.java:7: erreur : symbole introuvable\r\n"
                + "C:\\Workspace\\Main.java:9: warning: unchecked conversion\r\n"
        );

        assertEquals(1, errors.size());
        assertEquals("C:\\Workspace\\Main.java", errors.get(0).getSourcePath());
        assertEquals(7, errors.get(0).getLine());
    }
}

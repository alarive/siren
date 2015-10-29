package fr.imj.siren;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by alarive on 29/10/2015.
 */
public class SirenHashMapMain {
    private static final String USAGE = "Usage: ./sirens.sh [file]\n"+
        "  if no [file] parameter is given, reads from stdin";

    public static void main(String[] args) throws IOException {
        InputStream sirens = null;
        if (args.length == 0) {
            sirens = System.in;
        } else {
            if ("-h".equals(args[0]) || "--help".equals(args[0])) {
                System.out.println(USAGE);
                System.exit(0);
            } else {
                sirens = new FileInputStream(args[0]);
            }
        }
        try {
            SirenHashMapAnalyzer.SirenAnalyzerResult result = new SirenHashMapAnalyzer().analyzeSirenList(sirens);
            System.out.printf("Uniques: %s\nRepetes: %s\n", result.getUniqueCount(), result.getDuplicatedCount());
        } finally {
            sirens.close();
        }
    }
}

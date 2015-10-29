package fr.imj.siren;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;

/**
 * User: alarive
 */
public class SirenArrayAnalizer {

    public static class SirenAnalyzerResult {
        private int uniqueCount = 0;
        private int duplicatedCount = 0;

        public int getUniqueCount() {
            return uniqueCount;
        }

        public int getDuplicatedCount() {
            return duplicatedCount;
        }

        public void incrementUniqueCount() {
            uniqueCount++;
        }
        public void incrementDuplicatedCount() {
            duplicatedCount++;
        }

        public void decrementUniqueCount() {
            uniqueCount--;
        }
    }

    private static final int SIREN_MAX = 1000000000;

    /**
     * The semantic of this array is:
     *      if value == 1, then this siren is unique.
     *      if value == 2, then this siren is a duplicate.
     *      if value == 0? then this siren was not in the input.
     */
    private byte[] sirensUniqueStatuses = new byte[SIREN_MAX];

    /**
     * Analyze the 'sirensUniqueStatuses' input stream and reports the number of unique/duplicated SIREN numbers.
     *
     * @param sirensStream A \n-separated stream of siren numbers
     * @return
     */
    public SirenAnalyzerResult analyzeSirenList(InputStream sirensStream) {
        Scanner scanner = new Scanner(sirensStream);
        SirenAnalyzerResult sirenAnalyzerResult = new SirenAnalyzerResult();
        while (scanner.hasNext()) {
            int currentSiren = scanner.nextInt();
            if (currentSiren < 0 || currentSiren > SIREN_MAX - 1) {
                System.err.println("Invalid SIREN input:" + currentSiren);
                continue;
            }
            byte existing = sirensUniqueStatuses[currentSiren];
            if (existing == 0) {
                sirensUniqueStatuses[currentSiren] = 1;
                sirenAnalyzerResult.incrementUniqueCount();
                continue;
            }
            if (existing == 1) {
                sirenAnalyzerResult.incrementDuplicatedCount();
                sirenAnalyzerResult.decrementUniqueCount();
                sirensUniqueStatuses[currentSiren] = 2;
            }
        }
        return sirenAnalyzerResult;
    }
}
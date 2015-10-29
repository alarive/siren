package fr.imj.siren;

import java.io.InputStream;
import java.util.Scanner;

/**
 * User: alarive
 */
public class SirenSortedAnalyzer {

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
    }

    /**
     * Analyze the 'sirens' input stream and reports the number of unique/duplicated SIREN numbers.
     *
     * WARNING: this version assumes the input is already sorted.
     *
     * @param sirens A \n-separated stream of siren numbers
     * @return
     */
    public static SirenAnalyzerResult analyzeSirenList(InputStream sirens) {
        Scanner scanner = new Scanner(sirens);
        SirenAnalyzerResult sirenAnalyzerResult = new SirenAnalyzerResult();
        int previousSiren = -1;
        boolean alreadyCounted = false;
        while (scanner.hasNext()) {
            int currentSiren = scanner.nextInt();
            if (previousSiren != -1 && currentSiren != previousSiren) {
                if (!alreadyCounted) {
                    sirenAnalyzerResult.incrementUniqueCount();
                }
                alreadyCounted = false;
            }
            else if (currentSiren == previousSiren && !alreadyCounted ) {
                sirenAnalyzerResult.incrementDuplicatedCount();
                alreadyCounted = true;
            }
            previousSiren = currentSiren;
        }
        return sirenAnalyzerResult;
    }
}
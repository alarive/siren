package fr.imj.siren;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;

/**
 * User: alarive
 */
public class SirenHashMapAnalyzer {

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

    /**
     * The semantic of this map is:
     *      if value == true, then this siren is unique.
     *      if value == false, then this siren is a duplicate
     */
    private HashMap<String, Boolean> sirensUniqueStatuses = new HashMap<String, Boolean>();

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
            String currentSiren = scanner.next();
            Boolean existing = sirensUniqueStatuses.get(currentSiren);
            if (existing == null) {
                sirensUniqueStatuses.put(currentSiren, true);
                sirenAnalyzerResult.incrementUniqueCount();
                continue;
            }
            if (existing) {
                sirenAnalyzerResult.incrementDuplicatedCount();
                sirenAnalyzerResult.decrementUniqueCount();
                sirensUniqueStatuses.put(currentSiren, false);
            }
        }
        return sirenAnalyzerResult;
    }
}
package contest;

import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Contest5750 {
    static class Entry {
        public int year;
        public int isBirth;

        public Entry(int year, int isBirth) {
            this.year = year;
            this.isBirth = isBirth;
        }
    }
    public int maximumPopulation(int[][] logs) {
        List<Entry> entryList = new ArrayList<>();
        for (int[] log : logs) {
            entryList.add(new Entry(log[0], 0));
            entryList.add(new Entry(log[1], 1));
        }
        Collections.sort(entryList, (a, b) -> {
            if (a.year == b.year) {
                return b.isBirth - a.isBirth;
            }
            return a.year - b.year;
        });
        int count = 0, maxCount = 0, maxYear = 0;
        for (Entry e : entryList) {
            if (e.isBirth == 0) {
                count++;
                if (count > maxCount) {
                    maxCount = count;
                    maxYear = e.year;
                }
            } else {
                count--;
            }
        }

        return maxYear;
    }

    public static void main(String[] args) {
        Contest5750 instance = new Contest5750();
        int[][] logs = {{2008,2026},{2004,2008},{2034,2035},{1999,2050},{2049,2050},{2011,2035},{1966,2033},{2044,2049}};
        instance.maximumPopulation(logs);
    }

}

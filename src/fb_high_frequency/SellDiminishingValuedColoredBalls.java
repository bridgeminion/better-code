package fb_high_frequency;

import java.util.*;
import java.util.stream.Collectors;

public class SellDiminishingValuedColoredBalls {
    class Entry {
        int i;
        int value;
        public Entry (int i, int value) {
            this.i = i;
            this.value = value;
        }
    }

    public int maxProfitTimeout(int[] inventory, int orders) {
        TreeSet<Entry> set = new TreeSet<>((e1, e2) ->
            e1.value == e2.value ? e1.i - e2.i : e1.value - e2.value
        );
        for (int i=0; i<inventory.length; i++) {
            set.add(new Entry(i, inventory[i]));
        }
        int sum = 0, count = 0;
        while (count < orders) {
            Entry entry = set.last();
            sum += entry.value;
            if (entry.value > 1) {
                set.remove(entry);
                set.add(new Entry(entry.i, entry.value - 1));
            }
            count++;
        }

        return sum;
    }

    public int maxProfit(int[] inventory, int orders) {
        Arrays.sort(inventory);
        int sum = 0, count = 0, repeat = 1;
        for (int i = inventory.length - 1; i >= 0; i--) {
            for (int j = inventory[i]; j > (i == 0 ? 0 : inventory[i - 1]); j--) {
                for (int k = 0; k < repeat; k++) {
                    sum += j;
                    count++;
                    System.out.println("adding " + j + ", count=" + count);
                    if (count >= orders) {
                        return sum;
                    }
                }
            }
            repeat++;
        }

        return sum;
    }

    public static void main(String[] args) {
        SellDiminishingValuedColoredBalls app = new SellDiminishingValuedColoredBalls();
        int[] inventory = {2,8,4,10,6};
        System.out.println(app.maxProfit(inventory, 20));
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> a = map.values().stream().collect(Collectors.toList());
    }
}

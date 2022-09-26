package high_frequency.calculation;

import java.util.ArrayList;
import java.util.List;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        List<Integer> starts = new ArrayList<>();
        for (int i=0; i<gas.length; i++) {
            if (gas[i] >= cost[i]) {
                starts.add(i);
            }
        }
        for (int start : starts) {
            if (canFinish(gas, cost, start)) {
                return start;
            }
        }

        return -1;
    }

    private boolean canFinish(int[] gas, int[] cost, int start) {
        int count = 0, gasLeft = 0;
        while (count < gas.length) {
            gasLeft += gas[start] - cost[start];
            if (gasLeft < 0) {
                return false;
            }
            start = (start + 1)%cost.length;
            count++;
        }

        return true;
    }

    public static void main(String[] args) {
        GasStation instance = new GasStation();
        int[] gas = {2,3,4};
        int[] cost = {3,4,3};
        System.out.println(instance.canCompleteCircuit(gas, cost));
    }

}

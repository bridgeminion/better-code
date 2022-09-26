package fb_high_frequency;

import java.util.*;

/**
 * ["0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"]
 */
public class ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        Deque<String> stack = new LinkedList<>();
        int[] result = new int[n];
        for (String log : logs) {
            if (log.contains("start")) {
                stack.push(log);
            } else {
                int jobId = Integer.valueOf(log.split(":")[0]);
                int ended =  Integer.valueOf(log.split(":")[2]);
                String startLog = stack.pop();
                int started =  Integer.valueOf(startLog.split(":")[2]);

                result[jobId] += ended - started + 1;
                if (!stack.isEmpty()) {
                    int peekJobId = Integer.valueOf(stack.peek().split(":")[0]);
                    result[peekJobId] -= ended - started + 1;
                }
            }
        }

        return result;
    }


    public static void main(String[] args) {
        ExclusiveTimeOfFunctions app = new ExclusiveTimeOfFunctions();
        List<String> logs = Arrays.asList("0:start:0","1:start:5","2:start:6","3:start:9","4:start:11","5:start:12","6:start:14","7:start:15","1:start:24","1:end:29","7:end:34","6:end:37","5:end:39","4:end:40","3:end:45","0:start:49","0:end:54","5:start:55","5:end:59","4:start:63","4:end:66","2:start:69","2:end:70","2:start:74","6:start:78","0:start:79","0:end:80","6:end:85","1:start:89","1:end:93","2:end:96","2:end:100","1:end:102","2:start:105","2:end:109","0:end:114");
        System.out.println(app.exclusiveTime(8, logs));
    }



}

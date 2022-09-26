package fb_high_frequency;

import java.util.*;

public class SimplifyPath {
    public String simplifyPath1(String path) {
        String[] folders = path.split("/");
        Set<String> skip = new HashSet<>(Arrays.asList("", ".", ".."));
        Deque<String> stack = new LinkedList<>();
        for (String folder : folders) {
            if ("..".equals(folder) && !stack.isEmpty()) {
                stack.pop();
            } else if (!skip.contains(folder)) {
                stack.push(folder);
            }
        }
        StringBuilder sb = new StringBuilder("/");
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast()).append("/");
        }

        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public String simplifyPath(String path) {
        String[] dirs = path.split("/");
        Deque<String> res = new LinkedList<>();
        for (String dir : dirs) {
            if ("..".equals(dir)) {
                if (res.size() > 0) {
                    res.pollLast();
                }
            } else if (!".".equals(dir) && !"".equals(dir)) {
                res.offer(dir);
            }
        }

        return res.isEmpty() ? "/" : "/" + String.join("/", res);
    }


    public static void main(String[] args) {
        SimplifyPath app = new SimplifyPath();
        System.out.println(app.simplifyPath("/a//b////c/d//././/.."));
    }

}

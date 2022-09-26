package doordash;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class KSimilarStrings {
    public int kSimilarity(String s1, String s2) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(s1);
        visited.add(s1);
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                String s = queue.poll();
                if (s.equals(s2)) {
                    return steps;
                }
                int j=0;
                while (j < s.length() && s.charAt(j) == s2.charAt(j)) {
                    j++;
                }
                for (int k=j+1; k<s.length(); k++) {
                    if (s.charAt(k) != s2.charAt(k) && s.charAt(k) == s2.charAt(j) ) {
                        String temp = swap(s, j, k);
                        if (visited.add(temp)) {
                            queue.offer(temp);
                        }
                    }
                }
            }
            steps++;
        }

        return steps;
    }

    private String swap (String s, int i, int j) {
        char[] arr = s.toCharArray();
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;

        return String.valueOf(arr);
    }

//    public int kSimilarity(String A, String B) {
//        if (A.equals(B)) return 0;
//        Set<String> vis= new HashSet<>();
//        Queue<String> q= new LinkedList<>();
//        q.add(A);
//        vis.add(A);
//        int res=0;
//        while(!q.isEmpty()){
//            res++;
//            for (int sz=q.size(); sz>0; sz--){
//                String s= q.poll();
//                int i=0;
//                while (s.charAt(i)==B.charAt(i)) i++;
//                for (int j=i+1; j<s.length(); j++){
//                    if (s.charAt(j)==B.charAt(j) || s.charAt(j)!=B.charAt(i) ) continue;
//                    String temp= swap(s, i, j);
//                    if (temp.equals(B)) return res;
//                    if (vis.add(temp)) {
//                        q.add(temp);
//                        System.out.println("after swap: " + temp);
//                    }
//                }
//            }
//        }
//        return res;
//    }
//    public String swap(String s, int i, int j){
//        char[] ca=s.toCharArray();
//        char temp=ca[i];
//        ca[i]=ca[j];
//        ca[j]=temp;
//        return new String(ca);
//    }
    public static void main(String[] args) {
        KSimilarStrings app = new KSimilarStrings();
        System.out.println(app.kSimilarity(
                "bccaba",
                "abacbc"));
    }
}

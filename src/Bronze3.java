import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bronze3 {

    static class Cow {
        int x;
        int y;
        int index;
        public Cow(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
        }
    }

    static int[] ans = new int[51];
    static boolean[] done = new boolean[51];

    public static void gen (Cow cow, List<Cow> north){
        for (Cow i : north){
            if (cow.x < i.x && i.y < cow.y && !done[i.index]){
                int distr = i.x - cow.x;
                int distu = cow.y - i.y;
                if (distr > distu){
                    ans[cow.index] = distr;
                    return;
                }
                if (distr < distu){
                    ans[i.index] = distu;
                    done[i.index] = true;
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Cow> north = new ArrayList<>();
        List<Cow> east = new ArrayList<>();
        for (int i=0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (c == 'N'){
                north.add(new Cow (x, y, i+1));
            }
            else {
                east.add(new Cow (x, y, i+1));
            }
        }
        for (int i=1; i <= n; i++){
            ans[i] = -1;
        }
        Collections.sort(north, new Comparator<Cow>() {
            @Override
            public int compare(Cow o1, Cow o2) {
                return o1.x - o2.x;
            }
        });
        Collections.sort(east, new Comparator<Cow>() {
            @Override
            public int compare(Cow o1, Cow o2) {
                return o1.y - o2.y;
            }
        });
        for (Cow i : east){
            gen (i, north);
        }
        for (int i=1; i <= n; i++){
            if (ans[i] == -1){
                System.out.println("Infinity");
            }
            else {
                System.out.println(ans[i]);
            }
        }
    }
}

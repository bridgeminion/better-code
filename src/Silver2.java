import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Silver2 {

    static class Pt {
        int x;
        int y;
        int id;
        public Pt(int x, int y, int id) {
            this.x = x;
            this.y = y;
            this.id = id;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Pt> list = new ArrayList<>();
        for (int i=0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Pt (x, y, 0));
        }
        Collections.sort(list, new Comparator<Pt>() {
            @Override
            public int compare(Pt o1, Pt o2) {
                return o1.x - o2.x;
            }
        });
        for (int i=0; i < n; i++){
            list.get(i).id = i;
        }
        Collections.sort(list, new Comparator<Pt>() {
            @Override
            public int compare(Pt o1, Pt o2) {
                return o1.y - o2.y;
            }
        });
        long ans = ((long)n*(n+1)/2) + 1;
        for (int i=0; i < n; i++){
            TreeSet<Integer> tset = new TreeSet<>();
            for (int j=i; j >= 0; j--){
                tset.add(list.get(j).id);
                if (tset.last()-tset.first()+1 != tset.size()){
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Silver1 {

    static class L{
        List<Integer> list = new ArrayList<>();
        public L () {}
    }

    public static int gen (int cur, boolean[] visited, L[] adj){
        visited[cur] = true;
        int res = 0;
        int num = 0;
        for (int i : adj[cur].list) {
            if (!visited[i]) {
                num++;
                res++;
                res += gen(i, visited, adj);
            }
        }
        int del = 1;
        while (del < num+1){
            del = del*2;
            res++;
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        L[] adj = new L[n+1];
        for (int i=1; i <= n; i++){
            adj[i] = new L ();
        }
        for (int i=0; i < n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].list.add(b);
            adj[b].list.add(a);
        }
        System.out.println(gen (1, new boolean[n+1], adj));
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Bronze2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int ans = 0;
        for (int i=0; i < n; i++){
            for (int j=i; j < n; j++){
                int sum = 0;
                Set<Integer> seen = new HashSet<>();
                for (int k=i; k <= j; k++){
                    seen.add(arr[k]);
                    sum += arr[k];
                }
                int size = j-i+1;
                if (sum%size == 0 && seen.contains(sum/size)){
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}

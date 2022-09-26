import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Dec2020 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 7;
        List<Long> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i < n; i++){
            list.add(Long.parseLong(st.nextToken()));
        }
        Collections.sort(list);
        long sum = 0;
        for (int i=0; i < 3; i++){
            sum += list.get(i);
        }
        if (sum == list.get(6)){
            System.out.println(list.get(0) + " " + list.get(1) + " " + list.get(2));
        }
        else {
            System.out.println(list.get(0) + " " + list.get(1) + " " + list.get(3));
        }
    }
}

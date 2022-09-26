package google_high_frequency;

public class OutputContestMatches {
    public String findContestMatch(int n) {
        String[] result = new String[n];
        for (int i=0; i<n; i++) {
            result[i] = String.valueOf(i+1);
        }
        while (n > 1) {
            for (int j=0; j<n/2; j++) {
                result[j] = "(" + result[j] + "," + result[n-j-1] + ")";
            }
            n /= 2;
        }
        return result[0];
    }

    public static void main(String[] args) {
        OutputContestMatches app = new OutputContestMatches();
        System.out.println(app.findContestMatch(8));
    }

}

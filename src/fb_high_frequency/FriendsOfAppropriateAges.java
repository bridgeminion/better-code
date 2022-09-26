package fb_high_frequency;

public class FriendsOfAppropriateAges {
    public int numFriendRequests(int[] ages) {
        int[] ageCount = new int[121];
        for (int age : ages) {
            ageCount[age]++;
        }
        int result = 0;
        for (int i=1; i<=120; i++) {
            for (int j=1; j<=120; j++) {
                if (ageCount[i] != 0 && ageCount[j] != 0) {
                    if (!notValid(i, j)) {
                        result += ageCount[i] * (i == j ? ageCount[i]-1 : ageCount[j]);
                    }
                }
            }
        }

        return result;
    }

    /**
     * age[y] <= 0.5 * age[x] + 7
     * age[y] > age[x]
     * age[y] > 100 && age[x] < 100
     */
    private boolean notValid(int i, int j) {
        return j <= 0.5 * i + 7 || j > i;
    }

    public static void main(String[] args) {
        FriendsOfAppropriateAges app = new FriendsOfAppropriateAges();
        int[] ages = {16,17,18};
        System.out.println(app.numFriendRequests(ages));
    }

}

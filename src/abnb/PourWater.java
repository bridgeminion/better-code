package abnb;

public class PourWater {
    public int[] pourWater(int[] heights, int V, int K) {
        for(int i = 0; i < V; i++) {
            int cur = K;
            // Move left
            while(cur > 0 && heights[cur] >= heights[cur - 1]) {
                cur--;
            }
            // Move right
            while(cur < heights.length - 1 && heights[cur] >= heights[cur + 1]) {
                cur++;
            }
            // Move left to K
            while(cur > K && heights[cur] >= heights[cur - 1]) {
                cur--;
            }
            heights[cur]++;
        }

        return heights;
    }

    public static void main(String[] args) {
        PourWater app = new PourWater();
        int[] heights = {2,1,1,2,1,2,2};
        System.out.println(app.pourWater(heights, 4, 3));
    }
}

package google_high_frequency;

import java.util.HashMap;
import java.util.Map;

/**
 * secret = "1807", guess = "7810"
 */
public class BullsAndCows {
    public String getHintTwoMap(String secret, String guess) {
        Map<Character, Integer> secretMap = new HashMap<>();
        Map<Character, Integer> guessMap = new HashMap<>();
        int bulls = 0, cows = 0;
        for (int i=0; i<secret.length(); i++) {
            char c1 = secret.charAt(i);
            char c2 = guess.charAt(i);
            if (c1 == c2) {
                bulls++;
            } else {
                if (guessMap.containsKey(c1)) {
                    cows++;
                    guessMap.put(c1, guessMap.get(c1) - 1);
                    if (guessMap.get(c1) == 0) {
                        guessMap.remove(c1);
                    }
                } else {
                    secretMap.put(c1, secretMap.getOrDefault(c1, 0) + 1);
                }

                if (secretMap.containsKey(c2)) {
                    cows++;
                    secretMap.put(c2, secretMap.get(c2) - 1);
                    if (secretMap.get(c2) == 0) {
                        secretMap.remove(c2);
                    }
                } else {
                    guessMap.put(c2, guessMap.getOrDefault(c2, 0) + 1);
                }

            }
        }

        return String.format("%dA%dB", bulls, cows);
    }

    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] numbers = new int[10];
        for (int i = 0; i<secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) bulls++;
            else {
                if (numbers[secret.charAt(i)-'0']++ < 0) cows++;
                if (numbers[guess.charAt(i)-'0']-- > 0) cows++;
            }
        }
        return bulls + "A" + cows + "B";
    }

    public static void main(String[] args) {
        BullsAndCows app = new BullsAndCows();
        System.out.println(app.getHint("1807", "7810"));
    }

}

import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public boolean isNStraightHand(int[] deck, int W) {
        Map<Integer, Integer> counts = new TreeMap<>();
        for (int card : deck) {
            counts.put(card, counts.getOrDefault(card, 0) + 1);
        }
        
      for (int card : counts.keySet()) {
    if (counts.get(card) > 0) {
        int count = counts.get(card);
        counts.put(card , 0);
        
        for (int i = 1; i < W; i++) {
            if (counts.getOrDefault(card + i, 0) < count) {
                return false;
            }
            counts.put(card + i, counts.get(card + i) - count);
        }
    }
}

        return true;
    }
}

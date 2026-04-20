package selfpracticeproblems.arrays.slidingwindow.variablewindowsize;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBasket {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int maxLength = 0;

        for (int j = 0; j < fruits.length; j++) {
            map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);

            while (map.size() > 2) {
                map.put(fruits[i], map.get(fruits[i]) - 1);

                if (map.get(fruits[i]) == 0) {
                    map.remove(fruits[i]);
                }
                i++;
            }
            maxLength = Math.max(maxLength, j - i + 1);
        }
        return maxLength;
    }
}

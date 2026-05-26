package maang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static void main(String[] args) {

        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };

        List<List<String>> result = groupAnagrams(strs);

        System.out.println(result);
    }

    private static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> hm = new HashMap<>();

        for (String obj : strs) {

            char[] charArr = obj.toCharArray();
            Arrays.sort(charArr);

            String key = new String(charArr);

            // Create new list if key does not exist
            if (!hm.containsKey(key)) {
                hm.put(key, new ArrayList<>());
            }

            // Add word to existing list
            hm.get(key).add(obj);
        }

        // Convert map values to list
        return new ArrayList<>(hm.values());
    }
}
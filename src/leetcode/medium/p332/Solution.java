package src.leetcode.medium.p332;

import java.util.*;

class Solution {
    Map<String, Map<String, Integer>> map = new HashMap<>();
    List<String> res = new ArrayList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        int len = tickets.size();
        for (int i = 0; i < len; i++) {
            List<String> travel = tickets.get(i);
            String from = travel.get(0);
            String to = travel.get(1);
            Map<String, Integer> order;
            if (map.containsKey(from)) {
                order = map.get(from);
                order.put(to, order.getOrDefault(to, 0) + 1);
            } else {
                order = new TreeMap<>();
                order.put(to, 1);
            }
            map.put(from, order);
        }
        res.add("JFK");
        backTrack("JFK", len + 1);
        return res;
    }

    private boolean backTrack(String from, int travelLen) {
        if (res.size() == travelLen) {
            return true;
        }

        if (map.containsKey(from)) {
            for (Map.Entry<String, Integer> entry : map.get(from).entrySet()) {
                String to = entry.getKey();
                int count = entry.getValue();
                if (count > 0) {
                    res.add(to);
                    entry.setValue(count - 1);
                    if (backTrack(to, travelLen)) return true;
                    entry.setValue(count);
                    res.remove(res.size() - 1);
                }
            }
        }
        return false;
    }
}

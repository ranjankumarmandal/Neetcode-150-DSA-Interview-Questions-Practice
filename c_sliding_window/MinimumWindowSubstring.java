package org.example.c_sliding_window;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> tCount = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();
        int have = 0;
        int need = tCount.size();

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;

        for(int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            window.put(ch, window.getOrDefault(ch, 0) + 1);

            if(tCount.containsKey(ch) && window.get(ch).intValue() == tCount.get(ch).intValue()) {
                have++;
            }

            while(have == need) {
                if(right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minStart = left;
                }

                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);

                if(tCount.containsKey(leftChar) && window.get(leftChar).intValue() < tCount.get(leftChar).intValue()) {
                    have--;
                }

                left++;
            }
        }

        if(minLen == Integer.MAX_VALUE) return "";

        return s.substring(minStart, minStart + minLen);
    }
}

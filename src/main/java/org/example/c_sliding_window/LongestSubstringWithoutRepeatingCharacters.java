package org.example.c_sliding_window;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> seen = new HashSet<>();

        int left = 0, maxLen = 0;

        for(int right = 0; right < s.length(); right++) {
            char c  = s.charAt(right);

            while(seen.contains(c)) {
                seen.remove(s.charAt(left));
                left++;
            }

            seen.add(c);

            int currLen = right - left + 1;
            if(currLen > maxLen) maxLen = currLen;
        }

        return maxLen;
    }
}

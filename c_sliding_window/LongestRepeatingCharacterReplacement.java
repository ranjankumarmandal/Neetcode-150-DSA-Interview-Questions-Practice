package org.example.c_sliding_window;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0;
        int maxCount = 0;
        int maxLen = 0;

        for(int right = 0; right < s.length(); right++) {
            int idx = s.charAt(right) - 'A';
            count[idx]++;

            if(count[idx] > maxCount) maxCount = count[idx];

            while((right - left + 1) - maxCount > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            int windowLen = right - left + 1;
            if(windowLen > maxLen) maxLen = windowLen;
        }

        return maxLen;
    }
}

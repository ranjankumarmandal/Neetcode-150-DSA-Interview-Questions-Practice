package org.example.a_array_and_hashing;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        for(int num : nums) {
            numSet.add(num);
        }

        int maxLen = 0;

        for(int num : nums) {
            if(!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentLen = 1;

                while(numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentLen += 1;
                }

                if(currentLen > maxLen) maxLen = currentLen;
            }
        }

        return maxLen;
    }
}

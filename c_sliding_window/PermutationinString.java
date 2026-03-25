package org.example.c_sliding_window;

public class PermutationinString {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int[] s1Count = new int[26];
        int[] windowCount = new int[26];

        for(int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            windowCount[s2.charAt(i) - 'a']++;
        }

        for(int i = 0; i <= s2.length() - s1.length(); i++) {
            if(matches(s1Count, windowCount)) return true;

            if(i + s1.length() < s2.length()) {
                windowCount[s2.charAt(i) - 'a']--;
                windowCount[s2.charAt(i + s1.length()) - 'a']++;
            }
        }

        return false;
    }

    private boolean matches(int[] a, int[] b) {
        for(int i = 0; i < 26; i++) {
            if(a[i] != b[i]) return false;
        }

        return true;
    }
}

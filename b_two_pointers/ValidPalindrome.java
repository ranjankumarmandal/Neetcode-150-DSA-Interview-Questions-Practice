package org.example.b_two_pointers;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while(left < right) {
            while(left < right && !Character.isLetterOrDigit(left)) {
                left++;
            }

            while(left < right && !Character.isLetterOrDigit(right)) {
                right--;
            }

            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}

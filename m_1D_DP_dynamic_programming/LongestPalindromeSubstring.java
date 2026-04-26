public class LongestPalindromeSubstring {
    public String longestPalindrome(String s) {
        int start = 0, end = 0;


        return s.substring(start, end + 1);
    }

    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
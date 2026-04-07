public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(s, 0, current, result);

        return result;
    }

    public void backtrack(String s, int start, List<String> current, List<List<Integer>> result) {
        if(start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for(int end = start; end < s.length(); end++) {
            if(isPalindrome(s, start, end)) {
                current.add(s.substring(start, end + 1));
                backtract(s, end + 1, current, result);
                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int righ) {
        while(ledt < right) {
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }
}
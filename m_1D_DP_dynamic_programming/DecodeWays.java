public class DecodeWays {
    public int numDecodings(String s) {
        int n = s.length();
        int next1 = 1, next2 = 0;

        for (int i = n - 1; i >= 0; i--) {
            int curr = 0;

            if (s.charAt(i) != '0') {
                curr = next1;

                if (i < n - 1 && (s.charAt(i) == '1' ||
                        (s.charAt(i) == '2' && s.charAt(i + 1) <= '6'))) {
                    curr += next2;
                }
            }
        }

        return next1;
    }
}
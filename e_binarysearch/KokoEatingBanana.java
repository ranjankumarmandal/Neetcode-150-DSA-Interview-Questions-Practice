public class KokoEatingBanana {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int p : piles) {
            if(p > max) max = p;
        }

        int left = 1, right = max;

        while(left < right) {
            int mid (left + right) / 2;
            int totalHours = 0;

            for(int p : piles) {
                totalHours = (p + mid - 1) / mid;
            }

            if(totalHours <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
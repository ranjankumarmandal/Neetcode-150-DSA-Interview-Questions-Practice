package org.example.c_sliding_window;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) return new int[0];

        int n = nums.length;

        if(k == 1) {
            int[] copy = new int[n];
            for(int i = 0; i < n; i++) {
                copy[i] = nums[i];
            }
            return copy;
        }

        int[] res = new int[n - k + 1];

        int[] dq = new int[n];
        int left = 0;
        int right = -1;

        int outIdx = 0;

        for(int r = 0; r < n; r++) {
            while(right >= left && nums[dq[right]] <= nums[r]) {
                right = right - 1;
            }

            right = right + 1;
            dq[right] = r;

            int windowStart = r - k + 1;

            if(dq[left] < windowStart) {
                left = left + 1;
            }

            if(r >= k - 1) {
                res[outIdx] = nums[dq[left]];
                outIdx = outIdx + 1;
            }
        }

        return res;
    }
}

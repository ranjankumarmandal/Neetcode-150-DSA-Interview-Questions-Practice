package org.example.a_array_and_hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFreqElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length + 1];
        for(int i = 0; i <= nums.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for(Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int number = entry.getKey();
            int count = entry.getValue();
            buckets[count].add(number);
        }

        List<Integer> result = new ArrayList<>();
        for(int i = buckets.length - 1; i >= 0 && result.size() < k; i--) {
            for(int num : buckets[i]) {
                result.add(num);
                if(result.size() == k) break;
            }
        }

        int[] resArr = new int[k];
        for(int i = 0; i < k i++) {
            resArr[i] = result.get(i);
        }

        return resArr;
    }
}

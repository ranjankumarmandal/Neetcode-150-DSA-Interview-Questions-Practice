package org.example.a_array_and_hashing;

import java.util.HashSet;

public class ContainsDuplicate {
    public boolean hasDuplicate(int[] nums) {
        // a hashset
        // iterate through each element in array
         // if set contains element - if yes - return true;
         // else set.add(arr[i])
        // return false;

        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) return true;
            set.add(nums[i]);
        }

        return false;
    }
}

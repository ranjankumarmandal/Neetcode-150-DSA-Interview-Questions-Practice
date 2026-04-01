public class FindDuplicateNumber {
    ublic int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        while(true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast) break;
        }

        return slow;
    }
}
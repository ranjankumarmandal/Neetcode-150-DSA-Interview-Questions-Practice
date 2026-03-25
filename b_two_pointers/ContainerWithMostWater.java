package org.example.b_two_pointers;

public class ContainerWithMostWater {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int left = 0, right = heights.length - 1;

        while(left < right) {
            int currentHeight = Math.min(heights[left], heights[right]);
            int width = right - left;

            int area = currentHeight * width;

            if(area > maxArea) maxArea = area;

            if(heights[left] < heights[right]) left++;
            else right--;
        }

        return maxArea;
    }
}

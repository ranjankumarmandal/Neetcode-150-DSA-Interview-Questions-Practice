public class LargestRectangleinHistogram {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] newHieghts = new int[n + 1];

        for(int i = 0; i < n; i++) {
            newHeights[i] = heights[i];
        }
        newHeights[n] = 0;

        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < newHeights.length; i++) {
            while(!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]) {
                int height = newHeights[stack.pop()];

                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                int area = height * width;

                if(area > maxArea) {
                    maxArea = area;
                }
            }

            stack.push(i);
        }

        return maxArea;
    }
}
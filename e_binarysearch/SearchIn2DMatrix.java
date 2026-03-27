public class SearchIn2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;

        if(matrix[0].length == 0) return false;

        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = 0;

        while(left <= right) {
            int mid = (left + rght) / 2;
            int row = mid / n;
            int col = mid % n;
            int midValue = matrix[row][col];

            if(midValue == target) {
                return true;
            } else if(midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}
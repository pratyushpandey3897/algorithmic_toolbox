class MatrixBinarySearch {
    public boolean searchMatrix(int[][] matrix, int target) {

        int lenOfRows = matrix.length;
        int lenOfColumns = matrix[0].length;

        int low = 0, high = lenOfRows;

        while (high-low>1){
            int mid = (high + low) / 2;

            if (target >= matrix[mid][0] && target <= matrix[mid][(lenOfColumns-1)]){
                // we found the row where target could be
                return BinarySearchRow(matrix, target, mid);
            } else if (target > matrix[mid][lenOfColumns-1]){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;

    }

    public static boolean BinarySearchRow(int[][] matrix, int target, int row){

        int low = 0, high = matrix[0].length;

        while (high - low > 1){
            int mid = (high + low) / 2;
            if (target == matrix[row][mid])
                return true;
            else if (target > matrix[row][mid])
                low = mid + 1;
            else if (target < matrix[row][mid])
                high = mid - 1;
        }

        return false;
    }
    public static void main (String[] args){
        MatrixBinarySearch obj = new MatrixBinarySearch();
        int [][] m = {{1,3,5,7}, {10,11,16,20}, {23,30,34,60}};
        Boolean b =obj.searchMatrix(m ,3);
        System.out.println(b);
    }
}
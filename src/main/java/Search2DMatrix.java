//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

class Search2DMatrix {
    Search2DMatrix() {
    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        int lenOfRows = matrix.length;
        int lenOfColumns = matrix[0].length;

        int low = 0, high = lenOfRows;

        while (high-low>0){
            int mid = (high + low) / 2;

            if (target >= matrix[mid][0] && target <= matrix[mid][(lenOfColumns-1)]){
                // we found the row where target could be
                return BinarySearchRow(matrix, target, mid);
            } else if (target > matrix[mid][lenOfColumns-1]){
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return false;

    }

    public static boolean BinarySearchRow(int[][] matrix, int target, int row){

        int low = 0, high = matrix[0].length;

        while (high - low > 0){
            int mid = (high + low) / 2;
            if (target == matrix[row][mid])
                return true;
            else if (target > matrix[row][mid])
                low = mid + 1;
            else if (target < matrix[row][mid])
                high = mid;
        }

        return false;
    }

    public static void main(String[] var1) {
        Boolean var2 = searchMatrix(new int[][]{{1}}, 1);
        System.out.println(var2);
    }
}

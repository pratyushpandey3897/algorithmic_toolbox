import java.util.ArrayList;
import java.util.List;

class MatrixReshape {
    public static int[][] matrixReshape(int[][] mat, int r, int c) {

        int[][] reshapedMat = new int[r][c];

        List<Integer> l = new ArrayList<Integer>();
        for (int row =0;row<mat.length; row++)
        {
            for (int col =0; col<mat[row].length; col++){
                l.add(mat[row][col]);
            }
        }

        int listCtr = 0;
        for (int row =0;row<r; row++)
        {
            for (int col =0; col< c; col++){
                reshapedMat[row][col] = l.get(listCtr);
                listCtr++;
            }
        }
        return reshapedMat;

    }

    public static void main(String[] args) {

        int[][] matrixInput = {{1,2}, {3,4}};
        System.out.println(matrixReshape(matrixInput, 1, 4));

    }
}
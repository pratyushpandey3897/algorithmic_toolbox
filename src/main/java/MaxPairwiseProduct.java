import java.util.Scanner;

public class MaxPairwiseProduct {

    public static void main (String[] args) {
        MaxPairwiseProduct obj = new MaxPairwiseProduct();
        Scanner sc = new Scanner((System.in));
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(obj.findMaxProduct(n,arr));

    }

    public int findMaxProduct(int n, int[] eleList) {

        int max = 0;
        for (int i = 0; i < n; i++){
            for (int j = i+1; j<n; j++){
                int prod = eleList[i]*eleList[j];
                if (prod > max)
                    max= prod;
            }
        }
        return max;
    }
}

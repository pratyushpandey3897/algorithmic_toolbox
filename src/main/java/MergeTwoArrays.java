import java.util.Arrays;

class MergeTwoArrays {
    public static void main(String[] args) {

        int[] nums1 = {1,2,3,0,0,0};

        int[] nums2 = {2,5,6};
        int m =3, n=3;
        int[] arr3 = Arrays.stream(nums1).toArray();
        int i = 0, j=0, k=0;

        while (i<m && j<n){
            if (arr3[i] <= nums2[j]){
                nums1[k++] = arr3[i++];
            } else {
                nums1[k++] = nums2[j++];
            }

        }

        while (k < m+n && i < m){
            nums1[k++] = arr3[i++];
        }

        while (j < n){
            nums1[k++] = nums2[j++];
        }

        i =0;
        while (i<m+n) {
            System.out.println(nums1[i++]);
        }

    }
}
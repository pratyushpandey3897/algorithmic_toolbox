class MaxSubarraySum {
    public static void main(String[] args) {

        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int n = nums.length;
        System.out.println(maxSubArraySum(nums, 0, n-1));

    }

    public static int maxSubArraySum(int[] arr, int low, int high) {

        if (low == high){
            return arr[high];
        }

        int mid = (low + high)/2;

        return Math.max(maxCrossinSum(arr, low, mid, high),
                Math.max(maxSubArraySum(arr, low, mid),
                        maxSubArraySum(arr, mid+1, high)));



    }

    public static int maxCrossinSum(int[] arr, int low, int mid, int high) {

        int sum = 0;
        int left_sum = Integer.MIN_VALUE;
        for (int i = mid; i >= low; i--) {
            sum = sum + arr[i];
            if (sum > left_sum)
                left_sum = sum;
        }

        sum = 0;
        int right_sum = Integer.MIN_VALUE;
        for (int i = mid+1; i <= high; i++) {
            sum = sum + arr[i];
            if (sum > right_sum)
                right_sum = sum;
        }

        int crossingSum = left_sum + right_sum;

        return Math.max(Math.max(left_sum, right_sum), crossingSum);

    }
}
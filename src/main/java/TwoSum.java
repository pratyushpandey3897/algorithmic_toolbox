import java.util.HashMap;
class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i<nums.length; i++)
        {
            int toBeFound = target - nums[i];
            if (map.containsKey(toBeFound))
            {
                return (new int[]{map.get(toBeFound), i});
            }
            map.put(nums[i],i);
        }
        return (new int[]{});
    }
}
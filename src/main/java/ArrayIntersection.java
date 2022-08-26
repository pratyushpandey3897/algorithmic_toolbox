import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class ArrayIntersection {
    public int[] intersect(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> hMap = new HashMap<>();
        List<Integer> l = new ArrayList<>();

        for (int num: nums1) {
            hMap.put(num, hMap.getOrDefault(num,0)+1);
        }
        for(int num: nums2){
            if (hMap.containsKey(num) && hMap.get(num)>0){
                l.add(num);
                hMap.put(num, hMap.get(num)-1);
            }
        }
        int[] arr = new int[l.size()];
        for (int i=0; i<l.size() ; i++){
            arr[i] = l.get(i);
        }

        return arr;
    }
}


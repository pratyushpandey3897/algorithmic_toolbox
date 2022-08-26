import java.util.*;
class UniqueStringChar {
    public static int firstUniqChar(String s) {
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for (int i = 0; i< s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }

        for (int i = 0; i< s.length(); i++){
            int uniqueFlag = map.get(s.charAt(i));
            if (uniqueFlag == 1)
                return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
    }

}
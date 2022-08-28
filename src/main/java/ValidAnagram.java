public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        HashMap <Character, Integer> map1 = new HashMap<Character, Integer>();
        for (int i=0; i <s.length(); i++){
            map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i),0)+1);
        }
        for (int i=0; i <t.length(); i++){
            char ch = t.charAt(i);
            if (map1.containsKey(ch)) {
                map1.put(ch, map1.get(ch)-1);
                if (map1.containsKey(ch) && map1.get(ch) <=0)
                    map1.remove(ch);
            }  else {
                return false;
            }
        }
        if (map1.size() == 0)
            return true;

        return false;

    }
}

import java.util.HashMap;

class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> magMap = new HashMap<Character, Integer>();
        for (int i = 0; i < magazine.length(); i++){
            magMap.put(magazine.charAt(i), magMap.getOrDefault(magazine.charAt(i), 0)+1);
        }

        for (int i = 0; i < ransomNote.length(); i++){
            char ch = ransomNote.charAt(i);
            if (magMap.containsKey(ch) == false || magMap.get(ch) <=0 )
                return false;
            magMap.put(ch, magMap.get(ch) -1 );
        }
        return true;
    }
}
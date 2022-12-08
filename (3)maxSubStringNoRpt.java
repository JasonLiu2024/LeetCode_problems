class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();
        int result = 0;
        int size = 0;
        for(int i = 0; i < s.length(); i++){
            int j = i; 
            while(set.contains(s.charAt(j)) == false){
                set.add(s.charAt(j));
                if(j < s.length() - 1){
                j++;
                }
            }
            size = set.size();
            set.clear();
            if(size >= result){
                result = size;
            }
        }
        return result;
    }
}

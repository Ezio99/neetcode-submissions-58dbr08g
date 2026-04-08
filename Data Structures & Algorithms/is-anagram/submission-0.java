class Solution {
  public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }

        int[] freqArr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freqArr[s.charAt(i)-'a']+=1;
            freqArr[t.charAt(i)-'a']-=1;
        }
        
        for(int i: freqArr){
            if(i!=0) return false;
        }
        
        return true;
    }
}

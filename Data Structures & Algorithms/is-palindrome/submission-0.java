class Solution {
    public boolean isPalindrome(String s) {
        s = s.trim().toLowerCase();
        int R = s.length()-1;

        for(int L=0;L<R;){
            if(!Character.isLetterOrDigit(s.charAt(L))){
                L++;
                continue;
            } else if (!Character.isLetterOrDigit(s.charAt(R))) {
                R--;
                continue;
            } else if (s.charAt(L) != s.charAt(R)) {
                return false;
            }

            L++;R--;
        }


        return true;
    }
}

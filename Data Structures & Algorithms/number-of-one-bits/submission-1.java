class Solution {
    public int hammingWeight(int n) {
        int ctr = 0;
        while (n > 0) {
            ctr += (n&1);
            n >>= 1;
        }
        return ctr;
    }
}

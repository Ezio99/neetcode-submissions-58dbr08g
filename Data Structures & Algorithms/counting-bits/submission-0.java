class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n+1];

        for (int i = 0; i <= n; i++) {
            result[i] = numberOfOnes(i);
        }

        return result;

    }

    private int numberOfOnes(int x){
        int ans=0;
        while(x>0){
            ans+=x&1;
            x=x>>1;
        }
        return ans;
    }
}

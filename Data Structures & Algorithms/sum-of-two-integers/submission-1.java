class Solution {
    public int getSum(int a, int b) {
        int and = (a & b) << 1, xor = a ^ b, sum;
        System.out.println("xor "+Integer.toBinaryString(xor));
        System.out.println("and "+Integer.toBinaryString(and));
        int tmp;
        while (and != 0) {
            //Left Shifted 1 as this is basically carry which needs to be added to next
            tmp = (xor & and) << 1;
            xor = xor ^ and;
            and=tmp;
            

            System.out.println("xor "+Integer.toBinaryString(xor));
            System.out.println("and "+Integer.toBinaryString(and));
        }

        return xor;
    }
}

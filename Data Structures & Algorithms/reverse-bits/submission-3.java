class Solution {
    public int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            // Extract the least significant bit (LSB)
            int lsb = n & 1;

            // Shift the result left to make space for the new bit
            result = (result << 1) | lsb;

            // Shift the input number right to process the next bit
            n >>= 1;
        }

        return result;
    }
}

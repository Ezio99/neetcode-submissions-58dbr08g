class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int j = numbers.length - 1, i = 0, sum = 0;

        while (i < j) {
            sum = numbers[i] + numbers[j];

            if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            }
            else {
                break;
            }


        }


        return new int[]{i+1, j+1};
    }
}

class Solution {
public  List<List<Integer>> permute(int[] nums) {
        return helper(nums);
    }

    private  List<List<Integer>> helper( int[] nums) {
        List<List<Integer>> perms = new ArrayList<>();
        perms.add(new ArrayList<>());
        int i=0;


        while (i < nums.length) {
            List<List<Integer>> nextPerms = new ArrayList<>();
            for (int j = 0; j < perms.size(); j++) {
                List<Integer> perm = perms.get(j);
                for (int k = 0; k < perm.size() + 1; k++) {
                    List<Integer> copy = new ArrayList<>(perm);
                    copy.add(k, nums[i]);
                    nextPerms.add(copy);
                }
            }
            perms = nextPerms;
            i++;
        }

        return perms;
    }
}

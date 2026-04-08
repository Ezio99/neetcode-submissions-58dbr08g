class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        result = new ArrayList<>();
        dfsHelper(0, candidates, target, new ArrayList<>());

        return result;
    }

    public void dfsHelper(int i, int[] candidates, int target, List<Integer> curr) {
        if (target == 0) {
            result.add(new ArrayList<>(curr));
            return;
        }
        if (i >= candidates.length) return;

        //Since sorted, if this elem is big, anything further will be big as well
        if (candidates[i] > target) {
            return;
        }

        //Take
        curr.add(candidates[i]);
        dfsHelper(i + 1, candidates, target - candidates[i], curr);
        curr.remove(curr.size() - 1);

        int j = i;
        while (j < candidates.length && candidates[j] == candidates[i]) {
            j++;
        }

        //Skip
        if (j < candidates.length) {
            dfsHelper(j, candidates, target, curr);
        }

    }
}

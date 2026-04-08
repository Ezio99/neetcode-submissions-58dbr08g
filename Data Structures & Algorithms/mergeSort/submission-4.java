// Definition for a pair.
// class Pair {
//     public int key;
//     public String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> mergeSort(List<Pair> pairs) {
        if (pairs.isEmpty()) {
            return pairs;
        }
        return divide(0, pairs.size() - 1, pairs);
    }

    public List<Pair> divide(int l, int r, List<Pair> pairs) {
        if (r == l) {
            return new ArrayList<>(pairs.subList(l, r + 1));
        }
        
        int m = l + (r - l) / 2;
        List<Pair> leftPair = divide(l, m, pairs);
        List<Pair> rightPair = divide(m + 1, r, pairs);
        return merge(leftPair, rightPair);
    }

    public List<Pair> merge(List<Pair> leftPair, List<Pair> rightPair) {
        if (leftPair == null) {
            return rightPair;
        }
        if (rightPair == null) {
            return leftPair;
        }

        List<Pair> combinedPair = new ArrayList<>();


        int lp = 0, rp = 0;
        while (lp < leftPair.size() && rp < rightPair.size()) {
            if (leftPair.get(lp).key <= rightPair.get(rp).key) {
                combinedPair.add(leftPair.get(lp++));
            } else {
                combinedPair.add(rightPair.get(rp++));
            }
        }

        while (lp < leftPair.size()) {
            combinedPair.add(leftPair.get(lp++));
        }

        while (rp < rightPair.size()) {
            combinedPair.add(rightPair.get(rp++));
        }

        return combinedPair;
    }
}

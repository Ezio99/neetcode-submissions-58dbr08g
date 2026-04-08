// Definition for a pair
// class Pair {
//     int key;
//     String value;
//
//     Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
public class Solution {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {
                if(pairs.isEmpty()){
            return new ArrayList<>();
        }
                List<List<Pair>> result = new ArrayList<>();
        int j;
        Pair tmp;


        for (int i = 1; i < pairs.size(); i++) {
            result.add(new ArrayList<>(pairs));
            j = i - 1;
            while (j >= 0 && pairs.get(j).key > pairs.get(j+1).key) {
                tmp = pairs.get(j);
                pairs.set(j, pairs.get(j+1));
                pairs.set(j+1, tmp);
                j--;
            }
        }

        result.add(new ArrayList<>(pairs));

        return result;
    }
}

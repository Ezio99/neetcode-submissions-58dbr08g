class Solution {
    public boolean isValidSudoku(char[][] board) {
            HashMap<Character, List<List<Integer>>> numberCoordinates = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char currentValue = board[i][j];
                if(currentValue == '.'){
                    continue;
                }
                if (numberCoordinates.containsKey(currentValue)) {
                    for (List<Integer> k : numberCoordinates.get(currentValue)) {
                        if (k.get(0) == i || k.get(1)==j){
                            return false;
                        }
                        int square_start_x = (k.get(0) / 3) * 3 ;
                        int square_start_y = (k.get(1) / 3) * 3;
                        if(i>= square_start_x && i<= square_start_x+2){
                            if(j>= square_start_y && j<= square_start_y+2){
                                return false;
                            }
                        }
                    }
                } else {
                    numberCoordinates.put(currentValue, new ArrayList<>());
                }
                numberCoordinates.get((currentValue)).add(List.of(i, j));

            }
        }

        return true;
    }
}

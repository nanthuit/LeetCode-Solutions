class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {       // rows
            for (int j = 0; j < 9; j++) {   // cols
                char number = board[i][j];
                if (number != '.') {
                    String rowKey = number + " in row " + i;
                    String colKey = number + " in col " + j;
                    String boxKey = number + " in box " + (i/3) + "-" + (j/3);

                    if (!seen.add(rowKey) || !seen.add(colKey) || !seen.add(boxKey)) {
                        return false;
                    }
                }
            }
        }
        return true;

    }
}
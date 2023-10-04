package Blind75;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {

        int rows = 9, cols = 9;

        // check all rows for dups
        Map<Integer, Set<Character>> rowChecker = new HashMap<>();
        Map<Integer, Set<Character>> colChecker = new HashMap<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                char value = board[i][j];
                // check row for dups
                if (value >= '1' && value <= '9') {
                    if (rowChecker.containsKey(i) && rowChecker.get(i).contains(value)) {
                        return false;
                    } else {
                        if (!rowChecker.containsKey(i)) {
                            HashSet<Character> iRowSet = new HashSet<>();
                            iRowSet.add(value);
                            rowChecker.put(i, iRowSet);
                        } else {
                            rowChecker.get(i).add(value);
                        }
                    }
                }

                // check col
                if (value >= '1' && value <= '9') {
                    if (colChecker.containsKey(j) && colChecker.get(j).contains(value)) {
                        return false;
                    } else {
                        if (!colChecker.containsKey(j)) {
                            HashSet<Character> jColSet = new HashSet<>();
                            jColSet.add(value);
                            colChecker.put(j, jColSet);
                        } else {
                            colChecker.get(j).add(value);
                        }
                    }
                }

                // compare 3*3 square

                if (i % 3 == 2 && j % 3 == 2) {
                    int subMatILimit = i - 3, subMatJLimit = j - 3;
                    Set<Character> threeBy3 = new HashSet<>();

                    for (int subMatI = i; subMatI > subMatILimit; subMatI--) {
                        for (int subMatJ = j; subMatJ > subMatJLimit; subMatJ--) {
                            char cell = board[subMatI][subMatJ];
                            if (cell >= '1' && value <= '9') {
                                if (threeBy3.contains(cell)) {
                                    return false;
                                } else {
                                    threeBy3.add(cell);
                                }
                            }
                        }
                    }

                }

            }
        }

        return true;
    }
}
/*
 * 
 * [
 * [".",".",".",".","5",".",".","1","."],
 * [".","4",".","3",".",".",".",".","."],
 * [".",".",".",".",".","3",".",".","1"],
 * ["8",".",".",".",".",".",".","2","."],
 * [".",".","2",".","7",".",".",".","."],
 * [".","1","5",".",".",".",".",".","."],
 * [".",".",".",".",".","2",".",".","."],
 * [".","2",".","9",".",".",".",".","."],
 * [".",".","4",".",".",".",".",".","."]]
 */
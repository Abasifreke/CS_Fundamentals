package com.example.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class ArraysAndStrings {
    private static HashSet<String> exclusionSet = new HashSet<>(Arrays.asList("agege", "ajeromi", "alimosho", "amukoko", "amuwo", "apapa", "banana", "badagry", "bus", "busstop", "clinic", "company", "ebute-metta", "epe", "eti", "eti-osa", "hosp", "hosp.", "hospital", "hospitals", "hospt.", "ibeju", "ifako-ijaye", "ifelodun", "ikeja", "ikorodu", "island", "isolo", "kosofe", "l.g.a", "l.g.a.", "lagos", "lekki", "lga", "limited", "ltd", "ltd.", "mainland", "mushin", "nigeria", "odofin", "ojo", "osa", "oshodi", "pharm", "pharma", "pharmaceutical", "pharmaceuticals", "pharmacy", "rd", "road", "shomolu", "state", "str", "street", "surulere", "vi", "victoria"));

    public static void main(String[] args) {
//        System.out.println(compressString("aabcccccaaa"));
//        System.out.println(zerofyMatrixRowsAndCols(new int[][]{{1, 0, 3}, {1, 2, 3}, {0, 0, 20}}));
//        System.out.println(getSubWords("the big fox is u ", 9));
        System.out.println(computeNameSimilarityScore("Famacare", "Famacare"));
    }

    /**
     * Implement a method to perform basic string compression using the counts of repeated characters.
     * For example, the string aabcccccaaa would become a2b1c5a3.
     * If the "compressed" string would not become smaller than the original string, your method should return the original string.
     * <p>
     * e.g. abca = abca; abcca = abcca; abccaacca = abccaacca; aaaba = aaaba; aaabbbaa = a3b3a2
     */
    private static String compressString(String input) {
        char last = input.charAt(0);
        int count = 1; // assume at least string of length 1

        // first iterate through string and count how big a difference would be needed
        // sacrificing one additional round of N time for creating N space when not needed.
        for (int i = 1; i < input.length(); i++) {
            char curr = input.charAt(i);

            if (curr != last) {
                count++;
            }

            last = curr;
        }

        if (count * 2 < input.length()) {
            StringBuffer sb = new StringBuffer(); // for any string mutation
            // then iterate making the changes if the length compressed length would be smaller than original string
            for (int i = 0; i < input.length(); ) {
                char curr = input.charAt(i);
                sb.append(curr);
                int currCount = 1;

                i++;
                while (i < input.length() && input.charAt(i) == curr) {
                    currCount++;
                    i++;
                }

                sb.append(currCount);
            }
            return sb.toString();
        }
        return input;
    }

    /**
     * Write an algorithm such that if an element in an MxN matrix is 0, its entire row
     * and column are set to 0
     */
    private static int[][] zerofyMatrixRowsAndCols(int[][] input) {
        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;

        // iterate through first col and check for zero
        for (int i = 0; i < input.length; i++) {
            if (input[i][0] == 0) {
                firstRowHasZero = true;
            }
        }

        // iterate through first row and check for zero
        for (int i = 0; i < input[0].length; i++) {
            if (input[0][i] == 0) {
                firstColHasZero = true;
            }
        }

        // iterate through rest of matrix using first row and column for recording zero rows.
        for (int i = 1; i < input.length; i++) {
            for (int j = 1; j < input[0].length; j++) {
                if (input[i][j] == 0) {
                    input[0][j] = 0;
                    input[i][0] = 0;
                }
            }
        }

        // zerofy zero containing rows and columns
        for (int i = 1; i < input.length; i++) {
            for (int j = 1; j < input[0].length; j++) {
                if (input[0][j] == 0 || input[i][0] == 0) {
                    input[i][j] = 0;
                }
            }
        }

        if (firstRowHasZero) {
            for (int i = 0; i < input.length; i++) {
                input[0][i] = 0;
            }

        }

        if (firstColHasZero) {
            for (int i = 0; i < input[0].length; i++) {
                input[i][0] = 0;
            }

        }
        return input; // placing a debugger shows the resultant array structure.
    }

    public  static double computeNameSimilarityScore(String name1, String name2) {
//        StringBuffer buffName1 = removeExclusions(name1.toLowerCase(), 2);
//        StringBuffer buffName2 = removeExclusions(name2.toLowerCase(), 2);
//
//        int longStringLen = Math.max(buffName1.length(), buffName2.length());
//        int editDistance = minDistance(buffName1.toString(), buffName2.toString());
//        double score = 1.0 * (longStringLen - editDistance) / longStringLen;


        StringBuffer buffName1 = new StringBuffer(name1);
        StringBuffer buffName2 = new StringBuffer(name2);
        buffName1 = removeChar(buffName1, ',', 10);
        buffName2 = removeChar(buffName2, ',', 10);
        buffName1 = removeExclusions(buffName1.toString().toLowerCase(), 2);
        buffName2 = removeExclusions(buffName2.toString().toLowerCase(), 2);
        int longStringLen = Math.max(buffName1.length(), buffName2.length());
        int editDistance = minDistance(buffName1.toString(), buffName2.toString());
        double score = 1.0 * (longStringLen - editDistance) / longStringLen;

        // augment score if at least first words were similar
        if (score < 0.55) {
            if (getSubWords(removeChar(new StringBuffer(name1), ',', 10), 1).toString().toLowerCase()
                    .equals(getSubWords(removeChar(new StringBuffer(name2), ',', 10), 1).toString().toLowerCase())) {
                score = score + (score * 0.5);
            }
        }
        return score;
    }

    /***
     * split string into a specified number of words
     */
    private static StringBuffer getSubWords(StringBuffer input, int wordCount) {
        int count = 0;
        int i = 0;
        for (; i < input.length() && count < wordCount; i++) {
            if (input.charAt(i) == ' ') {
                count++;
            }
        }
        input = i == input.length() ? input.replace(i, input.length(), "") : input.replace(i - 1, input.length(), "");
        if (input.length() > 0 && input.charAt(input.length() - 1) == ' ')
            input = input.replace(input.length() - 1, input.length(), "");
        return input;
    }

    private static StringBuffer removeChar(StringBuffer input, char c, int charCount) {
        int count = 0;
        int indexOfSpace;
        while (count < charCount) {
            indexOfSpace = input.substring(0, input.length()).indexOf(c);

            if (indexOfSpace == -1) break;

            input = input.replace(indexOfSpace, indexOfSpace + 1, "");
            count++;
        }

        return input;
    }

    private static StringBuffer removeExclusions(String input) {
        StringBuffer sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer(input, " ");

        while (st.hasMoreTokens()) {
            String nextToken = st.nextToken();
            if (!exclusionSet.contains(nextToken)) {
                sb.append(nextToken);
            }
        }

        return sb;
    }

    private static StringBuffer removeExclusions(String input, int wordCount) {
        StringBuffer sb = new StringBuffer();
        StringTokenizer st = new StringTokenizer(input, " ");
        int count = 0;

        while (st.hasMoreTokens() && count < wordCount) {
            String nextToken = st.nextToken();
            if (!exclusionSet.contains(nextToken)) {
                sb.append(nextToken);
                count++;
            }
        }

        return sb;
    }

    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] mem = new int[m][n];
        for (int[] arr : mem) {
            Arrays.fill(arr, -1);
        }
        return calDistance(word1, word2, mem, m - 1, n - 1);
    }

    private static int calDistance(String word1, String word2, int[][] mem, int i, int j) {
        if (i < 0) {
            return j + 1;
        } else if (j < 0) {
            return i + 1;
        }
        if (mem[i][j] != -1) {
            return mem[i][j];
        }
        if (word1.charAt(i) == word2.charAt(j)) {
            mem[i][j] = calDistance(word1, word2, mem, i - 1, j - 1);
        } else {
            int prevMin = Math.min(calDistance(word1, word2, mem, i, j - 1), calDistance(word1, word2, mem, i - 1, j));
            prevMin = Math.min(prevMin, calDistance(word1, word2, mem, i - 1, j - 1));
            mem[i][j] = 1 + prevMin;
        }
        return mem[i][j];
    }
}

package Blind75;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

/*
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]

 */
public class GroupAnagram {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, List<String>> resultMap = new HashMap<>();

        for (String str : strs) {

            // compute str's dictionary
            HashMap<Character, Integer> strMap = new HashMap<>();

            for (int i = 0; i < str.length(); i++) {
                char charAti = str.charAt(i);

                if (!strMap.containsKey(charAti)) {
                    strMap.put(charAti, 1);
                } else {
                    strMap.put(charAti, strMap.get(charAti) + 1);
                }
            }

            if (!resultMap.containsKey(strMap)) {
                List<String> strList = new ArrayList<>();
                strList.add(str);
                resultMap.put(strMap, strList);
            } else {
                resultMap.get(strMap).add(str);
            }
        }

        System.out.println(resultMap.values().stream().toList());
        return resultMap.values().stream().toList();

    }

    public List<List<String>> groupAnagramsWithSorting(String[] strs) {
        HashMap<String, List<String>> mapping = new HashMap<>();

        for (String str : strs) {
            char[] strArr = str.toCharArray();
            Arrays.sort(strArr);
            String key = Arrays.toString(strArr);
            if (!mapping.containsKey(key)) {
                List<String> value = new LinkedList<>();
                value.add(str);
                mapping.put(key, value);
            } else {
                mapping.get(key).add(str);
            }
        }

       return mapping.values().stream().toList();
    }

    public static void main(String[] args) {
        GroupAnagram groupAnagram = new GroupAnagram();
        groupAnagram.groupAnagrams(new String[] { "" });
    }

}

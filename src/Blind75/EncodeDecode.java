package Blind75;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class EncodeDecode {

    /*
     * @param strs: a list of strings
     * 
     * @return: encodes a list of strings to a single string.
     */
    public String encode(List<String> strs) {
        if (strs == null || strs.size() == 0) {
            return "";
        }

        // write your code here
        StringBuilder sb = new StringBuilder(strs.get(0));
        for (int i = 1; i < strs.size(); i++) {
            sb.append("::");
            sb.append(strs.get(i));
        }

        return sb.toString();
    }

    /*
     * @param str: A string
     * 
     * @return: decodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        // write your code here

        String[] strArr = str.split("::");

        return Arrays.asList(strArr);
    }

    public static void main(String[] args) {
        EncodeDecode ed = new EncodeDecode();
        String encoded = ed
                .encode(new ArrayList<String>(Arrays.asList(new String[] { "lint", "code", "love", "you" })));
        System.out.println(encoded);
        System.out.println(ed.decode(encoded));
    }
}

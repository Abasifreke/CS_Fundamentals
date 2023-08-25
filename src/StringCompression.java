public class StringCompression {

    public static String compress(String input) {

        input = input.toLowerCase();
        StringBuffer buff = new StringBuffer("");

        for (int i = 0; i <= input.length() - 1;) {
            int j = i + 1;
            int counter = 1;

            char charLookedAt = input.charAt(i);
            while (j < input.length() && charLookedAt == input.charAt(j)) {
                j++;
                counter++;
            }

            i = j;
            buff.append(charLookedAt + "" + counter);
        }

        return buff.length() < input.length() ? buff.toString() : input;
    }

    // i -
    // j --------------
    // i -
    // j --------------
    // i -
    // j --------------
    // ....

    // i --------------
    // j --------------

    // ---------------
    // stirng

    // ---------
    // i -
    // j ---
    // i -
    // j -----
    // i -
    // j ------

    // -----------------
    // stirng

    public static void main(String[] args) {

        String testString = "aaabbbcccddda";
        System.out.println(StringCompression.compress(testString));

        // expexts a3b4c3d1
    }

}

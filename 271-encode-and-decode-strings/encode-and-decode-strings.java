public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < strs.size(); i++){
            String str = strs.get(i);
            sb.append(str);
            if(i != strs.size() - 1){
                sb.append("è");
            }
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        System.out.println(s);
        String[] sParts = s.split("è", -1);
        // System.out.println(Arrays.toString(sParts));
        return Arrays.asList(sParts);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
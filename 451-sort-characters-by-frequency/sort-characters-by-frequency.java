
import java.util.AbstractMap.SimpleEntry;
class Solution {

    public String frequencySort(String s) {
        // a-z, A-Z, 0-9 = 62
        SimpleEntry<Character, Integer>[] counter = new SimpleEntry[26 + 26 + 10];

        for(int i = 0; i < counter.length; i++ ){
            if(i < 26){
                counter[i] = new SimpleEntry((char)('A' + i), 0);
            }else if(i >= 26 && i < 52){
                 counter[i] = new SimpleEntry((char)('a' + i - 26), 0);
            }else {
                counter[i] = new SimpleEntry((char)('0' + i - 52), 0);
            }
        }

        for(char c: s.toCharArray()){
            if(c >= 'A' && c <= 'Z'){
                counter[c - 'A'].setValue(counter[c - 'A'].getValue() + 1);
            }else if(c >= 'a' && c <= 'z'){
                counter[c - 'a' + 26].setValue(counter[c - 'a' + 26].getValue() + 1);
            }else{
                counter[c - '0' + 52].setValue(counter[c - '0' + 52].getValue() + 1);
            }
        }

        Arrays.sort(counter, (a, b) -> b.getValue() - a.getValue());

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < counter.length; i++){
            SimpleEntry<Character, Integer> curr = counter[i];

            for(int j = 0; j < curr.getValue(); j++){
                sb.append(curr.getKey());
            }
        }

        return sb.toString();
    }
}
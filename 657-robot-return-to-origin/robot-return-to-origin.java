class Solution {
    public boolean judgeCircle(String movesString) {
        Map<Character, Integer> moves = new HashMap<>();
        moves.put('U',0);
        moves.put('D',0);
        moves.put('L',0);
        moves.put('R',0);
        
        for(char c: movesString.toCharArray()){
            moves.put(c, moves.getOrDefault(c, 0) + 1);
        }
        
        
        return moves.get('D').equals(moves.get('U')) && moves.get('L').equals(moves.get('R'));
    }
}
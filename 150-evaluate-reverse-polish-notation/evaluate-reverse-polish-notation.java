class Solution {
    private static final Map<String, BiFunction<Integer, Integer, Integer>> OPERATIONS = new HashMap<>();
    static {
        OPERATIONS.put("+", (a, b) -> b + a);
        OPERATIONS.put("-", (a, b) -> b - a);
        OPERATIONS.put("*", (a, b) -> b * a);
        OPERATIONS.put("/", (a, b) -> b / a);
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> operands = new Stack<>();

        for(String token: tokens){
            if(!"+-*/".contains(token)){
                operands.push(Integer.parseInt(token));
            }else{
                operands.push(OPERATIONS.get(token).apply(operands.pop(), operands.pop()));
            }
        }

        return operands.pop();
    }
}
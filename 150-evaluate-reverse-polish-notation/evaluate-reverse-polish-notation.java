class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> operands = new Stack<>();

        for(String token: tokens){
            try{
                int tokenAsNum = Integer.parseInt(token);
                operands.push(tokenAsNum);
            }
            catch(NumberFormatException nfException){
                Integer opResult = performOperation(token, operands.pop(), operands.pop());
                if(opResult == null) return -1;

                operands.push(opResult);
            }
        }

        return operands.pop();
    }

    private Integer performOperation(String token, int operand1, int operand2){
        if(token.equals("+")){
            return operand2 + operand1;
        }
        else if(token.equals("-")){
            return operand2 - operand1;
        }
        else if(token.equals("*")){
            return operand2 * operand1;
        }
        else if(token.equals("/")){
            return operand2 / operand1;
        }else{
            return null;
        }
    }
}
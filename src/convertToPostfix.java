public class convertToPostfix{

    public static StringBuilder convertToPostfix(String infix) {
        StackInterface<Character> operatorStack = new LinkedStack<>();
        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i < infix.length(); i++) {
            Character nextCharacter = infix.charAt(i);

            switch(nextCharacter){
                case '^':
                    operatorStack.push(nextCharacter);
                    break;
                case '+': case '-': case '*': case '/':
                    while(!operatorStack.isEmpty() && precedence(nextCharacter) <= precedence(operatorStack.peek())){
                        postfix.append(operatorStack.peek());
                        operatorStack.pop();
                    }
                    operatorStack.push(nextCharacter);
                    break;
                case '(':
                    operatorStack.push(nextCharacter);
                    break;
                case ')':
                    Character topOperator = operatorStack.pop();
                    while (topOperator != '('){
                        postfix.append(topOperator);
                        topOperator = operatorStack.pop();
                    }
                    break;
                default:
                    break;
            }
        }

        while (!operatorStack.isEmpty()){
            Character topOperator = operatorStack.pop();
            postfix.append(topOperator);
        }
        return postfix;
    }

    private static int precedence(Character character){
        int result = 0;
        switch (character){
            case '^':
                result = 3;
                break;
            case '*': case '/':
                result = 2;
                break;
            case '+': case '-':
                result = 1;
                break;
                default:
                    break;
        }
        return result;
    }

}

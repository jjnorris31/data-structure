public class BalanceChecker {

    public static boolean checkBalance(String expression){

        StackInterface<Character> openDelimiterStack = new LinkedStack<>();
        int characterCount = expression.length();
        boolean isBalanced = true;
        int index = 0;
        char nextCharacter = ' ';

        for (; isBalanced && (index < characterCount); index++){
            nextCharacter = expression.charAt(index);

            switch (nextCharacter){
                case '(': case '[': case '{':
                    openDelimiterStack.push(nextCharacter);
                    break;
                    case ')': case ']': case '}':
                        if (openDelimiterStack.isEmpty()){
                            isBalanced = false;
                        } else {
                            char openDelimiter = openDelimiterStack.pop();
                            isBalanced = isPaired(openDelimiter, nextCharacter);
                        }
                    break;
                default:
                    break;
            }
        }

        if (!openDelimiterStack.isEmpty()){
            isBalanced = false;
        }
        return isBalanced;
    }

    private static boolean isPaired(char open, char close){
        return (open == '(' && close == ')') || (open == '[' && close == ']') || (open == '{' && close == '}');
    }
}

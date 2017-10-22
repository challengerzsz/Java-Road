import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Calculator {
    public boolean whoIsBig(char tmp1, char tmp2) {
        if ('(' == tmp2) {
            return true;
        }
        if ('*' == tmp1 || '/' == tmp1) {
            if ('+' == tmp2 || '-' == tmp2) {
                return true;
            }
        }
        if ('%' == tmp1) {
            if ('+' == tmp2 || '-' == tmp2) {
                return true;
            }
        }

        return false;
    }


    public String changeMidToAfter(String expression) {

        List<Character> newExpression = new ArrayList();
        Stack<Character> stack = new Stack();

        newExpression.add(' ');
        for (int i = 0; i < expression.length(); i++) {
            if ('(' == expression.charAt(i)) { // 如果是左括号,则入栈
                stack.push(expression.charAt(i));
            }
            else if ('+' == expression.charAt(i) || '-' == expression.charAt(i) || '*' == expression.charAt(i) || '/' == expression.charAt(i) || '%' == expression.charAt(i)) {
                newExpression.add(' ');
                char tmp;
                if (!stack.empty()) {
                    tmp = stack.pop();
                    if (whoIsBig(expression.charAt(i), tmp)) {
                        stack.push(tmp);
                        stack.push(expression.charAt(i));
                    } else {
                        while (true) {
                            if (!whoIsBig(expression.charAt(i), tmp)) {
                                newExpression.add(tmp);
                                newExpression.add(' ');
                                if (!stack.empty()) {
                                    tmp = stack.pop();
                                } else {
                                    stack.push(expression.charAt(i));
                                    break;
                                }
                            } else {
                                stack.push(tmp);
                                stack.push(expression.charAt(i));
                                break;
                            }
                        }
                    }
                } else {
                    stack.push(expression.charAt(i));
                }
            } else if (')' == expression.charAt(i)) { //如果是")",则出栈,一直到遇到"("
                while (!stack.empty()) {
                    char tmp = stack.pop();
                    if (!('(' == tmp)) {
                        newExpression.add(' ');
                        newExpression.add(tmp);
                    } else {
                        break;
                    }
                }
            } else {
                newExpression.add(expression.charAt(i));
            }
        }
        while (!stack.empty()) {
            char tmp = stack.pop();
            newExpression.add(' ');
            newExpression.add(tmp);
        }
        newExpression.add(' ');
        String newExpression1 = "";
        for (int i = 0; i < newExpression.size(); i++) {
            newExpression1 = newExpression1 + newExpression.get(i) + "";
        }
        return newExpression1;
    }





    /*
    1 public BigDecimal add(BigDecimal value);                        //加法
    2 public BigDecimal subtract(BigDecimal value);                   //减法
    3 public BigDecimal multiply(BigDecimal value);                   //乘法
    4 public BigDecimal divide(BigDecimal value);                     //除法
 */
    public BigDecimal expressionCalculating(String expression) {
        Stack<String> stack = new Stack();
        String tmp1 = null, tmp2 = null;
        String [] splitExpression;
        splitExpression = expression.split(" ");

        for (int i = 0; i < splitExpression.length; i++) {
            if (isNumeric(splitExpression[i])) {
                stack.push(splitExpression[i]);
            }
            else {
                BigDecimal op1;
                BigDecimal op2;
                BigDecimal [] ans;
                if (!stack.empty()) {
                    tmp1 = stack.pop();
                }
                if (!stack.empty()) {
                    tmp2 = stack.pop();
                }

                op1 = new BigDecimal(tmp2);
                op2 = new BigDecimal(tmp1);
                switch (splitExpression[i]) {
                    case "+":
                        stack.push(String.valueOf(op1.add(op2)));
                        break;
                    case "-":
                        stack.push(String.valueOf(op1.subtract(op2)));
                        break;
                    case "*":
                        stack.push(String.valueOf(op1.multiply(op2)));
                        break;
                    case "/" :
                        stack.push(String.valueOf(op1.divide(op2,6,BigDecimal.ROUND_DOWN)));
                        break;
                    case "%" :
                        ans = op1.divideAndRemainder(op2);
                        stack.push(String.valueOf(ans[1]));
                    default:
                        break;
                }
            }
        }
        return new BigDecimal(stack.pop());

    }
    public static boolean isNumeric(String str) {
        for (int i = str.length(); --i >= 0 ;) {
            if (!Character.isDigit(str.charAt(i)) && str.charAt(i) != '.') {
                return false;
            }
        }
        return true;
    }


}




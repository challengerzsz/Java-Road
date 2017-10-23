
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


    private boolean isMatched(String str) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9' || str.charAt(i) == '+' || str.charAt(i) == '-' ||str.charAt(i) == '*'
            || str.charAt(i) == '/') {
                i++;
                continue;
            }
            if (str.charAt(i) == '(') {
                stack.push(str.charAt(i));
                continue;
            }
            if (str.charAt(i) == ')') {
                if (!stack.empty() && stack.peek() == '(') {
                    stack.pop();
                    continue;
                }
                else {
                    return false;
                }
            }
        }

        if (!stack.empty()) {
            return false;
        }

        return true;
    }


    public String changeMidToAfter(String expression) {

        if (isMatched(expression)) {
            List<Character> newExpression = new ArrayList();
            Stack<Character> stack = new Stack();
            newExpression.add(' ');
            for (int i = 0; i < expression.length(); i++) {
                if ('(' == expression.charAt(i)) { // 如果是左括号,则入栈
                    stack.push(expression.charAt(i));
                }
                else if ('+' == expression.charAt(i) || '-' == expression.charAt(i) || '*' == expression.charAt(i) || '/' == expression.charAt(i) || '%' == expression.charAt(i)) {
                    if ('-' == expression.charAt(i)) {
                        if (newExpression.get(newExpression.size() - 1) >= '0'
                                && newExpression.get(newExpression.size() - 1) <= '9') {
                            newExpression.add(' ');
                            newExpression.add('0');
                            newExpression.add(' ');
                            newExpression.add('+');
                        }
                        else {
                            newExpression.add('0');
                            newExpression.add(' ');
                            newExpression.add('0');
                            newExpression.add(' ');
                            newExpression.add('+');
                        }

                    }
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
            System.out.println(newExpression1);
            return newExpression1;
        }

        return "";
    }





    /*
    1 public BigDecimal add(BigDecimal value);                        //加法
    2 public BigDecimal subtract(BigDecimal value);                   //减法
    3 public BigDecimal multiply(BigDecimal value);                   //乘法
    4 public BigDecimal divide(BigDecimal value);                     //除法
 */
    public String expressionCalculating(String expression) {
        String tmp = null;
        if (hasOp(expression)) {
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
                            tmp = String.valueOf(op1.divide(op2,10,BigDecimal.ROUND_DOWN));
                            tmp = isZhengChu(tmp);
                            stack.push(tmp);
                            break;
                        case "%" :
                            System.out.println("op1:" + op1 + "op2:" + op2);
                            ans = op1.divideAndRemainder(op2);
                            stack.push(String.valueOf(ans[1]));
                        default:
                            break;
                    }
                }
            }
            String finalAnswer = new String(String.valueOf(new BigDecimal(stack.pop())));
            return finalAnswer;
        }

        return "";
    }


    private String isZhengChu(String finalAnswer) {
        int index = 0;
        for (int i = 0; i < finalAnswer.length(); i++) {
            if (finalAnswer.charAt(i) == '.') {
                index = i;
                break;
            }
        }
        int flag = 0;
        for (int i = index + 1; i < finalAnswer.length(); i++) {
            if (finalAnswer.charAt(i) > '0' && finalAnswer.charAt(i) <= '9') {
                flag = 1;
                break;
            }
        }
        if (flag == 0) { //整除
            finalAnswer = finalAnswer.substring(0,index);
        }
        return finalAnswer;
    }

    public static boolean isNumeric(String str) {
        for (int i = str.length(); --i >= 0 ;) {
            if (!Character.isDigit(str.charAt(i)) && str.charAt(i) != '.') {
                return false;
            }
        }
        return true;
    }

    private boolean hasOp(String str) {
        int opindex = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                opindex++;
            }
        }
        if (opindex == 0) {
            return false;
        }
        return true;
    }
}




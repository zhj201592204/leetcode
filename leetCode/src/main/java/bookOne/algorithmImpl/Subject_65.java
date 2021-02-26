package bookOne.algorithmImpl;

import java.util.Stack;

public class Subject_65 {

    public int calculate(String s) {
        Stack<Integer> result = new Stack<>();
        Stack<String> ope = new Stack<>();

        char[] data = s.toCharArray();
        //计算完乘除法
        for(int i=0; i<data.length; ) {
            if(Character.isDigit(data[i])) {
                result.push(Integer.parseInt(data[i++]+""));
            }else{
                switch(data[i]) {
                    case '+' :
                        ope.push(String.valueOf(data[i++]));
                        break;
                    case '-' :
                        ope.push(String.valueOf(data[i++]));
                        break;
                    case '*' :
                        result.push(result.pop() * Integer.parseInt(String.valueOf(data[i+1])));
                        i += 2;
                        break;
                    case '/' :
                        result.push(result.pop() / Integer.parseInt(String.valueOf(data[i+1])));
                        i += 2;
                        break;
                }
            }
        }
        //计算加减法
        while(!ope.isEmpty()) {
            int operands_r = result.pop();
            String op = ope.pop();
            int operands_l = result.pop();
            if("+".equals(op)) {
                result.push(operands_l+operands_r);
            }else {
                result.push(operands_l-operands_r);
            }
        }
        return result.pop();
    }
}

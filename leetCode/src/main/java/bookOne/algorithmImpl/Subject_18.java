package bookOne.algorithmImpl;

import java.util.Stack;

//请设计一个栈，除了常规栈支持的pop与push函数以外，
// 还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(1)。

/**
 * 可以采用双栈法
 */
public class Subject_18 {

    private Stack<Integer> minData;
    private Stack<Integer> stack;

    /** initialize your data structure here. */
    public Subject_18() {
        stack = new Stack<>();
        minData = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(minData.empty()) {
            minData.add(x);
        }else {
            if(x < minData.peek()) {
                minData.push(x);
            }
        }
    }

    public void pop() {
        if(stack.pop().equals(minData.peek())) {
            minData.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minData.peek();
    }
}

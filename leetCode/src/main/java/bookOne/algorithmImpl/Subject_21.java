package bookOne.algorithmImpl;

import java.util.Stack;

/**
 * 栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。
 * 最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。
 * 该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。
 *
 * 优化点：加一个辅助栈，不必将数据压回来压过去，只在必要的时候进行操作
 */
public class Subject_21 {

    private Stack<Integer> minStack;

    public Subject_21() {
        minStack = new Stack<>();
    }

    public void push(int val) {
        if(minStack.isEmpty() || minStack.peek() > val) {
            minStack.push(val);
        }else {
            Stack<Integer> tempStack = new Stack<>();
            while(!minStack.isEmpty() && minStack.peek() < val) {
                tempStack.push(minStack.pop());
            }
            minStack.push(val);
            while(!tempStack.isEmpty()) {
                minStack.push(tempStack.pop());
            }
        }
    }

    public void pop() {
        if(!minStack.isEmpty()) {
            minStack.pop();
        }
    }

    public int peek() {
        return minStack.isEmpty()?(-1) : minStack.peek();
    }

    public boolean isEmpty() {
        return minStack.isEmpty();
    }
}

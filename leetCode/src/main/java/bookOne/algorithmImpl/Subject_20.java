package bookOne.algorithmImpl;

import java.util.Stack;

/**
 * 实现一个MyQueue类，该类用两个栈来实现一个队列。
 */
public class Subject_20 {

    private Stack<Integer> stack;
    private Stack<Integer> queue;

    public Subject_20() {
        this.stack = new Stack<>();
        this.queue = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if(stack.isEmpty()) {
            if(queue.isEmpty()) {
                stack.push(x);
            }else{
                while(!queue.isEmpty()) {
                    stack.push(queue.pop());
                }
                stack.push(x);
            }
        }else{
            stack.push(x);
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(queue.isEmpty()) {
            while(!stack.isEmpty()) {
                queue.push(stack.pop());
            }
            return queue.pop();
        }
        return queue.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(queue.isEmpty()) {
            while(!stack.isEmpty()) {
                queue.push(stack.pop());
            }
            return queue.peek();
        }
        return queue.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty()&&queue.isEmpty();
    }
}

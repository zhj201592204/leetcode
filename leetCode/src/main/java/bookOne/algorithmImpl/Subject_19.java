package bookOne.algorithmImpl;

import java.util.ArrayList;
import java.util.List;

/**
 *  堆盘子。设想有一堆盘子，堆太高可能会倒下来。因此，在现实生活中，盘子堆到一定高度时，我们就会另外堆一堆盘子。
 *  请实现数据结构SetOfStacks，模拟这种行为。SetOfStacks应该由多个栈组成，并且在前一个栈填满时新建一个栈。
 *  此外，SetOfStacks.push()和SetOfStacks.pop()应该与普通栈的操作方法相同（也就是说，pop()返回的值，
 *  应该跟只有一个栈时的情况一样）。 进阶：实现一个popAt(int index)方法，根据指定的子栈，执行pop操作。
 *
 *  当某个栈为空时，应当删除该栈。当栈中没有元素或不存在该栈时，pop，popAt 应返回 -1.
 */
public class Subject_19 {
    private int cap;
    private ArrayList<List> stacks = new ArrayList<>();

    public Subject_19(int cap) {
        this.cap = cap;
    }

    public void push(int val) {
        if(this.stacks.size() == 0) {
            List<Integer> stack = new ArrayList<>();
            stack.add(val);
            this.stacks.add(stack);
        }else{
            if(this.stacks.get(this.stacks.size()-1).size() == cap) {
                List<Integer> stack = new ArrayList<>();
                stack.add(val);
                this.stacks.add(stack);
            }else{
                this.stacks.get(this.stacks.size()-1).add(val);
            }
        }
    }

    public int pop() {
        if(this.stacks.size() <=0 ) {
            return -1;
        }
        List finalStack = this.stacks.get(stacks.size()-1);//最新的一个盘子
        int top = (int)finalStack.get(finalStack.size()-1);//盘子里最上面的值
        finalStack.remove(finalStack.size()-1);//出栈
        if(finalStack.size() == 0) {
            this.stacks.remove(this.stacks.size()-1);
        }
        return top;
    }

    public int popAt(int index) {
        if(index > this.stacks.size()-1 || index < 0) {
            return -1;
        }
        List atStack = this.stacks.get(index);
        int atTop = (int)atStack.get(atStack.size()-1);
        atStack.remove(atStack.size()-1);
        if(atStack.size() == 0) {
            this.stacks.remove(index);
        }
        return atTop;

    }
}

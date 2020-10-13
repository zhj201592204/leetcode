package bookOne.algorithmImpl;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 动物收容所。有家动物收容所只收容狗与猫，且严格遵守“先进先出”的原则。在收养该收容所的动物时，收养人只能收养所有动物中“最老”（由其进入收容所的时间长短而定）的动物，或者可以挑选猫或狗（同时必须收养此类动物中“最老”的）。换言之，收养人不能自由挑选想收养的对象。请创建适用于这个系统的数据结构，实现各种操作方法，比如enqueue、dequeueAny、dequeueDog和dequeueCat。允许使用Java内置的LinkedList数据结构。
 *
 * enqueue方法有一个animal参数，animal[0]代表动物编号，animal[1]代表动物种类，其中 0 代表猫，1 代表狗。
 *
 * dequeue*方法返回一个列表[动物编号, 动物种类]，若没有可以收养的动物，则返回[-1,-1]。
 */
public class Subject_22 {

    private Queue<Integer> Dogs = new LinkedList<>();
    private Queue<Integer> Cats = new LinkedList<>();

    public Subject_22() {

    }

    public void enqueue(int[] animal) {
        if(0 == animal[1]) {
            Cats.offer(animal[0]);
        }else{
            Dogs.offer(animal[0]);
        }
    }

    public int[] dequeueAny() {
        if(Dogs.isEmpty() && Cats.isEmpty()) {
            return new int[]{-1,-1};
        }
        if(Dogs.isEmpty()) {
            return new int[]{Cats.poll(),0};
        }else{
            if(Cats.isEmpty()) {
                return new int[]{Dogs.poll(),1};
            }else{
                return (Dogs.peek() < Cats.peek())?new int[]{Dogs.poll(),1} : new int[]{Cats.poll(),0};
            }
        }
    }

    public int[] dequeueDog() {
        return Dogs.isEmpty() ? new int[]{-1,-1} : new int[]{Dogs.poll(),1};
    }

    public int[] dequeueCat() {
        return Cats.isEmpty() ? new int[]{-1,-1} : new int[]{Cats.poll(),0};
    }
}

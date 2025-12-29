package Chapter_9_Collections_and_Generics;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Queue_and_Deque_Interfaces {
    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(4);
        System.out.println(queue.remove());
        System.out.println(queue.peek());


        // Using LinkedList as a Deque
        Deque<Integer> deque = new LinkedList<>();
        deque.offerFirst(10);
        deque.offerLast(4);
        System.out.println(deque.peekFirst());
        System.out.println(deque.pollFirst());
        System.out.println(deque.pollLast());
        System.out.println(deque.pollFirst());
        System.out.println(deque.peekFirst());

        // Using ArrayDeque as a stack
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(10);
        stack.push(4);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}

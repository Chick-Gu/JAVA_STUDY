package data_structures;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.PriorityQueue;

/**
 * 队列和栈示例
 */
public class QueueStackDemo {
    
    public static void main(String[] args) {
        // 1. Queue（队列 - FIFO）
        System.out.println("=== Queue（队列）===");
        Queue<String> queue = new LinkedList<>();
        queue.add("第一个");
        queue.add("第二个");
        queue.add("第三个");
        
        System.out.println("队列元素: " + queue);
        System.out.println("队首元素: " + queue.peek());
        System.out.println("出队: " + queue.poll());
        System.out.println("出队: " + queue.poll());
        System.out.println("剩余元素: " + queue);
        
        // 2. Stack（栈 - LIFO）
        System.out.println("\n=== Stack（栈）===");
        Stack<String> stack = new Stack<>();
        stack.push("第一个");
        stack.push("第二个");
        stack.push("第三个");
        
        System.out.println("栈元素: " + stack);
        System.out.println("栈顶元素: " + stack.peek());
        System.out.println("出栈: " + stack.pop());
        System.out.println("出栈: " + stack.pop());
        System.out.println("剩余元素: " + stack);
        
        // 3. PriorityQueue（优先级队列）
        System.out.println("\n=== PriorityQueue（优先级队列）===");
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(5);
        pq.add(1);
        pq.add(3);
        pq.add(2);
        
        System.out.println("优先级队列: " + pq);
        while (!pq.isEmpty()) {
            System.out.println("出队（最小元素）: " + pq.poll());
        }
        
        // 4. Deque（双端队列）
        System.out.println("\n=== Deque（双端队列）===");
        LinkedList<String> deque = new LinkedList<>();
        deque.addFirst("头部");
        deque.addLast("尾部");
        deque.addFirst("新头部");
        
        System.out.println("双端队列: " + deque);
        System.out.println("移除头部: " + deque.removeFirst());
        System.out.println("移除尾部: " + deque.removeLast());
    }
}

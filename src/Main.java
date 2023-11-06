
import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        HashMap<Integer, String> hashMap = new HashMap<>();
        Stack<Integer> stack = new Stack();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        int size = stack.size();
        System.out.println(size);

        Queue<Integer[]> q = new LinkedList<>();
        q.offer(new Integer[]{1,2});
        Integer[] pos = q.poll();

        System.out.println(pos[0] + "," + pos[1]);

    }
}
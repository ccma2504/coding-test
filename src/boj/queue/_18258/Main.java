package boj.queue._18258;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int size = Integer.parseInt(br.readLine());
            String[] arr = new String[size];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = br.readLine();
            }
            br.close();

            solution(arr, bw);

            bw.flush();
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
    public static void solution(String[] arr, BufferedWriter bw) throws IOException {
        /*
        Qeueue,
        for loop,
            slice " ",

            push, q.offer();
            pop, q.poll(); 없으면-1
            size, q.size()
            empty, 1 or 0
            front, q.peek()
            back, 마지막에 push 한것 불러오기, 없으면 -1
         */
        Queue<Integer> q = new LinkedList<>();
        Deque<Integer> dq = new ArrayDeque<>();

        int last = 0;
        for (int i = 0; i < arr.length; i ++) {
            String command = arr[i];
            String[] commandList = command.split(" ");

            if ("push".equals(commandList[0])) {
                int tmp = Integer.parseInt(commandList[1]);
                q.offer(tmp);
                last = tmp;
            } else if ("pop".equals(commandList[0])) {
                int tmp = -1;
                if (! q.isEmpty()) {
                    tmp = q.poll();
                }
                bw.write(tmp + "\n");
            } else if ("size".equals(commandList[0])) {
                bw.write(q.size() + "\n");
            } else if ("empty".equals(commandList[0])) {
                int tmp = 0;
                if (q.isEmpty()) {
                    tmp = 1;
                }
                bw.write(tmp + "\n");
            } else if ("front".equals(commandList[0])) {
                int tmp = -1;
                if (!q.isEmpty()) {
                    tmp = q.peek();
                }
                bw.write(tmp + "\n");
            } else if ("back".equals(commandList[0])) {
                int tmp = -1;
                if (! q.isEmpty()) {
                    tmp = last;
                }
                bw.write(tmp + "\n");
            }
        }
    }
}
/*
15
push 1  1
push 2  1,2
front
back
size
empty
pop
pop
pop
size
empty
pop
push 3
empty
front

->
1
2
2
0

 */

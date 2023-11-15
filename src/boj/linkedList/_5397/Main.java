package boj.linkedList._5397;


import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String cnt = br.readLine();
        int size = Integer.parseInt(cnt);

        String[] sArr = new String[size];
        for (int i = 0; i < size; i++) {
            sArr[i] = br.readLine();
        }

        solution(sArr);

        br.close();
    }
    public static void solution(String[] sArr) throws IOException {
        for (int i = 0; i < sArr.length; i++) {

            System.out.println(makePw(sArr[i]));
        }
    }

    public static String makePw(String pw) {
        /*
        < (문자, 포지션), 포지션 -1, left.pop() right.push()
        > (문자, 포지션), 포지션 +1 left.push() right.pop()
        - (문자, 포지션), 포지션에서 한칸 뒤 있는 문자 제거 및 포지션-1, left.pop()

        시간 초과 문제.
        해결은 했지만, 리스트를 매번 travers 하는 문제가 있음,
        현제의 위치를 저장하고 있는 자료형이었으면 함.
        stack을 사용해 왼쪽 오른쪽 옮겨가면서 해볼까?
        https://myeongmy.tistory.com/30
         */
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
//        int pos = -1;
        for (int i = 0; i < pw.length(); i++) {
            char c = pw.charAt(i);

            if (c == '<') {
                if (left.size() > 0) {
                    right.push(left.pop());
                }
            } else if (c == '>') {
                if (right.size() > 0) {
                    left.push(right.pop());
                }
            } else if (c == '-') {
                if (left.size() > 0) {
                    left.pop();
                }
            } else {
                left.push(c);
            }
        }
        StringBuilder rtn = new StringBuilder();
        while (!left.isEmpty()) {
            right.push(left.pop());
        }

        while (!right.isEmpty()) {
            rtn = rtn.append(right.pop());
        }

        return rtn.toString();
    }
//    public static String makePw(String pw) {
//        /*
//        i 번쨰 삭제 : remove(int)
//        i 번째 "-" 끼워넣기 : add(int , string);
//        so
//
//        < (문자, 포지션), 포지션 -1
//        > (문자, 포지션), 포지션 +1
//        - (문자, 포지션), 포지션에서 한칸 뒤 있는 문자 제거 및 포지션-1,
//
//        시간 초과 문제.
//        해결은 했지만, 리스트를 매번 travers 하는 문제가 있음,
//        현제의 위치를 저장하고 있는 자료형이었으면 함.
//        stack을 사용해 왼쪽 오른쪽 옮겨가면서 해볼까?
//         */
//        LinkedList<String> arrayList = new LinkedList<>();
//        int pos = -1;
//        for (int i = 0; i < pw.length(); i++) {
//            char c = pw.charAt(i);
//
//            if (c == '<') {
//                if (pos > -1) {
//                    pos--;
//                }
//            } else if (c == '>') {
//                if (arrayList.size()-1 > pos) {
//                    pos++;
//                }
//            } else if (c == '-') {
//                if (pos > -1) {
//                    arrayList.remove(pos);
//                    pos--;
//                }
//            } else {
//                arrayList.add(pos+1, "" + c);
//                pos++;
//            }
//        }
//        String rtn = "";
//        for (int i = 0; i < arrayList.size(); i++) {
//            rtn = rtn + arrayList.get(i);
//        }
//
//
//        return rtn;
//    }
}

package boj.stack._3986;

import java.io.*;
import java.util.*;

public class Main {
    static class Info {
        int start = 0;
        int end = 0;
        char c = ' ';
        public Info(int start, int end, char c) {
            this.start = start;
            this.end = end;
            this.c = c;
        }
    }
    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int size = Integer.parseInt(br.readLine());
            String[] arr = new String[size];
            for (int i = 0; i < size; i++) {
                arr[i] = br.readLine();
            }
            br.close();

            solution(arr);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
    public static void solution(String[] arr) {
        /*
        각 문자별로
            전체 글자를 travers 한다.
            이떄 시작 글자와 같은 글자가 있으면
                스택에 저장해 둔다, start, end, 문자
                이때, 기존 스택에 쌓여있는 데이터 모두 겹쳐치 않아야 한다.
                만약 겹치는 것이 있으면 스택에서 해당 값을 제거한다,  모두 돌면서, start, end 가 겹치는 것이 있으면 삭제한다.

            남아있는 값들을 최총 스택에 저장한다.
        쌓여있는 최총 스택 중, c가 A/B 맞는것이 있으면 카운팅 한다,
        -> 넣을때마다 스택에 있는 데이터와 겹치지 않는것만 넣는다.
        ->> 처리시간 오류
        -> 솔루션을 본 후 새로운 방식 확인
        문제가 웃기긴 하지만, 원하는 질문은,
        테트리스 연속 타일 제거 처럼, 글자 2개가 붙어있으면 제거 시키고, 이가 연쇄적으로 처리 된다, 이것이 되면 되는것이다.
        -> 글자 처음부터, 스택에 넣는다.
            스택에 글자가 있으면
                가장 나중에 있는 값을 가져와서 현 글자와 비교 후
                    같다면 삭제(pop) 처리
                다르다면 push
            없으면 push
            스택 길이가 0이면 OK
        글자 연결이, 모두 감싸거나, 따로 떨어져 있거나
         */

        int rtn = 0;
        for (int i = 0; i < arr.length; i++) {
            if (isGood(arr[i])) {
                rtn++;
            }

        }
//        for (int i = 0; i < arr.length; i++) {
//            Stack<Info> each = getStr(arr[i]);
//            // 넣을떄 있는것만
//            // 스택 중 겹치는 것이 없는것만 남기기
//            // each = removeCrossing(each);
//
//            // A B 남기기, global 에 넘기기
//            countAB(each, global);
//        }
        //System.out.println(countAB(global));
        System.out.println(rtn);
    }

    public static boolean isGood(String word) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < word.length(); i++) {
            String c = String.valueOf(word.charAt(i));
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                String top = stack.peek();
                if (top.equals(c)) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static int countAB(Stack<Info> data) {

        boolean a = false;
        boolean b = false;
        while (!data.isEmpty()) {
            Info info = data.pop();
            if (info.c == 'A') {
                a = true;
            }
            if (info.c == 'B') {
                b = true;
            }
        }
        int rtn = 0;
        if (a) {
            rtn++;
        }
        if (b) {
            rtn++;
        }
        return rtn;
    }
    public static Stack<Info> countAB(Stack<Info> data, Stack<Info> global) {

        boolean a = false;
        boolean b = false;
        while (!data.isEmpty()) {
            Info info = data.pop();
            if (info.c == 'A') {
                a = true;
            }
            if (info.c == 'B') {
                b = true;
            }
        }
        if (a) {
            global.push(new Info(0, 0, 'A'));
        }
        if (b) {
            global.push(new Info(0, 0, 'B'));
        }
        return global;
    }

    public static Stack<Info> pushIfNotCross(Stack<Info> stack, Info info) {
        Stack<Info> rtn = new Stack<>();
        boolean isCross = false;
        while (!stack.isEmpty()) {
            Info each = stack.pop();
            if (info.end <= each.start
                        || info.start >= each.end) {
                rtn.push(each);
            } else {
                isCross = true;
            }
        }
        if (!isCross) {
            rtn.push(info);
        }
        return rtn;
    }

    public static Stack<Info> getStr(String str) {
        Stack<Info> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char charactor = str.charAt(i);

            for (int j = i+1; j < str.length(); j++) {
                char charComp = str.charAt(j);

                if (charactor == charComp) {
                    Info info = new Info(i, j, charactor);
                    stack = pushIfNotCross(stack, info);
                }
            }
        }
        return stack;
    }
}

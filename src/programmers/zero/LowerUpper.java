package programmers.zero;

import java.util.Scanner;

public class LowerUpper {
    public static void main(String[] args) {
        /*
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        StringBuffer resultSB = new StringBuffer(a);
        for (int i = 0; i < a.length(); i++) {
            String each;
            if (Character.isLowerCase(a.charAt(i))) {
                each = String.valueOf(Character.toUpperCase(a.charAt(i)));
            } else {
                each = String.valueOf(Character.toLowerCase(a.charAt(i)));
            }
            resultSB.replace(i, i+1, each);
        }
        System.out.println(resultSB);
        */
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String rtn = new String(a);
        //StringBuffer resultSB = new StringBuffer(a);
        for (int i = 0; i < a.length(); i++) {
            Character each;
            if (Character.isLowerCase(a.charAt(i))) {
                each = (Character.toUpperCase(a.charAt(i)));
            } else {
                each = (Character.toLowerCase(a.charAt(i)));
            }
            rtn = rtn.replace(String.valueOf(a.charAt(i)), String.valueOf(each));
        }
        //System.out.println("asdf".replace("a", "A"));
        System.out.println(rtn);

    }
}
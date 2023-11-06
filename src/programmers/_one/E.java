package programmers._one;

// 둘만의 암호

/*
"aukks"	"wbqd"	5	"happy"
z ab 1 "c"
z ab 27 "e"
 */
public class E {
    public static void main(String[] args) {

        solution("aukks", "wbqd", 5);
        solution("z", "ab", 1);
        solution("z", "ab", 27);
    }
    public static String solution(String s, String skip, int index) {
        String answer = "";
        /*
        s 각 문자를
            인덱스 만큼 증가 시킨 값을 저장한다.
            이때, skip에 걸린다면, 한번 더 증가 시킨다.
            z 다음은 a 이다.
        */
        for (int i = 0; i < s.length(); i++) {
            char eachC = s.charAt(i);

            // 인덱스 만큼 넘어간 값을 가져와서 저장한다.
            answer += getNextChar(eachC, index, skip);
        }

        return answer;
    }

    static String getNextChar(char eachC, int index, String skip) {
        int cnt = 1;
        char tmp = eachC;
        while (index >= cnt) {
            // 다음 문자 가져온다. 스킵에 포함 되면 카운드 증가 안한다

            tmp = getNextChar(tmp);
            if (! skip.contains( String.valueOf(tmp) )) {
                cnt++;
            }
        }
        return String.valueOf(tmp);
    }

    static char getNextChar(char tmp) {
        char rtn = (char)(tmp + 1);
        if (rtn > 'z') {
            rtn = 'a';
        }

        return rtn;
    }














    // old
    public static String solution_(String s, String skip, int index) {
        // 입력값을 건건이
        // index 만큼 더한 값을 가져온다.
        // 이때 skip 을 만나면 더 더한다.
        // 그리고 char 의 글자 오버랩을 주의한다.
        String answer = "";

        // abcde fgghij klmno pqrst uvwxy z
        // 전체 27개
        if (false) {

            System.out.println( overlap((char)('a'+26 )) );
            return null;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            char rtn = skipAndGetChar(c, skip, hashing(index));
            answer += String.valueOf(rtn);
        }

        return answer;
    }

    static int hashing(int index) {
        return index % 26;
    }

    static char skipAndGetChar(char c, String skip, int index) {
        int cntSub = 0;

        char rtn = c;
        while (index != cntSub) {

            rtn = (char)(rtn + 1);
            rtn = overlap(rtn);

            if (skip.contains(String.valueOf(rtn) )) {
            } else {
                cntSub++;
            }
        }
        return rtn;
    }

    static char overlap(char a) {
        if (a > 'z') {
            return (char)(a - ('z' - 'a') -1);
        } else {
            return a;
        }
    }

}

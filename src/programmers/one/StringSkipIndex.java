package programmers.one;

class StringSkipIndex {
    public String solution(String s, String skip, int index) {
        // 문자열 s 각각을
        // index 만큼 뒤의 알바벳으로 바꿈.
        // 이중 skip 에 포함된 알파벳은 제외함.
        //  따라서, skip 에 포함된 글자수 만큼 더함.
        //  (s[0] 에서 (s[0]+index) 까지 값중 skip 에 포함된것이 있는지 카운트
        //  한바퀴 도는 부분은 어디서 체크해야되나? 더할때?

        String[] arrString = new String[s.length()];

        char aString = 65 ;

        //System.out.println( String.valueOf( aString ) );
        //System.out.println( String.valueOf( (char)(65+1) ) );
        //System.out.println(getCntContainedSkip("wbqd", 'u', index) );


        for (int i = 0; i < s.length(); i++){
            char each = s.charAt(i);

            char result = (char)( each + index + getCntContainedSkip(skip, each, index)  );

            result = makeInChar(result);

            arrString[i] = String.valueOf(result);
        }

        return arrToString(arrString);
    }

    char makeInChar(char param) {
        if (param > 'z') {
            return (char)(param - ('z' - 'a' +1)); // ex 11 - 1 = 10, 12는? 12-10 = 2, -1 필요
        } else {
            return param;
        }
    }

    int getCntContainedSkip(String skip, char startChar, int index) {
        int skipped = 0;
        System.out.println(skip + "," + startChar + "," + index);

        // 문제는, 단순히 스킵에 걸리면, 해당 문자는 계속 신경 안쓰면 된다.

        for (int i = 1; i <= index; i++) {

            while (skip.contains( String.valueOf( makeInChar((char)( startChar + i + skipped )) ) ) ) {
                skipped++;
                System.out.println("while");
            }
            System.out.println("for end");
        }

        System.out.println(skipped + ":" + index);
        return skipped;
    }

    String arrToString(String[] arrString) {
        String rtn = "";
        for (int i = 0 ; i < arrString.length; i++) {
            rtn += arrString[i];
        }
        return rtn;
    }
}

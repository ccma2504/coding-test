package programmers._one;

import java.util.*;
//대충 만든 자판

/*
["ABACD", "BCEFD"]	["ABCD","AABB"]	[9, 4]
["AA"]	["B"]	[-1]
["AGZ", "BSSS"]	["ASA","BGZ"]	[4, 6]
 */
public class D {
    public static void main(String[] args) {

        solution(new String[] {"ABACD", "BCEFD"}, new String[] {"ABCD","AABB"});
        solution(new String[] {"AGZ", "BSSS"}, new String[] {"ASA","BGZ"});
        solution(new String[] {"AA"}, new String[] {"B"});
    }


    public static int[] solution(String[] keymap, String[] targets) {
        int[] answer = {};

//        타켓 각각의 문자를
//        문자열 하나씩 가져와서
//            키맵들 중 가장 작은 타이핑 수를 가져온다.
//
//            타이핑 수들을 더한다. (이때 특정 문자를 입력할수 없다면, 해당 타캣 결과를 -1로 한다 )

        int[] rtn = new int[targets.length];
        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];

            // 한 문자당 키맵 별 타이핑 수 가져오기.
            for (int j = 0; j < target.length(); j++) {
                char c = target.charAt(j);

                // 문자 하나에 키맵 별 타이핑 수
                Integer[] charTypeCnt = bindCharTypeCnt(keymap, c);
                Arrays.sort(charTypeCnt, (a, b) -> a - b);

                if (isAllMinus(charTypeCnt)) {
                    rtn[i] = -1;
                    break;
                }
                rtn[i] += getMinNotMinus(charTypeCnt);
            }
        }
        return rtn;
}

    static int getMinNotMinus(Integer[] charTypeCnt) {
        int rtn = -1;
        for (int i = 0; i < charTypeCnt.length; i++) {
            int each = charTypeCnt[i];
            if (each > -1) {
                rtn = each;
                break;
            }
        }
        return rtn;
    }

    static Integer[] bindCharTypeCnt(String[] keymap, char c) {
        // 키맵 사이즈 만큼의 어레이에 키맵 별 타이핑 수 가져온다.
        // 키맵 중 각 문자가 있다면 그 위치를 리턴. 디폴트는 -1
        Integer[] rtn = new Integer[keymap.length];
        for (int i = 0; i < keymap.length; i++) {
            String eachKeyMap = keymap[i];

            rtn[i] = -1;
            for (int j = 0; j < eachKeyMap.length(); j++) {
                char charOfKeymap = eachKeyMap.charAt(j);

                if (c == charOfKeymap) {
                    rtn[i] = j+1;
                    break;
                }
            }
        }
        return rtn;
    }

    static boolean isAllMinus(Integer[] rtn) {
        // 정렬되어 있기 때문에
        boolean value = false;
        if (rtn[rtn.length-1] == -1) {
            value = true;
        }
        return value;
    }
}

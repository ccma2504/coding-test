package programmers.one;

class KeyMapCheck {
    public int[] solution(String[] keymap, String[] targets) {

        // 입력값 처리
        // 키 맵을 일일이 루프 돌면서 찾아야 하기 때문에, 해시맵을 쓰자, 순서 변경 안되므로
        // ->일일이 해시맵을 쓰기에는 배열이 많아지므로 그냥 하자.
        // 타켓 글자 loop 돌면서, 키 맵을 하나씩 찾는다
        // 키맵중 가장 낮은 숫자를 찾아서, +1해서 결과에 더해준다.
        // 타켓은 n개 이기 때문에, 타켓 길이 로 가변이다. ??
        // 일단 해보자.

        // 전체

        // test
        //System.out.println(targets[0].charAt(0));
        //System.out.println(String.valueOf(targets[0].charAt(0)));

        //
        if (true) {
            //return testGetPressCnt("A", new String[] {"B"});
        }
        if (true) {
            //return new int[] {getMinNotZero(new int[] {0, 1})};
        }
        // 문제, 하나라도 없는 문자가 나오면 -1 이 나와야 하는데 그게 아님.
        // getPressCnt 에서 0은 문자가 없다는 뜻, 0 -> -1
        // += getPressCnt(char1, keymap); 부분에서 -1 이
        // 키맵 당 없는것이 있을수 있는데, 있는 어레이가 있다면 -1 처리 하면 안됨.
        // 글자당 {0, 1} 은 1,  {0, 0, 1}



        int[] rtn = new int[targets.length];
        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];

            for (int j = 0; j < target.length(); j++) {
                // 각 글자별 키 누르는 갯수 증분 처리

                String char1 = String.valueOf(target.charAt(j));

                int rtnEach = getPressCnt(char1, keymap);
                if (-1 == rtnEach) {
                    rtn[i] = -1;
                    break;
                } else {
                    rtn[i] += rtnEach;
                }
                //rtn[i] += getPressCnt(char1, keymap);
            }
        }

        return rtn;
    }

    int getPressCnt(String char1, String[] keymap) {
        // 해당 글자 가져오기
        // 전체 키맵 뒤지기.
        // 각 키맵 별 최소값 가져오기
        int[] rtn = new int[keymap.length];
        for (int i = 0; i < keymap.length; i++) {
            String each = keymap[i];

            for (int j = 0; j < each.length(); j++) {

                String charNow = String.valueOf(each.charAt(j));
                if (char1.equals(charNow)) {
                    rtn[i] = j+1;
                    break;
                }
            }
        }

        return getMinNotZero(rtn);
    }

    int getMinNotZero(int[] param) {
        int min = -1;

        for (int i = 0; i < param.length; i++) {
            int each = param[i];

            if (each != 0 && ( min == -1 || min > each ) ) {
                min = each;
            }
        }
        // ?? 없으면 -1 잘 되나?
        return min;
    }

    int[] testGetPressCnt(String char1, String[] keymap) {
        // 해당 글자 가져오기
        // 전체 키맵 뒤지기.
        // 각 키맵 별 최소값 가져오기
        int[] rtn = new int[keymap.length];
        for (int i = 0; i < keymap.length; i++) {
            String each = keymap[i];

            for (int j = 0; j < each.length(); j++) {

                String charNow = String.valueOf(each.charAt(j));
                //System.out.println(charNow);
                if (char1.equals(charNow)) {
                    rtn[i] = j+1;
                    break;
                }
            }
        }

        return rtn;
    }
}
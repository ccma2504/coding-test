package programmers.zero;

class StringOverrite {
    public String solution(String my_string, String overwrite_string, int s) {
        // my_string 에서 s 위치부터 overwrite값을 붙여넣고 나머지는 원글짜 그대로 씀
        //

        //for (int i = 0; i < )

        //System.out.println("abcd".substring(start,end));
        //String pre = my_string.substring(s, s+overwrite_string.length());
        //System.out.println("abcde".substring(6));
        String pre = my_string.substring(0, s);
        String pre_wr = pre + overwrite_string;

        // 만약 s + overwrite_string 길이가 my_string 를 넘어가면

        String end = my_string.substring(s + overwrite_string.length());

        //System.out.println(end);

        String answer = pre_wr + end;
        return answer;
    }
}

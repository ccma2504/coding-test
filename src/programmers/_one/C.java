package programmers._one;
// 바탕화면 정리

/*

[".#...", "..#..", "...#."]	[0, 1, 3, 4]
["..........", ".....#....", "......##..", "...##.....", "....#....."]	[1, 3, 5, 8]
[".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."]	[0, 0, 7, 9]
["..", "#."]	[1, 0, 2, 1]

 */
public class C {
    public static void main(String[] args) {

        solution(new String[] {".#...", "..#..", "...#."});
        solution(new String[] {"..........", ".....#....", "......##..", "...##.....", "....#....."});
        solution(new String[] {".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."});
        solution(new String[] {"..", "#."});
    }

    public static int[] solution(String[] wallpaper) {
        int[] answer = {};

        int[] posStart = {wallpaper.length-1, wallpaper[0].length()-1};
        int[] posEnd = {0, 0};

        // 최 상단
        for (int i = wallpaper.length-1; i >= 0; i--) {
            String each = wallpaper[i];

            if (each.contains("#")) {
                if (posStart[0] > i) {
                    posStart[0] = i;
                }

                for (int j = each.length()-1; j >= 0; j--) {
                    char c = each.charAt(j);
                    if (c == '#') {
                        if (posStart[1] > j) {
                            posStart[1] = j;
                        }
                    }
                }
            }
        }

        // 최 하단
        for (int i = 0; i < wallpaper.length; i++) {
            String each = wallpaper[i];

            if (each.contains("#")) {
                if (posEnd[0] < i) {
                    posEnd[0] = i;
                }

                for (int j = 0; j < each.length(); j++) {
                    char c = each.charAt(j);
                    if (c == '#') {
                        if (posEnd[1] < j) {
                            posEnd[1] = j;
                        }
                    }
                }
            }
        }

        return new int[] {posStart[0], posStart[1], posEnd[0]+1, posEnd[1]+1};
    }
}

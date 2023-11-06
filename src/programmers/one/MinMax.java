package programmers.one;

/*

wallpaper	result
[".#...", "..#..", "...#."]	[0, 1, 3, 4]
["..........", ".....#....", "......##..", "...##.....", "....#....."]	[1, 3, 5, 8]
[".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."]	[0, 0, 7, 9]
["..", "#."]	[1, 0, 2, 1]
 */
class MinMax {
    public int[] solution(String[] wallpaper) {
        int[] answer = {};

        // 전체 h, w 구하기

        // #최초 시작점 h_s, w_s
        // # 최대 시작점 h_e, h_e 구하기
        // 리턴

        // 최초 h_s
        int h_s = 0;
        for (int i = 0; i < wallpaper.length; i++) {
            String each = wallpaper[i];
            int pos = each.indexOf("#");
            if (pos > -1) {
                h_s = i;
                break;
            }
        }

        int h_e = 0;
        for (int i = wallpaper.length-1; i >= 0; i--) {
            String each = wallpaper[i];
            int pos = each.indexOf("#");
            if (pos > -1) {
                h_e = i;
                break;
            }
        }

        int w_s = wallpaper[0].length();
        for (int i = 0; i < wallpaper.length; i++) {
            String each = wallpaper[i];
            int pos = each.indexOf("#");
            if (pos > -1 && pos < w_s) {
                w_s = pos;
            }
        }

        int w_e = 0;
        for (int i = wallpaper.length-1; i >= 0; i--) {
            String each = wallpaper[i];
            int pos = each.lastIndexOf("#");
            if (pos > -1 && ( pos > w_e )) {
                w_e = pos;
            }
        }
        return new int[] {h_s, w_s, h_e+1, w_e+1};
    }
}
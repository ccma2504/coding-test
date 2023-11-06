package dongbinan;

/*
팩토리얼 구현 n! = 1 * 2 * .. * (n-1) * n
 */
public class Recusive {

    public static void main(String[] args) {

        int result = factorial(10);
        System.out.println(result);
    }

    static int factorial(int num) {
        if (num == 1) {
            System.out.println(1);
            return 1;
        }
        int rtn = factorial(num - 1) * num;
        System.out.println(rtn);
        return rtn;
    }
}

package etc;

public class SortQuick {
   /*
   O(N LogN), N 곱하기 절반씩 줄어든 것을 곱
   피봇을 이동해 가며 정렬
   분활과 정복 과정

   피봇은 어레이 중간의 값으로 함.
   피봇값을 기준으로 작은것은 왼쪽으로, 큰것은 오른쪽으로 함.

   가운데 피봇 기준, start, end 값을 각각 증가, 감소 시키면서
   피봇 값보다 정렬이 안맞는 값이 있으면 왼쪽과 오른쪽을 스왑한다.
   이때 start <= end 조건이 맞을때까지 한다.
   리턴되는 피봇값은 마지막 스왑 후 +1 이 된다.

   이른 기반으로 다시, 제귀 호출 하는데, 피봇 기준 왼쪽과 오른쪽으로 배열을 나눠 제귀 처리 한다.

70, 20, 50, 10, 30, 40 | 50,
40, 20, 50, 10, 30, 70 | 50, 0 5
40, 20, 30, 10, 50, 70 | 50, 2 4
return 4
0, 3
4, 5

40, 20, 30, 10           | 20,
10, 20, 30, 40,          | 20
10, 20, 30, 40,          | 20
return 2

20, 40, 50, 10, 30, 70 | 30,
20, 40, 50, 10, 30, 70 | 30,

    */
   public static void main(String[] args) {
       int[] arr = {70, 20, 50, 10, 30, 40};


       for (int i = 0; i < arr.length; i++) {
           System.out.print(" " + arr[i]);
       }
       System.out.println(" ");

       quickSort(arr, 0, arr.length-1);
   }

   public static void quickSort(int[] arr, int start, int end) {
       int part2 = partition(arr, start, end);
       if (start < part2 - 1) {
           quickSort(arr, start, part2 - 1);
       }
       if (part2 < end) {
           quickSort(arr, part2, end);
       }
   }

    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[(start + end) / 2];

        System.out.println(" " + pivot + " " + start + "," + end) ;


        while (start <= end) {
            while (arr[start] < pivot) start++;
            while (arr[end] > pivot) end--;
            if (start <= end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        return start;
    }





    /* 망
    피봇을 이동해 가며 정렬
    분활과 정복 과정

    피봇 위치 선정(오른쪽 or 가운데 등)
    맨 오른쪽 값을 피봇으로 잡고
    피봇 위치보다 낮은 어레이의 값을 순차로 비교하면 옮긴다. (j)
        피봇 값보다 작으면 i증가 시키고 j 위치와 스왑 한다.
        목표는, 피봇 값보다 작은것을 왼쪽에 둔다.
    마지막으로, 피봇과 i+1 값을 스왑 하여, 피봇값 왼쪽은 작은값, 오른쪽은 큰값으로 한다.
    이때 각 왼쪽과 오른쪽 값들은 정렬이 된것은 아니다.

    partition 함수 호출시, 피봇된 값의 위치가 정해진다.

    왼쪽 오른쪽을 각각 제귀로 소팅한다.

    70, 20, 50, 10, 30, 40  //40 보다 작을때 스왑 로직
    20, 70, 50, 10, 30, 40
    20, 10, 30, 70, 50, 40
    20, 10, 30, 40, 50, 70

    20, 10, 30, 40, 50, 70
    20, 70, 10, 30, 40, 50
     */


    static void quickSort_(int[] arr, int l, int r) {
        if (l < r) {
            int p = partition_(arr, l, r);

            quickSort_(arr, l, p - 1);
            quickSort_(arr, p + 1, r);
        }
    }

    static int partition_(int[] arr, int l, int r) {
        int pivot = arr[r];
        int i = l - 1;

        for (int j = l; j < r-1; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, r);

        return (i + 1);
    }

    static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;

        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
        System.out.println(" ");
    }
}

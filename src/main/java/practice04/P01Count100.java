package practice04;

/**
 * Created by xuweiman on 16/4/28.
 * for 和 foreach实现
 */

public class P01Count100 {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; ++i) {
            System.out.print(i + " ");
        }
        System.out.println();
        for(int i: Ranger.range(1, 101)) {
            System.out.print(i + " ");
        }


        //消除ide的警告
        Ranger.range(100);

    }
}


class Ranger {
    private static int[] range(int start, int end, int step) {
        if ((step > 0 && end < start)||(step<0 && end > start)) {
            int temp = start;
            start = end;
            end = temp;
        }

        int[] result = new int[end - start];
        for (int i = start, j = 0; i <= end && j < end - start; i += step, ++j) {
            result[j] = i;
        }
        return result;
    }

    static int[] range(int start, int end) {
        return range(start, end, 1);
    }

    static int[] range(int num) {
        return range(0, num);
    }
}

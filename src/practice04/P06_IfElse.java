package practice04;

/**
 * Created by xuweiman on 16/4/30.
 * 使用 if  else
 */
public class P06_IfElse {
    private static int test(int testval, int target) {
        if (testval > target) {
            return 1;
        } else if (testval < target) {
            return -1;
        } else {
            return 0;
        }
    }

    private static boolean test(int testval, int begin, int end) {
        return (testval >= begin && testval <= end);
    }

    public static void main(String[] args) {
        System.out.println(test(1, 199));
        System.out.println(test(20, 1, 199));
    }
}

package practice04;

/**
 * Created by xuweiman on 16/4/30.
 * 斐波那契数列
 */
public class P09_Fibonacci {
    private static long[] getFibonacciArray(int count) {
        if(count <= 0) {
            System.out.println("请输入正整数,以确定返回的斐波那契数列数值的个数");
            return new long[1];
        } else {
            long[] fibonacci = new long[count];
            fibonacci[0] = 1;
            if(count >=2) {
                fibonacci[1] = 1;
                for(int i=2; i<count; ++i) {
                    fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
                }
            }
            return fibonacci;
        }
    }

    public static void main(String[] args) {
        for(long f: getFibonacciArray(25)) {
            System.out.print(f + " ");
        }
    }
}

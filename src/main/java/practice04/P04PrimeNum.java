package practice04;


/**
 * Created by xuweiman on 16/4/28.
 * 两个for循环查找质数, 循环1K次的情况下, printPrimeNum_GoodWay2方法效率较高.
 */
public class P04PrimeNum {
    private static void printPrimeNum() {
        System.out.print(2 + " ");
        System.out.print(3 + " ");
        for (int num = 5; num < 100; num += 2) {
            boolean is_prime = true;
            // i * i 一定要 <= num, 还可以优化:避免所有偶数,一个素数一定不能被小于他的素数整除, 一个非素数一定有素数因
            for (int i = 2; i * i <= num; ++i) {
                if (num % i == 0) {
                    is_prime = false;
                    break;
                }
            }
            if (is_prime) {  // 打印素数
                System.out.print(num + " ");
            }
        }
    }

    private static void printPrimeNum_GoodWay() {
        int max = 100;
        int[] p_options = new int[max];
        int p_index = 2;
        p_options[0] = 2;
        p_options[1] = 3;
        for (int p = 5; p <= max; p += 2) {  // 生成素数
            boolean is_prime = true;
            for (int i = 0; p_options[i] * p_options[i] <= p; i++) {
                if (p % p_options[i] == 0) {
                    is_prime = false;
                    break;
                }
            }
            if (is_prime) {
                p_options[p_index] = p;
                ++p_index;
            }

        }

//        for (int prime : p_options) {  // 打印素数
//            if (prime != 0) {
//                System.out.print(prime + " ");
//            }
//        }

        for (int i=0; i<p_index; ++i) {  // 打印素数,避免没有被填充的数组框被打印
            System.out.print(p_options[i] + " ");
        }
    }

    private static void printPrimeNum_GoodWay2() {
        int max = 100;
        //int limit = (int)floor(sqrt(max));  // 这里貌似会丢失掉挺多效率
        boolean[] primes = new boolean[max + 1];
        System.out.print(2 + " ");
        for (int i = 3; i * i <= max; i += 2) {  // 生成素数
            if (!primes[i]) {
                for (int j = 2 * i; j <= max; j += i) {
                    primes[j] = true;  // 将所有能被素数整除的下标,对应的数组值设置为true
                }
            }
        }

        for (int i = 3; i <= max; i += 2) {  // 打印素数
            if (!primes[i]) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        long x_time = System.currentTimeMillis();
        for (int i = 0; i < 2000; ++i) {
            printPrimeNum();
            //System.out.println();
        }
        System.out.println(System.currentTimeMillis() - x_time);

        x_time = System.currentTimeMillis();
        for (int i = 0; i < 2000; ++i) {
            printPrimeNum_GoodWay();
            //System.out.println();
        }
        System.out.println(System.currentTimeMillis() - x_time);

        x_time = System.currentTimeMillis();
        for (int i = 0; i < 2000; ++i) {
            printPrimeNum_GoodWay2();
            //System.out.println();
        }
        System.out.println(System.currentTimeMillis() - x_time);
    }
}

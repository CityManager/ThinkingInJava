package practice04;

/**
 * Created by xuweiman on 16/4/30.
 * 吸血鬼数字, 偶位数字刚好能够由两个一半数位的数相乘得到, 且等号两边出现一样的数字(次序可以不一致)
 * 比如: 1260 = 21 * 60
 */
public class P10_VampireNumber {
    private static void findVampireNum_4() {
        for (int divisor1 = 10; divisor1 <= 99; ++divisor1) {
            for (int divisor2 = 10; divisor2 <= 99; ++divisor2) {  // 列出所有两位数, 逐个匹配其乘积
                int mul_num = divisor1 * divisor2;
                if (mul_num < 1000) {
                    continue;
                }

                int[] candidate = new int[4];  // 组装乘积到 候选数组
                int temp = mul_num;
                for (int i = 0; i < 4; ++i) {
                    candidate[i] = temp % 10;
                    temp = temp / 10;
                }

                int[] reference = new int[4];  // 组装两个因数到 参考数组
                reference[0] = divisor1 / 10;
                reference[1] = divisor1 % 10;
                reference[2] = divisor2 / 10;
                reference[3] = divisor2 % 10;

                int count = 0;
                for (int id_c = 0; id_c < 4; ++id_c) {  // 开始匹配 参考数组 与 候选数组
                    for (int id_r = 0; id_r < 4; ++id_r) {
                        if (candidate[id_c] == reference[id_r]) {
                            ++count;
                            candidate[id_c] = -1;  // -1与-2 没有什么特殊意义, 用于避免已经匹配的下标重复被匹配
                            reference[id_r] = -2;
                        }
                    }
                }
                if (count == 4) {  // 计数为4, 表示 参考数组与候选数组匹配. 输出结果
                    System.out.println(mul_num + " = " + divisor1 + " * " + divisor2);
                }
            }
        }
    }

    private static void findVampireNumber_N(int digits) {
        if (digits % 2 != 0) {
            System.out.println("请传入整型偶数参数, 谢谢.");
            return;
        }
        int up_ary = 10;
        int min_divisor = 1;
        int max_divisor = 9;
        for (int i = 2; i <= digits / 2; ++i) {
            up_ary *= 10;
            min_divisor *= 10;
            max_divisor = max_divisor * 10 + 9;
        }
        int min_ary = up_ary * up_ary / 10;
        // 列出所有可能的因数, 逐个匹配其乘积
        for (int divisor1 = min_divisor; divisor1 <= max_divisor; ++divisor1) {
            for (int divisor2 = min_divisor; divisor2 <= max_divisor; ++divisor2) {
                int mul_num = divisor1 * divisor2;
                if (mul_num < min_ary) {  // 抛弃所有不足位数的积
                    continue;
                }

                int[] candidate = new int[digits];  // 组装乘积到 候选数组
                int temp = mul_num;
                for (int i = 0; i < digits; ++i) {
                    candidate[i] = temp % 10;
                    temp = temp / 10;
                }

                int[] reference = new int[digits];  // 组装两个因数到 参考数组
                temp = divisor1 * up_ary + divisor2;
                for (int i = 0; i < digits; ++i) {
                    reference[i] = temp % 10;
                    temp = temp / 10;
                }

                int count = 0;
                for (int id_c = 0; id_c < digits; ++id_c) {  // 开始匹配 参考数组 与 候选数组
                    for (int id_r = 0; id_r < digits; ++id_r) {
                        if (candidate[id_c] == reference[id_r]) {
                            ++count;
                            candidate[id_c] = -1;  // -1 与 -2 没有什么特殊意义, 只是用于避免已经匹配的下标重复被匹配
                            reference[id_r] = -2;
                        }
                    }
                }
                if (count == digits) {  // 计数为digits, 表示 参考数组与候选数组匹配. 输出结果
                    System.out.println(mul_num + " = " + divisor1 + " * " + divisor2);
                }
            }
        }
    }

    public static void main(String[] args) {
        findVampireNum_4();
        System.out.println("=========");
        findVampireNumber_N(4);
        System.out.println("=========");
        findVampireNumber_N(6);
    }
}

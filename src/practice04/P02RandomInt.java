package practice04;

import java.util.Random;

/**
 * Created by xuweiman on 16/4/29.
 * 生成25个int类型的随机数
 */
public class P02RandomInt {
    public static void main(String[] args) {
        Random random = new Random(47);
        for(int i=0; i<25; ++i) {
            int random_int1 = random.nextInt();
            int random_int2 = random.nextInt();
            if (random_int1 > random_int2) {
                System.out.println(random_int1 + " 大于 " + random_int2);
            } else if(random_int1 == random_int2) {
                System.out.println(random_int1 + " 等于 " + random_int2);
            } else {
                System.out.println(random_int1 + " 小于 " + random_int2);
            }
        }
    }
}

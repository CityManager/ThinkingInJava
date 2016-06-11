package practice09;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by xuweiman on 16/6/4.
 * 字符数组生成与适配Readable,使 Scanner 能够读取
 * 抄袭了答案
 */
public class P16_CharArray_ReadableAdapter {
    public static void main(String... args) {
        Scanner s = new Scanner(new CharArrayAdapter(10));
        while (s.hasNext()) {
            System.out.println(s.next());
        }
    }
}

class CharArrayGenerator {
    private static Random random = new Random(47);
    private static final char[] CAPITALS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final char[] LOWERS = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public char[] generate() {
        char[] chars = new char[10];
        int index = 0;
        chars[index++] = CAPITALS[random.nextInt(CAPITALS.length)];
        for (int i = 0; i < 8; ++i) {
            chars[index++] = LOWERS[random.nextInt(LOWERS.length)];
        }

        chars[index] = ' ';

        return chars;
    }
}


class CharArrayAdapter implements Readable {  // 可以直接继承自CharArrayGenerator,也可以使用组合
    private int count;
    private CharArrayGenerator charArrayGenerator;

    CharArrayAdapter(int count) {
        this.count = count;
        this.charArrayGenerator = new CharArrayGenerator();
    }

    public int read(CharBuffer cb) throws IOException {
        if (count-- == 0)
            return -1;
        char[] chars = charArrayGenerator.generate();
        cb.put(chars);
        return cb.length();
    }
}

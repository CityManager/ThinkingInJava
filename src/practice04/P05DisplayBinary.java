package practice04;

/**
 * Created by xuweiman on 16/4/29.
 * 使用三元操作符合按位操作符显示二进制的1和0
 */
public class P05DisplayBinary {
    /**
     * 打印int类型数值的二进制值, 实现方法:
     * 数值与0x01按位与后可以确定最后一位是0还是1;
     * >>> 二进制值向右移动一位(顶位补充0,末位截掉1位)
     * @param i int类型数值
     */
    private static void toBinaryString(int i) {
        char[] buffer = new char[32];
        int b_index = 32;
        /* 可以使用 Integer.toBinaryString(int i) 实现*/
        do {  // 完成int数值到二进制符号的转换
            buffer[--b_index] = ((i & 0x01) == 0) ? '0' : '1';  // --b_index 先计算值, 此处要倒序着填充
            i >>>= 1;
        } while (i != 0);

        for (int j = b_index; j<32; ++j) {  // 打印二进制符号,避免没有被填充的数组框被打印
            System.out.print(buffer[j]);
        }
    }

    public static void main(String[] args) {
        int i1 = 0xaaaaaaaa;
        int i2 = 0x55555555;
        System.out.print("i1 = ");  toBinaryString(i1);
        System.out.println();
        System.out.print("i2 = ");  toBinaryString(i2);
        System.out.println();
        System.out.print("~i1 = ");  toBinaryString(~i1);
        System.out.println();
        System.out.print("~i2 = ");  toBinaryString(~i2);
        System.out.println();
        System.out.print("i1 & i1 = ");  toBinaryString(i1 & i1);
        System.out.println();
        System.out.print("i1 | i1 = ");  toBinaryString(i1 | i1);
        System.out.println();
        System.out.print("i1 ^ i1 = ");  toBinaryString(i1 ^ i1);
        System.out.println();
        System.out.print("i1 & i2 = ");  toBinaryString(i1 & i2);
        System.out.println();
        System.out.print("i1 | i2 = ");  toBinaryString(i1 | i2);
        System.out.println();
        System.out.print("i1 ^ i2 = ");  toBinaryString(i1 ^ i2);
        System.out.println();
    }
}

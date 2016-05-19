package practice05;

/**
 * Created by xuweiman on 16/5/3.
 * 将main函数换成可选参数的形式,而不是String数组作为参数的形式.
 */
public class P20_VarArgsMain {
    public static void main(String... args) {
        for (String arg : args) {
            System.out.print(arg + " ");
        }
    }
}

package practice05;

/**
 * Created by xuweiman on 16/5/1.
 * 没有被初始化的字符串是否为 null
 */
public class P01_UnInitializeString {
    private String unString;

    public static void main(String[] args) {
        P01_UnInitializeString unInitializeString = new P01_UnInitializeString();
        System.out.println(unInitializeString.unString == null);
    }
}

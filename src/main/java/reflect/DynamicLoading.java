package reflect;

/**
 * Created by xuweiman on 16/8/2.
 * 利用反射 进行类的动态加载, 有利于程序扩展, 本例子涉及
 * 类: DynamicLoading, PDFDocument
 * 接口: Printable
 */
public class DynamicLoading {
    public static void main(String... args) {
        System.out.println(args[0]);

        try {
            Class c = Class.forName(args[0]);
            Printable printable = (Printable)c.newInstance();
            printable.print();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// 可以使用 java DynamicLoading reflect.PDFDocument  运行, 而无需察觉 PDFDocument 这个类的存在,只有在运行时才会检查

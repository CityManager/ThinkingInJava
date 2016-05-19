package practice05;

/**
 * Created by xuweiman on 16/5/1.
 * 多个重载的构造器中,使用this实现在构造器中调用其他构造器
 */
public class P09_Overload_This {
    private int number = 1024;
    private P09_Overload_This() {
        System.out.println("使用默认构造器");
    }

    private P09_Overload_This(int age) {
        this();
        System.out.print("--");
        System.out.println("使用整型参数构造器: " + age);
    }

    // 要在构造器的第一行就调用其他构造器,
    // 因为追溯到第一个被调用的构造器上,该对象已经实例化,后续只是对该实例补充初始化操作 -- 后记,是否构造函数执行前对象已经被实例化?
    private P09_Overload_This(String name) {
        this(28);
        System.out.print("--");
        System.out.println("使用字符串参数构造器: " + name);
    }

    public static void main(String[] args) {
        P09_Overload_This p = new P09_Overload_This("Ha he");
        System.out.println(p.number);
    }
}

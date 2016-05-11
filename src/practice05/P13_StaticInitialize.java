package practice05;

/**
 * Created by xuweiman on 16/5/3.
 * 静态对象可以直接视为类的成员(相对于对类的属性,在python中的说法),
 * 首次通过类对其进行访问 或者 首个类对象实例创建时,
 * 静态对象会被初始化
 */
public class P13_StaticInitialize {
    public static void main(String[] args) {
        System.out.println("Inside main()");
        Cups.cup1.f(99);
        System.out.println("Inside main()");
    }
    static Cups cups1 = new Cups();
    static Cups cups2 = new Cups();  // 注释掉 本行再执行试试:静态变量的初始化取决于何时被首次访问到.
}

class Cup {
    private int marker;

    Cup(int marker) {
        this.marker = marker;
        System.out.println("Cup(" + this.marker + ")");
    }

    void f(int number) {
        System.out.println("Cup(" + this.marker + ").f(" + number + ")");
    }
}

class Cups {
    static Cup cup1;
    private static Cup cup2;
    static {
        cup1 = new Cup(1);
        cup2 = new Cup(2);
    }

    private Cup cup3;
    {
        cup3 = new Cup(3);  // 每次创建实例时,cup3都会被初始化,不像静态对象(只被初始化一次)
    }

    Cups() {
        System.out.println("Cups()");
    }
}

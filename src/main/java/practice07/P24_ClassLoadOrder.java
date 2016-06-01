package practice07;

/**
 * Created by xuweiman on 16/5/21.
 * 学习类的加载顺序:
 * 1、加载基类,初始化类静态变量与静态方法;
 * 2、加载目标类,初始化目标类的静态变量和静态方法;
 * 3、实例化基类, 并初始化基类实例的成员变量;
 * 4、调用基类的构造方法(如果目标类构造方法中没有指明基类构造方法的话,调用默认构造方法);
 * 5、实例化目标类,并初始化目标类实例的成员变量;
 * 6、调用初始化类的构造方法;
 * 7、完成(备注:类的加载整个程序生命周期中只会加载一次)。
 */
public class P24_ClassLoadOrder {

    public static void main(String... args) {
        //System.out.println(Dung.DUNG);
        System.out.println("开始实例化");
        Dung dung = new Dung();
        Uang uang = new Uang();
    }

}


class Insect {
    public static int printInit(String str) {
        System.out.println(str);
        return 1;
    }
    private static final int INSECT = Insect.printInit("Insect 类已经被加载,开始初始化类的静态变量--INSECT");

    private int test_attribute = Insect.printInit("Insect 实例的普通成员变量初始化");

    private int id = 100;

    Insect() {
        System.out.println("Insect 实例开始初始化"+ id);
    }

    Insect(int id) {
        this.id = id;
        System.out.println("Insect 实例开始初始化,非默认方法:"+ this.id);
    }
}


class Beetle extends Insect {
    private static final int BEETLE = Insect.printInit("Beetle 类已经被加载,开始初始化类的静态变量--BEETLE");

    private int id = 101;

    private int test_attribute = Insect.printInit("Beetle 实例的普通成员变量初始化");

    Beetle() {
        super(1101);
        System.out.println("Beetle 实例开始初始化" + id);
    }

    Beetle(String name) {
        System.out.println("Beetle 实例开始初始化" + id + " name:" + name);
    }
}


class Dung extends Beetle {
    public static final int DUNG = Insect.printInit("Dung 类已经被加载,开始初始化类的静态变量--DUNG");

    private int id = 102;

    Dung() {
        super("Dung");
        System.out.println("Dung 实例开始初始化" + id);
    }
}


class Uang extends Beetle {
    public static final int UANG = Insect.printInit("Uang 类已经被加载,开始初始化类的静态变量--UANG");

    private int id = 103;

    Uang() {
        super();
        System.out.println("Uang 实例开始初始化" + id);
    }
}

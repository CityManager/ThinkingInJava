package practice07;

/**
 * Created by xuweiman on 16/5/21.
 * 学习类的加载顺序
 */
public class P24_ClassLoadOrder {

    public static void main(String... args) {
        System.out.println(Dung.DUNG);
        System.out.println("开始实例化");
        Dung dung = new Dung();
    }

}


class Insect {
    public static int printInit(String str) {
        System.out.println(str);
        return 1;
    }
    private static final int INSECT = Insect.printInit("Insect 类已经被加载,开始初始化类的静态变量--INSECT");


    private int id = 100;

    Insect() {
        System.out.println("Insect 实例开始初始化"+ id);
    }
}


class Beetle extends Insect {
    private static final int BEETLE = Insect.printInit("Beetle 类已经被加载,开始初始化类的静态变量--BEETLE");

    private int id = 101;

    Beetle() {
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
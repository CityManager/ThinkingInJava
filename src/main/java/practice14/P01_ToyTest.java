package practice14;

/**
 * Created by xuweiman on 16/7/26.
 * Thinking in Java 第十四章习题1
 * 类如果没有显示声明默认构造器,则通过类对象的getInstance()方法无法实例化类的实例
 *
 */
public class P01_ToyTest {
    static void printInfo(Class cc) {
        System.out.println("====================");
        System.out.println("完整类名: " + cc.getName() + " is interface? [" + cc.isInterface() + "]");
        System.out.println("简单类名: " + cc.getSimpleName());
        System.out.println("Canonical name: " + cc.getCanonicalName());
        System.out.println("====================");
    }

    public static void main(String... args) {
        Class c = null;
        try {
            c = Class.forName("practice14.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("Can't find FancyToy");
            System.exit(-1);
        }
        printInfo(c);
        for(Class face: c.getInterfaces()) {
            printInfo(face);
        }

        Class up = c.getSuperclass();
        printInfo(up);
        Object o = null;
        try {
            o = up.newInstance();
        } catch (InstantiationException e) {
            System.out.println("无法实例化");
            System.exit(-1);
        } catch (IllegalAccessException e) {
            System.out.println("Cannot access");
            System.exit(-1);
        }

        printInfo(o.getClass());


        // 下面是一些泛型的内容
        /*Class<FancyToy> ftClass = FancyToy.class;
        // Class<Toy> tClass = ftClass.getSuperclass();  // 编译不通过
        Class<? super FancyToy> tClass = ftClass.getSuperclass();
        try {
            Object obj = tClass.newInstance();   // <? super FancyToy> 修饰的类,newInstance时只能是Object
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }*/

    }
}

interface HasBatteries {}
interface Waterproof{}
interface Shoots{}

class Toy {
    // Toy() {}  // 注释掉默认构造器, 则无法通过 class.newInstance() 方法创建实例
    Toy(int i) {}
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots {
    FancyToy() {
        super(1);
    }
}
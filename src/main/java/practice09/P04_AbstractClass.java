package practice09;

/**
 * Created by xuweiman on 16/6/4.
 * 抽象类使用
 * 抽象类:内部能够包含抽象方法, 抽象方法在非抽象子类中必须被实现
 * 作用: 将类的抽象性明确,便于对子类的使用起指导作用
 */
public class P04_AbstractClass {
    public static void haveToBeDownCasted(AbstractClass a) {
        ((ExtendsClass) a).addMethod();
    }

    public static void main(String... args) {
        haveToBeDownCasted(new ExtendsClass());
    }
}

abstract class AbstractClass {}

class ExtendsClass extends AbstractClass {
    public void addMethod() {
        System.out.println("ExtendsClass's method which AbstractClass does not own.");
    }
}
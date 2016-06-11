package practice09;

/**
 * Created by xuweiman on 16/6/4.
 * 类无法使用多重继承,但是接口可以
 */
public class P13_InterfaceMultipleInherit {
    public static void main(String... args) {
        TestObject t = new TestObject();
        t.doFin();
    }
}

interface BasicInterface{
    void test();
}

interface SubOneInterface extends BasicInterface {
    void doSubOne();
}

interface SubTwoInterface extends BasicInterface {
    void doSubTwo();
}

interface FinInterface extends SubOneInterface, SubTwoInterface {
    void test();
    void doFin();
}

class TestObject implements FinInterface {
    public void doFin() {
        System.out.println("doFin");
        doSubOne();
        doSubTwo();
        test();
    }

    public void doSubOne() {
        System.out.println("doSubOne");
    }

    public void doSubTwo() {
        System.out.println("doSubTwo");
    }

    public void test() {
        System.out.println("test");
    }
}

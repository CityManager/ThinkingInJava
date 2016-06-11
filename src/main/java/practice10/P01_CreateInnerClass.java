package practice10;

import practice05.P09_Overload_This;

/**
 * Created by xuweiman on 16/6/11.
 * 练习创建内部类:
 * 普通内部类无法拥有静态变量和静态方法
 * 静态内部类可以则可以拥有
 *
 * 内部类拥有外部类所有成员的访问权限
 *
 *
 */
public class P01_CreateInnerClass {
    private static long inner_count = 0;

    private Inner getInner() {
        return new Inner();
    }

    class Inner {
        //public static long count = 0;
        private long id = inner_count++;
        @Override
        public String toString() {
            return "I'm Inner class," + id;
        }
    }

    public static void main(String... args) {
        P01_CreateInnerClass outer = new P01_CreateInnerClass();
        P01_CreateInnerClass.Inner inner = outer.getInner();
        P01_CreateInnerClass.Inner inner2 = outer.new Inner();  // 实例化内部类 必须使用外部类实例的new关键字
        System.out.println(inner);
        System.out.println(inner2);
    }
}

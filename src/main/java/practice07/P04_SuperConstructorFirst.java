package practice07;

/**
 * Created by xuweiman on 16/5/19.
 * 测试继承中父类构造器是否会比子类构造器方法先被调用
 */
public class P04_SuperConstructorFirst extends ParentClass {
    // 不手工创建构造器,检查java是否会自动合成一个构造器

    public static void main(String... args) {
        P04_SuperConstructorFirst superConstructorFirst = new P04_SuperConstructorFirst();
        System.out.println(superConstructorFirst.getClass());
    }
}

class ParentClass extends GrandParentClass {
    public ParentClass() {
        System.out.println("ParentClass Constructor is called.");
    }
}

class GrandParentClass {
    public GrandParentClass() {
        System.out.println("GrandParentClass Constructor is called.");
    }
}

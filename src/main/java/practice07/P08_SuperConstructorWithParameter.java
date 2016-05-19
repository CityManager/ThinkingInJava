package practice07;

/**
 * Created by xuweiman on 16/5/19.
 * 继承带参数构造的父类
 */
public class P08_SuperConstructorWithParameter extends BaseObject {
    private String title;
    public P08_SuperConstructorWithParameter() {
        super("Ha");
    }

    public P08_SuperConstructorWithParameter(String title) {
        this();
        this.title = title;
    }

    public P08_SuperConstructorWithParameter(String name, String title) {
        super(name);
        this.title = title;
        System.out.println(name + "--" + title);
    }

    public static void main(String[] args) {
        new P08_SuperConstructorWithParameter("abc", "good");
    }
}

class BaseObject {
    private String name;
    public BaseObject(String name) {
        this.name = name;
        System.out.println(name);
    }
}

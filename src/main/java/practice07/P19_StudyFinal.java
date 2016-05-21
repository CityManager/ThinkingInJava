package practice07;

/**
 * Created by xuweiman on 16/5/21.
 * 学习 final 关键字, 终归到底就是 引用的指向不能被改变
 */
public class P19_StudyFinal {
    private static final int ID = 10086;  // 基本类型,基本上初始化之后可以视为常量
    // static 相当于变成类属性,类加载后就会进行初始化, 类实例可以访问该属性,但不是拥有
    private static final String[] ALIAS = {"移动", "全球通", "财富收割机"};
    private static String test;
    private final char grade = 'a';
    private final String name;  // 空白 final ,必须在使用前初始化(必须先确定引用指向嘛)

    public P19_StudyFinal() {
        this.name = "关键字";
    }

    public static void main(String... args) {
        System.out.println("ALIAS --" + ALIAS[0]);
        P19_StudyFinal.ALIAS[0] = "测试";

        System.out.println("final 修饰的引用指向非基础类型对象,相当于只维护引用指向不变" +
                ", 对象内部怎么变是没办法控制的。");
        System.out.println("ALIAS --" + ALIAS[0]);
        P19_StudyFinal studyFinal = new P19_StudyFinal();
        studyFinal.printName("");

        SubFinal subFinal = new SubFinal();
        subFinal.printSay();
        subFinal.printSay("哈哈哈");
    }

    public void printName(final String name) {  // final 修饰形成,表示形参在方法内部引用指向不能被改变
        System.out.println(name);
    }

}


class BaseFinal {
    public final void printSay() {  // 尽量少用final去修饰方法吧。不如直接private
        System.out.println("final修饰的方法,被继承后,子类可以访问,但不能修改");
    }
}

class SubFinal extends BaseFinal {
    public void printSay(String str) {
        super.printSay();
        System.out.println("但是可以重载--" + str);
    }
}


final class FinalFinal {
    // 直接是一个无法被继承的类, 也许有一定的用处吧
}

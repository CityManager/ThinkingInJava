package practice03;

/**
 * Created by xuweiman on 16/4/27.
 * 练习 指向基本数据类型的引用间的比较,和 指向自定义类对象引用之间的比较
 * == 与 equals 的差别:
 * 1. 使用==比较原生类型如：boolean、int、char等等，使用equals()比较对象。
 * 2. 如果两个引用指向相同的对象: ==返回true，equals()的返回结果依赖于具体业务实现
 * 3. 字符串的对比使用equals()代替==操作符
 */
public class Dog {
    private String name;
    private String says;

    private Dog(String name, String says) {
        this.name = name;
        this.says = says;
    }

    public static void main(String[] args) {
        Dog spot = new Dog("spot", "Ruff!");
        Dog scruffy = new Dog("scruffy", "Wurf!");

        System.out.println(spot.name + "--" + spot.says);
        System.out.println(scruffy.name + "--" + scruffy.says);
        Dog spot_new = spot;
        spot_new.name = "scruffy";
        spot_new.says = "Wurf!";
        System.out.println(spot_new == scruffy);
        System.out.println(spot_new.equals(spot));
        System.out.println(spot_new.equals(scruffy));
    }
}

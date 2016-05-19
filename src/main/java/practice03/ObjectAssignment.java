package practice03;

/**
 * Created by xuweiman on 16/4/27.
 * 练习 基础类型赋值与对象类型赋值
 */
public class ObjectAssignment {
    private String name;
    private OtherObject otherObject;

    private ObjectAssignment(String name) {
        this.name = name;
        this.otherObject = new OtherObject();
    }

    public static void main(String[] args) {
        ObjectAssignment oass1 = new ObjectAssignment("haha");
        ObjectAssignment oass2 = new ObjectAssignment("hehe");

        System.out.println("原本:");
        System.out.println("name:" + oass1.name + "--OtherObject value:" + oass1.otherObject.value);
        System.out.println("name:" + oass2.name + "--OtherObject value:" + oass2.otherObject.value);
        oass1.name = oass2.name;
        oass2.name = "xuweiman";
        oass1.otherObject = oass2.otherObject;
        oass2.otherObject.value = 2;

        System.out.println("使用赋值:");
        System.out.println("oass1.name = oass2.name;");
        System.out.println("oass2.name = \"xuweiman\";");
        System.out.println("oass1.otherObject = oass2.otherObject;");
        System.out.println("oass2.otherObject.value = 2;");
        System.out.println("赋值后:");
        System.out.println("name:" + oass1.name + "--OtherObject value:" + oass1.otherObject.value);
        System.out.println("name:" + oass2.name + "--OtherObject value:" + oass2.otherObject.value);
        System.out.println("由此可以看出基础类型引用赋值后相当于是深度拷贝, 自定义对象引用赋值相当于是浅拷贝!");

    }
}

class OtherObject {
    int value = 0;
}

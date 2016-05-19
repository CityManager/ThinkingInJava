package practice05;

/**
 * Created by xuweiman on 16/5/10.
 * switch 与 enum 类型结合使用
 */

enum MoneyEnum {
    // 可以视为一个类, 类中定义了固定的final修饰的静态变量, 这些变量都是本类的实例.
    WUMAO, YIYUAN, WUYUAN, SHIYUAN, ERSHIYUAN, WUSHIYUAN, YIBAIYUAN
}

public class P22_SwitchEnum {
    private MoneyEnum moneyEnum;

    private P22_SwitchEnum(MoneyEnum e) {
        this.moneyEnum = e;
    }

    public static void main(String... args) {
        for (MoneyEnum e : MoneyEnum.values()) {
            P22_SwitchEnum p = new P22_SwitchEnum(e);
            switch (p.moneyEnum) {
                case WUMAO:
                    System.out.println(p.getClass().getName() + " 本示例为:五毛");
                    break;
                case YIYUAN:
                    System.out.println(p.getClass().getName() + " 本示例为:一元");
                    break;
                case WUYUAN:
                    System.out.println(p.getClass().getName() + " 本示例为:五元");
                    break;
                case SHIYUAN:
                    System.out.println(p.getClass().getName() + " 本示例为:十元");
                    break;
                case ERSHIYUAN:
                    System.out.println(p.getClass().getName() + " 本示例为:二十元");
                    break;
                case WUSHIYUAN:
                    System.out.println(p.getClass().getName() + " 本示例为:五十元");
                    break;
                case YIBAIYUAN:
                    System.out.println(p.getClass().getName() + " 本示例为:五十元");
            }
        }

        MoneyEnum RMB10 = MoneyEnum.SHIYUAN;
        for (MoneyEnum rmb : RMB10.values()) {  // 通过 枚举类型的一个实例去获取该枚举类内的所有枚举实例
            System.out.println(rmb + "--ordinal:" + rmb.ordinal());
        }

        for (TestEnum t : TestEnum.values()) {
            System.out.println(t + "--ordinal:" + t.ordinal());
        }
    }
}

class TestEnum {
    private static final TestEnum TEST1 = new TestEnum("TEST1", 1);
    private static final TestEnum TEST2 = new TestEnum("TEST2", 2);
    private static final TestEnum TEST3 = new TestEnum("TEST3", 3);

    private String name;
    private int id;

    private TestEnum() {
        // do nothing! Just keep it safe.
    }

    private TestEnum(String name, int id) {
        this();
        this.name = name;
        this.id = id;
    }

    static TestEnum[] values() {
        return new TestEnum[]{TEST1, TEST2, TEST3};
    }

    @Override
    public String toString() {
        return this.name;
    }

    int ordinal() {
        return this.id;
    }
}



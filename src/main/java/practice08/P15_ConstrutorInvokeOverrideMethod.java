package practice08;

/**
 * Created by xuweiman on 16/6/2.
 * 基类构造方法中调用 成员方法, 但是在导出类中 重写了该方法的情况
 * 1、在类加载后,类对象创建前,分配给对象的内存全部设置为二进制的零, 所有基本类型值基本都是零,其他类型则为null
 * 2、构造方法尽量设置得简单,尽量只调用 private 方法(final修饰的方法)
 */
public class P15_ConstrutorInvokeOverrideMethod {
    public static void main(String... args) {
        RoundGlyph roundGlyph = new RoundGlyph(10);
        System.out.println("==========");
        roundGlyph.draw();
    }
}

class Glyph {
    private static long count = 0;
    private final long id = count++;

    public Glyph() {
        System.out.println("Start creating " + this);
        draw();
        System.out.println("End creating " + this);
    }

    public void draw() {
        System.out.println("Drawing " + this);
    }

    @Override
    public String toString() {
        return "Glyph" + id;
    }
}


class RoundGlyph extends Glyph {
    private static long count = 0;
    private final long id = count++;
    private int radius;

    public RoundGlyph(int radius) {
        System.out.println("Start creating " + this);
        this.radius = radius;
        System.out.println("End creating " + this);
    }

    @Override
    public void draw() {
        System.out.println("Drawing " + this + ", and the radius is " + radius);
    }

    @Override
    public String toString() {
        return "RoundGlyph" + id;
    }
}

package practice07;

/**
 * Created by xuweiman on 16/5/21.
 * 自动向上转型,重点在与子类的同名方法内部使用了基类中没有的方法,依然能够生效
 */
public class P17_Up_Casting {
    public void test_up_casting(Amphibian a) {
        a.crawl();
    }

    public static void main(String... args) {
        P17_Up_Casting up_casting = new P17_Up_Casting();
        Frog f = new Frog("zi lai ye");

        up_casting.test_up_casting(f);
    }
}

class Amphibian {
    private String name;

    public Amphibian() {
        this.name = "Amphibian";
    }

    public Amphibian(String name) {
        this.name = name;
    }

    public void crawl() {
        System.out.println(name + " is crawling.");
    }
}

class Frog extends Amphibian {
    private String name;

    public Frog(String name) {
        this.name = name;
    }

    @Override
    public void crawl() {
        System.out.println(name + " is crawling.");
        getTarget();  // 直接扩充了向上转型的能力
        super.crawl();
    }

    public void getTarget() {
        System.out.println(name + " target target...");
    }
}
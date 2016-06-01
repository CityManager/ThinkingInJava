package practice08;

import java.util.Random;

/**
 * Created by xuweiman on 16/6/1.
 * 啮(nie)齿类动物,同时完成练习10:
 * 父类两个方法,其中一个方法A被另一个方法B调用,子类重写方法A,观察执行效果
 */
public class P09_Rodents {
    public static void main(String... args) {
        Rodent[] rodents = new Rodent[9];
        RodentGenerator generator = new RodentGenerator();
        for (int i = 0; i < rodents.length; ++i) {
            rodents[i] = generator.next();
        }

        for (Rodent rodent : rodents) {
            System.out.println("==========");
            rodent.eat();
            System.out.println("==========");
        }
    }
}

class Rodent {
    public void eat() {
        System.out.println("Rodent is eating.");
        shineTeeth();
    }

    public void shineTeeth() {
        System.out.println("Shining Rodent teeth.");
    }

}

class Mouse extends Rodent {
    @Override
    public void shineTeeth() {
        System.out.println("Shining Mouse teeth.");
    }
}

class Gerbil extends Rodent {
    @Override
    public void eat() {
        System.out.println("Gerbil is eating.");
        shineTeeth();
    }
}


class Hamster extends Rodent {
    @Override
    public void eat() {
        System.out.println("Hamster is eating.");
        shineTeeth();
    }

    @Override
    public void shineTeeth() {
        System.out.println("Shining Hamster teeth.");
    }
}


class RodentGenerator {
    private static Random random = new Random(47);

    public Rodent next() {
        switch (random.nextInt(3)) {
            default:
            case 0:
                return new Mouse();
            case 1:
                return new Gerbil();
            case 2:
                return new Hamster();
        }
    }
}

package practice09;

/**
 * Created by xuweiman on 16/6/4.
 * 字符数组生成与适配Readable,使 Scanner 能够读取
 * 抄袭了答案
 */
public class P18_CycleFactory {
    public static void ride(CycleFactory cycleFactory) {
        Cycle cycle = cycleFactory.genCycle();
        cycle.wheels();
    }

    public static void main(String... args) {
        ride(new UnicycleFactory());
        ride(new BicycleFactory());
        ride(new TricycleFactory());
    }
}


interface Cycle{
    void wheels();
}


class Unicycle implements Cycle {
    public void wheels() {
        System.out.println("One wheel");
    }
}


class Bicycle implements Cycle {
    public void wheels() {
        System.out.println("Two wheels");
    }
}


class Tricycle implements Cycle {
    public void wheels() {
        System.out.println("Three wheels");
    }
}



interface CycleFactory {
    Cycle genCycle();
}

class UnicycleFactory implements CycleFactory {
    public Unicycle genCycle() {
        return new Unicycle();
    }
}

class BicycleFactory implements CycleFactory {
    public Bicycle genCycle() {
        return new Bicycle();
    }
}

class TricycleFactory implements CycleFactory {
    public Cycle genCycle() {
        return new Tricycle();
    }
}
package practice08;

import java.util.Random;

/**
 * Created by xuweiman on 16/6/2.
 * 使用继承和组合
 * 继承的一个使用的方式是策略,即各个子类表示同一类型事件不同的策略实现
 */
public class P16_ExtendsOrCompose {
    public static void main(String... args) {
        Starship starship = new Starship();
        for(int i=0; i<10; ++i) {
            starship.changeAlert();
            starship.displayAlertMsg();
        }
    }
}

class Starship {
    private static AlertGenerator gen = new AlertGenerator();
    private Alert alert;

    public void changeAlert() {
        this.alert = gen.createAlert();
    }

    public void displayAlertMsg() {
        alert.alert();
    }
}


class Alert {
    private int status = 0;
    private String msg;

    Alert(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Status " + status + ", DefaultAlert";
    }

    public void alert() {
        System.out.println(msg + " " + this);
    }
}


class WarningAlert extends Alert {
    private int status = 1;

    WarningAlert(String msg) {
        super(msg);
    }

    @Override
    public String toString() {
        return "Status " + status + ", WarningAlert";
    }
}


class DangerAlert extends Alert {
    private int status = -1;

    DangerAlert(String msg) {
        super(msg);
    }

    @Override
    public String toString() {
        return "Status " + status + ", DangerAlert";
    }
}


class AlertGenerator {
    private static Random random = new Random(47);

    public Alert createAlert() {
        switch (random.nextInt(3)) {
            default:
            case 0:
                return new Alert("HA");
            case 1:
                return new WarningAlert("Hungry");
            case 2:
                return new DangerAlert("Attack");
        }
    }

}

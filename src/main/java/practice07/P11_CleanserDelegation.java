package practice07;

/**
 * Created by xuweiman on 16/5/21.
 * 使用代理类
 */
public class P11_CleanserDelegation {
    private String name;
    private Cleanser cleanser;

    public P11_CleanserDelegation(String name) {
        this.name = name;
        this.cleanser = new Cleanser();
    }

    public void append(String a) {
        cleanser.append(a);
    }

    public void dilute() {
        cleanser.dilute();
    }

    public void apply() {
        cleanser.apply();
    }

    @Override
    public String toString() {
        return name + " " + cleanser.toString();
    }

    public static void main(String... args) {
        P11_CleanserDelegation delegation = new P11_CleanserDelegation("Delegation");
        delegation.dilute();
        delegation.apply();
        System.out.println(delegation);
    }
}


class Cleanser {
    private String s = "Cleanser";

    public void append(String a) {
        s += a;
    }
    public void dilute() {
        append(" dilute()");
    }

    public void apply() {
        append(" apply()");
    }

    public void scrub() {
        append(" scrub()");
    }

    @Override
    public String toString() {
        return s;
    }
}
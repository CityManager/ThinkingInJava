package practice02;

/**
 * Created by xuweiman on 16/4/27.
 *
 */


public class DataOnly {
    private int i;
    private double d;
    private boolean b;

    public static void main(String[] args) {
        DataOnly dataOnly = new DataOnly();
        dataOnly.i = 10;
        dataOnly.d = 937492384.2034820348;
        dataOnly.b = false;

        System.out.println(dataOnly.i);
        System.out.println(dataOnly.d);
        System.out.println(dataOnly.b);
    }
}

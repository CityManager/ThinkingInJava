package practice02;

public class AutoPackage {
    private boolean b = new Boolean("true");
    private Boolean bh = true;
    private char c = new Character('x');
    private Character ch = 'x';
    private byte bi = new Byte("5");
    private Byte bih = bi;
    private short s = new Short("10");
    private Short sh = 1;
    private int i = new Integer("100");
    private Integer ih = 1;
    private long l = new Long("1000");
    private Long lh = 100L;
    private float f = new Float("3.33");
    private Float fh = 0.01f;
    private double d = new Double("4.44");
    private Double dh = 0.02;
    // void v = new Void();
    private Void vh = null;

    public static void main(String[] args) {
        AutoPackage ap = new AutoPackage();
        System.out.println(ap.b);
        System.out.println(ap.bh);
        System.out.println(ap.c);
        System.out.println(ap.ch);
        System.out.println(ap.bi);
        System.out.println(ap.bih);
        System.out.println(ap.s);
        System.out.println(ap.sh);
        System.out.println(ap.i);
        System.out.println(ap.ih);
        System.out.println(ap.l);
        System.out.println(ap.lh);
        System.out.println(ap.f);
        System.out.println(ap.fh);
        System.out.println(ap.d);
        System.out.println(ap.dh);
        // System.out.println(ap.v);
        System.out.println(ap.vh);
    }
}

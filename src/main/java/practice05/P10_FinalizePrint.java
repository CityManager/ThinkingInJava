package practice05;

/**
 * Created by xuweiman on 16/5/3.
 * 练习使用finalize() 方法(但是这个方法不建议被经常使用)
 */
public class P10_FinalizePrint {
    private int id;
    private P10_FinalizePrint(int id) {
        this.id = id;
        System.out.println("创建: ID为" + this.id + "的对象");
    }

    protected void finalize() {
        System.out.println("清理: ID为" + this.id + "的对象");

        try {
            super.finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for(int i=0; i< 10; ++i) {
            P10_FinalizePrint a = new P10_FinalizePrint(i);
            System.out.println(a.id);
        }

        System.gc();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

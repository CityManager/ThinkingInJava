package practice10;

/**
 * Created by xuweiman on 16/6/11.
 * 回调初识?
 */
public class P23_Callback {
    public static void startWork(B b) {
        b.doWork();
        b.remove();
    }

    public static void main(String... args) {
        int size = 10;
        B b = new B(size);
        for (int i = 0; i < size; ++i) {
            A a = new A();
            b.insert(a.getU());
        }

        startWork(b);
    }
}


interface U {
    void setStatus(String status);

    long getId();

    String getStatus();
}


class A {
    private static long counter = 0;
    private long id = counter++;
    private String status = "waiting";

    public U getU() {
        return new U() {
            public void setStatus(String status) {
                A.this.status = status;
            }

            public long getId() {
                return id;
            }

            public String getStatus() {
                return status;
            }
        };
    }
}


class B {
    private U[] us;

    public B(int size) {
        this.us = new U[size];
    }

    public void insert(U u) {
        boolean isInserted = false;
        for (int i = 0; i < us.length; ++i) {
            if (us[i] == null) {
                us[i] = u;
                isInserted = true;
                break;
            }
        }
        if (!isInserted) {
            System.out.println("没有空闲空间用于注册U接口");
        }
    }

    public void remove() {
        for (int i = 0; i < us.length; ++i) {
            if (us[i] != null && "finish".equals(us[i].getStatus())) {
                us[i] = null;
            }
        }
    }

    public void doWork() {
        for (U u : us) {
            if (u != null && !"finish".equals(u.getStatus())) {
                System.out.println("Start invoking U:" + u.getId());
                System.out.println("A's status is " + u.getStatus());
                u.setStatus("finish");
                System.out.println("A's status now turn into " + u.getStatus());
            }
        }
    }
}
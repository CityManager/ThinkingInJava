package practice08;

/**
 * Created by xuweiman on 16/6/2.
 * 对象被其他多个应用共享时,内部使用引用计数器,在对象清理前判断 计数器是否清零
 */
public class P13_DisposeShareObject {
    public static void main(String... args) {
        Shared shared = new Shared();
        Composing[] composings = {new Composing(shared), new Composing(shared), new Composing(shared)};
        for(Composing composing:composings) {
            composing.dispose();
        }
        System.gc();

        new Composing(new Shared());
        System.gc();
    }
}

class Shared {
    private int refCount = 0;
    private static int count = 0;
    private final long id = count++;  // ++ 后缀的作用是先返回值,后自增

    public Shared() {
        System.out.println("Create " + this);
    }

    public void addRef() {
        ++refCount;
    }

    protected void dispose() {
        if(--refCount == 0) {
            System.out.println("Disposing " + this);
        }
    }

    @Override
    public String toString() {
        return "Shared " + id;
    }

    @Override
    protected void finalize() throws Throwable {
        if(refCount>0) {
            System.out.println("There still have objects reference Shared " + id);
        }
        super.finalize();
    }
}


class Composing {
    private Shared shared;
    private static int count = 0;
    private final long id = count++;

    public Composing(Shared shared) {
        System.out.println("Create " + this);
        this.shared = shared;
        shared.addRef();  // 这个本来不应该在这里调用,应该是shared自己管理
    }

    @Override
    public String toString() {
        return "Composing " + id;
    }

    protected void dispose() {
        System.out.println("Disposing " + this);
        shared.dispose();
    }
}
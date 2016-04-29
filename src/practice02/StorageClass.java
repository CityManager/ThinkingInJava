package practice02; /**
 * Created by xuweiman on 16/4/27.
 * 第二章练习6
 */
public class StorageClass {
    private int storage(String s) {
        return s.length() * 2;
    }

    public static void main(String[] args) {
        StorageClass storageClass = new StorageClass();

        int storage = storageClass.storage("xuweiman");
        System.out.println(storage);
    }
}

package practice05;

/**
 * Created by xuweiman on 16/5/1.
 * 类构造器与方法的重载
 */
public class P06_Overload {
    private String bark_str = "barking";

    private P06_Overload() {
        System.out.println("使用默认构造器");
    }

    private P06_Overload(String bark_str) {
        this.bark_str = bark_str;
        System.out.println("使用自定义构造器");
    }

    private void park() {
        System.out.println(this.bark_str);
    }

    private void park(String park_str, int count) {
        for(int i=0; i<count; ++i) {
            System.out.print(park_str+ " ");
        }
        System.out.println();
    }

    private void park(int count, String park_str) {
        for(int i=0; i< count; ++i) {
            System.out.print("o " + park_str + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        P06_Overload dog = new P06_Overload();
        dog.park();
        System.out.println("========");
        P06_Overload dog2 = new P06_Overload("Ha Ha");
        dog2.park();
        dog2.park("barking", 5);
        dog2.park(3, "howling");
    }
}

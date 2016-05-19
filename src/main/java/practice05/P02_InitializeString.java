package practice05;

/**
 * Created by xuweiman on 16/5/1.
 * 类定义中初始化的String 与 构造器中初始化的 String的异同
 */
public class P02_InitializeString {
    private String str_class = "类定义";
    private String str_constructor;

    private P02_InitializeString(String str) {
        this.str_constructor = str;
        System.out.println("类初始化String: " + this.str_class);
        System.out.println("构造器初始化String: " + this.str_constructor);
    }

    public static void main(String[] args) {
        P02_InitializeString p_obj1 = new P02_InitializeString("Ha ha ha");
        P02_InitializeString p_obj2 = new P02_InitializeString("He he he");
        // P02_InitializeString p_obj3 = new P02_InitializeString();
        // 类中存在自定义构造器的情况下,不能使用没有显式定义的默认构造器

        System.out.println(p_obj1.str_class.equals(p_obj2.str_class));
        System.out.println(p_obj1.str_constructor.equals(p_obj2.str_constructor));
    }
}

package practice05;

/**
 * Created by xuweiman on 16/5/3.
 * 可选参数的使用
 */
public class P19_VarStringArgs {

    private static void print_str(int index, String... str_args) {
        System.out.print("Index: " + index + " ");
        for (String str : str_args) {
            System.out.print(str + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        P19_VarStringArgs.print_str(1, "good", "morning", "my", "world");
        String[] str_array = new String[]{"have", "a", "good", "day"};
        P19_VarStringArgs.print_str(2, str_array);
    }

}



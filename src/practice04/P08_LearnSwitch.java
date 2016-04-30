package practice04;

/**
 * Created by xuweiman on 16/4/30.
 * switch的用法
 */
public class P08_LearnSwitch {
    private static void switchGroup(int num_key) {
        switch (num_key) {
            case 1:
            case 2:
                System.out.println("Group 1");
                break;
            case 3:
            case 4:
                System.out.println("Group 2");
            case 5:
                System.out.println("Still Group 2");
                break;
            case 6:
                System.out.println("Ha Ha");
            default:
                System.out.println("The Default Group");
        }
    }

    public static void main(String[] args) {
        System.out.println("==========");
        switchGroup(1);
        System.out.println("==========");
        switchGroup(4);
        System.out.println("==========");
        switchGroup(6);
        System.out.println("==========");
        switchGroup(10);
    }
}

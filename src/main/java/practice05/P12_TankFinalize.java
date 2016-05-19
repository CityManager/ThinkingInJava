package practice05;

/**
 * Created by xuweiman on 16/5/3.
 * 测试Tank类的终极条件
 */
public class P12_TankFinalize {
    private int id;
    private int status; //  1为满的, 0为空的

    private void setStatus(int status) {
        this.status = status;
    }

    private P12_TankFinalize(int id, int status) {
        this.id = id;
        this.status = status;
    }

    protected void finalize() {
        try {
            if (this.status != 0) {
                System.out.println("ID为" + this.id + "的Tank的状态是满的, 存在缺陷");
            } else {
                System.out.println("ID为" + this.id + "的Tank的状态是空的, 清理");
                super.finalize();
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    public static void main(String[] args) {
        P12_TankFinalize tank1 = new P12_TankFinalize(1, 1);
        P12_TankFinalize tank2 = new P12_TankFinalize(2, 1);
        P12_TankFinalize tank3 = new P12_TankFinalize(3, 1);
        P12_TankFinalize tank4 = new P12_TankFinalize(4, 1);

        tank2.setStatus(0);
        tank4.setStatus(0);

        System.out.println("ID为" + tank1.id + "的Tank状态是" + tank1.status);
        System.out.println("ID为" + tank2.id + "的Tank状态是" + tank2.status);
        tank1 = null;
        tank2 = null;

        System.gc();  // gc清理时另一个线程在跑

        System.out.println("ID为" + tank3.id + "的Tank状态是" + tank3.status);
        System.out.println("ID为" + tank4.id + "的Tank状态是" + tank4.status);
    }
}

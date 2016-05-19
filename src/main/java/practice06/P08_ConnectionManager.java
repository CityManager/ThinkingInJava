package practice06;

/**
 * Created by xuweiman on 16/5/11.
 * 包权限控制
 */
public class P08_ConnectionManager {
    private static Connection[] connections = new Connection[4];

    static {
        for (int id = 0; id < 4; ++id) {
            connections[id] = new Connection(id);
        }
    }

    public static Connection getConnection() {
        for(int id=0 ;id<4; ++id) {
            if(connections[id] != null) {
                Connection c = connections[id];
                connections[id] = null;
                return c;
            }
        }
        return null;
    }

    public static void main(String... args) {
        for (int i=0; i<5; ++i) {
            Connection c = P08_ConnectionManager.getConnection();
            if (c != null) {
                System.out.println(c.getId());
            }
        }
    }
}

class Connection {  // Connection 类是报访问权限
    private int id;  // 私有域(属性)

    public Connection(int id) {  // 即使设置为 公开访问权限,因为类是包访问权限的而无法再包外被访问.
        this.id = id;
    }

    int getId() {  // 包权限方法,可以被包内其他类调用
        return this.id;
    }
}

package practice14;

import sun.security.provider.SHA;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xuweiman on 16/7/26.
 * 1. toString 方法利用 运行时类型确定 来整合代码
 * 2. 初步使用反射
 */
public class P06_FlagShape {
    public static void main(String[] args) {
        List<HShape> shapes = Arrays.asList(
          new HCircle(), new HRhomboid(), new HSquare(), new HTriangle(),
                new HTriangle(), new HCircle(), new HSquare(), new HRhomboid()
        );

        HShape.highLight_m1(HCircle.class);
        for (HShape s: shapes) {
            s.draw();
        }
        System.out.println("===========");
        HShape.highLight_m2(HShape.class);
        for (HShape s: shapes) {
            s.draw();
        }

        System.out.println("===========");
        HShape.clearHighLight_m2(HRhomboid.class);
        for (HShape s: shapes) {
            s.draw();
        }
        System.out.println("===========");
        HShape.clearHighLight_m1(HSquare.class);
        for (HShape s: shapes) {
            s.draw();
        }


    }
}

class HShape {
    private static ArrayList<HShape> hShapes = new ArrayList<HShape>();
    private boolean highLighted = false;

    public void highLight() { highLighted = true; }
    public void clearHighLight() { highLighted = false;}

    public void draw() { System.out.println(this + ".draw()"); }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + (highLighted ? "highLighted": "normal");
    }

    public HShape() {
        hShapes.add(this);
    }

    public static void highLight_m1(Class<?> type) {
        for (HShape s: hShapes) {
            if (type.isInstance(s)) {
                s.highLight();
            }
        }
    }

    public static void clearHighLight_m1(Class type) {
        for (HShape s: hShapes) {
            if(type.isInstance(s)) {
                s.clearHighLight();
            }
        }
    }

    private static void forEach(Class<?> type, String method) {  // 使用反射
        try {
            Method m = HShape.class.getMethod(method);
            for (HShape s: hShapes) {
                if(type.isInstance(s)) {
                    m.invoke(s);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void highLight_m2(Class<?> type) {
        forEach(type, "highLight");
    }

    public static void clearHighLight_m2(Class<?> type) {
        forEach(type, "clearHighLight");
    }

}


class HCircle extends HShape {}
class HSquare extends HShape {}
class HRhomboid extends HShape {}
class HTriangle extends HShape {}
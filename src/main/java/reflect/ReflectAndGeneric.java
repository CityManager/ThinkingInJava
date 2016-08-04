package reflect;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Created by xuweiman on 16/8/4.
 * 通过反射解释 java的泛型只存在于编译期,运行时java是去泛型化的
 */
public class ReflectAndGeneric {
    public static void main(String... args) throws Exception {
        ArrayList list = new ArrayList();
        ArrayList<String> strList = new ArrayList<String>();
        strList.add("Hello World");

        Class listClass = list.getClass();
        Method addInList = listClass.getDeclaredMethod("add", Object.class);
        addInList.invoke(strList, 10);
        //  第一:两个list的类类型是同一个,即运行时,所有的类类型已经确定,包括后续手工加入的编译类
        //  第二:利用泛型限定了类型的strList对象,在运行期可以通过反射放入Object类型的对象,即 在运行期已经去泛型化

        System.out.println(strList);  // 此时无法通过 for(String s:strList) 这种形式去遍历
    }
}

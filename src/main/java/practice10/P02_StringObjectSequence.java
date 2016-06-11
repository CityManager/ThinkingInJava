package practice10;



/**
 * Created by xuweiman on 16/6/11.
 * 使用定义为内部类的选择器,遍历序列外部类所包含的对象
 * 外部类可以访问内部类的私有成员
 */
public class P02_StringObjectSequence {
    public static void main(String... args) {
        int size = 10;
        Sequence tempStringSequence = new Sequence(size);
        for(int i=0;i<size; ++i) {
            TempString tempString = new TempString(Integer.toString(i));
            tempStringSequence.add(tempString);
        }

        Sequence.SequenceSelector selector = tempStringSequence.selector();
        while(!selector.end()) {
            System.out.println(selector.current());
            selector.next();
        }

        Sequence sequence2 = new Sequence(size);
        Sequence.SequenceSelector selector2 = sequence2.new SequenceSelector();
        for(int i=size; i>0; --i) {
            selector2.selectTarget().add(new TempString(Integer.toString(i)));
        }

        while(!selector2.end()) {
            System.out.println(selector2.current());
            selector2.next();
        }
    }

}

class TempString {
    private String content;

    public TempString(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }
}


class Sequence {
    private Object[] items;
    private int next;
    public Sequence(int size) {
        this.items = new Object[size];
    }

    public void add(Object o) {
        if(next < items.length) {
            items[next++] = o;
        }
    }

    public SequenceSelector selector() {
        SequenceSelector selector = new SequenceSelector();
        // selector.i = 10;  // 外部类可以访问内部类的 私有变量。
        return selector;
    }

    class SequenceSelector {
        private int i = 0;

        public boolean end() {
            return i == items.length;
        }

        public Object current() {
            return items[i];
        }

        public void next() {
            if(i<items.length) {
                i++;
            }
        }

        public Sequence selectTarget() {
            return Sequence.this;
        }
    }
}

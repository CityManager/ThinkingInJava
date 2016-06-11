package practice10;

/**
 * Created by xuweiman on 16/6/11.
 * 习题22,为习题02添加一个 匿名选择器
 * 内部类的好处:
 * 1.无需外部类实现过多的接口,并且可以利用内部类来完成 多重继承
 * 2.本例中的情况,多个内部类来使用不同方式实现同一个接口,或者类
 * 3.内部类并不要求在外部类实例化是一起实例化,可以在外部类实例化后,需要使用内部类时才进行实例化
 */
public class P22_ReverseSelector {
    public static void main(String... args) {
        int size = 10;
        StringSequence StringSequence = new StringSequence(size);
        for(int i=0;i<size; ++i) {
            NewTempString temp = new  NewTempString(Integer.toString(i));
            StringSequence.add(temp);
        }

        Selector selector = StringSequence.selector();
        while(!selector.end()) {
            System.out.println(selector.current());
            selector.next();
        }

        Selector reverseSelector = StringSequence.reverseSelector();
        while(!reverseSelector.end()) {
            System.out.println(reverseSelector.current());
            reverseSelector.next();
        }
    }
}

class NewTempString {
    private String content;

    public NewTempString(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }
}


interface Selector {
    boolean end();
    Object current();
    void next();
}


class StringSequence {
    private Object[] items;
    private int next;
    public StringSequence(int size) {
        this.items = new Object[size];
    }

    public void add(Object o) {
        if(next < items.length) {
            items[next++] = o;
        }
    }

    public Selector selector() {
        return new SequenceSelector();
    }

    // 添加一个匿名内部类
    public Selector reverseSelector() {
        return new Selector() {
            private int i = items.length - 1;
            public boolean end() {
                return i == -1;
            }

            public Object current() {
                return items[i];
            }

            public void next() {
                if(i>=0){
                    i--;
                }
            }
        };
    }

    class SequenceSelector implements Selector {
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

        public StringSequence selectTarget() {
            return StringSequence.this;
        }
    }
}

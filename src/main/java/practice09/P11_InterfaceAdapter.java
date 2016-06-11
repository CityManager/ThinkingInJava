package practice09;

/**
 * Created by xuweiman on 16/6/4.
 * 接口使用
 * 使用接口或抽象类均能够达到策略模式的效果,抽象类相对而言有利于公有代码复用
 * 适配器模式: 假如Filter及其"实现"在第三方库中,欲将Filter实现当成Processor使用,则可以使用适配器
 * 创建一个Filter具体实现的代理类,并设置该代理类继承了Processor, 以此来完成Filter与Processor之间的适配
 *
 * 反过来,如果Processor是在第三方库中,我们可能后续会跟换Processor,减少代码耦合方式也是可以使用适配器
 * 即不用考虑创造同时继承Processor和实现Filter的类,使用适配器提高灵活性
 */
public class P11_InterfaceAdapter {
    public static void process(Processor p, Object s) {
        System.out.println("Using Processor " + p.name());
        System.out.println(p.process(s));
    }

    public static void main(String... args) {
        System.out.println("使用策略模式");
        process(new UpperCaseProcessor(), "XuWeiman");
        process(new LowerCaseProcessor(), "Xuweiman");

        System.out.println("=================");
        System.out.println("想要在process方法中使用Filter,可以适应适配器");
        process(new FilterProcessorAdapter(new StringSwapFilter()), "abcdefg");

    }
}

abstract class Processor {
    public abstract String name();
    public abstract Object process(Object input);
}


class UpperCaseProcessor extends Processor {
    public String name() {
        return getClass().getSimpleName();
    }

    public String process(Object input) {
        return ((String)input).toUpperCase();
    }
}


class LowerCaseProcessor extends Processor {
    public String name() {
        return getClass().getSimpleName();
    }

    public String process(Object input) {
        return ((String) input).toLowerCase();
    }
}


interface Filter {
    public String filter(String input);
}


class StringSwapFilter implements Filter {
    public String filter(String input) {
        StringBuilder sb = new StringBuilder(input);
        for(int i=0; i<=sb.length()-2; i+=2) {
            char c1 = sb.charAt(i);
            char c2 = sb.charAt(i+1);
            sb.setCharAt(i, c2);
            sb.setCharAt(i+1, c1);
        }
        return sb.toString();
    }
}

class FilterProcessorAdapter extends Processor {
    private Filter filter;

    FilterProcessorAdapter(Filter filter) {
        this.filter = filter;
    }
    public String name() {
        return filter.getClass().getSimpleName();
    }

    public Object process(Object input) {
        return filter.filter((String)input);
    }
}


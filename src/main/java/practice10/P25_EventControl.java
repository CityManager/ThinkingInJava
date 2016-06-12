package practice10;

import java.util.ArrayList;

/**
 * Created by xuweiman on 16/6/12.
 * 内部类实现的 事件驱动
 */
public class P25_EventControl {
    public static void main(String... args) {
        GreenHouseController greenHC = new GreenHouseController();
        greenHC.addEvent(greenHC.new Bell(900));
        Event[] events = {
                greenHC.new ThermostatNight(0),
                greenHC.new LightOn(200),
                greenHC.new LightOff(400),
                greenHC.new WaterOn(600),
                greenHC.new WaterOff(800),
                greenHC.new ThermostatDay(1400)
        };
        greenHC.addEvent(greenHC.new Restart(2000, events));
        greenHC.addEvent(greenHC.new Terminate(5000000));

        // 可以在外部添加一个事件
        greenHC.addEvent(new Event(600) {
            @Override
            void action() {
                // this.eventMsg = "Wind on.";
                System.out.println("Wind on.");
            }
        });
        greenHC.addEvent(new Event(900) {
            @Override
            void action() {
                // this.eventMsg = "Wind off.";
                System.out.println("Wind off.");
            }
        });

        greenHC.run();


    }
}

abstract class Event {
    private long eventTime;
    protected final long delayTime;
    public String eventMsg = "abstract event";

    public Event(long delayTime) {
        this.delayTime = delayTime;
        start();
    }

    public void start() {
        eventTime = System.nanoTime() + delayTime;
    }

    public boolean ready() {
        return System.nanoTime() >= eventTime;
    }

    abstract void action();  // 具体事件触发实现,由各个子类实现

    @Override
    public String toString() {
        return eventMsg;
    }
}

class Controller {
    private ArrayList<Event> eventList = new ArrayList<Event>();

    public void addEvent(Event e) {
        eventList.add(e);
    }

    public void run() {
        while (!eventList.isEmpty()) {
            for (Event e : new ArrayList<Event>(eventList)) {  // for循环中安全起见不修改循环主体, 所以要做一个深拷贝
                if (e.ready()) {
                    System.out.println(e);
                    e.action();
                    eventList.remove(e);
                }
            }
        }
    }

}

class GreenHouseController extends Controller {
    private boolean light = false;

    public class LightOn extends Event {
        public LightOn(long delayTime) {
            super(delayTime);
            this.eventMsg = "Light is on.";
        }

        void action() {
            light = true;  // action方法中可以加入控制硬件的代码
        }
    }

    public class LightOff extends Event {
        public LightOff(long delayTime) {
            super(delayTime);
            this.eventMsg = "Light is off.";
        }

        void action() {
            light = false;
        }
    }


    private boolean water = false;

    public class WaterOn extends Event {
        public WaterOn(long delayTime) {
            super(delayTime);
            this.eventMsg = "Greenhouse water is on.";
        }

        void action() {
            water = true;
        }
    }

    public class WaterOff extends Event {
        public WaterOff(long delayTime) {
            super(delayTime);
            this.eventMsg = "Greenhouse water is off.";
        }

        void action() {
            water = false;
        }
    }

    private String thermostat = "Day";

    public class ThermostatNight extends Event {
        public ThermostatNight(long delayTime) {
            super(delayTime);
            this.eventMsg = "Thermostat on night setting.";
        }

        public void action() {
            thermostat = "Night";
        }
    }

    public class ThermostatDay extends Event {
        public ThermostatDay(long delayTime) {
            super(delayTime);
            this.eventMsg = "Thermostat on Day setting.";
        }

        public void action() {
            thermostat = "Day";
        }
    }

    public class Bell extends Event {
        public Bell(long delayTime) {
            super(delayTime);
            this.eventMsg = "Bing Bing Bing!";
        }

        public void action() {
            addEvent(new Bell(delayTime)); // 可以在事件中再添加事件
        }
    }

    public class Restart extends Event {
        private Event[] events;

        public Restart(long delayTime, Event[] events) {
            super(delayTime);
            this.events = events;
            this.eventMsg = "Restarting System...";
        }

        public void action() {
            for (Event e : events) {
                e.start();
                addEvent(e);
            }
            start();
            addEvent(this);  // 将自己也加入到 控制器的事件列表中
        }
    }

    public class Terminate extends Event {
        public Terminate(long delayTime) {
            super(delayTime);
            this.eventMsg = "Terminating all events.";
        }

        public void action() {
            System.exit(0);
        }
    }
}

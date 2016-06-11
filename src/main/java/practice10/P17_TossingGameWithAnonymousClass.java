package practice10;

import java.util.Random;

/**
 * Created by xuweiman on 16/6/11.
 * 匿名内部类实现工厂接口, 第九章中习题19的另一个实现方案, 直接在目标类中静态拥有一个工厂
 */
public class P17_TossingGameWithAnonymousClass {
    static void play(GameFactory f, int stake) {
        if(stake == f.newGame().toss()) {
            System.out.println("Win");
        } else {
            System.out.println("Loss");
        }
    }

    public static void main(String[] args) {
        play(CoinGame.factory, 0);
        play(DiceGame.factory, 2);
    }
}


interface TossingGame{
    int toss();
}

interface GameFactory {
    TossingGame newGame();
}


class CoinGame implements TossingGame {
    public static GameFactory factory = new GameFactory() {
        public TossingGame newGame() {
            return new CoinGame();
        }
    };

    public int toss() {
        Random random = new Random(47);
        switch(random.nextInt(2)) {
            case 0:
                System.out.println("Flower of the coin.");
                return 0;
            default:
            case 1:
                System.out.println("Letter of the coin.");
                return 1;
        }
    }
}


class DiceGame implements TossingGame {
    public static GameFactory factory = new GameFactory() {
        public TossingGame newGame() {
            return new DiceGame();
        }
    };

    public int toss() {
        Random random = new Random(47);
        int result = random.nextInt(6) + 1;
        System.out.println("Dice value is " + result);
        return result;
    }
}
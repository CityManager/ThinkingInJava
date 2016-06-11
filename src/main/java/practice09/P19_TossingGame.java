package practice09;

import java.util.Random;

/**
 * Created by xuweiman on 16/6/4.
 * 学习使用接口和工厂
 */
public class P19_TossingGame {
    public static void play(TossingGameFactory f, int stake) {
        if(stake == f.newGame().toss()) {
            System.out.println("Win");
        } else {
            System.out.println("Loss");
        }
    }

    public static void main(String[] args) {
        play(new CoinGameFactory(), 0);
        play(new DiceGameFactory(), 2);
    }
}


interface TossingGame {
    int toss();
}

interface TossingGameFactory {
    TossingGame newGame();
}

class CoinGame implements TossingGame {
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

class CoinGameFactory implements TossingGameFactory {
    public CoinGame newGame() {
        return new CoinGame();
    }
}


class DiceGame implements TossingGame {
    public int toss() {
        Random random = new Random(47);
        int result = random.nextInt(6) + 1;
        System.out.println("Dice value is " + result);
        return result;
    }
}

class DiceGameFactory implements TossingGameFactory {
    public DiceGame newGame() {
        return new DiceGame();
    }
}
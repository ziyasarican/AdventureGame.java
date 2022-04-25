package Monsters;

import java.util.Random;

public class Snake extends Monster {
    private static Random random = new Random();
    private static int snakeDamage = random.nextInt(4) + 3;
    public Snake() {
        super(4, "Monsters.Snake",snakeDamage, 12, 0);
    }
}

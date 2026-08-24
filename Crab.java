import java.util.Random;

public class Crab extends SeaCreature {

    private int moves;
    private Random random;
    private String symbol;

    public Crab(String name, int position, int speed, int direction, String symbol) {
        super(name, position, speed, direction);
        this.moves = 0;
        this.random = new Random();
        this.symbol = symbol;
    }

    @Override
    public void move(int tankWidth) {
        position += speed * direction;
        keepInsideTank(tankWidth);

        moves++;

        if (random.nextInt(100) < 20) {
            direction *= -1;
        }
    }

    @Override
    public String getSymbol() {
        return direction >= 0 ? symbol : symbol;
    }

    public int getMoves() {
        return moves;
    }
}
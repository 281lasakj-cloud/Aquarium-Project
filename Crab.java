import java.util.Random;


public class Crab extends SeaCreature {


    private int moves;
    private Random random;
    private String symbol;


    public Crab(String name, int position, int speed, int direction, String symbol) throws InvalidCreatureException {
        super(name, position, speed, direction);
        this.moves = 0;
        this.random = new Random();
        this.symbol = symbol;
        if (name.length() < 3 || name.length() > 20 || position < 0 || speed < 0 || (direction != -1 && direction != 1)) {
            throw new InvalidCreatureException("Invalid name length for Crab: " + name);
        }
    }


    @Override
    public void move(int tankWidth) {
        position += speed * direction;
        keepInsideTank(tankWidth);


        moves++;

        int crabChance = 20;
        if (random.nextInt(100) < crabChance) {
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


public class Shark extends SeaCreature {


    private String symbol;


    public Shark(String name, int position, int speed, int direction, String symbol) throws InvalidCreatureException {
        super(name, position, speed, direction);
        this.symbol = symbol;
        if (name.length() < 3 || name.length() > 20 || position < 0 || speed < 0 || (direction != -1 && direction != 1)) {
            throw new InvalidCreatureException("Invalid creature parameter for the Shark " + name);
        }
    }


    @Override
    public void move(int tankWidth) {
        position += speed * direction;
        keepInsideTank(tankWidth);


        position += speed * direction;
        keepInsideTank(tankWidth);
    }


    @Override
    public String getSymbol() {
        return direction >= 0 ? symbol : symbol;
    }
}


public class Fish extends SeaCreature {


    private String symbol;


    public Fish(String name, int position, int speed, int direction, String symbol) throws InvalidCreatureException {
        super(name, position, speed, direction);
        this.symbol = symbol;
        if (name.length() < 3 || name.length() > 20 || position < 0 || speed < 0 || (direction != -1 && direction != 1)) {
            throw new InvalidCreatureException("Invalid creature parameter for the Fish " + name);
        }
    }


    @Override
    public void move(int tankWidth) {
        position += speed * direction;
        keepInsideTank(tankWidth);
    }


    @Override
    public String getSymbol() {
        return direction >= 0 ? symbol : reverseSymbol(symbol);
    }


    private String reverseSymbol(String text) {
        return new StringBuilder(text).reverse().toString();
    }
}




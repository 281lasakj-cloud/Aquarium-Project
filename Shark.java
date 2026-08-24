public class Shark extends SeaCreature {

    private String symbol;

    public Shark(String name, int position, int speed, int direction, String symbol) {
        super(name, position, speed, direction);
        this.symbol = symbol;
    }

    @Override
    public void move(int tankWidth) {
        // Shark moves twice every turn.
        position += speed * direction;
        keepInsideTank(tankWidth);

        position += speed * direction;
        keepInsideTank(tankWidth);
    }

    @Override
    public String getSymbol() {
        return direction >= 0 ? symbol : reverseSymbol(symbol);
    }
}
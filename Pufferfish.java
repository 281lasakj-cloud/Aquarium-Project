public class Pufferfish extends SeaCreature {

private String symbol;
private String puffedSymbol;
private int turns;

public Pufferfish(
        String name, int position, int speed, int direction, String symbol) throws InvalidCreatureException {

    super(name, position, speed, direction);

    this.symbol = symbol;
    this.puffedSymbol = ">(@o@)<";
    this.turns = 0;

    if (name.length() < 3 || name.length() > 20 || position < 0 || speed < 0
        || (direction != -1 && direction != 1)) {

        throw new InvalidCreatureException("Invalid creature parameters for Pufferfish: " + name);
    }
}

@Override
public void move(int tankWidth) {

    turns++;

    position += speed * direction;
    keepInsideTank(tankWidth);
}

@Override
public String getSymbol() {

    if (turns % 4 == 0) {
        return puffedSymbol;
    }

    return direction >= 0 ? symbol : reverseSymbol(symbol);
}

private String reverseSymbol(String text) {
    return new StringBuilder(text).reverse().toString();
}

}
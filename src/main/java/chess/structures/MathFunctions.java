package chess.structures;

public class MathFunctions {

    /**
     * Given value returns its absolute value
     * @param a int value
     * @return Absolute value of a
     */
    public int abs(int a) {
        if (a < 0) {
            return a * -1;
        }
        return a;
    }
}

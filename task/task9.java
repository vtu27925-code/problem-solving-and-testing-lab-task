
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    Calculator calc = new Calculator();

    @Test
    public void testAddition() {
        assertEquals(10, calc.add(5, 5));
    }

    @Test
    public void testSubtraction() {
        assertEquals(5, calc.subtract(10, 5));
    }

    @Test
    public void testMultiplication() {
        assertEquals(20, calc.multiply(4, 5));
    }

    @Test
    public void testDivision() {
        assertEquals(5, calc.divide(10, 2));
    }

    @Test
    public void testDivisionByZero() {
        assertThrows(ArithmeticException.class,
                () -> calc.divide(10, 0));
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();

        System.out.println("Addition: " + calc.add(5, 5));
        System.out.println("Subtraction: " + calc.subtract(10, 5));
        System.out.println("Multiplication: " + calc.multiply(4, 5));
        System.out.println("Division: " + calc.divide(10, 2));
    }
}

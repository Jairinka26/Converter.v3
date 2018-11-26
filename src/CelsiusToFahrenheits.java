public class CelsiusToFahrenheits implements IOperation {
    @Override
    public double calculate(double value) {
        return (value*9/5)+32;
    }
}

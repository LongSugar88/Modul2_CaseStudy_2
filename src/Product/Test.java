package Product;

public class Test {
    public static void main(String[] args) {
        WashingMachine washingMachine = new WashingMachine();
        washingMachine.reader();
        washingMachine.writer(1);
        washingMachine.writer(0);
    }
}

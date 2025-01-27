package operations;

public class FactoryOperationsMultiplicationThenSum implements FactoryOperations {

    public OperationSum createTopOperation() {
        return new OperationSum();
    }

    public OperationMultiplication createBottomOperation() {

        return new OperationMultiplication();
    }
}

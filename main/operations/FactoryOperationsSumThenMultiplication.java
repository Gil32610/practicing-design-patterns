package operations;

public class FactoryOperationsSumThenMultiplication implements FactoryOperations {

    public OperationMultiplication createTopOperation() {
        return new OperationMultiplication();
    }

    public OperationSum createBottomOperation() {
        return new OperationSum();
    }
}

package results;

import java.util.ArrayList;

import operations.Operation;
import operations.OperationMultiplication;

public class ResultComposite implements ResultComponent {
    private Operation operation;
    private ArrayList<ResultComponent> children;

    public ResultComposite(Operation operation) {
        this.operation = operation;
        this.children = new ArrayList<>();
    }

    public void addResult(ResultComponent resultComponent) {
        this.children.add(resultComponent);
    }

    public double getResult() {
        double[] childrenResults = new double[children.size()];
        for (int i = 0; i < childrenResults.length; i++) {
            childrenResults[i] = children.get(i).getResult();
        }
        double result = this.operation.calculate(childrenResults);

        return result;
    }

}

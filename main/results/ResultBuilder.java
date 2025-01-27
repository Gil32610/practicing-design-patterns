package results;

import operations.*;

public class ResultBuilder {

    private FactoryOperations factoryOperation;

    public ResultBuilder(FactoryOperations factoryOperation) {
        this.factoryOperation = factoryOperation;
    }

    public ResultComponent buildOperations(double[] leftValues, double[] rightValues) {
        ResultComposite root = new ResultComposite(this.factoryOperation.createTopOperation());
        ResultComponent lefTree = new ResultComposite(factoryOperation.createBottomOperation());
        ResultComponent rightTree = new ResultComposite(factoryOperation.createBottomOperation());
        for (int i = 0; i < rightValues.length; i++) {
            rightTree.addResult(new ResultLeaf(rightValues[i]));
        }
        for (int i = 0; i < leftValues.length; i++) {
            lefTree.addResult(new ResultLeaf(leftValues[i]));
        }
        root.addResult(lefTree);
        root.addResult(rightTree);
        return root;
    }

}

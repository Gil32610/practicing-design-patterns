package results.observer;

import operations.*;

public class ResultBuilder {

    private FactoryOperations factoryOperation;

    public ResultBuilder(FactoryOperations factoryOperation) {
        this.factoryOperation = factoryOperation;
    }

    public ResultComponent buildOperations(ResultLeaf[] leftValues, ResultLeaf[] rightValues,
            ResultComposite resultCompositeBottomLeft, ResultComposite resultCompositeBottomRight) {
        ResultComposite root = new ResultComposite(this.factoryOperation.createTopOperation());
        // for (int i = 0; i < leftValues.length; i++) {
        // resultCompositeBottomLeft.addResult(leftValues[i]);
        // }
        // for (ResultLeaf resultLeaf : rightValues) {
        // resultCompositeBottomRight.addResult(resultLeaf);
        // }

        // for (ResultLeaf resultLeaf : leftValues) {
        // resultCompositeBottomLeft.addResult(resultLeaf);
        // }
        // for (int i = 0; i < rightValues.length; i++) {
        // resultCompositeBottomRight.addResult(rightValues[i]);
        // }
        populateComposite(resultCompositeBottomRight, rightValues);
        populateComposite(resultCompositeBottomLeft, leftValues);
        root.addResult(resultCompositeBottomLeft);
        root.addResult(resultCompositeBottomRight);

        return root;
    }

    public void populateComposite(ResultComposite resultComposite, ResultLeaf[] resultLeafs) {
        for (int i = 0; i < resultLeafs.length; i++)
            resultComposite.addResult(resultLeafs[i]);
    }

}

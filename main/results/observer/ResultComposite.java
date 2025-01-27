package results.observer;

import java.util.ArrayList;
import br.unicap.eng2.atividade02.operations.Operation;
import br.unicap.eng2.atividade02.operations.OperationMultiplication;

public class ResultComposite implements ResultComponent {

    private Operation operation;
    private ArrayList<ResultComponent> children;
    private ArrayList<ResultObserver> observers;
    private double result;

    public ResultComposite(Operation operation) {
        this.operation = operation;
        children = new ArrayList<>();
        observers = new ArrayList<>();
        result = operation instanceof OperationMultiplication ? 1.0 : 0.0;
    }

    public void addResult(ResultComponent resultComponent) {
        result = operation.calculate(result, resultComponent.getResult());
        children.add(resultComponent);
        resultComponent.attach(this);
        notifyObservers(this);
    }

    public double getResult() {
        return this.result;
    }

    @Override
    public void attach(ResultObserver observer) {
        observers.add(observer);
    }

    @Override
    public void detach(ResultObserver observer) {

    }

    @Override
    public void notifyObservers(ResultComponent resultComponent) {
        if (observers.isEmpty()) {   
        } else {
            for (ResultObserver observer : observers) {
                observer.update(resultComponent);
            }
        }
    }

    @Override
    public void update(ResultSubject subject) { 
        // double newResult = children.get(0).getResult();
        // for (int i = 1; i < children.size(); i++) {
        //     newResult = operation.calculate(newResult, children.get(i).getResult());
        // }
        // result = newResult;
        // notifyObservers(this);
        double[] results = new double[children.size()];
        for (int i = 0; i<results.length;i++) {
            results[i] = children.get(i).getResult();
        }
        result = operation.calculate(results);
        notifyObservers(this);
        
    }

    public void setResult(double result) {
        this.result = result;
        notifyObservers(this);
    }

}

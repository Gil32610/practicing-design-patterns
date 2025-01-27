package results.observer;
import java.util.ArrayList;

public class ResultLeaf implements ResultComponent {
    private double result;
    
    private ArrayList<ResultObserver> observers;

    public ResultLeaf (double result){
        this.result = result;
        this.observers = new ArrayList<>();
    }

    public double getResult(){
        return this.result;
    }

    public void addResult(ResultComponent resultComponent){
        throw new RuntimeException();
    }

    @Override
    public void attach(ResultObserver observer) {
        this.observers.add(observer);
    }

    @Override
    public void detach(ResultObserver observer) {
        
        
    }

    @Override
    public void notifyObservers(ResultComponent resultComponent) {
        for (ResultObserver observer : observers) {
            observer.update(resultComponent);
        }
    }

    @Override
    public void update(ResultSubject subject) {
        
    }

    public void setResult(double result) {
        this.result = result;
        notifyObservers(this);
    }

    
}

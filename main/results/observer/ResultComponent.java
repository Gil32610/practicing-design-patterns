package results.observer;


public interface ResultComponent extends ResultSubject, ResultObserver {

    public double getResult(); 

    public void addResult(ResultComponent resultComponent);

    

}

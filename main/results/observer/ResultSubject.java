package results.observer;

public interface ResultSubject {
    public void attach(ResultObserver observer);

    public void detach(ResultObserver observer);

    public void notifyObservers(ResultComponent resultComponent);
}

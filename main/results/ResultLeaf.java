package results;

public class ResultLeaf implements ResultComponent {
    private double result;

    public ResultLeaf(double result) {
        this.result = result;
    }

    public double getResult() {
        return this.result;
    }

    public void addResult(ResultComponent resultComponent) {
        throw new RuntimeException();
    }
}

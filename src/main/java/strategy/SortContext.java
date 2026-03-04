package strategy;

public class SortContext {
    private SortStrategy strategy;
    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }
    public void executeSort(int[] arr) {
        strategy.sort(arr);
    }
}

package account;

import java.util.Map;

public class Client {
    private final Map<String, Double> orderLines;

    public Client(Map<String, Double> orderLines) {
        this.orderLines = orderLines;
    }

    public double getTotalAmount() {
        return orderLines.values()
                .stream()
                .mapToDouble(x -> x)
                .sum();
    }

    public Map<String, Double> getAllLines() {
        return orderLines;
    }
}


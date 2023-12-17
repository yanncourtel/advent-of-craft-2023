package account;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

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

    public String toStatement() {
        return orderLines.entrySet()
                .stream()
                .map(entry -> formatLine(entry.getKey(), entry.getValue()))
                .collect(Collectors.joining(System.lineSeparator()))
                .concat(formatTotal());
    }

    private String formatLine(String name, Double value) {
        return name + " for " + value + "€";
    }

    private String formatTotal() {
        return System.lineSeparator() + "Total : " + getTotalAmount() + "€";
    }

    public Map<String, Double> getAllLines() {
        return orderLines;
    }
}


package food;

import java.time.LocalDate;
import java.util.UUID;
import java.util.function.Supplier;

public record Food(LocalDate expirationDate,
                   Boolean approvedForConsumption,
                   UUID inspectorId) {
    public boolean isEdible(Supplier<LocalDate> now) {
        return hasExpired(now.get()) &&
               hasBeenApproved() &&
               hasBeenInspected();
    }

    private boolean hasExpired(LocalDate now) {
        return this.expirationDate.isAfter(now);
    }

    private boolean hasBeenApproved() {
        return this.approvedForConsumption;
    }

    private boolean hasBeenInspected() {
        return this.inspectorId != null;
    }
}
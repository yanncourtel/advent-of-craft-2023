import food.Food;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.UUID;
import java.util.stream.Stream;

import static java.time.LocalDate.of;
import static java.util.UUID.randomUUID;
import static org.assertj.core.api.Assertions.assertThat;

class EdibleTests {
    private static final LocalDate today = LocalDate.now();
    private static final LocalDate passedDate = today.plusDays(7);
    private static final LocalDate freshDate = today.minusDays(7);
    private static final UUID inspector = randomUUID();

    public static Stream<Arguments> notEdibleFood() {
        return Stream.of(
                Arguments.of(true, inspector, passedDate),
                Arguments.of(false, inspector, freshDate),
                Arguments.of(true, null, freshDate),
                Arguments.of(false, null, passedDate),
                Arguments.of(false, null, freshDate)
        );
    }

    @ParameterizedTest
    @MethodSource("notEdibleFood")
    void food_should_not_edible_if_not_fresh(boolean approvedForConsumption, UUID inspectorId, LocalDate now) {
        var food = new Food(
                today,
                approvedForConsumption,
                inspectorId);

        assertThat(food.isEdible(() -> now)).isFalse();
    }

    @Test
    void food_should_be_edible() {
        var food = new Food(
                today,
                true,
                inspector);

        assertThat(food.isEdible(() -> freshDate)).isTrue();
    }
}
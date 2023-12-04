import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import people.Person;
import people.Pet;
import people.PetType;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PopulationTests {

    @Test
    void whoOwnsTheYoungestPet() {
        var personWithAPetThatWasJustBorn =
                new Person("Glenn", "Quagmire")
                        .addPet(PetType.HAMSTER, "Toto", 0);

        var populationUnderTest = myExistingPopulation();
        populationUnderTest.add(personWithAPetThatWasJustBorn);

        var personWithYoungestPet = populationUnderTest.stream()
                .min(Comparator
                    .comparingInt(PopulationTests::getYoungestPetAgeForPerson))
                .orElse(null);

        assertThat(personWithYoungestPet)
                .isEqualTo(personWithAPetThatWasJustBorn);
    }

    private static ArrayList<Person> myExistingPopulation() {
        var population = new ArrayList<Person>();

        population.add(new Person("Peter", "Griffin")
                .addPet(PetType.CAT, "Tabby", 2));

        population.add(new Person("Stewie", "Griffin")
                .addPet(PetType.CAT, "Dolly", 3)
                .addPet(PetType.DOG, "Brian", 9));

        population.add(new Person("Joe", "Swanson")
                .addPet(PetType.DOG, "Spike", 4));

        population.add(new Person("Lois", "Griffin")
                .addPet(PetType.SNAKE, "Serpy", 1));

        population.add(new Person("Meg", "Griffin")
                .addPet(PetType.BIRD, "Tweety", 1));

        population.add(new Person("Chris", "Griffin")
                .addPet(PetType.TURTLE, "Speedy", 4));

        population.add(new Person("Cleveland", "Brown")
                .addPet(PetType.HAMSTER, "Fuzzy", 1)
                .addPet(PetType.HAMSTER, "Wuzzy", 2));

        population.add(new Person("Glenn", "Quagmire"));

        return population;
    }

    private static int getYoungestPetAgeForPerson(Person person) {
        return person.pets()
                .stream()
                .mapToInt(Pet::age)
                .min()
                .orElse(Integer.MAX_VALUE);
    }
}

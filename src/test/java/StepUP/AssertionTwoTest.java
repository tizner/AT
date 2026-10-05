package StepUP;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static StepUP.TestClass.*;
import static StepUP.PartTwoTest.*;


public class AssertionTwoTest {

    /*
    Задача 2: добавить в автотесты разработанные в задаче 2 темы «Gradle и JUnit» информативные ассерты (заменить
    проверки через if на ассерты). При падении ассерты должны дать информацию, что ожидалось и что было получено в
    результате падения. Дополнить задачу запуска автотестов фильтрацией, или по аннотации @Tag, или по пакету.
     Запустить каждый тестовый метод не менее 10 раз.
     */


    @RepeatedTest(10)
    @Tag("AssertionTwo")
    void checkIsEven() {
        Random random = new Random();
        int x = random.nextInt(100) + 1;
        Assertions.assertThat(isEven(x))
                .as("isEven - TEST FAILED")
                .isEqualTo((x % 2 == 0));


    }

    @RepeatedTest(10)
    @Tag("AssertionTwo")
    void checkCheckAccess() {
        Random random = new Random();
        int x = random.nextInt(100) + 1;
        Assertions.assertThat(checkAccess(x))
                .as("checkAccess - TEST FAILED")
                .isEqualTo((x > 18) ? "Allowed" : "Denied");
    }

    @RepeatedTest(10)
    @Tag("AssertionTwo")
    void checkIsPositive() {
        Random random = new Random();
        int x = random.nextInt(21) - 10;
        Assertions.assertThat(isPositive(x))
                .as("isPositive - TEST FAILED")
                .isEqualTo((x >= 0));

    }


    @RepeatedTest(10)
    @Tag("AssertionTwo")
    void checkGetGrade() {
        Random random = new Random();
        int x = random.nextInt(100 + 1);
        String score = "";
        if ((x >= 0) && (x <= 20)) {
            score = "E";
        } else if ((x >= 21) && (x <= 40)) {
            score = "D";
        } else if ((x >= 41) && (x <= 60)) {
            score = "C";
        } else if ((x >= 61) && (x <= 80)) {
            score = "B";
        } else if ((x >= 81) && (x <= 100)) {
            score = "A";
        } else score = "Error";

        Assertions.assertThat(getGrade(x))
                .as("getGrade - TEST FAILED")
                .isEqualTo(score);

    }

    @RepeatedTest(10)
    @Tag("AssertionTwo")
    void checkBlastOff() {
        Random random = new Random();
        int x = random.nextInt(10);
        String blast = "";
        for (int i = x; i > 0; i--) {
            blast = blast + " " + i;
        }
        blast += " Поехали!";
        blast = blast.trim();

        Assertions.assertThat(blastOff(x))
                .as("blastOff - TEST FAILED")
                .isEqualTo(blast);

    }


    @RepeatedTest(10)
    @Tag("AssertionTwo")
    void checkSumToN() {
        Random random = new Random();
        int x = random.nextInt(10);
        int sum = 0;
        for (int i = 0; i <= x; i++) {
            sum += i;
        }

        Assertions.assertThat(sumToN(x))
                .as("sumToN - TEST FAILED")
                .isEqualTo(sum);

    }


    @RepeatedTest(10)
    @Tag("AssertionTwo")
    void checkHasBug() {
        Random random = new Random();
        boolean test = false;
        int size = random.nextInt(5) + 1;
        String[] messages = new String[size];
        for (int i = 0; i < size; i++) {
            if (random.nextBoolean()) {
                messages[i] = "Bug";
            } else {
                messages[i] = "Item" + random.nextInt(100);
            }
        }
        for (String message : messages) {
            if (message.equalsIgnoreCase("Bug")) {
                test = true;
            }
        }

        Assertions.assertThat(hasBug(messages))
                .as("hasBug - TEST FAILED")
                .isEqualTo(test);

    }


    @RepeatedTest(10)
    @Tag("AssertionTwo")
    void checkGetEvenInRange() {
        String str = "";
        Random random = new Random();
        int x1 = random.nextInt(10);
        int x2 = random.nextInt(10);
        int min = 0;
        int max = 0;
        if (x1 > x2) {
            min = x2;
            max = x1;
        } else {
            min = x1;
            max = x2;
        }
        for (int i = min; i <= max; i++) {
            if (i % 2 == 0) {
                str += " " + i;
            }
        }
        str = str.trim();

        Assertions.assertThat(getEvenInRange(min, max))
                .as("getEvenInRange - TEST FAILED")
                .isEqualTo(str);

    }


        static Stream<int[]> generateRandomArray() {
            Random random = new Random();
            return Stream.generate(() -> {
                int length = random.nextInt(10) + 1;
                int[] array = new int[length];
                for (int i = 0; i < length; i++) {
                    array[i] = random.nextInt(100);
                }
                return array;
            }).limit(10);
        }


    @Tag("AssertionTwo")
    @ParameterizedTest
    @MethodSource("generateRandomArray")
    void checkFindMax(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i])
                max = arr[i];
        }

        Assertions.assertThat(findMax(arr))
                .as("findMax - TEST FAILED")
                .isEqualTo(max);

    }


    static Stream<Arguments> provideFiveRandomLetterNames() {
        var rng = new Random(42); // фиксированный seed для воспроизводимости
        List<String> baseNames = List.of(
                "Alpha", "Bravo", "Charlie", "Delta", "Echo",
                "Foxtrot", "Golf", "Hotel", "India", "Juliet"
        );

        return Stream.generate(() -> {
                    var shuffled = new ArrayList<>(baseNames);
                    Collections.shuffle(shuffled, rng);
                    return shuffled.stream()
                            .limit(5)
                            .toArray(String[]::new);
                })
                .limit(10)
                .map(arr -> Arguments.of((Object) arr));
    }

    @Tag("AssertionTwo")
    @ParameterizedTest
    @MethodSource("provideFiveRandomLetterNames")
    void checkReverse(String[] arr) {
        String[] revers = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            revers[i] = arr[arr.length - 1 - i];
        }

        Assertions.assertThat(reverse(arr))
                .as("reverse - TEST FAILED")
                .isEqualTo(revers);

    }

    static Stream<Arguments> generateRandomList() {
        var rng = new Random(42);
        List<Integer> baseList = IntStream.range(0, 10)
                .boxed()
                .collect(Collectors.toList());

        return Stream.generate(() -> {
                    var shuffled = new ArrayList<>(baseList);
                    Collections.shuffle(shuffled, rng);
                    return shuffled;
                })
                .limit(10)
                .map(list -> Arguments.of(list));
    }


    @Tag("AssertionTwo")
    @ParameterizedTest
    @MethodSource("generateRandomList")
    void checkCalcAverage(List<Integer> list) {
        int size = list.size();
        float avg = 0;
        float sum = 0;
        for (Integer number : list) {
            sum += number;
        }
        avg = sum / size;

        Assertions.assertThat(calcAverage(list))
                .as("calcAverage - TEST FAILED")
                .isEqualTo(avg);

    }



    static Stream<Arguments> provideFiveRandomLetterNamesToRemove() {
        var rng = new Random(42); // фиксированный seed для воспроизводимости
        List<String> baseNames = List.of(
                "Alpha", "Bravo", "Charlie", "Delta", "Echo",
                "Foxtrot", "Golf", "Hotel", "India", "Juliet"
        );

        return Stream.generate(() -> {
                    var shuffled = new ArrayList<>(baseNames);
                    Collections.shuffle(shuffled, rng);

                    List<String> firstFive = shuffled.stream()
                            .limit(5)
                            .toList();

                    // имя для удаления берём из полного перемешанного списка
                    String nameToRemove = shuffled.get(rng.nextInt(shuffled.size()));

                    return Arguments.of(firstFive, nameToRemove);
                })
                .limit(10)
                .map(args -> args);
    }
    @Tag("AssertionTwo")
    @ParameterizedTest
    @MethodSource("provideFiveRandomLetterNamesToRemove")
    void checkRemoveSpecificName(List<String> list, String nameToRemove) {
        List<String> result = new ArrayList<>();
        for (String name : list) {
            if (!name.equals(nameToRemove)) {
                result.add(name);
            }
        }

        Assertions.assertThat(removeSpecificName(list, nameToRemove))
                .as("removeSpecificName  - TEST FAILED")
                .isEqualTo(result);

    }

}

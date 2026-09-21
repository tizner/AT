package StepUP;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static StepUP.TestClass.*;


public class PartTwoTest {

    /*
    * Задача 2: в проект, созданный в задаче 1, добавить тестовый класс или набор классов, содержащих запуск всех
    * тестовых методов, разработанных в ДЗ к теме «Базовая Java», и проверку, что результат работы равен эталонному.
    * Использование assert не требуется, достаточно проверить в условном операторе и вывести на
    * экран строку TEST PASSED или TEST FAILED. Данные для запуска тестов должны быть сгенерированы случайно или взяты из CSV,
    *  прикреплённого к проекту. Как минимум 4 метода должны вызываться с аннотацией:
1. @Test
2. @RepeatedTest
3. @ParametrizedTest
    * */

    @Test
    void checkIsEven() {
        Random random = new Random();
        int x = random.nextInt(100) + 1;
        if (isEven(x) == (x % 2 == 0)) {
            System.out.println("isEven - TEST PASSED");
        } else {
            System.out.println("isEven - TEST FAILED");
        }
    }

    @Test
    void checkCheckAccess() {
        Random random = new Random();
        int x = random.nextInt(100) + 1;
        if (checkAccess(x) == ((x > 18) ? "Allowed" : "Denied")) {
            System.out.println("checkAccess - TEST PASSED");
        } else {
            System.out.println("checkAccess - TEST FAILED");
        }
    }

    @Test
    void checkIsPositive() {
        Random random = new Random();
        int x = random.nextInt(21) - 10;
        ;
        if (isPositive(x) == (x >= 0)) {
            System.out.println("isPositive - TEST PASSED");
        } else {
            System.out.println("isPositive - TEST FAILED");
        }
    }


    @Test
    void checkGetGrade() {
        Random random = new Random();
        int x = random.nextInt(100 + 1);
        String score;
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

        if (getGrade(x) == score) {
            System.out.println("getGrade - TEST PASSED");
        } else {
            System.out.println("getGrade - TEST FAILED");
        }
    }

    @RepeatedTest(5)
    void checkBlastOff() {
        Random random = new Random();
        int x = random.nextInt(10);
        String blast = "";
        for (int i = x; i > 0; i--) {
            blast = blast + " " + i;
        }
        blast += " Поехали!";
        blast = blast.trim();

        if (blastOff(x).equals(blast)) {
            System.out.println("checkAccess - TEST PASSED");
        } else {
            System.out.println("checkAccess - TEST FAILED");
        }
    }


    @RepeatedTest(6)
    void checkSumToN() {
        Random random = new Random();
        int x = random.nextInt(10);
        int sum = 0;
        for (int i = 0; i <= x; i++) {
            sum += i;
        }

        if (sumToN(x) == sum) {
            System.out.println("isPositive - TEST PASSED");
        } else {
            System.out.println("isPositive - TEST FAILED");
        }
    }


    @RepeatedTest(7)
    void checkHasBug() {
        Random random = new Random();
        boolean test = false;
        //Генерация массива строк
        int size = random.nextInt(5) + 1; // от 1 до 5 элементов
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

        if (hasBug(messages) == test) {
            System.out.println("isPositive - TEST PASSED");
        } else {
            System.out.println("isPositive - TEST FAILED");
        }
    }


    @RepeatedTest(8)
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
        if (getEvenInRange(min, max).equals(str)) {
            System.out.println("isPositive - TEST PASSED");
        } else {
            System.out.println("isPositive - TEST FAILED");
        }
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
        }).limit(1);
    }


    @ParameterizedTest
    @MethodSource("generateRandomArray")
    void checkFindMax(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i])
                max = arr[i];
        }

        if (findMax(arr) == max) {
            System.out.println("isPositive - TEST PASSED");
        } else {
            System.out.println("isPositive - TEST FAILED");
        }

    }


    static Stream<Arguments> provideFiveRandomLetterNames() {
        var rng = new Random(42);

        List<String> names = new ArrayList<>(List.of(
                "Alpha", "Bravo", "Charlie", "Delta", "Echo",
                "Foxtrot", "Golf", "Hotel", "India", "Juliet"
        ));

        Collections.shuffle(names, rng);

        String[] firstFive = names.stream()
                .limit(5)
                .toArray(String[]::new);

        return Stream.of(Arguments.of((Object) firstFive));
    }

    @ParameterizedTest
    @MethodSource("provideFiveRandomLetterNames")
    void checkReverse(String[] arr) {
        String[] revers = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            revers[i] = arr[arr.length - 1 - i];
        }

        if (Arrays.equals(revers, reverse(arr))) {
            System.out.println("isPositive - TEST PASSED");
        } else {
            System.out.println("isPositive - TEST FAILED");
        }

    }

    static Stream<Arguments> generateRandomList() {

        List<Integer> list = IntStream.range(0, 10)
                .boxed()                          // превращает IntStream → Stream<Integer>
                .collect(Collectors.toList());

        return Stream.of(Arguments.of(list));
    }

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

        if (avg == calcAverage(list)) {
            System.out.println("isPositive - TEST PASSED");
        } else {
            System.out.println("isPositive - TEST FAILED");
        }

    }

    static Stream<Arguments> provideFiveRandomLetterNamesToRemove() {
        var rng = new Random(42);

        List<String> names = new ArrayList<>(List.of(
                "Alpha", "Bravo", "Charlie", "Delta", "Echo",
                "Foxtrot", "Golf", "Hotel", "India", "Juliet"
        ));

        Collections.shuffle(names, rng);

        // Берём первые 5 — это будет входной список для теста
        List<String> firstFive = names.stream()
                .limit(5)
                .toList();

        // А nameToRemove берём из полного списка names (может быть и вне firstFive)
        String nameToRemove = names.get(rng.nextInt(names.size()));

        return Stream.of(Arguments.of(firstFive, nameToRemove));
    }

    @ParameterizedTest
    @MethodSource("provideFiveRandomLetterNamesToRemove")
    void checkRemoveSpecificName(List<String> list, String nameToRemove) {
        List<String> result = new ArrayList<>();
        for (String name : list) {
            if (!name.equals(nameToRemove)) {
                result.add(name);
            }
        }
        if (result.equals(removeSpecificName(list,nameToRemove))) {
            System.out.println("isPositive - TEST PASSED");
        } else {
            System.out.println("isPositive - TEST FAILED");
        }

    }



}











package StepUP;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static StepUP.TestClass.*;
import static StepUP.TestClass.isEven;

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


}








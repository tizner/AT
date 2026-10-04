package StepUP;

import static StepUP.TestClass.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class AssertionOneTest {


    /*
    Задача 1: написать 4 автотеста, использующих в работе ассерты. Методы, которые будут проверяться автотестами, можно
    написать самостоятельно или взять из предыдущих заданий.Требования к методам — хотя бы один метод:

возвращает булево значение;
должен возвращать список;
должен вернуть неверное значение (ассерт должен падать).
При падении ассерты должны дать информацию, что ожидалось и что было получено в результате падения.
     */

    @Test
    void testIsEvenMethod() {
        boolean expectedResult = true;
        Assertions.assertEquals(expectedResult, isEven(2));
    }



    @Test
    void testRemoveSpecificNameMethod() {
        List<String> source = Arrays.asList("Alf", "Bob", "Joe");
        List<String> expected = Arrays.asList("Alf", "Joe");
        Assertions.assertEquals(expected, removeSpecificName(source, "Bob"));

    }


    @Test
    void testIsPositiveMethod(){
        Assertions.assertEquals(true, isPositive(-7));
    }



    @Test
    void testHasBugMethod(){
        String[] messages = {"Mother", "Father"};
        Assertions.assertEquals(true, hasBug(messages));
    }


}

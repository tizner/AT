package StepUP;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.Random;
import java.util.stream.Stream;
import static StepUP.TestClass.*;


public class PartOneTest {

    @BeforeEach
    void TestMethodStart() {
        System.out.println(" ");
        System.out.println("========================Test method start");
        System.out.println(" ");
    }

    @AfterEach
    void TestMethodEnd() {
        System.out.println(" ");
        System.out.println("Test method end");
        System.out.println("========================");
    }

    @Test
    void checkIsEven() {
        Random random = new Random();
        int x = random.nextInt(100) + 1;
        System.out.println(isEven(x));
    }

    @RepeatedTest(20)
    void testCheckAccess() {
        Random random = new Random();
        int x = random.nextInt(100);
        System.out.println(checkAccess(x));
    }


    static Stream<Integer> randomInt() {
        int singleScore = (int) (Math.random() * 101); // число от 0 до 100
        return Stream.of(singleScore);
    }


    @ParameterizedTest
    @MethodSource("randomInt")
    void checkGetGrande(int score) {
        System.out.println(getGrade(score));

    }


}

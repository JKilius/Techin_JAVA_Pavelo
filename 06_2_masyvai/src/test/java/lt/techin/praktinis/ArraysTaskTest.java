package lt.techin.praktinis;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Arrays Task")
public class ArraysTaskTest {


    static Stream<Arguments> provideArgumentsForAverage() {
        return Stream.of(
                Arguments.of(new int[]{5, 4, 5, 4, 9, 4, 9, 4, 5, 4}, 5.3),
                Arguments.of(new int[]{6, 4, 8, 9, 6, 2, 1, 4, 5, 9, 9}, 5.73),
                Arguments.of(new int[]{7, 7, 9, 3, 6, 9, 2, 5, 6, 9}, 6.3),
                Arguments.of(new int[]{70, 46, 100, 33, 68, 25, 17, 49}, 51.0),
                Arguments.of(new int[]{6, 4, 7, 0, 1, 2, 1, 4, 4, 4, 4, 5, 10}, 4.0)
        );
    }

    static Stream<Arguments> provideArgumentsForMin() {
        return Stream.of(
                Arguments.of(new int[]{5, 4, 5, 4, 9, 4, 9, 4, 5, 4}, 4),
                Arguments.of(new int[]{6, 4, 8, 9, 6, 2, 1, 4, 5, 9, 9}, 1),
                Arguments.of(new int[]{7, 7, 9, 3, 6, 9, 2, 5, 6, 9}, 2),
                Arguments.of(new int[]{70, 46, 100, 33, 68, 25, 17, 49}, 17),
                Arguments.of(new int[]{6, 4, 7, 0, 1, 2, 1, 4, 4, 4, 4, 5, 10}, 0)
        );
    }

    static Stream<Arguments> provideArgumentsForMax() {
        return Stream.of(
                Arguments.of(new int[]{5, 4, 5, 4, 9, 4, 9, 4, 5, 4}, 9),
                Arguments.of(new int[]{6, 4, 8, 9, 6, 2, 1, 4, 5, 9, 9}, 9),
                Arguments.of(new int[]{7, 7, 9, 3, 6, 9, 2, 5, 6, 9}, 9),
                Arguments.of(new int[]{70, 46, 100, 33, 68, 25, 17, 49}, 100),
                Arguments.of(new int[]{6, 4, 7, 0, 1, 2, 1, 4, 4, 4, 4, 5, 10}, 10)
        );
    }

    static Stream<Arguments> provideArgumentsForFirst() {
        return Stream.of(
                Arguments.of(new int[]{5, 4, 5, 4, 9, 4, 9, 4, 5, 4}, 5),
                Arguments.of(new int[]{6, 4, 8, 9, 6, 2, 1, 4, 5, 9, 9}, 6),
                Arguments.of(new int[]{70, 46, 100, 33, 68, 25, 17, 49}, 70),
                Arguments.of(new int[]{6, 4, 7, 0, 1, 2, 1, 4, 4, 4, 4, 5, 10}, 6)
        );
    }
    static Stream<Arguments> provideArgumentsForLast() {
        return Stream.of(
                Arguments.of(new int[]{5, 4, 5, 4, 9, 4, 9, 4, 5, 4}, 4),
                Arguments.of(new int[]{6, 4, 8, 9, 6, 2, 1, 4, 5, 9, 9}, 9),
                Arguments.of(new int[]{70, 46, 100, 33, 68, 25, 17, 49}, 49)

        );
    }

    static Stream<Arguments> provideArgumentsForSum() {
        return Stream.of(
                Arguments.of(new int[]{5, 4, 5, 4, 9}, 27),
                Arguments.of(new int[]{1, 1, 1, 1, 1, 1, 1, 2}, 9),
                Arguments.of(new int[]{70, 46, 100}, 216)

        );
    }

    static Stream<Arguments> provideArgumentsForCountElements() {
        return Stream.of(
                Arguments.of(new int[]{5, 4, 5, 4, 9}, 4, 3),
                Arguments.of(new int[]{1, 5, 1, 4, 1, 1, 7, 4},2, 4),
                Arguments.of(new int[]{70, 46, 100}, 50, 2)

        );
    }

    static Stream<Arguments> provideArgumentsForContains() {
        return Stream.of(
                Arguments.of(new int[]{5, 4, 5, 4, 9}, 4, true),
                Arguments.of(new int[]{1, 5, 1, 4, 1, 1, 7, 4},2, false),
                Arguments.of(new int[]{70, 46, 100, 33, 68, 25, 17, 49}, 49, true),
                Arguments.of(new int[]{6, 4, 7, 0, 1, 2, 1, 4, 4, 4, 4, 5, 10}, 6, true)

        );
    }

    static Stream<Arguments> provideArgumentsForLastIndexOf() {
        return Stream.of(
                Arguments.of(new int[]{5, 4, 5, 4, 9, 4}, 4, 5),
                Arguments.of(new int[]{6, 4, 8, 9,  2, 1, 4, 5, 9, 9}, 6, 0),
                Arguments.of(new int[]{7, 7, 9, 3, 6, 9, 2, 5, 6, 9}, 7, 1),
                Arguments.of(new int[]{70, 46, 49}, 49, 2),
                Arguments.of(new int[]{6, 4, 7, 0, 1, 2, 1, 4, 4, 4, 4, 5, 10}, 99, -1)
        );
    }


    @ParameterizedTest(name = "ArraysTask: {0}")
    @MethodSource("provideArgumentsForFirst")
    @DisplayName("FirstElement")
    void getFirstElementTest(int[] marks, int expected) {
        int actual = ArraysTask.getFirstElement(marks);

        assertEquals(expected, actual);
    }

    @ParameterizedTest(name = "ArraysTask: {0}")
    @MethodSource("provideArgumentsForLast")
    @DisplayName("Last")
    void getLastElementTest(int[] marks, int expected) {
        int actual = ArraysTask.getLastElement(marks);

        assertEquals(expected, actual);
    }

    @ParameterizedTest(name = "ArraysTask: {0}")
    @MethodSource("provideArgumentsForMin")
    @DisplayName("Min")
    void getMinMarkTest(int[] marks, int expected) {
        int actual = ArraysTask.getMin(marks);

        assertEquals(expected, actual);
    }

    @ParameterizedTest(name = "ArraysTask: {0}")
    @MethodSource("provideArgumentsForMax")
    @DisplayName("Max")
    void getMaxMarkTest(int[] marks, int expected) {
        int actual = ArraysTask.getMax(marks);

        assertEquals(expected, actual);
    }

    @ParameterizedTest(name = "ArraysTask: {0}")
    @MethodSource("provideArgumentsForAverage")
    @DisplayName("Average")
    void getAverageMarkTest(int[] marks, double expected) {
        double actual = ArraysTask.getAverage(marks);

        assertEquals(expected, actual, 0.01);
    }

    @ParameterizedTest(name = "ArraysTask: {0}")
    @MethodSource("provideArgumentsForSum")
    @DisplayName("Sum")
    void getSumTest(int[] marks, int expected) {
        int actual = ArraysTask.getSum(marks);

        assertEquals(expected, actual);
    }


    @ParameterizedTest(name = "ArraysTask: {0}")
    @MethodSource("provideArgumentsForCountElements")
    @DisplayName("CountElements ")
    void countElementsTest(int[] marks,int n, int expected) {
        int actual = ArraysTask.countElements(marks, n);

        assertEquals(expected, actual);
    }

    @ParameterizedTest(name = "ArraysTask: {0}")
    @MethodSource("provideArgumentsForContains")
    @DisplayName("Contains ")
    void containsTest(int[] marks,int n, boolean expected) {
        boolean actual = ArraysTask.contains(marks, n);

        assertEquals(expected, actual);
    }

    @ParameterizedTest(name = "ArraysTask: {0}")
    @MethodSource("provideArgumentsForLastIndexOf")
    @DisplayName("LastIndexOf ")
    void lastIndexOfTest(int[] marks,int n, int expected) {
        int actual = ArraysTask.lastIndexOf(marks, n);

        assertEquals(expected, actual);
    }



}

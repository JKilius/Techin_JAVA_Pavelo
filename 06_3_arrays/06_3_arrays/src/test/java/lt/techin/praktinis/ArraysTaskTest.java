package lt.techin.praktinis;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("06_3 Arrays Task")
public class ArraysTaskTest {

    static Stream<Arguments> provideArgumentsForGenerateRandomArray() {
        return Stream.of(
                Arguments.of(5, 1, 10),
                Arguments.of(0, 1, 10),
                Arguments.of(5, 5, 5),
                Arguments.of(15, -5, 5)
        );
    }


    static Stream<Arguments> provideArgumentsForRemoveElement() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 2, new int[]{1, 2, 4, 5}),
                Arguments.of(new int[]{1, 2, 3}, 0, new int[]{2, 3}),
                Arguments.of(new int[]{9}, 0, new int[]{}),
                Arguments.of(new int[]{}, -1, null),
                Arguments.of(new int[]{1, 2, 3}, 3, null)
        );
    }

    static Stream<Arguments> provideArgumentsForInsertElement() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 2, 99, new int[]{1, 2, 99, 3, 4, 5}),
                Arguments.of(new int[]{1, 2, 3}, 0, 99, new int[]{99, 1, 2, 3}),
                Arguments.of(new int[]{9}, 0, 99, new int[]{99, 9}),
                Arguments.of(new int[]{}, 0, 99, null),
                Arguments.of(new int[]{1, 2, 3}, 3, 99, null)
        );
    }


    static Stream<Arguments> provideArgumentsForReverseArray() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{5, 4, 3, 2, 1}),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, new int[]{6, 5, 4, 3, 2, 1}),
                Arguments.of(new int[]{}, new int[]{}),
                Arguments.of(new int[]{9}, new int[]{9})
        );
    }

    static Stream<Arguments> provideArgumentsForReverse() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{5, 4, 3, 2, 1}),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, new int[]{6, 5, 4, 3, 2, 1}),
                Arguments.of(new int[]{}, new int[]{}),
                Arguments.of(new int[]{9}, new int[]{9})
        );
    }

    @ParameterizedTest(name = "generateRandomArray: size={0}, min={1}, max={2}")
    @MethodSource("provideArgumentsForGenerateRandomArray")
    @DisplayName("Generate Random Array")
    void generateRandomArrayTest(int size, int min, int max) {
        int[] result = ArraysTask.generateRandomArray(size, min, max);


        assertEquals(size, result.length);


        for (int elem : result) {
            assertTrue(elem >= min && elem <= max);
        }
    }


    @ParameterizedTest(name = "removeElementAndReturnNewArray: {0}")
    @MethodSource("provideArgumentsForRemoveElement")
    @DisplayName("Remove Element and Return New Array")
    void removeElementAndReturnNewArrayTest(int[] original, int k, int[] expected) {
        int[] result = ArraysTask.removeElementAndReturnNewArray(original, k);
        assertArrayEquals(expected, result);
    }


    @ParameterizedTest(name = "insertElementAndReturnNewArray: {0}")
    @MethodSource("provideArgumentsForInsertElement")
    @DisplayName("Insert Element and Return New Array")
    void insertElementAndReturnNewArrayTest(int[] original, int k, int x, int[] expected) {
        int[] result = ArraysTask.insertElementAndReturnNewArray(original, k, x);
        assertArrayEquals(expected, result);
    }





    @ParameterizedTest(name = "reverseArray: {0}")
    @MethodSource("provideArgumentsForReverseArray")
    @DisplayName("Reverse Array")
    void reverseArrayTest(int[] input, int[] expected) {
        int[] result = ArraysTask.reverseArray(input);
        assertArrayEquals(expected, result);
    }


    @ParameterizedTest(name = "reverseInPlace: {0}")
    @MethodSource("provideArgumentsForReverse")
    @DisplayName("Reverse In Place")
    void reverseInPlaceTest(int[] input, int[] expected) {
        int[] sameReference = input;
        ArraysTask.reverseInPlace(input);

        assertArrayEquals(expected, input);
        assertSame(sameReference, input);
    }


}

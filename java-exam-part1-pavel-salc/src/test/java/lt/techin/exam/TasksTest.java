package lt.techin.exam;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class TasksTest extends BaseIOTest {



    static Stream<Arguments> args_convertToMeters() {
        return Stream.of(
                Arguments.of(5, 123, "5123 metrų\n"),
                Arguments.of(2, 5, "2005 metrų\n"),
                Arguments.of(0, 4, "4 metrų\n"),
                Arguments.of(0, 0, "0 metrų\n")


        );
    }


    @ParameterizedTest(name = "{0} and {1} => {2}")
    @MethodSource("args_convertToMeters")
    @DisplayName("convertToMeters")
    void convertToMetersTest(int first, int second, String expected) {

        Tasks.convertToMeters(first, second);
        assertEquals(expected, updateLineSpliterators(outContent.toString()));
    }




    static Stream<Arguments> args_convertCentsToEuros() {
        return Stream.of(
                Arguments.of(234,  "Gauta: 2 Eur ir 34 ct\n"),
                Arguments.of(55,  "Gauta: 0 Eur ir 55 ct\n"),
                Arguments.of(333, "Gauta: 3 Eur ir 33 ct\n")



        );
    }


    @ParameterizedTest(name = "{0}  => {1}")
    @MethodSource("args_convertCentsToEuros")
    @DisplayName("convertCentsToEuros")
    void convertCentsToEurosTest(int first,  String expected) {

        Tasks.convertCentsToEuros(first);
        assertEquals(expected, updateLineSpliterators(outContent.toString()));
    }



    public static double averageOf(int a, int b, int c) {
        return 0.0;
    }
    static Stream<Arguments> args_averageOf() {
        return Stream.of(
                Arguments.of(1, 2, 3, 2.0),
                Arguments.of(1, 1, 3, 1.66666),
                Arguments.of(2, 2, 3, 2.33333)




        );
    }


    @ParameterizedTest(name = "{0} {1} {2} => {3}")
    @MethodSource("args_averageOf")
    @DisplayName("averageOf")
    void averageOfTest(int a, int b, int c,  double expected) {


        assertEquals(expected, Tasks.averageOf(a, b, c), 0.001);
    }



    static Stream<Arguments> args_isEven() {
        return Stream.of(
                Arguments.of(1, 2, 3,true),
                Arguments.of(1, 1, 3,false),
                Arguments.of(4, 6, 3,true)




        );
    }


    @ParameterizedTest(name = "{0} {1} {2} => {3}")
    @MethodSource("args_isEven")
    @DisplayName("isEven")
    void isEvenTest(int a, int b, int c,  boolean expected) {


        assertEquals(expected, Tasks.isEven(a, b, c));
    }



    @Test
    @DisplayName("isTriangleValid")
    void isTriangleValidTest() {
        assertTrue(Tasks.isTriangleValid(2, 3, 4));
        assertFalse(Tasks.isTriangleValid(7, 2, 3));
        assertFalse(Tasks.isTriangleValid(3, 2, 7));
    }




    static Stream<Arguments> args_printOddNumbers() {
        return Stream.of(
                Arguments.of(8, "7\n5\n3\n1\n"),
                Arguments.of(11, "11\n9\n7\n5\n3\n1\n"),
                Arguments.of(1, "1\n")


        );
    }


    @ParameterizedTest(name = "number: {0} ")
    @MethodSource("args_printOddNumbers")
    @DisplayName("printOddNumbers")
    void printOddNumbersTest(int number, String expected) {

        Tasks.printOddNumbers(number);
        assertEquals(expected, updateLineSpliterators(outContent.toString()));
    }












    static Stream<Arguments> args_countLargerThanNumber() {
        return Stream.of(
                Arguments.of(new int[]{1, 20, 30,  5}, 10, 2),
                Arguments.of(new int[]{100, 20, 30,  5, 60}, 15, 4),
                Arguments.of(new int[]{1, 2, 3,  }, 5, 0)


        );
    }


    @ParameterizedTest(name = "countLargerThanNumber")
    @MethodSource("args_countLargerThanNumber")
    @DisplayName("countLargerThanNumber")
    void multiplyBy2Test(int[] arr, int number,  int expected) {

        int result = Tasks.countLargerThanNumber(arr, number);
        assertEquals(result, expected);

    }






    static Stream<Arguments> args_findSmallest() {
        return Stream.of(
                Arguments.of(new ArrayList<Double>(List.of(6.7, 3.5, 1.2)), 1.2),
                Arguments.of(new ArrayList<Double>(List.of(1.1, 3.5, 1.7, 2.4)), 1.1),
                Arguments.of(new ArrayList<Double>(List.of( 1.3)), 1.3)


        );
    }


    @ParameterizedTest(name = "findSmallest")
    @MethodSource("args_findSmallest")
    @DisplayName("findSmallest")
    void findSmallestTest(ArrayList<Double> words, double expected) {

        double result = Tasks.findSmallest(words);
        assertEquals(result, expected, 0.001);
    }


    static Stream<Arguments> args_countLettersInList() {
        return Stream.of(
                Arguments.of(new ArrayList<String>(List.of("aaa", "AcC")), 6),
                Arguments.of(new ArrayList<String>(List.of("Qaazll", "Bbb", "WcC")), 12),
                Arguments.of(new ArrayList<String>(List.of()), 0)


        );
    }


    @ParameterizedTest(name = "countLettersInList")
    @MethodSource("args_countLettersInList")
    @DisplayName("countLettersInList")
    void countLettersInListTest(ArrayList<String> words, int expected) {

        int result = Tasks.countLettersInList(words);
        assertEquals(expected, result);
    }


    static Stream<Arguments> args_countStringsContainingWord() {
        return Stream.of(
                Arguments.of(new ArrayList<String>(List.of("aaa", "Bbb", "AcC")), "a", 2),
                Arguments.of(new ArrayList<String>(List.of("Qaa", "Bbb", "WcC")), "bb", 1),
                Arguments.of(new ArrayList<String>(List.of("aaa")),"b", 0)


        );
    }


    @ParameterizedTest(name = "countStringsContainingWord")
    @MethodSource("args_countStringsContainingWord")
    @DisplayName("countStringsContainingWord")
    void countWordsStartingWithATest(ArrayList<String> words,String word, int expected) {

        int result = Tasks.countStringsContainingWord(words, word);
        assertEquals(result, expected);
    }


    static Stream<Arguments> args_countDisplayedElements() {
        Element a = new Element("aaa", true);
        Element b = new Element("bbb", true);
        Element c = new Element("ccc", false);
        Element d = new Element("ddd", true);

        return Stream.of(
                Arguments.of(new ArrayList<Element>(List.of(a, b)), 2),
                Arguments.of(new ArrayList<Element>(List.of(a, b, c)), 2),
                Arguments.of(new ArrayList<Element>(List.of(a, b, c, d)), 3),
                Arguments.of(new ArrayList<Element>(List.of(c)), 0)


        );
    }


    @ParameterizedTest(name = "countDisplayedElements")
    @MethodSource("args_countDisplayedElements")
    @DisplayName("countDisplayedElements")
    void countDisplayedElementsTest(ArrayList<Element> elements, int expected) {

        int result = Tasks.countDisplayedElements(elements);
        assertEquals(expected, result);
    }


    static Stream<Arguments> args_findNonEmptyLinks() {
        Element a = new Element("aaa", true);
        Element b = new Element("", true);
        Element c = new Element("ccc", false);
        Element d = new Element(" ", true);

        return Stream.of(
                Arguments.of(new ArrayList<Element>(List.of(a, b)), new ArrayList<Element>(List.of(a))),
                Arguments.of(new ArrayList<Element>(List.of(a, b, c)), new ArrayList<Element>(List.of(a, c))),
                Arguments.of(new ArrayList<Element>(List.of(a, b, c, d)), new ArrayList<Element>(List.of(a, c)))


        );
    }


    @ParameterizedTest(name = "findNonEmptyLinks")
    @MethodSource("args_findNonEmptyLinks")
    @DisplayName("findNonEmptyLinks")
    void findNonEmptyLinksTest(List<Element> elements, List<Element> expected) {

        List<Element> result = Tasks.findElementsWithNonEmptyTexts(elements);
        assertEquals(expected, result);
    }


    static Stream<Arguments> args_findElementWithMaxPrice() {
        Element a = new Element("$2.20", true);
        Element b = new Element("$3.00", true);
        Element c = new Element("$2.30", false);
        Element d = new Element("$2.50", true);

        return Stream.of(
                Arguments.of(new ArrayList<Element>(List.of(a, b)), 5.2),
                Arguments.of(new ArrayList<Element>(List.of(a, b, c)), 7.5),
                Arguments.of(new ArrayList<Element>(List.of(a, b, c, d)), 10.0)


        );
    }


    @ParameterizedTest(name = "findElementWithMaxPrice")
    @MethodSource("args_findElementWithMaxPrice")
    @DisplayName("findElementWithMaxPrice")
    void findElementWithMaxPriceTest(ArrayList<Element> elements, double expected) {

        double result = Tasks.findSumOfPrices(elements);
        assertEquals(expected, result, 0.01);
    }


}

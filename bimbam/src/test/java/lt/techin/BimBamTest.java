package lt.techin;

import com.sun.tools.javac.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BimBamTest extends BaseIOTest{

    @Test
    void bimBamTest() {


        BimBam.bimBam(15);
        String expectedOutput = "1\n2\nBim\n4\nBam\nBim\n7\n8\nBim\nBam\n11\nBim\n13\n14\nBimBam\n";
        assertEquals(expectedOutput, updateLineSpliterators(outContent.toString()));
    }

}

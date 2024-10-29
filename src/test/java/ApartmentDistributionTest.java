import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.ApartmentDistribution;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class ApartmentDistributionTest {

    private String readFile(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    private static Stream<Object[]> testCases() throws IOException {
        String testCasesDir = "src/test/cses_testfiles/";

        return Files.list(Paths.get(testCasesDir))
                .filter(path -> path.toString().endsWith(".in"))
                .map(path -> new Object[]{path.toString(), path.toString().replace(".in", ".out")})
                .filter(pair -> Files.exists(Paths.get(pair[1].toString())))
                .toList()
                .stream();
    }

    @ParameterizedTest(name = "Test {index}: {0}")
    @MethodSource("testCases")
    void testFromFiles(String inputFile, String outputFile) throws IOException {
        String input = readFile(inputFile);
        String expectedOutput = readFile(outputFile).trim();

        String[] lines = input.split("\n");
        String[] firstLine = lines[0].split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);
        int k = Integer.parseInt(firstLine[2]);

        int[] applicants = Arrays.stream(lines[1].split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] apartments = Arrays.stream(lines[2].split(" ")).mapToInt(Integer::parseInt).toArray();

        int result = ApartmentDistribution.maxApplicants(applicants, apartments, n, m, k);
        assertEquals(Integer.parseInt(expectedOutput), result);
    }
}


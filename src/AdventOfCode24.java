import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class AdventOfCode24 {
    public static ArrayList<String> rawData = new ArrayList<>();

    public static void main(String[] args) {
        readFile("input2.txt");

        int numberOfSafeReports = 0;
        for (String line : rawData) {
            String[] lineParts = line.trim().split("\\s+");
            System.out.println("line: " + Arrays.toString(lineParts));

            if (safeReport(lineParts)) {
                numberOfSafeReports++;
            }
        }

        System.out.println(numberOfSafeReports);
    }

    public static boolean safeReport(String[] report) {
        int[] differences = new int[report.length-1];
        for (int i=0; i<report.length-1; i++) {
            int current1 = Integer.parseInt(report[i]);
            int current2 = Integer.parseInt(report[i + 1]);

            int difference = current1 - current2;
            differences[i] = difference;

            if (Math.abs(difference) < 1 || Math.abs(difference) > 3) {
                return false;
            }
        }

        System.out.println(Arrays.toString(differences));

        boolean increasing = false;
        boolean decreasing = false;
        for (int difference : differences) {
            if (difference > 0) {
                increasing = true;
            }
            if (difference < 0) {
                decreasing = true;
            }
        }

        if (increasing && decreasing) {
            return false;
        }
        return true;
    }


    public static void readFile(String file) {
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                rawData.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

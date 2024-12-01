import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class AdventOfCode24 {
    public static ArrayList<String> rawData = new ArrayList<>();

    public static void main(String[] args) {
        readFile("input.txt");

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        for (String line : rawData) {
            String[] lineParts = line.trim().split("\\s+");

            list1.add(Integer.parseInt(lineParts[0]));
            list2.add(Integer.parseInt(lineParts[1]));
        }

        Collections.sort(list1);
        Collections.sort(list2);

        int result = 0;
        for (int l1 : list1) {
            int frequency = 0;
            for (int l2 : list2) {
                if (l1 == l2) {
                    frequency++;
                }
            }
            result += l1 * frequency;
        }

        System.out.println(result);
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

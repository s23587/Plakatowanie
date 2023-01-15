import java.io.*;
import java.util.Stack;

public class Main {

    public static int numberOfPosters = 0;

    public static void main(String[] args) {

        BufferedReader bufferedReader;
        String line;
        int numberOfBuildings = 0, currentHeight;
        Stack<Integer> heights = new Stack<>();

        try {
            bufferedReader = new BufferedReader(new FileReader("data/data.in"));

            numberOfBuildings = Integer.parseInt(bufferedReader.readLine());

            while ((line = bufferedReader.readLine()) != null) {

                currentHeight = Integer.parseInt(line.split(" ")[1]);

                if (heights.empty()) {
                    heights.push(currentHeight);
                    numberOfPosters++;
                } else if (currentHeight > heights.peek()) {
                    heights.push(currentHeight);
                    numberOfPosters++;
                } else if (currentHeight < heights.peek()) {
                    while (!heights.empty() && heights.peek() > currentHeight) {
                        heights.pop();
                    }
                    if ((!heights.empty() && heights.peek() < currentHeight) || heights.isEmpty()){
                        heights.push(currentHeight);
                        numberOfPosters++;
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (numberOfBuildings == 1) {
            System.out.println("Minimalna liczba plakatów to: " + numberOfBuildings);
        } else {
            System.out.println("Minimalna liczba plakatów to: " + numberOfPosters);
        }

    }
}
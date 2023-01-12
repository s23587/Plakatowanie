import java.io.*;
import java.util.Stack;

public class Main {

    public static int numberOfPosters=0;

    public static void main(String[] args) {

        BufferedReader bufferedReader;
        String line;
        int numberOfBuildings,currentHeight;
        Stack<Integer> heights = new Stack<>();

        try {
            bufferedReader = new BufferedReader(new FileReader("data/data.in"));

            numberOfBuildings = Integer.parseInt(bufferedReader.readLine());

            while ((line = bufferedReader.readLine()) != null){

                currentHeight = Character.getNumericValue(line.charAt(line.length()-1));

                if(heights.empty()){
                    heights.push(currentHeight);
                }else if(currentHeight>heights.peek()){
                    numberOfPosters++;
                    heights.push(currentHeight);
                }

                recursionCheck(currentHeight,heights);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Minimalna liczba plakatów to: "+numberOfPosters);

    }

    public static void recursionCheck(int currentHeight, Stack<Integer> stack){
        if(currentHeight<stack.peek()){
            stack.pop();
            numberOfPosters++;
            if(stack.peek()<currentHeight){
                stack.push(currentHeight);
            }
            recursionCheck(currentHeight,stack);
        }
    }

}


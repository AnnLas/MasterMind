package sample;


import java.util.*;

public class Game {
    private boolean isRunning;
    private boolean secondPlayerTurn;
    private List<Integer> code;
    private boolean isWinner;


    public Game() {
        isRunning = true;
    }

    public int[] checkMatch(ArrayList<Integer> providedCode) {
        int sameNumbersAndPlaces = 0;
        int sameNumbers = 0;

        Iterator iterator = code.iterator();


        for (int digit : providedCode) {

            if (digit == (int) iterator.next()) {
                sameNumbersAndPlaces++;
            } else if (code.contains(digit)) {
                sameNumbers++;
            }

        }
        if (sameNumbersAndPlaces == code.size()) {
            isWinner = true;
        }
        int[] results = new int[]{sameNumbers, sameNumbersAndPlaces};
        return results;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public boolean isSecondPlayerTurn() {
        return secondPlayerTurn;
    }

    public void setCode(List<Integer> code) {
        this.code = code;
    }
    public void setCode(int length){
        Random random = new Random();
        code = new ArrayList<>();
        Set<Integer> generated = new LinkedHashSet<>();
        while (generated.size() < length)
        {
            Integer next = random.nextInt(6) + 1;
            generated.add(next);
            System.out.println(next);
        }
        for (Integer number:generated) {
            code.add(number);
        }


    }

    public void setSecondPlayerTurn(boolean secondPlayerTurn) {
        this.secondPlayerTurn = secondPlayerTurn;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public List<Integer> getCode() {
        return code;
    }
}

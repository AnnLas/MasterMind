package sample;


import java.util.*;

/**
 * Represents single game and contains whole game logic.
 */
public class Game {
    private boolean isRunning;
    private boolean secondPlayerTurn;
    private List<Integer> code;
    private boolean isWinner;

    /**
     * Initializes instance of the game (starts the game).
     */
    public Game() {
        isRunning = true;
    }

    /**
     * Checks match, og provided code by codebreaker with code to break.
     * @param providedCode code provided by codebreaker
     * @return array with bulls and cows (which repesents number of: position and color mathc, only color match).
     */
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

    /**
     * Check if game is running
     * @return info about state of game
     */
    public boolean isRunning() {
        return isRunning;
    }

    /**
     * Check if it is second player turn
     * @return info if it is seond player turn
     */
    public boolean isSecondPlayerTurn() {
        return secondPlayerTurn;
    }

    /**
     * Sets code to break
     * @param code code to break
     */
    public void setCode(List<Integer> code) {
        this.code = code;
    }

    /**
     * Generate random code to breake
     * @param length length od the code
     */
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

    /**
     * Sets second player or first player turn.
     * @param secondPlayerTurn
     */
    public void setSecondPlayerTurn(boolean secondPlayerTurn) {
        this.secondPlayerTurn = secondPlayerTurn;
    }

    /**
     * Sets game state as running or stopped
     * @param running
     */
    public void setRunning(boolean running) {
        isRunning = running;
    }

    /**
     * Tells if codebreaker is winner
     * @return if codebreaker won the game
     */
    public boolean isWinner() {
        return isWinner;
    }

    /**
     * Return code to break
     * @return code sequence to break
     */
    public List<Integer> getCode() {
        return code;
    }
}

package sample;

import java.util.*;

/**
 * It is used to break the code. It is based some kind of Knuths algorithm.
 * First it creates set of possible codes and then remove from it those which didnt match.
 * After response about match of the code given by a solver, it compares this code
 * which rest from the set. Codes which dont give the same match response are removed.
 */
public class Solver {
    private HashSet<ArrayList<Integer>> numberCollection;
    private int numberOfDigits = 6;
    private int numberOfCodes;
    private Game game;
    private ArrayList <Integer> providedCode;

    /**
     * Create instance of the Solver and prepares set of all possible codes.
     * @param game game to solve
     */
    public Solver(Game game) {
        this.game = game;
        game.setCode(4);
        int[] numbersSet = new int[]{1, 2, 3, 4, 5, 6};
        ArrayList<Integer> numberArray = new ArrayList();
        for (int i : numbersSet) {
            numberArray.add(i);
        }

       numberCollection = new HashSet<>();

        while (numberCollection.size() < 360) {

            Collections.shuffle(numberArray);
            ArrayList<Integer> newList = new ArrayList<>();
            newList.add(numberArray.get(0));
            newList.add(numberArray.get(1));
            newList.add(numberArray.get(2));
            newList.add(numberArray.get(3));
            ArrayHashWrapper arrayHashWrapper = new ArrayHashWrapper(newList);
            numberCollection.add(arrayHashWrapper.getList());

        }


    }

    /**
     * Retuns random code from the set of codes.
     * @return random code from the set of codes
     */
    public ArrayList<Integer> giveAChoice() {
        providedCode = numberCollection.iterator().next();
        int[] result = game.checkMatch(providedCode);
        System.out.println(providedCode);
        System.out.println(game.isWinner());
        if (!game.isWinner()) {
            numberCollection.remove(providedCode);

        }

        deleteCodesWithoutBCMatches(result, numberCollection);
        return providedCode;
    }


    private void deleteCodesWithoutBCMatches(int[] hint, HashSet<ArrayList<Integer>> numberCollection) {

        for (Iterator<ArrayList<Integer>> i = numberCollection.iterator(); i.hasNext(); ) {
            ArrayList<Integer> item = i.next();
            int[] result = checkMatch(item);
            if (!(result[0] == hint[0] && result[1] == hint[1])) {
                i.remove();
            }


        }

    }

    private int[] checkMatch( ArrayList<Integer> secondCode) {
        int sameNumbersAndPlaces = 0;
        int sameNumbers = 0;

        Iterator iterator = secondCode.iterator();


        for (int digit : providedCode) {

            if (digit == (int) iterator.next()) {
                sameNumbersAndPlaces++;
            } else if (secondCode.contains(digit)) {
                sameNumbers++;
            }

        }

        int[] results = new int[]{sameNumbers, sameNumbersAndPlaces};
        return results;
    }


}

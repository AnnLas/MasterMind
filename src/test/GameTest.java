package test;

import org.junit.jupiter.api.Test;
import sample.Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void checkHints() {
        Game game = new Game();

        ArrayList <Integer> providedCode = new  ArrayList();
        ArrayList <Integer> properCode = new ArrayList();
        properCode.add(1);
        properCode.add(3);
        properCode.add(6);
        properCode.add(5);

        providedCode.add(1);
        providedCode.add(5);
        providedCode.add(3);
        providedCode.add(4);

        game.setCode(properCode);
        game.checkMatch(providedCode);

        assertEquals(2,game.checkMatch(providedCode)[0]);
        assertEquals(1,game.checkMatch(providedCode)[1]);
    }

    @Test
    void ifProperLengthOfCodeGenerated() {
        Game game  = new Game();
        game.setCode(5);
        assertEquals(5,game.getCode().size());


    }

    @Test
    void ifDigitsInCodeReapets() {
        Game game  = new Game();
        game.setCode(4);
        HashMap<Integer,Integer> digitsAndAmount = new HashMap<>();
        for (int i:game.getCode()) {
            if (!digitsAndAmount.containsKey(i)){
                digitsAndAmount.put(i,1);
            }
            else {
                digitsAndAmount.put(i,digitsAndAmount.get(i)+1);
            }
            int a = digitsAndAmount.get(i);
            assertEquals(1,a);

        }

    }
    @Test
    void checkIfWin() {
        Game game = new Game();

        ArrayList <Integer> providedCode = new ArrayList();
        ArrayList <Integer> properCode = new ArrayList();
        properCode.add(1);
        properCode.add(2);
        properCode.add(3);
        properCode.add(4);

        providedCode.add(1);
        providedCode.add(2);
        providedCode.add(3);
        providedCode.add(4);

        game.setCode(properCode);
        game.checkMatch(providedCode);

        assertTrue(game.isWinner());

    }

    @Test
    void checkIfNotWin() {
        Game game = new Game();

        ArrayList <Integer> providedCode = new ArrayList();
        ArrayList <Integer> properCode = new ArrayList();
        properCode.add(1);
        properCode.add(5);
        properCode.add(3);
        properCode.add(4);

        providedCode.add(1);
        providedCode.add(2);
        providedCode.add(3);
        providedCode.add(4);

        game.setCode(properCode);
        game.checkMatch(providedCode);

        assertFalse(game.isWinner());

    }
}
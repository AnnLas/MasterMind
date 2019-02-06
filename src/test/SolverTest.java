package test;

import org.junit.jupiter.api.Test;
import sample.Game;
import sample.Solver;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SolverTest {

    @Test
    void generatedCodeLength() {
        Game game = new Game();
        Solver solver = new Solver(game);
        assertEquals(4,solver.giveAChoice().size());
    }
    @Test
    void generatedClassType() {
        Game game = new Game();
        Solver solver = new Solver(game);
        assertEquals(ArrayList.class,solver.giveAChoice().getClass());

    }
    @Test
    void ifDoesntContainsNumbersOutsideRange() {
        Game game = new Game();
        Solver solver = new Solver(game);
        assertFalse(solver.giveAChoice().contains(8));

    }
    @Test
    void ifContainsNumbersInRange() {
        Game game = new Game();
        Solver solver = new Solver(game);
        assertTrue(solver.giveAChoice().get(2)<7);

    }
}
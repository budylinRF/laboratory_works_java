package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void endToEnd_1(){
        Board board = new Board(5 ,6);
        Monster[] monsters = {
                new Monster(1, 2, Direction.NORTH),
                new Monster(1, 3, Direction.SOUTH),
                new Monster(2, 1, Direction.EAST),
        };

        for(Monster monster : monsters){
            board.visit(monster.getX(), monster.getY());
        }
        for(Monster monster : monsters){
            while(monster.move(board)){
                board.visit(monster.getX(), monster.getY());
            }
        }
        assertEquals(8, board.countCells());
    }
}

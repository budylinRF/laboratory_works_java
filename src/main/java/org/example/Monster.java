package org.example;

public class Monster {
    private int x;
    private int y;
    private Direction direction;

    public Monster(int x_, int y_, Direction direction){
        this.x = x_;
        this.y = y_;
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }

    public boolean move(Board board) {

        int newX = x;
        int newY = y;

        switch (direction) {
            case NORTH:
                newY++;
                break;
            case EAST:
                newX++;
                break;
            case SOUTH:
                newY--;
                break;
            case WEST:
                newX--;
                break;
        }

        if (board.isInside(newX, newY)) {
            x = newX;
            y = newY;
            return true;
        } else {
            return false;
        }
    }
}

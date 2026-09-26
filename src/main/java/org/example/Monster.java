package org.example;

public class Monster {
    private int x;
    private int y;
    private Direction direction;

    public Monster(int x_, int y_, Direction direction){
        if(x_ < 1 || y_ < 1) throw new IllegalArgumentException("invalid value for board");
        if(direction == null) throw new IllegalArgumentException("direction cannot be null");
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

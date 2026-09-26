package org.example;

public class Board {
    private final int width;
    private final int height;

    private final int[][] visits;

    public Board(int w_, int h_){
        this.width = w_;
        this.height = h_;

        visits = new int[height][width];
    }

    public int getVisits(int x, int y){
        if(isInside(x, y)) {
            return visits[y - 1][x - 1];
        }
        else{
            throw new IllegalArgumentException("you gone beyond out of board");
        }
    }

    public int countCells(){
        int res = 0;

        for(int y = 1; y <= height; y++){
            for(int x = 1; x <= width; x++){
                if(getVisits(x, y) == 1){
                    res++;
                }
            }
        }
        return res;
    }

    public void visit(int x, int y){
        visits[y - 1][x - 1]++;
    }

    public boolean isInside(int x, int y){
        /*if((x >= 1 && x <= width) && (y >= 1 && y <= height)) return true;
        return false; */

        return (x >= 1 && x <= width && y >= 1 && y <= height);
    }
}

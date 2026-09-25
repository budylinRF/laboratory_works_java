package org.example;


import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        Board board = new Board(n, m);

        System.out.println("board: width" + n + " height" + m);

        Monster[] monsters = new Monster[k];

        for(int i = 0; i < k; i++){
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            String directionStr = scanner.next();

            Direction direction;

            switch (directionStr){
                case "NORTH":
                    direction = Direction.NORTH;
                    break;
                case "EAST":
                    direction = Direction.EAST;
                    break;
                case "SOUTH":
                    direction = Direction.SOUTH;
                    break;
                case "WEST":
                    direction = Direction.WEST;
                    break;
                default:
                    throw new Error("неизвестное направление: " + directionStr);
            }
            System.out.println("monster number: " + i + ", start pos(" + x + ", " + y + ")");

            monsters[i] = new Monster(x, y, direction);

            board.visit(x, y);

        }

        /*
        for (int i = 0; i < k; i++) {

            Monster monster = monsters[i];

            while (monster.move(board)) {
                board.visit(monster.getX(), monster.getY());
            }
        }
        */

        for(Monster monster : monsters){
            while(monster.move(board)){
                board.visit(monster.getX(), monster.getY());
            }
        }

        System.out.println(board.countCells());
    }
}
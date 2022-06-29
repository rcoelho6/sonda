package br.com.rafael.domains;

import br.com.rafael.domains.enums.DirectionEnum;

public class Probe {
    private int id;
    private int x;
    private int y;
    private DirectionEnum direction;
    private char[] commands;

    public Probe(int id,  int x,  int y,  DirectionEnum direction,  char[] commands) {
        this.id = id ;
        this.x = x;
        this.y = y ;
        this.direction = direction;
        this.commands = commands;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public DirectionEnum getDirection() {
        return direction;
    }
    public char[] getCommands() {
        return commands;
    }

    public void move() {
        switch (direction) {
            case NORTH:
                y++;
                break;
            case WEST:
                x--;
                break;
            case SOUTH:
                y--;
                break;
            case EAST:
                x++;
                break;
        }
    }

    public void turnLeft() {
        switch (direction) {
            case NORTH:
                direction = DirectionEnum.WEST;
                break;
            case WEST:
                direction = DirectionEnum.SOUTH;
                break;
            case SOUTH:
                direction = DirectionEnum.EAST;
                break;
            case EAST:
                direction = DirectionEnum.NORTH;
                break;
        }
    }

    public void turnRight() {
        switch (direction) {
            case NORTH:
                direction = DirectionEnum.EAST;
                break;
            case EAST:
                direction = DirectionEnum.SOUTH;
                break;
            case SOUTH:
                direction = DirectionEnum.WEST;
                break;
            case WEST:
                direction = DirectionEnum.NORTH;
                break;
        }
    }
}

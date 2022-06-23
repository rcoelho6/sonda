package br.com.rafael.domain;

public class Probe {
    private int id;
    private int x;
    private int y;
    private DirectionEnum direction;
    private char[] commands;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public DirectionEnum getDirection() {
        return direction;
    }
    public void setDirection(DirectionEnum direction) {
        this.direction = direction;
    }

    public void setCommands(char[] commands) {
        this.commands = commands;
    }

    public char[] getCommands() {
        return commands;
    }
}

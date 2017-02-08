package com.javarush.task.task23.task2312;

public class Room {
    public static Room game;

    public static void main(String[] args) {
        Snake snake = new Snake(20, 10);
        game = new Room(40, 20, snake);
        snake.setDirection(SnakeDirection.DOWN);
    }

    private int width;
    private int height;
    private Snake snake;
    private Mouse mouse;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    public Room(int width, int height, Snake snake) {
        this.width = width;
        this.height = height;
        this.snake = snake;
    }

    void run() {}
    void print() {}
}

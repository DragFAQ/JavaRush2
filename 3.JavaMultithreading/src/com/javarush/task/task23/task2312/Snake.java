package com.javarush.task.task23.task2312;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private ArrayList<SnakeSection> sections;
    private boolean isAlive;
    private SnakeDirection direction;

    public ArrayList<SnakeSection> getSections() {
        return sections;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public SnakeDirection getDirection() {
        return direction;
    }

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }

    public Snake(int x, int y) {
        sections = new ArrayList<>();
        sections.add(new SnakeSection(x, y));
        isAlive = true;
    }

    public int getX() {
        return sections.get(0).getX();
    }

    public int getY() {
        return sections.get(0).getY();
    }

    public void move() {
        if (isAlive) {
            if (direction == SnakeDirection.UP)
                move(0, -1);
            else if (direction == SnakeDirection.RIGHT)
                move(1, 0);
            else if (direction == SnakeDirection.DOWN)
                move(0, 1);
            else if (direction == SnakeDirection.LEFT)
                move(-1, 0);
        }
    }

    public void move(int hor, int vert) {
        SnakeSection tmpSection = new SnakeSection(sections.get(0).getX() + hor, sections.get(0).getY() + vert);
        checkBorders(tmpSection);
        checkBody(tmpSection);
        if (isAlive) {
            sections.add(0, tmpSection);
            if (Room.game.getMouse().getX() == tmpSection.getX() && Room.game.getMouse().getY() == tmpSection.getY()) {
                Room.game.eatMouse();
            } else
                sections.remove(sections.size()-1);
        }
    }

    public void checkBorders(SnakeSection head) {
        if (Room.game == null || head == null)
            isAlive = false;
        else if(head.getX() < 0 ||
                head.getY() < 0 ||
                head.getX() >= Room.game.getWidth() ||
                head.getY() >= Room.game.getHeight())
            isAlive = false;
    }

    public void checkBody(SnakeSection head) {
        if (head == null || sections == null)
            isAlive = false;
        else if (sections.contains(head))
            isAlive = false;
    }
}

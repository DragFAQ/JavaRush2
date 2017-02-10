package com.javarush.task.task24.task2413;

public abstract class BaseObject {
    private double x;
    private double y;
    private double radius;

    public BaseObject(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public boolean isIntersec(BaseObject o) {
        double distance = Math.sqrt((o.getX() - x) * (o.getX() - x) + (o.getY() - y) * (o.getY() - y));

        return distance <= Math.max(o.getRadius(), radius);
    }

    protected abstract void draw(Canvas canvas);
    protected abstract void move();

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}

package com.example.game;

/**
 * 表示蛇的移动方向
 */
public enum Direction {
    UP(0, -1),
    DOWN(0, 1),
    LEFT(-1, 0),
    RIGHT(1, 0);

    private final int deltaX;
    private final int deltaY;

    Direction(int deltaX, int deltaY) {
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }

    public int getDeltaX() {
        return deltaX;
    }

    public int getDeltaY() {
        return deltaY;
    }

    /**
     * 检查两个方向是否相反
     * 
     * @param other 要比较的另一个方向
     * @return 如果两个方向相反返回true，否则返回false
     */
    public boolean isOpposite(Direction other) {
        return this.deltaX + other.deltaX == 0 && this.deltaY + other.deltaY == 0;
    }
}
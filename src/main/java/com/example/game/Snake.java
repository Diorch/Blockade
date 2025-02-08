package com.example.game;

import java.util.ArrayList;
import java.util.List;

/**
 * 表示游戏中的蛇
 */
public class Snake {
    private List<Point> body;
    private Direction currentDirection;
    private boolean growing;

    /**
     * 创建一条新的蛇
     * 
     * @param startX        起始X坐标
     * @param startY        起始Y坐标
     * @param initialLength 初始长度
     */
    public Snake(int startX, int startY, int initialLength) {
        body = new ArrayList<>();
        currentDirection = Direction.RIGHT;

        // 初始化蛇的身体
        for (int i = 0; i < initialLength; i++) {
            body.add(new Point(startX - i, startY));
        }
    }

    /**
     * 移动蛇
     * 
     * @return 移动后蛇头的新位置
     */
    public Point move() {
        Point newHead = new Point(getHead());
        newHead.move(currentDirection);

        body.add(0, newHead);
        if (!growing) {
            body.remove(body.size() - 1);
        }
        growing = false;

        return newHead;
    }

    /**
     * 改变蛇的移动方向
     * 
     * @param newDirection 新的方向
     */
    public void changeDirection(Direction newDirection) {
        if (!currentDirection.isOpposite(newDirection)) {
            currentDirection = newDirection;
        }
    }

    /**
     * 让蛇在下次移动时增长
     */
    public void grow() {
        growing = true;
    }

    /**
     * 检查是否发生自身碰撞
     * 
     * @return 如果蛇与自身碰撞返回true，否则返回false
     */
    public boolean checkSelfCollision() {
        Point head = getHead();
        return body.stream()
                .skip(1) // 跳过头部
                .anyMatch(segment -> segment.equals(head));
    }

    /**
     * 获取蛇头位置
     * 
     * @return 蛇头的Point对象
     */
    public Point getHead() {
        return body.get(0);
    }

    /**
     * 获取蛇的身体
     * 
     * @return 包含蛇身体所有部分的List
     */
    public List<Point> getBody() {
        return new ArrayList<>(body);
    }

    /**
     * 获取当前移动方向
     * 
     * @return 当前的Direction
     */
    public Direction getCurrentDirection() {
        return currentDirection;
    }
}
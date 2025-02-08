package com.example.game;

import java.util.List;
import java.util.Random;

/**
 * 表示游戏中的食物
 */
public class Food {
    private Point position;
    private final Random random;
    private final int gridWidth;
    private final int gridHeight;

    /**
     * 创建一个食物生成器
     * 
     * @param gridWidth  游戏网格宽度
     * @param gridHeight 游戏网格高度
     */
    public Food(int gridWidth, int gridHeight) {
        this.gridWidth = gridWidth;
        this.gridHeight = gridHeight;
        this.random = new Random();
        this.position = null;
    }

    /**
     * 生成新的食物位置
     * 
     * @param snake 蛇的身体位置列表，用于避免食物生成在蛇身上
     */
    public void generateNew(List<Point> snake) {
        do {
            position = new Point(
                    random.nextInt(gridWidth),
                    random.nextInt(gridHeight));
        } while (isOnSnake(snake));
    }

    /**
     * 检查食物是否在蛇身上
     * 
     * @param snake 蛇的身体位置列表
     * @return 如果食物在蛇身上返回true，否则返回false
     */
    private boolean isOnSnake(List<Point> snake) {
        return snake.stream().anyMatch(p -> p.equals(position));
    }

    /**
     * 获取食物位置
     * 
     * @return 食物的Point对象
     */
    public Point getPosition() {
        return position;
    }
}
package com.example.game;

/**
 * 管理贪吃蛇游戏的主要逻辑
 */
public class Game {
    private static final int INITIAL_SNAKE_LENGTH = 4;

    private final int gridWidth;
    private final int gridHeight;
    private final Snake snake;
    private final Food food;
    private boolean isGameOver;
    private int score;

    /**
     * 创建新游戏
     * 
     * @param gridWidth  游戏网格宽度
     * @param gridHeight 游戏网格高度
     */
    public Game(int gridWidth, int gridHeight) {
        this.gridWidth = gridWidth;
        this.gridHeight = gridHeight;
        this.snake = new Snake(gridWidth / 2, gridHeight / 2, INITIAL_SNAKE_LENGTH);
        this.food = new Food(gridWidth, gridHeight);
        this.isGameOver = false;
        this.score = 0;

        // 生成第一个食物
        food.generateNew(snake.getBody());
    }

    /**
     * 更新游戏状态
     * 
     * @return 如果游戏继续返回true，游戏结束返回false
     */
    public boolean update() {
        if (isGameOver) {
            return false;
        }

        // 移动蛇
        Point newHead = snake.move();

        // 检查是否吃到食物
        if (newHead.equals(food.getPosition())) {
            snake.grow();
            food.generateNew(snake.getBody());
            score += 10;
        }

        // 检查是否撞墙
        if (newHead.getX() < 0 || newHead.getX() >= gridWidth ||
                newHead.getY() < 0 || newHead.getY() >= gridHeight) {
            isGameOver = true;
            return false;
        }

        // 检查是否撞到自己
        if (snake.checkSelfCollision()) {
            isGameOver = true;
            return false;
        }

        return true;
    }

    /**
     * 改变蛇的移动方向
     * 
     * @param direction 新的方向
     */
    public void changeDirection(Direction direction) {
        if (!isGameOver) {
            snake.changeDirection(direction);
        }
    }

    /**
     * 获取当前分数
     * 
     * @return 当前分数
     */
    public int getScore() {
        return score;
    }

    /**
     * 获取蛇对象
     * 
     * @return 蛇对象
     */
    public Snake getSnake() {
        return snake;
    }

    /**
     * 获取食物对象
     * 
     * @return 食物对象
     */
    public Food getFood() {
        return food;
    }

    /**
     * 检查游戏是否结束
     * 
     * @return 如果游戏结束返回true，否则返回false
     */
    public boolean isGameOver() {
        return isGameOver;
    }

    /**
     * 获取网格宽度
     * 
     * @return 网格宽度
     */
    public int getGridWidth() {
        return gridWidth;
    }

    /**
     * 获取网格高度
     * 
     * @return 网格高度
     */
    public int getGridHeight() {
        return gridHeight;
    }
}
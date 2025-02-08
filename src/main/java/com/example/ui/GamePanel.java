package com.example.ui;

import com.example.game.Game;
import com.example.game.Point;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * 游戏界面面板，负责绘制游戏画面
 */
public class GamePanel extends JPanel {
    private static final int CELL_SIZE = 20;
    private static final Color BACKGROUND_COLOR = Color.BLACK;
    private static final Color SNAKE_COLOR = Color.GREEN;
    private static final Color FOOD_COLOR = Color.RED;
    private static final Color TEXT_COLOR = Color.WHITE;

    private final Game game;

    /**
     * 创建游戏面板
     * 
     * @param game 游戏实例
     */
    public GamePanel(Game game) {
        this.game = game;
        setPreferredSize(new Dimension(
                game.getGridWidth() * CELL_SIZE,
                game.getGridHeight() * CELL_SIZE));
        setBackground(BACKGROUND_COLOR);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // 绘制蛇
        g.setColor(SNAKE_COLOR);
        List<Point> snakeBody = game.getSnake().getBody();
        for (Point p : snakeBody) {
            g.fillRect(
                    p.getX() * CELL_SIZE,
                    p.getY() * CELL_SIZE,
                    CELL_SIZE,
                    CELL_SIZE);
        }

        // 绘制食物
        g.setColor(FOOD_COLOR);
        Point foodPos = game.getFood().getPosition();
        g.fillOval(
                foodPos.getX() * CELL_SIZE,
                foodPos.getY() * CELL_SIZE,
                CELL_SIZE,
                CELL_SIZE);

        // 如果游戏结束，显示游戏结束信息
        if (game.isGameOver()) {
            drawGameOver(g);
        }

        // 显示分数
        drawScore(g);
    }

    /**
     * 绘制游戏结束信息
     * 
     * @param g Graphics对象
     */
    private void drawGameOver(Graphics g) {
        String gameOverText = "Game Over!";
        g.setColor(TEXT_COLOR);
        g.setFont(new Font("Arial", Font.BOLD, 30));

        FontMetrics metrics = g.getFontMetrics();
        int x = (getWidth() - metrics.stringWidth(gameOverText)) / 2;
        int y = getHeight() / 2;

        g.drawString(gameOverText, x, y);
    }

    /**
     * 绘制分数信息
     * 
     * @param g Graphics对象
     */
    private void drawScore(Graphics g) {
        String scoreText = "分数: " + game.getScore();
        g.setColor(TEXT_COLOR);
        g.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        g.drawString(scoreText, 10, 25);
    }
}
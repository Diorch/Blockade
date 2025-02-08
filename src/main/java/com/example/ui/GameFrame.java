package com.example.ui;

import com.example.game.Direction;
import com.example.game.Game;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * 游戏主窗口，处理用户输入并显示游戏画面
 */
public class GameFrame extends JFrame {
    private static final int GRID_WIDTH = 30;
    private static final int GRID_HEIGHT = 20;
    private static final int GAME_SPEED = 150; // 毫秒

    private final Game game;
    private final GamePanel gamePanel;
    private final Timer gameTimer;

    /**
     * 创建游戏窗口
     */
    public GameFrame() {
        game = new Game(GRID_WIDTH, GRID_HEIGHT);
        gamePanel = new GamePanel(game);

        // 设置窗口属性
        setTitle("贪吃蛇");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        add(gamePanel);
        pack();
        setLocationRelativeTo(null);

        // 添加键盘监听
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        game.changeDirection(Direction.UP);
                        break;
                    case KeyEvent.VK_DOWN:
                        game.changeDirection(Direction.DOWN);
                        break;
                    case KeyEvent.VK_LEFT:
                        game.changeDirection(Direction.LEFT);
                        break;
                    case KeyEvent.VK_RIGHT:
                        game.changeDirection(Direction.RIGHT);
                        break;
                }
            }
        });

        // 创建游戏定时器
        gameTimer = new Timer(GAME_SPEED, e -> {
            if (game.update()) {
                gamePanel.repaint();
            } else {
                ((Timer) e.getSource()).stop();
                gamePanel.repaint();
            }
        });
    }

    /**
     * 开始游戏
     */
    public void startGame() {
        gameTimer.start();
    }
}
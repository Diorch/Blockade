package com.example;

import com.example.ui.GameFrame;

import javax.swing.*;

/**
 * 贪吃蛇游戏的主类
 */
public class Main {
    public static void main(String[] args) {
        // 在事件调度线程中创建和显示游戏窗口
        SwingUtilities.invokeLater(() -> {
            GameFrame frame = new GameFrame();
            frame.setVisible(true);
            frame.startGame();
        });
    }
}
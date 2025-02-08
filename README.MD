# 贪吃蛇游戏 (Snake Game)

## 项目简介

这是一个使用 Java8 开发的经典贪吃蛇游戏。游戏提供图形界面，让玩家可以通过键盘控制蛇的移动方向，吃到食物后蛇身会变长，撞到墙壁或自身则游戏结束。

## 技术栈

- Java 8
- Swing (图形界面)
- Maven (项目管理)
- Spock Framework 1.3-groovy-2.5 (测试框架)
- Groovy 2.5.4
- PowerMock (静态方法测试)

## 功能特性

1. 图形界面展示游戏画面
2. 键盘方向键控制蛇的移动
3. 随机生成食物
4. 计分系统
5. 游戏难度随分数提升
6. 游戏结束提示

## 项目结构

```
src/
├── main/java/com/example/
│   ├── Main.java              // 程序入口
│   ├── game/
│   │   ├── Game.java         // 游戏主逻辑
│   │   ├── Snake.java        // 蛇的实现
│   │   ├── Food.java         // 食物实现
│   │   └── Direction.java    // 方向枚举
│   └── ui/
│       ├── GamePanel.java    // 游戏界面
│       └── GameFrame.java    // 主窗口
test/
└── groovy/com/example/
    └── game/
        ├── GameSpec.groovy   // 游戏逻辑测试
        ├── SnakeSpec.groovy  // 蛇相关测试
        └── FoodSpec.groovy   // 食物相关测试
```

## 如何运行

1. 确保已安装 Java 8 和 Maven
2. 克隆项目到本地
3. 在项目根目录执行: `mvn clean install`
4. 运行: `java -jar target/snake-game.jar`

## 游戏控制

- ↑: 向上移动
- ↓: 向下移动
- ←: 向左移动
- →: 向右移动
- Space: 暂停/继续
- ESC: 退出游戏

## 开发计划

1. 基础框架搭建
2. 实现蛇的移动逻辑
3. 实现食物生成
4. 实现碰撞检测
5. 完善游戏界面
6. 添加计分系统
7. 实现难度调节
8. 编写单元测试

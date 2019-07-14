package com.jsj.nukkit.sample.ballsbattle;

import cn.nukkit.Player;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PlayerVision {
    private Player player;
    private Map<Long, DefaultBall> defaultBallMap = new ConcurrentHashMap<>();
    private Map<Long, SporeBall> sporeBallMap = new ConcurrentHashMap<>();

    public PlayerVision(Player player) {
        this.player = player;
    }

    public void addBall(Ball ball) {
        if (ball instanceof DefaultBall) {
            addDefaultBall((DefaultBall) ball);
            return;
        }
        if (ball instanceof SporeBall) {
            addSporeBall((SporeBall) ball);
        }
    }

    public boolean removeBall(Ball ball) {
        if (ball instanceof DefaultBall) {
            return removeDefaultBall((DefaultBall) ball);
        }
        if (ball instanceof SporeBall) {
            return removeSporeBall((SporeBall) ball);
        }
        return false;
    }

    private void addDefaultBall(DefaultBall defaultBall) {
        defaultBallMap.put(defaultBall.getId(), defaultBall);
    }

    private void addSporeBall(SporeBall sporeBall) {
        sporeBallMap.put(sporeBall.getId(), sporeBall);
    }

    private boolean removeDefaultBall(DefaultBall defaultBall) {
        return defaultBallMap.remove(defaultBall.getId()) != null;
    }

    private boolean removeSporeBall(SporeBall sporeBall) {
        return sporeBallMap.remove(sporeBall.getId()) != null;
    }

    public boolean outOfVision(Ball ball) {
        //根据majorball的坐标判断，避免线程问题
        return true;
    }

    public boolean containsBall(Ball ball) {
        if (ball instanceof DefaultBall) {
            return defaultBallMap.containsKey(ball.getId());
        }
        if (ball instanceof SporeBall) {
            return sporeBallMap.containsKey(ball.getId());
        }
        return false;
    }

}

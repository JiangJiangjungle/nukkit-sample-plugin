package com.jsj.nukkit.sample.ballsbattle;

public class BallCreateTask implements Runnable {

    @Override
    public void run() {
        DefaultBall ball = new DefaultBall();
        //更新视野
        ball.updatePlayerVision();
        //todo 球的注册
    }
}

package com.jsj.nukkit.sample.ballsbattle;

import cn.nukkit.Player;
import lombok.Data;

import java.util.Collection;

@Data
public abstract class Ball {
    protected long id;
    protected float x;
    protected float y;
    protected float z;
    protected float motionX;
    protected float motionZ;

    /**
     * 异步线程执行
     */
    public void tick() {
        move();
        updatePlayerVision();
    }

    public boolean kill() {
        boolean succeed = true;
        //todo 暂时发给所有玩家
        disappearFrom(DataHolder.playerVisionMap.keySet());
        return succeed;
    }

    public void move() {

    }

    /**
     * 异步线程执行
     */
    public abstract void updatePlayerVision();


    public void displayTo(Player player) {

    }

    public void disappearFrom(Player player) {

    }

    public void disappearFrom(Collection<Player> players) {

    }

    public void sendMovePacket(Player player) {

    }
}

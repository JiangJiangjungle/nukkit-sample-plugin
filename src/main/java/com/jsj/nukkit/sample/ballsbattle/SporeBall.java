package com.jsj.nukkit.sample.ballsbattle;

import cn.nukkit.Player;

import java.util.Map;

public class SporeBall extends Ball {

    @Override
    public void updatePlayerVision() {
        for (Map.Entry<Player, PlayerVision> entry : DataHolder.playerVisionMap.entrySet()) {
            Player player = entry.getKey();
            PlayerVision playerVision = entry.getValue();
            boolean out = playerVision.outOfVision(this);
            boolean contains = playerVision.containsBall(this);
            if (out) {
                playerVision.removeBall(this);
                disappearFrom(player);
            } else if (!contains) {
                playerVision.addBall(this);
                displayTo(player);
            } else if (this.motionX != 0.0f || this.motionZ != 0.0f) {
                sendMovePacket(player);
            }
        }
    }
}

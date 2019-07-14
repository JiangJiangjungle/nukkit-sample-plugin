package com.jsj.nukkit.sample.ballsbattle;

import cn.nukkit.Player;
import cn.nukkit.entity.Entity;

import java.util.Map;

public class DefaultBall extends Ball {
    private Player owner;
    private boolean majorBall;

    /**
     * 发包操作
     *
     * @param entity
     */
    public void mountEntity(Entity entity) {

    }

    @Override
    public boolean kill() {
        boolean succeed = super.kill();
        if (succeed && majorBall) {
            //1.骑到第二大的球上
            //2.重新生成球并骑上去
        }
        return succeed;
    }

    @Override
    public void updatePlayerVision() {
        for (Map.Entry<Player, PlayerVision> entry : DataHolder.playerVisionMap.entrySet()) {
            Player player = entry.getKey();
            PlayerVision playerVision = entry.getValue();
            //是否超出该玩家视野
            boolean out = playerVision.outOfVision(this);
            //是否已经包含此球
            boolean contains = playerVision.containsBall(this);
            if (out) {
                //不包含则直接返回
                if (!contains) return;
                //已包含此球则要移除并发包
                playerVision.removeBall(this);
                disappearFrom(player);
            } else if (!contains) {
                playerVision.addBall(this);
                displayTo(player);
                //todo 若为主球则要发骑乘包（发移动包时也可以考虑发骑乘包）
                if (majorBall) {
                    mountEntity(owner);
                }
            } else {
                sendMovePacket(player);
            }
        }
    }
}

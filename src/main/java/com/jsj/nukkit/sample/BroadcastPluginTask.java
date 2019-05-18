package com.jsj.nukkit.sample;

import cn.nukkit.scheduler.PluginTask;

public class BroadcastPluginTask extends PluginTask<MainClass> {
    public BroadcastPluginTask(MainClass owner) {
        super(owner);
    }

    @Override
    public void onRun(int currentTick) {
        this.getOwner().getLogger().info("I've run on tick " + currentTick);
    }
}

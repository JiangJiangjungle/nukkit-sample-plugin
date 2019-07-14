package com.jsj.nukkit.sample.ballsbattle;

import cn.nukkit.Player;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DataHolder {
    public static Map<Player, PlayerVision> playerVisionMap = new ConcurrentHashMap<>();
}

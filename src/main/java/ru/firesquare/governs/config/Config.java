package ru.firesquare.governs.config;

import redempt.redlib.config.annotations.Comment;
import redempt.redlib.config.annotations.ConfigMappable;

import java.util.HashMap;
import java.util.Map;

@ConfigMappable
public class Config {
    @Comment("Allow players to leave from government?")
    public static Boolean allow_quit = false;

    @Comment("Force players to join in some government?")
    @Comment("Hermit players will not be able to interact with the world and go beyond spag")
    public static Boolean force_to_join = true;

    @Comment("Distance allowed from spawn point for hermit players. A circle. Default: 100")
    public static int hermit_allowed_distance = 100;

    @Comment("List of governments.")
    public static Map<String, Group> governments = new HashMap<>();
}

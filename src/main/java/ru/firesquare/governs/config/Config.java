package ru.firesquare.governs.config;

import redempt.redlib.config.annotations.Comment;
import redempt.redlib.config.annotations.ConfigMappable;

@ConfigMappable
public class Config {
    @Comment("Allow players to leave from government?")
    public static Boolean allow_quit = false;

    @Comment("Force players to join in some government?")
    @Comment("Hermit players will not be able to interact with the world and go beyond spawn")
    public static Boolean force_to_join = true;

    @Comment("Distance allowed from spawn point for hermit players. A circle. Default: 100")
    public static int hermit_allowed_distance = 100;

    @Comment("Database connection")
    public static String database = "jdbc:sqlite:plugins/Governs/database.db";

    public static boolean enable_gui_stroke = true;
    public static String gui_stroke_item = "BLACK_STAINED_GLASS_PANE";
}

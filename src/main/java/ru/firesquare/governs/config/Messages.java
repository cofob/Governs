package ru.firesquare.governs.config;

import redempt.redlib.config.annotations.ConfigMappable;

@ConfigMappable
public class Messages {
    public static String success = "&aSuccess!1";
    public static String error = "&cError :((( : ";
    public static String reload = "&aReloaded";
    public static String join_button = "&aJoin!";
    public static String join_button_item = "GREEN_STAINED_GLASS_PANE";
    public static String back_button = "<- &cBack";
    public static String back_button_item = "RED_STAINED_GLASS_PANE";
    public static String join_govern_gui_title = "&aGovern choice";
    public static String join_govern_title = "&aGovern choice";
    public static String join_govern_subtitle = "&a/governs join";
    public static int join_govern_fade_in = 20;
    public static int join_govern_stay = 80;
    public static int join_govern_fade_out = 20;
    public static String join_remember = "Remember to join some govern!";
    public static int join_remember_retry_every = 20;
    public static String joined_title = "&aSuccessfully joined!";
    public static String joined_subtitle = "Lorem ipsum";
    public static int joined_fade_in = 20;
    public static int joined_stay = 50;
    public static int joined_fade_out = 20;
    public static String already_in_govern = "Error: Already in govern!";
    public static String govern_info = "&a= Govern info =\n" +
            "Name: %name%\n" +
            "Display Name: %display_name%\n" +
            "Description: %description%\n" +
            "Base coords: %x% %y% %x%\n" +
            "Icon: %icon%\n" +
            "Approve: %approve%";
    public static String player_info = "&a= Player info =\n" +
            "Nickname: %nickname%\n" +
            "Govern: %govern%";
    public static String feature_info = "&a= Feature info =\n" +
            "Name: %name%\n" +
            "Govern: %govern%\n" +
            "Display Name: %display_name%\n" +
            "Description: %description%\n" +
            "Icon: %icon%";
    public static String clan_chat = "<%govern%:%player%> %message%";
}

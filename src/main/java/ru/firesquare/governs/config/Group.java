package ru.firesquare.governs.config;

import redempt.redlib.config.annotations.Comment;
import redempt.redlib.config.annotations.ConfigMappable;

@ConfigMappable
public class Group {
    @Comment("Public name, will be shown in placeholders.")
    public String name;

    @Comment("Requires approve from government administration? (Public or approve-only)")
    public Boolean approve = false;
}

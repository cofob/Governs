package ru.firesquare.governs.sql;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import org.bukkit.Material;

import java.util.Locale;

@DatabaseTable(tableName = "governs_governs")
public class Govern {
    @DatabaseField(canBeNull = false, id = true)
    private String name;

    @DatabaseField(canBeNull = false)
    private String display_name;

    @DatabaseField(canBeNull = false)
    private String description;

    @DatabaseField(canBeNull = false, defaultValue = "CARROT")
    private String icon = "CARROT";

    @DatabaseField
    private boolean approve = false;

    @DatabaseField
    private int base_x;

    @DatabaseField
    private int base_y;

    @DatabaseField
    private int base_z;

//    ORMLite boilerplate
    public Govern() {}

    public String getDisplayName() {
        return display_name;
    }

    public void setDisplayName(String display_name) {
        this.display_name = display_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        icon = icon.toUpperCase(Locale.ROOT);
        assert Material.getMaterial(icon) != null;
        this.icon = icon;
    }

    public boolean isApprove() {
        return approve;
    }

    public void setApprove(boolean approve) {
        this.approve = approve;
    }

    public void setBaseX(int base_x) {
        this.base_x = base_x;
    }

    public void setBaseY(int base_y) {
        this.base_y = base_y;
    }

    public void setBaseZ(int base_z) {
        this.base_z = base_z;
    }

    public int getBaseX() {
        return base_x;
    }

    public int getBaseY() {
        return base_y;
    }

    public int getBaseZ() {
        return base_z;
    }
}

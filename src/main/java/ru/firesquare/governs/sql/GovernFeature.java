package ru.firesquare.governs.sql;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import org.bukkit.Material;

import java.util.Locale;

@DatabaseTable(tableName = "governs_govern_features")
public class GovernFeature {
    @DatabaseField(id = true)
    private String name;

    @DatabaseField()
    private String govern;

    @DatabaseField(canBeNull = false)
    private String display_name;

    @DatabaseField(canBeNull = false)
    private String description;

    @DatabaseField(canBeNull = false, defaultValue = "CARROT")
    private String icon = "CARROT";

    @DatabaseField(canBeNull = false, defaultValue = "1")
    private int x = 1;

    @DatabaseField(canBeNull = false, defaultValue = "1")
    private int y = 1;

//    ORMLite boilerplate
    public GovernFeature() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGovern() {
        return govern;
    }

    public void setGovern(String govern) {
        this.govern = govern;
    }

    public String getDisplayName() {
        return display_name;
    }

    public void setDisplayName(String display_name) {
        this.display_name = name;
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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

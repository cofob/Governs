package ru.firesquare.governs.sql;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

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
        this.icon = icon;
    }
}

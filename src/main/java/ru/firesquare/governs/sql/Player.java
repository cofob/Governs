package ru.firesquare.governs.sql;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "governs_players")
public class Player {
    @DatabaseField(canBeNull = false, id = true)
    private String name;

    @DatabaseField()
    private String govern;

//    ORMLite boilerplate
    public Player() {}

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
}

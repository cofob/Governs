package ru.firesquare.governs.config;

import redempt.redlib.config.annotations.Comment;
import redempt.redlib.config.annotations.ConfigMappable;
import ru.firesquare.governs.sql.DatabaseType;

@ConfigMappable
public class Database {
    public DatabaseType type = DatabaseType.SQLite;
    public String ip;
    public int port = 3306;
    public String username;
    public String password;
    public String database;
}

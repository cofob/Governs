package ru.firesquare.governs.sql;

import org.bukkit.Bukkit;
import redempt.redlib.sql.SQLHelper;
import ru.firesquare.governs.GovernsPlugin;
import ru.firesquare.governs.config.Config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Level;

public class SQLManager {
    public SQLManager() {
        try {
            if (Config.database.type == DatabaseType.MySQL) {
                sql = new SQLHelper(SQLHelper.openMySQL(Config.database.ip, Config.database.port,
                        Config.database.username, Config.database.password,
                        Config.database.database));
            } else if (Config.database.type == DatabaseType.SQLite) {
                sql = new SQLHelper(SQLHelper.openSQLite(GovernsPlugin.getInstance()
                        .getDataFolder().toPath().resolve("database.db")));
            }
        } catch (Exception e) {
            Bukkit.getLogger().log(Level.SEVERE, "Failed to load SQL connection.\n" + e.getMessage());
            Bukkit.getServer().shutdown();
        }
    }

    private SQLHelper sql;

    public SQLHelper getSQL() {
        return sql;
    }

    public void close() {
        sql.close();
    }

    public void initialize() {
        try {
            sql.execute(readFromInputStream(GovernsPlugin.class.getResourceAsStream("/sql/init_governments.sql")));
            sql.execute(readFromInputStream(GovernsPlugin.class.getResourceAsStream("/sql/init_players.sql")));
            sql.execute(readFromInputStream(GovernsPlugin.class.getResourceAsStream("/sql/init_pending.sql")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        close();
    }

    public boolean checkPlayerInSomeGovern(String nickname) {
        try {
            int id = sql.querySingleResult("SELECT `id` FROM `governs_players` WHERE nickname=? AND government IS NOT NULL;", nickname);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void createGovern(String name){
        sql.execute("INSERT INTO `governs_governments` (name, description, approve) " +
                             "VALUES (?, ?, ?)", name, "", true);
    }

    public void updateGovernDescription(String name, Object value){
        sql.execute("UPDATE `governs_governments` SET description=? WHERE name=?;", value, name);
    }

    public void updateGovernApprove(String name, boolean value){
        sql.execute("UPDATE `governs_governments` SET approve=? WHERE name=?;", value, name);
    }

    public List<String> getGovern(String name){
        return sql.queryResultStringList("SELECT * FROM `governs_governments` WHERE name=?;", name);
    }

    public List<String> getAllGoverns(){
        return sql.queryResultStringList("SELECT name, description, approve FROM `governs_governments`;");
    }

    private String readFromInputStream(InputStream inputStream)
            throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }
}

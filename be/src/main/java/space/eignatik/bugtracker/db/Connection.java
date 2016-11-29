package space.eignatik.bugtracker.db;

import org.sql2o.Sql2o;

public class Connection {
    private static Sql2o sql2o;
    private static String DATA_BASE = "jdbc:mysql://localhost:3306/bug_tracker";
    private static String USERNAME = "root";
    private static String PASS = "root";


    public static synchronized Sql2o getConection() {
        if (sql2o == null) {
            sql2o = new Sql2o(DATA_BASE, USERNAME, PASS);
        }
        return sql2o;
    }
}

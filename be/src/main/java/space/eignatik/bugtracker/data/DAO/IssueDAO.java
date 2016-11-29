package space.eignatik.bugtracker.data.DAO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.sql2o.Sql2o;
import space.eignatik.bugtracker.db.Connection;
import space.eignatik.bugtracker.model.Issue;

import java.util.List;

public class IssueDAO {

    public static final Logger logger = LogManager.getLogger(IssueDAO.class.getName());

    @Autowired
    private Sql2o sql2o;

    public IssueDAO() {
        sql2o = Connection.getConection();
    }

    public Issue getItem(Long id) throws Exception {
        String sql = "select id, title, date, description from issue where id = :id";
        try(org.sql2o.Connection connection = sql2o.open()) {
            return connection.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Issue.class);
        }
    }

    public void createItem(Issue item) throws Exception {
        String sql = "insert into issue (title, date, description)values(:title, :date, :description)";
        try(org.sql2o.Connection connection = sql2o.open()) {
           connection.createQuery(sql)
                    .addParameter("title", item.getTitle())
                    .addParameter("date", item.getDate())
                    .addParameter("description", item.getDescription())
                    .executeUpdate();
        }
    }

    public boolean deleteItem(Long id) throws Exception {
        String sql = "delete from issue where id=:id";
        try(org.sql2o.Connection connection = sql2o.open()) {
            connection.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Exception e) {
            logger.error(e.getMessage() + "Can't delete record with id = " + id);
        }
        return true;
    }

    public Issue updateItem(Long id, Issue item) throws Exception {
        String sql = "update issue set title=:title, description=:description where id=:id";
        try(org.sql2o.Connection connection = sql2o.open()) {
            connection.createQuery(sql)
                    .addParameter("id", id)
                    .addParameter("title", item.getTitle())
                    .addParameter("description", item.getDescription())
                    .executeUpdate();
            return getItem(id);
        }
    }

    public List<Issue> getItems() throws Exception {
        String sql = "select * from issue";
        try(org.sql2o.Connection connection = sql2o.open()) {
            return connection.createQuery(sql).executeAndFetch(Issue.class);
        }
    }
}

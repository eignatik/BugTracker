package space.eignatik.bugtracker.model;

public class Issue {
    private long id;
    private String title;
    private String date;
    private String description;

    public Issue() {
        this.title = "New Issue";
        this.date = "";
        this.description = "Issue description";
    }

    public Issue(String title, String date, String description) {
        this.title = title;
        this.date = date;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "id:" + id +
                ", title:'" + title + '\'' +
                ", date:'" + date + '\'' +
                ", description:'" + description + '\'' +
                '}';
    }
}

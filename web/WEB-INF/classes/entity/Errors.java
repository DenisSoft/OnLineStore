package entity;

/**
 * Created by Dzianis on 15.04.2017.
 */
public class Errors {
    private long id;
    private String name;

    public Errors(String name) {
        this.name = name;
    }

    public Errors(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

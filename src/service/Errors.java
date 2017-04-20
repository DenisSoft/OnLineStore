package service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Dzianis on 15.04.2017.
 */
public class Errors {
    private long id;
    private String name;

    public Errors() {
    }

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

    public void add(String name) {
        this.name = String.format("%s\n%s", this.name, name);
    }

    public static long isNumeral(String string, String regex) {

        return string.matches(regex) ? -1 : Long.valueOf(string);

    }
}

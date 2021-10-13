package service;

public class Status {
    private final String NAME;
    public static final Status FREE = new Status("FREE");
    public static final Status VOCATION = new Status("VOCATION");
    public static final Status BUSY = new Status("BUSY");

    public Status(String name) {
        this.NAME = name;
    }

    public String getNAME() {
        return this.NAME;
    }

    public String toString() {
        return this.NAME;
    }
}

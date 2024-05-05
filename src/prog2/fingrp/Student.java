package prog2.fingrp;

public class Student {
    private String name;
    private String program;
    private String id;

    public Student() {
        name = "";
        program = "";
        id = "";
    }
    public Student(String name, String program, String id) {
        this.name = name;
        this.program = program;
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getProgram() {
        return program;
    }

    public String getId() {
        return id;
    }
    public String toString(String name, String program, String id) {
        return (name + "\n" + program + "\n" +id);
    }
}

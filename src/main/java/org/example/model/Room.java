package org.example.model;

import java.util.UUID;

public class Room {

    private UUID id;
    private String name;
    private boolean isOrdered;
    private UUID teacherId;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOrdered() {
        return isOrdered;
    }

    public void setOrdered(boolean ordered) {
        isOrdered = ordered;
    }

    public UUID getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(UUID teacherId) {
        this.teacherId = teacherId;
    }

    public Room(UUID id, String name, UUID teacherId) {
        this.id = id;
        this.name = name;
        this.isOrdered = false;
        this.teacherId = teacherId;
    }
}

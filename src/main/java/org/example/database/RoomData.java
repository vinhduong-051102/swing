package org.example.database;

import org.example.model.Room;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RoomData {
    private final List<Room> db = new ArrayList<>();
    // thêm lớp học mới
    public int addNewRoom(@NotNull Room room) {
        UUID id = UUID.randomUUID();
        room.setId(id);
        db.add(room);
        return 1;
    }
    // đăng ký mượn lớp học
    public int borrowClass(UUID id) {
        for(Room room: db) {
            if(room.getId().equals(id)) {
                room.setOrdered(true);
                return 1;
            }
        }
        return 0;
    }
    // trả lại lớp học
    public int paybackClass(UUID id) {
        for(Room room: db) {
            if(room.getId().equals(id)) {
                room.setOrdered(false);
            }
        }
        return 1;
    }
    // lấy tất cả lớp học
    public List<Room> getAll() {
        return db;
    }

}

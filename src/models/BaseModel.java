package models;

import java.util.Date;

public class BaseModel {
    private int id;
    private Date insertedAt;
    private Date updatedAt;

    public BaseModel(int id, Date insertedAt, Date updatedAt) {
        this.id = id;
        this.insertedAt = insertedAt;
        this.updatedAt = updatedAt;
    }


    public Date getInsertedAt() {
        return insertedAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public int getId() {
        return id;
    }
}

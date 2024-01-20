package models;

public class BaseModel {
    private int id;
    private int insertedAt;
    private int updatedAt;

    public int getInsertedAt() {
        return insertedAt;
    }

    public int getUpdatedAt() {
        return updatedAt;
    }

    public int getId() {
        return id;
    }
}

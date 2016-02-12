package io.khasang.wlogs.model;

/**
 * Created by e.karpov on 12.02.2016.
 */
public class Item {
    int ID;
    String pName;
    String description;

    public Item() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Item{" +
                "ID=" + ID +
                ", pName='" + pName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

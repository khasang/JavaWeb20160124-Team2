package io.khasang.wlogs.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 134 on 09.02.2016.
 */
public class SelectDataFromTable {
    private String firstItem = "Apples";
    private int firstItemPrice = 100;
    private String secondItem = "Oranges";
    private int secondItemPrice = 200;
    private String result;

    public SelectDataFromTable() {
    }

    public String getFirstItem() {
        return firstItem;
    }

    public int getFirstItemPrice() {
        return firstItemPrice;
    }

    public String getSecondItem() {
        return secondItem;
    }

    public int getSecondItemPrice() {
        return secondItemPrice;
    }

    public String getResult() {
        return result;
    }

    public List<String> selectDataFromTable(String tableName) {
        return new ArrayList<String>();
    }
}

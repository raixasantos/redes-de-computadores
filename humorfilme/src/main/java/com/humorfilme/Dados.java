package com.humorfilme;

import java.lang.reflect.Array;

public class Dados {
    private String searchType;
    private String expresssion;
    private Object[] items;

    public String getSearchType() {
        return searchType;
    }

    public Object[] getItems() {
        return items;
    }

    public Object getItemByPosition(int position) {
        return items[position];
    }

    public String getExpression(){
        return this.expresssion;
    }
}

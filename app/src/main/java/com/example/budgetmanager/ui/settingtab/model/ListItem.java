package com.example.budgetmanager.ui.settingtab.model;

public class ListItem {
    private final String name;
    private final int icon;

    public ListItem(String name, int icon) {
        this.name = name;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public int getIcon() {
        return icon;
    }
}
package com.company.studentstuff;

public class Events {
    private String eventName;
    private int budget;

    public Events(String eventName, int budget) {
        this.eventName = eventName;
        this.budget = budget;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }
}

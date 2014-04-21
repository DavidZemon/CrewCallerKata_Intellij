package com.uprr.training.pojos;

/**
 * Created by igen006 on 4/21/2014.
 */
public class Dates {
    private int id;

    private String date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dates dates = (Dates) o;

        if (id != dates.id) return false;
        if (date != null ? !date.equals(dates.date) : dates.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}

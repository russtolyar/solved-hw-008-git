package com.solvd.hw007.dom;

public abstract class Conctruction {

    private String form;

    public abstract void printConstrForm();

    public Conctruction(String form) {
        this.form = form;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }
}

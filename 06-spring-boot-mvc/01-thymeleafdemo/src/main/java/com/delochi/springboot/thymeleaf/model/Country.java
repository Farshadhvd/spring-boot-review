package com.delochi.springboot.thymeleaf.model;

public enum Country {
    IRAN("Iran"),
    USA("USA"),
    AUSTRIA("Austria"),
    CANADA("Canada"),
    GERMANY("Germany"),
    UAE("UAE"),
    Oman("Oman");

    private final String label;

    Country(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}

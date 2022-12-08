package com.nespresso.selenium.testing.enums;

public enum Browser {

    CHROME("Chrome"), FIREFOX("Firefox"), EDGE("Edge"),SAFARI("Safari");

    private final String label;

    Browser(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}

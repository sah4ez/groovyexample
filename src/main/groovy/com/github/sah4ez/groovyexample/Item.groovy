package com.github.sah4ez.groovyexample

class Item {
    String name
    String type
    int value
    boolean necessary

    Item(String name, String type, int value, boolean necessary=true) {
        this.name = name
        this.type = type
        this.value = value
        this.necessary = necessary
    }
}

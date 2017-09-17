package com.github.sah4ez.groovyexample

class Repository {
    String name
    int capacity
    def items = [] as ArrayList<Item>
    def allowedItems = [] as ArrayList<String>

    Repository(String name, int capacity, ArrayList<String> allowedItems) {
        this.name = name
        this.capacity = capacity
        this.allowedItems = allowedItems
    }

    int free() {
        def all = this.capacity
        items.forEach({ all -= it.value })
        return all
    }

    boolean add(Item item) {
        if (!allowedItems.contains(item.type) || this.free() < item.value) {
            return false
        }
        this.items.add(item)
    }

    void add(Item... args) {
        (args as ArrayList).forEach({add(it)})
    }
}

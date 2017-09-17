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

    void add(Item item) {
        if (!allowedItems.contains(item.name) || this.free() < item.value) {
            return
        }
        this.items.add(item)
    }

    void add(Item... args) {
        (args as ArrayList).forEach({add(it)})
    }
}

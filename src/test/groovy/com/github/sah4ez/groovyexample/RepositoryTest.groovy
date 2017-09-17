package com.github.sah4ez.groovyexample

class RepositoryTest extends GroovyTestCase {

    private Repository rep

    void setUp() {
        super.setUp()
        rep = new Repository("first", 3, ["f"] as ArrayList<String>)
    }

    void testFree() {
        Item item = new Item("f", 1)
        rep.add(item)
        assertEquals(2, rep.free())
    }

    void testNotAllowedItems() {
        Item item = new Item("f", 1)
        Item notAllowed = new Item("ff", 2)
        rep.add(item, notAllowed)
        assertEquals(1, rep.items.size())
    }

    void testAddSeveralItems(){
        Item item1 = new Item("f", 1)
        Item item2 = new Item("f", 1)
        Item item3 = new Item("f", 1)
        rep.add(item1, item2, item3)
        assertEquals(3, rep.items.size())
    }

    void testConstrainsCapacity(){
        Item item1 = new Item("f", 1)
        Item item4 = new Item("f", 4)
        rep.add(item1, item4)
        assertEquals(1, rep.items.size())
    }
}

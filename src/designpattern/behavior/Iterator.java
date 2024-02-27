package designpattern.behavior;


import java.util.ArrayList;
import java.util.List;

class Item {
    private String title;
    private String url;
    public Item(String title, String url) {
        super();
        this.title = title;
        this.url = url;
    }

    @Override
    public String toString() {
        return "Item [title=" + title + ", url=" + url + "]";
    }
}

interface ItemIterator<T> {
    boolean hasNext();
    T next();
}

// ConcreteAggregate
class Menu {
    private List<Item> menuItems = new ArrayList<>();
    public void addItem(Item item) {
        menuItems.add(item);
    }

    // Khởi tạo đối tượng iterator
    public ItemIterator<Item> iterator() {
        return new MenuItemIterator();
    }

    // ConcreteIterator
    class MenuItemIterator implements ItemIterator<Item> {
        private int currentIndex = 0;
        @Override
        public boolean hasNext() {
            return currentIndex < menuItems.size();
        }
        @Override
        public Item next() {
            return menuItems.get(currentIndex++);
        }
    }
}

// Client
public class Iterator {
    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.addItem(new Item("Home", "/home"));
        menu.addItem(new Item("Java", "/java"));
        menu.addItem(new Item("Spring Boot", "/spring-boot"));


        ItemIterator<Item> iterator = menu.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            System.out.println(item);
        }
    }
}

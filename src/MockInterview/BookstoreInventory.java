package MockInterview;
import java.util.HashMap;
import java.util.Map;

public class BookstoreInventory {

    private Map<String, Integer> inventory;

    public BookstoreInventory() {
        inventory = new HashMap<>();
    }

    public synchronized void addBook(String title, int quantity) {
        if(title == null || quantity < 0){
            System.out.println("Invalid input");
            return;
        } 
        if (inventory.containsKey(title)) {
            inventory.put(title, inventory.get(title) + quantity);
        } else {
            inventory.put(title, quantity);
        }
    }

    public synchronized void sellBook(String title, int quantity) {
        if(title == null || quantity < 0){
            System.out.println("Invalid input");
            return;
        } 

        if (inventory.containsKey(title)) {
            int currentQuantity = inventory.get(title);
            if (quantity > currentQuantity) {
                System.out.println("Not enough copies to sell");
            } else {
                inventory.put(title, currentQuantity - quantity);
            }
        } else {
            System.out.println("Book not available");
        }
    }

    public int getBookQuantity(String title) {
        return inventory.getOrDefault(title, 0);
    }

    public boolean hasBook(String title){
        return inventory.containsKey(title) && inventory.get(title) > 0;
    }

    public void printInventory() {
        for (String title : inventory.keySet()) {
            System.out.println(title + ": " + inventory.get(title));
        }
    }
}

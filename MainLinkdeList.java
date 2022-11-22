public class MainLinkdeList {
    int size;
    StoreNode head;
    StoreNode tail;
    ShoppingCartList cart;

    public ItemNode searchItem(String name, String id) {
        StoreNode store = head;
        if (head == null) {
            return null;
        }
        while (true) {
            // storeLinkedList that holds all of the items inside each store
            StoreLinkedList storeLinkedList = store.store;
            if (storeLinkedList == null) {
                store = store.next;
                continue;
            }
            return storeLinkedList.searchForItemNode(name, id); // add the item
        }
    }

    public void add(int storeNumber, ItemNode itm) {

        StoreNode store = head;
        if (head == null) {
            return;
        }
        while (true) {
            // storeLinkedList that holds all of the items inside each store
            StoreLinkedList storeLinkedList = store.store;
            if (storeLinkedList == null) {
                store = store.next;
                continue;
            }
            storeLinkedList.addItem(itm); // add the item
            break;
        }
    }

    public double purchase() {
        double totalPrice = 0;
        if (cart == null) {
            return totalPrice; // means that nothing is the cart
        }
        ItemNode head;
        while (true) {
            head = cart.head;
            if (head == null) {
                return totalPrice;
            }
            totalPrice += head.price * head.quantity; // accumulate the item price on the totalPrice
            head = head.next; // get the next of the current itmNode
            if (head.next == null) { // if the next is null, then it is a tail, get its value and break
                totalPrice += head.price * head.quantity;
                return totalPrice;
            }
        }
    }
}

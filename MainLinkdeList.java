public class MainLinkdeList {
    int size;
    StoreNode head;
    StoreNode tail;
    ShoppingCartList cart;

    public ItemNode searchItem(String name, String id) {
        StoreNode store = head; // copy the head into store
        if (head == null) {
            return null;// this means that there are no stores in the mall
        }
        while (true) { // this loop will break conditionally
            // storeLinkedList that holds all of the items inside each store
            StoreLinkedList storeLinkedList = store.store;
            if (storeLinkedList == null) { // this means that i have a store without any items
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
            StoreLinkedList storeLinkedList = store.store;// holds a list of items of each store
            if (storeLinkedList == null) {
                store = store.next;// add the next of the current node and continue;
                continue;
            }
            itm.storeNumber = storeNumber;
            storeLinkedList.addItem(itm); // add the item
            break;
        }
    }

    public double purchase() {
        double totalPrice = 0;
        if (cart == null) {
            return totalPrice; // means that nothing is the cart
        }
        ItemNode cartHeadNode;
        while (true) {
            cartHeadNode = cart.head;
            if (cartHeadNode == null) {
                return totalPrice;
            }
            totalPrice += cartHeadNode.price * cartHeadNode.quantity; // accumulate the item price on the totalPrice
            if (cartHeadNode.next != null) {

                cartHeadNode = cartHeadNode.next; // get the next of the current itmNode
                if (cartHeadNode.next == null) { // if the next is null, then it is a tail, get its value and break
                    totalPrice += cartHeadNode.price * cartHeadNode.quantity;
                    return totalPrice;
                }
            } else {
                return totalPrice;
            }
        }
    }

    public void setCart(ShoppingCartList cart) {
        this.cart = cart;
    }
}

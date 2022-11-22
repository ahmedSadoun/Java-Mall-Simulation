public class ShoppingCartList {
    int size;
    ItemNode head;
    ItemNode tail;

    public void addItem(ItemNode itm) {
        ItemNode searchResulItem = searchForItemNode(itm.ID);
        if (head == null) { // if the head is null then this means this the first item to be added to the
                            // store, then the head and the tail are pointing to the same place
            head = itm;// set the head to the itm that we want to add to the store.
            tail = head;// tail equals head

        } else if (searchResulItem == null) {
            // search for the item if existed then update its quantity.
            tail.next = itm;
            tail = itm;

        } else {
            // then update the item quantity
            searchResulItem.price += itm.price;
            searchResulItem.quantity += itm.quantity;
        }
    }

    // in order to use it from outside the function
    private ItemNode searchForItemNode(String id) {
        ItemNode itm = head;
        while (true) {

            if (itm == null) {
                return null;
            }
            if (itm.ID == id) {
                return itm;
            }
        }
    }
}


public class StoreLinkedList {
    int size;
    ItemNode head;// once it is initialized it will never change
    ItemNode tail;// will always indicates to null

    public boolean addItem(ItemNode itm) {
        ItemNode searchResulItem = searchForItemNode(itm.ID);
        if (head == null) { // if the head is null then this means this the first item to be added to the
                            // store, then the head and the tail are pointing to the same place
            head = itm;// set the head to the itm that we want to add to the store.
            tail = head;// tail equals head
            return true;
        } else if (searchResulItem == null) {
            // search for the item if existed then update its quantity.
            tail.next = itm;
            tail = itm;
            return true;
        } else if (searchResulItem.ID == itm.ID) {
            // then update the item quantity
            searchResulItem.quantity += itm.quantity;

            return true;
        } else if (searchResulItem.next.ID == itm.ID) {

            searchResulItem.next.quantity = itm.quantity;

            return true;
        }

        return false;
    }

    /*
     * to delete an itemNode from the list we have the head is pointing to the head
     * ItemNode, from there we will start browsing searching for the id we want
     */
    public boolean deleteItems(String id) {
        ItemNode itm = searchForItemNode(id);

        if (searchForItemNode(id) == null) {
            return false;
        } else {
            delete(itm);
        }
        return true;
    }

    private void delete(ItemNode itm) {
        /*
         * we have either the current node in case of the head or the the current and
         * its
         * next which is id of it matches the id desired
         */
        /*
         * if itm's id is matched with the head's id then the desired node is the head
         * so we have two cases either the list have just one node which is the head
         * or the list has more than the head node.
         * in the first case we will just put the head to null
         * in the second case we will make the new head is the current head's next
         */
        if (itm.ID == head.ID) {
            if (head.next != null) {
                head = head.next;
            } else {
                head = null;
            }
        } else if (itm.next.next == null) { // if the next of the next of the current node is null then the desired node
                                            // is a tail
            itm.next = null;
        } else {
            itm.next = itm.next.next; // garbage collection will do its job
        }
    }

    // this function will return the either the current itm or its next. we will use
    // it when removing
    private ItemNode searchForItemNode(String id) {
        ItemNode itm = head;// get a copy of the head in order to not change its value
        while (true) {// loop until the loop conditionally breaks like below.
            // if the next of the current item is null then this means that this is the tail
            // object, and the id is not the id we want then return false.
            if (itm == null || (itm.next == null && itm.ID != id)) {
                return null;
            }
            // if the two id are matched then return true
            if (itm.ID == id || itm.next.ID == id) {
                return itm;
            } else {// else set itm to the next object in the sequence.
                itm = itm.next;
            }
        }
    }

    // in order to use it from outside the function
    public ItemNode searchForItemNode(String name, String id) {
        ItemNode itm = head;
        while (true) {

            if (itm == null) {
                return null;
            }
            if (itm.ID == id && itm.name == name) {
                return itm;
            }
        }
    }
}

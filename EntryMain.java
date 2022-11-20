public class EntryMain {
    public static void main(String[] args) {
        ItemNode itm = new ItemNode("ahmed", "1", 100, 5, 1);
        StoreLinkedList storeOfItems = new StoreLinkedList();
        if (storeOfItems.head != null) {
            storeOfItems.head = itm;
            storeOfItems.tail = itm;
        }
        storeOfItems.tail.setNext(new ItemNode(null, null, 0, 0, 0));
        storeOfItems.tail = itm.getNext();
    }
}

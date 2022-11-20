import java.util.LinkedList;
import java.util.List;

public class StoreNode {
    StoreLinkedList store;
    StoreNode next;
    List<ItemNode> items = new LinkedList<ItemNode>();

    // check if an item is existed if true, then update its quantity, else add it to
    // the list
    private boolean checkItemExistenceInList(ItemNode item) {
        for (ItemNode itemNode : items) {
            if (itemNode.ID == item.ID) {
                itemNode = updateItemQuantity(item, itemNode);
                return true;
            }
        }
        return false;
    }

    private ItemNode updateItemQuantity(ItemNode newItem, ItemNode existedItem) {
        existedItem.quantity += newItem.quantity;
        return existedItem;
    }

    public void addItems(ItemNode item) {
        if (!checkItemExistenceInList(item)) {
            items.add(item);
            return;
        }

    }
}

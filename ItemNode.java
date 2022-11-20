import java.lang.reflect.Constructor;

import javax.naming.directory.InitialDirContext;

public class ItemNode {
    String name;
    String ID;
    int price;
    int quantity;
    int storeNumber;
    ItemNode next;

    public ItemNode(String name, String ID,
            int price, int quantity, int storeNumber

    ) {
        this.name = name;
        this.ID = ID;
        this.price = price;
        this.quantity = quantity;
        this.storeNumber = storeNumber;
    }

    // #region setter functions

    public void setNext(ItemNode next) {
        this.next = next;
    }

    // #endregion
    // #region getter Functions
    public ItemNode getNext() {
        return next;
    }
    // #endregion
}
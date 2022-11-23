public class EntryMain {
    public static void main(String[] args) {
        ItemNode itm = new ItemNode("ahmed", "1", 100, 5, 1);
        ShoppingCartList cart = new ShoppingCartList();
        cart.addItem(itm);
        MainLinkdeList mains = new MainLinkdeList();
        mains.setCart(cart);
        System.out.println(mains.purchase());
    }
}

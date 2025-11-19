package productFactory;

public class ItemShelf {
    private int code;
    private Item item;
    private int quantity;

    public ItemShelf(int code) {
        this.code = code;
        this.quantity = 0;
    }

    public boolean isEmpty() {
        return item == null || quantity == 0;
    }

    public Boolean getIsSoldOut() {
        return quantity == 0;
    }

    public int getCode() {
        return code;
    }

    public Item getItem() {
        return item;
    }

    public void addItem(Item item, int quantity) {
        if(quantity <= 0) {
            System.out.println("Quantity must be greater than 0");
            return;
        }

        if(isEmpty()) {
            this.item = item;
            this.quantity = quantity;
            return;
        }

        if(this.item.getItemType() == item.getItemType() ) {
            this.quantity += quantity;
            return;
        }

        System.out.println("Cannot place different item on shelf: " + this.getCode());
    }

    public Item dispenseItem() {
        if(getIsSoldOut()) {
            System.out.println("Item is already sold out");
        }

        quantity--;
        return this.item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity() {
        this.quantity = quantity;
    }
}

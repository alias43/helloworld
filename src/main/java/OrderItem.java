import java.util.ArrayList;

public class OrderItem extends Menu{

    private int quantity;

    public OrderItem(String name, int price, int quantity) {
        super(name, price);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public static void addOrder(int i, int qty, ArrayList<OrderItem> orderList){
        String name = Main.menuList.get(i-1).getName();
        int price = Main.menuList.get(i-1).getPrice();
        OrderItem item = new OrderItem(name, price, qty);

        if(!orderList.contains(item)){
            orderList.add(item);
        }else{
            System.out.println("item sudah ada!");
            qty += item.getQuantity();
            item.setQuantity(qty);
        }
    }

    public static void showOrderList(ArrayList<OrderItem> orderList){
        System.out.format("%-16s %2s %6s %2s %2s", "Menu", "|", "Harga", " | ", "Jumlah\n");
        for (int i = 0; i < orderList.size(); i++) {
            OrderItem item = orderList.get(i);
            System.out.format("%-16s %2s %6s %2s %2s", (i + 1) + ". " + item.getName(), "|", item.getPrice(), " | ", item.getQuantity()+"\n");
        }
        System.out.println("----------------------------------------+");
        System.out.format("%-23s %12s", "Total :",Bill(orderList));
    }

    public static int Bill(ArrayList<OrderItem> orderList){
        int Total = 0;
        for (int i = 0; i < orderList.size(); i++) {
            OrderItem item = orderList.get(i);
            Total += (item.getPrice() * item.getQuantity());
        }
        return Total;
    }

}

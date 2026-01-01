import java.util.ArrayList;
import java.util.List;

public final class Order {
	private final List<OrderItem> itemOrderList = new ArrayList<>();
	private double total;

	public double getTotal() {
		return total;
	}

	public void outputOrder(){
		itemOrderList.forEach(System.out::println);
	}

	public void addItem(ItemCatalog.Item stockItem, int quantity){
		itemOrderList.add(new OrderItem(
				stockItem.productName,
				stockItem.price,
				quantity
			)
		);

		stockItem.stock -= quantity;
		total+= stockItem.price*quantity;
	}

	// Order creation with validation
	public void createOrder(ItemCatalog stockCatalog) {

		int orderQuantity;

		while (true) {
			String input = InputReader.readString(
					"How many different products do you want to order?"
			);

			try {
				orderQuantity = Integer.parseInt(input);
				if (orderQuantity <= 0) {
					System.out.println("Please enter a number greater than 0.");
					continue;
				}
				break;
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Please enter a number.");
			}
		}

		while (orderQuantity > 0) {

			String productOrder = InputReader.readString("What product?");
			int productQuantity;

			while (true) {
				String qtyInput = InputReader.readString("How many pieces?");
				try {
					productQuantity = Integer.parseInt(qtyInput);
					if (productQuantity <= 0) {
						System.out.println("Quantity must be greater than 0.");
						continue;
					}
					break;
				} catch (NumberFormatException e) {
					System.out.println("Invalid input. Please enter a number.");
				}
			}

			ItemCatalog.Item foundItem = null;
			for (ItemCatalog.Item item : stockCatalog.getItemCatalog()) {
				if (productOrder.equalsIgnoreCase(item.productName)) {
					foundItem = item;
					break;
				}
			}

			if (foundItem == null) {
				System.out.println("Product not found. Try again.");
				continue;
			}

			if (productQuantity > foundItem.stock) {
				System.out.println("Not enough stock available.");
				continue;
			}

			addItem(foundItem, productQuantity);
			orderQuantity--;
		}
	}




	boolean discount(Order order){
		return order.getTotal() > 500;
	}
}

final class OrderItem{
	private final String productName;
	private final double price;
	private final int quantity;

	public OrderItem(String productName, double price, int quantity) {
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}

	public double getTotalPrice(){
		return price*quantity;
	}

	@Override
	public String toString() {
		return "Product: " +productName +"\n" +
				"Quantity: "+ + quantity + "\n" +
				"Total price: " + getTotalPrice() + " €";
	}
}

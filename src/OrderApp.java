public class OrderApp {
	public static void main(String[] args) {

		String createOrder;

		do {
			System.out.println("""
                    ----------------------------------------------------
                    Welcome to the automated ordering System of our Shop.
                    ----------------------------------------------------
                    """);
			// User creation
			User user;
			user = User.createUser();
			System.out.println(user);

			String continueProcess = InputReader.readString("Continue: Y|N");
			if (!continueProcess.equalsIgnoreCase("y")) break;

			//Stock Items creation
			ItemCatalog stockItemCatalog = ItemCatalog.createStockItems();

			System.out.println("""
                    ----------------------------------------------------
                    OK now everything is prepared for your order.
                    Let's create one.
                    ----------------------------------------------------
                    """);
			//Order creation
			stockItemCatalog.outputItemCatalog();
			Order order = new Order();

			order.createOrder(stockItemCatalog);
			System.out.println("----------------------------------------------------");
			order.outputOrder();

			//Discount calculation
			boolean discountEarned = order.discount(order);
			double finalPrice;

			if (discountEarned) {
				finalPrice = new PercentageDiscount(order).totalPrice(order);
			} else {
				finalPrice = new NoDiscount(order).totalPrice(order);
			}
			System.out.println("Final Price: " + finalPrice + " €");
			//Finalization of the Order
			int choiceDelivery = InputReader.readInt("""
                    Delivery or Pickup?
                    (1) Delivery  (2) Pickup
                    """);

			if (choiceDelivery == 1) {
				new DeliveryOrder().processOrder(order);

			} else if (choiceDelivery == 2) {
				new PickupOrder().processOrder(order);
			}

			createOrder = InputReader.readString("Do you want to create a new Order? Yes - No");

		} while (createOrder.equalsIgnoreCase("yes"));
	}
}

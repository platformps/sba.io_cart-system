package com.github.perschola;

import com.github.perschola.model.Item;
import com.github.perschola.model.ItemInterface;
import com.github.perschola.service.ShoppingCartService;
import com.github.perschola.service.ShoppingStoreService;
import com.github.perschola.service.ItemContainerInterface;
import com.github.perschola.utils.IOConsole;

public class ApplicationRunner implements Runnable {
    IOConsole ioConsole = new IOConsole();
    ItemContainerInterface groceryStore = (ItemContainerInterface) new ShoppingStoreService();
    ItemContainerInterface cart = (ItemContainerInterface) new ShoppingCartService();

    public void run() {
        String mainMenuInput;
        do {
            mainMenuInput = getMainMenuInput();
            switch (mainMenuInput) {
                case "add-to-system":
                    addToSystem();
                    break;

                case "add-to-cart":
                    addToCart();
                    break;

                case "display-cart":
                    cart.display();
                    break;

                case "display-system":
                    groceryStore.display();
                    break;

                case "remove-from-cart":
                    removeFromCart();
                    break;

                case "remove-from-system":
                    removeFromSystem();
                    break;

                case "quit":
                    ioConsole.println("Bye!");
                    break;
            }
        } while (!"quit".equalsIgnoreCase(mainMenuInput));
    }

    private void removeFromSystem() {
        String itemName = ioConsole.getStringInput("Enter the name of the item to be removed from the system.");
        ItemInterface item = groceryStore.getByName(itemName);
        if (item != null) {
            cart.removeByName(itemName);
            ioConsole.println("%s was removed from cart", itemName);

            groceryStore.removeByItem(item);
            ioConsole.println("%s was removed inventory", itemName);
        } else {
            ioConsole.println("%s is not an item in the system", itemName);
        }
    }

    private void removeFromCart() {
        String itemName = ioConsole.getStringInput("Enter the name of the item to be removed from the cart.");
        ItemInterface item = cart.getByName(itemName);
        if (item != null) {
            cart.removeByName(itemName);
            ioConsole.println("%s was removed from cart", itemName);

            groceryStore.add(item);
            ioConsole.println("%s was stocked back in inventory", itemName);
        } else {
            ioConsole.println("%s is not an item in your cart", itemName);
        }
    }

    private void addToCart() {
        String itemName = ioConsole.getStringInput("Enter the name of the item");
        ItemInterface item = groceryStore.getByName(itemName);
        if (item != null) {
            cart.add(item);
            ioConsole.println("%s successfully added", itemName);
        } else {
            ioConsole.println("%s is not currently in stock", itemName);
        }
    }

    private void addToSystem() {
        String itemName = ioConsole.getStringInput("Enter the name of the item");
        String itemDescription = ioConsole.getStringInput("Enter the description of the item");
        Double itemPrice = ioConsole.getDoubleInput("Enter the price of the item");
        Integer itemQuantity = ioConsole.getIntegerInput("Enter the quantity available in the system");

        ItemInterface item = (ItemInterface) new Item();
        item.setItemName(itemName);
        item.setItemDescription(itemDescription);
        item.setItemPrice(itemPrice);
        item.setQuantity(itemQuantity);
        groceryStore.add(item);
        ioConsole.println("%s successfully added", itemName);
    }

    private String getMainMenuInput() {
        return ioConsole.getStringInput(new StringBuilder()
                .append("Welcome to the main menu.")
                .append("\nFrom here, you can select any of the following actions:\n\t[")
                .append("system, ")
                .append("cart ]")
                .toString());
    }

    private String getCartMenu() {
        return ioConsole.getStringInput(new StringBuilder()
                .append("Welcome to the cart menu.")
                .append("\nFrom here, you can select any of the following actions:\n\t[")
                .append("add, ")
                .append("remove, ")
                .append("view, ")
                .append("quit ]")
                .toString());
    }


    private String getSystemMenu() {
        return ioConsole.getStringInput(new StringBuilder()
                .append("Welcome to the system menu.")
                .append("\nFrom here, you can select any of the following actions:\n\t[")
                .append("add, ")
                .append("remove, ")
                .append("view, ")
                .append("quit ]")
                .toString());
    }
}

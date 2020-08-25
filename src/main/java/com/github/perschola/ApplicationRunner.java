package com.github.perschola;

import com.github.perschola.itemcontainerinterface.ItemContainerInterface;
import com.github.perschola.itemcontainerinterface.ShoppingCartService;
import com.github.perschola.itemcontainerinterface.ShoppingStoreService;
import com.github.perschola.model.Item;
import com.github.perschola.utils.IOConsole;

import java.util.Map;

public class ApplicationRunner implements Runnable {
    private final ItemContainerInterface groceryStore;
    private final ItemContainerInterface cart;

    public ApplicationRunner(ItemContainerInterface groceryStore, ItemContainerInterface cart) {
        this.groceryStore = groceryStore;
        this.cart = cart;
    }

    public void run() {
        IOConsole ioConsole = new IOConsole();
        ClientDecision clientDecision;
        do {
            clientDecision = ClientDecision.getValueOf(ioConsole.getStringInput(new StringBuilder()
                    .append("Welcome to the main menu.")
                    .append("\nFrom here, you can select any of the following actions:\n\t[")
                    .append("system, ")
                    .append("cart ]")
                    .toString()));
            clientDecision.perform(groceryStore, cart);
        } while (!ClientDecision.QUIT.equals(clientDecision));
    }

    // TODO - implement
    public String getHeader() {
        return String.format("%-20s %-20s %-10s %-10s\n", "Name", "Description", "Price", "Available Quantity");
    }

    @Override // TODO - implement
    public String toString() {
        return null;
    }

    public Map<String, Item> getItemCollection() {
        return null;
    }
}

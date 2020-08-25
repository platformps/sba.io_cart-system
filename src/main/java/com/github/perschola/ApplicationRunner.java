package com.github.perschola;

import com.github.perschola.itemcontainerinterface.ItemContainerInterface;
import com.github.perschola.itemcontainerinterface.ShoppingCartService;
import com.github.perschola.itemcontainerinterface.ShoppingStoreService;
import com.github.perschola.model.Item;
import com.github.perschola.model.ItemInterface;
import com.github.perschola.utils.IOConsole;

import java.util.HashMap;
import java.util.Map;

public class ApplicationRunner implements Runnable {
    private final ItemContainerInterface groceryStore;
    private final ItemContainerInterface cart;
    private final Map<String, ItemInterface> map = new HashMap<>();

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
        return String.format("AppSystem Inventory:\n%-20s %-20s %-10s %-10s\n", "Name", "Description", "Price", "Available Quantity");
    }

    @Override // TODO - implement
    public String toString() {
        return "";
    }

    public Map<String, ItemInterface> getItemCollection() {
        return map;
    }
}

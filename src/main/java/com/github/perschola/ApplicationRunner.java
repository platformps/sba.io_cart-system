package com.github.perschola;

import com.github.perschola.service.ItemContainerInterface;
import com.github.perschola.service.ShoppingCartService;
import com.github.perschola.service.ShoppingStoreService;
import com.github.perschola.utils.IOConsole;

public class ApplicationRunner implements Runnable {
    public void run() {
        IOConsole ioConsole = new IOConsole();
        ItemContainerInterface groceryStore = (ItemContainerInterface) new ShoppingStoreService();
        ItemContainerInterface cart = (ItemContainerInterface) new ShoppingCartService();
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
}

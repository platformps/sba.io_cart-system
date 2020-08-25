package com.github.perschola;

import com.github.perschola.itemcontainerinterface.ItemContainerInterface;
import com.github.perschola.itemcontainerinterface.ShoppingCartService;
import com.github.perschola.itemcontainerinterface.ShoppingStoreService;

public class MainApplication {
    public static void main(String[] args) {
        ItemContainerInterface store = (ItemContainerInterface) new ShoppingStoreService();
        ItemContainerInterface cart = (ItemContainerInterface) new ShoppingCartService();
        ApplicationRunner application = new ApplicationRunner(store, cart);
        application.init();
        application.run();
    }
}

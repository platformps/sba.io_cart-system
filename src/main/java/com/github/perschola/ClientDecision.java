package com.github.perschola;

import com.github.perschola.model.Item;
import com.github.perschola.model.ItemInterface;
import com.github.perschola.itemcontainerinterface.ItemContainerInterface;
import com.github.perschola.utils.IOConsole;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * Created by leon on 8/24/2020.
 */
public enum ClientDecision {
    ADD_TO_SYSTEM((app) -> {
        IOConsole ioConsole = new IOConsole();
        ItemContainerInterface store = app.getStore();
        String itemName = ioConsole.getStringInput("Enter the name of the item");
        String itemDescription = ioConsole.getStringInput("Enter the description of the item");
        Double itemPrice = ioConsole.getDoubleInput("Enter the price of the item");
        Integer itemQuantity = ioConsole.getIntegerInput("Enter the quantity available in the system");

        ItemInterface item = (ItemInterface) new Item();
        item.setItemName(itemName);
        item.setItemDescription(itemDescription);
        item.setItemPrice(itemPrice);
        item.setQuantity(itemQuantity);
        store.add(item);
        ioConsole.println("%s successfully added", itemName);
    }),

    ADD_TO_CART((app) -> {
        IOConsole ioConsole = new IOConsole();
        String itemName = ioConsole.getStringInput("Enter the name of the item");
        ItemInterface item = app.getStore().getByName(itemName);
        if (item != null) {
            app.getCart().add(item);
            ioConsole.println("%s successfully added", itemName);
        } else {
            ioConsole.println("%s is not currently in stock", itemName);
        }
    }),

    DISPLAY_CART((app) -> {
        new IOConsole().println(app.getCart().toString());
    }),

    DISPLAY_SYSTEM((app) -> {
        new IOConsole().println(app.toString());
    }),

    REMOVE_FROM_CART((app) -> {
        IOConsole ioConsole = new IOConsole();
        ItemContainerInterface cart = app.getCart();
        ItemContainerInterface store = app.getStore();
        String itemName = ioConsole.getStringInput("Enter the name of the item to be removed from the cart.");
        ItemInterface item = cart.getByName(itemName);
        if (item != null) {
            cart.removeByName(itemName);
            ioConsole.println("%s was removed from cart", itemName);

            store.add(item);
            ioConsole.println("%s was stocked back in inventory", itemName);
        } else {
            ioConsole.println("%s is not an item in your cart", itemName);
        }
    }),

    REMOVE_FROM_SYSTEM((app) -> {
        IOConsole ioConsole = new IOConsole();
        ItemContainerInterface store = app.getStore();
        ItemContainerInterface cart = app.getCart();
        String itemName = ioConsole.getStringInput("Enter the name of the item to be removed from the system.");
        ItemInterface item = store.getByName(itemName);
        if (item != null) {
            cart.removeByName(itemName);
            store.removeByItem(item);
            ioConsole.println("%s was removed from cart", itemName);
            ioConsole.println("%s was removed inventory", itemName);
        } else {
            ioConsole.println("%s is not an item in the system", itemName);
        }
    }),

    QUIT((app) -> {
        IOConsole ioConsole = new IOConsole();
        ioConsole.println("Bye!");
    });
    private Consumer<ApplicationRunner> operationToBePerformed;

    ClientDecision(Consumer<ApplicationRunner> operationToBePerformed) {
        this.operationToBePerformed = operationToBePerformed;
    }

    public void perform(ApplicationRunner applicationRunner) {
        operationToBePerformed.accept(applicationRunner);
    }

    public static ClientDecision getValueOf(String userInput) {
        return valueOf(userInput
                .toUpperCase()
                .replaceAll("-", "_")
                .replaceAll(" ", "_"));
    }
}

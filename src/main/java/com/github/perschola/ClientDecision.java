package com.github.perschola;

import com.github.perschola.model.Item;
import com.github.perschola.model.ItemInterface;
import com.github.perschola.service.ItemContainerInterface;
import com.github.perschola.utils.IOConsole;

import java.util.function.BiConsumer;

/**
 * Created by leon on 8/24/2020.
 */
public enum ClientDecision {
    ADD_TO_SYSTEM((store, cart) -> {
        IOConsole ioConsole = new IOConsole();
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

    ADD_TO_CART((store, cart) -> {
        IOConsole ioConsole = new IOConsole();
        String itemName = ioConsole.getStringInput("Enter the name of the item");
        ItemInterface item = store.getByName(itemName);
        if (item != null) {
            cart.add(item);
            ioConsole.println("%s successfully added", itemName);
        } else {
            ioConsole.println("%s is not currently in stock", itemName);
        }
    }),

    DISPLAY_CART((store, cart) -> {
        new IOConsole().println(cart.toString());
    }),

    DISPLAY_SYSTEM((store, cart) -> {
        new IOConsole().println(store.toString());
    }),

    REMOVE_FROM_CART((store, cart) -> {
        IOConsole ioConsole = new IOConsole();
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

    REMOVE_FROM_SYSTEM((store, cart) -> {
        IOConsole ioConsole = new IOConsole();
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

    QUIT((store, cart) -> {
        IOConsole ioConsole = new IOConsole();
        ioConsole.println("Bye!");
    });
    private BiConsumer<ItemContainerInterface, ItemContainerInterface> operationToBePerformed;

    ClientDecision(BiConsumer<ItemContainerInterface, ItemContainerInterface> operationToBePerformed) {
        this.operationToBePerformed = operationToBePerformed;
    }

    public void perform(ItemContainerInterface store, ItemContainerInterface cart) {
        operationToBePerformed.accept(store, cart);
    }

    public static ClientDecision getValueOf(String userInput) {
        return valueOf(userInput
                .toUpperCase()
                .replaceAll("-", "_")
                .replaceAll(" ", "_"));
    }
}

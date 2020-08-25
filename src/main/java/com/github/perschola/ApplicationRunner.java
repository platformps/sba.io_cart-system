package com.github.perschola;

import com.github.perschola.itemcontainerinterface.ItemContainerInterface;
import com.github.perschola.model.ItemInterface;
import com.github.perschola.orm.ItemObjectMapper;
import com.github.perschola.orm.ItemObjectMapperInterface;
import com.github.perschola.utils.DirectoryReference;
import com.github.perschola.utils.FileReader;
import com.github.perschola.utils.IOConsole;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ApplicationRunner implements Runnable {
    private final ItemContainerInterface store;
    private final ItemContainerInterface cart;
    private final Map<String, ItemInterface> map = new HashMap<>();

    public ApplicationRunner(ItemContainerInterface store, ItemContainerInterface cart) {
        this.store = store;
        this.cart = cart;
    }

    public void init() {
        File fileToBeRead = DirectoryReference.RESOURCE_DIRECTORY.getFileFromDirectory("sample.txt");
        String fileContent = new FileReader(fileToBeRead.getAbsolutePath()).toString();
        ItemObjectMapperInterface itemObjectMapper = (ItemObjectMapperInterface) new ItemObjectMapper();
        for (String lineToBeMapped : fileContent.split("\n")) {
            itemObjectMapper.setStringToParse(lineToBeMapped);
            ItemInterface item = itemObjectMapper.parseItem();
            store.add(item);
        }
    }

    public void run() {
        IOConsole ioConsole = new IOConsole();
        ClientDecision clientDecision;
        do {
            clientDecision = ClientDecision.getValueOf(ioConsole.getStringInput(new StringBuilder()
                    .append("Welcome to the main menu.")
                    .append("\nFrom here, you can select any of the following actions:\n\t")
                    .append(Arrays.toString(ClientDecision.values()))
                    .toString()));
            clientDecision.perform(this);
        } while (!ClientDecision.QUIT.equals(clientDecision));
    }

    public String getHeader() {
        return String.format("Inventory:\n%-20s %-20s %-10s %-10s\n", "Name", "Description", "Price", "Available Quantity");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(getHeader());
        getItemCollection().forEach((k,item) -> sb.append(item.toString()));
        return sb.toString();
    }

    public Map<String, ItemInterface> getItemCollection() {
        return map;
    }

    public ItemContainerInterface getStore() {
        return store;
    }

    public ItemContainerInterface getCart() {
        return cart;
    }
}

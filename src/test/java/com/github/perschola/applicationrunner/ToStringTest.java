package com.github.perschola.applicationrunner;

import com.github.perschola.ApplicationRunner;
import com.github.perschola.itemcontainerinterface.ItemContainerInterface;
import com.github.perschola.itemcontainerinterface.ShoppingCartService;
import com.github.perschola.itemcontainerinterface.ShoppingStoreService;
import com.github.perschola.model.Item;
import com.github.perschola.model.ItemBuilder;
import com.github.perschola.model.ItemInterface;
import com.github.perschola.utils.RandomDataGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by leon on 8/24/2020.
 */
public class ToStringTest {
    private RandomDataGenerator randomDataGenerator = new RandomDataGenerator();

    private void test(List<ItemInterface> storeItems, List<ItemInterface> cartItems) {
        // given
        ItemContainerInterface store = (ItemContainerInterface) new ShoppingStoreService();
        ItemContainerInterface cart = (ItemContainerInterface) new ShoppingCartService();
        storeItems.forEach(store::add);
        cartItems.forEach(cart::add);
        ApplicationRunner applicationRunner = new ApplicationRunner(store, cart);
        StringBuilder sb = new StringBuilder(applicationRunner.getHeader());
        applicationRunner.getItemCollection().forEach((k, item) -> sb.append(item.toString()));
        String expected = sb.toString();

        // when
        String actual = applicationRunner.toString();

        // then
        Assertions.assertEquals(expected, actual);
    }

    private List<ItemInterface> generateRandomStoreItems(int numberOfItems) {
        return Stream
                .generate(() -> {
                    int randomAvailableQuantity = randomDataGenerator.createInteger(1, 100);
                    int randomQuantity = randomDataGenerator.createInteger(1, randomAvailableQuantity);
                    String randomDescription = Arrays.toString(randomDataGenerator.createStrings('a', 'z', 10, 5));
                    Double randomPrice = randomDataGenerator.createDouble(0.1, 1000.0);
                    return new ItemBuilder()
                            .setAvailableQuantity(randomAvailableQuantity)
                            .setQuantity(randomQuantity)
                            .setItemDescription(randomDescription)
                            .setItemPrice(randomPrice)
                            .build();
                })
                .limit(numberOfItems)
                .collect(Collectors.toList());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,10})
    public void test(int numberOfItemsToBeAddedToStore) {
        List<ItemInterface> itemsToBeAddedToStore = generateRandomStoreItems(numberOfItemsToBeAddedToStore);
        List<ItemInterface> itemsToBeAddedToCart = itemsToBeAddedToStore.subList(0, randomDataGenerator.createInteger(1, itemsToBeAddedToStore.size()));
        test(itemsToBeAddedToStore, itemsToBeAddedToCart);
    }
}

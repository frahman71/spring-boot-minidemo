package se.webstep.demoapplication.jsonutil;

import static org.hamcrest.Matchers.is;

import org.junit.Assert;
import org.junit.Test;

import se.webstep.springbootdemo.helpers.JSONHelper;


public class VerifyJSONGeneration {

    private class Item {

        private Integer itemId;
        private String itemName;

        public Item(Integer itemId, String itemName) {
            this.itemId = itemId;
            this.itemName = itemName;
        }

        public Integer getItemId() {
            return itemId;
        }

        public void setItemId(Integer itemId) {
            this.itemId = itemId;
        }

        public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
        }
    }

    private Item getMockedItem() {
        Item item = new Item(1, "itemOne");
        return item;
    }

    @Test
    public void verifyGeneratedJSONFromJavaObject() {
        Item mockedItem=getMockedItem();

        String itemAsJSON= JSONHelper.getJSONVariantOfObjectResponse("anItem",mockedItem);

        Assert.assertThat(itemAsJSON.contains("anItem"),is(true));
        Assert.assertThat(itemAsJSON.contains("1"),is(true));
        Assert.assertThat(itemAsJSON.contains("itemOne"),is(true));
    }

}

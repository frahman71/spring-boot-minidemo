package se.webstep.springbootdemo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ITEM")
public class Item {

    @Id
    @Column(name="ITEM_ID")
    private Integer itemId;
    @Column(name="QUANTITY")
    private Integer quantity;
    @Column(name="ITEM_DESCRIPTION")
    private String itemDescription;

    public Item() {

    }

    public Item(Integer itemId, Integer quantity, String itemDescription) {
        this.itemId = itemId;
        this.quantity = quantity;
        this.itemDescription = itemDescription;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }
}

package epam.ssu.cources.model;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

public class Item {

    private String id;

    private String title;

    private int price;

    private String desc;

    @JsonCreator
    public Item(@JsonProperty("id") String id,@JsonProperty("title") String title,@JsonProperty("price") int price,@JsonProperty("desc") String desc) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.desc = desc;
    }

    public Item(String title, int price, String desc) {
        this.title = title;
        this.price = price;
        this.desc = desc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return id +":"+title+":"+price+":"+desc+"\n";
    }
}

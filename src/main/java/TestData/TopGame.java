package TestData;

public class TopGame {
    private String title;
    private String released;
    private String price;

    public TopGame(String title, String released, String price){
        this.title = title;
        this.released = released;
        this.price = price;
    }

    public String getTitle(){
        return this.title;
    }

    public String getReleased(){
        return this.released;
    }

    public String getPrice(){
        return this.price;
    }
}

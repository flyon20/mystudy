package domain;

public class NoteBook implements Equipment {

    private String model;
    private String price;


    public NoteBook() {
    }

    public NoteBook(String model,String price) {
        this.model = model;
        this.price=price;
    }

    public String getModel() {
        return model;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setModel(String model) {
        this.model = model;
    }
    @Override
    public String getDescription() {
        return model+"("+price+")";
    }
}

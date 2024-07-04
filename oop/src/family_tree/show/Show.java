package family_tree.show;

public class Show implements ShowInterface{
    private String text="";

    public Show(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        System.out.println(text);
        return  null;
    }
}

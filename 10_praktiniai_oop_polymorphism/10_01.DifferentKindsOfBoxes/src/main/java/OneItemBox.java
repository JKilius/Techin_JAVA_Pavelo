import java.util.ArrayList;

public class OneItemBox extends Box {
    private Item item;
    public OneItemBox (){
        item=null;
    }
    @Override
    public void add(Item item) {
        if(this.item==null) this.item=item;
    }

    @Override
    public boolean isInBox(Item item) {
        return this.item == null ? false : this.item.equals(item);
    }
}

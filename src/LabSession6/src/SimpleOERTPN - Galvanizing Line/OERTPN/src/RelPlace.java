import Interfaces.PlaceTemplate;

public class RelPlace implements PlaceTemplate {
    Rel value;
    String name;


    public RelPlace(  String name,Rel value) {
        this.value = value;
        this.name = name;
    }
    @Override
    public String GetPlaceName() {
        return this.name;
    }

    @Override
    public void SetPlaceName(String name) {
        this.name = name;
    }

    @Override
    public Object Get() {
        return this.value;
    }

    @Override
    public Boolean IsNull() {

        return this.Get() == null;
    }

    @Override
    public void Set(Object value) {
        this.value = (Rel) value;
    }

    @Override
    public String Print() {
        return "[" + this.name + "=" + this.value +"]";
    }

    @Override
    public void Init(String name, Object value) {
        this.SetPlaceName(name);
        this.Set(value);

    }
}

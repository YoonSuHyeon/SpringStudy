package generic;

public class GenericPrinter<T extends Meterial> {
    public T getMaterial() {
        return material;
    }

    public void setMaterial(T material) {
        this.material = material;
    }

    private T material;

    public String toString(){
        material.doPrinting();
        return material.toString();

    }
}

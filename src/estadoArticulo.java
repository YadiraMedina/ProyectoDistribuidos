
public final class estadoArticulo {
    
    private int id;
    private String nombre;
    
    public estadoArticulo(int id, String nom){
        setId(id);
        setNombre(nom);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String toString(){
        return nombre;
    }
}

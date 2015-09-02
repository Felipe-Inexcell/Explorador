package cl.inexcell.sistemadegestion.objetos;

/**
 * Created by felip on 31/08/2015.
 */
public class Boton {
    String id;
    String name;
    boolean enabled;


    public Boton(String id, String name, String enabled) {
        this.id = id;
        this.name = name;
        this.enabled = enabled.equals("true");
    }

    public Boton() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled.equals("true");
    }
}

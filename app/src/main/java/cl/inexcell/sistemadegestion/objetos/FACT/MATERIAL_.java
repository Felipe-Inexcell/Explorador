package cl.inexcell.sistemadegestion.objetos.FACT;

import java.util.ArrayList;

public class MATERIAL_ {
    String name;
    String type;
    ArrayList<String> series;

    public MATERIAL_(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public void addSerie(String serie){
        if(series == null)series = new ArrayList<>();
        series.add(serie);
    }

    public void rmvSerie(int position){
        if(series != null)
            series.remove(position);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<String> getSeries() {
        return series;
    }

    public void setSeries(ArrayList<String> series) {
        this.series = series;
    }
}

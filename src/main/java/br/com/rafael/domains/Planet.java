package br.com.rafael.domains;

import br.com.rafael.persistences.models.PlanetModel;

import java.util.List;

public class Planet {
    private int id;
    private int width;
    private int height;
    private List<Probe> probes;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getHeight() {
        return height;
    }

    public List<Probe> getProbes() {
        return probes;
    }

    public void setProbes(List<Probe> probes) {
        this.probes = probes;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PlanetModel) {
            return ((Planet) obj).id == this.id;
        }
        return false;
    }
}

package br.com.rafael.domain;

import br.com.rafael.persistence.model.PlanetModel;

import java.util.List;

public class Planet {
    private int id;
    private int width;
    private int height;
    private List<Probe> probes;

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
    public void setHeight(int height) {
        this.height = height;
    }

    public List<Probe> getProbes() {
        return probes;
    }

    public void setProbes(List<Probe> probes) {
        this.probes = probes;
    }
}

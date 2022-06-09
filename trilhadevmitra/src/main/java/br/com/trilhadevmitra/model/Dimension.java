package br.com.trilhadevmitra.model;

import java.util.List;

public class Dimension {
    private Integer id;
    private String name;
    private String idDataType;
    private List<DimensionContent> dimensionContents;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdDataType() {
        return idDataType;
    }

    public void setIdDataType(String idDataType) {
        this.idDataType = idDataType;
    }

    public List<DimensionContent> getDimensionContents() {
        return dimensionContents;
    }

    public void setDimensionContents(List<DimensionContent> dimensionContents) {
        this.dimensionContents = dimensionContents;
    }
}

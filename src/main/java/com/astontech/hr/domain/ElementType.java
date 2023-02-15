package com.astontech.hr.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class ElementType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ElementTypeId")
    private Integer id;

    @Version
    private Integer version;

    private String elementTypeName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Element> elementList;

    public ElementType(){};
    public ElementType(String elementTypeName){
        this.elementTypeName = elementTypeName;
    };
    public ElementType(String elementTypeName, List<Element> elementList){
        this.elementTypeName = elementTypeName;
        this.elementList = elementList;

    };

    //region    GETTER / SETTERS

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getElementTypeName() {
        return elementTypeName;
    }

    public void setElementTypeName(String elementTypeName) {
        this.elementTypeName = elementTypeName;
    }

    public List<Element> getElementList() {
        return elementList;
    }

    public void setElementList(List<Element> elementList) {
        this.elementList = elementList;
    }


    //endregion


    public String printElementList() {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < elementList.size(); i++) {
            sb.append(elementList.get(i).getElementName());
            if (i != elementList.size()-1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }




    @Override
    public String toString() {
        return "ElementType{" +
                "elementList=" + elementList +
                '}';
    }
}
package com.astontech.hr.services;

import com.astontech.hr.domain.Element;
import com.astontech.hr.domain.ElementType;

import java.util.List;

public interface ElementTypeService {

    Iterable<ElementType> listAllElementTypes();

    ElementType getElementTypeById(Integer id);

    ElementType saveElementType(ElementType elementType);

//    Iterable<ElementType> saveElementTypeList(Iterable<ElementType> elementTypeIterableIterable);

    void deleteElementType(Integer id);


    //  custom repo methods
    List<ElementType> findByElementTypeName(String elementTypeName);

    ElementType findElementTypeById(int id);

    List<Element> findAllElementByElementTypeName(String elementTypeName);

//    List<ElementType> findAllByElementTypeNameIgnoreCase(String elementTypeName);

}

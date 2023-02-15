package com.astontech.hr.services.impl;

import com.astontech.hr.domain.Element;
import com.astontech.hr.domain.ElementType;
import com.astontech.hr.repositories.ElementTypeRepository;
import com.astontech.hr.services.ElementTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElementTypeServiceImpl implements ElementTypeService {

    @Autowired
    private ElementTypeRepository elementTypeRepository;

    @Override
    public Iterable<ElementType> listAllElementTypes() {
        return elementTypeRepository.findAll();
    }

    @Override
    public ElementType getElementTypeById(Integer id) {
        return elementTypeRepository.findOne(id);
    }

    @Override
    public ElementType saveElementType(ElementType elementType) {
        return elementTypeRepository.save(elementType);
    }

//    @Override
//    public Iterable<ElementType> saveElementTypeList(Iterable<ElementType> elementTypeIterableIterable) {
//        return null;
//    }

    @Override
    public void deleteElementType(Integer id) {
        elementTypeRepository.delete(id);
    }

    @Override
    public List<ElementType> findByElementTypeName(String elementTypeName) {
        return elementTypeRepository.findElementTypeByElementTypeName(elementTypeName);
    }

    @Override
    public ElementType findElementTypeById(int id){
        return elementTypeRepository.findElementTypeById(id);
    }

    @Override
    public List<Element> findAllElementByElementTypeName(String elementTypeName) {
        return elementTypeRepository.findElementListByElementTypeName(elementTypeName);
    }

//    @Override
//    public List<ElementType> findAllByElementTypeNameIgnoreCase(String elementTypeName) {
//        return null;
//    }
}

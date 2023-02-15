package services;


import com.astontech.hr.Application;
import com.astontech.hr.domain.Element;
import com.astontech.hr.domain.ElementType;
import com.astontech.hr.services.ElementTypeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
@WebAppConfiguration
public class ElementTypeServiceTest {

    @Autowired
    private ElementTypeService elementTypeService;

    @Test
    public void elementTypeServiceSaveTest(){
        ElementType elementTypeTest = new ElementType("Test");
        assertNull(elementTypeTest.getId());
        elementTypeService.saveElementType(elementTypeTest);
        assertNotNull(elementTypeTest.getId());

        ElementType fetchedElementType = elementTypeService.getElementTypeById(elementTypeTest.getId());
        assertNotNull(fetchedElementType);
        assertEquals(elementTypeTest.getId(), fetchedElementType.getId());

    }

//    @Test
//    public void elementListFromElementType(){
//        ElementType elementType = new ElementType("List Test");
//
//        Element element1 = new Element("element1");
//        Element element2 = new Element("element2");
//
//    }



}

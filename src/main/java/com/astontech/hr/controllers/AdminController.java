package com.astontech.hr.controllers;

import com.astontech.hr.domain.*;
import com.astontech.hr.domain.VO.ElementVO;
import com.astontech.hr.domain.VO.VO;
import com.astontech.hr.repositories.VehicleRepository;
import com.astontech.hr.services.ElementTypeService;
import com.astontech.hr.services.VehicleMakeService;
import com.astontech.hr.services.VehicleModelService;
import com.astontech.hr.services.VehicleService;
import com.astontech.hr.services.impl.VehicleImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private ElementTypeService elementTypeService;

    @Autowired
    private VehicleMakeService vehicleMakeService;

    @Autowired
    private VehicleModelService vehicleModelService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private VehicleRepository vehicleRepository;

    private Logger log = Logger.getLogger(AdminController.class);

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminHome() {

        return "admin/adminHome";
    }


    //region    VEHICLE MAPS

    @RequestMapping(value = "admin/vehicle/add", method = RequestMethod.GET)
    public String adminVehicleGet(Model model) {
        model.addAttribute("vo", getVehicleModelPopulatedVO());
        model.addAttribute("warningAlert", "visible");

        return "admin/vehicle/vehicle_add";
    }

    @RequestMapping(value = "/admin/vehicle/add", method = RequestMethod.POST)
    public String adminVehicleMakePost(VO vo, Model model){

        if (vo.getVehicleMake().getName() != null && !vo.getVehicleMake().getName().equals("")) {
            saveMakeAndModelFromVO(vo);
        } else if(vo.getVehicle().getVin() != null &&!vo.getVehicle().getVin().equals("")){
            saveVehicleFromVO(vo);
        } else {
            model.addAttribute("vo", getVehicleModelPopulatedVO());
            return "/admin/vehicle/vehicle_add";
        }
        boolean success = true;
        if (success)
            model.addAttribute("successAlert", "visible");
        else
            model.addAttribute("errorAlert", "visible");

        model.addAttribute("vo", getVehicleModelPopulatedVO());
        return "admin/vehicle/vehicle_add";
    }

    @RequestMapping(value = "admin/vehicle/listM", method = RequestMethod.GET)
    public String adminVehicleMakeList(Model model){
        model.addAttribute("vehicleMakeList", vehicleMakeService.listAllVehicleMakes());

        return "admin/vehicle/vehicle_make_list";
    }

    @RequestMapping(value = "/admin/vehicle/modeledit/{id}", method = RequestMethod.GET)
    public String vehicleMakeEdit(@PathVariable int id, Model model) {
        VehicleMake vehicleMake = vehicleMakeService.getVehicleMakeById(id);

        model.addAttribute("vehicleMake", vehicleMake);
        return "admin/vehicle/vehicle_make_edit";
    }

    @RequestMapping(value = "/admin/vehicle/modeldelete/{id}", method = RequestMethod.GET)
    public String vehicleMakeDelete(@PathVariable int id) {
        vehicleMakeService.deleteVehicleMake(id);
        return "redirect:/admin/vehicle/vehicle_make_list";
    }

    @RequestMapping(value = "/admin/vehicle/updatemake", method = RequestMethod.POST)
    public String vehicleMakeUpdate(VehicleMake vehicleMake,
                                    Model model,
                                    @RequestParam("inputNewModel") String newModel) {

        //  if newElement (unbound text box) has value add it to the list

        vehicleMakeService.updateVehicleMake(vehicleMake, newModel);

        return "redirect:/admin/vehicle/modeledit/" + vehicleMake.getId();

    }






    @RequestMapping(value = "admin/vehicle/listV", method = RequestMethod.GET)
    public String adminVehicleList(Model model){

        List<Vehicle> vehicleList = (List<Vehicle>) vehicleService.listAllVehicles();

        for(Vehicle vehicle : vehicleList) {
            vehicle.setVehicleModel(vehicleService.findVehicleModelByVehicleId(vehicle.getId()));
            vehicle.setVehicleMake(vehicleService.findVehicleMakeByVehicleId(vehicle.getId()));
        }



        model.addAttribute("vehicleList", vehicleList);

        return "admin/vehicle/vehicle_list";
    }

    @RequestMapping(value = "/admin/vehicle/vehicleedit/{id}", method = RequestMethod.GET)
    public String vehicleEdit(@PathVariable int id, Model model) {

        Vehicle vehicle = vehicleService.getVehicleById(id);

        model.addAttribute("vehicle", vehicle);
        return "admin/vehicle/vehicle_edit";
    }

    @RequestMapping(value = "/admin/vehicle/updatevehicle", method = RequestMethod.POST)
    public String vehicleUpdate(Vehicle vehicle,
                                Model model) {
        if(vehicleService.findVehicleByVin(vehicle.getVin()) != null){
            return "redirect:/admin/vehicle/vehicleedit/" + vehicle.getId();
        } else {
            vehicleService.saveVehicle(vehicle);
        }
        return "redirect:/admin/vehicle/vehicleedit/" + vehicle.getId();
    }

    @RequestMapping(value = "/admin/vehicle/vehicledelete/{id}", method = RequestMethod.GET)
    public String vehicleDelete(@PathVariable @Param("id") int id) {

        vehicleRepository.deleteVehicleAssociation(id);
        vehicleService.deleteVehicle(id);
        return "redirect:/admin/vehicle/listV";
    }




    //endregion


    //region    ELEMENTS MAPS

    @RequestMapping(value = "admin/element/add", method = RequestMethod.GET)
    public String adminElementGet(Model model) {
        model.addAttribute("elementVO", new ElementVO());
        model.addAttribute("warningAlert", "visible");

        return "admin/element/element_add";
    }

    @RequestMapping(value = "/admin/element/add", method = RequestMethod.POST)
    public String adminElementPost(ElementVO elementVO, Model model){
        elementVO.splitNewElementsIntoArray();
        logElementVO(elementVO);

        saveElementTypeAndElementsFromVO(elementVO);

        boolean success = true;
        if (success)
            model.addAttribute("successAlert", "visible");
        else
            model.addAttribute("errorAlert", "visible");

        model.addAttribute("elementVO", new ElementVO());
        return "admin/element/element_add";
    }

    @RequestMapping(value = "admin/element/list", method = RequestMethod.GET)
    public String adminElementList(Model model){
        model.addAttribute("elementTypeList", elementTypeService.listAllElementTypes());

        return "admin/element/element_list";
    }

    @RequestMapping(value = "/admin/element/edit/{id}", method = RequestMethod.GET)
    public String elementTypeEdit(@PathVariable int id, Model model) {
        ElementType elementType = elementTypeService.getElementTypeById(id);

        model.addAttribute("elementType", elementType);
        return "admin/element/element_edit";
    }

    @RequestMapping(value = "/admin/element/delete/{id}", method = RequestMethod.GET)
    public String elementTypeDelete(@PathVariable int id) {
        elementTypeService.deleteElementType(id);
        return "redirect:/admin/element/list";
    }

    @RequestMapping(value = "/admin/element/update", method = RequestMethod.POST)
    public String elementTypeUpdate(ElementType elementType,
                                    Model model,
                                    @RequestParam("inputNewElement") String newElement) {

        //  if newElement (unbound text box) has value add it to the list
        if(!newElement.equals("")) {
            if(elementType.getElementList() == null) {
                List<Element> elementList = new ArrayList<Element>();
                elementList.add(new Element(newElement));
                elementType.setElementList(elementList);
            } else {
                elementType.getElementList().add(new Element(newElement));
            }
        }
        
        //  iterate through the list of elements
        for (int i = 0; i < elementType.getElementList().size(); i++) {
            //check to see if element name is empty or blank
            if(elementType.getElementList().get(i).getElementName().equals("")){
                //element name is blank remove it for the list
                elementType.getElementList().remove(i);
            }
        }

        elementTypeService.saveElementType(elementType);


        return "redirect:/admin/element/edit/" + elementType.getId();

    }

    //endregion

    //region    ELEMENT HELPER METHODS

    private void saveElementTypeAndElementsFromVO(ElementVO elementVO){
        List<Element> newElementList = new ArrayList<Element>();
        for(String str : elementVO.getNewElementArray()){
            newElementList.add(new Element(str));
        }
        ElementType newElementType = new ElementType(elementVO.getNewElementType());
        newElementType.setElementList(newElementList);

        elementTypeService.saveElementType(newElementType);

    }

    private void logElementVO(ElementVO elementVO){
        log.info("New Element Type: " + elementVO.getNewElementType());


        for(String str : elementVO.getNewElementArray()) {
            log.info("New Element: " + str);
        }
    }

    //endregion

    //region    VEHICLE HELPER METHODS

    private VO getVehicleModelPopulatedVO() {
        VO vo = new VO();
        vo.getVehicleMake().setVehicleModelList(vehicleModelService.listAllVehicleModels());
        return vo;
    }

    private void saveMakeAndModelFromVO(VO vo){

        List<VehicleModel> newModels = vo.splitNewModelsIntoArray();
        logMakeModelVO(vo);
        if(vehicleMakeService.findVehicleMakeByName(vo.getVehicleMake().getName()) == null){
            vehicleMakeService.saveVehicleMake(vo.getVehicleMake());
        } else {
            VehicleMake existingMake = vehicleMakeService.findVehicleMakeByName(vo.getVehicleMake().getName());
            List<VehicleModel> existingModels = existingMake.getVehicleModelList();

            for(VehicleModel newModel : newModels){
                boolean exists = false;
                for(VehicleModel model : existingModels){
                    if (model.getName().equals(newModel.getName())) {
                        exists = true;
                        break;
                    }
                }
                if (!exists) {
                    existingModels.add(newModel);
                    existingMake.setVehicleModelList(existingModels);
                    vehicleMakeService.saveVehicleMake(existingMake);
                }
            }
        }
    }

    private void saveVehicleFromVO(VO vo){

        VehicleMake existingMake = vehicleMakeService.findVehicleMakeByModel(vo.getVehicleModel().getName());

        if(vehicleService.findVehicleByVin(vo.getVehicle().getVin()) == null) {
            for (VehicleModel model : existingMake.getVehicleModelList()) {
                if (model.getName().equals(vo.getVehicleModel().getName())) {
                    Vehicle newVehicle = new Vehicle();

                    newVehicle.setColor(vo.getVehicle().getColor());
                    newVehicle.setVin(vo.getVehicle().getVin());
                    newVehicle.setYear(vo.getVehicle().getYear());
                    newVehicle.setPrice(vo.getVehicle().getPrice());
                    newVehicle.setPurchaseDate(vo.getVehicle().getPurchaseDate());
                    newVehicle.setSold(vo.getVehicle().getSold());
                    newVehicle.setLicensePlate(vo.getVehicle().getLicensePlate());

                    if (model.getVehicleList() == null) model.setVehicleList(new ArrayList<>());
                    model.getVehicleList().add(newVehicle);
                }
            }
            vehicleMakeService.saveVehicleMake(existingMake);
        }


    }

    private void logMakeModelVO(VO vo){
        log.info("New Vehicle Make: " + vo.getVehicleMake().getName());

        for(VehicleModel vm : vo.getVehicleMake().getVehicleModelList()) {
            log.info("New Model: " + vm.getName());
        }
    }

    //endregion


}

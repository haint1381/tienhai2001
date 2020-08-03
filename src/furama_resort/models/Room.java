package furama_resort.models;

import furama_resort.libs.AccompaniedService;

public class Room extends Services{
    private AccompaniedService freeService;
    private String flag="3";

    public Room(String id, String name, String area, String price, String peopleMax, String typeOfRent, AccompaniedService freeService, String flag) {
        super(id, name, area, price, peopleMax, typeOfRent);
        this.freeService = freeService;
        this.flag = flag;
    }

    public AccompaniedService getFreeService() {
        return freeService;
    }

    public void setFreeService(AccompaniedService freeService) {
        this.freeService = freeService;
    }
    public Room() {
    }


    @Override
    public String showInfor() {
       return "ROOM: "+"\n"+
               "1. ID Services: "+super.getId()+"\n"+
               "2.Name Services: "+super.getName()+"\n"+
               "3.Area Used: "+super.getArea()+"\n"+
               "4.Rental Costs: "+super.getPrice()+"\n"+
               "5.Maximum number of people: "+super.getPeopleMax()+"\n"+
               "6.Rental services: "+super.getTypeOfRent()+"\n"+
               "7.Includes free service: "+this.getFreeService().toString();
    }
}

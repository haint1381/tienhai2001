package furama_resort.models;

public class Room extends Services{
    private String freeService;
    private String flag="3";
    public Room(String id, String name, String area, String price, String peopleMax, String typeOfRent, String freeService,String flag) {
        super(id, name, area, price, peopleMax, typeOfRent);
        this.freeService = freeService;
    }
    public Room() {
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
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
               "7.Includes free service: "+this.getFreeService();
    }
}

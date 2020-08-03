package furama_resort.models;

public class Villa extends Services{
    private String kindOfRoom;
    private String description;
    private String poolArea;
    private String numberOfFloors;
    private String flag="1";

    public Villa(String id, String name, String area, String price, String peopleMax, String typeOfRent, String kindOfRoom, String description, String poolArea, String numberOfFloors,String flag) {
        super(id, name, area, price, peopleMax, typeOfRent);
        this.kindOfRoom = kindOfRoom;
        this.description = description;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
    }
    public Villa(){
    }

    public String getKindOfRoom() {
        return kindOfRoom;
    }

    public void setKindOfRoom(String kindOfRoom) {
        this.kindOfRoom = kindOfRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public String getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(String numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }
    @Override

    public String showInfor() {
        return "VILLA: "+"\n"+
                "1. ID Services: "+super.getId()+"\n"+
                "2.Name Services: "+super.getName()+"\n"+
                "3.Area Used: "+super.getArea()+"\n"+
                "4.Rental Costs: "+super.getPrice()+"\n"+
                "5.Maximum number of people: "+super.getPeopleMax()+"\n"+
                "6.Rental services: "+super.getTypeOfRent()+"\n"+
                "7.Kind of room: "+this.getKindOfRoom()+"\n"+
                "8.Description: "+this.getDescription()+"\n"+
                "9.Pool area: "+this.getPoolArea()+"\n"+
                "10.Number of floors: "+this.getNumberOfFloors();
    }

}

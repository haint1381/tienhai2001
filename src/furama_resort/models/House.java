package furama_resort.models;

public class House extends Services {
    private String kindOfRoom;
    private String description;
    private String numberOfFloors;
    private String flag="2";
    public House(String id, String name, String area, String price, String peopleMax, String typeOfRent, String kindOfRoom, String description, String numberOfFloors,String flag) {
        super(id, name, area, price, peopleMax, typeOfRent);
        this.kindOfRoom = kindOfRoom;
        this.description = description;
        this.numberOfFloors = numberOfFloors;
    }

    public House() {

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

    public String getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(String numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String showInfor() {
        return "HOUSE: " + "\n" +
                "1. ID Services: "+super.getId()+"\n"+
                "2.Name Services: "+super.getName()+"\n"+
                "3.Area Used: "+super.getArea()+"\n"+
                "4.Rental Costs: "+super.getPrice()+"\n"+
                "5.Maximum number of people: "+super.getPeopleMax()+"\n"+
                "6.Rental services: "+super.getTypeOfRent()+"\n"+
                "7.Kind of room: "+this.getKindOfRoom()+"\n"+
                "8.Description: "+this.getDescription()+"\n"+
                "9.Number of floors: "+this.getNumberOfFloors();
    }

}

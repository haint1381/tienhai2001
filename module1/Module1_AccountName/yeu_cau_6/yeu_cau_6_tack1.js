class Customer {
    constructor(name, CMND, Birthday, Email, Address, TypeCustomer,
                Discount, QuantityIncluded, Typeroom, RentDay, TypeService) {
        this.name=name;
        this.cmnd=CMND;
        this.birthday=Birthday;
        this.email=Email;
        this.address=Address;
        this.typeCustomer=TypeCustomer;
        this.discount=Discount;
        this.quantityIncluded=QuantityIncluded;
        this.typeroom=Typeroom;
        this.rentDay=RentDay;
        this.typeService=TypeService;
    }
    getName() {
        return this.name;
    }

    setName(name) {
        this.name = name;
    }

    getCMND() {
        return this.cmnd;
    }

    setCMND(cmnd) {
        this.cmnd = cmnd;
    }

    getBirthday() {
        return this.birthday;
    }

    setBirthday(birthday) {
        this.birthday = birthday;
    }

    getEmail() {
        return this.email;
    }

    setEmail(email) {
        this.email = email;
    }

    getAddress() {
        return this.address;
    }

    setAddress(address) {
        this.address = address;
    }

    getTypeCustomer() {
        return this.typeCustomer;
    }

    setTypeCustomer(typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    getDiscount() {
        return this.discount;
    }

    setDiscount(discount) {
        this.discount = discount;
    }

    getQuantityIncluded() {
        return this.quantityIncluded;
    }

    setQuantityIncluded(quantityIncluded) {
        this.quantityIncluded = quantityIncluded;
    }

    getTyperoom() {
        return this.typeroom;
    }

    setTyperoom(typeroom) {
        this.typeroom = typeroom;
    }

    getRentDay() {
        return this.rentDay;
    }

    setRentDay(rentDay) {
        this.rentDay = rentDay;
    }

    getTypeService() {
        return this.typeService;
    }

    setTypeService(typeService) {
        this.typeService = typeService;
    }
    TotalPays(){
        let money=0;
        if(this.getTypeService()==="Villa"){
            money=500;
        }else if(this.getTypeService()==="House"){
            money=300;
        }else if(this.getTypeService()==="Room"){
            money=100;
        }
      return  this.getRentDay()*money*(1-this.getDiscount()/100)
    }
}
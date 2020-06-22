class Employee {
    constructor(name, birthday, phone, email, cmnd, level, location) {
        this.name = name;
        this.birthday = birthday;
        this.phone = phone;
        this.email = email;
        this.cmnd = cmnd;
        this.level = level;
        this.location = location;
    }

    getName() {
        return this.name;
    }

    getBirthday() {
        return this.birthday;
    }

    getPhone() {
        return this.phone;
    }

    getEmail() {
        return this.email;
    }

    getCMND() {
        return this.cmnd;
    }

    getLocation() {
        return this.location;
    }

    getLevel() {
        return this.level;
    }

    getSalary() {
        if (this.getLocation() === "Manager") {
            this.salary = 500;
        } else if (this.getLocation() === "Sale") {
            this.salary = 300;
        } else if (this.getLocation() === "Makerting") {
            this.salary = 200;
        }
        return this.salary
    }

    setName(name) {
        this.name = name;
    }

    setBirthday(birthday) {
        this.birthday = birthday;
    }

    setPhone(phone) {
        this.phone = phone;
    }

    setEmail(email) {
        this.email = email;
    }

    setCMND(cmnd) {
        this.cmnd = cmnd;
    }

    setLocation(location) {
        this.location = location;
    }

    setLevel(level) {
        this.level = level;
    }
}
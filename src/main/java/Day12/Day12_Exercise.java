package Day12;

import java.util.ArrayList;
import java.util.List;

public class Day12_Exercise {
    private String name;//instance variable
    private String city;//instance variable
    private String state;//instance variable
    private String carModel;//instance variable
    private List<String> phoneNumbers;//instance variable

    public Day12_Exercise(String name,String city,String state,String carModel,List<String> phoneNumber){
        this.name=name;
        this.city=city;
        this.state=state;
        this.carModel=carModel;
        this.phoneNumbers=phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
}

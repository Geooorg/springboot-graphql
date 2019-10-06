package de.gs.dto;

public class AddSimpleUserInput {

    public String name;
    public String address;

    public AddSimpleUserInput(String name) {
        this.name = name;
    }

    public AddSimpleUserInput(String name, String address) {
        this.name = name;
        this.address = address;
    }
}

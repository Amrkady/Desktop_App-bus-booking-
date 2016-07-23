/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans;

/**
 *
 * @author Alkady
 */
public class Busbean {
    private int id;
    private String timeleave ,timearrive,type, name,numberseat, price ;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the timeleave
     */
    public String getTimeleave() {
        return timeleave;
    }

    /**
     * @param timeleave the timeleave to set
     */
    public void setTimeleave(String timeleave) {
        this.timeleave = timeleave;
    }

    /**
     * @return the timearrive
     */
    public String getTimearrive() {
        return timearrive;
    }

    /**
     * @param timearrive the timearrive to set
     */
    public void setTimearrive(String timearrive) {
        this.timearrive = timearrive;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the numberseat
     */
    public String getNumberseat() {
        return numberseat;
    }

    /**
     * @param numberseat the numberseat to set
     */
    public void setNumberseat(String numberseat) {
        this.numberseat = numberseat;
    }

    /**
     * @return the price
     */
    public String getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(String price) {
        this.price = price;
    }

}
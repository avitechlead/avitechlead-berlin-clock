/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubs.opsit.interviews;

/**
 *
 * @author admin
 */
public enum BerlinRowEnum {
    TOP(1,"Y"),
    FIRSTROW(4,"R"),
    SECONDROW(4,"R"),
    THIRDROW(11,"Y"),
    FOURTHROW(4,"Y");
    
    private int numberOfLamps;
    private String lampColor;

    BerlinRowEnum(int numberOfLamps, String lampColor){
        this.numberOfLamps = numberOfLamps;
        this.lampColor = lampColor;
    }
    /**
     * populate the row value for Berlin Row
     * @param number - HH or MM or SS
     * @return 
     */
    public String populateRowValue(int number){
        String rowValue = null;
        int factor;
        switch(this){
            case TOP:
                factor = number%2==0 ? 1 : 0;
                rowValue = getRowValue(1,factor);
                break;
            case FIRSTROW:
                factor = number/5;
                rowValue = getRowValue(number,factor);
                break;
            case SECONDROW:
                factor = number%5;
                rowValue = getRowValue(number,factor);
                break;
            case THIRDROW:
                factor = number/5;
                rowValue = getRowValue(number,factor);
                break;
            case FOURTHROW:
                factor = number%5;
                rowValue = getRowValue(number,factor);
                break;
            default:
                System.out.println("not a case...");
                break;
        }
                
        return rowValue;
    }
    /**
     * populates row value/ lamps on base of below params
     * @param number - HH or MM or SS
     * @param factor - factor number to show On/Off lamps
     * @return 
     */
    private String getRowValue(int number, int factor){
        boolean isThirdRow  = this.equals(THIRDROW)? true: false;
        String value = "";  

        for(int i=0; i<factor; i++){
            if(isThirdRow && (i==2 || i == 5 || i == 8)){
                value+="R";
            }else{
                value+=this.lampColor;
            }
        }
        for(int i= factor; i<this.numberOfLamps; i++){
            value+="O";
        }
        return value;
    }    
}

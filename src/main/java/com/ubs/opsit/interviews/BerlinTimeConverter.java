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
public class BerlinTimeConverter implements TimeConverter{

    private static final String NEWLINECHAR = System.getProperty("line.separator");
    
    @Override
    public String convertTime(String aTime) {
                StringBuilder berlinString = new StringBuilder();
        //split the input
        String[] splitTime = aTime.split(":");
        //validate has 3 tokens
        if (splitTime.length != 3) {
            berlinString.append("Invalid input");
        } else {
            try{
            //build berlin time
            berlinString.append(BerlinRowEnum.TOP.populateRowValue(Integer.parseInt(splitTime[2])));
            berlinString.append(NEWLINECHAR);
            berlinString.append(BerlinRowEnum.FIRSTROW.populateRowValue(Integer.parseInt(splitTime[0])));
            berlinString.append(NEWLINECHAR);
            berlinString.append(BerlinRowEnum.SECONDROW.populateRowValue(Integer.parseInt(splitTime[0])));
            berlinString.append(NEWLINECHAR);
            berlinString.append(BerlinRowEnum.THIRDROW.populateRowValue(Integer.parseInt(splitTime[1])));
            berlinString.append(NEWLINECHAR);
            berlinString.append(BerlinRowEnum.FOURTHROW.populateRowValue(Integer.parseInt(splitTime[1])));
            
            }catch(RuntimeException e){
                berlinString = new StringBuilder("Invalid input");
            }
        }
        return berlinString.toString();
    }
    public static void main(String[] args) {

        BerlinTimeConverter berlin = new BerlinTimeConverter();

        System.out.println(berlin.convertTime("00:00:00"));
        System.out.println("----------------------------");
        System.out.println(berlin.convertTime("13:17:01"));
        System.out.println("----------------------------");
        System.out.println(berlin.convertTime("23:59:59"));
        System.out.println("----------------------------");
        System.out.println(berlin.convertTime("00:00:00"));
    }    
}

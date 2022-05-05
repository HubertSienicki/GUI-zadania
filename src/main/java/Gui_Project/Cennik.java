/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui_Project;

import java.util.ArrayList;

/**
 *
 * @author kneiv
 */
public class Cennik {
    private static Cennik instance = null;

    public  ArrayList<roomPrice> menu;
    
    
    
    private class roomPrice{
        private String roomName;
        private String roomType;
        private int pricePnight;
        private int alteredPrice;
        private int nights = 0;

        public roomPrice(String roomName, String roomType, int nights, int pricePnight, int alteredPrice) {
            this.roomName = roomName;
            this.roomType = roomType;
            this.pricePnight = pricePnight;
            this.alteredPrice = alteredPrice;
            this.nights = nights;
        }
        
        public roomPrice(String roomName, String roomType, int pricePnight) {
            this.roomName = roomName;
            this.roomType = roomType;
            this.pricePnight = pricePnight;
        }

        public String getRoomName() {
            return roomName;
        }

        public void setRoomName(String roomName) {
            this.roomName = roomName;
        }

        public String getRoomType() {
            return roomType;
        }

        public void setRoomType(String roomType) {
            this.roomType = roomType;
        }

        public int getPricePnight() {
            return pricePnight;
        }

        public void setPricePnight(int pricePnight) {
            this.pricePnight = pricePnight;
        }

        public int getAlteredPrice() {
            return alteredPrice;
        }

        public void setAlteredPrice(int alteredPrice) {
            this.alteredPrice = alteredPrice;
        }

        public int getNights() {
            return nights;
        }

        public void setNights(int nights) {
            this.nights = nights;
        }
        
        
    }

    private Cennik() {
        this.menu  = new ArrayList<>();
    }
    
    
    public int getPrice(String roomType, String roomName){
        int tempPokojPrice = 0;
        
        for (int i = 0; i < menu.size(); i++) {
            if(menu.get(i).roomType.equals(roomType) && menu.get(i).roomName.equals(roomName)){
                if(menu.get(i).nights >= 4){
                    tempPokojPrice = menu.get(i).getAlteredPrice();
                    break;
                }else{
                    tempPokojPrice = menu.get(i).getPricePnight();
                    break;
                }
            }
        }
        return tempPokojPrice;
    }
    
    public void dodaj(String roomName, String roomType, int pricePnight, int alteredPrice, int nights){
        menu.add(new roomPrice(roomName, roomType, pricePnight, alteredPrice, nights));
    }
    
    public void dodaj(String roomName, String roomType, int pricePnight){
        menu.add(new roomPrice(roomName, roomType, pricePnight));
    }
    
    public static Cennik pobierzCennik(){
        if(instance == null){
            instance = new Cennik();
        }
        return instance;
    }
    
    
}

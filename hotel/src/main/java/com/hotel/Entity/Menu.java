package com.hotel.Entity;


import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name="menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="menu_id")
    private int menuId;

    @Column(name="menu_name")
    private String menuName;

    @ManyToOne
    @JoinColumn(name="hotel_id")
    private Hotel hotel;

    public Menu() {
    }

    public Menu(int menuId, String menuName, Hotel hotel) {
        this.menuId = menuId;
        this.menuName = menuName;
        this.hotel = hotel;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}

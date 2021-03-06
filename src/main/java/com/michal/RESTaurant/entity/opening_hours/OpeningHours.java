package com.michal.RESTaurant.entity.opening_hours;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.michal.RESTaurant.entity.restaurant.Restaurant;

import javax.persistence.*;

@Entity
@Table(name = "opening_hours")
public class OpeningHours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "opening_hour")
    private Integer openHour;
    @Column(name = "opening_minute")
    private Integer openMinute;
    @Column(name = "closing_hour")
    private Integer closeHour;
    @Column(name = "closing_minute")
    private Integer closeMinute;
    @Column(name = "week_day")
    private DAY dayOfWeek;
    @Column(name = "closed")
    private Boolean closed;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", referencedColumnName = "id")
    @JsonIgnore
    private Restaurant restaurant;

    public OpeningHours() {
        this.openHour = 8;
        this.openMinute = 0;
        this.closeHour = 20;
        this.closeMinute = 0;
        this.closed = false;
    }

    public Boolean getClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Integer getOpenHour() {
        return openHour;
    }

    public void setOpenHour(Integer openHour) {
        this.openHour = openHour;
    }

    public Integer getOpenMinute() {
        return openMinute;
    }

    public void setOpenMinute(Integer openMinute) {
        this.openMinute = openMinute;
    }

    public Integer getCloseHour() {
        return closeHour;
    }

    public void setCloseHour(Integer closeHour) {
        this.closeHour = closeHour;
    }

    public Integer getCloseMinute() {
        return closeMinute;
    }

    public void setCloseMinute(Integer closeMinute) {
        this.closeMinute = closeMinute;
    }

    public DAY getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DAY dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    @Override
    public String toString() {
        return "OpeningHours{" +
                "openHour=" + openHour +
                ", openMinute=" + openMinute +
                ", closeHour=" + closeHour +
                ", closeMinute=" + closeMinute +
                ", dayOfWeek=" + dayOfWeek +
                ", restaurant=" + restaurant.getName() +
                '}';
    }

    public enum DAY {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }


}


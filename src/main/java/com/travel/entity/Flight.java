package com.travel.entity;

import javax.persistence.*;

@Entity
@Table(name = "flight")
public class Flight {
    private Integer id;
    private City fromDestination;
    private City toDestination;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "from_destination")
    public City getFromDestination() {
        return fromDestination;
    }

    public void setFromDestination(City fromDestination) {
        this.fromDestination = fromDestination;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "to_destination")
    public City getToDestination() {
        return toDestination;
    }

    public void setToDestination(City toDestination) {
        this.toDestination = toDestination;
    }
}

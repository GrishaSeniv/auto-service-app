package com.example.autoserviceapp.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY)
    private Car car;
    private String description;
    private LocalDateTime acceptanceDate;
    @OneToMany
    @JoinColumn(name = "order_id")
    private List<Service> services;
    @ManyToMany
    private List<Goods> goods;
    @Enumerated(EnumType.STRING)
    private Status status;
    private BigDecimal price;
    private LocalDateTime expiredTime;

    public enum Status {
        ACCEPTED,
        IN_PROCESS,
        SUCCESSFULLY_COMPLETED,
        UNSUCCESSFULLY_COMPLETED,
        PAID

        //        private String name;
        //
        //        Status(String name) {
        //            this.name = name;
        //        }
    }
}

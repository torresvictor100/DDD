package com.ddd.learn.domain.shared.customer;

import com.ddd.learn.domain.customer.valueobject.Address;
import com.ddd.learn.domain.shared.event.EventAbstract;

import java.time.LocalDateTime;

public class AdressChangeEvent extends EventAbstract {
    public AdressChangeEvent(Address eventData, String idCustomer, String nameCustome) {
        super(LocalDateTime.now(), eventData);
        this.nameCustome = nameCustome;
        this.idCustomer = idCustomer;
        this.endereco = eventData.toString();
    }

    private String idCustomer;
    private String nameCustome;
    private String endereco;

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameCustome() {
        return nameCustome;
    }

    public void setNameCustome(String nameCustome) {
        this.nameCustome = nameCustome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}

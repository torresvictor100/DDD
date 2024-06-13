package com.ddd.learn.domain.customer.entity;

import com.ddd.learn.domain.customer.valueobject.Address;

import java.util.UUID;

//entidade focada em negocio essa entidade não vai ser a que vai ser pesistida no banco de dados
public class Customer implements CustomerInterface {

    private String id;
    private String name;
    private Boolean active;
    private Address address;
    private Integer poits;

    public Customer(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.active = false;
        this.poits = 0;
        this.validate();
    }

    @Override
    public String getName() {
        return name;
    }

    //uma entidade sempre vai ter que se alto validar
    //ao criar o objeto ele ja adiciona
    private void validate(){
        if(this.id == null){
            throw new NullPointerException("Field id is null");
        }
        if(this.name.isBlank()){
            throw new NullPointerException("Field name required");
        }
    }

    private void validateActivate(){
        if(!isActive()){
            throw new IllegalArgumentException("customen no activate");
        }
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public String recoverName() {
        return name;
    }

    //isso seria uma regra de negocio, ex: o nome precisa ser modificado
    public void changeName(String _name) {
        this.name = _name;
        this.validate();
    }

    //aqui seria apenas um set sem significar nada
    //public void set_name(String _name) {
    //    this._name = _name;
    //}


    public Boolean isActive() {
        return active;
    }

    //muito melhor que o set pq ai é um regra
    public void activate(){
        if (this.address == null){
            throw new NullPointerException("Adress is required for activate the customer");
        }
        this.active = true;
    }

    public Integer getPoits() {
        return poits;
    }

    public void setPoits(Integer poits) {
        this.validate();
        this.validateActivate();
        this.poits = poits;
    }

    public void addPoits(Integer poits) {
        this.validateActivate();
        if(poits > 0 && isActive()){
            this.poits = getPoits() + poits;
        }
    }

    public void deactivate(){
        this.active = false;
    }

    //Isso esta errado, mesmo se tivesse um construtor que so pegasse o id, não esta correto pq esta faltando dados
    //não podemos ter uma entedade que não podemos conifiar, não criamos e depois começamos a adicionar. na regra de negocio
    // o name não pode ser null;
    //Long id = 123;
    //Customer customer = new Customer(id);
}

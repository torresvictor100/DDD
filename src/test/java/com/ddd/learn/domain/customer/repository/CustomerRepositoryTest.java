package com.ddd.learn.domain.customer.repository;

import com.ddd.learn.infrastructure.customer.model.AddressModel;
import com.ddd.learn.infrastructure.customer.model.CustomerModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.NoSuchElementException;

@DataJpaTest
@ActiveProfiles("test")
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void cutomerTest(){

        //save
        CustomerModel customerModel1 = new CustomerModel();
        CustomerModel customerModel2 = new CustomerModel();
        customerModel1.setPoits(0);
        customerModel1.setName("customerModel1");

        customerModel2.setPoits(0);
        customerModel2.setName("customerModel2");

        AddressModel addressModel = new AddressModel();

        addressModel.setCity("City");
        addressModel.setZip("Zip");
        addressModel.setNumber(1);
        addressModel.setStreet("Street");

        customerModel1.setAddress(addressModel);
        customerModel2.setAddress(addressModel);

        CustomerModel customerModelSave = customerRepository.save(customerModel1);
        customerRepository.save(customerModel2);

        Assertions.assertNotNull(customerModelSave);
        Assertions.assertEquals("customerModel1", customerModelSave.getName());
        Assertions.assertEquals(addressModel, customerModelSave.getAddress());
        Assertions.assertEquals(1, customerModelSave.getAddress().getNumber());
        Assertions.assertEquals("City", customerModelSave.getAddress().getCity());
        Assertions.assertEquals("Zip", customerModelSave.getAddress().getZip());
        Assertions.assertEquals("Street", customerModelSave.getAddress().getStreet());

        //findAll

        List<CustomerModel> customerModelsList = customerRepository.findAll();
        Assertions.assertEquals(2, customerModelsList.size());

        //findById

        CustomerModel customerModelFound = customerRepository.findById(customerModel1.getId()).get();
        Assertions.assertEquals(customerModel1.getId() ,customerModelFound.getId());
        Assertions.assertEquals(customerModelFound.getName(), customerModelFound.getName());

        //update
        customerModel1.setName("customerModelUpdate");
        CustomerModel customerModelUpdate = customerRepository.save(customerModel1);
        Assertions.assertEquals("customerModelUpdate",customerModelUpdate.getName());

        //delete

        customerRepository.delete(customerModel1);
        Assertions.assertThrows(NoSuchElementException.class,() ->  {customerRepository.findById(customerModel1.getId()).get();});
    }
}

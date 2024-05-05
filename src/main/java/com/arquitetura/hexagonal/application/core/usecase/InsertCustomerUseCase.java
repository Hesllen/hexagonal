package com.arquitetura.hexagonal.application.core.usecase;

import com.arquitetura.hexagonal.application.core.domain.Customer;
import com.arquitetura.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.arquitetura.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.arquitetura.hexagonal.application.ports.out.InsertCustomerOutputPort;
import com.arquitetura.hexagonal.application.ports.out.SendCpfForValidationOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    public InsertCustomerUseCase(FindAddressByZipCodeOutputPort findAddressByZipCodeoutputPort, InsertCustomerOutputPort insertCustomerOutputPort, SendCpfForValidationOutputPort sendCpfForValidationOutputPort) {
        this.findAddressByZipCodeoutputPort = findAddressByZipCodeoutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
        this.sendCpfForValidationOutputPort = sendCpfForValidationOutputPort;
    }


    private final FindAddressByZipCodeOutputPort findAddressByZipCodeoutputPort;
    private final InsertCustomerOutputPort insertCustomerOutputPort;

    private final SendCpfForValidationOutputPort sendCpfForValidationOutputPort;
    @Override
    public void insert(Customer customer, String zipCode) {
        var address = findAddressByZipCodeoutputPort.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutputPort.insert(customer);
        sendCpfForValidationOutputPort.send(customer.getCpf());
    }
}

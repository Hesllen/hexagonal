package com.arquitetura.hexagonal.config;

import com.arquitetura.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.arquitetura.hexagonal.adapters.out.InsertCustomerAdapter;
import com.arquitetura.hexagonal.adapters.out.SendCpfValidationAdapter;
import com.arquitetura.hexagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            InsertCustomerAdapter insertCustomerAdapter,
            SendCpfValidationAdapter sendCpfValidationAdapter
    ) {
        return new InsertCustomerUseCase(findAddressByZipCodeAdapter, insertCustomerAdapter, sendCpfValidationAdapter);
    }
}

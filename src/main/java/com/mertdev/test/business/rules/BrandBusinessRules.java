package com.mertdev.test.business.rules;

import com.mertdev.test.core.utilities.exceptions.BusinessException;
import com.mertdev.test.dataAccess.abstracts.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BrandBusinessRules {
    private BrandRepository brandRepository;
    public void checkIfBrandNameExists(String name){
        if(this.brandRepository.existsByName(name)){
            throw new BusinessException("Brand already exists");
        }
    }
}

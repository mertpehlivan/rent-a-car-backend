package com.mertdev.test.business.abstracts;

import com.mertdev.test.business.requests.CreateBrandRequest;
import com.mertdev.test.business.requests.CreateModelRequest;
import com.mertdev.test.business.requests.UpdateBrandRequest;
import com.mertdev.test.business.responses.GetAllBrandsResponse;
import com.mertdev.test.business.responses.GetAllModelsResponse;
import com.mertdev.test.business.responses.GetByIdBrandResponse;

import java.util.List;

public interface ModelService {
    List<GetAllModelsResponse> getAll();
    void create(CreateModelRequest createModelRequest);
}

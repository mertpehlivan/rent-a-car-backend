package com.mertdev.test.business.abstracts;

import com.mertdev.test.business.requests.CreateBrandRequest;
import com.mertdev.test.business.requests.UpdateBrandRequest;
import com.mertdev.test.business.responses.GetAllBrandsResponse;
import com.mertdev.test.business.responses.GetByIdBrandResponse;

import java.util.List;

public interface BrandService {
	List<GetAllBrandsResponse> getAll();
	GetByIdBrandResponse getById(int id);
	void create(CreateBrandRequest createBrandRequest);
	void update(UpdateBrandRequest updateBrandRequest);
	void delete(int id);
}

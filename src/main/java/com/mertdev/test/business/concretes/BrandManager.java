package com.mertdev.test.business.concretes;

import com.mertdev.test.business.abstracts.BrandService;
import com.mertdev.test.business.requests.CreateBrandRequest;
import com.mertdev.test.business.requests.UpdateBrandRequest;
import com.mertdev.test.business.responses.GetAllBrandsResponse;
import com.mertdev.test.business.responses.GetByIdBrandResponse;
import com.mertdev.test.business.rules.BrandBusinessRules;
import com.mertdev.test.core.utilities.mappers.ModelMapperService;
import com.mertdev.test.dataAccess.abstracts.BrandRepository;
import com.mertdev.test.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class BrandManager implements BrandService{
	private BrandRepository brandRepository;
	private BrandBusinessRules brandBusinessRules;
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllBrandsResponse> getAll() {
		List<Brand> brands = brandRepository.findAll();
		List<GetAllBrandsResponse> brandsResponse = brands.stream()
				.map(brand -> this.modelMapperService.forResponse()
						.map(brand,GetAllBrandsResponse.class)).collect(Collectors.toList());

		return brandsResponse;
	}
	@Override
	public GetByIdBrandResponse getById(int id) {
		Brand brand = this.brandRepository.findById(id).orElseThrow();
		GetByIdBrandResponse brandResponse = this.modelMapperService.forResponse().map(brand,GetByIdBrandResponse.class);
		return brandResponse;
	}

	@Override
	public void create(CreateBrandRequest createBrandRequest) {
		this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());
		Brand brand = this.modelMapperService.forRequest().map(createBrandRequest,Brand.class);
		this.brandRepository.save(brand);
	}

	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {
		Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest,Brand.class);
		this.brandRepository.save(brand);
	}

	@Override
	public void delete(int id) {
		this.brandRepository.deleteById(id);
	}


}

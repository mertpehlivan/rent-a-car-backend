package com.mertdev.test.webApi.controllers;

import java.util.List;

import com.mertdev.test.business.requests.CreateBrandRequest;
import com.mertdev.test.business.requests.UpdateBrandRequest;
import com.mertdev.test.business.responses.GetAllBrandsResponse;
import com.mertdev.test.business.responses.GetByIdBrandResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.mertdev.test.business.abstracts.BrandService;
import com.mertdev.test.entities.concretes.Brand;

@RestController
@RequestMapping("api/brands")
@AllArgsConstructor
public class BrandsController {
	private BrandService brandService;

	@GetMapping()
	public List<GetAllBrandsResponse> getAll(){
		return brandService.getAll();
	}
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public void create(@RequestBody() @Valid() CreateBrandRequest createBrandRequest){
		 this.brandService.create(createBrandRequest);
	}
	@GetMapping("/{id}")
	public GetByIdBrandResponse getById(@PathVariable int id){
		return this.brandService.getById(id);
	}
	@PutMapping
	public void update(@RequestBody() UpdateBrandRequest updateBrandRequest){
		this.brandService.update(updateBrandRequest);
	}
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable() int id){
		this.brandService.delete(id);
	}


	
}

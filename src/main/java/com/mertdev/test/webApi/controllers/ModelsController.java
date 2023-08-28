package com.mertdev.test.webApi.controllers;

import com.mertdev.test.business.abstracts.ModelService;
import com.mertdev.test.business.concretes.ModelManager;
import com.mertdev.test.business.requests.CreateBrandRequest;
import com.mertdev.test.business.requests.CreateModelRequest;
import com.mertdev.test.business.responses.GetAllModelsResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/models")
@AllArgsConstructor
public class ModelsController {
    private ModelService modelService;
    @GetMapping()
    public List<GetAllModelsResponse> getAll(){
        return this.modelService.getAll();
    }
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody() @Valid() CreateModelRequest createModelRequest){
        this.modelService.create(createModelRequest);
    }
}

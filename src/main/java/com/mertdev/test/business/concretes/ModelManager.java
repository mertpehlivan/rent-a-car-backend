package com.mertdev.test.business.concretes;

import com.mertdev.test.business.abstracts.ModelService;
import com.mertdev.test.business.requests.CreateModelRequest;
import com.mertdev.test.business.responses.GetAllBrandsResponse;
import com.mertdev.test.business.responses.GetAllModelsResponse;
import com.mertdev.test.core.utilities.mappers.ModelMapperService;
import com.mertdev.test.dataAccess.abstracts.ModelRepository;
import com.mertdev.test.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> models = this.modelRepository.findAll();
        List<GetAllModelsResponse> modelsResponse = models.stream()
                .map(model -> this.modelMapperService.forResponse()
                        .map(model, GetAllModelsResponse.class)).collect(Collectors.toList());

        return modelsResponse;
    }

    @Override
    public void create(CreateModelRequest createModelRequest) {
        Model model = this.modelMapperService.forRequest().map(createModelRequest,Model.class);
        this.modelRepository.save(model);
    }
}

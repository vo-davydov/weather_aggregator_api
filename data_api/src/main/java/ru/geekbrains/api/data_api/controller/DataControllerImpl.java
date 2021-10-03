package ru.geekbrains.api.data_api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.ObjectNode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.api.data_api.application.utils.JsonResponseGenerator;
import ru.geekbrains.api.data_api.application.utils.ValidateRequestUtils;
import ru.geekbrains.api.data_api.request.DataParameters;


@RestController
public class DataControllerImpl implements DataController {
    private final ValidateRequestUtils validateRequestUtils;

    @Autowired
    public DataControllerImpl(ValidateRequestUtils validateRequestUtils) {
        this.validateRequestUtils = validateRequestUtils;
    }

    @Override
    public ResponseEntity<ObjectNode> cityData(ObjectNode json) {
        DataParameters dataParameters = validateRequestUtils.validateUserRegistrationParameters(json);
        ObjectNode response = JsonResponseGenerator.generateSuccessResponseJson();

        return ResponseEntity.ok(response);
    }
}

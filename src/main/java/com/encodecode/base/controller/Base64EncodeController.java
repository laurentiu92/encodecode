package com.encodecode.base.controller;

import com.encodecode.base.model.Base64EncodeReqDTO;
import com.encodecode.base.model.Base64EncodeRespDTO;
import com.encodecode.base.service.Base64EncodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("encode")
public class Base64EncodeController {
    @Autowired
    Base64EncodeService base64EncodeService;

    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Base64EncodeRespDTO> handleEncodeRequest(@RequestBody Base64EncodeReqDTO base64EncodeReqDTO){
        String originalValue = base64EncodeReqDTO.getValue();
        String encodedValue = base64EncodeService.encodeString(originalValue);
        Base64EncodeRespDTO response = new Base64EncodeRespDTO(originalValue,encodedValue);
        return new ResponseEntity<Base64EncodeRespDTO>(response,HttpStatus.OK);
    }

    @RequestMapping(value="/test",method = RequestMethod.GET )
    public ResponseEntity<?> test() throws InterruptedException {
        TimeUnit.SECONDS.sleep(60);
        return ResponseEntity.ok().body("Ok");
    }
}

package com.example.postDe.postDemo2.Controller;

import com.example.postDe.postDemo2.Dto.Request.nuserRequest;
import com.example.postDe.postDemo2.Dto.Request.nuserUpdateRequest;
import com.example.postDe.postDemo2.Dto.Response.nuserResponse;
import com.example.postDe.postDemo2.Identifier;
import com.example.postDe.postDemo2.Services.nuserServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/nuser")
public class nuserController {
    private final nuserServices nserServices;

    @PostMapping
    public Identifier Createuser(@RequestBody nuserRequest nserRequest){
     return   nserServices.Createaccount(nserRequest);

    }

    @GetMapping("/getalluser")
    public List<nuserResponse> getAllUser(){
        return nserServices.getUserList();
    }

    @GetMapping("/{id}")
    public nuserResponse getUserBy(@PathVariable String id){
        return nserServices.getUserBy(id);
    }

    @PutMapping("/updateuser/{id}")
    public String Update(@PathVariable String id, @RequestBody nuserUpdateRequest nserUpdateRequest){
        return nserServices.UpdateUserBy(id, nserUpdateRequest);
    }

    @DeleteMapping("/deleteuser/{id}")
        public void Delete(@PathVariable String id){
        nserServices.DeleteUserBy(id);
    }

}

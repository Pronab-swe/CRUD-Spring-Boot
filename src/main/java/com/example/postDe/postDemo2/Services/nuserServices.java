package com.example.postDe.postDemo2.Services;

import com.example.postDe.postDemo2.Domain.nuser;
import com.example.postDe.postDemo2.Dto.Request.nuserRequest;
import com.example.postDe.postDemo2.Dto.Request.nuserUpdateRequest;
import com.example.postDe.postDemo2.Dto.Response.nuserResponse;
import com.example.postDe.postDemo2.Identifier;
import com.example.postDe.postDemo2.Repository.nuserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class nuserServices {
    private final nuserRepository nserRepository;

    public Identifier Createaccount(nuserRequest nserRequest){

        UUID uuid=UUID.randomUUID();
        String uid =uuid.toString();

        nuser ns=new nuser();
        ns.setId(uid);
        ns.setNname(nserRequest.getNname());
        ns.setNemail(nserRequest.getNemail());
        ns.setNaddress(nserRequest.getNaddress());
        nserRepository.saveAndFlush(ns);

        return new Identifier(uid);

    }
    public List<nuserResponse> getUserList(){
        List<nuser> nuserList = nserRepository.findAll();

        List<nuserResponse> nuserResponseList = new ArrayList<>();
        for (nuser nser:nuserList) {
            nuserResponseList.add(new nuserResponse(nser.getNname(),nser.getNemail(),nser.getNaddress()));
        }
        return nuserResponseList;
    }

    public nuserResponse getUserBy(String id){
        Optional<nuser> nuserOptional= nserRepository.findById(id);
        nuser nser=nuserOptional.get();
        return nuserResponse.builder()
                .nname(nser.getNname())
                .nemail(nser.getNemail())
                .naddress(nser.getNaddress())

                .build();

    }

    public String UpdateUserBy(String id, nuserUpdateRequest nserUpdateRequest){
        Optional<nuser> nuserUpdateOptional=nserRepository.findById(id);

        nuser nser=nuserUpdateOptional.get();
        nser.setNname(nserUpdateRequest.getNname());
        nser.setNemail(nserUpdateRequest.getNemail());
        nser.setNaddress(nserUpdateRequest.getNaddress());
        nserRepository.save(nser);

        return "Succesfull";

    }

    public void DeleteUserBy(String id){
        Optional<nuser> nuserDeleteOptional=nserRepository.findById(id);
        nuser nser=nuserDeleteOptional.get();
        nserRepository.delete(nser);

    }
}

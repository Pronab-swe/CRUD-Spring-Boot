package com.example.postDe.postDemo2.Domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="newuser")
public class nuser {

    @Id
    private String id;
    private String nname;
    private String nemail;
    private String naddress;
}

package com.cybersoft.demosrpingboot.model.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;

import java.io.Serializable;
@Embeddable
public class IdTask implements Serializable {
    @Column(name = "user_id")
    private int userId;
    @Column(name = "project_id")
    private int projectId;
}

package com.cybersoft.demosrpingboot.model;

import com.cybersoft.demosrpingboot.model.keys.IdTask;
import jakarta.persistence.*;

@Entity(name = "task")
public class Task {
    @EmbeddedId
    private IdTask idTask;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private Users user;

    @ManyToOne
    @JoinColumn(name = "project_id", insertable = false, updatable = false)
    private Project project;
}

package com.cybersoft.demosrpingboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "project")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Project {
    @Id
    @Column(name = "id_project")
    private int id;
    @Column(name = "project_name")
    private String projectName;

    @OneToMany(mappedBy = "project")
    private List<Task> tasks;
}

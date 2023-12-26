package com.ltp.gradesubmission.entity;




import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;


@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "subject", nullable = false)
    private String subject;

    @NonNull
    @Column(name = "code", nullable = false)
    private String code;

    @NonNull
    @Column(name = "description", nullable = false)
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
    private List<Grade> grades;

}

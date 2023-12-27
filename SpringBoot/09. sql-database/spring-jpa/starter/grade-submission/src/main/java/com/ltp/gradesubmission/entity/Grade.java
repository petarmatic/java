package com.ltp.gradesubmission.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

@Entity
@Table(name ="grade", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"studentid", "course_id"})
} )
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="score", nullable =false)
    private String score;

    @ManyToOne(optional =false)
    @JoinColumn(name = "student_id",referencedColumnName = "id")
    private Student student;


    @ManyToOne(optional =false)
    @JoinColumn(name = "course_id",referencedColumnName = "id")
    private Course course;
    

}

package ca.uqtr.fitbit.entity;


import ca.uqtr.fitbit.entity.fitbit.ActivitiesCalories;
import ca.uqtr.fitbit.entity.fitbit.ActivitiesSteps;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.persistence.Version;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "patient_device", schema = "public")
public class PatientDevice implements Serializable {

    static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Version
    @Column(name = "version", nullable = false)
    private int version;
    @Column(name = "init_date", nullable = false)
    @Temporal(value = TemporalType.DATE)
    private Date initDate;
    @Column(name = "return_date", nullable = false)
    @Temporal(value = TemporalType.DATE)
    private Date returnDate;
    @Column(name = "professional_id", nullable = false)
    private UUID professionalId;
    @Column(name = "medical_file_id", nullable = false)
    private UUID medicalFileId;
    @Column(name = "returned_at", nullable = false)
    @Temporal(value = TemporalType.DATE)
    private Date returnedAt;
    @OneToMany
    @JoinColumn(name = "id")
    private List<ActivitiesCalories> activitiesCalories = new ArrayList<>();
    @OneToMany
    @JoinColumn(name = "id")
    private List<ActivitiesSteps> activitiesSteps = new ArrayList<>();
    //@ToString.Exclude
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private Device device;
}

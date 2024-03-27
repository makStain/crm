package sprint.project.crm.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "requests")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Requests {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username", length = 255)
    private String userName;

    @Column(name = "coursename", length = 255)
    private String courseName;

    @Column(name = "commentary")
    private String commentary;

    @Column(name = "phone", length = 100)
    private String phone;

    private boolean handled;
}

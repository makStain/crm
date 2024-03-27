package sprint.project.crm.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sprint.project.crm.model.Requests;

@Repository
@Transactional
public interface RequestRepository extends JpaRepository<Requests, Long> {
}

package tn.esprit.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.model.Role;

@Repository
public interface RolesRepository extends JpaRepository<Role,Long> {
    Role getRoleByRole(String role);


}

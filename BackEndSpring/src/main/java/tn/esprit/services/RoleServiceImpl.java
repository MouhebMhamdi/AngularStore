package tn.esprit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Repositories.RolesRepository;
import tn.esprit.model.Role;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RolesRepository rolesRepository;

    @Override
    public void addRoles(Role role) {

        if(rolesRepository.getRoleByRole(role.getRole())==null) rolesRepository.save(role);
    }

    @Override
    public Role getRoleByRole(String role) {
        return rolesRepository.getRoleByRole(role);
    }

    @Override
    public void deleteRole(String role) {
        Role ro=rolesRepository.getRoleByRole(role);
        if(ro!=null){
            rolesRepository.delete(ro);
        }else{
           System.out.println("Role n'existe pas ");
        }

    }

    @Override
    public List<Role> getAllRoles() {
        return rolesRepository.findAll();
    }
}

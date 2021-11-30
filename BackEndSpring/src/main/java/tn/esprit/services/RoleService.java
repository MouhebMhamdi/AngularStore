package tn.esprit.services;

import tn.esprit.model.Role;

import java.util.List;

public interface RoleService {
    void addRoles(Role role);
    Role getRoleByRole(String role);
    void deleteRole(String role) throws Exception;
    List<Role> getAllRoles();
}

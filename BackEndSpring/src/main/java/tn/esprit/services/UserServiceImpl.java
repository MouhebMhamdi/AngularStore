package tn.esprit.services;





import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tn.esprit.Repositories.UserRepository;
import tn.esprit.model.Role;
import tn.esprit.model.User;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Transactional
@RequiredArgsConstructor
@Slf4j

public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
    public UserRepository UserRepositorie;



    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private RoleServiceImpl roleService;

    public UserServiceImpl(UserRepository UserRepositorie) {
        this.UserRepositorie = UserRepositorie;
    }


    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
        final User user = this.getUserByEmail(email.toLowerCase());
        if (user == null) {
            throw new UsernameNotFoundException("Invalid Email or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(final Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList());
    }



    @Override
    public void ajouterUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        UserRepositorie.save(user);
    }

    @Override
    public Optional<User> chercherUserByID(long id) {
        return UserRepositorie.findById(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return UserRepositorie.getUserByEmail(email);
    }

    @Override
    public void supprimerUser(long id) {
        UserRepositorie.deleteById(id);
    }

    @Override
    public void supprimerToutLesUsers() {
        UserRepositorie.deleteAll();
    }

    @Override
    public List<User> chercherUser() {
        return UserRepositorie.findAll();
    }

    @Override

    public void updateUser(User user, long id) {

        User cl=UserRepositorie.findById(id).get();

        if(user.getDateNaissance()!=null)
        cl.setDateNaissance(user.getDateNaissance());

        if(user.getFactures()!=null)
        cl.setFactures(user.getFactures());

        if(user.getProffesion()!=null)

        cl.setProffesion(user.getProffesion());

        if(user.getPassword()!=null)
        cl.setPassword(passwordEncoder.encode(user.getPassword()));

        if(user.getEmail()!=null)
        cl.setEmail(user.getEmail());

        if(user.getCategorie()!=null)
            cl.setCategorie(user.getCategorie());


        UserRepositorie.save(cl);

    }

    @Override
    public User getUserByEmailAndPassword(String email, String Password) {
        return UserRepositorie.getUserByEmailAndPassword(email,Password);
    }



    @Override
    public void addRoleToUser(String email, String role) {
       User us= UserRepositorie.getUserByEmail(email);
       Role ro=roleService.getRoleByRole(role);
       us.getRoles().add(ro);
    }



}

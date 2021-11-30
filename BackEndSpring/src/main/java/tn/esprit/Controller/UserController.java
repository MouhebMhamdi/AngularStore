package tn.esprit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tn.esprit.Dto.UserDto;
import tn.esprit.model.PasswordResetToken;
import tn.esprit.model.Role;
import tn.esprit.model.User;
import tn.esprit.services.RoleServiceImpl;
import tn.esprit.services.UserServiceImpl;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import tn.esprit.services.passwordResetTokenServiceImpl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.time.Instant;
import java.util.*;

import tn.esprit.services.passwordResetTokenServiceImpl;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    RoleServiceImpl roleService;

    @Autowired
    public JavaMailSender emailSender;

    @Autowired
    private passwordResetTokenServiceImpl passworrResetToken;


    private MailSender mailSender;
    private SimpleMailMessage templateMessage;

    public UserController(UserServiceImpl userService){
        this.userService=userService;
    }
        @GetMapping("/getAllUsers")
    public List<User> getUsers(){
        return userService.chercherUser();
    }

    @DeleteMapping("/deleteUser/{id}")
    public List<User> deleteUser(@PathVariable(value="id") long id){
        userService.supprimerUser(id);
        return userService.chercherUser();
    }

        @PostMapping("/registerUser")
    public String RegisterUser(@RequestBody User user) throws Exception {
            Role role=new Role("USER");
            if(roleService.getRoleByRole("USER")==null) this.addRole(role);

            userService.ajouterUser(user);
        return "Hi "+ user.getNom()+" your registration process successfuly Don!!";
    }

    @GetMapping("/getUserByEmail/{email}")
    public User getUserByEmail(@PathVariable(value = "email") String email){

        return userService.getUserByEmail(email);
    }

    @PostMapping("/updateUser/{id}")
    public String UpdateUser(@RequestBody User user, @PathVariable long id){
        userService.updateUser(user,id);
        return "User updated successfuly Don !!";
    }

    @DeleteMapping("/DeleteAllUsers")
    public String DeleteAllUsers(){
        userService.supprimerToutLesUsers();
        return  "All Users deleted !";
    }

    @GetMapping ("/login")
    public User login(@RequestParam String email,@RequestParam String password) throws Exception {
        boolean isLogined=false;

        User us=userService.getUserByEmail(email);

        if(us!=null && passwordEncoder.matches(password,us.getPassword()) ){

                return   us;
           

        }else if(userService.getUserByEmail(email)!=null){
           throw new Exception("Password invalid");
        }else{
            throw new Exception("Email and password invalid");
        }



    }
    @GetMapping("/send")
    public PasswordResetToken send(@RequestParam String email)throws Exception{
        MimeMessage message = emailSender.createMimeMessage();
        boolean multipart = true;
        MimeMessageHelper helper;

        final String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
        String token = UUID.randomUUID().toString();
        try {
            User us=userService.getUserByEmail(email);
            if(us==null) throw new Exception("Invalid User");


            Date now = Date.from(Instant.now());
            List<PasswordResetToken> passwordResetToken=passworrResetToken.getAllTokenByUser(us);
            PasswordResetToken myToken = new PasswordResetToken();
            if(passwordResetToken.isEmpty()){

                myToken.setToken(token);
                myToken.setUser(us);
                myToken.setExpiryDate(now);

                passworrResetToken.saveToken(myToken);
            }else{
                for(PasswordResetToken l:passwordResetToken) {
                    l.setToken(token);
                    l.setExpiryDate(now);
                    passworrResetToken.saveToken(l);
                }
            }


            //email send *************************************
            helper = new MimeMessageHelper(message, multipart, "utf-8");
            message.setContent("http://localhost:4200/newPassword", "text/html");
            helper.setTo(us.getEmail());
            helper.setSubject("Reset Password");
            emailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return passworrResetToken.getToken(token);
    }
    @GetMapping("newPassword")
    public String newPasswordTestToken(@RequestParam String token) throws Exception{
        PasswordResetToken passwordResetToken=passworrResetToken.getToken(token);
        if(passwordResetToken!=null && isTokenExpired(passwordResetToken)){
            return "Tokin Valid thanks";
        }

        throw new Exception("token invalid");
    }
    private boolean isTokenExpired(PasswordResetToken passToken) {
        final Calendar cal = Calendar.getInstance();
        Date date=passToken.getExpiryDate();
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date);
        cal1.add(Calendar.MINUTE, 5);
        return cal.getTime().before(cal1.getTime());
    }

    @GetMapping("changePassword")
    public String newpass(@RequestParam("token") String token,@RequestParam("password") String password) throws Exception{
        MimeMessage message = emailSender.createMimeMessage();
        boolean multipart = true;
        MimeMessageHelper helper;

        final String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();

        PasswordResetToken passwordResetTokens=passworrResetToken.getToken(token);
         if(passwordResetTokens==null) throw new  Exception("Token Not found");

         User us=passwordResetTokens.getUser();
         if(us==null) throw new Exception("user invalid");
         User user=new User();
         user.setPassword(password);
         userService.updateUser(user,us.getIdClient());

        helper = new MimeMessageHelper(message, multipart, "utf-8");
        message.setContent("Your password AppStore has been changed", "text/html");
        helper.setTo(us.getEmail());
        helper.setSubject("Password Changed");
        emailSender.send(message);


        return "password modified";
    }
    @PostMapping("/addRole")
    public String addRole(@RequestBody Role role){

        role.setRole(role.getRole().toUpperCase());
        roleService.addRoles(role);

        return  "Role Added succesfully don !";
    }

    @DeleteMapping("/deleteRole/{role}")
    public String DeleteRole(@PathVariable String role){
        roleService.deleteRole(role);
        return "role deleted !!";
    }

    @GetMapping("/getAllRoles")
    public List<Role> getAllroles(){
        return roleService.getAllRoles();
    }


    @GetMapping("/addRoleToUser/{email}/{role}")
    public String addRoleToUser(@PathVariable String role, @PathVariable String email) throws Exception{



        Role ro= roleService.getRoleByRole(role.toUpperCase());
        if(ro!=null){
            User user=userService.getUserByEmail(email);
            if(user!=null){
                if(user.getRoles()!=null){user.getRoles().clear();}
                user.getRoles().add(ro);
                userService.updateUser(user,user.getIdClient());
            }else
            {
                return "email introuvable";
            }
        }else {
            throw new Exception("Role introuvable !!");
        }
        return "Role add successfully !!";
    }
    public String addRoleToUserMethod(String role, String email) throws Exception{



        Role ro= roleService.getRoleByRole(role.toUpperCase());
        if(ro!=null){
            User user=userService.getUserByEmail(email);
            if(user!=null){

                user.getRoles().add(ro);
                userService.updateUser(user,user.getIdClient());
            }else
            {
                return "email introuvable";
            }
        }else {
            throw new Exception("Role introuvable !!");
        }
        return "Role add successfully !!";
    }

}

package tn.esprit.Dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class contactUs {
  private String name;
  private String subject;
  private String email;
  private String phone;
  private String message;
}

package practicajrg.t4_p2.Entities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Usuario{

    private Long id;

    private String name;
    private String password;
    private String roles;

}

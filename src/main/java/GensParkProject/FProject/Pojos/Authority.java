package GensParkProject.FProject.Pojos;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Table(name = "AUTH_AUTHORITY")
@Entity
public class Authority implements GrantedAuthority {



    @Id
    @GeneratedValue
   private Long id;
    @Column(name = "ROLE_CODE")
    private String roleCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    @Column(name ="ROLE_DESCRIPTION")
   private String roleDescription;

    @Override
    public String getAuthority() {
        return roleCode;
    }
}

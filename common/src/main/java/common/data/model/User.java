package common.data.model;

import common.data.model.converter.UserProfileConverter;
import common.data.model.lcp.UserProfile;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import javax.persistence.*;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SahakBabayan on 6/21/2017.
 */
@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "profile_id")
    @Convert(converter = UserProfileConverter.class)
    private UserProfile profile;

    @NotEmpty(message = "{err.field.first.name.required}")
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty(message = "{err.field.last.name.required}")
    @Column(name = "last_name")
    private String lastName;

    @Email(message = "{err.field.email.invalid}")
    @NotEmpty(message = "{err.field.email.required}")
    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
    private List<OrderTable> tables = new ArrayList<>(0);

    public List<OrderTable> getTables() {
        return this.tables;
    }

    public void setTables(List<OrderTable> tables) {
        this.tables = tables;
    }

    public User() {}

    public User(User user) {
        this.profile = user.profile;
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.email = user.email;
        this.password = user.password;
        this.tables = user.tables;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserProfile getProfile() {
        return profile;
    }

    public void setProfile(UserProfile profile) {
        this.profile = profile;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}

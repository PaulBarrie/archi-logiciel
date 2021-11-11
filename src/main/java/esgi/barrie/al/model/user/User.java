package esgi.barrie.cc1.model.user;

import esgi.barrie.cc1.model.validators.user.UserValidator;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class User {
    @SerializedName("ID")
    private String id;
    @SerializedName("Firstname")
    private String firstName;
    @SerializedName("Lastname")
    private String lastName;
    @SerializedName("Birth")
    private String birth;
    @SerializedName("Email")
    private String email;
    @SerializedName("Credentials")
    private Credentials credentials;
    @SerializedName("Phone")
    private Phone phone;
    @SerializedName("Address")
    private Address address;

    private User(String firstName, String lastName, String birth, String email, Credentials credentials, Phone phone, Address address) {
        this.id = UUID.randomUUID().toString();
        this.firstName = Objects.requireNonNull(firstName);
        this.lastName = Objects.requireNonNull(lastName);
        this.birth = Objects.requireNonNull(birth);
        this.email = Objects.requireNonNull(email);
        this.credentials = Objects.requireNonNull(credentials);
        this.phone = Objects.requireNonNull(phone);
        this.address = address;
    }

    public static User of(String firstName, String lastName, String birth, String email,Credentials credentials, Phone phone, Address address) {
        User user = new User(firstName, lastName, birth, email, credentials, phone, address);
        UserValidator.of(user).check();
        return user;
    }

    public static User nullUser() {
        return new User(null, null, null, null, Credentials.nullCredentials(), Phone.nullPhone(), Address.nullAddress());
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirth() {
        return birth;
    }

    public String getEmail() {
        return email;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public Phone getPhone() {
        return phone;
    }

    public Optional<Address> getAddress() {
        return Optional.ofNullable(address);
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

package com.unla.pedidosya.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long idUser;

    @Column(name = "nombre",length = 100,nullable = false)
    @NotBlank
    private String nombre;

    @Column(name = "apellido",length = 100,nullable = false)
    @NotBlank
    private String apellido;

    @Column(name = "direccion",length = 100,nullable = false)
    @NotBlank
    private String direccion;

    @Column(name = "ciudad",length = 100,nullable = false)
    @NotBlank
    private String ciudad;

    @Column(name = "username",length = 100,nullable = false)
    @NotBlank
    private String username;

    @Column(name = "password",length = 128,nullable = false)
    @NotBlank
    @NotNull
    private String password;

    @Column(name = "enabled")
    private boolean enabled;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
        name = "user_roles",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Roles> roles = new HashSet<>();

    public User(){}

    public User(@NotBlank String nombre, @NotBlank String apellido, @NotBlank String direccion, @NotBlank String ciudad,
            @NotBlank String username, @NotBlank @NotNull String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.username = username;
        this.password = password;
        this.enabled = true;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User [apellido=" + apellido + ", ciudad=" + ciudad + ", direccion=" + direccion + ", enabled=" + enabled
                + ", nombre=" + nombre + ", password=" + password + ", username=" + username + "]";
    }
    
}

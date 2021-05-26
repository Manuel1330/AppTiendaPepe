package com.example.apptiendapepe.Datos;

public class Usuarios {

    private String personName;
    private String personGivenName;
    private String personFamilyName;
    private String personEmail;
    private String personId;
    private String personPhoto;

    private String personNombreUsuario;
    private String personLugarEntrega;
    private String personTelefono;
    private String personObservaciones;
    private String personFechaNacimiento;
    private String personAux1;
    private Double personAux2;

    private String personUltimoPedido;
    private Double personSaldo;

    private String bloqueado;


    public Usuarios() {}

    public Usuarios(String personName, String personGivenName, String personFamilyName, String personEmail,
                    String personId, String personPhoto, String personNombreUsuario, String personLugarEntrega,
                    String personTelefono, String personObservaciones, String personFechaNacimiento,
                    String personAux1, Double personAux2, String personUltimoPedido, Double personSaldo, String bloqueado) {
        this.personName = personName;
        this.personGivenName = personGivenName;
        this.personFamilyName = personFamilyName;
        this.personEmail = personEmail;
        this.personId = personId;
        this.personPhoto = personPhoto;
        this.personNombreUsuario = personNombreUsuario;
        this.personLugarEntrega = personLugarEntrega;
        this.personTelefono = personTelefono;
        this.personObservaciones = personObservaciones;
        this.personFechaNacimiento = personFechaNacimiento;
        this.personAux1 = personAux1;
        this.personAux2 = personAux2;
        this.personUltimoPedido = personUltimoPedido;
        this.personSaldo = personSaldo;
        this.bloqueado = bloqueado;
    }

    public String getPersonName() { return personName; }
    public void setPersonName(String personName) { this.personName = personName; }

    public String getPersonGivenName() { return personGivenName; }
    public void setPersonGivenName(String personGivenName) { this.personGivenName = personGivenName; }

    public String getPersonFamilyName() { return personFamilyName; }
    public void setPersonFamilyName(String personFamilyName) { this.personFamilyName = personFamilyName; }

    public String getPersonEmail() { return personEmail; }
    public void setPersonEmail(String personEmail) { this.personEmail = personEmail; }

    public String getPersonId() { return personId; }
    public void setPersonId(String personId) { this.personId = personId; }

    public String getPersonPhoto() { return personPhoto; }
    public void setPersonPhoto(String personPhoto) { this.personPhoto = personPhoto; }

    public String getPersonNombreUsuario() { return personNombreUsuario; }
    public void setPersonNombreUsuario(String personNombreUsuario) { this.personNombreUsuario = personNombreUsuario; }

    public String getPersonLugarEntrega() { return personLugarEntrega; }
    public void setPersonLugarEntrega(String personLugarEntrega) { this.personLugarEntrega = personLugarEntrega; }

    public String getPersonTelefono() { return personTelefono; }
    public void setPersonTelefono(String personTelefono) { this.personTelefono = personTelefono; }

    public String getPersonObservaciones() { return personObservaciones; }
    public void setPersonObservaciones(String personObservaciones) { this.personObservaciones = personObservaciones; }

    public String getPersonFechaNacimiento() { return personFechaNacimiento; }
    public void setPersonFechaNacimiento(String personFechaNacimiento) { this.personFechaNacimiento = personFechaNacimiento; }

    public String getPersonAux1() { return personAux1; }
    public void setPersonAux1(String personAux1) { this.personAux1 = personAux1; }

    public Double getPersonAux2() { return personAux2; }
    public void setPersonAux2(Double personAux2) { this.personAux2 = personAux2; }

    public String getPersonUltimoPedido() { return personUltimoPedido; }
    public void setPersonUltimoPedido(String personUltimoPedido) { this.personUltimoPedido = personUltimoPedido; }

    public Double getPersonSaldo() { return personSaldo; }
    public void setPersonSaldo(Double personSaldo) { this.personSaldo = personSaldo; }

    public String getBloqueado() { return bloqueado; }
    public void setBloqueado(String bloqueado) { this.bloqueado = bloqueado; }

}

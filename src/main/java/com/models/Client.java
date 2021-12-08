package com.models;

public class Client extends Person {
    private String numeroBadge;
    private String nomEntreprise;
    private String dateDebut;
    private boolean identite;

    public String getDateDebut() {
        return dateDebut;
    }

    public boolean isIdentite() {
		return identite;
	}

	public void setIdentite(boolean identite) {
		this.identite = identite;
	}

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Client(String firstname, String lastname,String email, String phone, String address,String cin, String numeroBadge,String nomEntreprise, String dateDebut, boolean identite) {
		super(firstname, lastname,email,phone, address,cin);
		this.setNumeroBadge(numeroBadge);
		this.setNomEntreprise(nomEntreprise);
		this.setDateDebut(dateDebut);
		this.setIdentite(identite);
		// TODO Auto-generated constructor stub
	}

	public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getNomEntreprise() {
        return nomEntreprise;
    }

    public void setNomEntreprise(String nomEntreprise) {
        this.nomEntreprise = nomEntreprise;
    }

    @Override
	public String toString() {
		return "Client [firstname="+getFirstname()+",lastname="+getLastname()+",email="+getEmail()+",phone="+getPhone()+",cin="+getCin()+",numeroBadge=" + numeroBadge + ", nomEntreprise=" + nomEntreprise + ", dateDebut=" + dateDebut
				+ "]";
	}

	public String getNumeroBadge() {
        return numeroBadge;
    }

    public void setNumeroBadge(String numeroBadge) {
        this.numeroBadge = numeroBadge;
    }
}

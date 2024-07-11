package com.example.demo.DTO;
import java.sql.Date;
import com.example.demo.entities.Utilisateur;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemandeRequestDto {

	private int id;
	private Date date_demande;
	private String objet_demande;
	private String configuration;
	private String etat_demande;
	
	private  Utilisateur utilisateur;
}

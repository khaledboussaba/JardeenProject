package fr.afcepf.ai105.p3.g1.appjardeen.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import fr.afcepf.ai105.p3.g1.appjardeen.business.AciditeBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.business.EmplacementBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.business.HumiditeSolBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.business.ParcelleBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.business.TacheBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.business.TerrainBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.business.TypeSolBusiness;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Acidite;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Emplacement;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.HumiditeSol;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Parcelle;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Tache;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.Terrain;
import fr.afcepf.ai105.p3.g1.appjardeen.entities.TypeSol;

@ManagedBean(name = "mbParcelle")
@ViewScoped
public class ParcelleManagedBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="#{mbListeTerrain.terrainSelected}")
	private Terrain terrain;
	private Parcelle parcelle;
	private static int numLigne;
	private static int numColonne;
	private static int NB_MAX=18;

	private String msgInfoActionGrilleJS;
	private String etatMsgInfoGrilleJS;
	private String msgInfoActionTableau;
	private String etatMsgInfoTableau;

	private String emplacementsSelectionneesFromJS="";
	private String[] listesEmplacementsFromJS;
	
	private List<TypeSol> listeTypeSol;
	private List<Acidite> listeAcidite;
	private List<HumiditeSol> listeHumiditeSol;
	private List<Emplacement> listeEmplacementsNonRetires;
	private List<Parcelle> listeParcellesNonRetirees;
	private List<Tache> listeTachesPlanifiees;
	private List<Parcelle> listeParcellesRetirees;

	@EJB 
	TypeSolBusiness proxyTypeSolBusiness; 
	@EJB 
	AciditeBusiness proxyAciditeBusiness;	
	@EJB 
	HumiditeSolBusiness proxyHumiditeSolBusiness;
	@EJB 
	ParcelleBusiness proxyParcelleBusiness;
	@EJB 
	TerrainBusiness proxyTerrainBusiness;
	@EJB 
	TacheBusiness proxyTacheBusiness;
	@EJB 
	EmplacementBusiness proxyEmplacementBusiness;
	
	@PostConstruct
	public void init() {
		numColonne=0;
		numLigne=1;
		listeTypeSol = proxyTypeSolBusiness.obtenirTousLesTypesSol();
		listeAcidite = proxyAciditeBusiness.obtenirTousLesAcidites();
		listeHumiditeSol = proxyHumiditeSolBusiness.obtenirTousLesHumiditeSol();
		// terrain = proxyTerrainBusiness.obtenirTerrainById(1);
		listeParcellesNonRetirees= proxyParcelleBusiness.listerParcellesTerrain(terrain);
		listeEmplacementsNonRetires = proxyEmplacementBusiness.obtenirTousLesEmplacementsDontLesParcellesSontNonRetirerByTerrain(terrain);      
		listeParcellesRetirees = proxyParcelleBusiness.obtenirToutesLesParcellesRetireesByTerrain(terrain);
		
		//TODO : Gerer si une tache est en cours (suppression et fusion) 
		listeTachesPlanifiees = proxyTacheBusiness.obtenirLesTachesPlanifees();
	
		parcelle= new Parcelle();	
	}
	
	public void creerParcelle() {

		List<Emplacement> emplacements = new ArrayList<Emplacement>();
		listesEmplacementsFromJS = emplacementsSelectionneesFromJS.split("-");
		boolean isEmpty = false ;
		boolean isAlreadyInParcelle = false ;
		
		//Création d'une liste de tous les emplacements selectionnées 
		for (String emplacement : listesEmplacementsFromJS) {
			System.out.println("===== Creer Parcelle emplacement : "+emplacement);
			if(isEmpty(emplacement)) {
				isEmpty = true;
			}else {
				String[] emplacementDetails= emplacement.split("_");
				int numLigne = Integer.parseInt(emplacementDetails[0]);
				int numColonne = Integer.parseInt(emplacementDetails[1]);
				
				//On verifie que les emplacements ne sont pas déja affectés
				if(!listeEmplacementsNonRetires.contains(new Emplacement(numLigne, numColonne, parcelle))) {					
					emplacements.add(new Emplacement(numLigne, numColonne, parcelle));
				}else {
					isAlreadyInParcelle=true;
				}
			}
		}
		
//		//Verification que tous les emplacements sont contingus
//		if(listeEmplacementsIsContigus(emplacements)) {
			System.out.println("Création d'une parcelle -> tous les emplacements sont contingu ");
			
			//On vérifie qu'il n'y a pas un emplacement deja affecté avant de créer la parcelle 
			if(!isEmpty&&!isAlreadyInParcelle) {
				parcelle.setDateCreationParcelle(new Date());
				parcelle.setTerrain(terrain);
				parcelle.setEmplacements(emplacements);
				proxyParcelleBusiness.creerParcelle(parcelle);
				
				msgInfoActionGrilleJS="La parcelle '"+parcelle.getLibelleParcelle()+"' a bien été créé !";
				etatMsgInfoGrilleJS="color:green;";
			}else {
				// Il y a un probleme sur les emplacements selectionnés 
				if(isEmpty) {
					msgInfoActionGrilleJS="Erreur: la sélection des emplacements a échoué  ! ( W.Lepante ? ¯\\_(ツ)_/¯ )";
				}else {
					msgInfoActionGrilleJS="Erreur: les emplacements sont déjà affectées ! ";
				}
				etatMsgInfoGrilleJS="color:red;";
			}
//		}else{
//			// les emplacements selectionnés sont pas contingus  
//			System.out.println("Création d'une parcelle -> tous les emplacements NE sont PAS contingu ");
//
//			msgInfoActionGrilleJS="Erreur: la liste des emplacements n'est pas contigue  !";
//			etatMsgInfoGrilleJS="color:red;";
//		}
		
		this.clearForm();
		parcelle = new Parcelle();
	}
	public boolean isParcellesContigues(Parcelle p1, Parcelle p2) {	
		List<Emplacement> emplacementP1 = obtenirListeEmplacementByParcelle(p1);
		List<Emplacement> emplacementP2 = obtenirListeEmplacementByParcelle(p2);

		return deuxListesEmplacementsIsContigus(emplacementP1, emplacementP2);
	}
	

// A Supprimer ? 
//	public boolean listeEmplacementsIsContigus(List<Emplacement> emplacements) {
//		boolean emplacementContigu=false;
//		boolean listeEmplacementContigu=true;
//
//		int i=0,j=1;
//		if(emplacements.size()>0) {
//			do {
//				do {
//					if(isEmplacementContigues(emplacements.get(i),emplacements.get(j))) {
//						emplacementContigu=true;
//					}
//					j++;
//				}while(!emplacementContigu&&(j<emplacements.size()));
//				if(!emplacementContigu) {
//					listeEmplacementContigu=false;
//				}
//				i++;
//				j=0;
//			}while(listeEmplacementContigu && (i<emplacements.size()-1));
//		}
//
//		return listeEmplacementContigu;
//	}

	// Gere la fusion de deux parcelles 
	public boolean deuxListesEmplacementsIsContigus(List<Emplacement> e1, List<Emplacement> e2) {
		boolean emplacementContigu = false;
		int i = 0, j = 1;

		do {
			do {
				if (isEmplacementContigues(e2.get(j), e1.get(i))) {
					emplacementContigu = true;
				} 
				j++;
			} while (!emplacementContigu && (j < e2.size()));
			i++;
			j = 0;
		}while (!emplacementContigu && (i < e1.size() - 1));
		return emplacementContigu;
	}
	
	// OK 
	public boolean isEmplacementContigues(Emplacement e1, Emplacement e2) {
		boolean contigues= false;
		if(((e1.getNumLigne()==e2.getNumLigne())&&(((e1.getNumColonne()-e2.getNumColonne())==1)||(e1.getNumColonne()-e2.getNumColonne())==-1))
			||((e1.getNumColonne()==e2.getNumColonne())&&(((e1.getNumLigne()-e2.getNumLigne())==1)||(e1.getNumLigne()-e2.getNumLigne())==-1))) {
			contigues= true;
		}
		
		return contigues;
	}
	
	//GERER LES PARCELLES POSSEDANT DES TACHES PLANIFIEES
	//GERER LE CAS OU ON SUPPRIME PLUSIEUR PARCELLE DONT UNE QUI NE PEUT PAS ETRE SUPPRIMER 
	public void supprimerParcelle() {
		boolean isEmpty=false;
		int nbParcelleSup=0;
		List<String> nomParcellesNonSupprimees = new ArrayList<>();
		List<String> nomParcellesSupprimees = new ArrayList<>();

		for (String emplacement : emplacementsSelectionneesFromJS.split("-")) {
			nbParcelleSup++;

			if (!isEmpty(emplacement)){
				String[] refEmplacement= emplacement.split("_");
				int numLigne = Integer.parseInt(refEmplacement[0]);
				int numColonne = Integer.parseInt(refEmplacement[1]);
				Emplacement e = obtenirEmplacement(numLigne,numColonne);

				if(e != null && notHaveTachePlanified(parcelle).equals("true") ) {
					// Suppression de la parcelle 
					this.parcelle = e.getParcelle();
					affecterDateRetraitPuisMAJParcelleEnBase(parcelle);
					nomParcellesSupprimees.add(parcelle.getLibelleParcelle());
					System.out.println("Supprimer Parcelle  OK ");
				}else {
					nomParcellesNonSupprimees.add(parcelle.getLibelleParcelle());
				}
			}else {
				//Probleme de selection d'emplacement
				isEmpty=true;
			}
		}

		if(isEmpty&&nbParcelleSup==1) {
			msgInfoActionGrilleJS="Erreur : La selection ne correspond à aucune parcelle !";
			etatMsgInfoGrilleJS="color:red;";
			System.out.println("Supprimer Parcelle  KO : L'emplacement selectionnee n'est pas affecté à une parcelle ");
		}else {
			if(nbParcelleSup>1) {
				String listeLibelleParcellesSupprimees="";
				String listeLibelleParcellesNonSupprimees="";

				for (String string : nomParcellesSupprimees) {
					listeLibelleParcellesSupprimees+=string+", ";
				}
				for (String string : nomParcellesNonSupprimees) {
					listeLibelleParcellesNonSupprimees+=string+", ";
				}
				if(listeLibelleParcellesSupprimees.length()>0) {
					int i = listeLibelleParcellesSupprimees.length()-2;
					msgInfoActionGrilleJS="Les parcelles ' "+listeLibelleParcellesSupprimees.substring(0, i)+" ' ont bien été retirées !";
				}
				if(listeLibelleParcellesNonSupprimees.length()>0) {
					int j = listeLibelleParcellesNonSupprimees.length()-2;

					msgInfoActionGrilleJS="\n Attention : Les parcelles ' "+listeLibelleParcellesNonSupprimees.substring(0, j)+" ' n'ont pas pu être supprimées (Taches en cours ou emplamcement vide)!";
				}

			}else {
				msgInfoActionGrilleJS="La parcelle '"+parcelle.getLibelleParcelle()+"'a bien été retirée !";
			}
			etatMsgInfoGrilleJS="color:green;";
		}
		this.clearForm();
	}
	
	public void affecterDateRetraitPuisMAJParcelleEnBase(Parcelle p) {
			p.setDateRetraitParcelle(new Date());
			proxyParcelleBusiness.modifierParcelle(p);
	}
	public void retirerParcelle(Parcelle p) {
		if(notHaveTachePlanified(parcelle).equals("true")) {
			affecterDateRetraitPuisMAJParcelleEnBase(p); 
			msgInfoActionGrilleJS="La parcelle '"+p.getLibelleParcelle()+"' a été retiré !";;
			etatMsgInfoGrilleJS = "color: green;";
		}else {
			msgInfoActionGrilleJS="La parcelle '"+p.getLibelleParcelle()+"' n'est pas libre (des taches y sont prévues)  !";;
			etatMsgInfoGrilleJS = "color:red;";
		}
}
	public void supprimerDefinitivementParcelle(Parcelle p) {
		proxyParcelleBusiness.supprimerDefinitivementParcelle(p);
		msgInfoActionGrilleJS="La parcelle '"+p.getLibelleParcelle()+"' a bien été supprimeée de la base de données !";;
		etatMsgInfoGrilleJS = "color: green;";
	}
	
	//permet de remettre d'actualité une parcelle anciennement retirée (prise en compte des emplacements disponibles)
	public void rajouterParcelle(Parcelle p) {
		List<Emplacement> emplacementsParcelle = proxyEmplacementBusiness.obtenirListeEmplacementByParcelle(p);
		boolean emplacementsDispo=true;
		int i=0;

		do {
			if(listeEmplacementsNonRetires.contains(emplacementsParcelle.get(i))) {
				emplacementsDispo = false;
			}
			i++;
		}while(emplacementsDispo&&i<emplacementsParcelle.size());
		
		if(emplacementsDispo) {
			p.setDateRetraitParcelle(null);
			proxyParcelleBusiness.modifierParcelle(p);
			msgInfoActionGrilleJS="La parcelle '"+p.getLibelleParcelle()+"' a bien été rajouté !";;
			etatMsgInfoGrilleJS = "color:green;";

		}else {
			msgInfoActionGrilleJS="Erreur lors du rajout de la parcelle: au moins un emplacement n'est pas disponible !";;
			etatMsgInfoGrilleJS = "color:red;";
		}
	}
	
	
	
	public void fusionnerParcelles() {
		String[] emplacementSelectionePremiereParcelle = emplacementsSelectionneesFromJS.split("-")[0].split("_");
		String[] emplacementSelectioneDeuxiemeParcelle = emplacementsSelectionneesFromJS.split("-")[1].split("_");
		
		
		int numLignePremiereParcelle = Integer.parseInt(emplacementSelectionePremiereParcelle[0]);
		int numColonnePremiereParcelle = Integer.parseInt(emplacementSelectionePremiereParcelle[1]);
		
		int numLigneDeuxiemeParcelle = Integer.parseInt(emplacementSelectioneDeuxiemeParcelle[0]);
		int numColonneDeuxiemeParcelle = Integer.parseInt(emplacementSelectioneDeuxiemeParcelle[1]);
		System.out.println("______ FUSION_____ emplacement 1 : [" +numLignePremiereParcelle+", "+numColonnePremiereParcelle+"]");
		System.out.println("______ FUSION_____ emplacement 2 : [" +numLigneDeuxiemeParcelle+", "+numColonneDeuxiemeParcelle+"]");

		
		Parcelle premiereParcelle = obtenirEmplacement(numLignePremiereParcelle, numColonnePremiereParcelle).getParcelle();
		System.out.println("Parcelle 1 : "+premiereParcelle.getLibelleParcelle());
		Parcelle deuxiemeParcelle = obtenirEmplacement(numLigneDeuxiemeParcelle, numColonneDeuxiemeParcelle).getParcelle();
		System.out.println("Parcelle 2 : "+deuxiemeParcelle.getLibelleParcelle());

		if(isParcellesContigues(premiereParcelle, deuxiemeParcelle)) {
			//On fusionne les deux parcelles 
			List<Emplacement> emplacements = new ArrayList<Emplacement>();
			//emplacements.addAll(premiereParcelle.getEmplacements());
			//emplacements.addAll(deuxiemeParcelle.getEmplacements());
			for (Emplacement emplacement : this.listeEmplacementsNonRetires) {
				if(emplacement.getParcelle().equals(premiereParcelle)||emplacement.getParcelle().equals(deuxiemeParcelle)) {
					Emplacement e = new Emplacement(emplacement.getNumLigne(),emplacement.getNumColonne(),parcelle);
					emplacements.add(e);
					System.out.println("Fusion emplacement : "+e.toString());
				}
			}
			parcelle.setDateCreationParcelle(new Date());
			System.out.println("______ FUSION_____ terrain :"+terrain.getLibelleTerrain());
			parcelle.setTerrain(terrain);
			parcelle.setEmplacements(emplacements);
			
			//TODO ERREUR : ICI NULL POINTER EXCEPTION sur la parcelle 
			proxyParcelleBusiness.creerParcelle(parcelle);
			
			//On retire les deux anciennes parcelles
			premiereParcelle.setDateRetraitParcelle(new Date());
			deuxiemeParcelle.setDateRetraitParcelle(new Date());
			proxyParcelleBusiness.modifierParcelle(premiereParcelle);
			proxyParcelleBusiness.modifierParcelle(deuxiemeParcelle);
			
			msgInfoActionGrilleJS="La fusion a bien été prise en compte !";
			etatMsgInfoGrilleJS="color:green;";
			System.out.println("______ FUSION_____ OOOKKK");
		}else {
			//On renvoi un msg d'erreur 
			msgInfoActionGrilleJS="Erreur : les parcelles sont-elles contigües ?";
			etatMsgInfoGrilleJS="color:red;";
			System.out.println("______ FUSION_____ KKKOOO");
		}
				
		this.clearForm();
		
	}
	
	boolean isEmpty(String s) {
		return (s=="" || s==" "||s.isEmpty());
	}
	
	public String estOccupee() {
		String returned="";
		Emplacement e = new Emplacement(numLigne, numColonne);
		
		if(listeEmplacementsNonRetires.contains(e)) {
			returned="occupee";
		}

		return returned;
	}
	
	public String obtenirLibelleParcelle() {
		String returned="";
		Emplacement e = new Emplacement(numLigne, numColonne);
		boolean found =false;
		int i=0;
		
		while(!found&&i<listeEmplacementsNonRetires.size()) {
			if(listeEmplacementsNonRetires.get(i).equals(e)){
				e=listeEmplacementsNonRetires.get(i);
				found = true;
			}
			i++;
		}

		if(found) {
			returned =e.getParcelle().getLibelleParcelle();
		}else {
			returned = "emplacement disponible";
		}
		return  returned;
	}
	
	public String obtenirIdDiv() {
		if(numColonne<NB_MAX) {
			numColonne++;
		}else {
			numLigne++;
			numColonne=1;
		}
		return numLigne+"_"+numColonne;
	}
	
	public String obtenirCouleurEmplacement() {
		String couleur="";
		if(estOccupee()!="") {
			couleur = obtenirEmplacement(-1,-1).getParcelle().getCouleurParcelle();
			couleur = "background-color:"+couleur+";";
		}
		return couleur;
	}
	
	
	public Emplacement obtenirEmplacement(int numeroLigne, int numeroColonne) {
		boolean emplacementFound=false;
		int j=0;
		Emplacement eReturn = null;

		//Gere si c'est l'emplacement en cours (ou non cad -1)
		numeroLigne = (numeroLigne<0) ? ParcelleManagedBean.numLigne : numeroLigne;
		numeroColonne = (numeroColonne<0) ? ParcelleManagedBean.numColonne : numeroColonne;
				
		do{
			Emplacement e = listeEmplacementsNonRetires.get(j);
			if(e.getNumColonne()==numeroColonne&& e.getNumLigne()==numeroLigne) {
				emplacementFound=true;
				eReturn = e;
			}
			j++;
		}while(!emplacementFound&&j<listeEmplacementsNonRetires.size());

		return eReturn;
	}
	
	public List<Emplacement>  obtenirListeEmplacementByParcelle(Parcelle p){
		List<Emplacement> emplacements = new ArrayList<Emplacement>();
		for (Emplacement e : this.listeEmplacementsNonRetires) {
			if(e.getParcelle().getIdParcelle()== p.getIdParcelle()) {
				emplacements.add(e);
			}
		}
		return emplacements;
		
	}
	
	public void clearForm() {
		parcelle.setAcidite(null);
		parcelle.setCouleurParcelle(null);
		parcelle.setDateCreationParcelle(null);
		parcelle.setEmplacements(null);
		parcelle.setHumiditeSol(null);
		parcelle.setLibelleParcelle(null);
		parcelle.setTypeSol(null);
		numLigne=1;
		numColonne=0;
	}
	
	

	
	//TODO VERIFIER CETTE FONCTION 
	public String notHaveTachePlanified(Parcelle p) {
		boolean hasTachePlanified=false;
		int i=0;
	//	System.out.println(" ========> notHaveTachePlanified libelle parcelle (parcelle): "+p.getLibelleParcelle());

//		for (Tache tache : listeTachesPlanifiees) {
	//		System.out.println(" ========> notHaveTachePlanified libelle parcelle (tachePlanifiees) : "+tache.getParcelle().getLibelleParcelle());
//		}
		
		do {
			if(listeTachesPlanifiees.get(i).getParcelle().equals(p)) {
				hasTachePlanified = true; 
			}
			i++;
		}while(!hasTachePlanified && i<listeTachesPlanifiees.size());
		
		return hasTachePlanified ? "false": "true";
	}

	
	//BIZARRE JAMAIS D ORANGE 
	public String etatParcelle(Parcelle p) {
		String etat=""; 
//		System.out.println("-------- Etat parcelle  "+p.getLibelleParcelle());

		if(p.getDateRetraitParcelle()!=null){
//			System.out.println("-------- Etat Parcelle (RED) dateRetrait : "+p.getDateRetraitParcelle());
			etat = "red";
		}else if (notHaveTachePlanified(p).equals("true")) {
//			System.out.println("-------- Etat parcelle GREEN ");

			etat = "green";
		}else {
//			System.out.println("-------- Etat parcelle ORANGE ");

			etat = "orange";
		}
		return etat;
	}
	
	public String libelleEtatParcelle(Parcelle p) {
		String s = etatParcelle(p);
		String retuned="";
		switch(s) {
		case "red" : 
			retuned="Parcelle retirée";
			break;
		case "green" : 
			retuned="Parcelle Libre (aucune tache prévue)";
			break;		
		case "orange" :
			retuned="Parcelle occupée (des tâches y sont prévues)";
			break;	
		default : 
			break;
		}
		return retuned;
		
	}
	
	public Terrain getTerrain() {
		return terrain;
	}
	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}

	public static int getNumLigne() {
		return numLigne;
	}

	public static void setNumLigne(int numLigne) {
		ParcelleManagedBean.numLigne = numLigne;
	}

	public static int getNumColonne() {
		return numColonne;
	}

	public static void setNumColonne(int numColonne) {
		ParcelleManagedBean.numColonne = numColonne;
	}



	public String getEmplacementsSelectionneesFromJS() {
		return emplacementsSelectionneesFromJS;
	}

	public void setEmplacementsSelectionneesFromJS(String emplacementsSelectionneesFromJS) {
		this.emplacementsSelectionneesFromJS = emplacementsSelectionneesFromJS;
	}

	public String[] getListesEmplacements() {
		return listesEmplacementsFromJS;
	}

	public void setListesEmplacements(String[] listesEmplacements) {
		this.listesEmplacementsFromJS = listesEmplacements;
	}

	public Parcelle getParcelle() {
		return parcelle;
	}

	public void setParcelle(Parcelle parcelle) {
		this.parcelle = parcelle;
	}

	public List<TypeSol> getListeTypeSol() {
		return listeTypeSol;
	}

	public void setListeTypeSol(List<TypeSol> listeTypeSol) {
		this.listeTypeSol = listeTypeSol;
	}

	public List<Acidite> getListeAcidite() {
		return listeAcidite;
	}

	public void setListeAcidite(List<Acidite> listeAcidite) {
		this.listeAcidite = listeAcidite;
	}

	public List<HumiditeSol> getListeHumiditeSol() {
		return listeHumiditeSol;
	}

	public void setListeHumiditeSol(List<HumiditeSol> listeHumiditeSol) {
		this.listeHumiditeSol = listeHumiditeSol;
	}

	public List<Emplacement> getListeEmplacementNonDispo() {
		return listeEmplacementsNonRetires;
	}

	

	public List<Emplacement> getListeEmplacement() {
		return listeEmplacementsNonRetires;
	}

	public void setListeEmplacement(List<Emplacement> listeEmplacement) {
		this.listeEmplacementsNonRetires = listeEmplacement;
	}

	public String[] getListesEmplacementsFromJS() {
		return listesEmplacementsFromJS;
	}

	public void setListesEmplacementsFromJS(String[] listesEmplacementsFromJS) {
		this.listesEmplacementsFromJS = listesEmplacementsFromJS;
	}

	public List<Tache> getListeTaches() {
		return listeTachesPlanifiees;
	}

	public void setListeTaches(List<Tache> listeTaches) {
		this.listeTachesPlanifiees = listeTaches;
	}

	public List<Parcelle> getListeParcellesNonRetirees() {
		return listeParcellesNonRetirees;
	}

	public void setListeParcellesNonRetirees(List<Parcelle> listeParcellesNonRetirees) {
		this.listeParcellesNonRetirees = listeParcellesNonRetirees;
	}

	public List<Tache> getListeTachesPlanifiees() {
		return listeTachesPlanifiees;
	}

	public void setListeTachesPlanifiees(List<Tache> listeTachesPlanifiees) {
		this.listeTachesPlanifiees = listeTachesPlanifiees;
	}

	public String getMsgInfoActionGrilleJS() {
		return msgInfoActionGrilleJS;
	}

	public void setMsgInfoActionGrilleJS(String msgInfoActionGrilleJS) {
		this.msgInfoActionGrilleJS = msgInfoActionGrilleJS;
	}

	public String getEtatMsgInfoGrilleJS() {
		return etatMsgInfoGrilleJS;
	}

	public void setEtatMsgInfoGrilleJS(String etatMsgInfoGrilleJS) {
		this.etatMsgInfoGrilleJS = etatMsgInfoGrilleJS;
	}

	public String getMsgInfoActionTableau() {
		return msgInfoActionTableau;
	}

	public void setMsgInfoActionTableau(String msgInfoActionTableau) {
		this.msgInfoActionTableau = msgInfoActionTableau;
	}

	public String getEtatMsgInfoTableau() {
		return etatMsgInfoTableau;
	}

	public void setEtatMsgInfoTableau(String etatMsgInfoTableau) {
		this.etatMsgInfoTableau = etatMsgInfoTableau;
	}

	public List<Parcelle> getListeParcellesRetirees() {
		return listeParcellesRetirees;
	}

	public void setListeParcellesRetirees(List<Parcelle> listeParcellesRetirees) {
		this.listeParcellesRetirees = listeParcellesRetirees;
	}
	
}

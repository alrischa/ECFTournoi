package clientServeur;

public enum Jeu {
	Points(0), CrossJeu(1);
	
	private int ID;
	public int getID(){
		return ID;
	}
	
	Jeu(int id){
		this.ID=id;
	}
	
	static Jeu getJeuFromId(int id){
		Jeu moyen=null;
		for(Jeu m:Jeu.values()){
			if (m.getID()==id){
				moyen=m;
			}
		}
		return moyen;
	}
	
}
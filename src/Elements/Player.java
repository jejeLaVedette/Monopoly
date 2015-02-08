package Elements;

public class Player {
	
	private int argentInit;
	private int id;
	private int argentCourant;
	private int positionx;
	private int positiony;
	
	public Player(int id){
		this.argentInit=1500;
		this.id=id;
		this.argentCourant=1500;
		this.setPositionx(0);
		this.setPositiony(0);
	}

	public int getArgentCourant() {
		return argentCourant;
	}

	public void setArgentCourant(int argentCourant) {
		this.argentCourant = argentCourant;
	}

	public int getId() {
		return id;
	}

	public int getPositionx() {
		return positionx;
	}

	public void setPositionx(int positionx) {
		this.positionx = positionx;
	}

	public int getPositiony() {
		return positiony;
	}

	public void setPositiony(int positiony) {
		this.positiony = positiony;
	}


}

package entities;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Lignepanier {
	
	private int idlp;
	
	public Lignepanier() {
		super();
		
	}
	public int getIdlp() {
		return idlp;
	}
	public void setIdlp(int idlp) {
		this.idlp = idlp;
	}
	public Lignepanier(int idlp) {
		super();
		this.idlp = idlp;
	
	}
	
}

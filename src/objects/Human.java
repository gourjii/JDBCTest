package objects;

public class Human{
	int id;
	String name;
	Profession profession;

	public Human(int id, String name, Profession profession) {
		super();
		this.id = id;
		this.name = name;
		this.profession = profession;
	}

	public Profession getProfession() {
		return profession;
	}

	public void setProfession(Profession profession) {
		this.profession = profession;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}

package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class Skills {
	private int id;
	private String skillName;
	private int fee;

	public Skills(int id, String skillName, int fee) {
		super();
		this.id = id;
		this.skillName = skillName;
		this.fee = fee;
	}

	public int getId() {
		return id;
	}

	public String getSkillName() {
		return skillName;
	}

	public int getFee() {
		return fee;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + fee;
		result = prime * result + id;
		result = prime * result + ((skillName == null) ? 0 : skillName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Skills other = (Skills) obj;
		if (fee != other.fee)
			return false;
		if (id != other.id)
			return false;
		if (skillName == null) {
			if (other.skillName != null)
				return false;
		} else if (!skillName.equals(other.skillName))
			return false;
		return true;
	}

}

public class UserDefinedHashMap {
	public static void main(String[] args) {
		Map<Skills, String> hm = new HashMap<Skills, String>();
		hm.put(new Skills(1, "C++", 1500), "Udemy");
		hm.put(new Skills(2, "Java", 1200), "Edureka");
		hm.put(new Skills(1, "C++", 1500), "Udemy");

		System.out.println("Size is " + hm.size());
		for (Entry<Skills, String> obj : hm.entrySet()) {
			System.out.println(obj.getKey().getSkillName() + " " + obj.getValue());
		}
	}

}

package concepts;

public class MarkerCustom {

	public static void main(String[] args) {
		Entity entity = new Entity(4);
		ShapeDao obj = new ShapeDao();
		boolean flag = obj.delete(entity);
		System.out.println(flag);
	}

}

interface Deletable {

}

class Entity implements Deletable {
//	class Entity  {
	// implementation details
	int id;

	public Entity(int id) {
		super();
		this.id = id;
	}
}

class ShapeDao {

	// other dao methods

	public boolean delete(Object object) {
		if (!(object instanceof Deletable)) {
			throw new RuntimeException("deleteNotSupportedException");
		}

		// delete implementation details

		return true;
	}
}
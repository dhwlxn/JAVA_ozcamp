package menu;

import java.util.List;

public abstract class Board {

	public abstract void insert(int CUID, int CID);
	public abstract void delete(int CUID, int CID);
	public abstract List findAll(int CUID);
	
}

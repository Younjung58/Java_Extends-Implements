package dao_inf;

import java.util.ArrayList;

import dto.WordDTO;

public interface DBdao {
	public void add(String d);
	public ArrayList<WordDTO> selectAll();
	public void mod(WordDTO wdto);
	public void delete(WordDTO wdto);
}

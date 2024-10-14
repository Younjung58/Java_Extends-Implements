package dao_inf;

import java.util.ArrayList;

import dto.WordDTO;

public class WordDAO_m implements DBdao{

	@Override
	public void add(String d) {
		// TODO Auto-generated method stub
		System.out.println("mysql + "+ d);
	}

	@Override
	public ArrayList<WordDTO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void mod(WordDTO wdto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(WordDTO wdto) {
		// TODO Auto-generated method stub
		
	}

}

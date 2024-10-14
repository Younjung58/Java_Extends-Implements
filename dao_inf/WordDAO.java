package dao_inf;

import java.util.ArrayList;

import dto.WordDTO;

public class WordDAO implements DBdao{
	// 인터페이스는 핸들링하기 위한 것.
	public WordDAO() {}
	
	@Override
	public void add(String d) {
		System.out.println("insert: "+d);
	}

	@Override
	public ArrayList<WordDTO> selectAll() {
		ArrayList<WordDTO> w = new ArrayList<WordDTO>();
		WordDTO temp = new WordDTO();
		temp.setEng("apple");
		temp.setKor("사과");
		w.add(temp);
		temp = new WordDTO();
		temp.setEng("banana");
		temp.setKor("바나나");
		w.add(temp);
		
		return w;
	}

	@Override
	public void mod(WordDTO wdto) {
		// TODO Auto-generated method stub
		System.out.println("수정 : "+wdto.getEng()+"/"+wdto.getKor());
	}

	@Override
	public void delete(WordDTO wdto) {
		// TODO Auto-generated method stub
		System.out.println("삭제 : "+wdto.getEng());
	}
}

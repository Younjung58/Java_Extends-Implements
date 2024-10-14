package main;

import dao_inf.DBdao;
import dao_inf.WordDAO;
import service.WordMainFrame;

public class Main {

	public static void main(String[] args) {
		// mysql version
		DBdao dao = new WordDAO();	// 내가 만들 객체를 결정해서 그에 대한 주소를 넘겨서 인젝션(주소를 주입시킴)
//		WordService ws = new WordService(dao);
		WordMainFrame ws = new WordMainFrame(dao);
	}
}

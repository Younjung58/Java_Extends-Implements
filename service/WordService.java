package service;

import dao_inf.DBdao;
// 사용안함
public class WordService {
	
//	WordDAO worddao = new WordDAO(); -> 필요없어짐
//	DBdao worddao = null;		// -> 인터페이스만 알면됨(모든 변수명, 메서드명 알필요 없음!)
//	DBdao worddao = new WordDAO();
	// 만일 WordDAO_m로 변경이 되었다면,,
//	DBdao worddao = new WordDAO_m();  // 객체만 바꾸면 됨(인터페이스를 통하여 응집도가 낮아진 것을 확인할 수 있음)
	// 여기서 더 나아가서 누군가가 객체를 생성하면, 그에 대한 객체의 주소를 주도록 설계
	DBdao worddao = null;  // 어떤 객체를 만들어야하는지 생각하지 않아도됨(의존도가 더 낮아짐)
	public WordService(DBdao db) {
		this.worddao = db;
	} 
	
	public void menu() {
		add();
	}

	private void add() {
		// add 데이터베이스 TEST
		String a = "test";	// DB작업
		worddao.add(a);
	}
}

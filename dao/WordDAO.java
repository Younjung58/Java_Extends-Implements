package dao;
 // 사용안함
public class WordDAO {
	// 만약, 이상황에서 mysql과 연동되는 또다른 DAO역할의 클래스를 만들어서 변경을 한다면, 
	// WordService에서 만들어놓은 변수타입, 객체 클래스 모두 바꾸고, 그 속에 존재하는 메소드또한 알아야함 
	// 즉 응집도가 높아서 수정사항이 많아지는 경우가 발생되는 것.
	//  -> 그 역할을 해줄 DBdao의 인터페이스를 만들어서 진행해보자.
	public void add(String d) {
		System.out.println("insert into "+d);
	}
}

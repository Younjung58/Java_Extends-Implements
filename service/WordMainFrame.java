package service;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dao_inf.DBdao;
import dto.WordDTO;
													// 동작감지기능 위한	ActionListener implements
public class WordMainFrame extends JFrame implements ActionListener, ItemListener {
																	// 선택 기능을 위한 ItemListener implements
	private JPanel title_p = new JPanel();  //컴포넌트&컨테이너. 
	// 기본 레이아웃이 flow 레이아웃.. 가운데부터하나씩 정렬
	private JLabel t = new JLabel("단어장 프로그램" );
	private JPanel center_p = new JPanel();
	private JPanel center_1 = new JPanel();
	private JPanel center_2 = new JPanel();
	private JPanel center_3 = new JPanel();
	//center_1
	JLabel c1 = null;
	JButton c1btn = null;
	JPanel c1c = null;
	JLabel c2 = null;
	JLabel c3 = null;
	JTextField j1 = new JTextField();
	JTextField j2 = new JTextField();
	//center_2
	JPanel c22 = null;
	JLabel c22l = null;
	List c22list = null;
	JButton c22btn = null;
	//center_3
	JLabel c5 = null;
	JButton c5btn = null;
	JPanel c5c = null;
	JLabel c6 = null;
	JLabel c7 = null;
	JTextField j5 = null;
	JTextField j6 = null;
	
	ArrayList<WordDTO> w = null;
	
	// DB작업을 위한 인터페이스 변수 선언
	DBdao dbdao = null;
	
	public WordMainFrame(DBdao d){
		this.dbdao = d;		// DB작업을 위한 객체주소를 외부(메인클래스)로부터 주입받는다.
		this.setBounds(100, 100, 500, 180);
		title_p.add(t);
		center_p.setBackground(Color.yellow);
		this.add(title_p,"North");
		this.add(center_p,"Center");
		center_1.setBackground(Color.red);
		center_2.setBackground(Color.cyan);
		center_3.setBackground(Color.green);
		// 위 3개의 패널을 center_p 에 추가시키는데
		center_p.setLayout(new GridLayout());
		center_p.add(center_1);
		center_p.add(center_2);
		center_p.add(center_3);
		
		//center_1 작업
		c1 = new JLabel("단어입력");
		c1btn=new JButton("저장");
		c1c = new JPanel();
		c1c.setBackground(Color.gray);
		c1c.setLayout(new GridLayout(2, 2));
		c2 = new JLabel("영어");
		c3 = new JLabel("한글");
		c1c.add(c2);
		c1c.add(j1);
		c1c.add(c3);
		c1c.add(j2);
		center_1.setLayout(new BorderLayout());
		center_1.add(c1,"North");
		center_1.add(c1btn,"South");
		center_1.add(c1c,"Center");
		
		//center_2작업
		c22 = new JPanel();
		c22.setLayout(new BorderLayout());
		c22l = new JLabel("단어리스트");
		c22list = new List();
		c22btn = new JButton("선택단어삭제");
		c22.add(c22l,"North");
		c22.add(c22list,"Center");
		c22.add(c22btn,"South");
		center_2.setLayout(new BorderLayout());
		center_2.add(c22,"Center");
		
		//center_3 작업
		c5 = new JLabel("단어수정");
		c5btn=new JButton("수정");
		c5c = new JPanel();
		c5c.setBackground(Color.gray);
		c5c.setLayout(new GridLayout(2, 2));
		c6 = new JLabel("영어");
		c7 = new JLabel("한글");
	    j5 = new JTextField();
		j6 = new JTextField();
		c5c.add(c6);
		c5c.add(j5);
		c5c.add(c7);
		c5c.add(j6);
		center_3.setLayout(new BorderLayout());
		center_3.add(c5,"North");
		center_3.add(c5btn,"South");
		center_3.add(c5c,"Center");		
		
		j5.setEnabled(false);
		c1btn.addActionListener(this);
		j1.addActionListener(this);
		j2.addActionListener(this);
		
		c22list.addItemListener(this);		// 리스너등록 -> 이벤트 감지하기 위해서
		c22btn.addActionListener(this);
		c5btn.addActionListener(this);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		init();
	}

	private void init() {
		w = dbdao.selectAll();
		for(WordDTO t : w) {
			c22list.add(t.getEng()+" : "+t.getKor());
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==c1btn || e.getSource()== j1 || e.getSource()== j2) {
			System.out.println("저장 버튼눌림");
			String eng = j1.getText();
			String kor = j2.getText();
			System.out.println(eng+" / "+kor);
			
			j1.setText("");
			j2.setText("");
			
			// DTO 에 저장하고 DAO를 통해서 db에 저장..
			WordDTO wdto = new WordDTO();
			wdto.setEng(eng);
			wdto.setKor(kor);
			dbdao.add(eng);
		}else if(e.getSource()==c22btn) {
			System.out.println("삭제 버튼눌림");
			String eng = j5.getText();
			WordDTO wdto = new WordDTO();
			wdto.setEng(eng);
			// dao에게 넘겨서 수정합니다. 단, 영어단어는 수정이 불가로 하는 컨셉.
			dbdao.delete(wdto);
			
		}else if(e.getSource()==c5btn) {
			System.out.println("수정 버튼눌림");
			String eng = j5.getText();
			String kor = j6.getText();
			WordDTO wdto = new WordDTO();
			wdto.setEng(eng);
			wdto.setKor(kor);
			// dao에게 넘겨서 삭제합니다.
			dbdao.mod(wdto);
		}
		
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		int selectNum = c22list.getSelectedIndex();
		System.out.println(selectNum+"번이 선택됨");
		WordDTO tempdto = w.get(selectNum);
		j5.setText(tempdto.getEng());
		j6.setText(tempdto.getKor());
	}

}

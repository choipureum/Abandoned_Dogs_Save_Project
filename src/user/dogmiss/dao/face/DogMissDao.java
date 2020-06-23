package user.dogmiss.dao.face;

import java.util.List;


import user.dogmiss.dto.DogMiss;
import user.dogmiss.dto.DogMissAdd;
import user.dogmiss.dto.DogMissFile;
import util.Paging;





public interface DogMissDao {
	//public List<DogMiss> selectAll();
	
	
	
	
	
	public int selectNextUserno();
	
	
	//public void insert(QNA qna);
	
	//게시글의 전체 숫자를 가져온다 
	public int selectCntAll();
	
	public int selectCntAll(String serch);
	
	public List<DogMissAdd> selectAll(Paging paging);
	
	public DogMiss selectBoardByMissno(DogMiss missno);

	public void updateHit(DogMiss missno);
	
	public DogMissFile selectFile(DogMiss view);
	
	public int selectBoardno();
	
	public void insert(DogMiss board);
	
	public void insertFile(DogMissFile boardFile);
	
	public void delete(DogMiss board);
	
	
	public void deleteFile(DogMiss board);
	
	public DogMissFile viewFM(DogMissFile FM);
	
	public void update(DogMiss board);
	
	//public List<DogMissAdd> joinList(DogMiss list);
}

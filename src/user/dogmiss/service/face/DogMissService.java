package user.dogmiss.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import user.dogmiss.dto.DogMiss;
import user.dogmiss.dto.DogMissAdd;
import user.dogmiss.dto.DogMissFile;
import util.Paging;



public interface DogMissService {

	
	//public List<DogMiss> getList();
	
	//public QNA getParam(HttpServletRequest request);
	
	//public QNA join(QNA member);
	
	
	
	public Paging getPaging(HttpServletRequest request);
	
	public List<DogMissAdd> getList(Paging paging);
	
	public DogMiss getmissno(HttpServletRequest req);
	
	public DogMiss view(DogMiss missno);
	
	public DogMissFile viewFile(DogMiss view);
	
	public void write(HttpServletRequest request);
	
	
	public DogMiss getBoardno(HttpServletRequest req);
	
	public void delete(DogMiss board);
	
	public DogMissFile viewFM(DogMissFile FM);
	
	public void update(HttpServletRequest req);
	
	//public List <DogMissAdd> joinList(DogMiss missList);
	
}
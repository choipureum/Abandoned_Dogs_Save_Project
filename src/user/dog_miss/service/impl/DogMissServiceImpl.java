package user.dog_miss.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import user.dog_miss.dao.face.DogMissDao;
import user.dog_miss.dao.impl.DogMissDaoImpl;
import user.dog_miss.dto.Dog_MissDTO;
import user.dog_miss.service.face.DogMissService;
import util.JDBCTemplate;

public class DogMissServiceImpl implements DogMissService {

	private DogMissDao dog_MissDao = new DogMissDaoImpl();

	
	@Override
	public List<Dog_MissDTO> list() {
		
		List<Dog_MissDTO> list = dog_MissDao.selectAll();
		
		
		return list;
	}


	@Override
	public int insertDogMiss(Dog_MissDTO dog_MissDTO) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dog_MissDao.insertDog_Miss(conn, dog_MissDTO);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		return result;
	}
	
	
}

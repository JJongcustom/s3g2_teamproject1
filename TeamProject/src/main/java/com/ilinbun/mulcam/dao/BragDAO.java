package com.ilinbun.mulcam.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ilinbun.mulcam.dto.Bragboard;

@Mapper
@Repository
public interface BragDAO {	
	public Bragboard bragBest1() throws Exception;

	public Bragboard bragBoardQueryByID(String id);
	
	void insertBragBoard(Bragboard bragboard) throws Exception;
	
	
	Integer selectMaxArticleNo () throws Exception;
	List<Bragboard> selectBragBoardList(int startrow) throws Exception;
	//사용자 화면에 뿌려줄 게시판 한 페이지에 대한 정보 가져올 DAO 메서드
	int selectBragBoardCount() throws Exception;
	//사용자 화면 하단에 뿌려줄 게시판 페이지 번호를 구성하기 위한 저장된 글의 총 row를 개수 정보를 반환하는 DAO 메서드
	Bragboard selectBragBoard(int articleNo) throws Exception;
	//하나의 글 정보를 select하는 쿼리문
	void updateReadCount(int articleNo) throws Exception;
	void updateBragBoardReSeq(Bragboard bragboard) throws Exception;

	void updateBragBoard(Bragboard bragboard) throws Exception;
	void deleteBragBoard(int articleNo) throws Exception;
	void updateDeletedBragBoard(Bragboard bragboard) throws Exception;


}



package com.ilinbun.mulcam.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ilinbun.mulcam.dao.PlaceReviewDAO;
import com.ilinbun.mulcam.dto.PageInfo;
import com.ilinbun.mulcam.dto.PlaceReview;
import com.ilinbun.mulcam.dto.PlaceReviewExtended;
@Service
public class PlaceReviewServiceImpl implements PlaceReviewService {
	
	@Autowired
	PlaceReviewDAO placeReviewDAO;
	
	@Override
	public void writeBoard(PlaceReview pr) throws Exception {
		Integer boardNum = placeReviewDAO.selectMaxPRNum();
		if(boardNum==null) boardNum=1;
		else boardNum+=1;
		//pr.setBoard_num(boardNum);
		pr.setReviewNo(boardNum);
		//pr.setBoard_re_ref(boardNum);
		//pr.setBoard_re_lev(0);
		//pr.setBoard_re_seq(0);
		//pr.setBoard_readcount(0);
		placeReviewDAO.insertReview(pr);
	}
	
	@Override
	public List<PlaceReviewExtended> getReviewList(int page, PageInfo pageInfo, int id) throws Exception {
		int listCount = placeReviewDAO.selectPRBoardCount(id);
		
		// 총 페이지 수. 올림처리
		int maxPage = (int)Math.ceil((double)listCount/10);
		
		// 현재 페이지에 보여줄 시작 페이지 수
		int startPage =(((int)((double)page/10+0.9))-1)*10+1;
		
		// 현재 페이지에 보여줄 마지막 페이지 수(10,20,30,..)
		int endPage = startPage+10 -1;
		
		if(endPage>maxPage) endPage = maxPage;
		pageInfo.setStartPage(startPage);
		pageInfo.setEndPage(endPage);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setPage(page);
		pageInfo.setListCount(listCount);
		int startrow = (page-1)*10+1;
		HashMap<String, Integer> input = new HashMap<>();
		input.put("startrow", startrow);
		input.put("id", id);
		return placeReviewDAO.selectPRReviewList(input);
	}

	@Override
	public int getReviewAmount(int id) throws Exception {
		return placeReviewDAO.selectPRBoardCount(id);
	}
	
}
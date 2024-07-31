package com.fastcampus.ch4.domain;

public class PageHandler {
	private int boardSize;
	private static final int PAGE_SIZE = 10;
	private int LastPage;
	private int beginPage;
	private int curPage;
	private int endPage;
	
	private PageHandler() {
	}
	
	public PageHandler(int boardSize) {
		this.boardSize = boardSize;
		this.LastPage = this.boardSize / PAGE_SIZE + (this.boardSize % PAGE_SIZE == 0 ? 0 : 1);
		this.beginPage = 1;
		this.curPage = 1;
		this.endPage = LastPage > 10 ? 10 : LastPage;
	}
	
	public void InccurPage() {
		if(curPage < endPage) {
			curPage = curPage + 1;
		}
	}

	public void DeccurPage() {
		if(curPage > 1) {
			curPage = curPage - 1;
		}
	}
	
	public void Inc10curPage() {
		if(curPage < endPage) {
			curPage = curPage + 10 < LastPage ? curPage + 10 : LastPage;
		}
	}
	
	public void Dec10curPage() {
		if(curPage < endPage) {
			curPage = curPage - 10 < 1 ? curPage - 10 : 1;
		}
	}

	public int getBoardSize() {
		return boardSize;
	}

	public void setBoardSize(int boardSize) {
		this.boardSize = boardSize;
	}
	
	public int getBeginPage() {
		return beginPage;
	}

	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public static int getPageSize() {
		return PAGE_SIZE;
	}
}

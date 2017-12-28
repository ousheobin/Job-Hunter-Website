package cn.gcu.pojo;

import java.io.Serializable;
import java.util.List;

public class Page<T> implements Serializable{

	private static final long serialVersionUID = -7501049484305582871L;
	
	private long pageSize;
	private long pageNumber;
	private long next;
	private long prev;
	private long firstPage;
	private long lastPage;
	private List<T> pageData;

	public long getPageSize() {
		return pageSize;
	}

	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}

	public long getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(long pageNumber) {
		this.pageNumber = pageNumber;
	}

	public long getNext() {
		return next;
	}

	public void setNext(long next) {
		this.next = next;
	}

	public long getPrev() {
		return prev;
	}

	public void setPrev(long prev) {
		this.prev = prev;
	}

	public long getFirstPage() {
		return firstPage;
	}

	public void setFirstPage(long firstPage) {
		this.firstPage = firstPage;
	}

	public long getLastPage() {
		return lastPage;
	}

	public void setLastPage(long lastPage) {
		this.lastPage = lastPage;
	}

	public List<T> getPageData() {
		return pageData;
	}

	public void setPageData(List<T> pageData) {
		this.pageData = pageData;
	}

	@Override
	public String toString() {
		return "Page [pageSize=" + pageSize + ", pageNumber=" + pageNumber + ", next=" + next + ", prev=" + prev
				+ ", firstPage=" + firstPage + ", lastPage=" + lastPage + ", pageData=" + pageData + "]";
	}

}

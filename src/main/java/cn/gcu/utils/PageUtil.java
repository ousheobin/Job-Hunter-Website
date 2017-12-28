package cn.gcu.utils;

import cn.gcu.pojo.Page;

public class PageUtil {

	public static Page<?> generatePage(Page<?> page, long sum, long prePage, long pageNumber) {
		long lastPage = generateLastPage(sum, prePage);
		prePage = (prePage>0)?prePage:1;
		pageNumber = vaildPageNumber(pageNumber, lastPage);
		page.setPageNumber(pageNumber);
		page.setFirstPage(1);
		page.setLastPage(lastPage);
		page.setNext(generateNext(lastPage, pageNumber));
		page.setPageSize(prePage);
		page.setPrev(generatePrev(pageNumber));
		return page;
	}

	private static long vaildPageNumber(long pageNumber, long lastPage) {
		if (pageNumber < 1) {
			return 1;
		} else if (pageNumber > lastPage) {
			return lastPage;
		}
		return pageNumber;
	}

	private static long generateLastPage(long sum, long prePage) {
		long page =  sum / prePage;
		if(sum%prePage > 0){
			page ++;
		}
		return (page>0)?page:1;
	}

	private static long generateNext(long lastPage, long pageNumber) {
		if (pageNumber < lastPage) {
			return pageNumber + 1;
		} else {
			return lastPage;
		}
	}

	private static long generatePrev(long pageNumber) {
		if (pageNumber > 1) {
			return pageNumber - 1;
		} else {
			return 1;
		}
	}

	/**
	 * 
	 * @param baseUrl
	 *            需要插入页码的URL，页码以${pageNumber}代替
	 * @return
	 */
	public static String generateBootstrapNav(Page<?> page, String baseUrl) {
		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append("<nav aria-label=\"Page navigation\">\n  <ul class=\"pagination\">\n");
		// Prev
		if (page.getFirstPage() < page.getPageNumber()) {
			strBuffer.append("<li><a href=\"" + baseUrl.replace("${pageNumber}", Long.toString(page.getPrev()))
					+ "\" aria-label=\"Previous\"><span aria-hidden=\"true\">&laquo;</span></a></li>\n");
		}
		// Page
		if (page.getLastPage()<= 10) {
			for (long pageNumber = 1; pageNumber <= page.getLastPage(); pageNumber++) {
				if(pageNumber == page.getPageNumber() ){
					strBuffer.append("<li class=\"active\"><a href=\""+ baseUrl.replace("${pageNumber}", Long.toString(pageNumber))+"\">"+pageNumber+"</a></li>\n");
				}else{
					strBuffer.append("<li><a href=\""+ baseUrl.replace("${pageNumber}", Long.toString(pageNumber))+"\">"+pageNumber+" </a></li>\n");
				}
			}
		}else if(page.getPageNumber()<10 && page.getLastPage() > 10){
			for (long pageNumber = 1; pageNumber < page.getPageNumber()+2 || pageNumber <=9; pageNumber++) {
				if(pageNumber == page.getPageNumber() ){
					strBuffer.append("<li class=\"active\"><a href=\""+ baseUrl.replace("${pageNumber}", Long.toString(pageNumber))+"\">"+pageNumber+"</a></li>\n");
				}else{
					strBuffer.append("<li><a href=\""+ baseUrl.replace("${pageNumber}", Long.toString(pageNumber))+"\">"+pageNumber+" </a></li>\n");
				}
			}
			strBuffer.append("<li ><a href=\"#\">...</a></li>\n");
			strBuffer.append("<li><a href=\""+ baseUrl.replace("${pageNumber}", Long.toString(page.getLastPage()-1))+"\">"+Long.toString(page.getLastPage()-1)+"</a></li>\n");
			strBuffer.append("<li><a href=\""+ baseUrl.replace("${pageNumber}", Long.toString(page.getLastPage()))+"\">"+Long.toString(page.getLastPage())+"</a></li>\n");
		}else{
			strBuffer.append("<li><a href=\""+ baseUrl.replace("${pageNumber}", Long.toString(1))+"\">"+1+"</a></li>\n");
			strBuffer.append("<li><a href=\""+ baseUrl.replace("${pageNumber}", Long.toString(2))+"\">"+2+"</a></li>\n");
			if(page.getLastPage()>12){
				strBuffer.append("<li class=\"disable\"><a href=\"#\">...</a></li>\n");
			}
			if(page.getPageNumber() > page.getLastPage()-10){
				for (long pageNumber = page.getPageNumber(); pageNumber <= page.getLastPage() -2 && pageNumber <= page.getPageNumber()+6; pageNumber++) {
					if(pageNumber == page.getPageNumber() ){
						strBuffer.append("<li><a class=\"active\" href=\""+ baseUrl.replace("${pageNumber}", Long.toString(pageNumber))+"\">"+pageNumber+"</a></li>\n");
					}else{
						strBuffer.append("<li><a href=\""+ baseUrl.replace("${pageNumber}", Long.toString(pageNumber))+"\">"+pageNumber+" </a></li>\n");
					}
				}
			}else{
				for (long pageNumber = page.getPageNumber()-1; pageNumber <= page.getLastPage() -2 && pageNumber <= page.getPageNumber()+2; pageNumber++) {
					if(pageNumber == page.getPageNumber() ){
						strBuffer.append("<li><a class=\"active\" href=\""+ baseUrl.replace("${pageNumber}", Long.toString(pageNumber))+"\">"+pageNumber+"</a></li>\n");
					}else{
						strBuffer.append("<li><a href=\""+ baseUrl.replace("${pageNumber}", Long.toString(pageNumber))+"\">"+pageNumber+" </a></li>\n");
					}
				}
			}
			
			if(page.getLastPage()-8>page.getPageNumber()){
				strBuffer.append("<li ><a href=\"#\">...</a></li>\n");
			}
			strBuffer.append("<li><a href=\""+ baseUrl.replace("${pageNumber}", Long.toString(page.getLastPage()-1))+"\">"+Long.toString(page.getLastPage()-1)+"</a></li>\n");
			strBuffer.append("<li><a href=\""+ baseUrl.replace("${pageNumber}", Long.toString(page.getLastPage()))+"\">"+Long.toString(page.getLastPage())+"</a></li>\n");
		}
		// Next
		if (page.getLastPage() > page.getPageNumber()) {
			strBuffer.append("<li><a href=\"" + baseUrl.replace("${pageNumber}", Long.toString(page.getNext()))
					+ "\" aria-label=\"Next\"><span aria-hidden=\"true\">&raquo;</span></a></li>\n");
		}
		strBuffer.append("</ul>\n</nav>");
		return strBuffer.toString();
	}

}

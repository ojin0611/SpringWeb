<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../common/header.jsp" />

<c:set var="pageSize" value="${pageSize}" /> <!-- 한 페이지에 뿌여지는 레코드 수 -->
<c:set var="currentPage" value="${currentPage}" />
<c:set var="totalPage" value="${totalPage}" />
<div class="container">
	<div class="row">
		<h1 class="text-center">Q&A 게시판</h1>
		
		<table class="table">
			<tr>
				<td class="text-left">[<a href="/qna/write">글쓰기</a>]</td>
				<td class="text-right">(${currentPage}/${totalPage})</td>
			</tr>
		</table>
		<table class="table table-bordered">
  			<thead>
  				<tr class="success">
  					<th class="text-center" style="width:10%">글번호</th>
  					<th class="text-center" style="width:15%">작성자</th>
  					<th class="text-center" style="width:50%">제목</th>
  					<th class="text-center" style="width:15%">작성날짜</th>
  					<th class="text-center" style="width:10%">조회수</th>
  				</tr>
  			</thead>
  			<tbody>
  				<c:if test="${qnalist.size() == 0}">
  					<tr>
  						<td colspan="5" class="text-center danger">No Data</td>
  					</tr>
  				</c:if>
  				<c:if test="${qnalist.size() > 0}">
  					<c:set var="begin" value="${(currentPage - 1) * pageSize}" />
  					<c:set var="end" value="${begin + pageSize - 1}" />
  					<c:forEach items="${qnalist}" var="row" begin="${begin}" end="${end}">
  						<tr>
  							<td class="text-center">
  								<c:if test="${row.lvl gt 0}"><!-- 만일 답변일 경우에는 글번호를 보여주지 말자. -->
  									&nbsp;
  								</c:if>
  								<c:if test="${row.lvl eq 0 }"> <!--  원본 글이면 -->
  									${row.grp}
  								</c:if>
  							</td>
  							<td class="text-center">
  								<c:if test="${empty row.email}">
  									${row.writer}
  								</c:if>
  								<c:if test="${not empty row.email}">
  									<a href="mailto:${row.email}">${row.writer}</a>
  								</c:if>
  							</td>
  							<td class="text-left">
  								<c:forEach begin="1" end="${row.lvl * 3}" var="i">
  									&nbsp;
  								</c:forEach>
  								<c:if test="${row.lvl gt 0}">
  									<img src="/images/reply.jpg" />
  								</c:if>
  								<a href="/qna/read?bno=${row.bno}">${row.title}</a>
  							</td>
  							<td class="text-center">${row.writeday}</td>
  							<td class="text-center">${row.readnum}</td>
  						</tr>
  					</c:forEach>
  				</c:if>
  			</tbody>
		</table>
		<hr />
		<div class="text-center">
			<c:if test="${currentPage ne 1}">
				[<a href="/qna/list?page=${currentPage - 1}">이전</a>]&nbsp;&nbsp;&nbsp;
			</c:if>
			<c:if test="${currentPage eq 1}">
				[이전]&nbsp;&nbsp;&nbsp;
			</c:if>
			<c:forEach begin="1" end="${totalPage}" var="i">
				<c:if test="${currentPage eq i}">
					<span style="color:red;font-size:1.5em;font-weight:900">${i}</span>&nbsp;&nbsp;&nbsp;
				</c:if>
				<c:if test="${currentPage ne i}">
					<a href="/qna/list?page=${i}">${i}</a>&nbsp;&nbsp;&nbsp;
				</c:if>
			</c:forEach>
			<c:if test="${currentPage eq totalPage}">
				[다음]
			</c:if>
			<c:if test="${currentPage ne totalPage}">
				[<a href="/qna/list?page=${currentPage + 1}">다음</a>]
			</c:if>
		</div>
	</div>
</div>

<c:import url="../common/footer.jsp" />
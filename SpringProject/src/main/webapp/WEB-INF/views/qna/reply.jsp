<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../common/header.jsp" />
<script src="https://cdn.ckeditor.com/4.15.1/standard/ckeditor.js"></script>
<h1 class="text-center">QnA 답변하기</h1>
  <div class="container">
    <div class="row">
      <form class="form-horizontal" action="/qna/reply" method="POST">
      	<input type="hidden" name="grp"  value="${qna.grp}"/>
      	<input type="hidden" name="lvl" value="${qna.lvl}"/>
      	<input type="hidden" name="step"  value="${qna.step}"/>
        <div class="form-group">
          <label for="txtWriter" class="col-sm-2 control-label">답변자</label>
          <div class="col-sm-5">
            <input type="text" class="form-control" name="writer" id="txtWriter" 
            placeholder="답변자의 이름을 입력합니다." required>
          </div>
        </div>
        <div class="form-group">
          <label for="txtTitle" class="col-sm-2 control-label">글 제목</label>
          <div class="col-sm-8">
            <input type="text" class="form-control" name="title" id="txtTitle" 
            placeholder="글 제목을 입력합니다." required value="Re:${qna.title}">
          </div>
        </div>
        <div class="form-group">
          <label for="txtEmail" class="col-sm-2 control-label">Email</label>
          <div class="col-sm-3">
            <input type="text" name="email" class="form-control" 
            	id="txtEmail" placeholder="작성자의 Email을 입력합니다.">
          </div>
          <div class="input-group  col-sm-3">
        	<span class="input-group-addon">@</span>
        	<select class="form-control" name="company" id="company">
  				<option value="naver.com">네이버</option>
  				<option value="hanmail.net">한메일</option>
			  	<option value="google.com">구글</option>
			  	<option value="nate.com">네이트</option>
			  	<option>직접입력</option>
				</select>
      	  </div>
        </div>
        <div class="form-group">
          <label for="txtContent" class="col-sm-2 control-label">글 내용</label>
          <div class="col-sm-8">
          	<!--  CKEditor를 사용하지 않고 일반 Textarea일 경우에는 위에서 몇 줄 띄고 원본질문을 넣는다. -->
            <textarea class="form-control" rows="10" required="required" name="content">
       			<p>&nbsp;</p>            
				<p>&nbsp;</p>               
            	<p>&nbsp;</p>
            	<p>&nbsp;</p>
       			<p>-----------------------------------------------------</p>            
				${qna.content}</textarea>
          </div>
        </div>
        <div class="form-group">
          <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-success" id='btnSubmit'>답변하기</button>
            <button type="reset" class="btn btn-warning">취소하기</button>
            <button type="button" id="btnList" class="btn btn-info">목록으로</button>
          </div>
        </div>
      </form>
    </div>
  </div>
<script>
	CKEDITOR.replace( 'content' );
</script>
<script>
	$('#btnList').on('click', function(){
		location.href = "/qna/list";
	});
	$('#company').on('change', function(){
		let company = document.getElementById("company")
		if(company.selectedIndex == 4){  //직접입력을 선택했다면
			$(this).replaceWith("<input type='text' name='company' class='form-control'>");
		}
	});
</script>
<c:import url="../common/footer.jsp" />
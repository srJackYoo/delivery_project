<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 관리</title>
<script src="<%=request.getContextPath()%>/public/js/comment_ajax_managing.js" defer="defer"></script>
</head>
<body>
<div class="container">
	<blockquote class="blockquote">
		<h1>리뷰 관리 페이지</h1>
	</blockquote>
	<%@ include file="/header_nav.jsp" %>
	<nav>
		<div class="nav nav-pills nav-justified" id="nav-tab" role="tablist">
	    <button class="nav-link active" id="nav-list-tab" data-bs-toggle="tab" data-bs-target="#nav-list" type="button" role="tab" aria-controls="nav-list" aria-selected="true">리뷰 리스트</button>
	    <button class="nav-link" id="nav-modify-tab" data-bs-toggle="tab" data-bs-target="#nav-modify" type="button" role="tab" aria-controls="nav-modify" aria-selected="false" disabled>리뷰 수정</button>
	  </div>
	</nav>
	<div class="tab-content" id="nav-tabContent">
	  <div class="tab-pane fade show active" id="nav-list" role="tabpanel" aria-labelledby="nav-home-tab">
	  	<h2>메뉴 리스트</h2>
	  	<table class="table table-info table-striped">
	  		<thead>
	  			<tr>
	  				<th>num</th>
	  				<th>title</th>
	  				<th>member_id</th>
	  				<th>menu_num</th>
	  				<th>contents</th>				
	  				<th>delivery_grade</th>
	  				<th>food_grade</th>
	  				<th>seller_grade</th>
	  				<th>post_time</th>
	  				<th>state</th>
	  			</tr>
	  		</thead>
	  		<tbody id="commentList">
	  			<tr id="commentClone">
	  				<td class="comment_num"></td>
	  				<td>
						<a class="title" href="javascript:void(0)" onclick="modifyLoad(event)" data-num=""></a>	  				
	  				</td>
	  				<td class="member_id"></td>
	  				<td class="menu_num"></td>
	  				<td class="contents"></td>
	  				<td class="delivery_grade"></td>
	  				<td class="item_grade"></td>
	  				<td class="seller_grade"></td>
	  				<td class="post_time"></td>
	  				<td class="state"></td>
	  			</tr>
	  		</tbody>
	  	</table>
	  </div>
	  <div class="tab-pane fade" id="nav-modify" role="tabpanel" aria-labelledby="nav-modify-tab">
	  	<div class="modal" id="updateModar" tabindex="-1">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title">리뷰 수정</h5>
			        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			      </div>
			      <div class="modal-body">
			        <p id="updateMsg"></p>
			      </div>
			      <div class="modal-footer">
			      <button type="button" id="listReloadBtn" class="btn btn-primary">리뷰 리스트 이동</button>
			        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
			      </div>
			    </div>
			  </div>
			</div>
			<div class="modal" id="deleteModar" tabindex="-1">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title">리뷰 삭제</h5>
			        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			      </div>
			      <div class="modal-body">
			        <p id="deleteMsg"></p>
			      </div>
			      <div class="modal-footer">
			      <button type="button" id="listReloadBtn2" class="btn btn-primary">리뷰 리스트 이동</button>
			        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
			      </div>
			    </div>
			  </div>
			</div>
	  	<h2>리뷰 수정 및 삭제</h2>
	  	<form action="" name=commentModifyForm>
	  			<p class="input-group">
				  <label for="commentModifyFormCommentNum" class="input-group-text">리뷰 번호</label>
				  <input name="comment_num" type="text" class="form-control" id="commentModifyFormCommentNum" value="" readonly>
				</p>
		  		<p class="input-group">
				  <label for="commentModifyFormTitle" class="input-group-text">리뷰 제목</label>
				  <input name="title" type="text" class="form-control" id="commentModifyFormTitle" value="" readonly>
				</p>
				<p class="input-group">
				  <label for="commentModifyFormMemberId" class="input-group-text">리뷰 작성자</label>
				  <input name="member_id" type="text" class="form-control" id="commentModifyFormMemberId" value="" readonly>
				</p>
				<p class="input-group">
				  <label for="commentModifyFormMenuNum" class="input-group-text">메뉴 번호</label>
				  <input name="menu_num" type="number" class="form-control" id="commentModifyFormMenuNum" value="" readonly>
				</p>
				<p class="input-group">
				  <label for="commentModifyFormContents" class="input-group-text">리뷰 내용</label>
				  <input name="contents" type="text" class="form-control" id="commentModifyFormContents" value="" readonly>
				</p>
				<p class="input-group">
				  <label for="commentModifyFormDeliveryGrade" class="input-group-text">배달 평점</label>
				  <input name="delivery_grade" type="number" class="form-control" id="commentModifyFormDeliveryGrade" value="" readonly>
			  		<label for="commentModifyFormItemGrade" class="input-group-text">음식 평점</label>
			 	 	<input name="item_grade" type="number" class="form-control" id="commentModifyFormItemGrade" value="" readonly>
				  <label for="commentModifyFormSellerGrade" class="input-group-text">판매자 평점</label>
				  <input name="seller_grade" type="number" class="form-control" id="commentModifyFormSellerGrade" value="" readonly>
				</p>
				<p class="input-group">
				  <label for="commentModifyFormImg" class="input-group-text">리뷰 사진</label>
				  <input name="img" type="text" class="form-control" id="commentModifyFormImg" value="" readonly>
				</p>
				<p class="input-group">
				  <label for="commentModifyFormState" class="input-group-text">리뷰 상태</label>
				  <select name="state" class="form-control" id="commentModifyFormState">
				  	<option value="0" selected>공개</option>
				  	<option value="1">비공개</option>
				  	<option value="2">신고</option>
				  </select>
				</p>
				<p class="d-grid gap-2 d-md-flex justify-content-md-end">
		  		<a class="btn btn-outline-danger" href="javascript:void(0)" onclick="deleteComment(event)">삭제</a>
		  		<button class="btn btn-outline-primary" type="submit">수정</button>
		  	</p>
	  	</form>
	  </div>
	  
  	</div>
</div>
</body>
</html>
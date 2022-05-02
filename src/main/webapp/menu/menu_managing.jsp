<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu 관리</title>
<script src="<%=request.getContextPath()%>/public/js/menu_ajax_managing2.js" defer="defer"></script>
</head>
<body>
<div class="container">
	<blockquote class="blockquote">
		<h1>메뉴 관리 페이지</h1>
	</blockquote>
	<%@ include file="/header_nav.jsp" %>
	<nav>
		<div class="nav nav-pills nav-justified" id="nav-tab" role="tablist">
	    <button class="nav-link active" id="nav-list-tab" data-bs-toggle="tab" data-bs-target="#nav-list" type="button" role="tab" aria-controls="nav-list" aria-selected="true">메뉴 리스트</button>
	    <button class="nav-link" id="nav-insert-tab" data-bs-toggle="tab" data-bs-target="#nav-insert" type="button" role="tab" aria-controls="nav-insert" aria-selected="false">메뉴 등록</button>
	    <button class="nav-link" id="nav-modify-tab" data-bs-toggle="tab" data-bs-target="#nav-modify" type="button" role="tab" aria-controls="nav-modify" aria-selected="false" disabled>메뉴 수정</button>
	  </div>
	</nav>
	<div class="tab-content" id="nav-tabContent">
	  <div class="tab-pane fade show active" id="nav-list" role="tabpanel" aria-labelledby="nav-home-tab">
	  	<h2>메뉴 리스트</h2>
	  	<table class="table table-info table-striped">
	  		<thead>
	  			<tr>
	  				<th>num</th>
	  				<th>name</th>
	  				<th>price</th>
	  				<th>menu_detail</th>
	  				<th>menu_img</th>
	  				<th>detail_img</th>
	  				<th>post_date</th>
	  				<th>shop_num</th>
	  			</tr>
	  		</thead>
	  		<tbody id="menuList">
	  			<tr id="menuClone">
	  				<td class="menu_num"></td>
	  				<td>
						<a class="name" href="javascript:void(0)" onclick="modifyLoad(event)" data-num=""></a>	  				
	  				</td>
	  				<td class="price"></td>
	  				<td class="menu_detail"></td>
	  				<td class="menu_img"></td>
	  				<td class="detail_img"></td>
	  				<td class="post_date"></td>
	  				<td class="shop_num"></td>
	  			</tr>
	  		</tbody>
	  	</table>
	  </div>
	  
	  <div class="tab-pane fade" id="nav-insert" role="tabpanel" aria-labelledby="nav-home-tab"> 
	  	<div class="modal" id="insertModar" tabindex="-1">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title">메뉴 등록</h5>
			        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			      </div>
			      <div class="modal-body">
			        <p id="insertMsg"></p>
			      </div>
			      <div class="modal-footer">
			      <button type="button" id="listReloadBtn" class="btn btn-primary">MENU 리스트 이동</button>
			        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
			      </div>
			    </div>
			  </div>
			</div>
	  	<h2>메뉴 등록</h2>
	  	<form action="" name=menuForm>
		  	<p class="input-group">
			  <label for="menuFormName" class="input-group-text">메뉴 이름</label>
			  <input name="name" type="text" class="form-control" id="menuFormName" value="오븐 바사삭">
			</p>
			<p class="input-group">
			  <label for="menuFormPrice" class="input-group-text">메뉴 가격</label>
			  <input name="price" type="number" class="form-control" id="menuFormPrice" value="20000">
			</p>
			<p class="input-group">
			  <label for="menuFormMenuDetail" class="input-group-text">메뉴 설명</label>
			  <input name="menu_detail" type="text" class="form-control" id="menuFormDetail" value="맛있는 오븐바사삭">
			</p>
			<p class="input-group">
			  <label for="menuFormMenuImg" class="input-group-text">메뉴 사진</label>
			  <input name="menu_img" type="file" class="form-control" id="menuFormMenuImg" value="chicken3.img">
			</p>
			<p class="input-group">
			  <label for="menuFormDetailImg" class="input-group-text">메뉴 상세 사진</label>
			  <input name="detail_img" type="file" class="form-control" id="menuFormDetailImg" value="chicken4.img">
			</p>
			<p class="input-group">
			  <label for="menuFormShopNum" class="input-group-text">메뉴 담당 가게 번호</label>
			  <input name="shop_num" type="text" class="form-control" id="menuFormShopNum" value="1">
			</p>
		  	<p class="d-grid gap-2 d-md-flex justify-content-md-end">
		  		<button class="btn btn-outline-warning" type="reset">리셋</button>
		  		<button class="btn btn-outline-primary" type="submit">등록</button>
		  	</p>
	  	</form>
	  </div>
	  <div class="tab-pane fade" id="nav-modify" role="tabpanel" aria-labelledby="nav-modify-tab">
	  	<div class="modal" id="updateModar" tabindex="-1">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title">메뉴 수정</h5>
			        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			      </div>
			      <div class="modal-body">
			        <p id="updateMsg"></p>
			      </div>
			      <div class="modal-footer">
			      <button type="button" id="listReloadBtn2" class="btn btn-primary">MENU 리스트 이동</button>
			        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
			      </div>
			    </div>
			  </div>
			</div>
			<div class="modal" id="deleteModar" tabindex="-1">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title">메뉴 삭제</h5>
			        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			      </div>
			      <div class="modal-body">
			        <p id="deleteMsg"></p>
			      </div>
			      <div class="modal-footer">
			      <button type="button" id="listReloadBtn3" class="btn btn-primary">MENU 리스트 이동</button>
			        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
			      </div>
			    </div>
			  </div>
			</div>
	  	<h2>메뉴 수정 및 삭제</h2>
	  	<form action="" name=menuModifyForm>
	  			<p class="input-group">
				  <label for="menuModifyFormMenuNum" class="input-group-text">메뉴 번호</label>
				  <input name="menu_num" type="text" class="form-control" id="menuModifyFormMenuNum" value="" readonly>
				</p>
		  		<p class="input-group">
				  <label for="menuModifyFormName" class="input-group-text">메뉴 이름</label>
				  <input name="name" type="text" class="form-control" id="menuModifyFormName" value="">
				</p>
				<p class="input-group">
				  <label for="menuModifyFormPrice" class="input-group-text">메뉴 가격</label>
				  <input name="price" type="number" class="form-control" id="menuModifyFormPrice" value="">
				</p>
				<p class="input-group">
				  <label for="menuModifyFormMenuDetail" class="input-group-text">메뉴 설명</label>
				  <input name="menu_detail" type="text" class="form-control" id="menuModifyFormDetail" value="">
				</p>
				<p class="input-group">
				  <label for="menuModifyFormMenuImg" class="input-group-text">메뉴 사진</label>
				  <input name="menu_img" type="text" class="form-control" id="menuModifyFormMenuImg" value="">
				</p>
				<p class="input-group">
				  <label for="menuModifyFormDetailImg" class="input-group-text">메뉴 상세 사진</label>
				  <input name="detail_img" type="text" class="form-control" id="menuModifyFormDetailImg" value="">
				</p>
				<p class="input-group">
				  <label for="menuModifyFormShopNum" class="input-group-text">메뉴 담당 가게 번호</label>
				  <input name="shop_num" type="text" class="form-control" id="menuModifyFormShopNum" value="">
				</p>
				<p class="d-grid gap-2 d-md-flex justify-content-md-end">
			  	<a class="btn btn-outline-danger clk" href="javascript:void(0)" onclick="deleteMenu(event)" data-num="">삭제</a>
		  		<button class="btn btn-outline-primary" type="submit">수정</button>
		  	</p>
	  	</form>
	  </div>
  </div>
</div>
</body>
</html>
const commentList=document.getElementById("commentList");
const commentClone=document.getElementById("commentClone");
const navListTab=document.getElementById("nav-list-tab");
const navModifyTab=document.getElementById("nav-modify-tab");
const navListTab2=new bootstrap.Tab(navListTab);
const navModifyTab2=new bootstrap.Tab(navModifyTab);
const commentModifyForm=document.forms["commentModifyForm"];
const updateModar=document.getElementById("updateModar");
const updateModar2=new bootstrap.Modal(updateModar);
const deleteModar=document.getElementById("deleteModar");
const deleteModar2=new bootstrap.Modal(deleteModar);
const listReloadBtn=document.getElementById("listReloadBtn");
const listReloadBtn2=document.getElementById("listReloadBtn2");

const COMMENT_AJAX_URL="./comment_ajax.do";

listReloadBtn2.addEventListener("click",(e)=>{
	deleteModar2.hide();
	navListTab2.show();
	commentListFetch();
	});
listReloadBtn.addEventListener("click",(e)=>{
	updateModar2.hide();
	navListTab2.show();
	commentListFetch();
});

commentModifyForm.addEventListener("submit",async (e)=>{
	e.preventDefault(0);
	//reset api put 방식으로 통신 (Get,Post,Put,Delete)=> 모든 http 통신에서 가능하다.
	const inputNodes=(commentModifyForm.querySelectorAll("[name]"));
	const putData=new Object();
	for(let input of inputNodes){
		putData[input.name]=input.value;
	}
	let res=await fetch(COMMENT_AJAX_URL,{
		method:"put",
		body: JSON.stringify(putData)
	});
	let json=await res.json();
	updateMsg.innerText=(json.update)?"수정 성공":"수정 실패";
	updateModar2.show();
	console.log(json);
});

async function deleteComment(e){
	const inputNodes=(commentModifyForm.querySelectorAll("[name]"));
	const deleteData=new Object();
	for(let input of inputNodes){
		deleteData[input.name]=input.value;
	}
	console.log(deleteData);
	let res=await fetch(COMMENT_AJAX_URL,{
		method: "delete",
		body:JSON.stringify(deleteData)
	});
	let json=await res.json();
	deleteMsg.innerText=(json.delete)?"삭제 성공":"삭제 실패";
	deleteModar2.show();
	
};

commentListFetch();


async function commentListFetch(){
	let res=await fetch(COMMENT_AJAX_URL);
	let json=await res.json();
	commentList.innerHTML="";
	json.forEach((comment)=>{
		const commentNode=commentClone.cloneNode(true);
		for(let key in comment){
			if(commentNode.querySelector(`.${key}`)){			
				commentNode.querySelector(`.${key}`).innerText=comment[key];
				if(key=="title"){
					commentNode.querySelector(`.${key}`).dataset.num=comment["comment_num"];
				}
			}
			commentNode.id="";
		}
		commentList.append(commentNode);			
	});
};
async function modifyLoad(e){
	let comment_num=e.target.dataset.num;
	navModifyTab2.show();
	let res=await fetch(COMMENT_AJAX_URL+"?comment_num="+comment_num);
	let json=await res.json();
	const input_list=(commentModifyForm.querySelectorAll("[name]"));
	input_list.forEach((input)=>{
		input.value=json[input.name];
	});
};
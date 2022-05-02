const menuList=document.getElementById("menuList");
const menuClone=document.getElementById("menuClone");
const navInsertTab=document.getElementById("nav-insert-tab");
const navListTab=document.getElementById("nav-list-tab");
const navModifyTab=document.getElementById("nav-modify-tab");
const menuForm=document.forms["menuForm"];
const menuModifyForm=document.forms["menuModifyForm"];
const navInsertTab2=new bootstrap.Tab(navInsertTab);
const navListTab2=new bootstrap.Tab(navListTab);
const navModifyTab2=new bootstrap.Tab(navModifyTab);

const insertModar=document.getElementById("insertModar");
const insertModar2=new bootstrap.Modal(insertModar);
const updateModar=document.getElementById("updateModar");
const updateModar2=new bootstrap.Modal(updateModar);
const deleteModar=document.getElementById("deleteModar");
const deleteModar2=new bootstrap.Modal(deleteModar);
const listReloadBtn=document.getElementById("listReloadBtn");
const listReloadBtn2=document.getElementById("listReloadBtn2");
const listReloadBtn3=document.getElementById("listReloadBtn3");
alert("a222");

listReloadBtn3.addEventListener("click",(e)=>{
	deleteModar2.hide();
	navListTab2.show();
	menuListFetch();
	});

listReloadBtn2.addEventListener("click",(e)=>{
	updateModar2.hide();
	navListTab2.show();
	menuListFetch();
	});
listReloadBtn.addEventListener("click",(e)=>{
	insertModar2.hide();
	navListTab2.show();
	menuListFetch();
});

const MENU_AJAX_URL="./menu_ajax.do";

menuForm.addEventListener("submit",async(e)=>{
	e.preventDefault(0);
	const inputNodes=(menuForm.querySelectorAll("[name]"));
	const postData=new Object();
	for(let input of inputNodes){
		postData[input.name]=input.value;
	}
	console.log(postData);
	let res=await fetch(MENU_AJAX_URL,{
		method: "post",
		body:JSON.stringify(postData)
	});
	let json=await res.json();
	insertMsg.innerText=(json.insert)?"등록 성공":"등록 실패";
	insertModar2.show();
});
menuModifyForm.addEventListener("submit",async (e)=>{
	e.preventDefault(0);
	//reset api put 방식으로 통신 (Get,Post,Put,Delete)=> 모든 http 통신에서 가능하다.
	const inputNodes=(menuModifyForm.querySelectorAll("[name]"));
	const putData=new Object();
	for(let input of inputNodes){
		putData[input.name]=input.value;
	}
	let res=await fetch(MENU_AJAX_URL,{
		method:"put",
		body: JSON.stringify(putData)
	});
	let json=await res.json();
	updateMsg.innerText=(json.update)?"수정 성공":"수정 실패";
	updateModar2.show();
	console.log(json);
});

menuListFetch();


async function menuListFetch(){
	let res=await fetch(MENU_AJAX_URL);
	let json=await res.json();
	menuList.innerHTML="";
	json.forEach((menu)=>{
		const menuNode=menuClone.cloneNode(true);	
		for(let key in menu){
			if(menuNode.querySelector(`.${key}`)){			
				menuNode.querySelector(`.${key}`).innerText=menu[key];
				if(key=="name"){
					menuNode.querySelector(`.${key}`).dataset.num=menu["menu_num"];
				}
			}
			menuNode.id="";		
		}
		menuList.append(menuNode);			
	});
};

async function modifyLoad(e){
	let menu_num=(e.target.dataset.num);
	navModifyTab2.show();
	console.log(menu_num);
	let res=await fetch(MENU_AJAX_URL+"?menu_num="+menu_num);
	let json=await res.json();
	const input_list=(menuModifyForm.querySelectorAll("[name]"));
	input_list.forEach((input)=>{
		input.value=json[input.name];
	});
};
async function deleteMenu(e){
let menu_num=(e.target.dataset.num);
	navModifyTab2.show();
	console.log(menu_num);
	let res=await fetch(MENU_AJAX_URL+"?menu_num="+menu_num);
	let json=await res.json();
	const input_list=(menuModifyForm.querySelectorAll("[name]"));
	input_list.forEach((input)=>{
		input.value=json[input.name];
	});
	deleteMsg.innerText=(json.delete)?"삭제 성공":"삭제 실패";
	deleteModar2.show();
}


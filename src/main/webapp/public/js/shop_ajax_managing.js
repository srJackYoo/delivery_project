const shopList = document.getElementById("shopList");
const shopClone = document.getElementById("shopClone");

const pillsListTab = document.getElementById("pills-list-tab");
const pillsInsertTab = document.getElementById("pills-insert-tab");
const pillsModifyTab = document.getElementById("pills-modify-tab");

const shopForm = document.forms["shopForm"];
const shopModifyForm = document.forms["shopModifyForm"];

const pillsListTab2 = new bootstrap.Tab(pillsListTab);
const pillsInsertTab2 = new bootstrap.Tab(pillsInsertTab);
const pillsModifyTab2 = new bootstrap.Tab(pillsModifyTab);

const insertModar = document.getElementById("insertModar");
const insertModar2 = new bootstrap.Modal(insertModar);
const updateModar = document.getElementById("updateModar");
const updateModar2 = new bootstrap.Modal(updateModar);

const listReloadBtn = document.getElementById("listReloadBtn");
const listReloadBtn2 = document.getElementById("listReloadBtn2");

listReloadBtn.addEventListener("click", (e)=>{
	updateModar.hide();
	pillsInsertTab.show();
	shopListFetch();
})
listReloadBtn2.addEventListener("click", (e)=>{
	updateModar2.hide();
	pillsInsertTab2.show();
	shopListFetch();
})

const AJAX_URL = "./ajax.do";

shopForm.addEventListener("submit", async(e)=>{
	e.preventDefault(0);
	const inputNodes = shopForm.querySelectorAll("[name]");
	const postData = new Object();
	for(let input of inputNodes){
		postData[input.name] = input.value;
	};
	let res = await fetch(AJAX_URL, {
		method:"post",
		body: JSON.stringify(postData)
	});
	let json = await res.json();
	insertMsg.innerText = (json.insert)?"등록 성공":"등록 실패";
	insertModar2.show();
});

shopModifyForm.addEventListener("submit", async(e)=>{
	e.preventDefault(0);
	const inputNodes = shopModifyForm.querySelectorAll("[name]");
	const putData = new Object();
	for(let input of inputNodes){
		putData[input.name] = input.value;
	}
	let res = await fetch(AJAX_URL, {
		method:"put",
		body: JSON.stringify(putData)
	});
	let json = await res.json();
	updateModar2.show();
	if(json.update){
		updateMsg.innerText = "수정 성공";
	}else{
		updateMsg.innerText = "수정 실패";
	}
});

shopListFetch();
async function shopListFetch(){
	let res = await fetch(AJAX_URL);
	let json = await res.json();
	shopList.innerHTML="";
	json.forEach((shop)=>{
		const shopNode = shopClone.cloneNode(true);
		for(let key in shop){
			if(shopNode.querySelector(`.${key}`)){
				shopNode.querySelector(`.${key}`).innerText = shop[key];
				if(key=="shop_name"){
					shopNode.querySelector(`.${key}`).dataset.num = shop["shop_num"];
				}
			}
			shopNode.id="";
		}
		shopList.append(shopNode);
	})
}

async function modifyLoad(e){
	let shop_num = e.target.dataset.num;
	pillsModifyTab2.show();
	let res = await fetch(AJAX_URL+"?shop_num="+shop_num);
	let json = await res.json();
	const input_list = shopModifyForm.querySelectorAll("[name]");
	input_list.forEach((input)=>{
		input.value = json[input.name];
	})
}
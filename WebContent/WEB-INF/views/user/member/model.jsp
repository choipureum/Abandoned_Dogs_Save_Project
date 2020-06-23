<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>

	<style>
		body { font-family: Arial, Helvetica, sans-serif;}
		button{
			all: unset;
			background-color: #990000;
			color: white;
			padding: 15px 25px;
			border-radius: 6px;
			cursor: pointer;
		}
		.modal{
			position: fixed;
			top: 0; left: 0;
			width: 100%; height: 100%;
			display: flex;
			justify-content: center;
			align-items : center;
		}
		.md_overlay {
			background-color: rgba(0, 0, 0, 0.6);
			width: 100%; height: 100%;
			position: absolute;
		}
		.md_content {
			width: 20%;
			position: relative;
			padding: 50px 100px;
			background-color: white;
			text-align: center;
			border-radius: 6px;
			box-shadow: 0 10px 20px rgba(0,0,0,0.20), 0 6px 6px rgba(0, 0, 0, 0.20);
		}
		h1 {
			margin:0; 
			padding: 5px;
		}
		.hidden {
			display: none;
		}
		.modal_text { padding: 16px; }
	</style>
</head>
<body>

	<button id="open">탈퇴하기</button>
	<div class="modal hidden">
		<div class="md_overlay"></div>
		<div class="md_content">
			<h1>탈퇴하기</h1>
			<div class="modal_text">
				자바스크립트로 모달창을 만들어 봤습니다. 
			</div>
			<button>탈퇴하기</button>
		</div>
	</div>
	

	<script type="text/javascript">
	
	<!--
		//필요한 엘리먼트들을 선택한다.
		const openButton = document.getElementById("open");
		const modal = document.querySelector(".modal");
		const overlay = modal.querySelector(".md_overlay");
		const closeButton = modal.querySelector("button");
		//동작함수
		const openModal = () => {
			modal.classList.remove("hidden");
		}
		const closeModal = () => {
			modal.classList.add("hidden");
		}
		//클릭 이벤트
		openButton.addEventListener("click", openModal);
		closeButton.addEventListener("click", closeModal);
	//-->
	</script>
</body>
</html>
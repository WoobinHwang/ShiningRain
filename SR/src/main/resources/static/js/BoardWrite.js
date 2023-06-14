var uploadFiles = [];

const imgInput = document.querySelector('.imgInput');
const imgList = document.querySelector('.imgList');
const target = document.querySelector('.target');
const imgButton = document.querySelector('.imgList li input');

imgInput.addEventListener('change', getImageFiles);

// 아래 두개의 함수는 같은 역할
// 1.
// upload.addEventListener('click', () => divUpload.click());

// 2.
// upload.addEventListener('click', function() {
// 	divUpload.click()
// })

function getImageFiles(e){
	const file = e.currentTarget.files[0];
	const imagePreview = document.querySelector('.preview');
	
	// console.log(typeof file, file);
	// console.log(typeof file.name);
	// console.log(file.name);
	// console.log(e);
	// console.log(uploadFiles);
	
	// 리스트 uploadFiles 에 파일을 추가
	for (i = 0; i < uploadFiles.length; i++){
		if(uploadFiles[i].name == file.name){
			alert("이미 올린 이미지입니다.");
			return;
		}
	}
	
	
    uploadFiles.push(file);
    const reader = new FileReader();
    reader.onload = (e) => {
    	imagePreview.setAttribute('src', e.target.result)
    	imagePreview.style.display = "";
    	
    	const liTag = createLiTag(file);
    	imgList.appendChild(liTag);
	};
	
    reader.readAsDataURL(file);
}

function createLiTag(file) {
	const li = document.createElement('li');
	const imgName = file.name;
	const textNode = document.createTextNode(imgName);
	const inputButton = document.createElement('input');
	
	li.appendChild(textNode);
	// span.appendChild(textNode);
	// button.appendChild(xNode);
	inputButton.setAttribute('type', 'button')
	inputButton.setAttribute('value', 'X')
	inputButton.setAttribute('onclick', 'removeImage("' +imgName+ '")');
	li.appendChild(inputButton);
	
	// console.log("////////////");
	// console.log(file);
	// console.log(file.name);
	
	return li;
}

/** name과 같은 요소를 리스트와 li태그에서 제거 */
function removeImage(name){
	
	// uploadFiles 리스트에서 name과 같은 요소 제거
	for (i = 0; i < uploadFiles.length; i++){
		if(uploadFiles[i].name == name){
			uploadFiles.splice(i, 1);
			alert(i + "번째 리스트 삭제 완료")
			// console.log(i + "번째 리스트 삭제 완료")
			// console.log(uploadFiles);
		}
		
	}
	
	// X 버튼 클릭한 element를 지우기
	$(".imgList li").each(function() {
		console.log($(this).text());
		console.log(this);
		
		if($(this).text() == name){
			console.log("발견");
			imgList.removeChild(this);
		}
	});
	
	console.log("남은 files ->")
	console.log(uploadFiles)
}

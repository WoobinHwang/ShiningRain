var uploadFiles = [];

const imgInput = document.querySelector('.imgInput');
const imgList = document.querySelector('.imgList');
const target = document.querySelector('.target');

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
	// const docFrag = new DocumentFragment();
	
	console.log(typeof file, file);
	console.log(typeof file.name);
	console.log(file.name);
	console.log(e);
	console.log(uploadFiles);
	
	// 리스트 uploadFiles 에 파일을 추가
    uploadFiles.push(file);
    const reader = new FileReader();
    reader.onload = (e) => {
    	imagePreview.setAttribute('src', e.target.result)
    	imagePreview.style.display = "";
    	
    	const liTag = createLiTag(e, file);
    	imgList.appendChild(liTag);
	};
	
	// imagePreview.setAttribute('src', e.target.result)
	// imagePreview.style.display = "";
	// const liTag = createLiTag(e);
	// imgList.appendChild(liTag);
	
    reader.readAsDataURL(file);
}

function  createLiTag(e, file) {
	const li = document.createElement('li');
	const imgName = file.name;
	// const textNode = document.createTextNode(file.name);
	const textNode = document.createTextNode(imgName);
	li.appendChild(textNode);
	
	console.log("////////////");
	console.log(file);
	console.log(file.name);
	
	return li;
}
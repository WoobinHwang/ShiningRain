var uploadFiles = [];

function getImageFiles(e){
	const file = e.currentTarget.files[0];
	const imagePreview = document.querySelector('.image-preview');
	// const docFrag = new DocumentFragment();
	
	console.log(typeof file, file);
	console.log(e);
	
	
	// 리스트 uploadFiles 에 파일을 추가
    uploadFiles.push(file);
    const reader = new FileReader();
    reader.onload = (e) => {
    	const preview = createElement(e, file);
    	imagePreview.appendChild(preview);
	};
    reader.readAsDataURL(file);
    
    
}

function createElement(e, file) {
      const li = document.createElement('li');
      const img = document.createElement('img');
      img.setAttribute('src', e.target.result);
      img.setAttribute('data-file', file.name);
      li.appendChild(img);

      return li;
    }

function test(){
	console.log("testing...");
}

const realUpload = document.querySelector('.real-upload');
const upload = document.querySelector('.upload');

upload.addEventListener('click', () => realUpload.click());
realUpload.addEventListener('change', getImageFiles);

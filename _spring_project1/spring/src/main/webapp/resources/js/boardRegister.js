document.getElementById('trigger').addEventListener('click',()=>{
    document.getElementById('file').click();
})

// 정규표현식을 사용하여 생성자 함수를 만들기
// 실행파일 막기, 이미지파일인지 아닌지 체크
// fileUpload시 형식제한 함수


const regExp = new RegExp("\.(exe|sh|bat|msi|dll|js)$") // 실행파일 막기
const regExpImg = new RegExp("\.(jpg|jpeg|png|gif|bmp)$") // 이미지파일 넣을 수 있는 애들
const maxSize = 1024*1024*20; // 20M 보다 큰지 확인

function fileSizeValidation(fileName, fileSize){ // 첨부 가능한 파일인지 체크
    if(regExp.test(fileName)){ //실행파일임
        return 0;
    }else if(fileSize > maxSize){
        return 0;
    // }else if(!regExpImg.test(fileName)){ // 이미지 파일인지 아닌지 확인할때  이미지가 아니면 첨부안할거임.
    //     return 0;
    }else{
        return 1;
    }
}

// 첨부 file에 따라서 체크 하여 등록 가능한지 체크
document.addEventListener('change', (e)=>{
    console.log(e.target);
    if(e.target.id == 'file'){ 
        // 첨부되지 말아야 하는 파일이 들어왔을 때 전송되는 것을 방지시키기 위해서
        // 버튼 자체를 죽인대; ;; ;;
        document.getElementById('regBtn').disabled = false;
        const fileObject = document.getElementById('file').files; // 여러개가 들어오면 배열로 들어온다.
        console.log(fileObject);

        let div = document.getElementById('fileZone');
        div.innerHTML ='';
        let ul = `<ul>`;
        let isOk = 1; // fileSizeValidation의 통과 여부를 체크 
        for(let file of fileObject){  // 배열로 들어올거야.
            let vaildResult = fileSizeValidation(file.name, file.size); // 파일의 결과를 vaildResult에 체크
            isOk *= vaildResult; // 모든 첨부파일의 결과가 1이면 통과고 0이면 0으로 바뀌겠찌.
            ul+= `<li>`; 
            // 업로드 가능 표시 // 통과가 됐다면 1=true, 0=false
            // 업로드 가능이면 파란색 업로드 불가능이면 빨간색으로 주고싶을때는 div를 별도로 넣어야한다.
            ul+= `<div> ${vaildResult ? '업로드 가능 >' : '업로드 불가능 >'} ${file.name} <span class="badge rounded-pill text-bg-${vaildResult ? 'primary' : 'danger'}">${file.size}bytes</span></div></li>`;
            // ul+= `${file.name}`;
            // // 클래스 안에서 색을 넣을때......?
            // // ul+= `<span class="badge rounded-pill text-bg-${vaildResult ? 'success' : 'danger'}">${file.size}Bytes </span></li>`;
            // ul+= `<span class="badge rounded-pill text-bg-${vaildResult ? 'primary' : 'danger'}">${file.size}bytes</span></li>`;
        }
        ul+= `</ul>`;
        div.innerHTML =ul;
        if(isOk==0){ //첨부불가 파일이 있다라는 의미 
            document.getElementById('regBtn').disabled = false;
        }
    }
})

{/* <ul>
    <li>
        // 첨부파일이 여러개인 경우 : for문으로 li를 여러개 생성
        <div>업로드 가능 </div> // 가능하다면 
        <div>업로드 불가능</div> // 불가능하다면 = fileSizeValidation에서 통과 못했다는 뜻
        // 파일이름
        <span>파일 사이즈</span>
    </li>
</ul> */}
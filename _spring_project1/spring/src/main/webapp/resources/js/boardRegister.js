document.getElementById('trigger').addEventListener('click',()=>{
    document.getElementById('file').click();
})

// 정규표현식을 사용하여 생성자 함수를 만들기
// 실행파일 막기, 이미지파일인지 아닌지 체크
// fileUpload시 형식제한 함수


const regExp = new RegExp("\.(exe|sh|bat|msi|dll|js)$") // 실행파일 막기
const regExpImg = new RegExp("\.(jpg|jpeg|png|gif|bmp)$") // 이미지파일 넣을 수 있는 애들
const maxSize = 1024*1024*20; // 20M 보다 큰지 확인

function fileSizeValidation(fileName, fileSize){
    if(regExp.test(fileName)){ //실행파일임
        return 0;
    }else if(fileSize > maxSize){
        return 0;
    }else {
        return 1;
    }
}

// image file에 따라서 체크
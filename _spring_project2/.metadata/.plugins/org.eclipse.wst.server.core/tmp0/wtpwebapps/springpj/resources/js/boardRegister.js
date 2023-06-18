document.getElementById('trigger').addEventListener('click',()=>{
    document.getElementById('file').click();
})

const regExp = new RegExp("\.(exe|sh|bat|msi|dll|js)$")
const regExpImg = new RegExp("\.(jpg|jpeg|png|gif|bmp)$") 
const maxSize = 1024*1024*20;

function fileSizeValidation(fileName, fileSize){ 
    if(regExp.test(fileName)){
        return 0;
    }else if(fileSize > maxSize){
        return 0;
    }else{
        return 1;
    }
}

// 첨부 file에 따라서 체크 하여 등록 가능한지 체크
document.addEventListener('change', (e)=>{
    console.log(e.target);
    if(e.target.id == 'file'){ 
        document.getElementById('regBtn').disabled = false;
        const fileObject = document.getElementById('file').files; 
        console.log(fileObject);

        let div = document.getElementById('fileZone');
        div.innerHTML ='';
        let ul = `<ul>`;
        let isOk = 1;
        for(let file of fileObject){
            let vaildResult = fileSizeValidation(file.name, file.size);
            isOk *= vaildResult;
            ul+= `<li>`; 
            ul+= `<div> ${vaildResult ? '업로드 가능 >' : '업로드 불가능 >'} ${file.name} <span class="badge rounded-pill text-bg-${vaildResult ? 'primary' : 'danger'}">${file.size}bytes</span></div></li>`;
        }
        ul+= `</ul>`;
        div.innerHTML =ul;
        if(isOk==0){ 
            document.getElementById('regBtn').disabled = false;
        }
    }
})

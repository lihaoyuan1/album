/**
 * Created by pc on 2018/9/6.
 */
function upload(){
    var root = document.getElementById("upload");
    var root1 = document.getElementById("section");
    document.getElementById("top").style.pointerEvents = 'none';
    root1.style.pointerEvents = 'none';
    root1.style.filter = "blur(2px)";
    root.style.display = 'block';
    var i = -30;
    var id = setInterval(f, 1);
    function f(){
        if (i == 35)
            clearInterval(id);
        else{
            i = i + 1;
            root.style.left = i + '%';
        }
    }
}
function closeUpload(){
    var root = document.getElementById("upload");
    var root1 = document.getElementById("section");
    document.getElementById("top").style.pointerEvents = 'auto';
    root1.style.pointerEvents = 'auto';
    var i = 35;
    var id = setInterval(f, 1);
    function f(){
        if (i == 100) {
            clearInterval(id);
        }
        else{
            i = i + 1;
            root.style.left = i + '%';
        }
    }
    setTimeout(function (){
        root.style.display = 'none';
        root1.style.filter = 'none';
        root.style.left = '-30%';
        document.getElementById("err").style.display = 'none';
    }, 800)
}
function Check(){
    var root1 = document.getElementById("picture");
    var root2 = document.getElementById("category");
    var root3 = document.getElementById("err");
    if (root1.value == "" || root2.value == "选择图片分类"){
        root3.style.display = 'block';
        return false;
    }
    else
        return true;
}
function newAlbum(){
    var root = document.getElementById("newAlbum");
    var root1 = document.getElementById("section");
    document.getElementById("top").style.pointerEvents = 'none';
    root1.style.pointerEvents = 'none';
    root1.style.filter = "blur(2px)";
    root.style.display = 'block';
    var i = -20;
    var id = setInterval(f, 1);
    function f(){
        if (i == 40) {
            clearInterval(id);
        }
        else{
            i = i + 1;
            root.style.top = i + '%';
        }
    }
}
function closeNewAlbum(){
    var root = document.getElementById("newAlbum");
    var root1 = document.getElementById("section");
    document.getElementById("top").style.pointerEvents = 'auto';
    root1.style.pointerEvents = 'auto';
    var i = 40;
    var id = setInterval(f, 1);
    function f(){
        if (i == -20) {
            clearInterval(id);
        }
        else{
            i = i - 1;
            root.style.top = i + '%';
        }
    }
    setTimeout(function (){
        root.style.display = 'none';
        root1.style.filter = 'none';
        document.getElementById("err1").style.display = 'none';
    }, 850)
}
function Check1(){
    var root = document.getElementById("album");
    var root1 = document.getElementById("err1");
    if (root.value == ""){
        root1.style.display = 'block';
        return false;
    }
    else
        return true;
}
function delete1(albumName){
    var root = document.getElementById("delete");
    var root1 = document.getElementById("section");
    document.getElementById("album_name1").value = albumName;
    document.getElementById("top").style.pointerEvents = 'none';
    root1.style.pointerEvents = 'none';
    root1.style.filter = "blur(2px)";
    root.style.display = 'block';
    var i = -20;
    var id = setInterval(f, 1);
    function f(){
        if (i == 40) {
            clearInterval(id);
        }
        else{
            i = i + 1;
            root.style.top = i + '%';
        }
    }
}
function closeDelete(){
    var root = document.getElementById("delete");
    var root1 = document.getElementById("section");
    document.getElementById("top").style.pointerEvents = 'auto';
    root1.style.pointerEvents = 'auto';
    var i = 40;
    var id = setInterval(f, 1);
    function f(){
        if (i == -20) {
            clearInterval(id);
        }
        else{
            i = i - 1;
            root.style.top = i + '%';
        }
    }
    setTimeout(function (){
        root.style.display = 'none';
        root1.style.filter = 'none';
    }, 850)
}
function reset(albumName){
    var root = document.getElementById("reset");
    var root1 = document.getElementById("section");
    document.getElementById("album_name2").value = albumName;
    document.getElementById("top").style.pointerEvents = 'none';
    root1.style.pointerEvents = 'none';
    root1.style.filter = "blur(2px)";
    root.style.display = 'block';
    var i = -20;
    var id = setInterval(f, 1);
    function f(){
        if (i == 40) {
            clearInterval(id);
        }
        else{
            i = i + 1;
            root.style.top = i + '%';
        }
    }
}
function closeReset(){
    var root = document.getElementById("reset");
    var root1 = document.getElementById("section");
    document.getElementById("top").style.pointerEvents = 'auto';
    root1.style.pointerEvents = 'auto';
    var i = 40;
    var id = setInterval(f, 1);
    function f(){
        if (i == -20) {
            clearInterval(id);
        }
        else{
            i = i - 1;
            root.style.top = i + '%';
        }
    }
    setTimeout(function (){
        root.style.display = 'none';
        root1.style.filter = 'none';
        document.getElementById("err2").style.display = 'none';
    }, 850)
}
function Check2(){
    var root = document.getElementById("album_name3");
    var root1 = document.getElementById("err2");
    if (root.value == ""){
        root1.style.display = 'block';
        return false;
    }
    else
        return true;
}
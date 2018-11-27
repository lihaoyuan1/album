/**
 * Created by pc on 2018/9/7.
 */
function Next(num){
    var root = document.getElementById("flag");
    var count = parseInt(root.value);
    if (count < num) {
        var root1 = document.getElementById(count.toString());
        var root2 = document.getElementById((count + 1).toString());
        var root3 = document.getElementById("bottom-img" + count.toString());
        var root4 = document.getElementById("bottom-img" + (count + 1).toString());
        if ((count + 1)%6 == 0) {
            var count1 = parseInt(count/6);
            var root6 = document.getElementById("bottom" + count1.toString());
            var root7 = document.getElementById("bottom" + (count1 + 1).toString());
            root6.style.display = 'none';
            root7.style.display = 'block';
        }
        var a = 20;
        var id = setInterval(f, 1)
        function f() {
            if (a == -60) {
                clearInterval(id);
                root.value = count + 1;
                root3.classList.remove("bottom-img-border");
                root4.classList.add("bottom-img-border");
            }
            else {
                a = a - 1;
                root1.style.left = a + '%';
                root2.style.left = a + 80 + '%';
            }
        }
    }
    else
        showMsg('没有下一张');
}
function Before(){
    var root = document.getElementById("flag");
    var count = parseInt(root.value);
    if (count > 0) {
        var root1 = document.getElementById(count.toString());
        var root2 = document.getElementById((count - 1).toString());
        var root3 = document.getElementById("bottom-img" + count.toString());
        var root4 = document.getElementById("bottom-img" + (count - 1).toString());
        if (count%6 == 0) {
            var count1 = parseInt(count/6);
            var root6 = document.getElementById("bottom" + count1.toString());
            var root7 = document.getElementById("bottom" + (count1 - 1).toString());
            root6.style.display = 'none';
            root7.style.display = 'block';
        }
        var a = 20;
        var id = setInterval(f, 1)
        function f() {
            if (a == 100) {
                clearInterval(id);
                root.value = count - 1;
                root3.classList.remove("bottom-img-border");
                root4.classList.add("bottom-img-border");
            }
            else {
                a = a + 1;
                root1.style.left = a + '%';
                root2.style.left = a - 80 + '%';
            }
        }
    }
    else
        showMsg('没有上一张');
}
function showMsg(msg){
    var root = document.getElementById("msg");
    root.innerHTML = msg;
    var a = -40;
    var id = setInterval(f, 1);
    function f(){
        if (a == 80){
            clearInterval(id);
            f1();
        }
        else{
            a = a + 1;
            root.style.top = a + 'px';
        }
    }
    function f1(){
        var b = 1;
        var id1 = setInterval(f2, 100);
        function f2(){
            if (b < 0){
                clearInterval(id1);
                root.style.top = -40 + 'px';
                root.style.opacity = 1;
            }
            else {
                b = b - 0.1;
                root.style.opacity = b;
            }
        }
    }
}
function toImg(num, size){
    for(var i=0; i<size; i++){
        var root = document.getElementById(i.toString());
        var root1 = document.getElementById("bottom-img" + i.toString());
        document.getElementById("flag").value = num;
        if (i < num){
            root.style.left = -60 + '%';
            if (root1.classList.contains("bottom-img-border") == true)
                root1.classList.remove("bottom-img-border");
        }
        if (i == num){
            root.style.left = 20 + '%';
            if (root1.classList.contains("bottom-img-border") == false)
                root1.classList.add("bottom-img-border");
        }
        else{
            root.style.left = 100 + '%';
            if (root1.classList.contains("bottom-img-border") == true)
                root1.classList.remove("bottom-img-border");
        }
    }
}
function init(id, size){
    document.getElementById("flag").value = id;
    toImg(id, size);
    var count = parseInt(size/6);
    if (size%6 != 0)
        count = count + 1;
    for(var i=0; i<count; i++){
        var root = document.getElementById("bottom" + i.toString());
        if (i == 0)
            root.style.display = 'block';
        else
            root.style.display = 'none';
    }
}
function delete1(){
    var root = document.getElementById("delete");
    var root1 = document.getElementById("section");
    var src = document.getElementsByTagName("img")[document.getElementById("flag").value].src;
    document.getElementById("photo_name2").value = src.split("/")[5].split(".")[0];
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
function move1(){
    var root = document.getElementById("move");
    var root1 = document.getElementById("section");
    var src = document.getElementsByTagName("img")[document.getElementById("flag").value].src;
    document.getElementById("photo_name1").value = src.split("/")[5].split(".")[0];
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
function closeMove(){
    var root = document.getElementById("move");
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
function Check(){
    var root1 = document.getElementById("category");
    if (root1.value == "移动到") {
        document.getElementById("err").style.display = 'block';
        return false;
    }
    else
        return true;
}
/**
 * Created by pc on 2018/9/4.
 */
function OnLoad(){
    var root1 = document.getElementById('username');
    var root2 = document.getElementById('password');
    var root3 = document.getElementById('remember');
    var msg = getCookie();
    if (msg != ""){
        root1.value = msg.split(';')[0];
        root2.value = msg.split(';')[1];
        root3.checked = true;
    }
    var root4 = document.getElementById("fail");
    if(root4.innerHTML != "null") {
        root4.style.display = 'block';
        var a = -50;
        var id = setInterval(f, 1);
        function f() {
            if (a == 150)
                clearInterval(id);
            else {
                a = a + 2;
                root4.style.top = a + "px";
            }
        }
    }
}
function getCookie(){
    var cookies = document.cookie.split(';');
    for (var i=0; i<cookies.length; i++){
        if (cookies[i].indexOf("user=") == 0){
            var cookie = cookies[i].split(',');
            var name = cookie[0].split('=')[1];
            var password = cookie[1];
            var date = parseInt(cookie[2]);
            if (date > Date.parse(new Date())){
                return name + ';' + password;
            }
            break;
        }
    }
    return "";
}
function setCookie(name, password){
    var date = Date.parse(new Date()) + 60*60*24*30;
    document.cookie = "user=" + name + ',' + password + ',' + date;
}
function deleteCookie(){
    var cookies = document.cookie.split(';');
    for (var i=0; i<cookies.length; i++){
        if (cookies[i].indexOf("user=") == 0){
            var cookie = cookies[i].split(',');
            var date = Date.parse(new Date());
            document.cookie = cookie[0] + ',' + cookie[1] + ',' + date;
            break;
        }
    }
}
function Check(){
    var root1 = document.getElementById("username");
    var root2 = document.getElementById("password");
    var root3 = document.getElementById("remember");
    var root4 = document.getElementById("err");
    if (root1.value == "" || root2.value == ""){
        root4.innerHTML = "用户名或密码为空";
        root4.style.display = 'block';
        return false;
    }
    else{
        if (root3.checked == true)
            setCookie(root1.value, root2.value)
        else
            deleteCookie();
        return true;
    }
}
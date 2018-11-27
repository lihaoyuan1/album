/**
 * Created by pc on 2018/9/5.
 */
function Check(){
    var root1 = document.getElementById("username");
    var root2 = document.getElementById("password");
    var root3 = document.getElementById("password1");
    var root4 = document.getElementById("err");
    if (root1.value == "" || root2.value == "" || root3.value == ""){
        root4.innerHTML = "用户名或密码为空";
        root4.style.display = 'block';
        return false;
    }
    else if (root2.value != root3.value){
        root4.innerHTML = "两次输入密码不一致";
        root4.style.display = 'block';
        return false;
    }
    else
        return true;
}
//---------Проверка комбинаций символов при вводе пароля------------

window.onload = function () {
    document.getElementById("password").onchange = validatePassword;
    document.getElementById("passwordRep").onchange = validatePassword;
}
function validatePassword(){
  var pass2 = document.getElementById("password").value;
  var pass1 = document.getElementById("passwordRep").value;
  console.log(pass1 + " " + pass2);
  if(pass1 != pass2)
      document.getElementById("passwordRep").setCustomValidity("Пароли не совпадают");
  else
      document.getElementById("passwordRep").setCustomValidity("");
}

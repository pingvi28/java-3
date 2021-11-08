//---------Проверка комбинаций символов при вводе пароля------------
document.addEventListener('DOMContentLoaded', function () {
    window.onload = function () {
        document.getElementById("password").onchange = validatePassword;
        document.getElementById("passwordRep").onchange = validatePassword;
    }
    function validatePassword(){
        let pass2 = document.getElementById("password").value;
        let pass1 = document.getElementById("passwordRep").value;

        if(pass1 !== pass2)
            document.getElementById("passwordRep").setCustomValidity("Пароли не совпадают");
        else
            document.getElementById("passwordRep").setCustomValidity("");
    }

});


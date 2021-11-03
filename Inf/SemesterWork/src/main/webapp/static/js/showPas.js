$('body').on('click', '.password-control', function(){
    if ($('#password').attr('type') === 'password'){
        $(this).addClass('view');
        $('#password').attr('type', 'text');
    } else {
        $(this).removeClass('view');
        $('#password').attr('type', 'password');
    }
    return false;
});

$('body').on('click', '.password-control2', function(){
    if ($('#passwordRep').attr('type') === 'password'){
        $(this).addClass('view');
        $('#passwordRep').attr('type', 'text');
    } else {
        $(this).removeClass('view');
        $('#passwordRep').attr('type', 'password');
    }
    return false;
});
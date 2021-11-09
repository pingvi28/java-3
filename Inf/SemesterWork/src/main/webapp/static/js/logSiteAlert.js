document.addEventListener('DOMContentLoaded', function () {
    let url = new URL(window.location.href);

    if (url.searchParams.get("return") === "-10") alert("\nупс, пользователь с такой почтой уже существует");
    if (url.searchParams.get("return") === "-11") alert("\nнекорректно введена почта или пароль");
    if (url.searchParams.get("return") === "-12") alert("\nой,пароли не совпадают");

    if (url.searchParams.get("return") === "-20") alert("\nтебя нет в базе данный\n\n Вперед регистрироваться!");

    if (url.searchParams.get("confirm") === "true") alert("\n\nТы зарегистировался и твоя почта подтверждена UwU\n\n Теперь можешь войти");

    if (url.searchParams.get("sendEmail") === "true") alert("\n\nЯ отправил письмо повторно UwU\n\n Проверь");

    if (url.searchParams.get("update") === "success") alert("\n данные обновлены");
    if (url.searchParams.get("update") === "-10") alert("\nтвой текущий пароль не такой...Перепроверь, пожалуйста");
    if (url.searchParams.get("update") === "-11") alert("\nне смогли обновить данные");
    if (url.searchParams.get("update") === "-12") alert("\nне смогли обновить твой пароль. Попробуй позже");

    if (url.searchParams.get("vkAuth") === "0") alert("\nизвини, мы не смогли связаться с сервисом вк");
    if (url.searchParams.get("vkAuth") === "-1") alert("\nнекорректно пришел запрос с вк");
    if (url.searchParams.get("vkAuth") === "-2") alert("\nой,мы не смогли создать пользователя");

    if (url.searchParams.get("delete") === "success") alert("\n профиль удален");
    if (url.searchParams.get("delete") === "-10") alert("\nтвой текущий пароль не такой...Перепроверь, пожалуйста.\nИ ты уверен, что хочешь уйти?");
    if (url.searchParams.get("delete") === "-11") alert("\nмы не смогли удалить твои данные...");
});


//window.history.replaceState({}, document.title, "/");
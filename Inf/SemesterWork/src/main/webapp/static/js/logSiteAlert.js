let url = new URL(window.location.href);

if (url.searchParams.get("return") === "-10") alert("\nemail already registered");
if (url.searchParams.get("return") === "-11") alert("\nuncorrected email or user don't exit");
if (url.searchParams.get("return") === "-12") alert("\npasswords don't equals");

if (url.searchParams.get("return") === "-20") alert("\nyou aren't in the database\n\n Register!");

if (url.searchParams.get("confirm") === "true") alert("\n\nТы зарегистировался и твоя почта подтверждена UwU\n\n Теперь можешь войти");

if (url.searchParams.get("sendEmail") === "true") alert("\n\nЯ отправил письмо повторно UwU\n\n Проверь");

//window.history.replaceState({}, document.title, "/");
let url = new URL(window.location.href);
console.log(url);
if (url.searchParams.get("return") === "-10") alert("email already registered"); 
if (url.searchParams.get("return") === "-11") alert("uncorrected email or user don't exit");
if (url.searchParams.get("return") === "-12") alert("passwords don't equals");

//window.history.replaceState({}, document.title, "/");
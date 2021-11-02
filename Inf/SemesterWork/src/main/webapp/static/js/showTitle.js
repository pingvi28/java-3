function theFocus(obj) {
    var tooltip = document.getElementById("email");
    tooltip.innerHTML = obj.title;
    tooltip.style.display = "block";
    tooltip.style.top = obj.offsetTop - tooltip.offsetHeight + "px";
    tooltip.style.left = obj.offsetLeft + "px";
}

function theBlur(obj) {
    var tooltip = document.getElementById("email");
    tooltip.style.display = "none";
    tooltip.style.top = "-9999px";
    tooltip.style.left = "-9999px";
}

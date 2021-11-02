window.onload=function() {
    document.getElementById('registration').onsubmit=function() {
        document.getElementById('registration').addEventListener(
            "submit",
            function(e){
                e.preventDefault();
                console.log("not submitting form");
                alert("\nподожди, данные проверяются");
            }
        );
    }
}

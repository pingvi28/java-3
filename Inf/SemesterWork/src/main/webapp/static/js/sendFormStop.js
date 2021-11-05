window.onload=function() {
    document.getElementById('stopSend').onsubmit=function() {
        document.getElementById('stopSend').addEventListener(
            "submit",
            function(e){
                e.preventDefault();
                console.log("not submitting form");
                alert("\nподожди, данные проверяются");
            }
        );
    }
}

